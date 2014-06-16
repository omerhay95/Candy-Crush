package game;

import javax.swing.ImageIcon;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class ColorBomb extends Candy
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public ColorBomb(Candy[][] board, int row, int column){
		super(board, row, column);
		this.setIcon(new ImageIcon("./src/pictures/pictures/Colorbomb.png"));
		
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void accept(Visitor visitor) {
		// TODO implement me	
	}
	 
	public void visit(Candy candy) {
		// TODO implement me	
	}
	@Override
	public boolean visit(RegularCandy candy) {
		return true;
		
	}
	@Override
	public boolean visit(StripedCandy candy) {
		return true;
		
	}
	@Override
	public boolean visit(WrappedCandy candy) {
		return true;
		
	}
	@Override
	public boolean visit(ColorBomb candy) {
		return true;	
	}
	
	@Override
	protected void crush(int color) { //need to check what to do about inheritance
		super.crush();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j].color==color)
					board[i][j].crush();

			}
		}
	}
}

