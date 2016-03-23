package display.clock;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import display.Dashboard;

@SuppressWarnings("serial")
public class PanelClock extends JPanel
{
	private TimeKeeper datetime;
	private JTextPane text;
	public PanelClock()
	{
		this.initialize();
	}
	public PanelClock(LayoutManager arg0)
	{
		super(arg0);
		this.initialize();
	}
	public PanelClock(boolean arg0)
	{
		super(arg0);
		this.initialize();
	}
	public PanelClock(LayoutManager arg0, boolean arg1)
	{
		super(arg0, arg1);
		this.initialize();
	}
	private void initialize()
	{
		datetime = new TimeKeeper();
		text = new JTextPane();
		text.setBorder(null);
		new Timer(true).scheduleAtFixedRate(
			new TimerTask(){
				public void run(){
					text.setText(datetime.getTimeShort());
				}
			}, (long)0, (long)1000);
		this.setBackground(java.awt.Color.MAGENTA);
		this.setLayout(new BorderLayout());
		this.add(text, BorderLayout.CENTER);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void paint(java.awt.Graphics g)
	{
		text.setFont(Dashboard.biggestFont(text));
		super.paint(g);
	}
}
