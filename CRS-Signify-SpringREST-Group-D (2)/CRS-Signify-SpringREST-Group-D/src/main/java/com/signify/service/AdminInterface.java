/**
 * 
 */
package com.signify.service;

import java.sql.ResultSet;
import java.util.*;

import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentDBViewException;

/**
 * @author HP
 *
 */
public interface AdminInterface {
	public boolean addAdmin(Admin admin);
	//public boolean addAdmin(int adminId, String adminPass ,String adminName,String AdminDesignation) throws AdminExceptions;
	public boolean addProfessor(int proffId, String pass, String name,String designation,String doj) throws AdminExceptions;
	//public void assignCourse(int studentId,String courseCode);
	public void approveStudent(int studentId) throws StudentDBViewException;
	public List viewRegisteredStudents() throws StudentDBViewException;
	//catalog
	public boolean addCourse(String courseId, String courseName, int courseProf,int course_price) throws CourseCreateExceptions;
	public boolean deleteCourse(String courseId) throws DeleteCourseException;
	public ResultSet viewCourseDetails(String courseID) throws CourseDetailsException;
}
