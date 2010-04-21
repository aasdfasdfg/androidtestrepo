package edu.utd.chess.pieces;

import edu.utd.chess.board.ChessCoords;
import edu.utd.chess.exceptions.CoordsOccupiedException;
import edu.utd.chess.exceptions.IllegalMoveException;
import edu.utd.chess.exceptions.InvalidCoordsException;

/**
 * The pawn chess piece.
 * @author troy
 *
 */
public class Pawn extends ChessPiece {
	private boolean firstMove = true; 
	
	public Pawn(String alignment, ChessCoords location) {
		super(alignment, location);
	}
	

	@Override
	public void validateMove(ChessCoords coords) 
	    throws
	        InvalidCoordsException,
	        IllegalMoveException
	{	    
	    super.validateMove(coords);
		//pawns can only move straight ahead
	    if (this.location.column != coords.column) {
	        //TODO : a pawn can move diagonally only if it's capturing
	        //another piece.  Implement this.
	        //TODO : add more logic here, can only be diff by 1,
	        //and only if the target coord is occupied by an enemy
	        //need to decide how we'll implement capture first
	        throw new IllegalMoveException();
	    }
	    //can't move backwards
	    if (coords.row < this.location.row) {
	        throw new IllegalMoveException();
	    }
	    //can't move more than 2 ahead on first move, or 
	    //more than 1 ahead on any subsequent moves
		if (firstMove 
		        ? coords.row - this.location.row > 2
		        : coords.row - this.location.row > 1)
		{
		    throw new IllegalMoveException();
		}
	}

	/**
	 * Calls super.moveTo(), and sets a state variable
	 * to indicate that this Pawn has moved at least once
	 * (since Pawns can only move two spaces on their 
	 * first move). 
	 */
	@Override
	public void moveTo(ChessCoords newLocation)
	    throws
	        InvalidCoordsException,
	        CoordsOccupiedException,
	        IllegalMoveException
	{
	    super.moveTo(newLocation);
	    firstMove = false;
	}
	
}
