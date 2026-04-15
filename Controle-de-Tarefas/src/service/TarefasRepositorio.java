package service;

import entities.Tarefa;

import java.sql.*;
import java.text.ParseException;

public class TarefasRepositorio {

    public TarefasRepositorio () {

    }
    public void salvar (Tarefa tarefa) {

        try {

            PreparedStatement st = null;
            ResultSet rs = null;
            Connection conn = null;

            String sql = "INSERT INTO tasks "
                            + "(title, description, status, created_at) "
                            + "VALUES (?, ?, ?, ?)";




            int rowsAffected = st.executeUpdate();
            System.out.println("Concluído, " + rowsAffected);

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Doone! Id = " + id);
                }
            } else {
                System.out.println("No rown affected!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
