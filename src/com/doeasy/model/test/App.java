package com.doeasy.model.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doeasy.model.dao.PersonDao;
import com.doeasy.model.vo.Person;

public class App {
     
    public static void main(String[] args) {
    	
    	
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        PersonDao dao 	= context.getBean(PersonDao.class);
 
        Person peter = new Person("Person 001", "M", null);
        Person nasta = new Person("Person 002", "M", null);
 
        // Add new Person records
        dao.save(peter);
        dao.save(nasta);
 
        // Count Person records
        System.out.println("Count Person records: " + dao.count());
 
        // Print all records
        List<Person> persons = (List<Person>) dao.findAll();
        for (Person person : persons) {
            System.out.println(person);
        }
 
        // Find Person by surname
        System.out.println("Find by surname 'Sagan': "  + dao.findByName("Sagan"));
 
        // Update Person
        nasta.setName("Barbora");
//        nasta.setSurname("Spotakova");
        dao.save(nasta);
 
        System.out.println("Find by id 2: " + dao.findOne(2L));
 
        // Remove record from Person
        dao.delete(2L);
 
        // And finally count records
        System.out.println("Count Person records: " + dao.count());
 
        context.close();
    	
//    	ClassPathXmlApplicationContext	 context = new 
//                  ClassPathXmlApplicationContext("applicationContext.xml");
//        PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");
//         	
//        Person peter = new Person("Person 1", "M", new Date());
//        Person nasta = new Person("Person 2", "F", new Date());
//         
//        dao.save(peter);
//        dao.save(nasta);
//         
//        List<Person> persons = dao.getAll();
//        for (Person person : persons) {
//            System.out.println(person);
//        }
//        context.close();
    }
}