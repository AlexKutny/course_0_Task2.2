import com.google.gson.Gson;

import java.util.Scanner;

public class Handler {
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);

        Student st = Student.getStudent(sc);
        Gson gson = new Gson();
        String json = gson.toJson(st);

        System.out.println(json);

        Student res = gson.fromJson(json, Student.class);

        System.out.println();
        System.out.println("Objects are equal: " + st.equals(res));
        sc.close();
    }
}
