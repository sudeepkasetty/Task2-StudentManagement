
 
import java.util.*;

class Student {
    int id;
    String name;
    double marks;

    // Constructor
    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Display student details
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("-----------------------");
    }
}

public class studentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

      //ADDING THE STUDENT
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Marks: ");
                    double marks = sc.nextDouble();

                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully.");
                    break;

        //VIEWING THE STUDENT

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\nStudent Records:");
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;


                    //UPDATING THE STUDENT

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.id == updateId) {
                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter New Marks: ");
                            s.marks = sc.nextDouble();

                            System.out.println("Student updated successfully.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                    //DELETING THE STUDENT

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).id == deleteId) {
                            students.remove(i);
                            System.out.println("Student deleted successfully.");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Student Management System...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}