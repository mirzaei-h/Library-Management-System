package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserRepo extends DBConnection {
    public static void addUser(String firstname, String lastname){

        try{
            Connection con= DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into user(firstname,lastname) values(?,?)");
            ps.setString(1,firstname);
            ps.setString(2,lastname);
            ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
    }
    public  void listuser() {

        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM user";

            // create the java statement
            Statement st = con.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");


                // print the results
                System.out.format("%s, %s, %s\n", id, firstname, lastname);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        }
    }

}
