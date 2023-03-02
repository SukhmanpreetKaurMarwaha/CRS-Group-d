package com.signify.restcontroller;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.Admin;
import com.signify.bean.Course;
//import com.signify.bean.CustomerOne;
import com.signify.bean.Professor;

import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.ViewEnrolledStudentsException;
import com.signify.exception.ViewGradeCardException;
import com.signify.exception.ViewUnapprovedStudentsException;
import com.signify.jdbc.AdminDAOImplementation;
import com.signify.jdbc.CourseCatalogDAOImplementation;
import com.signify.service.*;

@RestController
public class AdminRestControllerAPI {
	/**
	 * @param args
	 * @throws AdminExceptions 
	 * @throws StudentDBViewException 
	 * @throws CourseCreateExceptions 
	 * @throws DeleteCourseException 
	 * @throws CourseDetailsException 
	 * @throws ViewUnapprovedStudentsException 
	 * @throws CoursePamentViewException 
	 * @throws ViewGradeCardException 
	 * @throws StudentAddCourseException 
	 * @throws StudentDropCourseException 
	 * @throws ViewEnrolledStudentsException 
	 */
	
	
	@Autowired
	private AdminServiceIml adminservice;
	@Autowired
	private Admin admin;
	
	//add admin
	@RequestMapping(
		    method = RequestMethod.POST,
		    value = "/addadmin")
		@ResponseBody
	 public ResponseEntity<String> createAdmin(@RequestBody Map<String,String> param){
		
		System.out.println(admin.getAdmin_name());
		String name=param.get("Admin_name");
		int id= Integer.parseInt(param.get("Adminid"));
		String Designation =param.get("Designation");
		String Password=param.get("Password");
		
		if(adminservice.addAdmin(admin))
			return new ResponseEntity<String>("added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("error", HttpStatus.OK);
		
	}
	
	
	
	//login
	//add admin
	
	/*@PostMapping(value = "/admin")
	public ResponseEntity createAdmin(@RequestBody Admin admin) throws AdminExceptions {

		adminservice.addAdmin(admin);

		 return new ResponseEntity(admin, HttpStatus.OK);
		
	}*/
	
//	
//	//add professor
//	@PostMapping(value = "/professor")
//	public ResponseEntity createProfessor(@RequestBody Professor prof) throws AdminExceptions  {
//
//		boolean ans2= adminservice.addProfessor(prof);
//
//		if(ans2==false) {
//			return new ResponseEntity("No Prof created ", HttpStatus.NOT_FOUND);
//		}
//		else
//		 return new ResponseEntity(prof, HttpStatus.OK);
//		
//	}
//	//add course
//		@PostMapping(value = "/course")
//		public ResponseEntity createCourse(@RequestBody Course course) throws CourseCreateExceptions  {
//
//			boolean ans3= adminservice.addCourse(course);
//
//			if(ans3==false) {
//				return new ResponseEntity("No Prof created ", HttpStatus.NOT_FOUND);
//			}
//			else
//			 return new ResponseEntity(course, HttpStatus.OK);
//			
//		}
//  
    
	//delete course
	
	/*@DeleteMapping("/admin/{courseid}")
	public ResponseEntity deleteCourse(@PathVariable String courseid) throws DeleteCourseException  {

		if (false == adminservice.deleteCourse(courseid)) {
			return new ResponseEntity("No Course found for ID " + courseid, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(courseid, HttpStatus.OK);*/

	}
	

	
	
	
/*	public static void Adminfunc() throws AdminExceptions, StudentDBViewException, CourseCreateExceptions, DeleteCourseException, CourseDetailsException, ViewUnapprovedStudentsException, StudentDropCourseException, StudentAddCourseException, ViewGradeCardException, CoursePamentViewException, ViewEnrolledStudentsException {
		// TODO Auto-generated method stub
		String s = "\nWELCOME TO ADMIN MENU\n"+"=====================\n";
		String str="";

		int choice;
		System.out.println(s);
		Scanner scan = new Scanner(s);
		
		System.out.println("1: ADD A SUB ADMIN ");//done
		System.out.println("2: ADD PROFESSOR ");//done
		System.out.println("3: APPROVE A STUDENT REGISTRATION");//done
		
		//System.out.println("6: Generate a Report Card");
		
		//System.out.println("8: Generate a Bill");
		System.out.println("4: ADD A COURSE TO CATALOG");//done
		System.out.println("5: REMOVE A COURSE FROM CATALOG");//done
		System.out.println("6: VIEW REGISTERED COURSE");//done
		System.out.println("7: VIEW ALL REGISTERED STUDENTS"); //done 
		System.out.println("8: LOGOUT");//done
		 
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter Your Choice "); 
        choice = in.nextInt();
        //in.close();
        
        
        
		switch(choice) {
		//case statements within the switch block  
		    
		case 1: System.out.println("YOUR CHOICE: ADD A SUB ADMIN"); 
		Scanner scan1 = new Scanner(System.in);
		System.out.println("ENTER ADMIN ID ");
		 int adminId = scan1.nextInt();
		 System.out.println("ENTER ADMIN PASSWORD ");
		 String adminPass = scan1.next();
		System.out.println("ENTER ADMIN NAME ");
		 String adminName = scan1.next();
		 System.out.println("ENTER DESIGNATION ");
		 String adminDesign = scan1.next();
		 
		
		AdminInterface b= new AdminServiceIml();
		b.addAdmin(adminId,adminPass,adminName,adminDesign);
		AdminRestControllerAPI ay=new AdminRestControllerAPI();
		 ay.Adminfunc();
		
		break;    
		case 2: System.out.println("YOUR CHOICE: ADD PROFESSOR");
		
		//System.out.println(s);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("ENTER PROFESSOR ID ");
		 int proffId = scan2.nextInt();
		 System.out.println("ENTER PROFESSOR PASSWORD ");
		 String pass = scan2.next();
		System.out.println("ENTER PROFESSOR NAME ");
		 String profName = scan2.next();
		 System.out.println("ENTER DESIGNATION ");
		 String design = scan2.next();
		 System.out.println("ENTER DOJ ");
		 String doj = scan2.next();
		 
		
		AdminInterface a= new AdminServiceIml();
		a.addProfessor(proffId,pass,profName,design,doj);
		AdminRestControllerAPI at=new AdminRestControllerAPI();
		 at.Adminfunc();
		
		break;    
		case 3: System.out.println("YOUR CHOICE: APPROVE A STUDENT REGISTRATION");
		Scanner scan7 = new Scanner(System.in);
		System.out.println("\nEnter Your Choice ");
		 System.out.println("1: VIEW ALL UNAPPROVED STUDENTS ");//done
			System.out.println("2: ENTER STUDENT ID OF THE STUDENT YOU WANT TO APPROVE ");//done
			System.out.println("3: EXIT APPROVAL MENU");
		 Scanner t = new Scanner(System.in);
		int val = t.nextInt();
        
		if(val==1)
		{

        System.out.println("YOUR CHOICE: VIEW ALL UNAPPROVED STUDENTS ");
        StudentInterface y= new StudentServiceIml();
		y.view_unapproved_stds();
		AdminRestControllerAPI as=new AdminRestControllerAPI();
		 as.Adminfunc();
		}
		else if (val ==2)
		{
			 System.out.println("YOUR CHOICE: ENTER STUDENT ID OF THE STUDENT YOU WANT TO APPROVE");
			 Scanner t1 = new Scanner(System.in);
				int stdid = t1.nextInt();
				 AdminInterface approve= new AdminServiceIml();
				approve.approveStudent(stdid);
				AdminRestControllerAPI as=new AdminRestControllerAPI();
				 as.Adminfunc();
		}
		else if(val==3) {
			System.out.println("YOUR CHOICE: EXIT APPROVAL MENU");
			AdminRestControllerAPI as=new AdminRestControllerAPI();
			 as.Adminfunc();
			 //break;

		}
		else
		{
			System.out.println("\nINVALID INPUT!");    
		}
					
		
		
		break;    
		//case 5: System.out.println("Assign a Course");  
		//break;    
		//case 6: System.out.println("Generate a Report Card");  
		//break;    
		
		case 4: System.out.println("YOUR CHOICE: ADD A COURSE TO CATALOG"); 
		
		Scanner scan3 = new Scanner(System.in);
		System.out.println("ENTER COURSE ID ");
		 String courseId = scan3.next();
		 System.out.println("ENTER COURSE NAME ");
		 String courseName = scan3.next();
		System.out.println("ENTER PROFESSOR ID ");
		 int courseProf = scan3.nextInt();
		 System.out.println("ENTER COURSE PRICE ");
		 int coursePrice = scan3.nextInt();
		 AdminInterface course= new AdminServiceIml();
			course.addCourse(courseId,courseName,courseProf, coursePrice);
			AdminRestControllerAPI aE=new AdminRestControllerAPI();
			 aE.Adminfunc();
		 
		break;    
		
		case 5: System.out.println("YOUR CHOICE: REMOVE A COURSE FROM CATALOG");  
		Scanner scan4 = new Scanner(System.in);
		System.out.println("ENTER COURSE ID ");
		 String courseId1 = scan4.next();
		 
		 AdminInterface c= new AdminServiceIml();
			c.deleteCourse(courseId1);
			AdminRestControllerAPI aD=new AdminRestControllerAPI();
			 aD.Adminfunc();
		
		break;    
		case 6: System.out.println("YOUR CHOICE: VIEW REGISTERED COURSE");  
		Scanner scan5 = new Scanner(System.in);
		System.out.println("ENTER COURSE ID ");
		 String courseId2 = scan5.next();
		 
		 AdminInterface c1= new AdminServiceIml();
			ResultSet choice8=c1.viewCourseDetails(courseId2);
			return new ResponseEntity(choice8, HttpStatus.OK);
			AdminRestControllerAPI aB=new AdminRestControllerAPI();
			 aB.Adminfunc();		
		
		break;
		case 7: System.out.println("YOUR CHOICE: VIEW ALL REGISTERED STUDENTS");
		/*System.out.println(student_db);
		 AdminInterface c2= new AdminServiceIml();
			c2.viewRegisteredStudents();
		AdminRestControllerAPI aC=new AdminRestControllerAPI();
		 aC.Adminfunc();
		break;
		case 8: System.out.println("YOUR CHOICE: LOGOUT");
		MainMenuRestControllerAPI m=new MainMenuRestControllerAPI();
			m.Menufunc();
		break;
		default:System.out.println("\nINVALID INPUT!");    
		}    
		//Printing month of the given number  

	}
*/




