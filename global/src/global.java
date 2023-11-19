import java.util.Scanner;

public class global
{

    public static void main(String[] args) {
        // Ejemplo de uso


        System.out.println("Ejemplo de uso:");
        String[] dna1 = dataEntry();
        printMatrix(dna1);
        if (isMutant(dna1)) {
            System.out.println("Es mutante");
        } else {
            System.out.println("No es mutante");
        }

        // Prueba 1
        String[] dna2 = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };

        System.out.println("Prueba 1:");
        printMatrix(dna2);
        if (isMutant(dna2)) {
            System.out.println("Es mutante");
        } else {
            System.out.println("No es mutante");
        }

        // Prueba 2
        String[] dna3 = {
                "ATGCGA",
                "CAGTGC",
                "TTATTT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"
        };

        System.out.println("Prueba 2:");
        printMatrix(dna3);
        if (isMutant(dna3)) {
            System.out.println("Es mutante");
        } else {
            System.out.println("No es mutante");
        }
    }

    // Función para verificar si es mutante
    public static boolean isMutant(String[] dna) {
        char[][] matrix = new char[dna.length][];
        for (int i = 0; i < dna.length; i++) {
            matrix[i] = dna[i].toCharArray();
        }

        return findHorizontal(matrix, 'A', 4) || findHorizontal(matrix, 'G', 4) ||
                findHorizontal(matrix, 'C', 4) || findHorizontal(matrix, 'T', 4) ||
                findVertical(matrix, 'A', 4) || findVertical(matrix, 'G', 4) ||
                findVertical(matrix, 'C', 4) || findVertical(matrix, 'T', 4) ||
                findDiagonal(matrix, 'A', 4) || findDiagonal(matrix, 'G', 4) ||
                findDiagonal(matrix, 'C', 4) || findDiagonal(matrix, 'T', 4);
    }

    // Función que compara palabras en horizontal
    public static boolean findHorizontal(char[][] array, char base, int length) {
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == base) {
                    count++;
                    if (count == length) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    // Función que compara palabras en vertical
    public static boolean findVertical(char[][] array, char base, int length) {
        for (int i = 0; i < array[0].length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] == base) {
                    count++;
                    if (count == length) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    // Función que compara palabras en diagonal
    public static boolean findDiagonal(char[][] array, char base, int length) {
        for (int i = 0; i < array.length - 1; i++) {
            int count = 0;
            // De izquierda a derecha
            for (int j = 0; j < array.length - i; j++) {
                if (array[j + i][j] == base) {
                    count++;
                    if (count == length) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        // De derecha a izquierda
        for (int i = 0; i < array.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j][array[0].length - i - j - 1] == base) {
                    count++;
                    if (count == length) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    // Función para imprimir la matriz
    public static void printMatrix(String[] matrix) {
        System.out.println("Matriz ingresada:");
        for (String row : matrix) {
            System.out.println(row);
        }
    }

    // Función para llenar arreglo y validar si es correcto
    public static String[] dataEntry() {
        Scanner scanner = new Scanner(System.in);
        String[] array = new String[0];
        while (array.length < 6) {
            System.out.print("Ingrese una fila de la matriz, debe ser 6 letras y solo puede ingresar las letras A,T,C,G: ");
            String row = scanner.next().toUpperCase();
            if (row.length() == 6 && row.matches("[ATCG]+")) {
                array = appendToArray(array, row);
            } else {
                System.out.println("Ingreso invalido");
            }
        }
        return array;
    }

    // Función para agregar elemento a un arreglo
    public static String[] appendToArray(String[] array, String element) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }
}