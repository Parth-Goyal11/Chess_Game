package chess.pieces;

import chess.board.Board;
import chess.board.Coordinate;

import java.util.Set;

public class Knight extends Piece{

    Knight(Color pieceColor, Coordinate piecePosition) {
        super(pieceColor, piecePosition);
    }

    @Override
    public Set<Moves> determinePossibleMoves(Board board) {
        return null;
    }
}
