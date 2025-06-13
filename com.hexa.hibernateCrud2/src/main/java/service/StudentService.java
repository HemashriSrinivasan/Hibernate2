package service;

import java.util.Scanner;

import dao.DaoStudentI;
import dao.StudentDao;
import model.Student;

public class StudentService {
	
	Student s;
    StudentDao dao;
    Scanner sc;

    public StudentService(){
        s=new Student();
        sc=new Scanner(System.in);
        dao=new StudentDao();
    }
    public void saveStudent(){
        System.out.println("enter rollno");
        s.setRollno(sc.nextInt());
        
        System.out.println("enter name");
        sc.nextLine();
        s.setName(sc.nextLine());
        
        System.out.println("enter marks");
        s.setMarks(sc.nextDouble());
        dao.saveData(s);
        }
    public void removeByStudRoll() {
		
        System.out.println("Enter your rollno:");
        int rno1=sc.nextInt();
	     dao.removeByRoll(rno1);
	}
	
	public void updateByRoll() {
		
        System.out.println("Enter your rollno:");
        int rno1=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your new name:");
        String newName=sc.nextLine();
	     dao.updateByRoll1(rno1,newName);
	}
	public void searchByStudRoll()
	{
		System.out.println("Enter your name:");
        int rno=sc.nextInt();
	     dao.searchByRoll(rno);

	}
   
	public void searchByStudName()
	{
		System.out.println("Enter your name:");
        String name =sc.nextLine();
	     dao.searchByName(name);

	}
	
	public void searchByStudNameMarks()
	{
		System.out.println("Enter your name:");
        String name =sc.nextLine();
        System.out.println("Enter your name:");
        double marks =sc.nextDouble();
	     dao.searchByNameMarks(name, marks);

	}
	public void ShowData() {
		// TODO Auto-generated method stub
		dao.ShowData();
	}
	public void greaterMarks() {
		System.out.println("Enter your name:");
        String name =sc.nextLine();
        System.out.println("Enter your marks:");
        double marks =sc.nextDouble();
	     dao.greaterMarks(name, marks);
	
	}
	
	public void removebyRollHQL() {
		System.out.println("Enter Roll");
		int rollno=sc.nextInt();
		dao.removeByRollNo(rollno);
	}
	public void updateNameByRollNo() {
		System.out.println("Enter Roll");
		int rollno=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your name:");
        String name =sc.nextLine();
        dao.updateNameByRollNo(rollno, name);
		
	}
	public void ShowData1() {
		// TODO Auto-generated method stub
		dao.ShowData1();
	}
	
	public void updateByRoll1() {
		
        System.out.println("Enter your rollno:");
        int rno1=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your new name:");
        String newName=sc.nextLine();
	     dao.updateByRoll1(rno1,newName);
	}
	public void ShowData2() {
		// TODO Auto-generated method stub
		dao.ShowData2();
		
	}
        
        
		
	}

