package examen;

import java.util.Arrays;

public class problema01 {
    
    public static void print(String mensaje) {
        System.out.println(mensaje);
    }
    
public static boolean esOrdenado(int[] arr, int n) {
        if (n <= 1) {
            return true;
        }
        
        if (arr[n - 2] > arr[n - 1]) {
            return false;
        }
        
        return esOrdenado(arr, n - 1);
    }

    public static void ordenar(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }

        int temp = arr[maxIdx];
        arr[maxIdx] = arr[n - 1];
        arr[n - 1] = temp;

        ordenar(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 8};
        print("Arreglo 1: " + Arrays.toString(arr1));
        print("¿Está ordenado?: " + esOrdenado(arr1, arr1.length)); 
        print("---------------------------------------------");

        int[] arr2 = {1, 4, 2, 8};
        print("Arreglo 2: " + Arrays.toString(arr2));
        print("¿Está ordenado?: " + esOrdenado(arr2, arr2.length)); 
        
        print("\n----------------------------------------------------");
        ordenar(arr2, arr2.length);
        print("Arreglo 2 ordenado: " + Arrays.toString(arr2));
        print("¿Está ordenado ahora?: " + esOrdenado(arr2, arr2.length));
    }
}