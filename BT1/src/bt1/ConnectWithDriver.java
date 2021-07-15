/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dung
 */
public class ConnectWithDriver {

    /**
     * @param args the command line arguments
     */
    
    public Connection con;
    private String url;
    public ConnectWithDriver() throws Exception{

        try{
            url="jdbc:sqlserver://localhost:1433;databaseName=hanghoa;user=sa;password=123456";
            con=DriverManager.getConnection(url);
            if(con != null){
                System.out.println("Connect sucessfull");
            }
        }
        catch(SQLException ex){
            System.out.println("Cannot connect database "+ex);
        }
        /*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName=hanghoa;user=sa;password=123456";
        con=DriverManager.getConnection(url);*/
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
           ConnectWithDriver cd = new ConnectWithDriver();
           String sql = "select MaSP, TenSP, TenLoaiSP from SanPham, LoaiSanPham where SanPham.MaLoaiSP = LoaiSanPham.MaLoaiSP";
                   //+ "where LoaiSanPham.MaLoaiSP = SanPham.MaLoaiSP ";
           PreparedStatement pre = cd.con.prepareStatement(sql);
           ResultSet rs = pre.executeQuery();
           String row = "";
           while(rs.next()){
               row += "Mã sản phẩm: " + rs.getString("MaSP");
               row += "Tên sản phẩm: " + rs.getString("TenSP");
               row += "\tTên loại sản phẩm: " + rs.getString("TenLoaiSP");
               System.out.println("Mã sản phẩm: " + rs.getString("MaSP") + "Tên sản phẩm: " + rs.getString("TenSP") + "    Tên loại sản phẩm: " + rs.getString("TenLoaiSP"));
               //System.out.println("Tên sản phẩm: " + rs.getString("TenSP"));
               //System.out.println("Tên loại sản phẩm: " + rs.getString("TenLoaiSP"));
           }
           //System.out.println(row);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
}