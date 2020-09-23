package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

@Controller
public class MyController {
	
	@Autowired
	StudentDao sdao;
	
	public MyController() {
		sdao = new StudentDaoImpl();
	}
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	@RequestMapping("/aboutus")
	public String about()
	{
		return "AboutUs";
	}
	
	@RequestMapping("/addStudent")
	public ModelAndView openForm()
	{
		return new ModelAndView("AddNewStudent", "stu", new Student());
	}
	
	@RequestMapping(value = "/saveStudent" , method=RequestMethod.POST )
	public String saveStudent(@ModelAttribute("stu") Student ob)
	{
		System.out.println(ob.getId()+"\t"+ob.getName()+"\t"+ob.getAddress()+"\t"+ob.getCourse());
		sdao.create(ob);
		return "success";
	}
	@RequestMapping("/showAll")
	public ModelAndView showAllStudent()
	{
		ModelAndView model = new ModelAndView();
		List<Student> data = sdao.showAllStudents();
		model.addObject("allData",data);
		model.setViewName("AllStudents");
		return model;
		
	}
	@RequestMapping(value="/deleteStudent" , method = RequestMethod.GET)
	public String deleteStudentById(@RequestParam(value="id") int id)
	{
		System.out.println("ID = "+id);
		sdao.deleteStudentById(id);
		return "redirect:/showAll";
	}
}
