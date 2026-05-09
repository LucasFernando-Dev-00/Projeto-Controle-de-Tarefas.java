package service;

import entities.Tarefa;
import repository.DbBanco;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TarefasRepositorio {

    private Connection conn;

    public TarefasRepositorio() {
    }

    public TarefasRepositorio(Connection conn) {
        this.conn = conn;
    }

    public void salvar (Tarefa tarefa) {

        try {

            PreparedStatement st = null;
            ResultSet rs = null;

            st = conn.prepareStatement("INSERT INTO tasks "
                            + "(title, status, created_at) "
                            + "VALUES (?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, tarefa.getTitulo());
            st.setString(2, tarefa.getStatus());
            st.setObject(3, tarefa.getData());

            int rowsAffected = st.executeUpdate();
            System.out.println("Concluído, " + rowsAffected);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar (Tarefa tarefa) {

        try {

            PreparedStatement st = null;
            ResultSet rs = null;

            st = conn.prepareStatement("UPDATE tasks "
                            + "SET title = ?, status = ?, created_at = ? "
                            +"WHERE id = ?");

            st.setString(1, tarefa.getTitulo());
            st.setString(2, tarefa.getStatus());
            st.setObject(3, tarefa.getData());
            st.setInt(4, tarefa.getId());

             st.executeUpdate();
            System.out.println("Concluído!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar (Integer id) {

        try {

            PreparedStatement st = null;
            ResultSet rs = null;

            st = conn.prepareStatement("DELETE FROM tasks "
                    + "WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();
            System.out.println("Concluído!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selecionarId (Integer id) {

        try {

            PreparedStatement st = null;
            ResultSet rs = null;

            st = conn.prepareStatement(
                    "SELECT Id, title, status, created_at "
                            + "FROM tasks "
                    +"WHERE id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();
            if(rs.next()) {

                int taskId = rs.getInt("id");
                String title = rs.getString("title");
                String status = rs.getString("status");
                LocalDate date = rs.getDate("created_at").toLocalDate();

                Tarefa tarefa = new Tarefa(taskId, title, status, date);

                System.out.println(tarefa);
            }
            else {
                System.out.println("Nenhuma tarefa encontrada!\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tarefa> selecionarLista () {

        try {

            PreparedStatement st = null;
            ResultSet rs = null;

            st = conn.prepareStatement(
                    "SELECT * FROM tasks");


            rs = st.executeQuery();

            List<Tarefa> list = new ArrayList<>();

            while (rs.next()) {
                LocalDate data = rs.getDate("created_at").toLocalDate();
                Tarefa tarefa = new Tarefa(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("status"),
                        data
                );

                list.add(tarefa);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
