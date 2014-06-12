package game;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public  interface Visitor 
{
	
	
	public boolean visit(RegularCandy candy) ;
	public boolean visit(StripedCandy candy) ;
	public boolean visit(WrappedCandy candy) ;
	public boolean visit(ColorBomb candy) ;

	
}

