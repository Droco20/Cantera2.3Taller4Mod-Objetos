package planetarysystem;

import java.util.ArrayList;
import java.util.Collections;

public class SolarSystem {

     String name;

     public SolarSystem(String _name) {
          this.name = _name;
          createSolarSystem();
     }

     public ArrayList<ObjectSystem> solarSystem = new ArrayList();

     /**
      * Ordena el ArrayList de objetos del sistema
      * 
      * @param orden Campo de orden
      */
     public void sort(String orden) {
          for (ObjectSystem obj : solarSystem) {
               obj.sort = orden;
          }
          Collections.sort(solarSystem);
     }

     @Override
     public String toString() {
          String textOut = getHeaderList();
          for (ObjectSystem obj : solarSystem) {
               textOut += obj.toStringtoList();
          }

          return textOut;
     }

     /** obtiene un objeto con el nombre */
     public ObjectSystem getObjeto(String _name) {
          for (ObjectSystem objectSystem : solarSystem) {
               if (objectSystem.name.toUpperCase().contains(_name.toUpperCase())) {
                    return objectSystem;

               }
          }
          return null;

     }

     /**
      * Obtiene un encabezado de lista
      * 
      * @return Texto
      */
     private String getHeaderList() {
          String textOut = "";
          textOut += "Tipo" + CreateMenu.padRight(" ", 20) +
                    "Nombre" + CreateMenu.padRight(" ", 8) +
                    "Masa" + CreateMenu.padRight(" ", 37) +
                    "Diámetro" + CreateMenu.padRight(" ", 8) +
                    "Distancia" + CreateMenu.padRight(" ", 15) +
                    "Traslacion" + CreateMenu.padRight(" ", 5) +
                    "Rotación" + CreateMenu.padRight(" ", 6);

          textOut += "\n" + CreateMenu.padRight(" ", 140).replace(" ", "=") + "\n";
          return textOut;
     }

     /** Instancias de objetos planeta y estrella */

     private void createSolarSystem() {
          Star sol = new Star("sol", 1.9891E30, 1392000, StarType.Yellow_Dwarf);

          PlanetU mercurio = new PlanetU("Mercurio", 3.302E23, 57909175, 4879.4, sol);
          PlanetU venus = new PlanetU("Venus", 3.9742E24, 108200000, 12103.6, sol);
          PlanetU tierra = new PlanetU("Tierra", 5.9742E24, 149597870, 12742, sol);
          PlanetU marte = new PlanetU("Marte", 7.4191E23, 227936640, 6779, sol);
          PlanetU jupiter = new PlanetU("Jupiter", 1.8987E27, 778412010, 139822, sol);
          PlanetU urano = new PlanetU("Urano", 8.6849E25, 2870972200f, 50724, sol);
          PlanetU neptuno = new PlanetU("Neptuno", 1.0244E26, 4498252900f, 49244, sol);

          PlanetU pluton = new PlanetU("Pluton", 1.25E22, 5913520000f, 2320, sol);

          solarSystem.add(sol);
          solarSystem.add(mercurio);
          solarSystem.add(venus);
          solarSystem.add(tierra);
          solarSystem.add(marte);
          solarSystem.add(jupiter);
          solarSystem.add(urano);
          solarSystem.add(neptuno);
          solarSystem.add(pluton);

     }

}
