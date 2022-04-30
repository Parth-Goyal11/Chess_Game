package chess.pieces;

import chess.board.Board;
import chess.board.Coordinate;
import chess.board.Square;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    Coordinate King_Offset1 = new Coordinate(1, 0);
    Coordinate King_Offset2 = new Coordinate(1, 1);
    Coordinate King_Offset3 = new Coordinate(1, -1);
    Coordinate King_Offset4 = new Coordinate(0, 1);
    Coordinate King_Offset5 = new Coordinate(0, -1);
    Coordinate King_Offset6 = new Coordinate(-1, 0);
    Coordinate King_Offset7 = new Coordinate(-1, 1);
    Coordinate King_Offset8 = new Coordinate(-1, -1);

    Coordinate [] King_Offsets = {King_Offset1, King_Offset2, King_Offset3, King_Offset4, King_Offset5
    , King_Offset6, King_Offset7, King_Offset8};

    King(Color pieceColor, Coordinate piecePosition) {
        super(pieceColor, piecePosition);
    }

    @Override
    public List<Moves> determinePossibleMoves(Board board){

        List<Moves> moves = new ArrayList<>();

        for(Coordinate c : King_Offsets){
            int newX = piecePosition.X += c.X;
            int newY = piecePosition.Y += c.Y;

            Coordinate testPoint = new Coordinate(newX, newY);
            if(board.isValidPoint(testPoint)){

                Square boardPoint = board.retSquare(testPoint);
                if(!boardPoint.tileFull()){
                    moves.add(new Moves.normalMove(board, this, testPoint));
                }else{
                    Piece occupyingPiece = boardPoint.getPiece();
                    Color occupyingPieceColor = occupyingPiece.getColor();

                    if(occupyingPieceColor != pieceColor){
                        moves.add(new Moves.kill(board, this, testPoint, occupyingPiece));
                    }
                }


            }
        }
        return moves;

    }


}
