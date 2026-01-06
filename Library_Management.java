import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Book{
    String bname;
    int bid;
    String a_name;
    boolean isAvailable;
    Book(String bname,int bid,String a_name){
        this.bname=bname;
        this.bid=bid;
        this.a_name=a_name;
        this.isAvailable=true;
    }
    @Override
    public String toString() {
        return "Book ID: " + bid +
                ", Name: " + bname +
                ", Author: " + a_name +
                ", Status: " + (isAvailable ? "Available" : "Borrowed");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return bid == book.bid;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(bid);
    }
}

class Member{
    String m_name;
    int m_id;
    List<Book> borrow;
    Member(String m_name,int m_id){
        this.m_name=m_name;
        this.m_id=m_id;
        this.borrow=new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Member ID: " + m_id +
                ", Name: " + m_name +
                ", Borrowed Books: " + borrow.size();
    }
}
public class Library_Management {
    static HashMap<Integer,Book>book=new HashMap<>();
    static HashMap<Integer,Member>mem=new HashMap<>();
    public static void add_Books(String bname,int bid,String a_name){
        if(book.containsKey(bid)){
            System.out.println("Book already exists....");
            return;
        }
        Book bk=new Book(bname,bid,a_name);
        book.put(bid,bk);
        System.out.println("Book added successfully....");
    }

    public static void add_Member(String m_name,int m_id){
        if(mem.containsKey(m_id)){
            System.out.println("Member already exists....");
            return;
        }
        Member member=new Member(m_name,m_id);
        mem.put(m_id,member);
        System.out.println("Member added successfully....");
    }

    public static void borrow_Books(int m_id,int b_id){
        Member member = mem.get(m_id);
        Book bk = book.get(b_id);

        if (member == null || bk == null) {
            System.out.println("Invalid member ID or book ID.");
            return;
        }

        if (!bk.isAvailable) {
            System.out.println("Book already borrowed.");
            return;
        }

        member.borrow.add(bk);
        bk.isAvailable = false;
        System.out.println("Book borrowed successfully...");
    }

    public static void return_Book(int m_id,int b_id){
        Member member = mem.get(m_id);
        Book bk = book.get(b_id);

        if (member == null || bk == null) {
            System.out.println("Invalid member ID or book ID.");
            return;
        }

        if (!member.borrow.contains(bk)) {
            System.out.println("This member has not borrowed this book.");
            return;
        }

        member.borrow.remove(bk);
        bk.isAvailable = true;
        System.out.println("Book returned successfully...");
    }

    public static void display_Member(){
        if (mem.isEmpty()) {
            System.out.println("No members available.");
            return;
        }
        System.out.println("Members available are....");
        for (Member m : mem.values()) {
            System.out.println(m);
        }
    }

    public static void display_Book(){
        if (book.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Books available are....");
        for (Book b : book.values()) {
            System.out.println(b);
        }
    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        boolean run=true;
        while(run){
            System.out.println("\n----- Library Management System -----");
            System.out.println("What you need to do\n1.Add Book\n2.Add member\n3.Borrow Book\n4.Return Book\n5.Display Books\n6.Display Members\n7.Exit");
            int n=sc.nextInt();
            switch(n){
                case 1:
                    char c;
                    sc.nextLine();
                    do {
                        System.out.println("Enter book name: ");
                        String bname = sc.nextLine();

                        System.out.println("Enter book id: ");
                        int bid = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter author name: ");
                        String a_name = sc.nextLine();

                        add_Books(bname, bid, a_name);

                        System.out.println("Add another book? (y/n): ");
                        c = sc.next().charAt(0);
                        sc.nextLine();
                    } while (c == 'y');

                    break;

                case 2:
                    char d;
                    sc.nextLine();
                    do{
                        System.out.println("Enter your name: ");
                        String m_name=sc.nextLine();
                        System.out.println("Enter your member id: ");
                        int m_id=sc.nextInt();
                        add_Member(m_name,m_id);
                        System.out.println("Do you want to add member....");
                        d=sc.next().charAt(0);
                        sc.nextLine();
                    }while(d=='y');
                    break;

                case 3:
                    System.out.println("Enter member id: ");
                    int mId=sc.nextInt();
                    System.out.println("Enter book id: ");
                    int bId=sc.nextInt();
                    borrow_Books(mId,bId);
                    break;

                case 4:
                    System.out.println("Enter member id: ");
                    int m_Id=sc.nextInt();
                    System.out.println("Enter book id: ");
                    int b_Id=sc.nextInt();
                    return_Book(m_Id,b_Id);
                    break;

                case 5:
                    display_Book();
                    break;

                case 6:
                    display_Member();
                    break;

                case 7:
                    System.out.println("Exiting Program.....");
                    run=false;
                    break;

                default:
                    System.out.println("Invalid input....");
            }
        }
    }
}