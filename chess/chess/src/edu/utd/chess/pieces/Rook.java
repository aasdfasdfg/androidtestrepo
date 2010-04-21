package edu.utd.chess.pieces;

import edu.utd.chess.board.ChessCoords;
import edu.utd.chess.exceptions.IllegalMoveException;
import edu.utd.chess.exceptions.InvalidCoordsException;

public class Rook extends ChessPiece {

    public Rook(String alignment, ChessCoords location) {
        super(alignment, location);
    }
    
    /**
     * Rooks can move forward, backward and sideways
     * any number of spaces, but not diagonally.
     */
    @Override
    public void validateMove(ChessCoords coords) 
        throws
            InvalidCoordsException,
            IllegalMoveException
    {
        super.validateMove(coords);
        //can only move forward, backward, or
        //sideways, not diagonally
        if (!coords.column.toUpperCase().equals(
              this.location.column.toUpperCase()) 
                && coords.row != this.location.row)
        {
           throw new IllegalMoveException();
        }
    }
}
