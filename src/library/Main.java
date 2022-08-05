package library;


import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        BooksRepo bookRepo = new BooksRepo();
        UserRepo userRepo = new UserRepo();
        Book_UserRepo bookUserRepo = new Book_UserRepo();
        System.out.println("From the menu enter the action you want:");
        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt((scanner.nextLine()));
            // choosing number 0-6 from the menu

            switch (choice) {
                // adding books
                case 1:
                    getBook(scanner, bookRepo);
                    break;

                // Showing All available Books
                case 2:
                    bookRepo.listBooks();
                    break;

                // adding user
                case 3:
                    getUser(scanner, userRepo);
                    break;

                // Showing All Registered Students
                case 4:
                    userRepo.listuser();
                    break;

                // borrowing the Books
                case 5:
                    getBorrow( scanner, bookUserRepo);
                    break;


                // if above cases does not match do the default one
                default:
                    System.out.println("ENTER BETWEEN 0 TO 5.");
            }
        } while (choice != 0);
    }

        public static void displayMenu() {
            // Display menu
            System.out.println("-----------------------------------------");
            System.out.println("Press 0 to Exit Application.");
            System.out.println("Press 1 to Add new Book.");
            System.out.println("Press 2 to Show All available Books.");
            System.out.println("Press 3 to Register member.");
            System.out.println("Press 4 to Show All Registered Members.");
            System.out.println("Press 5 to borrow the Book. ");
            System.out.println("----------------------------------------");

        }

        private static void getBook(Scanner scanner, BooksRepo bookRepo) {
            System.out.println("Enter a book name:");
            String bookName = scanner.nextLine();
            System.out.println("Enter author name:");
            String authorName = scanner.nextLine();
            bookRepo.addBook(bookName, authorName);
        }

        private static void getUser(Scanner scanner, UserRepo userRepo) {
            System.out.println("Enter your first name:");
            String fname = scanner.nextLine();
            System.out.println("Enter your last name:");
            String lname = scanner.nextLine();
            userRepo.addUser(fname, lname);


        }

        private static void getBorrow(Scanner scanner, Book_UserRepo bookUserRepo){
            System.out.println("Enter your last name:");
            String lastName = scanner.nextLine();
            bookUserRepo.verifyUser(lastName);
            if (Objects.equals(scanner, "yes")) {
                System.out.println("Enter book name:");
                String borrowBookName = scanner.nextLine();
                bookUserRepo.verifyAndBorrowBook(borrowBookName);
                bookUserRepo.insertingBookUserTbl(lastName,
                        borrowBookName);
            }
        }

   }


