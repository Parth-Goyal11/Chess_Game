package chess.pieces;

import chess.board.Board;
import chess.board.Coordinate;
import chess.board.Square;
import chess.pieces.Moves.*;

import java.util.ArrayList;
import java.util.List;

import static chess.board.Square.Num_Columns;
import static chess.board.Square.Num_Rows;

public class Bishop extends Piece{
        //The Bishop can Move Diagonally in Four Different Ways
        Coordinate Bishop_Offset1 = new Coordinate(1, 1);
        Coordinate Bishop_Offset2 = new Coordinate(1, -1);
        Coordinate Bishop_Offset3 = new Coordinate(-1, 1);
        Coordinate Bishop_Offset4 = new Coordinate(-1, -1);

        public Coordinate[] Bishop_Offsets = {Bishop_Offset1, Bishop_Offset2, Bishop_Offset3, Bishop_Offset4};


    Bishop(Color pieceColor, Coordinate piecePosition) {
        super(pieceColor, piecePosition);
    }

    @Override
    public List<Moves> determinePossibleMoves(Board board) {

        List<Moves> moves = new ArrayList<Moves>();

        for(Coordinate c: Bishop_Offsets){
            Coordinate currentPosition = this.piecePosition;

            while(board.isValidPoint(currentPosition)){    //Bishop can move diagonally until move is no longer valid

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
