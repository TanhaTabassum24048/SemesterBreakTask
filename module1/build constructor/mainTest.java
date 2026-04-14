public static void mainTest(String[] args) {
        Employee emp1 = new Employee("Alice", 25, 20000);

        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setAge(30);
        emp2.setSalary(15000);

        System.out.println("Employee 1:");
        emp1.display();

        System.out.println("\nEmployee 2:");
        emp2.display();

        System.out.println("\nTrying invalid values...");
        emp2.setName(null);     
        emp2.setAge(10);        
        emp2.setSalary(-500);  

        System.out.println("After invalid input (no change expected):");
        emp2.display();

        emp1.giveRaise(10);
        emp2.giveRaise(10);

        System.out.println("\nAfter 10% raise:");
        emp1.display();
        emp2.display();

        try {
            Employee cloneEmp = (Employee) emp1.clone();

            System.out.println("\nCloned Employee:");
            cloneEmp.display();

            emp1.setName("Changed Name");
            emp1.setSalary(50000);

            System.out.println("\nAfter modifying original:");
            System.out.println("Original:");
            emp1.display();

            System.out.println("Clone (should not change):");
            cloneEmp.display();

        } 
        catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
        System.out.println("\nHigher salary: " + compareSalary(emp1, emp2));
    }
