package chess.pieces;

import chess.board.Board;
import chess.board.Coordinate;
import chess.board.Square;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{


    Coordinate Pawn_Offset1 = new Coordinate(0, 1 * multiplier);
    Coordinate Pawn_Offset2 = new Coordinate(0, 2 * multiplier);

    ArrayList<Coordinate> Pawn_Offsets = new ArrayList<>();




    Pawn(Color pieceColor, Coordinate piecePosition) {
        super(pieceColor, piecePosition);
    }

    @Override
    public List<Moves> determinePossibleMoves(Board board) {
        Pawn_Offsets.add(Pawn_Offset1);


        List<Moves> moves = new ArrayList<>();
        for(Coordinate c: Pawn_Offsets){
            int newX = piecePosition.X + c.X;
            int newY = piecePosition.Y + c.Y;
            Coordinate testPoint = new Coordinate(newX, newY);
            if(this.firstMove()){
                if(!Square.b)
            }
            if(pieceColor == Color.BLACK){                 //Pawn can only move forward so switch on black side

            }
            if(this.firstMove()){

            }
        }

        return moves;
    }
}
