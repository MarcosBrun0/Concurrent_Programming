public class Board {
    private final int length = 20;
    private final int width = length;
    private final char[][] grid = new char[length][width];

    public Board() {
        for(int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = ' ';
            }
        }
    }


    public void AddInGrid(int x, int y, char c) {
        grid[x][y] = c;
    }

    public void removeFromGrid(int x, int y) {
        grid[x][y] = ' ';
    }

    public static void limparConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void showBoard(){
        limparConsole();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void showBeatifulBoard(char[][] grid, String Cor_Conteudo){
        limparConsole();
        final String COR_BORDA = "\033[36m";
        final String RESET = "\033[0m";

        int rows = grid.length;
        int colums = grid[0].length;
        //borda superior
        System.out.print(COR_BORDA + "┌");
        for (int i = 0; i<colums;i++) {
            System.out.print("───");
            if (i < colums - 1) {
                System.out.print("┬");
            }
        }
        System.out.print("┐" + RESET);

        for (int i = 0; i<rows;i++) {
            System.out.println();
            System.out.print(COR_BORDA + "│ ");
            for (int j = 0; j < colums; j++) {
                System.out.print(Cor_Conteudo + grid[j][i] + RESET);
                System.out.print(COR_BORDA + " │ ");

            }
            System.out.println(RESET);

            if (i < rows - 1) {
                System.out.print(COR_BORDA + "├");

                for (int j = 0; j < colums; j++) {
                    System.out.print("───");
                    if (j < colums - 1) {
                        System.out.print("┼");
                    }
                }
                System.out.print("┤" + RESET);
            }
        }
        //borda inferior
        System.out.print(COR_BORDA + "└");
        for (int i = 0; i<colums;i++){
            System.out.print("───");
            if (i < colums - 1) System.out.print("┴");
        }

        System.out.println("┘");
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getLength() {
        return length;
    }
}