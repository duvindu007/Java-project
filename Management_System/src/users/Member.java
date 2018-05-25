package users;


//import packages

import Db.Connection_Class;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duvindu
 */
public class Member implements Users {
    
    private int id;
    private String user_Name;
    private String address;
    private String phone;
    private String barrowdate;
    private String returndate;
    private int bookid;


//Constructor overloading
    
      public Member(String user_Name,String phone,String address){
      this.user_Name=user_Name;
      this.phone = phone;
      this.address= address;
    
      
      
      }
      public Member(int id,String user_Name,String phone,String address,int bookid,String barrowdate,String returndate){
      this.id=id;
      this.user_Name=user_Name;
      this.phone=phone;
      this.address=address;
      this.bookid=bookid;
      this.barrowdate=barrowdate;
      this.returndate=returndate;

      }
      

      
      public Member(int id){
      
      this.id= id;
      
      }
      
      
      public Member(int id,String barrowdate, String returndate ){
      
      this.id = id;
   
      this.barrowdate=barrowdate;
      this.returndate=returndate;
      
      
      }

    public Member() {
       
    }

    
    //geters
     public int getId() {
        return id;
    }

     public String getBarrowDate(){
     
     return barrowdate;
     }
     
     public String getReturnDate(){
     
     
     return returndate;
     
     }
     
    public int getbookid(){
    
    return bookid;
    }
     
    public String getName() {
        return  user_Name;
    }

    public String getAddress() {
        return address;
    }

 
    
    public String getPhone(){
    
    return phone;
    
    }
    
    
    //seters
    
    public void setbookid(int bookid){
    this.bookid=bookid;
    
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String user_Name) {
        this.user_Name = user_Name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
  
    
    public void setPhone(String phone){
    
    this.phone = phone;
    
    }
    
    
    public void setBarrowDate(String barrowdate){
    this.barrowdate=barrowdate;
        
    }
    
    public void setReturnDate(String returndate){
    this.returndate=returndate;
    
    }
    
    

    public  int  signUp(Member c) throws ClassNotFoundException, SQLException{
      Connection con;
      Statement stat;

       con = Connection_Class.conDb();
      
      stat = con.createStatement();
      String sql = "insert into Member(M_Name,M_phone,M_Address) values('"+c.getName()+"','"+c.getPhone()+"','"+c.getAddress()+"')"; 
      System.out.println(sql);
      int i = stat.executeUpdate(sql);
      
      stat.close();
      con.close();
      
      return i;
    
    }

    
   public ArrayList<Member> viewMembers() throws SQLException{
   
        Connection conn;
        Statement stat;
       
       conn=Connection_Class.conDb();
       stat = conn.createStatement();
       ArrayList<Member> memberList = new ArrayList<>();
       
       String sql = "Select * from Member";
   ResultSet rs;
   
   
   rs = stat.executeQuery(sql);
  Member m;
   while(rs.next()){
   
   m= new Member(rs.getInt("M_ID"),rs.getString("M_Name"),rs.getString("M_phone"),rs.getString("M_Address"),rs.getInt("Book_ID"),rs.getString("Borrow_Date"),rs.getString("Return_Date"));
   memberList.add(m);
   
 
   }

   
 stat.close();
 conn.close();
     return memberList;
   
   
   } 

    @Override
    public String welCome() {
      return "Welcome Member";
    }
    
    
    
    
    
}
