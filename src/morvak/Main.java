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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
class Main {
    /**
     * @param args the command line arguments
     */
    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst = null;
    

  private String sqlSelectStatementBuilder(String tableName, String ...columnNames){
    StringBuilder sqlBuilder = new StringBuilder("select "); // avoid using string when you gonna be appending to it. Use string builders for efficiency
    int count = 0;
    for(String column: columnNames){
      if(!column.isEmpty()){ // we really dont need this but its just a safety check
        sqlBuilder.append(column);
        sqlBuilder.append(", ");
        ++count;
      }
    }

    if(count == 0) sqlBuilder.append("* ");
    sqlBuilder.append("from ");
    sqlBuilder.append(tableName);
    return sqlBuilder.toString();
  }
  
  public ResultSet select_update(String table_name, String ... columnNames){
    con = Connect2.ConnectDB();
    String sql  = sqlSelectStatementBuilder(table_name, columnNames);
    try{
        pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            //userAccounts_table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
    }
    return rs;
  }

  public static void main(String[] args) {
    //you can call by doing thiss
      
    Main m = new Main();
    //m.select_update("users", /*you can pass 0 to 1 paramenters*/ "UserID", "Username", "typeName");
    m.select_update("user_types");
    
    ArrayList items = new ArrayList<Object>();
  }
}
