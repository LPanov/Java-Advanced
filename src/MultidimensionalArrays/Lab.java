package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab {
    Scanner sc = new Scanner(System.in);

    private boolean areEqualMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
    public void compareMatrices() {
        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int matrix1Rows = dimensions[0];
        int matrix1Col = dimensions[1];

        int[][] firstMatrix = new int[matrix1Rows][];

        for (int i = 0; i < matrix1Rows; i++) {
            int[] temp = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            firstMatrix[i] = temp;
        }

        dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int matrix2Rows = dimensions[0];
        int matrix2Col = dimensions[1];
        int[][] secondMatrix = new int[matrix2Rows][];

        for (int i = 0; i < matrix2Rows; i++) {
            int[] temp = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            secondMatrix[i] = temp;
        }

        if (areEqualMatrices(firstMatrix, secondMatrix)) System.out.println("equal");
        else System.out.println("not equal");
    }

    public void positionOf() {
        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] temp = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = temp;
        }

        int number = Integer.parseInt(sc.nextLine());
        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    System.out.println(i + " " + j);
                    found = true;
                }
            }
        }

        if (!found) System.out.println("not found");

    }

    private void fill2DArray(int[][] matrix, int rows) {
        for (int i = 0; i < rows; i++) {
            int[] temp = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = temp;
        }
    }
    private void fill2DArray(String[][] matrix, int rows) {
        for (int i = 0; i < rows; i++) {
            String[] temp = sc.nextLine().split("\\s+");

            matrix[i] = temp;
        }
    }
    public void intersectionOfTwoMatrices() {
        //int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = Integer.parseInt(sc.nextLine());
        int columns = Integer.parseInt(sc.nextLine());

        String[][] A = new String[rows][];
        String[][] B = new String[rows][];
        fill2DArray(A, rows);
        fill2DArray(B, rows);

        String[][] C = new String[rows][columns];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j].equals(B[i][j])) {
                    C[i][j] = A[i][j];
                } else {
                    C[i][j] = "*";
                }
            }
        }
        //Arrays.stream(C).forEach(c -> System.out.println(Arrays.toString(c).replace(", ", " ").replaceAll("[\\[\\]]", "")));

        System.out.println(Arrays.deepToString(C).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
    }

    public void sumMatrixElements() {
        int[] dimensions = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] A = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] temp = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            A[i] = temp;
        }

        System.out.println(A.length);
        System.out.println(A[0].length);
        System.out.println(Arrays.stream(A).flatMapToInt(Arrays::stream).sum());
    }

    private List<int[][]> getBiggest(int[][] matrix) {
        List<int[][]> matrices = new ArrayList<>();

        for (int l = 0; l < matrix.length - 1; l++) {
            for (int k = 0; k < matrix[0].length-1; k++) {
                int[][] sample = new int[2][2];
                for (int i = l; i < l+2; i++) {
                    for (int j = k; j < k+2; j++) {
                        sample[i-l][j-k] = matrix[i][j];
                    }
                }

                matrices.add(sample);
            }
        }

        return matrices;
    }
    public void maximumSum2x2Submatrix() {
        int[] dimensions = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] A = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] temp = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            A[i] = temp;
        }

        int max = 0;
        int[][] biggest = new int[2][2];
        for (int[][] m : getBiggest(A)) {
            //System.out.println(Arrays.deepToString(m).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
            int sum = Arrays.stream(m).flatMapToInt(Arrays::stream).sum();
            if (sum > max) {
                max = sum;
                biggest = m;
            }
        }

        System.out.println(Arrays.deepToString(biggest).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
        System.out.println(max);
    }

    public void printDiagonals() {
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];
        fill2DArray(matrix, n);

        int[][] diagonals = new int[2][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) diagonals[0][j] = matrix[i][j];
                if (i+j == n - 1) diagonals[1][j] = matrix[i][j];
            }
        }

        System.out.println(Arrays.deepToString(diagonals).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
    }

    private boolean isValidPos(int i, int j, int n, int m)
    {
        if (i < 0 || j < 0 || i > n - 1 || j > m - 1) {
            return false;
        }
        return true;
    }
    private int getAdjacent(int[][] matrix, int i, int j, int value) {
        int out = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        // Checking for all the possible adjacent positions
        if (isValidPos(i - 1, j, n, m)) {
            if (matrix[i-1][j] != value) out += matrix[i-1][j];
        }
        if (isValidPos(i, j - 1, n, m)) {
            if (matrix[i][j-1] != value) out += matrix[i][j-1];
        }
        if (isValidPos(i, j + 1, n, m)) {
            if (matrix[i][j+1] != value) out += matrix[i][j+1];
        }
        if (isValidPos(i + 1, j, n, m)) {
            if (matrix[i+1][j] != value) out += matrix[i+1][j];
        }

        return out;
    }

    public void wrongMeasurements() {
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][];
        fill2DArray(matrix, n);

        int[] positionValue = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int value = matrix[positionValue[0]][positionValue[1]];

        int[][] output = new int[n][matrix[0].length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < output[0].length; j++) {
                if (matrix[i][j] == value) {
                    output[i][j] = getAdjacent(matrix, i, j, value);
                } else {
                    output[i][j] = matrix[i][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(output).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
    }

    private boolean isValid(String[][] board, int r, int c) {
        for (int i = r-1; i > 0; i--) {
            if (!isValidPos(i, c, 8, 8)) break;
            if (board[i][c].equals("q")) return false;
        }
        for (int i = r+1; i < 8; i++) {
            if (!isValidPos(i, c, 8, 8)) break;
            if (board[i][c].equals("q")) return false;
        }
        for (int i = c-1; i > 0; i--) {
            if (!isValidPos(r, i, 8, 8)) break;
            if (board[r][i].equals("q")) return false;
        }
        for (int i = c+1; i < 8; i++) {
            if (!isValidPos(r, i, 8, 8)) break;
            if (board[r][i].equals("q")) return false;
        }
        int j = c-1;
        for (int i = r+1; i < 8; i++) {
            if (!isValidPos(i, j, 8, 8)) break;
            if (board[i][j].equals("q")) return false;
            j--;
            if (j == 0) break;
        }
        j = c-1;
        for (int i = r-1; i > 0; i--) {
            if (!isValidPos(i, j, 8, 8)) break;
            if (board[i][j].equals("q")) return false;
            j--;
            if (j == 0) break;
        }
        j = c+1;
        for (int i = r-1; i > 0; i--) {
            if (!isValidPos(i, j, 8, 8)) break;
            if (board[i][j].equals("q")) return false;
            j++;
            if (j == 7) break;
        }
        j = c+1;
        for (int i = r+1; i < 8; i++) {
            if (!isValidPos(i, j, 8, 8)) break;
            if (board[i][j].equals("q")) return false;
            j++;
            if (j == 7) break;
        }
        return true;
    }
    public void findTheRealQueen() {
        String[][] board = new String[8][8];
        fill2DArray(board, 8);

        int[] positions = new int[2];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals("q") && isValid(board, i, j)) {
                    positions[0] = i;
                    positions[1] = j;
                }
            }
        }

        //if (isValid(board, 4, 3)) System.out.println("yes");
        System.out.println(Arrays.toString(positions).replace(", ", " ").replaceAll("[\\[\\]]", ""));

    }

    public static void main(String[] args) {
        Lab l = new Lab();
        l.findTheRealQueen();
    }
}

