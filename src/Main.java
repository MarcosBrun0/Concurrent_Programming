public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board();
        char[][] grid = board.getGrid();
        int i,j;

for(i = 0; i< grid.length; i++){    
        //add zombies

            Zombie zombie = new Zombie(board,board.getLength()-1,i);
            zombie.start();

            Human human = new Human(board,0,i);
            human.start();


}

while (true){
    //Board.showBeatifulBoard(grid);
    Board.showBoard();
    Thread.sleep(50);
}






    }
}