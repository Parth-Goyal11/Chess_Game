package chess.pieces;

import chess.board.Board;
import chess.board.Coordinate;
import chess.board.Square;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{


    Coordinate Pawn_Offset1 = new Coordinate(0, 1);
    Coordinate Pawn_Offset2 = new Coordinate(0, 2);
    Coordinate Pawn_Offset3 = new Coordinate(1, 1);
    Coordinate Pawn_Offset4 = new Coordinate(-1, 1);

    ArrayList<Coordinate> Pawn_Offsets = new ArrayList<>();




    Pawn(Color pieceColor, Coordinate piecePosition) {
        super(pieceColor, piecePosition);
    }

    @Override
    public List<Moves> determinePossibleMoves(Board board) {
        Pawn_Offsets.add(Pawn_Offset1);
        Pawn_Offsets.add(Pawn_Offset2);
        Pawn_Offsets.add(Pawn_Offset3);
        Pawn_Offsets.add(Pawn_Offset4);
        int multiplier = 0;


        List<Moves> moves = new ArrayList<>();
        for(Coordinate c: Pawn_Offsets){
            if(pieceColor == Color.BLACK){
                multiplier = -1;
            }else if(pieceColor == Color.WHITE){
                multiplier = 1;
            }

            c.X *= multiplier;
            c.Y *= multiplier;

            int newX = piecePosition.X + c.X;
            int newY = piecePosition.Y + c.Y;
            Coordinate testPoint = new Coordinate(newX, newY);
            if(board.isValidPoint(testPoint)){
                Square boardPoint = board.retSquare(testPoint);

                if(!boardPoint.tileFull() && c.X == 0 && c.Y !=2){ //non diagonal-single square move
                    moves.add(new Moves.normalMove(board, this, testPoint));
                }else if(!boardPoint.tileFull() && testPoint.Y == 2){
                    if(pieceColor == Color.WHITE){
                        Coordinate behindDestination = new Coordinate(testPoint.X, testPoint.Y-1);
                        Square testBehind = board.retSquare(behindDestination);
                        if(!testBehind.tileFull()){
                            moves.add(new Moves.normalMove(board, this, testPoint));
                        }
                    }else{
                        Coordinate behindDestination = new Coordinate(testPoint.X, testPoint.Y+1);
                        Square testBehind = board.retSquare(behindDestination);
                        if(!testBehind.tileFull()){
                            moves.add(new Moves.normalMove(board, this, testPoint));
                        }
                    }
                }else if(c.X == 1 || c.X == -1){
                    if(boardPoint.tileFull()){
                        Piece occupyingPiece = boardPoint.getPiece();
                        if(this.pieceColor != occupyingPiece.pieceColor){
                            moves.add(new Moves.kill(board, this, testPoint, occupyingPiece));
                        }
                    }
                }
            }


        }

        return moves;
    }
}
