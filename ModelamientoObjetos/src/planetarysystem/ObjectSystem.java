package planetarysystem;

public abstract class ObjectSystem implements Comparable<ObjectSystem> {

     private double mass;

     private double density;

     private double diameter;

     private double distanceMedia;

     String name;

     String sort = "distance";
     protected double daysTranslation;

     protected double hoursRotations;

     final double G = 6.6726E-11;

     private ObjectSystem objectReference;

     public ObjectSystem(String _name, double _mass, double diameter) {
          this.name = _name;
          this.mass = _mass;
          this.distanceMedia = 0L;
          this.diameter = diameter;

     }

     public ObjectSystem(String _name, double _mass, double _distance, double _diameter,
               ObjectSystem _objectReference) {
          this.name = _name;
          this.mass = _mass;
          this.distanceMedia = _distance;
          this.objectReference = _objectReference;
          this.diameter = _diameter;

     }

     public double getMass() {
          return mass;
     }

     public void setMass(double mass) {
          this.mass = mass;
     }

     public double getDensity() {
          return density;
     }

     public void setDensity(double density) {
          this.density = density;
     }

     public double getDiameter() {
          return diameter;
     }

     public void setDiameter(double diameter) {
          this.diameter = diameter;
     }

     public double getDistanceReference() {
          return distanceMedia;
     }

     public void setDistanceReference(double distanceReference) {
          this.distanceMedia = distanceReference;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public ObjectSystem getObjectReference() {
          return objectReference;
     }

     public void setObjectReference(ObjectSystem objectReference) {
          this.objectReference = objectReference;
     }

     public boolean equals(ObjectSystem objectSystem) {
          return this.name.equals(objectSystem.name);

     }

     /**
      * Obtiene la atraccion entre dos objetos planetarios
      * 
      */
     public double getAtraction(ObjectSystem objectSystem) {

          double distanceBetweenObjects = this.calculateDistance(objectSystem);
          double numerator = (this.mass * objectSystem.mass * this.G);
          double distance = distanceBetweenObjects;
          double denominator = distance * distance;
          double atraction = numerator / denominator;
          return atraction;
     }

     /** calcula la distancia de los planetas con respecto al sol */

     public double calculateDistance(ObjectSystem objectSystem) {
          double distance1 = calculateDistanceAObjectReference(this);
          double distance2 = calculateDistanceAObjectReference(objectSystem);

          return Math.abs(distance1 - distance2) * 1000;// metros
     }

     /**
      * Retorna el objeto sobre texto
      * 
      * @return Texto
      */
     @Override
     public String toString() {
          String textOut = "";
          textOut += "Nombre:          " + this.name + "\n";
          textOut += "Masa:            " + CreateMenu.toNumber(this.mass) + "Kg\n";
          textOut += "Diametro:        " + CreateMenu.toNumber(this.diameter) + " Km\n";
          textOut += "Distancia a " + this.objectReference.name + ":" + CreateMenu.toNumber(this.distanceMedia)
                    + " Km\n";

          return textOut;
     }

     /** toma la referencia entre el planeta inicial */

     public static char[] get(int i) {
          return null;
     }

     public String toStringtoList() {
          String textOut = "";
          String m = CreateMenu.toNumber(mass) + " Kg";
          String d = CreateMenu.toNumber(diameter) + " Km";
          String dm = "A " + this.objectReference.name + " " + CreateMenu.toNumber(distanceMedia) + " Km";
          textOut += this.name + CreateMenu.padLeft("", 10 - this.name.length());
          textOut += m + CreateMenu.padLeft("", 45 - m.length());
          textOut += d + CreateMenu.padLeft("", 15 - d.length());
          textOut += dm + CreateMenu.padLeft("", 23 - dm.length());

          return textOut;
     }

     /**
      * Método de compración de objetos
      */

     @Override
     public int compareTo(ObjectSystem o) {
          switch (sort) {
               case "name":
                    return this.name.compareTo(o.name);
               case "distance":
                    if (calculateDistanceAObjectReference(this) >= calculateDistanceAObjectReference(o)) {
                         return 1;
                    } else {
                         return -1;
                    }
               case "tamaño":
                    if (this.diameter >= o.diameter) {
                         return 1;
                    } else {
                         return -1;
                    }
               case "masa":
                    if (this.mass >= o.mass) {
                         return 1;
                    }
               case "rotacion":
                    if (this.hoursRotations >= o.hoursRotations) {
                         return 1;
                    } else {
                         return -1;
                    }
               case "traslacion":
                    if (this.daysTranslation >= o.daysTranslation) {
                         return 1;
                    } else {
                         return -1;
                    }

          }
          return 0;
     }

     /** metodo para clacular la distancia entre objetos */

     private double calculateDistanceAObjectReference(ObjectSystem objetoSistemaInicial) {
          double distance = objetoSistemaInicial.distanceMedia;
          if (!objetoSistemaInicial.objectReference.objectReference.equals(objetoSistemaInicial.objectReference)) {
               distance += calculateDistanceAObjectReference(objetoSistemaInicial.objectReference);
          }

          return distance;
     }

     /**
      * Obtiene la rotación en días u horas
      * 
      * @return Texto
      */
     protected String getRotacion() {
          String textOut = "";
          if (hoursRotations > 24) {
               textOut += CreateMenu.toNumber(hoursRotations / 24) + " días";
          } else {
               textOut += CreateMenu.toNumber(hoursRotations) + " horas";
          }

          return textOut;
     }

     /**
      * Obtiene la traslación en días o años
      */
     protected String getTraslacion() {
          String textOut = "";
          if (daysTranslation > 730) {
               textOut += CreateMenu.toNumber(daysTranslation / 365) + " Años";
          } else {
               textOut += CreateMenu.toNumber(daysTranslation) + " Días";
          }

          return textOut;
     }

}
