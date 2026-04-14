public class Main {
    public static void main(String[] args)
     {
        Employee emp1 = new Employee("Alice", 25, 20000);
        System.out.println("Original Employee:");
        emp1.display();
        emp1.giveRaise(10);
        System.out.println("\nAfter 10% Raise:");
        emp1.display();

        try {
            Employee emp2 = (Employee) emp1.clone();

            System.out.println("\nCloned Employee:");
            emp2.display();
        } 
        catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
    }
}