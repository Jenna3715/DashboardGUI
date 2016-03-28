package display;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import display.weather.WeatherKeeper;

@SuppressWarnings("serial")
public class PanelWeather extends JPanel
{
	private WeatherKeeper wkeep;
	private JTextPane text;
	public PanelWeather()
	{
		this.initialize();
	}
	public PanelWeather(LayoutManager arg0)
	{
		super(arg0);
		this.initialize();
	}
	public PanelWeather(boolean arg0)
	{
		super(arg0);
		this.initialize();
	}
	public PanelWeather(LayoutManager arg0, boolean arg1)
	{
		super(arg0, arg1);
		this.initialize();
	}
	private void initialize()
	{
		wkeep = new WeatherKeeper("KFAR");
		text = new JTextPane();
		text.setBorder(null);
		text.setFont(CommonConsts.FontWeather);
		text.setEditable(false);
		text.setForeground(CommonConsts.COLORfgW);
		text.setBackground(CommonConsts.COLORbgW);
		new Timer(true).scheduleAtFixedRate(
			new TimerTask(){
				public void run(){
					text.setText(wkeep.getTemperture());
				}
			}, CommonConsts.ZERO, CommonConsts.SECOND);
		this.setBackground(java.awt.Color.MAGENTA);
		this.setLayout(new BorderLayout());
		this.add(text, BorderLayout.CENTER);
	}
	@Override
	public void paint(java.awt.Graphics g)
	{
		text.setFont(Dashboard.biggestFont(text));
		super.paint(g);
	}
}