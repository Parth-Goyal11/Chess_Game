package comm.chess.engine.board;

public class Coordinate {     //Use coordinates up to [64, 64] to show a unique coordinate for each square
    int X;
    int Y;
    Coordinate(int X, int Y){
        this.X = X;
        this.Y = Y;
    }
}
