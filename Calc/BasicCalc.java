import java.util.*;
public class BasicCalc {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number 1:");
        int n1=sc.nextInt();
        System.out.println("Enter number 2:");
        int n2=sc.nextInt();
        System.out.println("Enter the operation(+,-,*,/,%):");
        char c=sc.next().charAt(0);
        switch(c){
            case '+':
                System.out.printf("The addition of %d and %d is %d",n1,n2,(n1+n2));
                break;
            case '-':
                System.out.printf("The Subtraction of %d and %d is %d",n1,n2,(n1-n2));
                break;
            case '*':
                System.out.printf("The multiplication of %d and %d is %d",n1,n2,(n1*n2));
                break;
            case '/':
                if(n2!=0){
                    System.out.printf("The division of %d and %d is %.2f",n1,n2,(double)n1/n2);
                }else{
                    System.out.println("Division by zero is not allowed");
                }
                break;
            case '%':
                System.out.printf("The modulo division of %d and %d is %d",n1,n2,(n1%n2));
                break;
            default:
                System.out.print("Invalid operation");
                break;
        }sc.close();
    }
}