package application;

import entities.Tarefa;
import repository.DbBanco;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Locale;

import repository.DbBanco;
import service.TarefasRepositorio;

import javax.swing.text.DateFormatter;

public class Programa {
    public static void main(String[]main) throws ParseException  {
       Locale.setDefault(Locale.US);
       Scanner sc = new Scanner(System.in);

        DbBanco conect = new DbBanco();
        DbBanco conect1 = conect;

        Connection conn = conect1.DBConection();

        TarefasRepositorio tr = new TarefasRepositorio(conn);

        while(true) {

         System.out.println("==LISTA DE TAREFAS==");
         System.out.println();
         System.out.print("Digite o título: ");
         String titulo = sc.nextLine();
         System.out.print("Digite o status: ");
         String status = sc.nextLine();
         System.out.print("Data (dd/MM/yyyy): ");
         String dataStr = sc.nextLine();

         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         LocalDate data = LocalDate.parse(dataStr, formatter);

         Tarefa tarefa = new Tarefa(null, titulo, status, data);

            tr.salvar(tarefa);


         System.out.print("Deseja continuar: ");
         String continuar = sc.nextLine();

         if (continuar.equalsIgnoreCase("sair")) break;
        }

    }
}
