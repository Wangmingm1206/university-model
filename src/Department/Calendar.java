package Department;

import CourseSchedule.CourseSchedule;
import java.util.HashMap;

public class Calendar {
    
    private HashMap<String, CourseSchedule> mastercatalog; 
    
    public Calendar(){
        mastercatalog = new HashMap<String, CourseSchedule>();    
    }
    
    public void addCourseSchedule(String semester, CourseSchedule cs){
        mastercatalog.put(semester, cs);
    }

    public CourseSchedule getCourseSchedule(String semester) {
        return mastercatalog.get(semester);
    }

    

    
    
}
