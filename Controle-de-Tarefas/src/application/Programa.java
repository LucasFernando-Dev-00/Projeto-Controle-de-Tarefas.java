package application;

import entities.Tarefa;
import repository.DbBanco;

import java.sql.Date;
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

public class Programa {
    public static void main(String[]main) throws ParseException  {
       Locale.setDefault(Locale.US);
       Scanner sc = new Scanner(System.in);



        DbBanco conect = new DbBanco();
        DbBanco conect1 = conect;

        conect1.DBConection();

        PreparedStatement st = null;
        ResultSet rs = null;

        System.out.println("==LISTA DE TAREFAS==");
        System.out.println();
        System.out.print("Digite o título: ");
        String titulo = sc.nextLine();
        System.out.print("Digite o status: ");
        String status = sc.nextLine();
        System.out.print("Data (dd/MM/yyyy HH:mm): ");
        String dataStr = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime data = LocalDateTime.parse(dataStr, formatter);

        Tarefa tarefa = new Tarefa(titulo, status, data);

        TarefasRepositorio tr = new TarefasRepositorio();

        tr.salvar(tarefa);

        //Preciso instaciar a Classe Tarefa com o banco de Dado e fazer com que a mesma tabela que aparece lá apareça no terminal Java

    }
}
