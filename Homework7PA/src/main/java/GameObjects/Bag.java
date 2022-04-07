package GameObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Bag {
    private final ArrayList<TileGroup> letters;
    public Bag() {
        Random random = new Random();
        letters = new ArrayList<>();
        for (char c = 'a'; c < 'z'; c++) {
          letters.add(new TileGroup(new Tile(c, random.nextInt(100)), random.nextInt(10)));
        }

    }
    public synchronized List<Tile> extractTiles(int howMany) {


        List<Tile> extracted = new ArrayList<>();
        Random random = new Random();
        int positionToBeExtracted;
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            positionToBeExtracted = random.nextInt(letters.size());
            TileGroup tileGroup = letters.get(positionToBeExtracted);
            if(tileGroup.canTakeTile() == true)
            {
                extracted.add(tileGroup.getTile());
                tileGroup.takeTile();
            }
        }
        return extracted;
    }

    protected class TileGroup{
       final Tile tile;
       int howMany;
       TileGroup(Tile tile, int howMany)
       {
           this.tile = tile;
           this.howMany = howMany;
       }
       public boolean canTakeTile()
       {
           if(howMany <= 0) return false;
            return true;
       }
       public void takeTile()
       {
           howMany--;
       }

        public Tile getTile() {
            return tile;
        }

        public int getHowMany() {
            return howMany;
        }

        public void setHowMany(int howMany) {
            this.howMany = howMany;
        }
    }
}