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

}

