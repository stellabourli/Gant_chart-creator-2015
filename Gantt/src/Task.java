import java.util.ArrayList;

public class Task {
	private String name;
	private int initialDate;
	private int finalDate;
	private int duration;
	private double cost;
	private String situation;
	private String text;
	private boolean upoergasia=false;
	private String suname;
	ArrayList<String> preoccupancy = new ArrayList<String>();
	ArrayList<String> upoergasies = new ArrayList<String>();
	
	public Task(String name,int initialDate,int finalDate, double cost,String situation,String text)
	{
		this.name = name;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.cost = cost;
		this.situation = situation;
		this.text = text;
		this.duration = finalDate-initialDate;
	}
	
	public String getName()
	{
		return name;
	}
	public int getInitialDate()
	{
		return initialDate;
	}
	 public int getFinalDate()
	 {
		 return finalDate;
	 }
	 public String getSituation()
	 {
		 return situation;
	 }
	 public double getCost()
	 {
		 return cost;
	 }
	
	 public String getText()
	 {
		 return text;
	 }
	  public ArrayList<String> getPreoccupancy()
	 {
		 return preoccupancy;
	 }
	 public ArrayList<String> getUpoergasies()
	 {
		 return upoergasies;
	 }
	 public boolean getUpoergasia()
	 {
		 return upoergasia;
	 }
	 public String getSuname()
	 {
		 return suname;
	 }
	 public void setUpoergasia(boolean upoergasia)
	 {
		 this.upoergasia=upoergasia;
	 }
	 public void setSuname(String suname)
	 {
		 this.suname=suname;
	 }
	 public void setName(String name)
	 {
		 this.name=name;
	 }
	 public void setInitialDate(int initialDate)
	 {
		 this.initialDate=initialDate;
	 }
	 public void setFinalDate(int finalDate)
	 {
		 this.finalDate=finalDate;
	 }
	 public void setCost(double cost)
	 {
		 this.cost=cost;
	 }
	public void setSituation(String situation)
	{
		this.situation=situation;
	}
	public void setText(String text)
	{
		this.text=text;
	}
	public void setDuration(int duration)
	{
		this.duration=duration;
	}
	public void addP(String nam)
	{
		preoccupancy.add(nam);
	}
	public void addYp(String n)
	{
		upoergasies.add(n);
	}
}