/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morvak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;  // for current year
/**
 *
 * @author Thulani Mpofu ask TOLANY-LANNIE
 */
public class GeneralFunctions {

    /**
     * @param args the command line arguments
     */
    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst = null;
    
    
    /*public void comboFunction(String query, String ...columnNames){
        con = Connect2.ConnectDB();
        
    }*/
    public String showLoggedInUser(String query, String username){
        String userID = retrieveColumnValue("select * from users where Username ='"+username+"' ", "UserID");
        return"";
        
    }
    
    //function to retrieve mysql table content to the diffirent combo boxes in the application.
    public ArrayList<Object> comboFunction(String query, String columnName){
        con = Connect2.ConnectDB();
        ArrayList items = new ArrayList<Object>();
        try {
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                items.add(rs.getString(columnName));
                //coscombo_txt.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return items;
    }
    
 
    //function to retrieve mysql table content to populate table functions in the application.
    public ResultSet retrieveTable(String query){
        con = Connect2.ConnectDB();
        try{
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();   
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
    //methods retrieves a tuple value at a particular column of the table
    public String retrieveColumnValue(String query, String columnName){
        String value="";
        try{
            
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()){
                value = rs.getString(columnName);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return  value;
    }
    //methods to retrieve  the ID of the first record from any table in the database
    public String retrieveFirstID(String query, String columnName){
        GeneralFunctions fc = new GeneralFunctions();
        String value ="";
       try{
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();
                if(rs.next()){
                    value = rs.getString(columnName); //retrieves that last record user id from the database
                    value =idUpdater(value);
                    
                }
                else{
                    char [] tableName= columnName.toUpperCase().toCharArray(); //table name is made to a char array
                    char [] id = new char[2];
                    for(int i=0;i<id.length;i++){
                        id[i]=tableName[i];
                    }
                   String result ="";
                   for(char rt: id){
                    result+=rt;
                   }
                    result+= fc.currentYear()+"0001";
                    value=result;
                   }
                  
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Table has no records","Application checker",JOptionPane.ERROR_MESSAGE);
            }
        return value;
    }
    
    //set current year
    public String currentYear(){
     Date d=new Date();  
     int cYear =d.getYear();
     cYear+=1900;
     String year = Integer.toString(cYear);
     return year;
    }
    
    //function to auto increment IDs for the different table based on the initial ID retrieve from any table
    private String idUpdater(String input){
        char [] chars = input.toCharArray();
        int num =Character.getNumericValue(chars[chars.length-1]);
        if(num<=8){
            num++;
            char c = (char)(num+'0');
            chars[chars.length-1] =c;
        }
        else if(num==9){
            int num1 =Character.getNumericValue(chars[chars.length-2]);//takes the preceedig value
            if(num1<=8){
            num1++;
            char c = (char)(num1+'0');
            chars[chars.length-2] =c;
            chars[chars.length-1] ='0';
            }
	    else if(num1==9){
            int num2 =Character.getNumericValue(chars[chars.length-3]);//takes the preceedig value
            if(num2<=8){
            num2++;
            char c = (char)(num2+'0');
            chars[chars.length-3] =c;
            chars[chars.length-2] ='0';
            chars[chars.length-1] ='0';
            }
            else if(num2==9){
            int num3 =Character.getNumericValue(chars[chars.length-4]);//takes the preceedig value
            if(num3<=8){
            num3++;
            char c = (char)(num3+'0');
            chars[chars.length-4] =c;
            chars[chars.length-3] ='0';
            chars[chars.length-2] ='0';
             chars[chars.length-1] ='0';
            }
            else if(num3==9){
            int num4 =Character.getNumericValue(chars[chars.length-5]);//takes the preceedig value
            if(num4<=8){
            num4++;
            char c = (char)(num4+'0');
            chars[chars.length-5] =c;
            chars[chars.length-4] ='0';
            chars[chars.length-3] ='0';
            chars[chars.length-2] ='0';
            chars[chars.length-1] ='0';
           }
            else if(num4==9){
            int num5 =Character.getNumericValue(chars[chars.length-6]);//takes the preceedig value
            if(num5<=8){
            num5++;
            char c = (char)(num5+'0');
            chars[chars.length-6] =c;
            chars[chars.length-5] ='0';
            chars[chars.length-4] ='0';
            chars[chars.length-3] ='0';
            chars[chars.length-2] ='0';
            chars[chars.length-1] ='0';
           }
            
            else if(num4==9){
            int num6 =Character.getNumericValue(chars[chars.length-7]);//takes the preceedig value
            if(num6<=8){
            num6++;
            char c = (char)(num6+'0');
            chars[chars.length-7] =c;
            chars[chars.length-6] ='0';
            chars[chars.length-5] ='0';
            chars[chars.length-4] ='0';
            chars[chars.length-3] ='0';
            chars[chars.length-2] ='0';
            chars[chars.length-1] ='0';
           }
            
           else if(num4==9){
            int num7 =Character.getNumericValue(chars[chars.length-8]);//takes the preceedig value
            if(num7<=8){
            num7++;
            char c = (char)(num7+'0');
            chars[chars.length-8] =c;
            chars[chars.length-7] ='0';
            chars[chars.length-6] ='0';
            chars[chars.length-5] ='0';
            chars[chars.length-4] ='0';
            chars[chars.length-3] ='0';
            chars[chars.length-2] ='0';
            chars[chars.length-1] ='0';
           }
                   
            
        }
        }
        }
        }
        }
        }
        }
        String result ="";
        for(char rt: chars){
            result+=rt;
        }
        return result;
    }
    
    
 
    /*public static void main (String [] args){
         GeneralFunctions fc = new GeneralFunctions();
         ArrayList list = new ArrayList<>();
         list = fc.comboFunction("Select * from user_types","Type_name");
         for(Object o: list){
            System.out.println(o);
         }
          System.out.println(fc.studentIDGenerator(null));
         
    }*/
}
