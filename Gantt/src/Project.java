import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


public class Project implements Loading
{
	private String projectName;
	private ArrayList<Task> arrayWithTasks = new ArrayList<Task>();
	int count2;
	private int initialDate;
	private String name1;
	private int star;
	private int l;
	private int l2;
	private int h=0;
	private int z=1;
	private String answer;
	private int max;
	private int min;
	private int kostos;
	private int diarkeia;
	private Task t;
	
	public Project(String projectName)
	{
		this.projectName=projectName;
	}
	public  ArrayList<Task> getArrayWithTasks()
	{
		return arrayWithTasks;
	}
	public void printRow(String[] row) //me8odos gia na ta typwnei stuxismena
	{
		for (String i : row) 
		{
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.println();
	}
	public void AddTask()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("name: ");
		String name = input.nextLine();
		
		System.out.println("initialDate: (number)");
		initialDate = input.nextInt();
		
		System.out.println("finalDate: (number)");
		int finalDate = input.nextInt();
		
		int duration=finalDate-initialDate;
		
		System.out.println("cost: ");
		double cost=input.nextInt();
		
		System.out.println("situation: ");
		String situation=input.nextLine();
		
		System.out.println("text: ");
		String text=input.nextLine();
		
		Task myTask = new Task(name,initialDate,finalDate,cost,situation,text);
		arrayWithTasks.add(myTask);
		
		System.out.println("do you want preoccupancy?(yes/no)");
		answer = input.nextLine();
		
		while(answer.equals("yes"))
		{
			System.out.println("preoccupancy's name: ");
			String t = input.nextLine();
			
			for(Task i : arrayWithTasks) //psaxnei ston pinaka me ths ergasies
			{
				if(i.getName().equals(t)) //otan vrei thn ergasia me auto to onoma
				{
					while(i.getFinalDate()>initialDate) //elegxei an h hmeromhnia enar3hs einai metagenesterh ths hmeromhnias lh3hs ths prokatoxoy
					{
						System.out.println("correct/cancel");
						String a = input.nextLine();
						
						if(a.equals("correct"))
						{
							System.out.println("initialDate: ");
							initialDate = input.nextInt();
						}
						else
						{
							System.exit(-1);
						}
					}
				}	
			}
			myTask.addP(t);
			System.out.println("do you want an other preoccupancy?");
			answer = input.nextLine();
		}
		System.out.println("do you want this task belong to another task?(yes/no)");
		String ans = input.nextLine();
		
		if(ans.equals("yes"))
		{
			System.out.println("name of Task: ");
			Scanner input2 = new Scanner(System.in);
			String nam = input2.nextLine();
			myTask.setSuname(nam);
			myTask.setUpoergasia(true);
			for(Task i : arrayWithTasks)
			{
				if(i.getName().equals(nam)) //psaxnei na vrei thn ergasia me auto to onoma
				{
					i.addYp(myTask.getName());
				
					for(String s : i.getUpoergasies())
					{
						for(Task t : arrayWithTasks)
						{
							if(t.getName().equals(s))
							{	
								if(t.getInitialDate()<min)
								{
									min = t.getInitialDate();
								}
								if(t.getFinalDate()>max)
								{
									max = t.getFinalDate();
								}
								kostos+= t.getCost();
								diarkeia=max-min;
							}
						}	
					}
				}
			}
			for(Task i : arrayWithTasks)
			{
				if(i.getName().equals(nam))
				{
					i.setInitialDate(min);
					i.setFinalDate(max);
					i.setCost(kostos);
					i.setDuration(diarkeia);
				}
			}
		}
	}
	public void ChangeElements(String nameTask)
	{
		for(Task x : arrayWithTasks)
		{
			if (x.getName().equals(nameTask))
			{
				System.out.println("What do you want to change in this task?(situation/initialDate/finalDate/cost/text/name/preoccupancy)");
				Scanner input = new Scanner(System.in);
				String ans = input.nextLine();
				if(ans.equals("name"))
				{
					System.out.println("New name: ");
					String name1 = input.nextLine();
					for(Task y : arrayWithTasks)
					{
						if(name1.equals(y.getName()))
						{
							System.out.println("This name exists already: ");
							System.out.println("New name: ");
							name1 = input.nextLine();
						}
					}
					x.setName(name1);
				}
				if(ans.equals("situation"))
				{
					System.out.println("New situation: ");
					String situation = input.nextLine();
					x.setSituation(situation);
				}
				if(ans.equals("initialDate"))
				{
					System.out.println("New initialDate: ");
					int initialDate = input.nextInt();
					x.setInitialDate(initialDate);
					diarkeia=x.getFinalDate()-initialDate;
					x.setDuration(diarkeia);
					if(x.getUpoergasia()==true)
					{
						for(Task i : arrayWithTasks)
						{
							if(i.getName().equals(x.getSuname()))
							{
								for(String s : i.getUpoergasies())
								{
									for(Task t : arrayWithTasks)
									{
										if(t.getName().equals(s))
										{	
											if(t.getInitialDate()<min)
											{
												min = t.getInitialDate();
											}
											if(t.getFinalDate()>max)
											{
												max = t.getFinalDate();
											}
											diarkeia=max-min;
										}
									}	
								}
							}
						}
					}
				}
				if(ans.equals("finalDate"))
				{
					System.out.println("New finalDate: ");
					int finalDate = input.nextInt();
					x.setFinalDate(finalDate);
					diarkeia=finalDate-x.getInitialDate();
					x.setDuration(diarkeia);
					if(x.getUpoergasia()==true)
					{
						for(Task i : arrayWithTasks)
						{
							if(i.getName().equals(x.getSuname()))
							{
								for(String s : i.getUpoergasies())
								{
									for(Task t : arrayWithTasks)
									{
										if(t.getName().equals(s))
										{	
											if(t.getInitialDate()<min)
											{
												min = t.getInitialDate();
											}
											if(t.getFinalDate()>max)
											{
												max = t.getFinalDate();
											}
											diarkeia=max-min;
										}
									}	
								}
							}
						}
					}	
				}
				if(ans.equals("cost"))
				{
					System.out.println("New cost: ");
					double cost = input.nextDouble();
					x.setCost(cost);
					if(x.getUpoergasia()==true)
					{
						for(Task i : arrayWithTasks)
						{
							if(i.getName().equals(x.getSuname()))
							{
								for(String s : i.getUpoergasies())
								{
									for(Task t : arrayWithTasks)
									{
										if(t.getName().equals(s))
										{	
											kostos+= t.getCost();
										}
									}	
								}
							}
						}
					}		
				}	
				if(ans.equals("preoccupancy"))
				{	
					System.out.println("add/delete");
					String choice = input.nextLine();
					if(choice.equals("delete"))
					{
						System.out.println("Name for delete: ");
						String n = input.nextLine();
						x.getPreoccupancy().remove(n);
					}
					else
					{
						System.out.println("preoccupancy's name: ");
						String t = input.nextLine();
						for(Task i : arrayWithTasks)
						{
							if(i.getName().equals(t))
							{
								while(i.getFinalDate()>x.getInitialDate())
								{
									System.out.println("correct/cancel");
									String a = input.nextLine();
									if(a.equals("correct"))
									{
										System.out.println("initialDate: ");
										int initial = input.nextInt();
										x.setInitialDate(initial);
									}
									else
									{
										System.exit(-1);
									}
								}
								while(i.getSituation()!= "Successfully Completed")
								{
									System.out.println("correct/cancel");
									String a = input.nextLine();
									if(a.equals("correct"))
									{
										System.out.println("preoccupancy's name: ");
										String s = input.nextLine();
										for(Task j : arrayWithTasks)
										{
											if(j.getName().equals(s))
											{
												t=s;
											}
										}
									}
									else
									{
										System.exit(-1);
									}
								}
							}
						}
						x.addP(t);
					}	
				}	
			}
		}	
	}
	
