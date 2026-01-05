import java.util.Scanner;
import java.util.ArrayList;
class Expense{
    String expense;
    int amount;
    Expense(String expense,int amount){
        this.expense=expense;
        this.amount=amount;
    }
}

public class Expense_Track {
    static ArrayList<Expense>expList=new ArrayList<>();

    public static void add_exp(String name,int expense){
        Expense exp=new Expense(name,expense);
        expList.add(exp);
    }

    public static void display(){
        if(expList.isEmpty()){
            System.out.print("You haven't added any expenses yet");
            return;
        }
        System.out.println("Your Expense is ");
        System.out.println("----------------------");
        for(Expense e:expList){
            System.out.println("Expense: " + e.expense + " | Amount: ₹" + e.amount);
        }System.out.println("----------------------");
    }

    public static void total_expense(){
        long total=0;
        for(Expense e:expList){
            total+=e.amount;
        }
        System.out.println("Your total expense is "+total);
    }

    public static void highest_expense(){
        if(expList.isEmpty()){
            System.out.print("You haven't added any expenses yet");
            return;
        }
        Expense max=expList.get(0);
        for(Expense e:expList) {
            if (max.amount < e.amount) {
                max = e;
            }
        }
        System.out.println("Your highest expense is "+max.expense + " amount is "+max.amount);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        boolean run=true;
        while(run){
            System.out.println("What do you need \n1.Add Expenses\n2.View Expenses\n3.Total Expenses\n4.Highest Expenses\n5.Exit");
            int n=sc.nextInt();
            switch(n){
                case 1:
                    char s;
                    do{
                        System.out.println("Do you want to add expenses(y/n):");
                        s=sc.next().charAt(0);
                        sc.nextLine();
                        System.out.println("Enter your expense name ");
                        String expense=sc.nextLine();
                        System.out.println("Enter your expense amount ");
                        int amount=sc.nextInt();
                        if(amount<=0){
                            System.out.println("Your amount is invalid");
                            continue;
                        }
                        add_exp(expense.toUpperCase(),amount);
                    }while(s=='y');
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    total_expense();
                    break;
                case 4:
                    highest_expense();
                    break;
                case 5:
                    System.out.println("Exiting Program...");
                    run=false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }sc.close();
    }
}