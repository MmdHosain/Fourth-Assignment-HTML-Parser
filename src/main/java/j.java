import java.io.IOException;
import java.util.Scanner;


public class j {


    static Scanner myObj = new Scanner(System.in);
    private static Object in;


    public static void out(String output){
        System.out.print(output);
    }
    public static void out(String output, int endl){
        System.out.println(output);
    }
    public static void out(int output, int endl){
        System.out.println(output);
    }
    public static void out(int output){
        System.out.print(output);
    }
    public static String in(){
        return myObj.nextLine();
    }
    public static int in(int is_int){
        return Integer.parseInt(myObj.nextLine());
    }
    public static  int menu(String op1, String op2, String op3, String op4) throws IOException {

        int cursor = 1;
        while (true)
        {
            opShow(op1,1,cursor);
            opShow(op2,2,cursor);
            opShow(op3,3,cursor);
            opShow(op4,4,cursor);

            switch (j.in(1)) {
                case 2:
                    cursor++;
                    if (cursor>4) cursor = 1;
                    break;
                case 8:
                    cursor--;
                    if (cursor<1) cursor = 4;

                    break;
                case 5:
                    return cursor;
            }
        }

    }
    private static void opShow(String output,int opNum,int cursor){
        j.out(opNum);
        j.out(output);
        if (cursor == opNum) {
            j.out(" <<*");
        }
        j.out("",1);
    }




}