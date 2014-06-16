package game;




public class WrappedCandy extends Candy
{
	
	public WrappedCandy(){
		super();
	}
	
	
	public void accept(Visitor visitor) {
		// TODO implement me	
	}
	
	
	
	public void visit(Candy candy) {
		// TODO implement me	
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
	
	@Override
	protected void crush() {
		
		
		int newRow = this.row - 1;
		int newcol = this.col - 1;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(board[newRow + i][newRow + j]!=null)//if it is within the board
					board[newRow + i][newRow + j].crush();
			}
		}
		
		this.setTransform(this.transform==3 ? 10: -1);
		
	}

}

