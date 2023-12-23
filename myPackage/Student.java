package myPackage;

import java.sql.*;

public class Student {
    
    public void createDatabase(String name){
        //driver load(don't need in new version)
        
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "PBD@1998";
            
            //connetion establish
            Connection conn = DriverManager.getConnection(url, userName, password);
            
            //statement create
            Statement stm = conn.createStatement();

            //execute query
            String query = "CREATE DATABASE IF NOT EXISTS "+name; 
            boolean bl = stm.execute(query);
            
            //connection close
            conn.close();

            System.out.println("database create and connection close successfully ");

        }catch (Exception e){
            e.printStackTrace();
        }          
          
    }
    
    public void createTable(){
            try{
                String url = "jdbc:mysql://localhost:3306/";
                String db = "mydatabase";
                String user = "root";
                String password = "PBD@1998";

                Connection con = DriverManager.getConnection(url+db, user, password);

                Statement st = con.createStatement();

                String q = "CREATE TABLE IF NOT EXISTS student( std_ID INT PRIMARY KEY NOT NULL,std_Name VARCHAR(100) NOT NULL,std_email VARCHAR(200))";
                st.execute(q);

                con.close();
                System.out.println("table created successfully");

            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public void createData(){
            try {
                String url = "jdbc:mysql://localhost:3306/mydatabase";
                // String db = "mydatabase";
                String user = "root";
                String password = "PBD@1998";

                Connection con = DriverManager.getConnection(url, user, password);

                // Statement st = con.createStatement();

                // String q = "INSERT INTO student(std_ID,std_Name,std_email) VALUES (1,'Preetam','preetamdas248@gmail.com')";
                // st.execute(q);
               

                //different way
                String query = "INSERT INTO student(std_ID,std_Name,std_email) VALUES (?,?,?)";
                PreparedStatement pstm = con.prepareStatement(query);

                pstm.setInt(1,5);
                pstm.setString(2, "Koushik");
                pstm.setString(3, "kp31@gmail.com");

                pstm.execute();
                // pstm.executeUpdate();
                // pstm.executeQuery(); not working

                System.out.println("data insert successfully");
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void readData(){
            try{
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String userName = "root";
            String password = "PBD@1998";
            
            //connetion establish
            Connection conn = DriverManager.getConnection(url, userName, password);
            
            //statement create
            Statement stm = conn.createStatement();

            //execute query
            String query = "SELECT * FROM student"; 
            // ResultSet rs = stm.executeQuery(query);
                boolean bl = stm.execute(query);
            // while (rs.next()) {
            //     System.out.print("std_ID : " + rs.getInt(1));
            //     System.out.print(" std_Name : " + rs.getString(2));
            //     System.out.println(" std_email : " + rs.getString(3));
            // }
            
            //connection close
            conn.close();

            System.out.println("read successfully"+bl);

        }catch (Exception e){
            e.printStackTrace();
        }          
          
        }

 
        public void updateData(){
        try {
                String url = "jdbc:mysql://localhost:3306/mydatabase";
                // String db = "mydatabase";
                String user = "root";
                String password = "PBD@1998";

                Connection con = DriverManager.getConnection(url, user, password);

                // Statement stm = con.createStatement();

                // String query = "UPDATE student SET std_ID = 4 WHERE std_ID = 5";

                // stm.execute(query);

                String query = "UPDATE student SET std_ID = ? WHERE std_Name = ?";
                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setInt(1, 15);
                pstm.setString(2, "Preetam");
                pstm.execute();

               System.out.println("update data successfully");
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        public void deleteData(){
        try {
            String url = "jdbc:mysql://localhost:3306/mydatabase";
                // String db = "mydatabase";
                String user = "root";
                String password = "PBD@1998";

                Connection con = DriverManager.getConnection(url, user, password);
                String query = "DELETE FROM student WHERE std_ID = ?";

                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setInt(1, 4);

                int n = pstm.executeUpdate();
            System.out.println("delete data successfully and affect on "+ n +" number of row"); 

            con.close();
               
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
