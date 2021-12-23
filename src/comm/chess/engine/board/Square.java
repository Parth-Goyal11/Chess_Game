package comm.chess.engine.board;

import comm.chess.engine.pieces.Piece;

public abstract class Square{
    int X;
    int Y;


    Square(Coordinate position){                       //Set a square as a position
        this.X = position.X;
        this.Y = position.Y;
    }

    public abstract boolean tileFull();

    public abstract Piece getPiece();

    public static final class blankSquare extends Square{   //Function Behavior for an empty square

        blankSquare(Coordinate position){
            super(position);
        }

        @Override
        public boolean tileFull() {                  //Return an empty tile on a blank space
            return false;
        }

        @Override
        public Piece getPiece() {                  //Return null for the value of piece on an empty square
            return null;
        }
    }

    public static final class occupiedSquare extends Square{    //Function Behavior for an Occupied Square

        Piece currentPiece;

        occupiedSquare(Coordinate position, Piece currentPiece){
            super(position);
            this.currentPiece = currentPiece;
        }

        @Override
        public boolean tileFull(){
            return true;
        }

        @Override
        public Piece getPiece(){
            return this.currentPiece;
        }
    }


}
