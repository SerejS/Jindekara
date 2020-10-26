package jsp;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Enumeration;

public class User {
    private static final String URL_BD = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME_BD = "root";
    private static final String PASSWORD_BD = "root";

    private static boolean check(String log, String pas) {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT * FROM users");
            while (res.next()) {
                if (res.getString(2).equals(log) && res.getString(3).equals(pas)) {
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
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO users(name, pass) VALUES(?, ?)";
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,log);
            preparedStatement.setString(2, pas);
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
}
