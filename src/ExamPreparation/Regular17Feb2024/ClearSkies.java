package ExamPreparation.Regular17Feb2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ClearSkies {

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
                if (airspace[i][j] == ('J')) {
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
                if (col == 'E') {
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
        char[][] airspace = new char[n][];

        fill2DArray(airspace, n);

        int[] cords = getCord(airspace);
        int jetRow = cords[0];
        int jetCol = cords[1];

        int armour = 300;

        boolean isDown = false;

        while (true) {
            if (armour <= 0) {
                isDown = true;
                break;
            }

            if (countEnemies(airspace) <= 0) {
                break;
            }

            String command = reader.readLine();

            if (command.equals("up") && isValidPos(jetRow - 1, jetCol, n, n)) {
                jetRow -= 1;
            }
            else if (command.equals("down") && isValidPos(jetRow + 1, jetCol, n, n)) {
                jetRow += 1;
            }
            else if (command.equals("right") && isValidPos(jetRow, jetCol + 1, n, n)) {
                jetCol++;
            }
            else if (command.equals("left") && isValidPos(jetRow, jetCol - 1, n, n)) {
                jetCol--;
            }

            if (airspace[jetRow][jetCol] == 'R') {
                armour = 300;
                airspace[jetRow][jetCol] = '-';
            }
            else if (airspace[jetRow][jetCol] == 'E') {
                if (countEnemies(airspace) > 1) armour -= 100;
                airspace[jetRow][jetCol] = '-';
            }

            //airspace[jetRow][jetCol] = 'J';
            //System.out.println(Arrays.deepToString(airspace).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", " "));
        }

        if (countEnemies(airspace) == 0) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        }
        else if (isDown) {
            System.out.println("Mission failed, your jetfighter was shot down! Last coordinates ["+jetRow+", "+jetCol+"]!");
        }

        airspace[jetRow][jetCol] = 'J';
        System.out.println(Arrays.deepToString(airspace).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));


    }
}
