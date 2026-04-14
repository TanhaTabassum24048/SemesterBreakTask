public class TestEncapsulation {
    public static String compareSalary(Employee e1, Employee e2) 
    {
        if (e1.getSalary() > e2.getSalary()) {
            return e1.getName();
        } else if (e2.getSalary() > e1.getSalary()) {
            return e2.getName();
        } else {
            return "Equal salaries";
        }
    }
}   