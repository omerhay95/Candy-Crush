package game;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class RegularCandy extends Candy {

	public RegularCandy(Candy[][] board, int row, int column) {
		super(board, row, column);
		this.setIcon(new ImageIcon("./src/pictures/pictures/"
				+ COLORS.get(color) + ".png"));
		this.setText(row + ", " + col);
	}

	public RegularCandy(Candy[][] board, int row, int column, int color) {
		super(board, row, column, color);
		this.setIcon(new ImageIcon("./src/pictures/pictures/"
				+ COLORS.get(color) + ".png"));
		// this.setText(row+", "+col);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean visit(RegularCandy candy) {
		boolean result = false;
		swap(row, col, candy.row, candy.col);

		int up = this.amountUp(), down = this.amountDown(), left = this
				.amountLeft(), right = this.amountRight();

		if (up + down + 1 >= 5) {// color bomb

			int tempRow = row - up;
			int i = up + down;
			while (i >= 0) {
				this.board[tempRow][col].crush();
				i--;
				tempRow++;
			}
			this.board[row + down][col].setTransform(4);// 4=colorbomb

			result = true;

		} else if (left + right + 1 >= 5) {
			this.board[row][col].setTransform(4);
			int tempCol = col;
			while (left > 0) {
				this.board[row][tempCol - left].crush();
				left--;
			}
			while (right > 0) {
				this.board[row][tempCol + right].crush();
				right--;
			}
			result = true;
		}

		else if (false) {// L or T wrapped candy
		}

		else if (up + down + 1 == 4) {// striped candy
			int type = this.col == candy.col ? 1 : 2;

			int tempRow = row - up;
			int i = up + down;
			while (i >= 0) {
				this.board[tempRow][col].crush();
				i--;
				tempRow++;
			}

			this.board[row + down][col].setTransform(type);
			result = true;

		}

		else if (left + right + 1 == 4) {
			int type = this.col == candy.col ? 1 : 2;
			this.board[row][col].setTransform(type);
			int tempCol = col;
			while (left > 0) {
				this.board[row][tempCol - left].crush();
				left--;
			}
			while (right > 0) {
				this.board[row][tempCol + right].crush();
				right--;
			}
			result = true;
		} else if (up + down + 1 == 3) {// regular

			int tempRow = row - up;
			int i = up + down;
			while (i >= 0) {
				this.board[tempRow][col].crush();

				i--;
				tempRow++;
			}

			result = true;

		}

		else if (left + right + 1 == 3) {
			int tempCol = col;
			while (left >= 0) {
				this.board[row][tempCol - left].crush();
				left--;
			}
			while (right > 0) {
				this.board[row][tempCol + right].crush();
				right--;
			}
			result = true;
		}

//		toBeCrushed();
//		
//		try {
//
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		updateBoard(this.getActionListeners()[0]);
		return result;
	}

	@Override
	protected void crush() {
		super.crush();
	}

	@Override
	public boolean visit(StripedCandy candy) {
		return true;
	}

	@Override
	public boolean visit(WrappedCandy candy) {
		// TODO Auto-generated method stub
		return true;

	}

	@Override
	public boolean visit(ColorBomb candy) {
		// TODO Auto-generated method stub
		return true;

	}

}
