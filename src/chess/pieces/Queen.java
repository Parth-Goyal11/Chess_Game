package chess.pieces;

import chess.board.Board;
import chess.board.Board.*;
import chess.board.Coordinate;
import chess.board.Square;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    Coordinate Queen_Offset1 = new Coordinate(1, 1);
    Coordinate Queen_Offset2 = new Coordinate(1, -1);
    Coordinate Queen_Offset3 = new Coordinate(-1, 1);
    Coordinate Queen_Offset4 = new Coordinate(-1, -1);
    Coordinate Queen_Offset5 = new Coordinate(0, 1);
    Coordinate Queen_Offset6 = new Coordinate(1, 0);
    Coordinate Queen_Offset7 = new Coordinate(0, -1);
    Coordinate Queen_Offset8 = new Coordinate(-1, 0);

    public Coordinate[] Queen_Offsets = {Queen_Offset1, Queen_Offset2, Queen_Offset3, Queen_Offset4, Queen_Offset5,
    Queen_Offset6, Queen_Offset7, Queen_Offset8};

    Queen(Color pieceColor, Coordinate piecePosition) {
        super(pieceColor, piecePosition);
    }

    @Override
    public List<Moves> determinePossibleMoves(Board board) {
        List<Moves> moves = new ArrayList<>();
        for(Coordinate c: Queen_Offsets){
            Coordinate currentPosition = this.piecePosition;

            currentPosition.X += c.X;
            currentPosition.Y += c.Y;
            while(board.isValidPoint(currentPosition)){

                currentPosition.X += c.X;
                currentPosition.Y += c.Y;

                if(board.isValidPoint(currentPosition)){

                    Square boardPoint = board.retSquare(currentPosition);

                    if(!boardPoint.tileFull()){
                        moves.add(new Moves.normalMove(board, this, currentPosition));
                    }else{
                        Piece occupyingPiece = boardPoint.getPiece();
                        Color occupyingPieceColor = occupyingPiece.getColor();

                        if(pieceColor != occupyingPieceColor){
                            moves.add(new Moves.kill(board, this, currentPosition, occupyingPiece));
                        }

                    }
                    break;
                }
            }
        }

        return moves;
    }
}
