package RegularExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BombHasBeenPlanted {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static boolean isValidPos(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i > n - 1 || j > m - 1) {
            return false;
        }
        return true;
    }
    private static int[] getCord(char[][] airspace) {
        int[] cords = new int[2];
        for (int i = 0; i < airspace.length; i++) {
            for (int j = 0; j < airspace[0].length; j++) {
                if (airspace[i][j] == ('C')) {
                    airspace[i][j] = '*';
                    cords[0] = i;
                    cords[1] = j;
                }
            }
        }

        return cords;
    }
    private static void fill2DArray(char[][] matrix, int rows) throws IOException {
        for (int i = 0; i < rows; i++) {
            String temp = reader.readLine();
            matrix[i] = temp.toCharArray();
        }
    }

    public static void main(String[] args) throws IOException{
        int[] nM = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int n = nM[0];
        int m = nM[1];
        char[][] maze = new char[n][m];

        fill2DArray(maze, n);

        int[] cTcords = getCord(maze);
        int cTrow = cTcords[0];
        int cTcol = cTcords[1];

        int[] startingCords = cTcords;

        int counter = 0;
        boolean isDefused = false;
        boolean isKilled = false;

        while (counter < 16) {
            String command = reader.readLine();

            if (command.equals("up")) {
                if (isValidPos(cTrow - 1, cTcol, n, m)) {
                    cTrow -= 1;
                }
                counter++;
            }
            else if (command.equals("down")) {
                if (isValidPos(cTrow + 1, cTcol, n, m)) {
                    cTrow += 1;
                }
                counter++;
            }
            else if (command.equals("right") ) {
                if (isValidPos(cTrow, cTcol + 1, n, m)) {
                    cTcol += 1;
                }
                counter++;
            }
            else if (command.equals("left")) {
                if (isValidPos(cTrow, cTcol - 1, n, m)) {
                    cTcol -= 1;
                }
                counter++;
            }

            if (maze[cTrow][cTcol] == 'T') {
                maze[cTrow][cTcol] = '*';
                isKilled = true;
                break;
            }

            if (command.equals("defuse")) {
                if (maze[cTrow][cTcol] == 'B') {
                    if (counter + 4 <= 16) {
                        maze[cTrow][cTcol] = 'D';
                        isDefused = true;
                        counter += 4;
                        break;
                    }
                    else {
                        maze[cTrow][cTcol] = 'X';
                        counter += 4;
                        break;
                    }
                }
                else {
                    counter += 2;
                }

            }

            //System.out.println(counter);
        }

        if (isDefused) {
            System.out.println("Counter-terrorist wins!");
            System.out.println("Bomb has been defused: " + (16 - counter) + " second/s remaining.");
        }
        else {
            if (isKilled) {
                System.out.println("Terrorists win!");
            }
            else {
                System.out.println("Terrorists win!");
                System.out.println("Bomb was not defused successfully!");
                System.out.println("Time needed: "+(counter - 16)+" second/s.");
            }
        }

        maze[startingCords[0]][startingCords[1]] = 'C';
        System.out.println(Arrays.deepToString(maze).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));


    }
}
