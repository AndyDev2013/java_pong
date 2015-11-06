import javax.swing.JFrame;

public class Pong extends JFrame
{
	private static final long serialVersionUID = 1L;

	public Pong()
	{
		setTitle("Andy's Pong Game");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new GamePanel());							
		setVisible(true);				
	}

	public static void main(String [] args)
	{
		new Pong();
		System.out.print("Player one controls A = UP Z = Down \n");
		System.out.print("Player two controls P = UP L = Down \n");
	}
}