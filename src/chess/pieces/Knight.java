package chess.pieces;

import chess.board.Board;
import chess.board.Coordinate;
import chess.board.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Knight extends Piece{

    public Coordinate knightOffSet1 = new Coordinate(2, 1);
    Coordinate knightOffset2 = new Coordinate(1, 2);
    Coordinate knightOffset3 = new Coordinate(-2, 1);
    Coordinate knightOffset4 = new Coordinate(-1, 2);
    Coordinate knightOffset5 = new Coordinate(2, -1);
    Coordinate knightOffset6 = new Coordinate(1, -2);
    Coordinate knightOffset7 = new Coordinate(-2, -1);
    Coordinate knightOffset8 = new Coordinate(-1, -2);



    public Coordinate[] Knight_Offsets = {knightOffSet1, knightOffset2, knightOffset3, knightOffset4, knightOffset5,
            knightOffset6, knightOffset7, knightOffset8};
    Knight(Color pieceColor, Coordinate piecePosition) {
        super(pieceColor, piecePosition);
    }

    @Override
    public List<Moves> determinePossibleMoves(Board board) {

        List<Moves> moves = new ArrayList<>();


        for(Coordinate c : Knight_Offsets){
            int newX = piecePosition.X + c.X;
            int newY = piecePosition.Y + c.Y;

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
