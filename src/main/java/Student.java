import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Student {
    @NotNull
    String fname, lname, phone, address;

    @NotNull
    Calendar birthD;

    @NotNull
    static Student getStudent(Scanner sc) {
        while (true) {
            Student student = new Student();
            System.out.println("Enter first name of the student: ");
            student.fname = sc.nextLine();
            if (student.fname.matches(".*\\d+.*")) {
                System.out.println("Data is not valid! Try again! ");
                continue;
            }

            System.out.println("Enter last name of the student: ");
            student.lname = sc.nextLine();
            if (student.lname.matches(".*\\d+.*")) {
                System.out.println("Data is not valid: ");
                continue;
            }

            System.out.println("Enter date of birth of the student: ");
            String temp = sc.nextLine();
            if (!temp.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                System.out.println("Data is not valid: ");
                continue;
            }
            String[] ta = temp.split("\\.");
            student.birthD = new GregorianCalendar(Integer.valueOf(ta[2]), Integer.valueOf(ta[1]), Integer.valueOf(ta[0]));

            System.out.println("Enter the number of the student: ");
            student.phone = sc.nextLine();
            if (!student.phone.matches("\\+\\d{12}")) {
                System.out.println("Data is not valid: ");
                continue;
            }

            System.out.println("Enter the address of the student: ");
            student.address = sc.nextLine();

            return student;
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Student)) return false;
        Student ob = (Student) o;

        if (this.fname.equals(ob.fname) &&
                this.lname.equals(ob.lname) &&
                this.phone.equals(ob.phone) &&
                this.address.equals(ob.address) &&
                (this.birthD.compareTo(ob.birthD) == 0))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return fname.hashCode()*63 + lname.hashCode()*31 +  phone.hashCode()*96 +
                address.hashCode()*17 +  birthD.hashCode()*484 ;
    }
}
