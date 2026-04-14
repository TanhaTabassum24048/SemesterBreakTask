class Employee implements Cloneable {
    private String name;
    private int age;
    private double salary;
    public Employee() {
        name = "Unknown";
        age = 18;
        salary = 0.0;
    }
    public Employee(String name, int age, double salary) 
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
    }

    public void setAge(int age)
     {
        if (age >= 18 && age <= 65)
            this.age = age;
    }

    public void setSalary(double salary) {
        if (salary >= 0)
            this.salary = salary;
    }

    public double calculateAnnualSalary() {
        return salary * 12;
    }

    public void giveRaise(double percentage) {
        salary = salary + (salary * percentage / 100);
    }

    public void display()
     {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Monthly Salary: " + salary);
        System.out.println("Annual Salary: " + calculateAnnualSalary());
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


