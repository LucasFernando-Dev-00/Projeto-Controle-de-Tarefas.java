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
import java.util.List;
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

        int opcao;

        do {
            System.out.println("1-Inserir Tarefa");
            System.out.println("2-Atualizar Tarefa");
            System.out.println("3-Deletar Tarefa");
            System.out.println("4-Selecionar Tarefa(Id)");
            System.out.println("5-Selecionar Tarefas");
            System.out.println();
            System.out.print("Qual opção deseja: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    String continuar;
                    do {
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

                        sc.nextLine();
                        System.out.print("Deseja continuar(sim/sair): ");
                        continuar = sc.nextLine();

                    } while (continuar.equalsIgnoreCase("sim"));
                    break;

                case 2:
                    do {
                        System.out.println("==ATUALIZAR TAREFA==");
                        System.out.println();
                        System.out.print("Digite o id: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Digite o status: ");
                        String status = sc.nextLine();
                        System.out.print("Data (dd/MM/yyyy): ");
                        String dataStr = sc.nextLine();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate data = LocalDate.parse(dataStr, formatter);

                        Tarefa tarefa = new Tarefa(id, titulo, status, data);

                        tr.atualizar(tarefa);
                        sc.nextLine();
                        System.out.print("Deseja continuar(sim/sair): ");
                        continuar = sc.nextLine();

                    } while (continuar.equalsIgnoreCase("sim"));
                    break;

                case 3:
                    do {
                        System.out.println("==DELETAR TAREFA==");
                        System.out.println();
                        System.out.print("Digite o id: ");
                        int id = sc.nextInt();

                        tr.deletar(id);

                        sc.nextLine();
                        System.out.print("Deseja continuar(sim/sair): ");
                        continuar = sc.nextLine();

                    } while (continuar.equalsIgnoreCase("sim"));
                    break;

                case 4:
                    do {
                        System.out.println("==SELECIONAR TAREFA==");
                        System.out.println();
                        System.out.print("Digite o id: ");
                        int id = sc.nextInt();

                        tr.selecionarId(id);

                        sc.nextLine();
                        System.out.print("Deseja continuar(sim/sair): ");
                        continuar = sc.nextLine();

                    } while (continuar.equalsIgnoreCase("sim"));
                    break;

                case 5:
                    do {
                        System.out.println("==SELECIONAR TAREFAS==");
                        System.out.println();

                        List<Tarefa> lista = tr.selecionarLista();

                        if (lista.isEmpty()) {
                            System.out.println("Nenhum item foi encontrado!");
                        }
                        else {
                            for (Tarefa t : lista) {
                                System.out.println(t);
                            }
                        }

                        sc.nextLine();
                        System.out.print("Deseja continuar(sim/sair): ");
                        continuar = sc.nextLine();

                    } while (continuar.equalsIgnoreCase("sim"));
                    break;

                default:
                    if (opcao != 0) System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }
}
