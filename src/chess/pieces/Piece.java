package chess.pieces;

import chess.board.Board;
import chess.board.Coordinate;

import java.util.Set;

public abstract class Piece {
    protected Color pieceColor;
    protected Coordinate piecePosition;

    Piece(Color pieceColor, Coordinate piecePosition){
        this.pieceColor = pieceColor;
        this.piecePosition = piecePosition;
    }

    public abstract Set<Moves> determinePossibleMoves(Board board);
}
