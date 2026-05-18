import java.util.Arrays;

public class problema02 {

    public static void print(String mensaje) {
        System.out.println(mensaje);
    }

    public static class Resultado {
        int max1;
        int max2;

        public Resultado(int max1, int max2) {
            this.max1 = max1;
            this.max2 = max2;
        }
    }

    public static Resultado obtenerSegundoMasGrande(int[] arr, int bajo, int alto) {

        if (bajo == alto) {
            return new Resultado(arr[bajo], Integer.MIN_VALUE); 
        }

        if (bajo + 1 == alto) {
            if (arr[bajo] > arr[alto]) {
                return new Resultado(arr[bajo], arr[alto]);
            } else {
                return new Resultado(arr[alto], arr[bajo]);
            }
        }

        int medio = bajo + (alto - bajo) / 2;


        Resultado izq = obtenerSegundoMasGrande(arr, bajo, medio);
        Resultado der = obtenerSegundoMasGrande(arr, medio + 1, alto);

        return combinar(izq, der);
    }

    private static Resultado combinar(Resultado izq, Resultado der) {
        int maxGlobal1;
        int maxGlobal2;

        if (izq.max1 > der.max1) {
            maxGlobal1 = izq.max1;
            maxGlobal2 = Math.max(izq.max2, der.max1);
        }
        else {
            maxGlobal1 = der.max1;
            maxGlobal2 = Math.max(der.max2, izq.max1);
        }

        return new Resultado(maxGlobal1, maxGlobal2);
    }

    public static void main(String[] args) {
        int[] datos = {8, 3, 10, 5, 7};
        
        print("Arreglo de prueba: " + Arrays.toString(datos));
        
        Resultado finalRes = obtenerSegundoMasGrande(datos, 0, datos.length - 1);
        
        print("Elemento Más Grande: " + finalRes.max1);
        print("Resultado esperado: " + finalRes.max2);
    }
}