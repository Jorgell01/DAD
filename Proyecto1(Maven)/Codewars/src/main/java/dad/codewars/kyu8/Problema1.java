package dad.codewars.kyu8;

public class Problema1 {
    public static int[] divisibleBy (int[] numbers, int divisor) {
        //Contar cuantos son divisibles
        int count = 0;
                for (int number : numbers) {
                    if (number % divisor == 0) {
                        count++;
                    }
                }
                //Hacer otro array para guardar los divisibles
                int[] resultado = new int[count];
                int index = 0;

                //Recorrer el array para llenar el nuevo con los divisibles
                for (int number : numbers) {
                    if (number % divisor == 0) {
                        resultado [index++] = number;
                    }
                }
                
                return resultado;
    }
}
