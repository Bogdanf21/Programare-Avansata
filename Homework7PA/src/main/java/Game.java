import GameObjects.Bag;
import GameObjects.Board;
import MockDictionary.MockDictionary;

import java.util.*;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() {
        for (Player player : players) {
           Thread playerThread = new Thread(player);
            playerThread.start();
        }
    }
    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
