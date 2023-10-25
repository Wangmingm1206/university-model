

import College.College;
import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Department.Department;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import Persona.Transcript;


public class UniversityExample {

    
    public static void main(String[] args) {
        College college = new College("Northeastern University College of Engineering");
        Department department = new Department("Information Systems");
        college.addDepartment(department);
        
        StudentDirectory sd = department.getStudentDirectory();
        PersonDirectory pd = department.getPersonDirectory();

        // Student side process
        Person archilPerson = pd.newPerson("0123", "Archil");
        StudentProfile archil = sd.newStudentProfile(archilPerson);
        
        
        Transcript archilsTranscript = archil.getTranscript();

        CourseLoad archilsSpring2024 = archilsTranscript.newCourseLoad("Fall2023");
        CourseLoad archilsCurrentCourseLoad = archil.getCurrentCourseLoad();


        // Course side
        
        CourseCatalog courseCatalog = department.getCourseCatalog();
        Course info5001 = courseCatalog.newCourse("info5001", "Application Design & Modeling", 4);    
        Course info5100 = courseCatalog.newCourse("info5100", "Application Engineering Development", 4);
        Course info5200 = courseCatalog.newCourse("info5200", "Data Science Fundamentals", 4);
        Course info5300 = courseCatalog.newCourse("info5300", "Cloud Computing", 4);
        Course info5400 = courseCatalog.newCourse("info5400", "Advanced DB Management", 4);

        CourseSchedule csFall2023 = department.newCourseSchedule("Fall2023");
        
        CourseOffer info5001offerFall2023 = csFall2023.newCourseOffer("info5001");
        CourseOffer info5100offerFall2023 = csFall2023.newCourseOffer("info5100");

        CourseOffer info5200offerFall2023 = csFall2023.newCourseOffer("info5200");
        CourseOffer info5300offerFall2023 = csFall2023.newCourseOffer("info5300");
        CourseOffer info5400offerFall2023 = csFall2023.newCourseOffer("info5400");
        
        info5001offerFall2023.generateSeats(25); // This means 10 students can take this class
        info5100offerFall2023.generateSeats(25);
        info5200offerFall2023.generateSeats(25); 
        info5300offerFall2023.generateSeats(25);
        info5400offerFall2023.generateSeats(25);

        
        SeatAssignment archilRegisteredForInfo5001inFall2023 = info5001offerFall2023.assignEmptySeat(archilsCurrentCourseLoad);
        SeatAssignment archilRegisteredForInfo5100inFall2023 = info5100offerFall2023.assignEmptySeat(archilsCurrentCourseLoad);
        SeatAssignment archilRegisteredForInfo5200inFall2023 = info5200offerFall2023.assignEmptySeat(archilsCurrentCourseLoad); 
        SeatAssignment archilRegisteredForInfo5300inFall2023 = info5300offerFall2023.assignEmptySeat(archilsCurrentCourseLoad);
        SeatAssignment archilRegisteredForInfo5400inFall2023 = info5400offerFall2023.assignEmptySeat(archilsCurrentCourseLoad);

        

        archil.printTranscript();

    }

}
