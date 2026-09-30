package final_project;

public class Course {
   
	public int ID;
	public String Title;
	public int CreditHours;
	public int Grade;
	public String Statues = "Did not Finish"; 
	
	
	Course(int CourseID , String Title , int CreditHours,int Grade ,String Statues){
	    this.ID = CourseID;
	    this.Title = Title;
	    this.CreditHours = CreditHours;
	    this.Grade = Grade; 
	    this.Statues = Statues;
	    
	}
}


