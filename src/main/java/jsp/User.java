package jsp;

import org.apache.commons.codec.digest.DigestUtils;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Enumeration;
import java.security.SecureRandom;

public class User {

    private static final String URL_BD = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME_BD = "root";
    private static final String PASSWORD_BD = "root";

    private static boolean check(String log, String pas) {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT * FROM users");
            while (res.next()) {
                if (res.getString(2).equals(log) && res.getString(3).equals(hash(pas, res.getString(4)))) {
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void add(String log, String pas) {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO users(name, password, salt) VALUES(?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1,log);
            String salt = createSalt(); // Creating salt for password.
            preparedStatement.setString(2, hash(pas, salt));
            preparedStatement.setString(3, salt);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String register(HttpServletRequest req) {
        Enumeration<String> s = req.getParameterNames();

        if (s.hasMoreElements()) {
            if (User.check(req.getParameter("name"), req.getParameter("pass"))) {return  "Такой пользователь уже существуюет";}
            else {
                User.add(req.getParameter("name"), req.getParameter("pass"));
                return  "Пользователь успешно зарегистрован.";
            }
        } else return "";
    }

    public static boolean login(HttpServletRequest req) {
        Enumeration<String> s = req.getParameterNames();
        return s.hasMoreElements() && User.check(req.getParameter("name"), req.getParameter("pass"));
    }

    public static String createSalt() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder salt = new StringBuilder();
        byte [] randHex = new byte [8];

        secureRandom.nextBytes(randHex);
        for(byte i : randHex) {
            salt.append(Integer.toHexString(i & 0xff));
        }
        return salt.toString();
    }

    public static String hash(String pass, String salt) {
        return DigestUtils.sha256Hex(pass + salt);
    }
}
