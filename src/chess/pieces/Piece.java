package chess.pieces;

import chess.board.Board;
import chess.board.Coordinate;

import java.util.List;
import java.util.Set;

public abstract class Piece {
    protected Color pieceColor;
    protected Coordinate piecePosition;

    Piece(Color pieceColor, Coordinate piecePosition){
        this.pieceColor = pieceColor;
        this.piecePosition = piecePosition;
    }

    public Color getColor(){
        return pieceColor;
    }

    public boolean firstMove(){
        boolean firstMove;
        if(pieceColor == Color.BLACK && piecePosition.Y == 7 || pieceColor == Color.WHITE && piecePosition.Y == 2){
            firstMove = true;
        }else{
            firstMove = false;
        }
        return firstMove;
    }

    public abstract List<Moves> determinePossibleMoves(Board board);
}
