package frames;

import javax.swing.*;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public MainFrame()
	{
		init(new MainMenu(this));
	}
	
	public void init(JPanel panel)
	{
		this.setContentPane(panel);
		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		setVisible(true);
	}
}
