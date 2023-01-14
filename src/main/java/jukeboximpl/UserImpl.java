package jukeboximpl;

import com.mysql.cj.protocol.Resultset;
import jukeboxinterfaces.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserImpl implements UserInterface {

  static  Connection connection=DBConnection.getConnection();


    static Scanner sc = new Scanner(System.in);

    @Override
    public boolean createAccount()
    {
        System.out.println("Enter a UserId:");
        String userid= sc.next();
        System.out.println("Enter a Password");
        String password= sc.next();
        System.out.println("Enter your Mobile Number ");
        String mobno = sc.next();
     try{

         String sql="insert into User(userid,password,mobno)values(?,?,?)";

         PreparedStatement st=connection.prepareStatement(sql);
         st.setString(1,userid);
         st.setString(2,password);
         st.setString(3,mobno);
         int rows= st.executeUpdate();
         System.out.println("*****------Jukebox account created Successfully------******");
         return true;
     }catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
     return false;
    }

    @Override
    public boolean login() {
        try {
            System.out.println("Enter your Existing UserId:");
            String userid = sc.next();
            System.out.println("Enter your Password");
            String password = sc.next();
            String query = "select * from user where UserId = ? and Password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Login Successfull");
                return true;
            }
            else{
                System.out.println("Invalid Credentials");
                System.exit(0);
            }

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }


}
