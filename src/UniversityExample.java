import College.College;
import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Degree.Degree;
import Department.Department;
import Persona.Person;
import Persona.StudentProfile;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.Faculty.FacultyDirectory;
import Persona.Faculty.FacultyProfile;

public class UniversityExample {

    public static void main(String[] args) {
        // Part 1 - Populating the model
        College college = new College("Northeastern University College of Engineering");
        college.printCollegeName(); 
        Department department = new Department("Information Systems");
        department.printDepartmentName(); 
        college.addDepartment(department);
        

        FacultyDirectory fd = department.getFacultyDirectory();
        
        for (int j = 0; j < 5; j++) {
            fd.newFacultyProfile("FID" + (j + 1), "Faculty " + (j + 1));
        }

        StudentDirectory sd = department.getStudentDirectory();
        PersonDirectory pd = department.getPersonDirectory();

        for (int j = 0; j < 10; j++) {
            String studentId = "ID" + (j + 1);
            String studentName = "Student " + (j + 1);
            Person studentPerson = pd.newPerson(studentId, studentName);


            
            sd.newStudentProfile(studentPerson);
        }

        CourseCatalog courseCatalog = department.getCourseCatalog();
        courseCatalog.newCourse("info5001", "Application Design & Modeling", 4);
        courseCatalog.newCourse("info5002", "Application Engineering Development", 4);
        courseCatalog.newCourse("info5003", "Data Science Fundamentals", 4);
        courseCatalog.newCourse("info5004", "Cloud Computing", 4);
        courseCatalog.newCourse("info5005", "Advanced DB Management", 4);

        // Part 2 - Populating the model (cont.)
        CourseSchedule csFall2023 = department.newCourseSchedule("Fall2023");

        for (int j = 0; j < 5; j++) {
            String code = "info" + (5000 + (j + 1) );
            Course course = courseCatalog.getCourseByNumber(code);
            if(course == null) {
                System.out.println("Course not found for code: " + code);
                continue;
            }
            
            
            CourseOffer courseOffer = csFall2023.newCourseOffer(code);
            if (courseOffer == null) {
                System.out.println("Failed to create CourseOffer for code: " + code);
                continue;
            }
            courseOffer.generateSeats(25);

            FacultyProfile facultyProfile = fd.getFacultyByIndex(j);
            if(facultyProfile != null) {
                courseOffer.AssignAsTeacher(facultyProfile);
            } else {
                System.out.println("Faculty not found for index: " + j);
            }

            courseOffer.AssignAsTeacher(facultyProfile);
        }

        for (StudentProfile student : sd.getAllStudentProfiles()) {
            CourseLoad cl = student.getCurrentCourseLoad();

            for (int j = 0; j < 5; j++) {
                String code = "info" + (5000 + (j + 1));
                CourseOffer offer = csFall2023.getCourseOfferByNumber(code);
                int seatCount = offer.getemptySeatsCount();
                if (seatCount > 0) {
                    offer.newSeatAssignment(cl, student);
                }
            }
        }

        // Part 3 – Program Analytics
        csFall2023.printCourseSchedule();

        for (StudentProfile studentProfile : sd.getAllStudentProfiles()) {
            CourseLoad cl = studentProfile.getCurrentCourseLoad();
            
        if (cl != null) {
            for (SeatAssignment seatAssignment : cl.getSeatAssignments()) {
                seatAssignment.assignGrade(3.5f);
            }
        } else {
            System.out.println("Warning: CourseLoad is null for student: " + studentProfile.getPerson().getName());
        }
                
    }        

        int revenue = calculateTotalRevenues(csFall2023, 6000);
        System.out.println("Total Revenue for Fall 2023: $" + revenue);}        
    

    private static int calculateTotalRevenues(CourseSchedule csFall2023, int pricePerCourse) {
        int totalRevenue = 0;
        for (CourseOffer offer : csFall2023.getAllCourseOffers()) {
            totalRevenue += offer.registeredStudentsCount() * pricePerCourse;
        }
        return totalRevenue;
    }
}
