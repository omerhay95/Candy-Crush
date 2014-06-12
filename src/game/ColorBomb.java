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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void visit(Candy candy) {
		// TODO implement me	
	}
	@Override
	public boolean visit(RegularCandy candy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean visit(StripedCandy candy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean visit(WrappedCandy candy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean visit(ColorBomb candy) {
		// TODO Auto-generated method stub
		
	}
}

