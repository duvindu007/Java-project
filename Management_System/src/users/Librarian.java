/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author ASUS
 */


//import Classes from packages
import Books.Books;
import Db.Connection_Class;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



//Constructor overloading

public class Librarian implements Users {
    
    private int id;
    private String username;
    private String password;
    private String address;

    
    
    
    public Librarian(){
    
    
    }
    
    
    public Librarian(String username,String password){
    this.username=username;
    this.password=password;
    
    
    }
    
        public  Librarian(int id, String username, String password,String address) {
        this.id = id;
        this.username =username;
        this.address = address;
        
    }
      
      public Librarian(String username,String address,String password){
      this.username=username;
     
      this.address= address;
      this.password=password;
      
      
      }
      //geters
     public int getId() {
        return id;
    }

    public String getName() {
        return  username;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword(){
    
    return password;
    
    }
    
  
    //seters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setPassword(String password){
    
    this.password = password;
    
    }
    
  

    public  int  signUp(Librarian c) throws ClassNotFoundException, SQLException{
      Connection con ;
      Statement stat;

       con = Connection_Class.conDb(); //open the connection
      
      stat = con.createStatement();
      String sql = "insert into Librarian values('"+c.getName()+"','"+c.getAddress()+"','"+c.getPassword()+"')"; 
      System.out.println(sql);
      int i = stat.executeUpdate(sql);
      stat.close();
      con.close();//closing the connection
      return i;
    
    }

    
    
    public int issueBooks(Books b, Member c) throws SQLException{
    
    Connection con;
    Statement stat;
    
    con=Connection_Class.conDb();//open the connection
    
    stat=con.createStatement();
    String sql = "Update Member set Book_ID ="+b.getId()+", Borrow_Date ='"+c.getBarrowDate()+"',Return_Date='"+c.getReturnDate()+"' where M_ID =" +c.getId()+"";
     System.out.println(sql); 
     int i =stat.executeUpdate(sql);
     stat.close();
     con.close();//closing the connection
     
        
        return i;

    }

public int returnBooks( Member m ) throws SQLException{

Connection con;
Statement stat;

con=Connection_Class.conDb();//open the connection

stat=con.createStatement();
String sql = "Update Member set Book_ID = null ,Borrow_Date= null, Return_Date=null where M_ID="+m.getId()+"";
   System.out.println(sql); 
     int i =stat.executeUpdate(sql);
     stat.close();
     con.close();//closing the connection
     
        
        return i;



}    

public boolean logIn(Librarian l) throws SQLException{
Connection conn;
Statement stat;

conn=Connection_Class.conDb();

stat=conn.createStatement();
String sql = "Select * from Librarian where Name='"+l.getName()+"'  and  password_='"+l.getPassword()+"'";


System.out.println(sql);

ResultSet rs= stat.executeQuery(sql);

while(rs.next()){
return true;

}
stat.close();
conn.close();
return false;


}

    @Override
    public String welCome() {
     return "Welcome Librarian";
    }
    
}




