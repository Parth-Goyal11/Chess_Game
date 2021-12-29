package chess.pieces;

import chess.board.Board;
import chess.board.Coordinate;

import java.util.ArrayList;
import java.util.List;

import static chess.board.Square.Num_Columns;
import static chess.board.Square.Num_Rows;
import chess.board.Board.*;
import chess.board.Square;
import chess.pieces.Moves.*;

public class Rook extends Piece{

    Coordinate Rook_Offset1 = new Coordinate(0, 1);
    Coordinate Rook_Offset2 = new Coordinate(1, 0);
    Coordinate Rook_Offset3 = new Coordinate(0, -1);
    Coordinate Rook_Offset4 = new Coordinate(-1, 0);

    Coordinate[] Rook_Offsets = {Rook_Offset1, Rook_Offset2, Rook_Offset3, Rook_Offset4};


    Rook(Color pieceColor, Coordinate piecePosition) {
        super(pieceColor, piecePosition);
    }

    @Override
    public List<Moves> determinePossibleMoves(Board board) {
        List<Moves> moves = new ArrayList<>();

        for(Coordinate c: Rook_Offsets){
            Coordinate currentPosition = this.piecePosition;

            while(board.isValidPoint(currentPosition)){
                currentPosition.X += c.X;
                currentPosition.Y += c.Y;
                if(board.isValidPoint(currentPosition)){
                    Square boardPoint = board.retSquare(currentPosition);

                    if(!boardPoint.tileFull()){
                        moves.add(new normalMove(board, this, currentPosition));
                    }else{
                        Piece occupyingPiece = boardPoint.getPiece();
                        Color occupyingPieceColor = occupyingPiece.getColor();

                        if(pieceColor != occupyingPieceColor){
                            moves.add(new kill(board, this, currentPosition, occupyingPiece));
                        }
                    }
                    break;
                }

            }
        }



        return moves;
    }
}
