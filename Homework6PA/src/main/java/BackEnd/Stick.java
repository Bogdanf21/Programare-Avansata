package BackEnd;

import java.util.Objects;

public class Stick {
   private final int node1X;
  private final int node1Y;
  private  final int node2X;
   private final int node2Y;

    public int getNode1X() {
        return node1X;
    }

    public int getNode1Y() {
        return node1Y;
    }

    public int getNode2X() {
        return node2X;
    }

    public int getNode2Y() {
        return node2Y;
    }

    public Stick(int node1X, int node1Y, int node2X, int node2Y) {
        this.node1X = node1X;
        this.node1Y = node1Y;
        this.node2X = node2X;
        this.node2Y = node2Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stick stick = (Stick) o;
        return (node1X == stick.node1X && node1Y == stick.node1Y && node2X == stick.node2X && node2Y == stick.node2Y) ||
                (node1X == stick.node2X && node1Y == stick.node2Y && node1X == stick.node2X && node1Y == stick.node2Y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node1X, node1Y, node2X, node2Y);
    }
}
