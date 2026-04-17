import java.util.Scanner;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        
        Scanner scanner = new Scanner(System.in);
        int shapeCount = 0;
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Shape Management System =====");
            System.out.println("1. Add a Circle");
            System.out.println("2. Add a Rectangle");
            System.out.println("3. Add a Triangle");
            System.out.println("4. Display all shapes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1: 
                    if (shapeCount < shapes.length) {
                        System.out.print("Enter circle name: ");
                        String name = scanner.nextLine();                  
                        System.out.print("Enter circle color: ");
                        String color = scanner.nextLine();
                        
                        System.out.print("Enter circle radius: ");
                        double radius = scanner.nextDouble();
                        scanner.nextLine(); 
        
                        shapes[shapeCount] = new Circle(name, color, radius);
                        System.out.println("Circle added successfully!");
                        System.out.println("\nCircle Details:");
                        System.out.println(shapes[shapeCount].toString());
                        System.out.println("Area: " + shapes[shapeCount].area());
                        System.out.println("Perimeter: " + shapes[shapeCount].perimeter());
                        
                        shapeCount++;
                    } else {
                        System.out.println("Cannot add more shapes. Array is full!");
                    }
                    break;                   
                case 2:
                    if (shapeCount < shapes.length) {
                        System.out.print("Enter rectangle name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Enter rectangle color: ");
                        String color = scanner.nextLine();
                        
                        System.out.print("Enter rectangle length: ");
                        double length = scanner.nextDouble();
                        
                        System.out.print("Enter rectangle width: ");
                        double width = scanner.nextDouble();
                        scanner.nextLine(); 
                        shapes[shapeCount] = new Rectangle(name, color, length, width);
                        System.out.println("Rectangle added successfully!");
                        System.out.println("\nRectangle Details:");
                        System.out.println(shapes[shapeCount].toString());
                        System.out.println("Area: " + shapes[shapeCount].area());
                        System.out.println("Perimeter: " + shapes[shapeCount].perimeter());
                        
                        shapeCount++;
                    } else {
                        System.out.println("Cannot add more shapes. Array is full!");
                    }
                    break;                   
                case 3: 
                    if (shapeCount < shapes.length) {
                        System.out.print("Enter triangle name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Enter triangle color: ");
                        String color = scanner.nextLine();
                        
                        System.out.print("Enter length of side 1: ");
                        double side1 = scanner.nextDouble();
                        
                        System.out.print("Enter length of side 2: ");
                        double side2 = scanner.nextDouble();
                        
                        System.out.print("Enter length of side 3: ");
                        double side3 = scanner.nextDouble();
                        scanner.nextLine(); 
                        shapes[shapeCount] = new Triangle(name, color, side1, side2, side3);
                        System.out.println("Triangle added successfully!");
                        System.out.println("\nTriangle Details:");
                        System.out.println(shapes[shapeCount].toString());
                        System.out.println("Area: " + shapes[shapeCount].area());
                        System.out.println("Perimeter: " + shapes[shapeCount].perimeter());
                        
                        shapeCount++;
                    } else {
                        System.out.println("Cannot add more shapes. Array is full!");
                    }
                    break;
                    
                case 4: 
                    if (shapeCount > 0) {
                        System.out.println("\n===== All Shapes =====");
                        for (int i = 0; i < shapeCount; i++) {
                            System.out.println("\nShape " + (i + 1) + ":");
                            System.out.println(shapes[i].toString());
                            System.out.println("Area: " + shapes[i].area());
                            System.out.println("Perimeter: " + shapes[i].perimeter());
                            System.out.println("------------------------");
                        }
                    } else {
                        System.out.println("No shapes to display. Please add some shapes first.");
                    }
                    break;                   
                case 5: 
                    exit = true;
                    System.out.println("Thank you for using the Shape Management System. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
