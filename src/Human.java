import java.util.Random;

public class Human extends Thread{
    private char HumanChar = '☺';
    private Board board;
    private int x,y;
    private String color = "\033[34m";



    public void run() {
        while (true) {
            move();
            board.showBeatifulBoard(board.getGrid(), "\033[0m");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
    private void move() {
        char[][] grid = board.getGrid();
        Random random = new Random();
        int randomValue = random.nextInt(3) - 1;
        int newX =  this.x + randomValue;
        int newY = this.y - 1;

        if(grid[newX][newY] == ' '){
            board.removeFromGrid(this.x, this.y);
            this.x = newX;
            this.y = newY;
            board.AddInGrid(this.x, this.y, zombiechar);
        }


    }
}