package jukeboximpl;

import java.sql.Connection;
import java.sql.*;

public class DBConnection {

    public static Connection getConnection()
    {
        Connection connection=null;
        try
        {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","Vishvaja@0105");
          //  System.out.println("Connected Successfully");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
