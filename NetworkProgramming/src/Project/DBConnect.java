package Project;
import java.sql.*;
import java.util.ArrayList;


public class DBConnect {
      
      public static void main(String[] args)
      {       
          
      }
      public static ArrayList<String>Tour(String Loc,String Loc2){
    	  String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=����������;user=pcy;password=1111";  
	       ArrayList<String> Loca = new ArrayList<String>();

    	          Connection con = null;  
    	          Statement stmt = null;  
    	          ResultSet rs = null;  

    	          try {  
    	             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    	             con = DriverManager.getConnection(connectionUrl);  

    	             String SQL = "SELECT distinct �������� FROM [����$] where ������ = '" + Loc + "' and " + "�������� = '" + Loc2 + "'"  ;  
    	             stmt = con.createStatement();  
    	             rs = stmt.executeQuery(SQL);

    	             while (rs.next()) {   
    	                Loca.add(rs.getString("��������"));
    	             }  
    	          }  

    	          catch (Exception e) {  
    	             e.printStackTrace();  
    	          }  
    	          finally {  
    	             if (rs != null) try { rs.close(); } catch(Exception e) {}  
    	             if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
    	             if (con != null) try { con.close(); } catch(Exception e) {}  
    	          }  
    	          return Loca;
      }
      public static ArrayList<String>Location_2(String Loc){
    	  String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=����������;user=pcy;password=1111";  
	       ArrayList<String> Loca = new ArrayList<String>();

    	          Connection con = null;  
    	          Statement stmt = null;  
    	          ResultSet rs = null;  

    	          try {  
    	             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    	             con = DriverManager.getConnection(connectionUrl);  

    	             String SQL = "SELECT distinct �������� FROM [����$] where ������ = '" + Loc + "'";  
    	             stmt = con.createStatement();  
    	             rs = stmt.executeQuery(SQL);

    	             while (rs.next()) {   
    	                Loca.add(rs.getString("��������"));
    	             }  
    	          }  

    	          catch (Exception e) {  
    	             e.printStackTrace();  
    	          }  
    	          finally {  
    	             if (rs != null) try { rs.close(); } catch(Exception e) {}  
    	             if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
    	             if (con != null) try { con.close(); } catch(Exception e) {}  
    	          }  
    	          return Loca;
      }
      
      public static ArrayList<String>Location(){
		   String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=����������;user=pcy;password=1111";  
	       ArrayList<String> Loc = new ArrayList<String>();
	       Connection con = null;  
	       Statement stmt = null;  
	       ResultSet rs = null;  
	
	       try {  
	          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	          con = DriverManager.getConnection(connectionUrl);  
	
	          String SQL = "SELECT distinct ������ FROM [����$]";  
	          stmt = con.createStatement();  
	          rs = stmt.executeQuery(SQL);  
	
	          while (rs.next()) {  
	             Loc.add(rs.getString("������"));
	          }  
	       }  
	
	       catch (Exception e) {  
	          e.printStackTrace();  
	       }  
	       finally {  
	          if (rs != null) try { rs.close(); } catch(Exception e) {}  
	          if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
	          if (con != null) try { con.close(); } catch(Exception e) {}  
	       }
	       return Loc;
	   }
   
}