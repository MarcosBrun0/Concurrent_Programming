public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        char[][] grid = board.getGrid();


        //Add Zombies in the bottom of the grid
//        for (int i = grid.length -1 ; i > grid.length - 2 ; i--) {
//            for (int j = 0; j < grid[0].length; j++) {
//                Zombie zombie = new Zombie(board,i,j);
//                board.AddInGrid(i,j,'Ø');
//                zombie.run();
//            }
//        }

        Zombie zombie = new Zombie(board,5,9);
        zombie.run();







    }
}