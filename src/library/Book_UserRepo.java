package library;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Book_UserRepo extends DBConnection {
    static final String QUERY_SELECTBOOKTBL = "SELECT id," +
            " name, author" + "  FROM books";
    java.util.Date date = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    public static Scanner scanner = new Scanner(System.in);
    String validation;

    //verify User name
    public boolean verifyUser(String lastName) {
        try {
            //select statement to verify User name
            Connection connection= DBConnection.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet selectResult = selectStatement.executeQuery(
                    "SELECT * FROM User " +
                            "WHERE lastname ='" + lastName + "'; ");
            while (selectResult.next()) {
                //First Column
                int id = selectResult.getInt("id");
                String firstname = selectResult.getString("firstname");
                String lastname = selectResult.getString("lastname");

                // print the results
                System.out.format("%s, %s, %s\n", id, firstname, lastname);

                System.out.println("is this information yours?" +
                        "please type yes if Yes and type No if N0");
                validation = scanner.nextLine();
                if (validation == "yes") {
                    System.out.println("awesome!");
                }
                return true;
            }
            selectStatement.close();

        } catch (SQLException e) {
            System.out.println("error...!");
            e.printStackTrace();
        }
        System.out.println("you are not registered Yet!");
        return false;
    }

    // verify book name
    public boolean verifyAndBorrowBook(String bookName) {
        try {
            //select statement to verify book name
            Connection connection= DBConnection.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet selectResult = selectStatement.executeQuery(
                    "SELECT * FROM books " +
                            "WHERE name ='" + bookName + "' " +
                            "and Status ='" + Status.RETURN.ordinal()
                            + "'; ");
            while (selectResult.next()) {
                //First Column
                int id = selectResult.getInt("id");
                String name = selectResult.getString("name");
                String author = selectResult.getString("author");
                int status = selectResult.getInt("status");
                // print the results
                System.out.format("%s, %s, %s, %s\n", id, name, author, status);

                System.out.println("this book is available to borrow, " +
                        "do you want to borrow?" +
                        "please type 1 if Yes and type 0 if No");
                validation = scanner.nextLine();
                if (Objects.equals(validation, "yes")) {
                    //updating status in book table
                    Statement updateStatement = connection.createStatement();
                    String sqlUpdate = "UPDATE books " +
                            "SET Status = '" + Status.BORROW.ordinal()
                            + "'" +
                            " WHERE Name ='" + bookName + "' ";
                    updateStatement.executeUpdate(sqlUpdate);
                    ResultSet updateResult = updateStatement.
                            executeQuery(QUERY_SELECTBOOKTBL);
                    updateResult.close();
                    System.out.println("this book is borrowed by you");
                }
                return true;
            }
            selectStatement.close();
        } catch (SQLException e) {
            System.out.println("error...!");
            e.printStackTrace();
        }
        System.out.println("this book is not available!");
        return false;
    }

    //inserting data in Book_User
    public void insertingBookUserTbl(String lastName, String selectedBookName) {
        try {
            Connection connection= DBConnection.getConnection();
            PreparedStatement selectStatementUser = connection.prepareStatement(
                    "SELECT * FROM User WHERE lastname ='" + lastName + "'; ");
            ResultSet resultSetSelectUser = selectStatementUser
                    .executeQuery();
            resultSetSelectUser.next();
            int userFk = Integer.parseInt(resultSetSelectUser.getString(1));
            PreparedStatement selectStatementBook = connection.prepareStatement(
                    "SELECT * FROM Books WHERE name ='"+selectedBookName+"';");
            ResultSet resultSetSelectBook = selectStatementBook
                    .executeQuery();
            resultSetSelectBook.next();
            int bookFK = Integer.parseInt(resultSetSelectUser.getString(1));
            PreparedStatement preparedStatementBookUser = connection
                    .prepareStatement("insert into Book_User(" +
                            "createDate ,status ,bookFk ,userFk)" +
                            " values(?,?,?,?)");

            preparedStatementBookUser.setDate(1, sqlDate);
            preparedStatementBookUser.setInt(2, Status.BORROW.ordinal());
            preparedStatementBookUser.setInt(3, bookFK);
            preparedStatementBookUser.setInt(4, userFk);
            preparedStatementBookUser.executeUpdate();

            System.out.println("table Book_User updated successfully :)");
            connection.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        }
    }
}
