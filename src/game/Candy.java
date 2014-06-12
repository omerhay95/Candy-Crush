package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.Collections; 
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class Candy extends JButton implements Visited, Visitor
{
	
	protected static final Map<Integer, String> COLORS = Collections.unmodifiableMap(new HashMap<Integer, String>() {{
		put(0,"Red");
		put(1,"Orange");
		put(2,"Yellow");
		put(3,"Green");
		put(4,"Blue");
		put(5,"Purple");
	}});
	
	
	protected int color;
	
	
	
	protected int transform = 0;
	/*
	 * Transforms the candy into:
	 * -1 = crush
	 * 0 = no change
	 * 1 = stripe vertical
	 * 2=stripe horizontal
	 * 3= wrapped
	 * 4=color bomb
	 */
	protected Candy[][] board;
	public int row;//IIIIIIIIIIIADIASIDAOSIDA
	public int col;//CHANGE THIS LATER
	String image;
	public Candy(Candy[][] board, int row, int column){
		Random rnd = new Random();
		color = rnd.nextInt(6);
		
		this.board = board;
		this.row = row;
		this.col = column;
	}
	
	public Candy(Candy[][] board, int row, int column,int color){
		Random rnd = new Random();
		this.color =color;
		
		this.board = board;
		this.row = row;
		this.col = column;
	}

	
	public void combine(Candy other) {
			this.accept(other);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Candy[][] getBoard(){
		return board;
	}
	
	protected  void updateBoard(ActionListener listener) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				switch (board[i][j].transform) {
				case -1:
					int newRow=i;
					while(newRow>0){
						this.board[newRow][j]=this.board[newRow-1][j];
						this.board[newRow][j].row=newRow;
						newRow--;
					}
					this.board[0][j]=new RegularCandy(board, 0, j);
					this.board[0][j].addActionListener(listener);
					break;
					
				case 1:
					this.board[i][j]=new StripedCandy(board, i, j,this.board[i][j].color,true);
					this.board[i][j].addActionListener(listener);
					break;
				case 2:
					this.board[i][j]=new StripedCandy(board, i, j,this.board[i][j].color,false);
					this.board[i][j].addActionListener(listener);
					break;
				case 3:
					this.board[i][j]=new WrappedCandy();
					this.board[i][j].addActionListener(listener);
					break;
				case 4:
					this.board[i][j]=new ColorBomb(board, i, j);
					this.board[i][j].addActionListener(listener);
					break;
				default:
					break;
					
				}
				
			}
		}
		resetTransorm();
	}
	
	private void resetTransorm() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				this.board[i][j].setTransform(0);
			}
		}
	}
	
	
	
	protected void crush() {
		transform=-1;
		
	}
	
	protected void setTransform(int tranform) {
		this.transform=tranform;
	}
	protected void moveUp() {
		int newRow= row;
		for(int i=0;i<newRow;i++){
			this.board[i][col]=this.board[i+1][col];
			this.board[i][col].row=i;
			newRow--;
		}
	}
	
	protected int getColor() {
		return color;
	}
	
	//Returns the amount of candies of the same color that are to the right
		protected int amountRight() {
			int amount = 0;
			int newCol = col+1;
			while(newCol<board.length && board[row][newCol].getColor() == this.getColor()){
				amount++;
				newCol++;
			}
			return amount;
		}
		
		//Returns the amount of candies of the same color that are to the left
		protected int amountLeft() {
			int amount = 0;
			int newCol = col-1;
			while(newCol >= 0 && board[row][newCol].getColor() == this.getColor()){
				amount++;
				newCol--;
			}
			return amount;
		}
		
		//Returns the amount of candies of the same color that are below
		protected int amountDown() {
			int amount = 0;
			int newRow = row+1;
			while(newRow < board.length && board[newRow][col].getColor() == this.getColor()){
				amount++;
				newRow++;
			}
			return amount;
		}
		
		//Returns the amount of candies of the same color that are above
				protected int amountUp() {
					int amount = 0;
					int newRow = row-1;
					while(newRow >= 0 && board[newRow][col].getColor() == this.getColor()){
						amount++;
						newRow--;
					}
					return amount;
				}


		

public boolean isNext(Candy other) {
	boolean result=false;
	if(this.row==other.row){
		return Math.abs(this.col-other.col)==1;
	}
	else{
		if(this.col==other.col){
			return Math.abs(this.row-other.row)==1;
		}
	}
	return result;
}
	protected void swap(int fRow,int fCol,int sRow,int sCol) {
		Candy temp=board[fRow][fCol];
		board[fRow][fCol]=board[sRow][sCol];
		
		board[fRow][fCol].row=fRow;
		board[fRow][fCol].col=fCol;
		
		temp.row =sRow;
		temp.col=sCol;
		board[sRow][sCol] =temp;
	}	
	
}

