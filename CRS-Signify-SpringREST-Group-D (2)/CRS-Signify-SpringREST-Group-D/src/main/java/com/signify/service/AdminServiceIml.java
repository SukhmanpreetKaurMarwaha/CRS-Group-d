/**
 * 
 */
package com.signify.service;

import java.sql.ResultSet;
import java.util.*;

import org.springframework.stereotype.Service;

import com.signify.restcontroller.AdminRestControllerAPI;
import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
//import com.signify.client.CSRDatabasemMenu;
import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentDBViewException;
import com.signify.jdbc.AdminDAOImplementation;
import com.signify.jdbc.CourseCatalogDAOImplementation;
import com.signify.jdbc.ProfessorDAOImplementation;
import com.signify.jdbc.StudentDAOImplementation;
import com.signify.jdbc.UserDAOImplementation;

/**
 * @author Tejaswini.S.J
 *
 */
@Service
public class AdminServiceIml implements AdminInterface
{
	//Function To Add Admin Details In The Database
	public boolean addAdmin(Admin admin) 
    {
		boolean addadmin=false;
		try {
			
			
		UserDAOImplementation unew=new UserDAOImplementation();
		boolean ans= unew.create_user(admin.getAdminid(),admin.getPassword(),admin.getAdmin_name(),"Admin");
		
		AdminDAOImplementation stdetail= new AdminDAOImplementation();
		boolean ans1=stdetail.admin_db_create(admin.getAdminid(),admin.getAdmin_name(),admin.getDesignation());
		
		if(ans==true && ans1==true)
		{
			addadmin=true;
		}
	    
		}catch(AdminExceptions e)
		{
			e.printStackTrace();

			return false;
		}
  	  return true;
    }
	
	
	//Function To Add Professor Details In The Database
	public boolean addProfessor(Professor prof) throws AdminExceptions 
      {
		boolean ans3=false;
		try {
		UserDAOImplementation unew=new UserDAOImplementation();
		boolean cal1=unew.create_user(prof.getProf_id(),prof.getPassword(),prof.getProf_name(),"Professor");
		
		ProfessorDAOImplementation stdetail= new ProfessorDAOImplementation();
		boolean cal2=stdetail.professor_db_create(prof.getProf_id(),prof.getProf_name(),prof.getDesignation(),prof.getDoj());

		if (cal1==true && cal2==true)
		{
			ans3=true;
		}
    	  //System.out.println("\nPROFESSOR ADDED\n");
    	
		}catch(AdminExceptions e)
		{
			System.out.println("PROFESSOR NOT ADDED");
		}
		return ans3;
      }
	//Function To View Registered Students Details From The Database
      public List viewRegisteredStudents() throws StudentDBViewException
      {
    	  List viewstd =null;
    	  try {
    	  StudentDAOImplementation unew=new StudentDAOImplementation();
  		unew.student_db_view();
  		
    	 }catch(StudentDBViewException e)
    	
    	  {
    		 System.out.println("STUDENT NOT REGISTERED");
    		  
    	  }
    	  return viewstd;
      }
      
      
      //Function To Add Course Details In The Database
     public boolean addCourse(Course course) throws CourseCreateExceptions {
   
    	  boolean addcourse=false;
    	  try {
    	  CourseCatalogDAOImplementation cfdetail= new CourseCatalogDAOImplementation();
		    addcourse=cfdetail.catalog_db_create(course.getCourseid(),course.getCoursename(),course.getProfid(),course.getCourse_price());
	
    	  }
    	  catch(CourseCreateExceptions e)
    	  {
    		  System.out.println("COURSE NOT ADDED");
    	  }
    		  return addcourse;
    	  }
  	      
  	
    //Function To Delete Course Details From The Database
  	public boolean deleteCourse(String courseId) throws DeleteCourseException {
  		boolean deletecourse=false;
  		try {
  		CourseCatalogDAOImplementation cf1detail= new CourseCatalogDAOImplementation();
  		deletecourse= cf1detail.deleteCourse(courseId);
  		
		 // System.out.println("\nCOURSE REMOVED\n");
  	  }catch(DeleteCourseException e)
  	  {
  		  System.out.println("COURSE NOT REMOVED");
  		 
  	  }
  		return deletecourse;
  	}

  	 //Function To View Course Details In The Database
  	public ResultSet viewCourseDetails(String courseId) throws CourseDetailsException {
  		ResultSet ans2=null;
  		try {
  		CourseCatalogDAOImplementation cf1detail= new CourseCatalogDAOImplementation();
  		 ans2=cf1detail.CourseDetail(courseId);
		  
    	  }catch(CourseDetailsException e)
    	  {
    		  System.out.println("COURSE CANNOT BE VIEWED");
    	  }
  		 return ans2;
  	}
	@Override
	//Function Approve Student Registration In The Database
	public void approveStudent(int studentId) throws StudentDBViewException{
		// TODO Auto-generated method stub
		try {
			
			AdminDAOImplementation approve= new AdminDAOImplementation();
			approve.approvestd(studentId,"approved");
			System.out.println("\nSTUDENT APPROVED \n");
			
			

  	  }catch(StudentDBViewException e)
  	  {
  		System.out.println("\nSTUDENT CANNOT BE APPROVED\n");
  	  }
		}


	@Override
	public boolean addAdmin(int adminId, String adminPass, String adminName, String AdminDesignation)
			throws AdminExceptions {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addProfessor(int proffId, String pass, String name, String designation, String doj)
			throws AdminExceptions {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addCourse(String courseId, String courseName, int courseProf, int course_price)
			throws CourseCreateExceptions {
		// TODO Auto-generated method stub
		return false;
	}
		
	}

