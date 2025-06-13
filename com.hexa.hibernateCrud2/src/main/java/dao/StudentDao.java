package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import connection.StudentConn;
import model.Student;

public class StudentDao implements DaoStudentI{
	

	
	private static SessionFactory factory;
	
	public StudentDao(){
		factory=StudentConn.getSessionFactory();
		System.out.println(factory.toString());
	}

	public void saveData(Student s) {
		// TODO Auto-generated method stub
		Session session= factory.openSession();
		Transaction txt = session.beginTransaction();
		session.save(s);
		txt.commit();
		
		
	}
	@Override
	public void removeByRoll(int rno) {
		
Session session=factory.openSession();
		
		Transaction txt=session.beginTransaction();
		
		
		NativeQuery<Student> q=session.createNativeQuery("delete from student where rollno=:rollno", Student.class);
		q.setParameter("rollno", rno);
		
		
		int r=q.executeUpdate();
		if(r>0)
		{
			System.out.println("Removed");
		
			}
		else
		{
			
			System.out.println("Not Found");
 
	
		}
		
		
		txt.commit();
		
		
		
		
		
		
	}
	public void updateByRoll1(int rno, String newName) {
		 
	    Session session = factory.openSession();
	    Transaction txt = session.beginTransaction();
 
	    NativeQuery<?> q = session.createNativeQuery("update student set name=:name where rollno=:rollno");
	    q.setParameter("name", newName);
	    q.setParameter("rollno", rno);
 
	    int r = q.executeUpdate();
 
	    if (r > 0) {
	        System.out.println("Updated");
	    } else {
	        System.out.println("Not Found");
	    }
 
	    txt.commit();
	    session.close();
	}


	public void searchByRoll(int rno1) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
	    Student rs=	session.get(Student.class, rno1);
	    if(rs!=null)
	    {
	    	System.out.println(rs.toString());
	    }
	    else {
	    	System.out.println("Not Found");
		}
		
	}

	public void searchByName(String name) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Query<Student> query = session.createQuery("from Student where name = :name", Student.class);
		query.setParameter("name", name); 
		List<Student> students=	 query.list();
		 
		for(Student s : students )	
		{
			System.out.println(s.toString());
			
		}
		
		
	}
	
	public void searchByNameMarks(String name,double marks) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Query<Student> query = session.createQuery("from Student where name = :name and marks=:marks", Student.class);
		
		query.setParameter("name", name); 
		query.setParameter("marks", marks);
		List<Student> students=	 query.list();
		 
		for(Student s : students )	
		{
			System.out.println(s.toString());
			
		}
		
		
	}
	
	
	public void ShowData() {
		
		
		Session session=factory.openSession();
		 NativeQuery<Student>  query= session.createNativeQuery("select * from Student", Student.class);
		 
		 //query.setFirstResult(1);
		 //query.setMaxResults(8);
		
		 List<Student> usersList=query.list();
			
			
			
			
			
			List<Student> students=	 query.list();
		 
			for(Student s : students )	
			{
				System.out.println(s.toString());
				
			}
	
		
	}
	
	
	
	
	public void greaterMarks(String name, double marks) {
		
		Session session=factory.openSession();
		 
			Query <Student>Q=session.createQuery("from Student where name=:name and marks>:marks",Student.class);
			Q.setParameter("name", name);
			Q.setParameter("marks", marks);
			 List<Student> usersList=  Q.list();
			 if(!(usersList.isEmpty()))
			 usersList.stream().forEach(i->System.out.println(i));
			 else {
				System.out.println("Not found");
			}
			
		}
	public void removeByRollNo(int rollno)
	{
		Session session=factory.openSession();
		Transaction txTransaction=session.beginTransaction();
		Query <Student>query=session.createQuery(" delete from Student where rollno=:rollno");
		query.setParameter("rollno", rollno);
		int r=query.executeUpdate();
		if(r>0)
		{
			System.out.println("Removed");
		}
		else {
			{
				System.out.println("Not Found");
			}
		}
		txTransaction.commit();
 
		
		
	}
	public void updateNameByRollNo(int rollno, String name) {
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();

	    Query<Student> query = session.createQuery("update Student set name = :name where rollno = :rollno");
	    query.setParameter("name", name);
	    query.setParameter("rollno", rollno);

	    int rs = query.executeUpdate();

	    if (rs > 0) {
	        System.out.println("Name updated successfully.");
	    } else {
	        System.out.println("Student not found.");
	    }

	    tx.commit();
	    
	}
public void ShowData1() {
		
		
		Session session=factory.openSession();
		 
		 Query<Student> query=session.createNamedQuery("Student.findAll", Student.class);
		 //query.setFirstResult(1);
		 //query.setMaxResults(8);
		
		 List<Student> usersList=query.list();
			
			
			
			
			
			List<Student> students=	 query.list();
		 
			for(Student s : students )	
			{
				System.out.println(s.toString());
				
			}
	
		
	}

public void ShowData2() {
	
	
	Session session=factory.openSession();
	 
	 Query<Student> query=session.createNamedQuery("Student.findByName", Student.class);
	
	 List<Student> usersList=query.list();
		
		
		
		
		
		List<Student> students=	 query.list();
	 
		for(Student s : students )	
		{
			System.out.println(s.toString());
			
		}

	
}
public void removeByRollNo1(int rollno)
{
	Session session=factory.openSession();
	Transaction txTransaction=session.beginTransaction();
	
	Query <Student>query=session.createNamedQuery("Student.removeByRoll");
	query.setParameter("rollno", rollno);
	int r=query.executeUpdate();
	if(r>0)
	{
		System.out.println("Removed");
	}
	else {
		{
			System.out.println("Not Found");
		}
	}
	txTransaction.commit();

	
	
}








}
