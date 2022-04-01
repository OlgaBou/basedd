package projetWordPress;

import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class  SQLConnector {
	
	public static void  main(String[] args) throws  ClassNotFoundException, SQLException {
//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
String dbUrl = "jdbc:mysql://localhost:3306/wordpress";

//Database Username
String username = "wordpress";

//Database Password
String password = "wordpress";

//Query to Execute
String query = "DELETE FROM wp_posts WHERE `post_title` = 'new title';";

             //Load mysql jdbc driver
               Class.forName("com.mysql.jdbc.Driver");

            //Create Connection to DB
            java.sql.Connection con = DriverManager.getConnection(dbUrl,username,password);

          //Create Statement Object
          java.sql.Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
          int rs= stmt.executeUpdate(query);
          System.out.println(query);
          // While Loop to iterate through all data and print results
/*while (rs.next()){
        String myName = rs.getString(1);
                            String myAge = rs.getString(2);
                            System. out.println(rs);
                    } */
      // closing DB Connection
      con.close();
}
}