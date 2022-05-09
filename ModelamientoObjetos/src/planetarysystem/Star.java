package planetarysystem;

public class Star extends ObjectSystem {

     private StarType startype;

     /**NUeva instancia del objeto estrella */

     public Star(String name, double mass, double diameter, StarType type) {
          super(name, mass, diameter);
          this.startype = type;
          this.setObjectReference(this);
          // TODO Auto-generated constructor stub
     }

     @Override
     public int compareTo(ObjectSystem o) {
          // TODO Auto-generated method stub
          return 0;
     }

     /** obtiene el objeto sobre el texto */
     @Override
     public String toString() {
          return "Tipo de estrella:    " + this.startype.toString().replace("_", "") + "\n" + super.toString();
     }

     @Override
     public String toStringtoList() {
          String textOut = "";
          String t = "Estrella " + this.startype.toString().replace("_", " ");
          textOut += t;
          textOut += super.toStringtoList() + "\n";
          return textOut;
     }

}
