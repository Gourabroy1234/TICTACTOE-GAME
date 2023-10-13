import java.util.*;
 public class LaunchGame
{
	public static void main(String args[])
	{
		TicTacToe t=new TicTacToe();
		HumanPlayer p1=new HumanPlayer("gourab",'X');
		HumanPlayer p2=new HumanPlayer("TAI",'O');
		HumanPlayer cp;
			cp=p1;
			TicTacToe.display();
			while(true)
			{ 
				System.out.println(cp.name + " turn");
				cp.makeMove();
				TicTacToe.display();
				if(TicTacToe.checkColWin() || 
				TicTacToe.checkDiagWin() || 
				TicTacToe.checkRowWin())
				{
					System.out.println(cp.name +" has won");
					break;
				}
				else if(TicTacToe.checkDraw())
				{
					System.out.println("Game is a Draw match");
					break;
				}
				else
				{
					if(cp==p1)
					{
						cp=p2;
					}
					else
					{
						cp=p1;
					}
				}
			}
	}
}
class TicTacToe
{
	static char[][] board;
	public TicTacToe()
	{
		board=new char[3][3];
		initBoard();
	}
	void initBoard()
	{
		for(int i=0;i<board.length;i++)
		{
			for (int j=0;j<board[i].length;j++)
			{
				board[i][j]=' ';
			}
		}
	}
	 static void display()
	{
		
		
		System.out.println("-------------");
		for(int i=0;i<board.length;i++)
		{
			System.out.print("| ");
			for (int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	 static void placeMark(int row,int col,char mark)
	{
		if(row>=0 && row <=2 && col>=0 && col<=2)
		{
		board[row][col]=mark;
		}
		else 
		{
			System.out.println("Invalid Input");
		}
	}
	static boolean checkColWin()
	{
		for(int j=0;j<=2;j++)
		{
			if(board[0][j]==board[1][j] && board[1][j]==board[2][j])
			{
				return true;
			}				
		}
		return false;
	}
	 static boolean checkRowWin()
	{
		for(int i=0;i<=2;i++)
		{
			if(board[i][0]==board[i][1] && 
			board[i][1]==board[i][2]);
			{
				return true;
			}
		}
		return false;
	}
	 static boolean checkDiagWin()
	{
		if( board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	static boolean checkDraw()
	{
		for(int i=0;i<=2;i++)
		{
			for( int j=0;j<=2;j++)
			{
				if(board[i][j]== ' ')
				{
					return false;
				}
			}
		}
		return true;
	}
}
 abstract class Player
{
		String name;
		char mark;
		abstract void makeMove();
		boolean isValiedMove(int row,int col)
	{
		if(row>=0 && row<=2 && 
		col>=0 && col<=2)
		{
			if(TicTacToe.board[row][col]==' ')
			{
				return true;
			}
		}
		return false;
	
	}
}
class HumanPlayer
{
	String name;
	 char mark;
	
	HumanPlayer(String name,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	static void makeMove()
	{
		Scanner sc=new Scanner(System.in);
		int row;
		int col;
		do
		{
			System.out.println("Enter the row and col");
			 row=sc.nextInt();
			 col=sc.nextInt();
		}while(!isValiedMove(row,col));
		TicTacToe.placeMark(row,col,mark);
	}

		static boolean isValiedMove(int row,int col)
	{
		if(row>=0 && row<=2 && 
		col>=0 && col<=2)
		{
			if(TicTacToe.board[row][col]==' ')
			{
				return true;
			}
		}
		return false;
	
	}
	
}
class AIplayer extends Player
{
	String name;
	char mark;
	
	AIplayer(String name,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	 void makeMove()
	{
		int row;
		int col;
		do
		{
			Random r=new Random();
			row=r.nextInt(3);
			col=r.nextInt(3);
			System.out.println(row + col);
		}while(!isValiedMove(row,col));
		TicTacToe.placeMark(row,col,mark);
	}
	
}

	
