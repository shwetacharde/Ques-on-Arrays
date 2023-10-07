class Solution {
    private List<Integer> spiralOrder;
    private String direction;
    private final String RIGHT = "right";
    private final String LEFT = "left";
    private final String DOWN = "down";
    private final String UP = "up";
    public List<Integer> spiralOrder(int[][] matrix) {
        spiralOrder = new ArrayList<>();
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        direction = RIGHT;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 101) {
                    formOrder(i, j, matrix, rowSize, colSize);
                }
            }
        }
        return spiralOrder;
    }

    private void formOrder(int row, int col, int matrix[][], int rowSize, int colSize) {
        if (!canMove(row, col, rowSize, colSize)) {
            getNextDirection();
            return;
        }
//        System.out.print(row +":"+col);
//        System.out.println();
        if (matrix[row][col] == 101) {
            getNextDirection();
            return;
        }
        spiralOrder.add(matrix[row][col]);
        matrix[row][col] = 101;

        if (direction.equals(RIGHT))
            formOrder(row, col+1, matrix, rowSize, colSize);
        if (direction.equals(DOWN))
            formOrder(row+1, col, matrix, rowSize, colSize);
        if (direction.equals(LEFT))
            formOrder(row, col-1, matrix, rowSize, colSize);
        if (direction.equals(UP))
            formOrder(row-1, col, matrix, rowSize, colSize);
    }
    private void getNextDirection() {
        if (direction.equals(RIGHT))
            direction = DOWN;
        else if (direction.equals(DOWN))
            direction = LEFT;
        else if (direction.equals(LEFT)) {
            direction = UP;
        }
        else {
            direction = RIGHT;
        }
    }

    private boolean canMove(int row, int col, int rowSize, int colSize) {
        return (row >=0 && row < rowSize) && (col >=0 && col < colSize);
    }
}
