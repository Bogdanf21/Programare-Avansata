package GameObjects;

public class Tile {
private final char letter;
private final int points;

Tile(char letter,int points)
{
this.letter = letter;
this.points = points;
}

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tile{");
        sb.append("letter=").append(letter);
        sb.append(", points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}

