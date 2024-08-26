package MultidimensionalArrays;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {
    Scanner sc = new Scanner(System.in);

    private void fillPatternA(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            if (i > 0) matrix[i][0] = matrix[i-1][0] + 1;
            for (int j = 0; j < size; j++) {
                if (i == 0 && j == 0) matrix[i][j] = 1;
                else if (j != 0){
                    matrix[i][j] = matrix[i][j-1] + size;
                }
            }
        }
    }
    private void fillPatternB(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            if (i > 0) matrix[0][i] = matrix[size-1][i-1] + size;
            for (int j = 0; j < size; j++) {
                if (i == 0 && j == 0) matrix[j][i] = 1;
                else if (j != 0) {
                    if (i % 2 != 0) {
                        matrix[j][i] = matrix[j-1][i] - 1;
                    }
                    else {
                        matrix[j][i] = matrix[j-1][i] + 1;
                    }
                }
            }
        }
    }

    public void fillTheMatrix() {
        String[] input = sc.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            fillPatternA(matrix, size);
        } else {
            fillPatternB(matrix, size);
        }

        System.out.println(Arrays.deepToString(matrix).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));

    }

    public void matrixOfPalindrome() {
        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int r = input[0];
        int c = input[1];
        String[][] palindromeMatrix = new String[r][c];
        int start = 97;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                StringBuilder palindrome = new StringBuilder(3);
                char firstLast = (char) (start + i);
                char middle = (char) (start + j + i);
                palindrome.append(firstLast);
                palindrome.append(middle);
                palindrome.append(firstLast);

                palindromeMatrix[i][j] = String.valueOf(palindrome);
            }
        }

        System.out.println(Arrays.deepToString(palindromeMatrix).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
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

    public void diagonalDifference() {
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];

        fill2DArray(matrix, n);

        int[] firstDiagonal = new int[n];
        int[] secondDiagonal = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) firstDiagonal[j] = matrix[i][j];
                if (i+j == n - 1) secondDiagonal[j] = matrix[i][j];
            }
        }
        int sum1 = Arrays.stream(firstDiagonal).sum();
        int sum2 = Arrays.stream(secondDiagonal).sum();

        System.out.println(Math.abs(sum1-sum2));
    }

    private List<int[][]> getBiggest(int[][] matrix) {
        List<int[][]> matrices = new ArrayList<>();

        for (int l = 0; l < matrix.length - 2; l++) {
            for (int k = 0; k < matrix[0].length-2; k++) {
                int[][] sample = new int[3][3];
                for (int i = l; i < l+3; i++) {
                    for (int j = k; j < k+3; j++) {
                        sample[i-l][j-k] = matrix[i][j];
                    }
                }

                matrices.add(sample);
            }
        }

        return matrices;
    }
    public void maximalSum() {
        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int r = input[0];
        int c = input[1];
        int[][] matrix = new int[r][c];

        fill2DArray(matrix, r);

        int max = 0;
        int[][] biggest = new int[3][3];
        for (int[][] m : getBiggest(matrix)) {
            //System.out.println(Arrays.deepToString(m).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
            int sum = Arrays.stream(m).flatMapToInt(Arrays::stream).sum();
            if (sum > max) {
                max = sum;
                biggest = m;
            }
        }

        System.out.println("Sum = " + max);
        System.out.println(Arrays.deepToString(biggest).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
    }

    private boolean isValidPos(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i > n - 1 || j > m - 1) {
            return false;
        }
        return true;
    }
    public void matrixShuffling() {
        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int r = input[0];
        int c = input[1];
        String[][] matrix = new String[r][c];

        fill2DArray(matrix, r);

        while (true) {
            String[] t = sc.nextLine().split("\\s+");
            if (t[0].equals("END")) break;

            if (t[0].equals("swap") && t.length == 5) {
                int i1 = Integer.parseInt(t[1]);
                int j1 = Integer.parseInt(t[2]);
                int i2 = Integer.parseInt(t[3]);
                int j2 = Integer.parseInt(t[4]);
                if (isValidPos(i1, j1, r, c) && isValidPos(i2, j2, r, c)) {
                    String temp = matrix[i1][j1];
                    matrix[i1][j1] = matrix[i2][j2];
                    matrix[i2][j2] = temp;
                    System.out.println(Arrays.deepToString(matrix).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private int longest(List<String> matrix) {
        int longest = 0;
        for (String s : matrix) {
            if (s.length() > longest) {
                longest = s.length();
            }
        }
        return longest;
    }
    public void stringMatrixRotation() {
        String regex = "Rotate\\((?<angle>\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        String rotation = sc.nextLine();

        Matcher matcher = pattern.matcher(rotation);
        int angle = 0;
        while (matcher.find()) {
            angle = Integer.parseInt(matcher.group("angle"));
        }

        List<String> strings = new ArrayList<>();

        while (true) {
            String s = sc.nextLine();
            if (s.equals("END")) break;

            strings.add(s);
        }

        char[][] matrix = new char[strings.size()][longest(strings)];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                try {
                    matrix[i][j] = strings.get(i).toCharArray()[j];
                } catch (ArrayIndexOutOfBoundsException e) {
                    matrix[i][j] = ' ';
                }
            }
        }

        char[][] rotated = new char[longest(strings)][strings.size()];
        int countRotations = angle/90;
        for (int rotations = 0; rotations < countRotations; rotations++) {
            if (rotations%2 == 0) {
                for (int i = 0; i < matrix[0].length; i++) {
                    int k = matrix.length-1;
                    for (int j = 0; j < matrix.length; j++) {
                        rotated[i][j] = matrix[k][i];
                        k--;
                    }
                }
            }
            else {
                for (int i = 0; i < matrix.length; i++) {
                    int k = matrix[0].length - 1;
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = rotated[k][i];
                        k--;
                    }
                }
            }
        }

        if (countRotations % 2 == 0) {
            System.out.println(Arrays.deepToString(matrix).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));
        } else {
            System.out.println(Arrays.deepToString(rotated).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));
        }


        //System.out.println(Arrays.deepToString(matrix).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
    public void crossfire() {
        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        List<List<Integer>> matrix = new ArrayList<>();

        int count = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }

        String command = sc.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] tokens = command.split("\\s+"); // 3 4 1
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]); //индексът на елемента в листа
            int radius = Integer.parseInt(tokens[2]);

            //destroy up, down
            for (int currentRow = row - radius; currentRow <= row + radius ; currentRow++) {
                if(isInMatrix(currentRow, col, matrix) && currentRow!=row) { //валидираме реда от който ще вземем
                    matrix.get(currentRow).remove(col);
                }
            }

            //destroy left. right
            for (int currentColumn = col + radius; currentColumn >=  col - radius; currentColumn--) {
                if(isInMatrix(row, currentColumn, matrix)) { //валидираме колоната от който ще вземем
                    matrix.get(row).remove(currentColumn);
                }
            }

            matrix.removeIf(List::isEmpty);
            command = sc.nextLine();
        }

        matrix.forEach(m -> {
            m.forEach(e -> System.out.print(e + " "));
            System.out.println();
        });
    }
    private boolean isWall(int moveCell) {
        return moveCell < 0 || moveCell >= 15;
    }

    private boolean isInDamageArea(int targetRow, int targetCol, int moveRow, int moveCol) {
        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1)
                && (targetCol - 1 <= moveCol && moveCol <= targetCol + 1));
    }
    public void theHeiganDance() {
        int playerRow = 7;
        int playerCol = 7;

        int playerHP = 18500;
        double heiganHP = 3000000;
        double playerDamage = Double.parseDouble(sc.nextLine());
        String lastSpell = "";
        while (true) {
            if (playerHP >= 0) {
                heiganHP -= playerDamage;
            }
            if (lastSpell.equals("Cloud")) {
                playerHP -= 3500;
            }
            if (heiganHP <= 0 || playerHP <= 0) {
                break;
            }
            String[] input = sc.nextLine().split(" ");

            String currentSpell = input[0];
            int targetRow = Integer.parseInt(input[1]);
            int targetCol = Integer.parseInt(input[2]);

            if (isInDamageArea(targetRow, targetCol, playerRow, playerCol)) {
                if (!isInDamageArea(targetRow, targetCol, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {
                    playerRow--;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol + 1) && !isWall(playerCol + 1)) {
                    playerCol++;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow + 1, playerCol) && !isWall(playerRow + 1)) {
                    playerRow++;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol - 1) && !isWall(playerCol - 1)) {
                    playerCol--;
                    lastSpell = "";
                } else {
                    if (currentSpell.equals("Cloud")) {
                        playerHP -= 3500;
                        lastSpell = "Cloud";
                    } else if (currentSpell.equals("Eruption")) {
                        playerHP -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }

        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String heiganState = heiganHP <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", heiganHP);
        String playerState = playerHP <= 0 ? String.format("Player: Killed by %s", lastSpell) :
                String.format("Player: %d", playerHP);
        String playerEndCoordinates = String.format("Final position: %d, %d", playerRow, playerCol);

        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);
    }

    public static void main(String[] args) {
        Exercises e = new Exercises();
        e.theHeiganDance();
    }
}
