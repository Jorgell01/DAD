package dad.codewars.kyu6;

public class Problema5 {
    public static int problema5(int numero) {
        int sum = 0;

        //Comprobar si todos los numeros dentro del que pasemos es divisible entre 3 o 5
        for (int i = 1; i < numero; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
