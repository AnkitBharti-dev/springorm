package com.springorm;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Start Application" );
        
        ClassPathXmlApplicationContext con =
        		new ClassPathXmlApplicationContext("config.xml");
        
        StudentDao sd = con.getBean("studentDao", StudentDao.class);
        
        //Student student = new Student(10, "rovin", "gonda");
        //System.out.println(sd.insert(student));
        
        //Student s = sd.getStudent(10);
        //System.out.println(s);
        
        //sd.update(new Student(10,"rovin", "bahadurgarh"));
        
        sd.delete(10);
        
        List<Student> list = sd.getAllStudents();
        for(Student student:list) {
        	System.out.println(student);
        }
        con.close();
    }
}
