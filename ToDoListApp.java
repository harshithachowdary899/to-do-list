package xyz;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<String> tasks=new ArrayList<>();
		while(true) {
			System.out.println("simple to do tasks");
			System.out.println("1.add a task");
			System.out.println("2.view the task");
			System.out.println("3.delete the task");
			System.out.println("4.exit");
			int choice= sc.nextInt();
			sc.nextLine();
			if(choice==1) {
				System.out.println("add task in this list");
				String task=sc.nextLine();
				tasks.add(task);
				continue;
			}else if(choice==2) {
				if(tasks.isEmpty()) {
					System.out.println("nothing");
				}else {
					System.out.println("view the tasks");
					for(int i=0;i<tasks.size();i++)
				    System.out.println(tasks.get(i));
				    continue;
				}
			}else if(choice==3) {
				System.out.println("delete the task");
				int b=sc.nextInt();
				if(b<=0 && b>tasks.size()) {
				tasks.remove(b);
				continue;
				}else {
					System.out.println("not vaild");
				}
			}else if(choice==4) {
				System.out.println("bye bye");
				break;
			}else {
				System.out.println("invalid option");
			}
		}   
	}
}