package dashboard.display;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.util.Timer;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import dashboard.CommonConsts;
import dashboard.display.weather.WeatherKeeper;

@SuppressWarnings("serial")
public class PanelWeather extends JPanel implements Destroyable
{
	private WeatherKeeper wkeep;
	private JTextPane text;
	private Timer textupdater;
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
		textupdater=new Timer(true);
		textupdater.scheduleAtFixedRate(
			new TimerTaskThread(new Runnable(){
				public void run(){
					text.setText(wkeep.getTemperture());
				}
			}), CommonConsts.ZERO, CommonConsts.SECOND);
		this.setBackground(java.awt.Color.MAGENTA);
		this.setLayout(new BorderLayout());
		this.add(text, BorderLayout.CENTER);
	}
	@Override
	public void paint(java.awt.Graphics g)
	{
		text.setFont(CommonConsts.biggestFont(text));
		super.paint(g);
	}
	@Override
	public void destroy()
	{
		textupdater.cancel();
		wkeep.destroy();
	}
	
}