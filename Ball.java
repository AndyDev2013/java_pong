import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.*;
import java.net.URL;

public class Ball
{
	private int SIZE = 8;
	private int SPEED = 7;
	private int xVelocity = -SPEED;
	private int yVelocity = SPEED;
	public int x = 250;
	public int y = 250;

	public boolean destroy = false;

	public boolean p1 = false;
	public boolean p2 = false;

	public void update()
	{
		x += xVelocity;
		y += yVelocity;

		if(x < 1)
		{
			xVelocity = SPEED;
			p2 = true;
			destroy = true;
		}
		else if(x > 495)
		{
			xVelocity = -SPEED;
			p1 = true;
			destroy = true;
		}

		if(y < 0)
		{
			yVelocity = SPEED;
			wallSound();
		}
		else if(y + SIZE > 470)
		{
			yVelocity = -SPEED;
			wallSound();
		}

	}

	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(x,y, SIZE, SIZE);
	}

	private void reverseBallDirection()
	{
		xVelocity  = -xVelocity;
	}

	public void checkCollisionWith(Player player,Player2 player2)
	{
		if(this.x > player.getX() && this.x < player.getX() + player.getWidth()) // top left of ball is greater than top left of player
		{
			if(this.y > player.getY() && this.y < player.getY()  + player.getHeight())
			{
				paddleSound();
				reverseBallDirection();
			}
		}

		if(this.x > player2.getX() && this.x < player2.getX() + player2.getWidth()) // top left of ball is greater than top left of player
		{
			if(this.y > player2.getY() && this.y < player2.getY()  + player2.getHeight())
			{
				paddleSound();
				reverseBallDirection();
			}
		}

	} // If the ball touches the bounds of the paddle


	public void paddleSound()
	{
		try
		{
			 URL url = this.getClass().getClassLoader().getResource("Music/Paddle.wav");
			 AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

			 Clip clip = AudioSystem.getClip();

			 clip.open(audioIn);
			 clip.stop();
			 clip.start();
		}
		catch (UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
		}
	}

	public void wallSound()
	{
		try
		{
			 URL url = this.getClass().getClassLoader().getResource("Music/Wall.wav");
			 AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

			 Clip clip = AudioSystem.getClip();

			 clip.open(audioIn);
			 clip.stop();
			 clip.start();
		}
		catch (UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
		}

	}
}
