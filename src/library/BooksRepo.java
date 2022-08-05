package library;

import java.sql.*;
import java.util.Scanner;

public class BooksRepo extends DBConnection{

    public void addBook(String title,  String author ){

        try{
            Connection con= DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into books(name,author,status) values(?,?,?)");
            ps.setString(1,title);
            ps.setString(2,author);
            ps.setInt(3,Status.RETURN.ordinal());
            ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}

    }

    public  void listBooks() {
        try {
            Connection con= DBConnection.getConnection();
            String query = "SELECT * FROM books WHERE status = 1";
            // create the java statement
            Statement st = con.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("name");
                String author = rs.getString("author");
                int status = rs.getInt("status");
                // print the results
                System.out.format("%s, %s, %s, %s\n", id, title, author, status);
            }
            st.close();}
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }



}
