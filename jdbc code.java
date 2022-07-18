import java.sql.*;
import oracle.jdbc.*;
import java.math.*;
import java.io.*;
import java.awt.*;
import oracle.jdbc.pool.OracleDataSource;

public class cust {

   public static void main (String args []) throws SQLException {
    try
    {

      //Connection to Oracle server. Need to replace username and
      //password by your username and your password. For security
      //consideration, it's better to read them in from keyboard.
      OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
      ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
      Connection conn = ds.getConnection("rravika1", "Ramfam21121997");

      // Query
      Statement stmt = conn.createStatement ();

      // Save result
        ResultSet rset;
        rset = stmt.executeQuery ("SELECT * FROM customers");

      // Print
      while (rset.next ()) {
         System.out.print (rset.getString (1)+"  ");
         System.out.print (rset.getString (2)+"  ");
         System.out.print (rset.getString (3)+"  ");
         System.out.println (rset.getString (4)+"  ");
	}
     //Input sid from keyboard
        BufferedReader  readKeyBoard;
        String icid;
        readKeyBoard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter CID:");
        icid = readKeyBoard.readLine();
        ResultSet rset2;
        rset2=stmt.executeQuery ("Select * from customers where cid='"+icid +"'");

         // Print
      while (rset2.next ()) {
         System.out.print (rset2.getString (1)+"  ");
         System.out.print (rset2.getString (2)+"  ");
         System.out.print (rset2.getString (3)+"  ");
         System.out.println (rset2.getString (4)+"  ");

	
      }

      //close the result set, statement, and the connection
      rset.close();
      rset2.close();
      stmt.close();
      conn.close();
   }
     catch (SQLException ex) { System.out.println ("\n*** SQLException caught ***\n");} 
     catch (Exception e) {System.out.println ("\n*** other Exception caught ***\n");}
   }
}
