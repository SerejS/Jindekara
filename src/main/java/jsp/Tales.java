package jsp;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;


public class Tales {
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
        String out = "";
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
        Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("select * from events order by year, day")) {
                while (resultSet.next()) {
                    out += "<tr><form>" +
                            "<td>" + resultSet.getString(2) + "</td>" +
                            "<td>" + toDate(resultSet.getShort(3)) + "</td>" +

                            "<td><button type='submit' name='event' value='" + resultSet.getInt(1) +
                            "'>" + resultSet.getString(4) + "</button></td>" +

                            "</form></tr>";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }


    public static String getEventDB(String id) {
        String out = "";
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             Statement statement = connection.createStatement()) {
            String query = "select * from describtion_event where id=" + id;
            try (ResultSet resultSet = statement.executeQuery(query)) {
                while(resultSet.next()) out += resultSet.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }
    public static String outEvent(String id, String sel) {
        String out = "";
        if (sel==null) {
            out = getEventDB(id);
            if (!out.isEmpty()) {
                try  {
                    File file = new File("C:\\Users\\Зальцбуржский Некто\\Documents\\GitHub\\Jindekara\\src\\main\\webapp\\WEB-INF\\subPages\\buttonBar.html");
                    FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
                    char [] c = new char[2000];
                    fr.read(c);
                    out += String.valueOf(c).replace("eventID", String.valueOf(id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (sel.equals("add")) {
            try  {
                File file = new File("C:\\Users\\Зальцбуржский Некто\\Documents\\GitHub\\Jindekara\\src\\main\\webapp\\WEB-INF\\subPages\\addEvent.html");
                FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
                char c[] = new char[2000];
                fr.read(c);
                out = String.valueOf(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try  {
                File file = new File("C:\\Users\\Зальцбуржский Некто\\Documents\\GitHub\\Jindekara\\src\\main\\webapp\\WEB-INF\\subPages\\editEvent.html");
                FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
                char c[] = new char[2000];
                fr.read(c);
                out = String.valueOf(c);
                try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
                     Statement statement = connection.createStatement()) {
                    String query = "select name_event, year, day, describtion from events left outer join describtion_event on events.id=describtion_event.id where events.id=" +id;
                    try (ResultSet resultSet = statement.executeQuery(query)) {
                        while (resultSet.next()) {
                            out = out.replace("eventID", id);
                            out = out.replace("valName", resultSet.getString(1));
                            out = out.replace("valYear", resultSet.getString(2));
                            out = out.replace("valDate", resultSet.getString(3));
                            out = out.replace("valDesc", resultSet.getString(4));
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }



            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return out;
    }

    public static String del(int id) {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             Statement statement = connection.createStatement()) {
            String query = "delete from describtion_event where id =" + id;
            statement.executeUpdate(query);
            query =  "delete from events where id =" + id;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Событие удалено";
    }
    public static String add(String name, int year, int day, String desc) {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             Statement statement = connection.createStatement()) {
            String query = "insert into events(year, day, name_event) values(" + year + "," + day + ",'" + name + "');";
            statement.executeUpdate(query);
            ResultSet rs = statement.executeQuery("select max(id) from events");
            rs.next();
            int id = rs.getInt(1);
            query ="insert into describtion_event(id, describtion) values("+id + ",'" + desc+"')";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Событие добавлено";
    }
    public static String edit(int id, String name, int year, int day, String desc) {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
             Statement statement = connection.createStatement()) {
            String query = "update events set year="+year+",day="+day+", name_event='"+name+"' where id="+id;
            statement.executeUpdate(query);
            query = "update describtion_event set describtion='"+ desc +"' where id="+id;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Событие изменено";
    }

    private static String toDate(short day) {
        if (day>390) return "30.13";
        else if  (day < 1) return "01.01";
        else {
            String date = "";
            if (day % 30 == 0) date += "30.";
            else {
                if (day%30 > 9) date += day % 30 + ".";
                else date += "0" + day % 30 + ".";
            }
            if (day/30 > 8) {
                date += (day / 30 + 1);
            }
            else date += "0" + (day / 30 + 1);
            return date;
        }
    }
}
