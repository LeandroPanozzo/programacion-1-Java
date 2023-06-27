/*
Ejercicio 6:
Escribir una clase Ejercicio6_Corcho, que contenga los atributos

1. bodega (cadena con el nombre de la bodega) y enBotella, booleano que indique si esta
puesto o no en la botella.

Escribir una clase Botella que contenga un atributo:
1. corcho (user la clase Ejercicio6_Corcho para definir el atributo de la clase) con una referencia al
corcho que la tapa (objeto de la clase Corcho).

Escribir una clase Sacacorchos que contenga un atributo:
1. tieneCorcho que indica si el sacacorchos ha sido usado previamente
Y los métodos

1. destapar() que recibe un objeto botella. El método sirve para sacar el corcho de la
botella (cambia el atributo del objeto corcho que forma parte de la clase botella). Debe
imprimir un mensaje de error en el caso en que la botella ya está destapada. Antes de
destapar una botella, debe verificar si el objeto Sacacorchos ha sido previamente usado
o no. En caso de que esté usado, imprima un mensaje de error y no destape la botella.

2. limpiar() que permite quitar el corcho del sacacorchos o en caso de que el sacacorchos
no tenga un corcho, entonces imprima un mensaje de error indicando esto.
Escriba una aplicación en donde se crean los objetos corcho, botella y sacacorcho y se pueda
sacar el corcho de la botella usando el sacacorchos.
r.
 */
package ejercicios_poo;

/**
 * Clase que representa un corcho.
 */
public class Ejercicio6_Corcho {
    private String bodega;
    private boolean enBotella;

    /**
     * Constructor de la clase Ejercicio6_Corcho.
     * @param bodega El nombre de la bodega.
     * @param enBotella Indica si el corcho está puesto en la botella.
     */
    public Ejercicio6_Corcho(String bodega, boolean enBotella) {
        this.bodega = bodega;
        this.enBotella = enBotella;
    }

    /**
     * Clase que representa una botella.
     */
    public class Botella {
        private Ejercicio6_Corcho corcho;

        /**
         * Constructor de la clase Botella.
         * @param corcho El corcho que tapa la botella.
         */
        public Botella(Ejercicio6_Corcho corcho) {
            this.corcho = corcho;
        }
    }

    /**
     * Clase que representa un sacacorchos.
     */
    public class Sacacorchos {
        private boolean tieneCorcho;

        /**
         * Constructor de la clase Sacacorchos.
         * @param tieneCorcho Indica si el sacacorchos tiene un corcho previamente usado.
         */
        public Sacacorchos(boolean tieneCorcho) {
            this.tieneCorcho = tieneCorcho;
        }

        /**
         * Método para destapar una botella.
         * @param botella La botella a destapar.
         */
        public void destapar(Botella botella) {
            if (!botella.corcho.enBotella) {
                System.out.println("Error: la botella ya está destapada.");
            } else if (tieneCorcho) {
                System.out.println("Error: el sacacorchos ya ha sido usado previamente.");
            } else {
                botella.corcho.enBotella = false;
                tieneCorcho = true;
            }
        }

        /**
         * Método para limpiar el sacacorchos.
         */
        public void limpiar() {
            if (!tieneCorcho) { //tiene corcho == false
                System.out.println("Error: el sacacorchos no tiene un corcho.");
            } else {
                tieneCorcho = false;
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio6_Corcho corcho = new Ejercicio6_Corcho("Bodega A", true);
        Ejercicio6_Corcho.Botella botella = corcho.new Botella(corcho);
        Ejercicio6_Corcho.Sacacorchos sacacorchos = corcho.new Sacacorchos(false);

        sacacorchos.destapar(botella);
        sacacorchos.limpiar();
    }
}

