
package College;

import Department.Department;
import java.util.ArrayList;


public class College {
    
    private ArrayList<Department> departments;
    
    
    public College(String name){
        
        departments = new ArrayList<Department>();
    }
    public void addDepartment(Department d){
        this.departments.add(d);
    }
    
}
