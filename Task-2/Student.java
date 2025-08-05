import java.util.*;

/*Student class is created with id, name and marks 
 * created method to add student data 
 * method to view student data
 * method to delete student data
 * method to update student data
 */

class Student {

    private int id;
    private String name;
    private int marks;

    // I want id to be updated sequentially
    private static int counter = 0;

    public Student(String name, int marks) {
        this.id = ++counter;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
    }

    /***************  Method to add student Data***************************  */
    public static List<Student> addStudentData(List<Student> students, Scanner sc) {

        System.out.print("Enter the student name: ");
        String name = sc.nextLine();

        System.out.print("Enter the student marks: ");
        int marks = sc.nextInt();

        Student st = new Student(name, marks);

        students.add(st);

        System.out.println("Student data added successfully");
        return students;

    }

    /***************  Method to View student Data***************************  */
    public static void viewData(List<Student> students) {

        for (Student st : students) {
            System.out.println(st);
        }
    }

    /***************  Method to Update student Data***************************  */
    public static void updateData(List<Student> students, Scanner sc) {

        System.out.println("Existing Data: " + students);

        System.out.print("Enter the id of student you want to update: ");
        int input = sc.nextInt();
        sc.nextLine(); // consume new line

        boolean found = false;

        for (Student st : students) {

            if (st.getId() == input) {

                System.out.println("Student Data found");

                System.out.print("Enter the new name: ");
                String newName = sc.nextLine();

                System.out.print("Enter the updated marks: ");
                int updatedMarks = sc.nextInt();
                sc.nextLine(); // to consume next line

                // suppose any user just type whitespaces to avoid empty or whitespaces in name
                if (newName.trim().isEmpty()) {

                    System.out.println("empty or whitespaces not allowed");


                }else{

                    st.setName(newName);


                }

                // marks cannot be less than 0

                if (updatedMarks >= 0) {

                    st.setMarks(updatedMarks);

                }

                System.out.println("Student data updated successfully " + st);

                found = true;
                break;

            }

        }

        if (!found) {

            System.out.println("Id does not exits");

        }

    }


    /***************  Method to Delete student Data***************************  */
    public static void deleteData(List<Student> students, Scanner sc) {

        // using remove says indexout of bound exception so use Iterator

        System.out.print("Enter id of student to delete data: ");
        int input = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {

            Student st = it.next(); // it will iterate over the list

            if (st.getId() == input) {
                it.remove();

                System.out.println("Student Data deleted successfully");

                found = true;
                break;
            }

        }

        if (!found) {

            System.out.println("Id does not exists");

        }

    }

    // Main function 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        students.add(new Student("Shivam", 99)); // initialize object with some data

        System.out.println(); // just to make look good

        while (true) {

            System.out.println("*******************STUDENT DATA*****************");
            System.out.println("Enter the choice to perform any operation");
            System.out.println("1: Add Data");
            System.out.println("2: View Data");
            System.out.println("3: Update Data");
            System.out.println("4: Delete Data");
            System.out.println("5: Exit");

            System.out.print("Enter Your choice: ");
            int input = sc.nextInt();
            sc.nextLine(); // consume new line

            switch (input) {
                case 1:
                    addStudentData(students, sc);

                    break;

                case 2:

                    viewData(students);

                    break;

                case 3:

                    updateData(students, sc);

                    break;

                case 4:

                    deleteData(students, sc);

                    break;

                case 5:

                    System.out.println("Exit Succesfully");
                    return;

                default:
                    System.out.println("Invalid Input");
                    break;
            }

        }

    }

}
