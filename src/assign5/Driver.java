package assign5;

import java.text.DecimalFormat;

/**
 *  Driver to test the Roster/Student classes.
 *  @author Jill Seaman
 */

public class Driver {
    
	public static void main(String[] args) {

        Student student = new Student("Harry Potter");
        student.addAssignmentScore(98.5);
        student.addAssignmentScore(90.1);
        student.addAssignmentScore(78.3);
        student.addExamScore(95);
        student.addExamScore(87);

        DecimalFormat df = new DecimalFormat("0.0");
        // should use algorithm A by default:
        System.out.println(student.getName() + "  " +
                           df.format(student.getAverage()));

        // switch to algorithm B:
        student.setDropLowestAssign(true);
        System.out.println(student.getName() + "  " +
                           df.format(student.getAverage()));
        // switch back to algorithm A:
        student.setDropLowestAssign(false);


        //test the GradeTracker
        GradeTracker gt = new GradeTracker(student);
        System.out.println("letter grade: " + gt.getLetterGrade());
        student.addExamScore(33);
        System.out.println("Added an exam score.");
        System.out.println("letter grade: " + gt.getLetterGrade());


        //add a new student
        Student hg = new Student("Hermione Granger");
        hg.addAssignmentScore(96.2);
        hg.addAssignmentScore(98.1);
        hg.addAssignmentScore(99.3);
        hg.addExamScore(95);
        hg.addExamScore(97);

        
        //new roster
        Roster potions = new Roster("Potions","MAG2308");
        potions.addStudent(student);
        potions.addStudent(hg);

        /* DEBUG
        for(int index = 0; index < 50;){
            Student tempStudent = new Student("Student" + index+1);
            tempStudent.addAssignmentScore(60 + index*2);
            tempStudent.addAssignmentScore(100 - index);
            tempStudent.addAssignmentScore(100);
            tempStudent.addExamScore(50+index/6);
            tempStudent.addExamScore(80+index/2);
            tempStudent.addExamScore(100);
            potions.addStudent(tempStudent);
            index++;
        }
        */


        //test the roster traversal
        System.out.println("Potions grades:");
        AvgDispenser ad = potions.getDispenser();
        while (!ad.done()) {
            System.out.println("next average "  +
                               df.format(ad.getNextAvg()));
        }
    }
}
