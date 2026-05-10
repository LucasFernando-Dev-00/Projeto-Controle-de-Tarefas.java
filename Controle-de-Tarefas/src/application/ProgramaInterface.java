package application;

import repository.DbBanco;
import service.TarefasRepositorio;

import javax.swing.*;
import java.sql.Connection;

public class ProgramaInterface {
    public static void main(String[]args) {

        DbBanco conect = new DbBanco();
        DbBanco conect1 = conect;

        Connection conn = conect1.DBConection();

        if (conn != null) {
            TarefasRepositorio tr = new TarefasRepositorio(conn);

            SwingUtilities.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                    TelaTarefas tela = new TelaTarefas(tr);
                    tela.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }
        else {
            JOptionPane.showMessageDialog(null,

                    "Erro: Não foi possível conectar ao abnco de dados!",
                    "Falha na Conexão",
                        JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
