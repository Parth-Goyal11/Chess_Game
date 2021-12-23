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

    public abstract List<Moves> determinePossibleMoves(Board board);
}
