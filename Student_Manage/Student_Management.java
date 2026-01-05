package Student_Manage;
import java.util.Scanner;
import java.util.ArrayList;
class Stud_Manage{
    int reg_no;
    String name;
    int mark1;
    int mark2;
    int mark3;
    int total;
    double avg;
    char grade;
    Stud_Manage(int reg_no,String name,int mark1,int mark2,int mark3,int total,double avg,char grade){
        this.reg_no=reg_no;
        this.name=name;
        this.mark1=mark1;
        this.mark2=mark2;
        this.mark3=mark3;
        this.total=total;
        this.avg=avg;
        this.grade=grade;
    }
}
public class Student_Management {
    static ArrayList<Stud_Manage>stud_list=new ArrayList<>();
    public static void add_Stud(int reg_no,String name,int mark1,int mark2,int mark3){
        int total=mark1+mark2+mark3;
        System.out.println("Your total mark is:"+total);
        double avg=(double)total/3;
        System.out.printf("Your average percentage is: %.2f\n",avg);
        char grade;
        if(avg>=90){
            grade='A';
        }else if(avg>=75){
            grade='B';
        }else if(avg>=50){
            grade='C';
        }else{
            grade='F';
        }
        Stud_Manage stud=new Stud_Manage(reg_no,name,mark1,mark2,mark3,total,avg,grade);
        stud_list.add(stud);
    }

    public static void display(){
        if(stud_list.isEmpty()){
            System.out.println("No students added yet!");
            return;
        }
        for(Stud_Manage s : stud_list){
            System.out.println("Reg No: " + s.reg_no);
            System.out.println("Name: " + s.name);
            System.out.println("Total: " + s.total);
            System.out.println("Average: " + s.avg);
            System.out.println("Grade: " + s.grade);
            System.out.println("--------------------");
        }
    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        boolean run=true;
        while(run){
            System.out.println("What you need to do \n1.Add Student\n2.Display students\n3.Exit");
            int n=sc.nextInt();
            switch(n){
                case 1:
                    char s;
                    do{
                        System.out.println("Did you want to add student (y/n):");
                        s=sc.next().charAt(0);
                        sc.nextLine();
                        System.out.println("Enter your name:");
                        String name=sc.nextLine();
                        System.out.println("Enter your register number:");
                        int reg_no=sc.nextInt();
                        System.out.println("Enter mark 1 (0-100):");
                        int mark1=sc.nextInt();
                        System.out.println("Enter mark 2 (0-100):");
                        int mark2=sc.nextInt();
                        System.out.println("Enter mark 3 (0-100):");
                        int mark3=sc.nextInt();
                        add_Stud(reg_no,name,mark1,mark2,mark3);
                    }while(s=='y');
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    System.out.println("Exiting program");
                    run=false;
                    break;
                default:
                    System.out.print("Invalid input");
            }
        }sc.close();
    }
}