	public void LoadingFromFile(String file)
	{
		ArrayList<String> numbers = new ArrayList<String>();
		ArrayList<String> tasks = new ArrayList<String>();
	
		
		Scanner inputStream = null;
		
		try
		{
			inputStream = new Scanner(new FileInputStream(file));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File was not found");
			System.out.println("or could not be opened.");
			System.exit(0);
	
		}

		while (inputStream.hasNextLine()) //oso uparxei seira pou na grafei kati sto arxeio
		{
			String line = inputStream.nextLine( );

			String elements[] = line.split("[\t ]"); //kanei split thn ka8e grammh tou arxeiou
			l++;
		
			tasks.add(elements[0]);
			if(l==1) //h prwth grammh exei tous ari8mous
			{
				for(int i=1;i<elements.length;i++)
				{
					numbers.add(elements[i]); 
				}
			}
		}
		inputStream.close();
	
		int s1 = numbers.size();
		int s2 = tasks.size();
		
		String Array[][] = new String[s2][s1+1]; //dhmiourgoyme disdiastato pinaka
		for(String q :tasks)
		{
			Array[h][0]=q; //vazoume ston pinaka ta onomata twn ergasiwn
			h++;
		}
		for(String n: numbers)
		{
			Array[0][z]= n; //vazoume ston pinaka tous ari8mous
			z++;
		}
		
		Scanner inputStream2 = null;
		try
		{
			inputStream2 = new Scanner(new FileInputStream(file));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File report.txt was not found");
			System.out.println("or could not be opened.");
			System.exit(0);
	
		}
		while (inputStream2.hasNextLine()) //ksanadiavazoyme to arxeio gia na vroume auth th fora pou uparxoyn # , * kai kena
		{
			String line2 = inputStream2.nextLine( );
			String elements2[] = line2.split("");
			ArrayList<String> stars = new ArrayList<String>();
			
			for(int o=0;o<elements2.length;o++)
			{
				if((elements2[o].equals("#"))||(elements2[o].equals("*"))||(elements2[o].equals(" ")))
				{
					stars.add(elements2[o]);
				}
			}
			star=1;
			for(String k :stars)
			{
				if(star<=s1)
				{
					Array[count2][star]=k; //vazoume ta #,* kai ta kena ston pinaka
					star++;
				}
			}
			count2++;
		}
		inputStream2.close( );	
		
		for(String[] row : Array) //tupwnoume ton pinaka gia na doume an ola diavasthkan swsta
		{
			printRow(row);
		}
		
	}
	public void exit()
	{
		System.out.println("do you want to save the project before exit?(yes/no)");
		Scanner newinput = new Scanner(System.in);
		String c = newinput.nextLine();
		if(c.equals("yes"))
		{
			System.out.println("do you want : report1/report2/report3");
			String r = newinput.nextLine();
			if(r.equals("report1"))
			{
				Report1 nReport1 = new Report1();
				nReport1.PrintTasks(this);
				nReport1.SaveInFile(this);
			}
			if(r.equals("report2"))
			{
				Report2 nReport2 = new Report2();
				nReport2.PrintTasks(this);
				nReport2.SaveInFile(this);
			}
			if(r.equals("report3"))
			{
				Report3 nReport3 = new Report3();
				nReport3.PrintTasks(this);
				nReport3.SaveInFile(this);
			}
		}
		System.exit(-1);
	}
}