package dad.codewars.kyu8;

public class Problema2 {
    public static boolean isAscOrder(int[] arr) {
        // Manejar casos especiales
        if (arr.length < 2) {
            return true; // Arrays con 0 o 1 elemento están ordenados
        }

        // Verificar si cada elemento es menor o igual que el siguiente elemento
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false; // Se encontró un par donde el orden no es ascendente
            }
        }

        return true; // Todos los pares estaban en orden ascendente
    }
}
