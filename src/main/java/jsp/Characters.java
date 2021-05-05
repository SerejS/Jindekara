package jsp;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.net.URL;
import java.sql.*;
import java.util.Enumeration;

public class Characters {
    private static final String URL_BD = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME_BD = "root";
    private static final String PASSWORD_BD = "root";


    public static String outTable() {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String output = "";
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             Statement statement = connection.createStatement()) {
            try (ResultSet res = statement.executeQuery("SELECT * FROM characters order by lvl desc, birth")) {
                while (res.next()) {
                    output += "<tr><form>" +
                            "<td><button type='submit' class='butTable' name='select' value=" + res.getString("id") +
                            ">" + res.getString("name") + "</button></td>" +

                            "<td>" + res.getString("birth") + "</td>" +
                            "<td>" + res.getString("death") + "</td>" +
                            "<td>" + res.getString("lvl") + "</td>" +
                            "</form></tr>";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;

    }

    public static String getSex(String id) {
        switch (getData(id, "sex")) {
            case "m": return "Мужчина";
            case "w": return "Женщина";
            default: return "Нейтральный";
        }
    }
    public static String getData(String id, String attribute) {
        String value = "";
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             Statement statement = connection.createStatement()) {
            String query;
            if (attribute.equals("diary")) {
                query = "select " + attribute + " from character_diaries where id=" + id;
            } else {
                query = "select " + attribute + " from characters where id=" + id;
            }
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            value = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String add(HttpServletRequest req) {
        if (req.getParameter("name") == null) return "";
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO characters(name, birth, death, race, sex, lvl, class, fraction, citizenship, bio) VALUES(?,?,?,?,?,?,?,?,?,?)";
        if (req.getParameterNames().hasMoreElements()){
            try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, req.getParameter("name"));
                preparedStatement.setString(2, req.getParameter("yearB"));
                preparedStatement.setString(3, req.getParameter("yearD"));
                preparedStatement.setString(4, req.getParameter("race"));
                preparedStatement.setString(5, req.getParameter("sex"));
                preparedStatement.setString(6, req.getParameter("lvl"));
                preparedStatement.setString(7, req.getParameter("class"));
                preparedStatement.setString(8, req.getParameter("fraction"));
                preparedStatement.setString(9, req.getParameter("citizenship"));
                preparedStatement.setString(10,req.getParameter("bio"));
                preparedStatement.executeUpdate();

                if (req.getParameter("diary") != null) {
                    Statement st = connection.createStatement();
                    query = "select id from characters where name='" + req.getParameter("name")+"'";
                    System.out.println(query);
                    ResultSet rs = st.executeQuery(query);
                    rs.next();
                    PreparedStatement preparedStatement2 = connection.prepareStatement("insert into character_diaries(id, diary) values(?, ?)");
                    preparedStatement2.setString(1, rs.getString(1));
                    preparedStatement2.setString(2, req.getParameter("diary"));
                    preparedStatement2.executeUpdate();
                }

                return "Персонаж добавлен";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Персонаж не добавлен!";
            }
        } else return "";
    }
    public static String del(HttpServletRequest req) {
        if (req.getParameterNames().hasMoreElements()) {
            String id = req.getParameter("select").substring(3);
            try {
                Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String query = "DELETE FROM characters WHERE id=" + id;

            try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
                 Statement statement1 = connection.createStatement(); Statement statement2 = connection.createStatement()) {
                statement1.executeUpdate(query);
                query = "DELETE FROM character_diaries WHERE id="+id;
                statement2.executeUpdate(query);
                return "Персонаж удален.";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Персонаж не удален.";
            }
        } else return "";
    }
    public static String edit(HttpServletRequest req) {
        String query = "UPDATE characters set name=?,birth=?,death=?,race=?,sex=?,lvl=?,class=?,fraction=?,citizenship=?,bio=? where id="+req.getParameter("select").substring(5);
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Statement statement = connection.createStatement()) {

            preparedStatement.setString(1, req.getParameter("name"));
            preparedStatement.setString(2, req.getParameter("yearB"));
            preparedStatement.setString(3, req.getParameter("yearD"));
            preparedStatement.setString(4, req.getParameter("race"));
            preparedStatement.setString(5, req.getParameter("sex"));
            preparedStatement.setString(6, req.getParameter("lvl"));
            preparedStatement.setString(7, req.getParameter("class"));
            preparedStatement.setString(8, req.getParameter("fraction"));
            preparedStatement.setString(9, req.getParameter("citizenship"));
            preparedStatement.setString(10,req.getParameter("bio"));
            preparedStatement.executeUpdate();

            if (req.getParameter("diary") != null) {
                query = "UPDATE character_diaries set diary='" + req.getParameter("diary")+"' where id=" + req.getParameter("select").substring(5);
                statement.executeUpdate(query);
            }
            return "Персонаж успешно изменен";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Персонаж не изменен";
        }
    }
}
