public class Board {
    private static final int length = 15;
    private static final int width = length;
    private static final char[][] grid = new char[length][width];

    public Board() {
        for(int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = ' ';
            }
        }
    }


    public void AddInGrid(int x, int y, char c) {
        grid[y][x] = c;
    }

    public void removeFromGrid(int x, int y) {
        grid[y][x] = ' ';
    }

    public static void limparConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void showBoard(){
        limparConsole();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void showBeatifulBoard(char[][] grid){
        limparConsole();
        //azul
        //final String COR_BORDA = "\033[36m";
        //branco
        //final String COR_BORDA = "";
        //preto
        final String COR_BORDA = "\033[30m";
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
                String Cor_Conteudo = "";
                if(grid[i][j] == Human.getHumanChar()) {
                    Cor_Conteudo = Human.getColor();
                }
                else{
                    Cor_Conteudo = Zombie.getColor();
                }

                System.out.print(Cor_Conteudo + grid[i][j] + RESET);
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