import College.College;
import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Department.Department;
import Persona.Person;
import Persona.Person.Faculty;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import Persona.Transcript;
import Persona.Faculty.FacultyDirectory;

public class UniversityExample {

    public static void main(String[] args) {
        College college = new College("Northeastern University College of Engineering");
        Department department = new Department("Information Systems");
        college.addDepartment(department);

        FacultyDirectory fd = department.getFacultyDirectory();
        for (int i = 0; i < 5; i++) {
            fd.newFacultyProfile("Faculty " + (i + 1));
        }

        StudentDirectory sd = department.getStudentDirectory();
        PersonDirectory pd = department.getPersonDirectory();
        for (int i = 0; i < 10; i++) {
            Person studentPerson = pd.newPerson("ID" + (i + 1), "Student " + (i + 1));
            sd.newStudentProfile(studentPerson);
        }

        CourseCatalog courseCatalog = department.getCourseCatalog();
        courseCatalog.newCourse("info5001", "Application Design & Modeling", 4);
        courseCatalog.newCourse("info5100", "Application Engineering Development", 4);
        courseCatalog.newCourse("info5200", "Data Science Fundamentals", 4);
        courseCatalog.newCourse("info5300", "Cloud Computing", 4);
        courseCatalog.newCourse("info5400", "Advanced DB Management", 4);

        CourseSchedule csFall2023 = department.newCourseSchedule("Fall2023");

        for (int i = 1; i <= 5; i++) {
            String code = "info" + (5000 + i);
            Course course = courseCatalog.getCourseByNumber(code);
            CourseOffer courseOffer = csFall2023.newCourseOffer(code);
            courseOffer.setFaculty(fd.getFaculty(i - 1)); // Assuming indexing starts from 0
            courseOffer.createSeats(25);
        }
        

        for (StudentProfile student : sd.getAllStudentProfiles()) {
            for (int j = 1; j <= 5; j++) {
                String code = "info" + (5000 + j);
                CourseOffer offer = csFall2023.getCourseOfferByNumber(code);
                if(offer == null) {
                    System.out.println("Course offer not found for code: " + code);
                    continue;
                }
                SeatAssignment seat = offer.assignEmptySeat(student.getCurrentCourseLoad());
                if (seat != null) {
                    Assuming grade assignment happens later, placeholder set for now
                    seat.setGrade("TBD");
                }
            }
        }

        csFall2023.printCourseSchedule();
        double revenue = csFall2023.calculateTotalRevenue(1000);
        System.out.println("Total Revenue for Fall 2023: $" + revenue);
    }
}
