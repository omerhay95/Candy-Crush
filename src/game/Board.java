package game;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements  ActionListener {
	
	
	private final int SIZE = 9;
	private Candy[][] candies = new Candy[SIZE][SIZE];
	private static boolean firstMove=true;
	private static Candy other;
	
	
	public Board(){
		setLayout(new BorderLayout(0, 0));
		initCandies();
		toGUI();
		
		
	}
	
	//private Candy createCandy(){
	//	Candy candy = new RegularCandy();
	//}
	private void toGUI() {
		
		removeAll();
		setLayout(new GridLayout(SIZE, SIZE, 10, 10));
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.add(candies[i][j]);
				candies[i][j].setText(candies[i][j].row+","+candies[i][j].col);
			}
		}
		
		this.revalidate();
		repaint();
	}
	
	private void initCandies(){
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				candies[i][j] = new RegularCandy(candies, i, j);
				candies[i][j].addActionListener(this);
			}
		}
		
		
		candies[1][3]=new RegularCandy(candies, 1, 3,1);
		candies[1][3].addActionListener(this);

		candies[3][3]=new RegularCandy(candies, 3, 3,1);
		candies[3][3].addActionListener(this);

		candies[4][3]=new RegularCandy(candies, 4, 3,1);
		candies[4][3].addActionListener(this);

		candies[5][3]=new RegularCandy(candies, 5, 3,1);
		candies[5][3].addActionListener(this);

		candies[6][3]=new RegularCandy(candies,6, 3,1);
		candies[6][3].addActionListener(this);
		
		
		
	}

	public void updateBoard(Candy[][] board){
		this.candies=deepCopyMat(board);
		toGUI();
	}
	
	
	private Candy[][] deepCopyMat(Candy[][]m){
		if(m==null)
			return null;
		Candy[][]res=new Candy[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				res[i][j]=m[i][j];
			}
		}
//		for (int i = 0; i < SIZE; i++) {
//			res[i]=m[i].clone();
//		}
		return res;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()  instanceof Candy){
			Candy candy = (Candy)(e.getSource());
			if(firstMove)
			{
				other = candy;
				//candy.setLocation(0, 0);
				firstMove=false;
				
			}
			else{
				if(candy.isNext(other)){
					candy.combine(other);
					
					
					firstMove=true;
				}
				else{
					other = candy;
					//candy.setLocation(0, 0);
					firstMove=false;
				}
			}
			
			this.updateBoard(candy.getBoard());
		}
		
	
		
	}
}

