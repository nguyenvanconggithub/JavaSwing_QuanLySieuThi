/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

/**
 *
 * @author Admin
 */
import EntityClass.Hang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnectHang {
    private Connection con;
    private String url = "jdbc:mysql://localhost:3306/sieuthidb";
    private String classDriver = "com.mysql.cj.jdbc.Driver";
    private static ConnectHang instance = null;
    
    public static ConnectHang Instance(){
        if(instance == null){
            instance = new ConnectHang();
        }
        return instance;
    }
    public ConnectHang() {
    }


    private void OpenConnect(){
        try {
            Class.forName(classDriver);
            con = DriverManager.getConnection(url,"root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void CloseConnect(){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Hang> getDataGianHang(){
        ArrayList<Hang> danhSachHang = new ArrayList();
        try {
           OpenConnect();
           Statement stmt = con.createStatement();
           ResultSet data = stmt.executeQuery("SELECT * FROM hang WHERE SLGianHang != 0");
           while(data.next()){
               Hang newHang = new Hang();
               newHang.setMaSP(data.getString(1));
               newHang.setTenSP(data.getString(2));
               newHang.setPhanLoai(data.getString(3));
               newHang.setViTriKho(data.getString(4));
               newHang.setViTriGianHang(data.getString(5));
               newHang.setGiaNhap(data.getInt(6));
               newHang.setGiaBan(data.getInt(7));
               newHang.setKhuyenMai(data.getFloat(8));
               newHang.setSoLuongTonKho(data.getInt(9));
               newHang.setSoLuongGianHang(data.getInt(10));
               newHang.setDonVi(data.getString(11));
               newHang.setHanSuDung(data.getDate(12));
               
               danhSachHang.add(newHang);
           }
           
           stmt.close();
           data.close();
           CloseConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return danhSachHang;
    }
    // %a%' OR TenSP LIKE '%b%' OR MaSP LIKE '%a%' OR MaSP LIKE '%b% 
    private String querySearchForGuest(String searchText){
        String search = "";
        search = searchText.replace(" ", "%' OR TenSP LIKE '%");
        search = search.replace(search, "'%" + search + "%'" );
        return "SELECT * FROM hang WHERE (TenSP LIKE " + search + ")";
    }
    private String querySearchForManager(String searchText){
        String search = "";
        String searchMa;
        search = searchText.replace(" ", "%' OR TenSP LIKE '%");
        search = search.replace(search, "'%" + search + "%'" );
        searchMa = search.replace("TenSP", "MaSP");
        search += " OR MaSP LIKE ";
        search += searchMa;
        return "SELECT * FROM hang WHERE (TenSP LIKE " + search + ")";
    }
    public ArrayList<Hang> getDataSearchGuest(String searchText,boolean isDiscountChoose){
        ArrayList<Hang> danhSachHang = new ArrayList();
        try {
           OpenConnect();
           Statement stmt = con.createStatement();
           String query = querySearchForGuest(searchText) + " AND SLGianHang != 0";
           if(isDiscountChoose){
               query += " AND KhuyenMai != 0";
           }
           ResultSet data = stmt.executeQuery(query);
           while(data.next()){
               Hang newHang = new Hang();
               newHang.setMaSP(data.getString(1));
               newHang.setTenSP(data.getString(2));
               newHang.setPhanLoai(data.getString(3));
               newHang.setViTriKho(data.getString(4));
               newHang.setViTriGianHang(data.getString(5));
               newHang.setGiaNhap(data.getInt(6));
               newHang.setGiaBan(data.getInt(7));
               newHang.setKhuyenMai(data.getFloat(8));
               newHang.setSoLuongTonKho(data.getInt(9));
               newHang.setSoLuongGianHang(data.getInt(10));
               newHang.setDonVi(data.getString(11));
               newHang.setHanSuDung(data.getDate(12));
               
               danhSachHang.add(newHang);
           }
           
           stmt.close();
           data.close();
           CloseConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachHang;
    }
    public ArrayList<Hang> getDataSearchManager(String searchText){
        ArrayList<Hang> danhSachHang = new ArrayList();
        try {
           OpenConnect();
           Statement stmt = con.createStatement();
           String query = querySearchForManager(searchText) + " AND SLGianHang != 0";
           ResultSet data = stmt.executeQuery(query);
           while(data.next()){
               Hang newHang = new Hang();
               newHang.setMaSP(data.getString(1));
               newHang.setTenSP(data.getString(2));
               newHang.setPhanLoai(data.getString(3));
               newHang.setViTriKho(data.getString(4));
               newHang.setViTriGianHang(data.getString(5));
               newHang.setGiaNhap(data.getInt(6));
               newHang.setGiaBan(data.getInt(7));
               newHang.setKhuyenMai(data.getFloat(8));
               newHang.setSoLuongTonKho(data.getInt(9));
               newHang.setSoLuongGianHang(data.getInt(10));
               newHang.setDonVi(data.getString(11));
               newHang.setHanSuDung(data.getDate(12));
               
               danhSachHang.add(newHang);
           }
           
           stmt.close();
           data.close();
           CloseConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachHang;
    }
    
    public Hang getHangChuaLenGianHangByMaSP(String MaSP){
        Hang result = new Hang();
        try {
           OpenConnect();
           Statement stmt = con.createStatement();
           String query = "SELECT * FROM hang WHERE MaSP='"+MaSP+"' AND SLGianHang = 0";
           //System.out.println(query);
           ResultSet data = stmt.executeQuery(query);
           while(data.next()){
               result.setMaSP(data.getString(1));
               result.setTenSP(data.getString(2));
               result.setPhanLoai(data.getString(3));
               result.setViTriKho(data.getString(4));
               result.setViTriGianHang(data.getString(5));
               result.setGiaNhap(data.getInt(6));
               result.setGiaBan(data.getInt(7));
               result.setKhuyenMai(data.getFloat(8));
               result.setSoLuongTonKho(data.getInt(9));
               result.setSoLuongGianHang(data.getInt(10));
               result.setDonVi(data.getString(11));
               result.setHanSuDung(data.getDate(12));
           }
           
           stmt.close();
           data.close();
           CloseConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public Hang getHangByMaSP(String MaSP){
        Hang result = new Hang();
        try {
           OpenConnect();
           Statement stmt = con.createStatement();
           String query = "SELECT * FROM hang WHERE MaSP='"+MaSP+"'";
           //System.out.println(query);
           ResultSet data = stmt.executeQuery(query);
           while(data.next()){
               result.setMaSP(data.getString(1));
               result.setTenSP(data.getString(2));
               result.setPhanLoai(data.getString(3));
               result.setViTriKho(data.getString(4));
               result.setViTriGianHang(data.getString(5));
               result.setGiaNhap(data.getInt(6));
               result.setGiaBan(data.getInt(7));
               result.setKhuyenMai(data.getFloat(8));
               result.setSoLuongTonKho(data.getInt(9));
               result.setSoLuongGianHang(data.getInt(10));
               result.setDonVi(data.getString(11));
               result.setHanSuDung(data.getDate(12));
           }
           
           stmt.close();
           data.close();
           CloseConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public String addHangTuKhoLenGianHang(Hang hang){
        try {
           OpenConnect();
           Statement stmt = con.createStatement();
           String query = "UPDATE hang SET ViTriGianHang = '"+hang.getViTriGianHang()+"',GiaBan="+hang.getGiaBan()+",KhuyenMai="+hang.getKhuyenMai()+","
                                        + "SLGianHang="+hang.getSoLuongGianHang()+",SLTonKho="+hang.getSoLuongTonKho()+" WHERE MaSP = '"+hang.getMaSP()+"'";
           //System.out.println(query);
           stmt.execute(query);
           stmt.close();
           CloseConnect();
           return "Thêm hoàn tất !";
        } catch (Exception e) {
            return e.toString();
        } 
    }
    public String editHangTrenGianHang(Hang hang){
        try {
           OpenConnect();
           Statement stmt = con.createStatement();
           String query = "UPDATE hang SET ViTriGianHang = '"+hang.getViTriGianHang()+"',GiaBan="+hang.getGiaBan()+",KhuyenMai="+hang.getKhuyenMai()+","
                                        + "SLGianHang="+hang.getSoLuongGianHang()+",SLTonKho="+hang.getSoLuongTonKho()+" WHERE MaSP = '"+hang.getMaSP()+"'";
           //System.out.println(query);
           stmt.execute(query);
           stmt.close();
           CloseConnect();
           return "Sửa hoàn tất !";
        } catch (Exception e) {
            return e.toString();
        } 
    }
    public String deleteHangbyMaSP(String MaSP){
        try {
           OpenConnect();
           Statement stmt = con.createStatement();
           String query = "UPDATE hang SET SLGianHang=0 WHERE MaSP='"+MaSP+"'";
           //System.out.println(query);
           stmt.execute(query);
           stmt.close();
           CloseConnect();
           return "Xóa hoàn tất !";
        } catch (Exception e) {
            return e.toString();
        } 
    }
    

    
    
}
