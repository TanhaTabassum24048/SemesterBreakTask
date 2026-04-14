public class StudentRegistry {

    public static void main(String[] args) 
    {
        Student s1 = new Student();
        Student s2 = new Student();

        s1.setStudentId("S001");
        s1.setName("John Doe");
        s1.setGrade(85.5);
        s1.setIsActive(true);

        s2.setStudentId("S002");
        s2.setName("Jane Smith");
        s2.setGrade(92.0);
        s2.setIsActive(true);

        System.out.println("Student 1:");
        s1.display();

        System.out.println("\nStudent 2:");
        s2.display();

        System.out.println("\nHigher Grade: " + compareStudents(s1, s2));

        System.out.println("\nLetter Grades:");
        System.out.println(s1.getName() + ": " + s1.getLetterGrade());
        System.out.println(s2.getName() + ": " + s2.getLetterGrade());

        System.out.println("\nPassing Status:");
        System.out.println(s1.getName() + ": " + s1.isPassing());
        System.out.println(s2.getName() + ": " + s2.isPassing());

        s1.setIsActive(false);

        System.out.println("\nAfter changing status:");
        s1.display();
    }

    public static String compareStudents(Student s1, Student s2) {
        if (s1.getGrade() > s2.getGrade()) {
            return s1.getName();
        } else if (s2.getGrade() > s1.getGrade()) {
            return s2.getName();
        } else {
            return "Both have equal grades";
        }
    }
}