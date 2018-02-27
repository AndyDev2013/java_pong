import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;
import javax.sound.sampled.*;
import java.net.URL;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	
	PlayerOne playerOne = new PlayerOne();
	PlayerTwo playerTwo = new PlayerTwo();
	Ball ball = new Ball();

	public int player1Score = 0;
	public int player2Score = 0;

	public GamePanel()
	{
		Timer time = new Timer(45, this);
		time.start();
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	private void update()
	{
		ball.update();
		ball.checkCollisionWith(playerOne,playerTwo);
		newBall();
		playerOne.update();
		playerTwo.update();
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500,500);

		g.setColor(Color.WHITE);
		g.setFont(new Font(null, Font.PLAIN, 30));
		g.drawString("P1: " + player1Score, 50, 30);
		g.drawString("P2: " + player2Score, 370, 30);

		playerOne.paint(g);
		playerTwo.paint(g);
		ball.paint(g);
	}

	public void actionPerformed(ActionEvent e)
	{
		update();
		repaint();
	}

	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			playerOne.setYVelocity(-7);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z)
		{
			playerOne.setYVelocity(+7);
		}

		if(e.getKeyCode() == KeyEvent.VK_P)
		{
			playerTwo.setYVelocity(-7);
		}
		else if(e.getKeyCode() == KeyEvent.VK_L)
		{
			playerTwo.setYVelocity(+7);
		}
	}

	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();

		if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_Z )
		{
			playerOne.setYVelocity(0);
		}

		if(keyCode == KeyEvent.VK_P || keyCode == KeyEvent.VK_L )
		{
			playerTwo.setYVelocity(0);
		}
		
		if(keyCode == KeyEvent.VK_SPACE){
			player1Score = 0;
			player2Score = 0;
			playerOne = new PlayerOne();
			playerTwo = new PlayerTwo();
			ball = new Ball();
		}
	}

	public void keyTyped(KeyEvent e){}

	public void newBall()
	{
		if(ball.destroy)
		{
			if(ball.p1)
			{
				pointSound();
				++player1Score;
			}
			if(ball.p2)
			{
				pointSound();
				++player2Score;
			}

			ball = new Ball();
		}
	}

	public void pointSound()
	{
		try
		{
			 URL url = this.getClass().getClassLoader().getResource("Music/Point.wav");
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