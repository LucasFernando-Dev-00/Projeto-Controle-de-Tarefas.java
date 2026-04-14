package application;

import repository.DbBanco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Locale;

import repository.DbBanco;

public class Programa {
    public static void main(String[]main) {
       Locale.setDefault(Locale.US);
       Scanner sc = new Scanner(System.in);

        DbBanco conect = new DbBanco();
        DbBanco conect1 = conect;

        conect1.DBConection();

        PreparedStatement st = null;
        ResultSet rs = null;

        //Preciso instaciar a Classe Tarefa com o banco de Dado e fazer com que a mesma tabela que aparece lá apareça no terminal Java

    }
}
