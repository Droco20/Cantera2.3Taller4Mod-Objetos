package planetarysystem;

import java.io.IOException;

import java.text.ParseException;

public class PlanetarySystem {

    static SolarSystem sl = new SolarSystem("Sistema Solar");

    public static void main(String[] args) throws IOException, ParseException {
        menuPrincipal();

    }

    private static void menuPrincipal() throws IOException, ParseException {
        /** Declaracion de variables */
        String opcionMenu = "";
        String[] menu = { "Calcular atracción gravitacional", "Calcular distancia entre dos objetos", "Salir" };

        /** Menu, Inicio Fin */
        do {
            System.out.println(CreateMenu.createMenu(menu, sl.name));
            opcionMenu = String.valueOf(CreateMenu.readText("Introduzca la opción..."));

            switch (opcionMenu) {
                case "1":
                    /** Calcula atracción gravitacional entre dos objetos */
                    String str3 = CreateMenu.readText("Introduzca el nombre del primer objeto...");
                    String str4 = "";
                    ObjectSystem obj3 = sl.getObjeto(str3);
                    ObjectSystem obj4 = null;
                    if (obj3 == null) {
                        System.out.println("El objeto no existe.");
                    } else {
                        str4 = CreateMenu.readText("Introduzca el nombre del segundo objeto...");
                        obj4 = sl.getObjeto(str4);
                        if (obj4 == null) {
                            System.out.println("El objeto no existe.");
                        } else {
                            double calculo = obj3.getAtraction(obj4);
                            System.out.println(CreateMenu.toNumber(calculo) + " Newton, Fuerza de atraccion ejercida");
                        }
                    }

                    break;
                case "2":
                    /** Calcular distancia entre objetos */
                    String str1 = CreateMenu.readText("Introduzca el nombre del primer objeto...");
                    String str2 = "";
                    ObjectSystem obj1 = sl.getObjeto(str1);
                    ObjectSystem obj2 = null;
                    if (obj1 == null) {
                        System.out.println("El objeto no existe.");
                    } else {
                        str2 = CreateMenu.readText("Introduzca el nombre del segundo objeto...");
                        obj2 = sl.getObjeto(str2);
                        if (obj2 == null) {
                            System.out.println("El objeto no existe.");
                        } else {
                            System.out.println(CreateMenu.toNumber(obj1.calculateDistance(obj2) / 1000) + " Km");
                        }
                    }

                    break;

                case "3":

                    break;
            }

        } while (!opcionMenu.equals("3"));

        System.out.println("Fin del sistema");
    }

}
