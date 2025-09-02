public class MazeSolver {
    static int [][] maze = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}
    };
   
    static int[][] solution = new int[4][4];
   
    /**
     * Resuelve el laberinto desde la posicion x y
     * @param x fila 
     * @param y columna 
     * @return true si se busca hasta la salida
     */
    public static boolean solve(int x, int y) {
        if (x == 3 && y == 3) {
            solution[x][y] = 1;
            return true;
        }
       
        if (isSafe(x, y)) {
            solution[x][y] = 1;
           
            if (solve(x + 1, y)) {
                return true;
            }
           
            if (solve(x, y + 1)) {
                return true;
            }
           
            solution[x][y] = 0;
        }
       
        return false;
    }
   
    /**
     * Verifica si la posición (x, y) está dentro del laberinto
     * y es un camino válido (valor 1 en maze).
     *
     * @param x fila a verificar
     * @param y columna a verificar
     * @return true si es seguro moverse a (x, y)
     */
    static boolean isSafe(int x, int y) {
        return x >= 0 && y >= 0 &&
               x < 4 && y < 4 &&
               maze[x][y] == 1;
    }
   

    static void printSolution() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (solution[i][j] == 1) {
                    System.out.print("1 ");
                } else {
                    System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
   
    public static void main(String[] args) {
        if (solve(0, 0)) {
            System.out.println("Imprimir solución:");
            printSolution();
        } else {
            System.out.println("No encontré el camino");
        }
    }
}
