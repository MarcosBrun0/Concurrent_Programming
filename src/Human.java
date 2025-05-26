import java.util.Random;
import java.util.concurrent.Semaphore;

public class Human extends Thread{
    private static char HumanChar = '☺';
    private Board board;
    private int x,y;
    private static String color = "\033[34m";
    private Boolean running = true;
    private final int sleeptimeMS = 200;
    private Semaphore lock = new Semaphore(1);

    public static String getColor() {
        return color;
    }

    public static char getHumanChar() {
        return HumanChar;
    }

    public Human(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
        board.AddInGrid(x,y,HumanChar);
    }

    public void run() {
        while (running) {
            move();
            checarMordida();
            checkwin();
            try {
                Thread.sleep(sleeptimeMS);
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
        if(newX < board.getLength() && newX >= 0  && newY < board.getLength() && newY >= 0) {
            try {
                lock.acquire();
                if(grid[newX][newY] == ' ') {
                    board.removeFromGrid(this.x, this.y);
                    this.x = newX;
                    this.y = newY;
                    board.AddInGrid(this.x, this.y, HumanChar);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                lock.release();
            }

        }


    }


    public void checkwin(){
        if (this.x == board.getLength()-1){
            System.out.println("HUMAN WINS!!!");
            System.exit(0);
        }
    }

    private void checarMordida(){

        //
        if(x < board.getLength()-1) {
            try {
                lock.acquire();
                char[][] grid = board.getGrid();
                if (grid[y][x + 1] == Zombie.getZombiechar()) {
                    board.removeFromGrid(this.x, this.y);
                    //System.out.println("[+1 zombie]");
                    Zombie newZombie = new Zombie(board, x, y);
                    newZombie.start();
                    running = false;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.release();
            }
        }


    }


    public void setRunning(Boolean running) {
        this.running = running;
    }
}



