/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;

import Db.Connection_Class;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author duvindu
 */
public class Books {
    
  private int bookid;
  private  String bookname;
  private String bookauthor;
  private String category;
  private String price;
  private String availability;
  
  
  
  //Constructor overloading
  
  public Books(int bookid){
  this.bookid= bookid;
  
  
  
  }
  
  public Books(){
  
  
  
  }
  
  
  public Books(int bookid,String availability){
  
      this.bookid=bookid;
  this.availability=availability;
  
  
  }
  
    public Books(int bookid,String bookname,String category,String bookauthor,String price,String availability){
     this.bookid = bookid;
     this.bookname = bookname;
     this.bookauthor= bookauthor;
     this.price = price;
     this.category= category;
      this.availability=  availability;
    }
    
    
    
    
    public Books(String bookname,String category ,String price,String bookauthor,String availability){
    this.bookname=bookname;
    this.bookauthor=bookauthor;
    this.price = price;
    this.category= category;
    this.availability=availability;
    
    }


    
    
    //geters
     public int getId() {
        return bookid;
    }

    public String getName() {
        return  bookname;
    }

    public String getAuthor() {
        return bookauthor;
    }

    public String getPrice(){
    
    return price;
    
    }
    public String getCategory(){
    
    return category;
    
    }
    
    public String getAvailability(){
    return availability;
    
    }
    
    
    
    //seters
      public void setId(int id) {
        this.bookid = id;
    }

    public void setName(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String bookauthor) {
        this.bookauthor =bookauthor;
    }
    public void setPrice(String price){
    
    this.price = price;
    
    }
    
    public void setCategory(String category){
    
    this.category = category;
    
    } 
    
    public void setAvailability_(String availability){
    this.availability= availability;
    
    
    }
    
     public int addBooks(Books b) throws SQLException{
    Connection conn;
Statement stat;
      
conn= Connection_Class.conDb();
stat = conn.createStatement();
String sql = "insert into Books values('"+b.getName()+"','"+b.getCategory()+"','"+b.getAuthor()+"','"+b.getPrice()+"','"+b.getAvailability()+"')"; 
        int i = stat.executeUpdate(sql);
        stat.close();
conn.close();
return i;
    
    
    
    }
    
    public  int  deletebooks(Books b) throws SQLException{

     Connection conn;
     Statement stat;
     
     conn= Connection_Class.conDb();
     stat=conn.createStatement();
     
    String sql ="Delete from Books where B_Id ="+b.getId()+"";
    
      int i = stat.executeUpdate(sql);
      stat.close();
      conn.close();
      return i;
     


}  
    
    
    
    public int setAvailability(Books b) throws SQLException{
    Connection conn;
    Statement stat;
    
    conn=Connection_Class.conDb();
    stat=conn.createStatement();
    
    String sql="Update  Books set Availability_= '"+b.getAvailability()+"' where B_Id ="+b.getId()+"";
    
    int i = stat.executeUpdate(sql);
    stat.close();
    conn.close();
    
    
    return i;
    
    
    
    
    }
    
     public ArrayList<Books> viewBooks() throws SQLException{
   
        Connection conn;
        Statement stat;
       
       conn=Connection_Class.conDb();
       stat = conn.createStatement();
       ArrayList<Books> bookList = new ArrayList<>();
       
       String sql = "Select * from Books";
   ResultSet rs;
   
   
   rs = stat.executeQuery(sql);
  Books b;
   while(rs.next()){
   
   b= new Books(rs.getInt("B_Id"),rs.getString("B_Name"),rs.getString("Category"),rs.getString("Author"),rs.getString("price"),rs.getString("Availability_"));
   bookList.add(b);
   
 
   }

   
 
     return bookList;
   
   
   } 
       
}
