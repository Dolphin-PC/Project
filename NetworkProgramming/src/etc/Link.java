package etc;
import java.sql.*;


public class Link {
      
      public static void main(String[] args)
      {
       
         // Create a variable for the connection string.  
          String connectionUrl = "jdbc:sqlserver://10.50.229.59:1433;" +  
             "databaseName=Project3;user=sql;password=1234";  

          // Declare the JDBC objects.  
          Connection con = null;  
          Statement stmt = null;  
          ResultSet rs = null;  

          try {  
             // Establish the connection.  
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
             con = DriverManager.getConnection(connectionUrl);  

             // Create and execute an SQL statement that returns some data.  
             String SQL = "SELECT ��ġ���,��ȭ��ȣ FROM ['������ �ڵ�������ݱ���']";  
             stmt = con.createStatement();  
             rs = stmt.executeQuery(SQL);  

             // Iterate through the data in the result set and display it.  
             while (rs.next()) {  
                System.out.println(rs.getString("��ġ���") + " " + rs.getString("��ȭ��ȣ"));  
             }  
          }  

          // Handle any errors that may have occurred.  
          catch (Exception e) {  
             e.printStackTrace();  
          }  
          finally {  
             if (rs != null) try { rs.close(); } catch(Exception e) {}  
             if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
             if (con != null) try { con.close(); } catch(Exception e) {}  
          }  
         /*Connection conn = null;
         Statement stmt = null;
         
         try
         {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String connectionString = "jdbc:sqlserver://10.50.229.59:1433;" + "DatabaseName=Project3;user=sql;password=1234";
            
            conn = DriverManager.getConnection(connectionString);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select ��ġ���,��ȭ��ȣ from ['������ �ڵ�������ݱ���']");
            System.out.println("��ġ���   ��ȭ��ȣ");
            System.out.println("-------------");
            
            while(rs.next());
            {
              System.out.printf("%s %s %n",rs.getString("��ġ���") , rs.getString("��ȭ��ȣ"));
            }
         }
         catch(ClassNotFoundException cnfe)
         {
            System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
         }
         catch(SQLException se)
         {
            System.out.println(se.getMessage());
         }
         finally
         {
            try
            {
               stmt.close();
               conn.close();
            }
            catch(Exception e)
            {
               
            }
         }*/
      }
   
}