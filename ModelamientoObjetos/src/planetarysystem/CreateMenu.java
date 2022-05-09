package planetarysystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Scanner;

public class CreateMenu {

    /**
     * Crea el menu desde un array de cadenas con asterisco por defecto.
     */
    public static String createMenu(String arg[], String header) {
        return createMenu(arg, "*", header);
    }

    /**
     * Crea el menu desde un array de cadenas.
     */

    public static String createMenu(String arg[], String stringMarcoMenu, String header) {

        /** Declaracion de Variables */
        int maxLong = 0;
        String asterisk = "";
        String textOut = "";

        // crear el menu
        for (int i = 0; i < maxLong + 10; i++) {
            asterisk += stringMarcoMenu;
        }

        textOut += asterisk + "\n";

        /** Cabecera si la hay */
        textOut += header + dumpChar(" ", maxLong - header.length()) + "\n" + asterisk + "\n";

        for (int i = 0; i < arg.length; i++) {
            textOut += stringMarcoMenu + " (" + (i + 1) + ") " + arg[i];
            for (int j = arg[i].length(); j < maxLong + 3; j++) {
                textOut += " ";
            }
            textOut += stringMarcoMenu + "\n";
        }
        textOut += asterisk + "\n";
        return textOut;
    }

    public static String toNumber(double number) {
        NumberFormat fn = NumberFormat.getNumberInstance();
        return fn.format(number);
    }

    public static String dumpChar(String string, int lenght) {
        String textOut = "";

        for (int i = 0; i < lenght; i++) {
            textOut += string;
        }
        return textOut;
    }

    public static String readText(String textIn) throws IOException {
        return CreateMenu.readText(textIn, false);
    }

    public static String readText(String textIn, boolean allowEmpty) throws IOException {

        /** Declaración de variables */
        BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));
        String textOut = null;

        /** Imprimir texto de consola */
        System.out.println(textIn);

        /** Solicitar datos desde teclado */

        do {
            textOut = keyboardIn.readLine();
        } while (CreateMenu.isNullOrEmpty(textOut) && !allowEmpty);

        /** Retornar texto */
        return textOut;
    }

    private static boolean isNullOrEmpty(String textOut) {
        return false;
    }

    public static void keyDownToContinue() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Pulse INTRO para continuar...");
        in.nextLine();
    }

    /**
     * Rellena por la derecha n espacios y
     * recorta el texto cuando es mayor añadiéndole
     * puntos suspensivos
     */
    public static String padRight(String text, int number) {
        if (text.length() > number) {
            text = text.substring(0, number - 3) + "...";
        }
        return String.format("%1$-" + number + "s", text);
    }

    /**
     * Rellena por la izquierda espacios y
     * recorta el texto cuando es mayor añadiéndole
     * puntos suspensivos
     */
    public static String padLeft(String text, int number) {
        if (text.length() > number) {
            text = text.substring(0, number - 3) + "...";
        }
        return String.format("%1$" + number + "s", text);
    }

}
