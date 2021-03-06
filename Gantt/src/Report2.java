import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;


public class Report2 extends Report
{
	private int max;
	private boolean found=false;
	private int h=1;
	private int z=1;
	private int min=100000000;
	private int projectDuration;
	private double projectCost;
	private String header;
	String myArray[][];
	int t;
	public void printRow(String[] row) 
	{
			for (String i : row) 
			{
				System.out.print(i);
				System.out.print("\t");
			}
			System.out.println();
	}
	public void PrintTasks(Project project)
	{
		System.out.println("Onoma sun8eths: ");
		Scanner input = new Scanner(System.in);
		String onoma = input.nextLine();
		for(Task t : project.getArrayWithTasks())
		{
			if(t.getName().equals(onoma))
			{
				found=true;
			}
		}
		while(found==false)
		{
			System.out.println("this task doesn't exist!");
			System.out.println("Allo onoma: ");
			Scanner input2 = new Scanner(System.in);
			onoma = input2.nextLine();
			for(Task t : project.getArrayWithTasks())
			{
				if(t.getName().equals(onoma))
				{
					found=true;
				}
			}
		}
		for(Task i: project.getArrayWithTasks())
		{
			if((i.getUpoergasia()==false)&&(!(i.getName().equals(onoma))))
			{
				System.out.println("name: " + i.getName());
				System.out.println("text: " + i.getText());
				System.out.println("duration: " + (i.getFinalDate()-i.getInitialDate()));
				if(i.getPreoccupancy().size()!=0)
				{
					for(String s : i.getPreoccupancy())
					{
						System.out.println("preoccupancy: " + s);
					}
				}
			}
			if(i.getName().equals(onoma))
			{
				System.out.println("name: " + i.getName());
				System.out.println("text: " + i.getText());
				System.out.println("duration: " + (i.getFinalDate()-i.getInitialDate()));
				if(i.getPreoccupancy().size()!=0)
				{
					for(String s : i.getPreoccupancy())
					{
						System.out.println("preoccupancy: " + s);
					}
				}
				for(String g : i.getUpoergasies())
				{
					for(Task h :project.getArrayWithTasks())
					{
						if(g.equals(h.getName()))
						{
							System.out.println("name upoergasias: " + h.getName());
							System.out.println("text: " + h.getText());
							System.out.println("duration: " + (h.getFinalDate()-h.getInitialDate()));
							if(h.getPreoccupancy().size()!=0)
							{
								for(String s : h.getPreoccupancy())
								{
									System.out.println("preoccupancy: " + s);
								}
							}
						}
					}
				}
			}
		}
		for(Task j: project.getArrayWithTasks())
		{
			projectCost+=j.getCost();
			if(j.getFinalDate()>max)
			{
				max=j.getFinalDate();
			}
			if(j.getInitialDate()<min)
			{
				min=j.getInitialDate();
			}
		}
		projectDuration=max-min;
		System.out.println("Project's duration: "+ projectDuration);
		System.out.println("Project's cost: " + projectCost);
		t=project.getArrayWithTasks().size();
		myArray= new String[t+1][max+1];
		myArray[0][0]="TASKS";
		
		for(Task d : project.getArrayWithTasks())
		{
			if(d.getName().equals(onoma))
			{
				myArray[h][0]=d.getName();
				h++;
				for(String w : d.getUpoergasies())
				{
					for(Task q : project.getArrayWithTasks())
					{
						if(q.getName().equals(w))
						{
							myArray[h][0]=q.getName();
							h++;
						}
					}
				}	
			}
			else
			{
				if(d.getUpoergasia()==false)
				{
					myArray[h][0]=d.getName();
					h++;
				}
			}
		}
		
		for(int j=1;j<=max;j++)
		{
			myArray[0][j]= ""+j;
		}
		
		
		for(Task c : project.getArrayWithTasks())
		{
			if((!(c.getName().equals(onoma)))&&(c.getUpoergasia()==false)&&(c.getUpoergasies().size()==0))
			{
				myArray[z][c.getInitialDate()]= "#";
				for(int l=c.getInitialDate();l<=c.getFinalDate();l++)
				{
					myArray[z][l]= "#";
				}
				myArray[z][c.getFinalDate()]= "#";	
				if(c.getInitialDate()!=1)
				{
					if(c.getInitialDate()==2)
					{
						myArray[z][1]= " ";
					}
					else
					{
						for(int l=(c.getInitialDate()-1);l>=1;l--)
						{
							myArray[z][l]= " ";
						}
					}
				}
				if(c.getFinalDate()!=max)
				{
					if(c.getFinalDate()==max-1)
					{
						myArray[z][max]= " ";
					}
					else
					{
						for(int l=c.getFinalDate();l<max+1;l++)
						{
							myArray[z][l]= " ";
						}
					}
				}
				z++;
			}
			else
			{
				if(c.getName().equals(onoma))
				{
					for(int l=c.getInitialDate()+1;l<=c.getFinalDate();l++)
					{
						myArray[z][l]= "#";
					}
					myArray[z][c.getFinalDate()]= "#";	
					if(c.getInitialDate()!=1)
					{
						if(c.getInitialDate()==2)
						{
							myArray[z][1]= " ";
						}
						else
						{
							for(int l=(c.getInitialDate()-1);l>=1;l--)
							{
								myArray[z][l]= " ";
							}
						}
					}
					if(c.getFinalDate()!=max)
					{
						if(c.getFinalDate()==max-1)
						{
							myArray[z][max]= " ";
						}
						else
						{
							for(int l=c.getFinalDate();l<max+1;l++)
							{
								myArray[z][l]= " ";
							}
						}
					}
					z++;
					
					for(String w : c.getUpoergasies())
					{
						for(Task q : project.getArrayWithTasks())
						{
							if(q.getName().equals(w))
							{
								myArray[z][q.getInitialDate()]= "*";
								for(int l=q.getInitialDate()+1;l<=q.getFinalDate();l++)
								{
									myArray[z][l]= "*";
								}
								myArray[z][q.getFinalDate()]= "*";	
								if(q.getInitialDate()!=1)
								{
									if(q.getInitialDate()==2)
									{
										myArray[z][1]= " ";
									}
									else
									{
										for(int l=(q.getInitialDate()-1);l>=1;l--)
										{
											myArray[z][l]= " ";
										}
									}
								}
								if(q.getFinalDate()!=max)
								{
									if(q.getFinalDate()==max-1)
									{
										myArray[z][max]= " ";
									}
									else
									{
										for(int l=q.getFinalDate();l<max+1;l++)
										{
											myArray[z][l]= " ";
										}
									}
								}			
								z++;
							}
						}				
					
					}
				}
			}
		}
		for(String[] row : myArray) 
		{
			printRow(row);
		}
	}
	public void SaveInFile(Project project)
	{
		System.out.println("do you want HTML or TEXT?");
		Scanner input = new Scanner(System.in);
		String file = input.nextLine();
		if(file.equals("HTML"))
		{
			header = new String("");
			header.concat("<!doctype html>");
			header.concat("\n");
			header.concat("<html>");
			header.concat("\n");
			header.concat("<head>");
			header.concat("\n");
			header.concat("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
			header.concat("\n");
			header.concat("<title>GANTT</title>");
			header.concat("\n");
			header.concat("</head>");
			header.concat("\n");
			header.concat("<body>");
			header.concat("\n");
				
			String fileName = new String("report.html");
			try 
			{
				PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName));
				outputStream.println(header);
				outputStream.println("<table>");
				for(int i=0;i<=t;i++)
				{
					outputStream.println("<tr>");
					for(int j=0;j<=max;j++)
					{
						outputStream.print("<td>"+myArray[i][j]+"</td>");
					}
					outputStream.println("\n</tr>");
				}
				outputStream.println("</table>");
				outputStream.println("</body>\n</html>");
				outputStream.close();
			} catch (FileNotFoundException e) {
				System.out.println("Problem opening files.");
				System.exit(0);
			}			
		}
		else
		{
			FileOutputStream outputStream = null;
			
			try
			{
				outputStream = new FileOutputStream("report.txt");
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Error opening the file report.txt.");
				System.exit(0);
			}
			try
			{
				PrintWriter outputWriter = new PrintWriter(outputStream);
				for(String[] row : myArray) 
				{
					for (String i : row) 
					{
						outputWriter.print(i);
						outputWriter.print("\t");
					}
					outputWriter.println();
				}
				outputWriter.close( );
			}
			catch(NullPointerException e)
			{
				System.out.println("Error ");
				System.exit(0);
			}
		}
	}
}