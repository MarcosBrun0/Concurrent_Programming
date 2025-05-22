import java.util.Random;
import java.util.concurrent.Semaphore;

public class Zombie extends Thread{
    private Board board;
    private int x,y;


    private static char zombiechar = 'Ø';
    private static String color = "\033[31m";
    private Semaphore lock = new Semaphore(1);

    public Zombie(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
        board.AddInGrid(x,y,zombiechar);
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        Zombie.color = color;
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
        int randomValue2 = random.nextInt(3) - 1;
        int newX =  this.x + randomValue;
        int newY = this.y + randomValue2;
        //System.out.println("("+newX + "," + newY+")");
        if(newX < board.getLength() && newX >= 0  && newY < board.getLength() && newY >= 0) {
            //semaforo add
            try {
                lock.acquire();
            if(grid[newX][newY] == ' ') {
                board.removeFromGrid(this.x, this.y);
                this.x = newX;
                this.y = newY;
                board.AddInGrid(this.x, this.y, zombiechar);
            }

           } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                lock.release();
            }


        }

    }
    public static char getZombiechar() {
        return zombiechar;
    }


}


