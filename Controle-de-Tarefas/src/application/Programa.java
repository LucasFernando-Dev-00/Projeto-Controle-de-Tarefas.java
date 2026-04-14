package application;

import repository.DbBanco;

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


    }
}
