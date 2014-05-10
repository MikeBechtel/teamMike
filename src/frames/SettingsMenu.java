package frames;

import tools.*;

import java.io.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;

import javax.imageio.*;
import javax.swing.*;

import java.util.*;

public class SettingsMenu extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1;
	
	private ConfigWriter confWriter;

	private BufferedImage background;
	private MainFrame parent;
	
	private JLabel musicLabel, separator;
	private JRadioButton musicButtonOn, musicButtonOff;
	private ButtonGroup musicSel;
	private JButton back;
	
	public SettingsMenu(MainFrame parent)
	{
		super(new GridBagLayout());
		
		try 
		{
			confWriter = new ConfigWriter("config/settings.cfg");
			background = ImageIO.read(new File("images/background.jpg"));
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException beim Erstellen der Settings.cfg");
			e.printStackTrace();
			System.exit(2);
		}
		catch (IOException e) 
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
		
		separator = new JLabel("");
		
		musicLabel = new JLabel("Music:");
		cont.gridx = 0;
		cont.gridy = 2;
		add(musicLabel, cont);
		
		musicButtonOn = new JRadioButton("On");
		musicButtonOn.setBackground(Color.LIGHT_GRAY);
		musicButtonOn.setSelected(true);
		cont.gridx = 1;
		add(musicButtonOn, cont);
		musicButtonOff = new JRadioButton("Off");
		musicButtonOff.setBackground(Color.LIGHT_GRAY);
		cont.gridx = 2;
		add(musicButtonOff, cont);
		
		musicSel = new ButtonGroup();
		musicSel.add(musicButtonOn);
		musicSel.add(musicButtonOff);
		
		cont.gridx = 0;
		cont.gridy = 3;
		add(separator, cont);
		
		back = new JButton("Back");
		cont.gridx = 1;
		cont.gridy = 4;
		add(back, cont);
		
		back.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == back)
		{
			for(Enumeration<AbstractButton> buttons = musicSel.getElements(); buttons.hasMoreElements();)
			{
				AbstractButton curButton = buttons.nextElement();
				
				if(curButton.isSelected())
					confWriter.writeLine("music = " + curButton.getText().toLowerCase());
			}
			
			confWriter.close();
			
			parent.init(new MainMenu(parent));
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(170, 160, 460, 400);
	}
}
