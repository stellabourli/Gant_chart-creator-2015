import java.util.Scanner;

public class Gantt
{
	public static void main(String[] args)
	{
		String answer="yes";
		String choice;
		String name;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("do you want to create a new project?(yes/no)");
		answer = input.nextLine();
		System.out.println("Give a name to create a new project: ");
		name = input.nextLine();
		Project newProject = new Project(name);
		
		System.out.print("1)If you want to add a task, press 1." + '\n' + "2)If you want to change something in a task, press 2." + '\n' + "3)If you want to have a report of the project, press 3." + '\n' + "4)If you want to load a project from a file,press 4." + '\n' + "5)If you want to exit from the project, press 5.");
		choice = input.nextLine();
		
		while(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5"))
		{
			while(choice.equals("1")&&answer.equals("yes"))
			{
				newProject.AddTask();
				System.out.println("do you want to add another task in this project?(yes/no)");
				answer = input.nextLine();
			}
			answer="yes";
			while(choice.equals("2")&&answer.equals("yes"))
			{
				System.out.println("name of task to change: ");
				String task = input.next();
				newProject.ChangeElements(task);
				Scanner input2 = new Scanner(System.in);
				System.out.println("do you want to change another task in this project?(yes/no)");
				answer = input2.nextLine();
			}
			if(choice.equals("3"))
			{
				System.out.println("if you want a simple report write:report1" + '\n' + "if you want a report with zoom-in in one task write:report2" + '\n' + "if you want a report with zoom-in in all tasks write:report3");
				answer = input.nextLine();
				if(answer.equals("report1"))
				{
					Report1 newReport1 = new Report1();
					newReport1.PrintTasks(newProject);
					System.out.println("do you want to save this report?(yes/no)");
					answer = input.nextLine();
					if(answer.equals("yes"))
					{
						newReport1.SaveInFile(newProject);
					}
				}
				if(answer.equals("report2"))
				{
					Report2 newReport2 = new Report2();
					newReport2.PrintTasks(newProject);
					System.out.println("do you want to save this report?(yes/no)");
					answer = input.nextLine();
					if(answer.equals("yes"))
					{
						newReport2.SaveInFile(newProject);
					}
				}
				if(answer.equals("report3"))
				{
					Report3 newReport3 = new Report3();
					newReport3.PrintTasks(newProject);
					System.out.println("do you want to save this report?(yes/no)");
					answer = input.nextLine();
					if(answer.equals("yes"))
					{
						newReport3.SaveInFile(newProject);
					}
				}
			}
			if(choice.equals("4"))
			{
				System.out.println("Name of the file: ");
				answer = input.nextLine();
				newProject.LoadingFromFile(answer);
			}
			if(choice.equals("5"))
			{
				newProject.exit();
			}
			System.out.print("1)If you want to add a task, press 1." + '\n' + "2)If you want to change something in a task, press 2." + '\n' + "3)If you want to have a report of the project, press 3." + '\n' + "4)If you want to load a project from a file,press 4." + '\n' + "5)If you want to exit from the project, press 5.");
			Scanner input3 = new Scanner(System.in);
			choice = input3.nextLine();
		}
	}
}