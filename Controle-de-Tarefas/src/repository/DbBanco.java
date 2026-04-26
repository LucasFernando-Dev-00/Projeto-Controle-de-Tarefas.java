package repository;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DbBanco {

    private String url = "jdbc:mysql://localhost:3306/tarefas";
    private String user = "root";
    private String password = "01032008";

    public DbBanco() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //private PreparedStatement st = null;
    //private ResultSet rs = null;

public Connection DBConection() {

    try {
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Conectado com sucesso!");

        return conn;

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}
