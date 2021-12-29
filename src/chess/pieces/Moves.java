package chess.pieces;

import chess.board.Board;
import chess.board.Coordinate;

public abstract class Moves {
    Board board;
    Piece pieceInPlay;
    Coordinate expectedMove;

    Moves(Board board, Piece pieceInPlay, Coordinate expectedMove){
        this.board = board;
        this.pieceInPlay = pieceInPlay;
        this.expectedMove = expectedMove;
    }

    public static class normalMove extends Moves{

        public normalMove(Board board, Piece pieceInPlay, Coordinate expectedMove){
            super(board, pieceInPlay, expectedMove);
        }

    }

    public static class kill extends Moves{

        Piece killedPiece;

        public kill(Board board, Piece pieceInPlay, Coordinate expectedMove, Piece killedPiece){
            super(board, pieceInPlay, expectedMove);
            this.killedPiece = killedPiece;
        }
    }
}
