package frames;

import java.io.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;

public class MainMenu extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1;
	
	private BufferedImage background;
	private MainFrame parent;

	private JButton singlePlayer, multiPlayer, settings, exit;
	
	public MainMenu(MainFrame parent)
	{
		super(new GridBagLayout());
		
		try 
		{
			background = ImageIO.read(new File("images/background.jpg"));
		} catch (IOException e) 
		{
			System.out.println("IOException beim Laden des Hintergrundbildes");
			e.printStackTrace();
			System.exit(1);
		}
		
		this.parent = parent;
		
		GridBagConstraints cont = new GridBagConstraints();
		
		cont.fill = GridBagConstraints.BOTH;
		cont.ipadx = 100;
		cont.ipady = 20;
		
		singlePlayer = new JButton("Singelplayer");
		cont.gridx = 0;
		cont.gridy = 0;
		add(singlePlayer, cont);
		
		multiPlayer = new JButton("Multiplayer");
		cont.gridx = 0;
		cont.gridy = 1;
		add(multiPlayer, cont);
		
		settings = new JButton("Settings");
		cont.gridx = 0;
		cont.gridy = 2;
		add(settings, cont);
		
		exit = new JButton("Exit");
		cont.gridx = 0;
		cont.gridy = 3;
		add(exit, cont);
		
		settings.addActionListener(this);
		exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == settings)
			parent.init(new SettingsMenu(parent));
		else if(event.getSource() == exit)
			System.exit(0);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}
}