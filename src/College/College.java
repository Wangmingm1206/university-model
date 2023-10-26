
package College;

import Department.Department;
import java.util.ArrayList;


public class College {
    
    private ArrayList<Department> departments;
    private String name;
    
    public College(String name){
        this.name = name;
        departments = new ArrayList<Department>();
    }
    public void addDepartment(Department d){
        this.departments.add(d);
    }
    public void printCollegeName() {
        System.out.println("College Name: " + name);
    }
    
}
