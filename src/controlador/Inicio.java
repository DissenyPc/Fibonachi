package controlador;

import java.util.Scanner;

public class Inicio {
    private static final int Modulo = 46337;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;
            System.out.println(fibonacci(n));
        }
        scanner.close();
    }

    private static int fibonacci(int numero) {
        if (numero == 0) return 0;
        if (numero == 1) return 1;
        
        int[][] resultado = {{1, 0}, {0, 1}};
        int[][] base = {{0, 1}, {1, 1}};
        
        numero -= 1;
        
        while (numero > 0) {
            if (numero % 2 == 1) {
                resultado = multiplyMatrices(resultado, base);
            }
            base = multiplyMatrices(base, base);
            numero /= 2;
        }
        
        return resultado[1][1];
    }

    private static int[][] multiplyMatrices(int[][] r, int[][] b) {
        int[][] resultado = new int[2][2];
        resultado[0][0] = (r[0][0] * b[0][0] + r[0][1] * b[1][0]) % Modulo;
        resultado[0][1] = (r[0][0] * b[0][1] + r[0][1] * b[1][1]) % Modulo;
        resultado[1][0] = (r[1][0] * b[0][0] + r[1][1] * b[1][0]) % Modulo;
        resultado[1][1] = (r[1][0] * b[0][1] + r[1][1] * b[1][1]) % Modulo;
        return resultado;
    }
}