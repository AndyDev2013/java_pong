import java.awt.*;

public class Player2
{
	private int y = 200;
	private int yVelocity = 0;
	private int width = 8;
	private int height = 70;

	public Player2()
	{}

	public void update()
	{
		y += yVelocity;
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(430,y,width,height);
	}

	public void setYVelocity(int speed)
	{
		yVelocity = speed;
	}

	public int getX()
	{
		return 430;
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