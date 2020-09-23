package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Student;

@Repository(value="sdao")
//@Transactional
public class StudentDaoImpl implements StudentDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public StudentDaoImpl() {
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(Student ob) {
		Session sess =  sessionFactory.openSession();
		sess.beginTransaction();
		sess.persist(ob);
		sess.getTransaction().commit(); 
		
	}

	@Override
	public List<Student> showAllStudents() {
	   return sessionFactory.openSession().createQuery("from Student").list();
		//return null;
	}

	@Override
	public void deleteStudentById(int id) {
		Session sess= sessionFactory.openSession();
		sess.beginTransaction();
		Student stu  = (Student) sess.load(Student.class, id);
		sess.delete(stu);
		sess.getTransaction().commit();
		
		
	}
	

}
