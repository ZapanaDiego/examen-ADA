import java.util.Arrays;

public class problema03 {

    public static void print(String mensaje) {
        System.out.println(mensaje);
    }

    public static long calcularInversiones(int[] arr) {
        int[] temp = new int[arr.length];
        return ordenarYContar(arr, temp, 0, arr.length - 1);
    }

    private static long ordenarYContar(int[] arr, int[] temp, int izq, int der) {
        long totalInversiones = 0;
        
        if (izq < der) {
            int mid = izq + (der - izq) / 2;

            totalInversiones += ordenarYContar(arr, temp, izq, mid);
            totalInversiones += ordenarYContar(arr, temp, mid + 1, der);
            totalInversiones += fusionarYContar(arr, temp, izq, mid, der);
        }
        
        return totalInversiones;
    }

    private static long fusionarYContar(int[] arr, int[] temp, int izq, int mid, int der) {
        int i = izq;
        int j = mid + 1;
        int k = izq;
        long inversionesCruzadas = 0;

        while (i <= mid && j <= der) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                for (int p = i; p <= mid; p++) {
                    print("Inversión: (" + arr[p] + ", " + arr[j] + ")");
                }
                temp[k++] = arr[j++];
                inversionesCruzadas += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= der) {
            temp[k++] = arr[j++];
        }

        for (i = izq; i <= der; i++) {
            arr[i] = temp[i];
        }

        return inversionesCruzadas;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        
        print("Arreglo original: " + Arrays.toString(arr));
        
        long resultado = calcularInversiones(arr);
        
        print("Resultado esperado: " + resultado);
    }
}