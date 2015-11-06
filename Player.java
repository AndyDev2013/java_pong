import java.awt.Graphics;
import java.awt.Color;

public class Player
{
	private int y = 400;
	private int yVelocity = 0;
	private int width = 8;
	private int height = 70;

	public Player()
	{}

	public void update()
	{
		y += yVelocity;
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(50,y,width,height);
	}

	public void setYVelocity(int speed)
	{
		yVelocity = speed;
	}

	public int getX()
	{
		return 50;
	}

	public int getY()
	{
		return y;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

}
