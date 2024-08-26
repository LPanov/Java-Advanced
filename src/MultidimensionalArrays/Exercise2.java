package MultidimensionalArrays;

import java.util.*;

public class Exercise2 {
    Scanner sc = new Scanner(System.in);
    private boolean isInRange(int dRow, int dCol, int rows, int cols, int entrance) {
        return dRow >= 0 && dRow < rows && dCol >= 1 && dCol < cols && entrance >= 0 && entrance < rows;
    }
    private int closestFree(int row, int col, boolean[][] matrix) {
        int dist1 = 0;
        int index1 = 0;
        int dist2 = 0;
        int index2 = 0;

        for (int i = col-1; i > 0; i--) {
            dist1++;
            if (!matrix[row][i]) {
                index1 = i;
                break;
            }
        }
        for (int i = col+1; i < matrix[0].length; i++) {
            dist2++;
            if (!matrix[row][i]) {
                index2 = i;
                break;
            }
        }
        if (index1 == 0) return index2;
        else if (index2 == 0) return index1;
        else if (dist1 < dist2) {
            return index1;
        }
        else if (dist2 < dist1) {
            return index2;
        }
        else {
            return index1;
        }
    }
    public void parkingSystem() {
        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        boolean[][] parking = new boolean[rows][cols];

        String command = sc.nextLine();
        while (!command.equals("stop")) {
            int[] token = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entrance = token[0];
            int dRow = token[1];
            int dCol = token[2];
            int count = 0;

            if (isInRange(dRow, dCol, rows, cols, entrance)) {
                if (dRow > entrance) {
                    for (int i = entrance; i <= dRow; i++) {
                        count++;
                    }
                } else  if (dRow < entrance) {
                    for (int i = entrance; i >= dRow; i--) {
                        count++;
                    }
                } else {
                    count++;
                }

                if (!parking[dRow][dCol]) {
                    for (int i = 1; i <= dCol; i++) {
                        count++;
                        parking[dRow][dCol] = true;
                    }
                    System.out.println(count);
                } else {
                    int index = closestFree(dRow, dCol, parking);

                    if (index == 0) {
                        System.out.println("Row " + dRow + " full");
                    } else {
                        parking[dRow][index] = true;
                        count += index;
                        System.out.println(count);
                    }
                }
            }
            //System.out.println(Arrays.deepToString(parking).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));

            command = sc.nextLine();
        }
    }
    private boolean isValidPos(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i > n - 1 || j > m - 1) {
            return false;
        }
        return true;
    }
    private void fill2DArray(char[][] matrix, int rows) {
        for (int i = 0; i < rows; i++) {
            String temp = sc.nextLine();
            matrix[i] = temp.toCharArray();
        }

    }
    private int[] getPlayer (char[][] matrix) {
        int[] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'P') {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        return position;
    }

    private char[][] multiplyBunnies(char[][] matrix) {
        char[][] temp = new char[matrix.length][matrix[0].length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (temp[i][j] != 'B') temp[i][j] = '.';
                if (matrix[i][j] == 'B') {
                    temp[i][j] = 'B';
                    if (isValidPos(i, j - 1, matrix.length, matrix[0].length)) temp[i][j-1] = 'B';
                    if (isValidPos(i, j + 1, matrix.length, matrix[0].length)) temp[i][j+1] = 'B';
                    if (isValidPos(i - 1, j, matrix.length, matrix[0].length)) temp[i - 1][j] = 'B';
                    if (isValidPos(i + 1, j, matrix.length, matrix[0].length)) temp[i + 1][j] = 'B';
                }
            }
        }
        //System.out.println(Arrays.deepToString(temp).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));

        return temp;
    }
    public void radioactiveMutantVampireBunnies() {
        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        char[][] lair = new char[rows][cols];

        fill2DArray(lair, rows);

        String commands = sc.nextLine();
        int playerRow = getPlayer(lair)[0];
        int playerCol = getPlayer(lair)[1];

        for (char c : commands.toCharArray()) {
            if (c == 'U') {
                playerRow--;
                if (playerRow < 0) {
                    lair = multiplyBunnies(lair);
                    //fillProper(lair);
                    System.out.println(Arrays.deepToString(lair).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));
                    System.out.println("won: " + "0 " + playerCol);
                    break;
                }
            }
            else if (c == 'D') {
                playerRow++;
                if (playerRow == lair.length) {
                    lair = multiplyBunnies(lair);
                    //fillProper(lair);
                    System.out.println(Arrays.deepToString(lair).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));
                    System.out.println("won: " + rows + " " + playerCol);
                    break;
                }
            }
            else if (c == 'R') {
                playerCol++;
                if (playerCol == cols) {
                    lair = multiplyBunnies(lair);
                    //fillProper(lair);
                    System.out.println(Arrays.deepToString(lair).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));
                    System.out.println("won: " + cols + " " + playerCol);
                    break;
                }
            }
            else if (c == 'L') {
                playerCol--;
                if (playerCol < 0) {
                    lair = multiplyBunnies(lair);
                    //fillProper(lair);
                    System.out.println(Arrays.deepToString(lair).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));
                    System.out.println("won: " + playerRow + " " + 0);
                    break;
                }
            }

            if (lair[playerRow][playerCol] == 'B') {
                lair = multiplyBunnies(lair);
                //fillProper(lair);
                System.out.println(Arrays.deepToString(lair).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));
                System.out.println("dead: " + playerRow + " " + playerCol);
                break;
            }

            //System.out.println(Arrays.deepToString(lair).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));

            lair = multiplyBunnies(lair);
            //System.out.println(Arrays.deepToString(lair).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));

            if (lair[playerRow][playerCol] == 'B') {
                //fillProper(lair);
                System.out.println(Arrays.deepToString(lair).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));
                System.out.println("dead: " + playerRow + " " + playerCol);
                break;
            }
        }
    }

    private void fill2DArray(int[][] matrix, int rows) {
        for (int i = 0; i < rows; i++) {
            int[] temp = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = temp;
        }
    }
    public void reverseMatrixDiagonals() {
        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];
        fill2DArray(matrix, rows);

        int row = rows - 1;
        int col = cols - 1;

        while (row >= 0) {
            int r = row;
            int c = col;

            while (r >= 0 && c < cols) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col < 0) {
                col = 0;
                 row--;
            }


        }
    }

    private void fill2DArray(String[][] matrix, int rows) {
        for (int i = 0; i < rows; i++) {
            String[] temp = sc.nextLine().split("\\s+");

            matrix[i] = temp;
        }
    }

    private void fill(String[][] matrix, int row, int col, String fillChar, String startChar) {
        if (!matrix[row][col].equals(startChar)) {
            return; // recursion current path ends when char at current position is not startChar
        }

        matrix[row][col] = fillChar;

        if (row + 1 < matrix.length) { // up
            fill(matrix, row + 1, col, fillChar, startChar); // recursion
        }

        if (row - 1 >= 0) { // down
            fill(matrix, row - 1, col, fillChar, startChar); // recursion
        }

        if (col + 1 < matrix[row].length) { // left
            fill(matrix, row, col + 1, fillChar, startChar); // recursion
        }

        if (col - 1 >= 0) { // right
            fill(matrix, row, col - 1, fillChar, startChar); // recursion
        }
    }
     public void theMatrix() {
        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String[rows][cols];

        fill2DArray(matrix, rows);

        //System.out.println(Arrays.deepToString(matrix).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));

        String fillChar = sc.nextLine();
        int[] fillingData = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rowFill = fillingData[0];
        int colFill = fillingData[1];
        String startChar = matrix[rowFill][colFill];

        fill(matrix, rowFill, colFill, fillChar, startChar);
        System.out.println(Arrays.deepToString(matrix).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));

    }

    public static void main(String[] args) {
        Exercise2 e = new Exercise2();
        e.theMatrix();
    }
}
