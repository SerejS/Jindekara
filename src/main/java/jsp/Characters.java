package jsp;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Enumeration;

public class Characters {
    private static final String URL_BD = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME_BD = "root";
    private static final String PASSWORD_BD = "root";


    public static String out () {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String output = "";
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             Statement statement = connection.createStatement()) {
            try (ResultSet res = statement.executeQuery("SELECT * FROM characters order by name asc")) {
                while (res.next()) {
                    output += "<tr>" +
                            "<td><a href='add_character.jsp'>" + res.getString(2) + "</a></td>" +
                            "<td>" + res.getString(3) + "</td>" +
                            "<td>" + res.getString(4) + "</td>" +
                            "<td>" + res.getString(5) + "</td>" +
                            "</tr>";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;

    }

    public static String add(HttpServletRequest req) {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO characters(name, birth, death, lvl) VALUES(?, ?, ?, ?)";
        Enumeration<String> names = req.getParameterNames();
        if (names.hasMoreElements()){
            try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                for (int i = 1; names.hasMoreElements(); i++) {
                    preparedStatement.setString(i, req.getParameter(names.nextElement()));
                }
                preparedStatement.executeUpdate();
                return "Персонаж добавлен";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Персонаж не добавлен!";
            }
        } else return "";
    }

    public static String del(HttpServletRequest req) {
        if (req.getParameterNames().hasMoreElements()) {
            String name = req.getParameter(req.getParameterNames().nextElement());
            System.out.println(name);
            try {
                Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String query = "DELETE FROM characters WHERE name=?";
            try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();
                return "Персонаж " + name + " удален.";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Персонаж " + name + " не удален.";
            }
        } else return "";
    }
}
