import GameObjects.Tile;

import java.util.List;

public class Player implements Runnable {

    private String name;
    private Game game;
    private boolean running;

    public Player(String name) {
        this.name = name;
    }

    private boolean submitWord()
    {
        List<Tile> extracted = game.getBag().extractTiles(7);
        return false;
    }


    @Override
    public void run() {
        System.out.println("Player " + this.name + " " + Thread.currentThread().getName());

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}


