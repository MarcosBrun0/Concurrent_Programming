import java.util.Random;

public class Zombie extends Thread{
    private Board board;
    private int x,y;
    private char zombiechar = 'Ø';
    private String color = "\033[31m";

    public Zombie(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;

    }

    public void run() {
        while (true) {
            move();
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

    public Board getBoard() {
        return board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getZombiechar() {
        return zombiechar;
    }
}