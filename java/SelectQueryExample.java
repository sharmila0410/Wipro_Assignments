import java.io.IOException;
import java.sql.*;
public class SelectQueryExample {
    public static void main(String[]args){

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampleDB","username", "password");

            String sql = "SELECT * FROM users WHERE username=?";
            ps = con.ps(sql);

            String usernameInput = "desiredUsername";
            ps.setString(1, usernameInput);

            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("Username:"+rs.getString("username"));
                System.out.println("email:"+rs.getString("email"));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(rs!= null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

    }
    
}
