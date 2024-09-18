package com.atmitvision.hibernetcruddemo;

import com.atmitvision.hibernetcruddemo.dao.StudentDao;
import com.atmitvision.hibernetcruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernetcruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(HibernetcruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return Runner ->{
			//createNewStudent(studentDao);
			//createMultpleStudent(studentDao);
			//readStudent(studentDao);
			//getAllStudents(studentDao);
			//getAllStudentsByLastName(studentDao);
			//updateStudentById(studentDao);
			//removeStudentId(studentDao);
			removeAllStudents(studentDao);
		};
	}

	private void removeAllStudents(StudentDao studentDao) {
		int numberOfStudentDeleted=studentDao.deleteAll();
		System.out.println(String.valueOf(numberOfStudentDeleted));
	}

	private void removeStudentId(StudentDao studentDao) {
		int studentId=3;
		studentDao.delete(studentId);
	}

	private void updateStudentById(StudentDao studentDao) {
		int studentId=1;
		Student student=studentDao.findById(studentId);

		System.out.println("Student Name befor update="+student.getFirstName());

		student.setFirstName("Arthi");

		studentDao.updateStudent(student);

		System.out.println(student);

	}

	private void getAllStudentsByLastName(StudentDao studentDao) {
		List<Student> students=studentDao.findByLastName("Chowdhury");
		for(Student student: students){
			System.out.println(student);
		}
	}

	private void getAllStudents(StudentDao studentDao) {
		List<Student> students=studentDao.findAll();
		for(Student student: students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDao studentDao) {
		int studentId=1;
		System.out.println(studentDao.findById(studentId));
	}

	private void createMultpleStudent(StudentDao studentDao) {
		Student student=new Student("ashokchy@gmail.com","Ashok","Chowdhury");
		Student student1=new Student("akashchy@gmail.com","Akash","Chowdhury");
		Student student2=new Student("paromitachy@gmail.com","Paromita","Chowdhury");
		Student student3=new Student("tumpahalderchy@gmail.com","Tumpa Halder","Chowdhury");
		studentDao.save(student);
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
	}

	private void createNewStudent(StudentDao studentDao) {
		Student student=new Student("ashokchy@gmail.com","Ashok Kumar","Chowdhury");

		studentDao.save(student);

		System.out.println("Student ID is "+ studentDao.findById(student.getId()));
	}

}
