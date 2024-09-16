package dad.codewars.kyu8;

public class Problema3 {
    public static String reverseWords(String str) {
        // Dividir el string por palabras
        String[] words = str.split(" ");
        // Almacen del resultado
        String result = "";

        // Recorrer las palabras de principio a fin
        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i];

            // Añadir espacio entre las palabras, excepto la última
            if (i != 0) {
                result += " ";
            }
        }

        return result;
    }
}