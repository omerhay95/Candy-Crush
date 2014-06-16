package game;

import javax.swing.ImageIcon;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class StripedCandy extends Candy
{
	private boolean isVertical;
	
	public StripedCandy(Candy[][] board, int row, int column, int color,boolean isVertical){
		super(board, row, column,color);
		
		String text;
		if(isVertical)
			text="Vertical";
		else {
			text="Horizontal";
		}
		
		this.setIcon(new ImageIcon("./src/pictures/pictures/"+text+COLORS.get(color)+".png"));
		this.isVertical=isVertical;
//		this.setText(row+", "+col);
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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void visit(Candy candy) {
		// TODO implement me	
	}
	
	protected void crush() {
		super.crush();
		int i = 0;
		if (isVertical) {
			while (i < board.length) {
				if(board[i][col].transform != -10 && board[i][col].transform != -1)
				board[i][col].crush();
				i++;
			}
		} else {
			while (i < board.length) {
				if(board[row][i].transform != -10 && board[row][i].transform != -1)
				board[row][i].crush();
				i++;
			}
		}
	}


	@Override
	public boolean visit(RegularCandy candy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(StripedCandy candy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(WrappedCandy candy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(ColorBomb candy) {
		// TODO Auto-generated method stub
		return false;
	}

}

