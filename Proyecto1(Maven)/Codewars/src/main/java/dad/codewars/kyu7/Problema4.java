package dad.codewars.kyu7;

public class Problema4 {
    public static int[] multiplos(int m, int n) {
        int[] resultados = new int[m];

        //Buscar la cantidad de multiplos (m) de un numero (n)
        for (int i = 0; i < m; i++) {
            resultados[i] = (i + 1) * n;
        }

        return resultados;
    }
}
