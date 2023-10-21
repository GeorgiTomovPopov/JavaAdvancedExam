import java.util.Scanner;

public class Fishing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        fillMatrix(matrix, scanner);
        int[] coords = findShipCoords(matrix);
        int shipRow = coords[0];
        int shipCol = coords[1];
        matrix[shipRow][shipCol] = '-';
        int caughtFish = 0;

        String command = scanner.nextLine();

        while (!"collect the nets".equals(command)) {
            switch (command) {
                case "up":
                    if (checkOutOfBounds(matrix, shipRow - 1, shipCol)) {
                        if (matrix[shipRow - 1][shipCol] == 'W') {
                            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", (shipRow - 1), shipCol);
                            shipRow = shipRow - 1;
                            return;
                        } else if (Character.isDigit(matrix[shipRow - 1][shipCol])) {
                            caughtFish += Integer.parseInt(String.valueOf(matrix[shipRow - 1][shipCol]));
                            matrix[shipRow - 1][shipCol] = '-';
                            shipRow = shipRow - 1;
                        } else {
                            shipRow = shipRow - 1;
                        }
                    } else {
                        if (matrix[matrix.length - 1][shipCol] == 'W') {
                            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", (matrix.length - 1), shipCol);
                            shipRow = matrix.length - 1;
                            return;
                        } else if (Character.isDigit(matrix[matrix.length - 1][shipCol])) {
                            caughtFish += Integer.parseInt(String.valueOf(matrix[matrix.length - 1][shipCol]));
                            matrix[matrix.length - 1][shipCol] = '-';
                            shipRow = matrix.length - 1;
                        } else {
                            shipRow = matrix.length - 1;
                        }
                    }
                    break;
                case "down":
                    if (checkOutOfBounds(matrix, shipRow + 1, shipCol)) {
                        if (matrix[shipRow + 1][shipCol] == 'W') {
                            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", (shipRow + 1), shipCol);
                            shipRow = shipRow + 1;
                            return;
                        } else if (Character.isDigit(matrix[shipRow + 1][shipCol])) {
                            caughtFish += Integer.parseInt(String.valueOf(matrix[shipRow + 1][shipCol]));
                            matrix[shipRow + 1][shipCol] = '-';
                            shipRow = shipRow + 1;
                        } else {
                            shipRow = shipRow + 1;
                        }
                    } else {
                        if (matrix[0][shipCol] == 'W') {
                            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", 0, shipCol);
                            shipRow = 0;
                            return;
                        } else if (Character.isDigit(matrix[0][shipCol])) {
                            caughtFish += Integer.parseInt(String.valueOf(matrix[0][shipCol]));
                            matrix[0][shipCol] = '-';
                            shipRow = 0;
                        } else {
                            shipRow = 0;
                        }
                    }
                    break;
                case "left":
                    if (checkOutOfBounds(matrix, shipRow, shipCol - 1)) {
                        if (matrix[shipRow][shipCol - 1] == 'W') {
                            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", shipRow, (shipCol - 1));
                            shipCol = shipCol - 1;
                            return;
                        } else if (Character.isDigit(matrix[shipRow][shipCol - 1])) {
                            caughtFish += Integer.parseInt(String.valueOf(matrix[shipRow][shipCol - 1]));
                            matrix[shipRow][shipCol - 1] = '-';
                            shipCol = shipCol - 1;
                        } else {
                            shipCol = shipCol - 1;
                        }
                    } else {
                        if (matrix[shipRow][matrix[shipRow].length - 1] == 'W') {
                            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", shipRow, (matrix[shipRow].length - 1));
                            shipCol = matrix[shipRow].length - 1;
                            return;
                        } else if (Character.isDigit(matrix[shipRow][matrix[shipRow].length - 1])) {
                            caughtFish += Integer.parseInt(String.valueOf(matrix[shipRow][matrix[shipRow].length - 1]));
                            matrix[shipRow][matrix[shipRow].length - 1] = '-';
                            shipCol = matrix[shipRow].length - 1;
                        } else {
                            shipCol = matrix[shipRow].length - 1;
                        }
                    }
                    break;
                case "right":
                    if (checkOutOfBounds(matrix, shipRow, shipCol + 1)) {
                        if (matrix[shipRow][shipCol + 1] == 'W') {
                            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", shipRow, (shipCol + 1));
                            shipCol = shipCol + 1;
                            return;
                        } else if (Character.isDigit(matrix[shipRow][shipCol + 1])) {
                            caughtFish += Integer.parseInt(String.valueOf(matrix[shipRow][shipCol + 1]));
                            matrix[shipRow][shipCol + 1] = '-';
                            shipCol = shipCol + 1;
                        } else {
                            shipCol = shipCol + 1;
                        }
                    } else {
                        if (matrix[shipRow][0] == 'W') {
                            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", shipRow, 0);
                            shipCol = 0;
                            return;
                        } else if (Character.isDigit(matrix[shipRow][0])) {
                            caughtFish += Integer.parseInt(String.valueOf(matrix[shipRow][0]));
                            matrix[shipRow][0] = '-';
                            shipCol = 0;
                        } else {
                            shipCol = 0;
                        }
                    }
                    break;

            }


            command = scanner.nextLine();
        }


//        if (caughtFish >= 20) {
//            System.out.println("Success! You managed to reach the quota!");
//            System.out.printf("Amount of fish caught: %d tons.\n", caughtFish);
//        } else if (caughtFish > 0) {
//            System.out.printf("You didn't catch enough fish and didn't reach the quota! " +
//                    "You need %d tons of fish more.\n", (20 - caughtFish));
//            System.out.printf("Amount of fish caught: %d tons.\n", caughtFish);
//        }

        if (caughtFish >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.\n", (20 - caughtFish));
        }

        if(caughtFish > 0){
            System.out.printf("Amount of fish caught: %d tons.\n", caughtFish);
        }

        matrix[shipRow][shipCol] = 'S';
        printMatrix(matrix);


    }


    private static int[] findShipCoords(char[][] board) {
        int[] coords = new int[2];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char currentChar = board[row][col];


                if (currentChar == 'S') {
                    coords[0] = row;
                    coords[1] = col;
                }
            }
        }
        return coords;
    }

    private static boolean checkOutOfBounds(char[][] matrix, int futureRow, int futureCol) {

        return futureRow >= 0 && futureRow < matrix.length && futureCol >= 0 & futureCol < matrix[futureRow].length;
    }

    private static void fillMatrix(char[][] matrix, Scanner s) {
        for (int row = 0; row < matrix.length; row++) {
            char[] rowData = s.nextLine().toCharArray();
            matrix[row] = rowData;
        }
    }

    private static void printMatrix(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }
}
