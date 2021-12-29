package chess.board;

public class Board {

    public Square retSquare(Coordinate squareCoordinate){
        return null;
    }

    public boolean isValidPoint(Coordinate point){
        if(point.X < 8 && point.X >= 0 && point.Y < 8 && point.Y >= 0){
            return true;
        }else{
            return false;
        }
    }
}
