package ExamPreparation.Retake10April2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EscapeMaze {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static void fill2DArray(char[][] matrix, int rows) throws IOException {
        for (int i = 0; i < rows; i++) {
            String temp = reader.readLine();
            matrix[i] = temp.toCharArray();
        }
    }

    private static int[] getCord(char[][] airspace) {
        int[] cords = new int[2];
        for (int i = 0; i < airspace.length; i++) {
            for (int j = 0; j < airspace[0].length; j++) {
                if (airspace[i][j] == ('P')) {
                    airspace[i][j] = '-';
                    cords[0] = i;
                    cords[1] = j;
                }
            }
        }

        return cords;
    }

    private static int countEnemies(char[][] airspace) {
        int count = 0;
        for (char[] row : airspace) {
            for (char col : row) {
                if (col == 'M') {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValidPos(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i > n - 1 || j > m - 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(reader.readLine());
        char[][] maze = new char[n][];

        fill2DArray(maze, n);

        int[] cords = getCord(maze);
        int trRow = cords[0];
        int trCol = cords[1];

        int armour = 100;

        boolean isDown = false;

        while (true) {
            if (armour <= 0) {
                isDown = true;
                break;
            }

            String command = reader.readLine();

            if (command.equals("up") && isValidPos(trRow - 1, trCol, n, n)) {
                trRow -= 1;
            }
            else if (command.equals("down") && isValidPos(trRow + 1, trCol, n, n)) {
                trRow += 1;
            }
            else if (command.equals("right") && isValidPos(trRow, trCol + 1, n, n)) {
                trCol++;
            }
            else if (command.equals("left") && isValidPos(trRow, trCol - 1, n, n)) {
                trCol--;
            }

            if (maze[trRow][trCol] == 'H') {
                if (armour < 100) {
                    if (armour + 15 < 100) armour += 15;
                    else armour = 100;
                }
                maze[trRow][trCol] = '-';
            }
            else if (maze[trRow][trCol] == 'M') {
                armour -= 40;
                if (armour > 0) {
                    maze[trRow][trCol] = '-';
                }
            }
            else if (maze[trRow][trCol] == 'X') {
                break;
            }

            //airspace[jetRow][jetCol] = 'J';
            //System.out.println(Arrays.deepToString(airspace).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
        }

        if (isDown) {
            System.out.println("Player is dead. Maze over!");
        }
        else {
            System.out.println("Player escaped the maze. Danger passed!");
        }
        if (armour < 0) armour = 0;
        System.out.println("Player's health: "+armour+" units");
        maze[trRow][trCol] = 'P';
        System.out.println(Arrays.deepToString(maze).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));

    }
}
