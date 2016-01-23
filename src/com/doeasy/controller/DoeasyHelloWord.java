package com.doeasy.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doeasy.model.dao.PersonDao;
import com.doeasy.model.vo.Person;

@Controller
public class DoeasyHelloWord {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWord() {
		
		String message = "";
		
		if (teste()) {
			message = "passou sim";
		} else {
			message = "passou não";
		}
		
		return new ModelAndView("welcome", "message", message);
	}	

	
	public boolean teste(){
		
		try {
			
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

        return true;

		} catch (Exception e) {
			return false;
		}
		
	}
}
