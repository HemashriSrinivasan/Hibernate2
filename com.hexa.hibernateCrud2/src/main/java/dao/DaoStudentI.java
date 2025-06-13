package dao;

import model.Student;

public interface DaoStudentI {
	
	void saveData(Student s);

	void removeByRoll(int s);
	
	//void updateByRoll(int rno,String newName);
	void updateByRoll1(int rno,String newName);
	void searchByRoll(int rno);
	void searchByName(String s);
	void searchByNameMarks(String s, double marks);
	public void greaterMarks(String name, double marks);
	public void removeByRollNo(int rollno);
	public void updateNameByRollNo(int rollno, String Name);
	void ShowData();
	void ShowData2();
}
