/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class TableHang extends AbstractTableModel{

    private String columnName[] = {"Sản Phẩm","Đơn Vị","Phân Loại","Giá Gốc","Khuyến Mại(%)","Giá Khuyến Mại","Vị Trí","Số Lượng"};
    private ArrayList<EntityClass.Hang> tableListData = new ArrayList<>();
    private int Page;
    private int productPerPage = 20;
    private int numberOfProductInLastPage;
    private int lastPage;
    public TableHang setPage(int Page) {
        this.Page = Page;
        if(this.Page > lastPage)
            this.Page = lastPage;
        if(this.Page < 0)
            this.Page = 0;
        return this;
    }
    
    public int getPage() {
        return Page +1;
    }
    public int getSumOfProduct(){
        return tableListData.size();
    }
    public String getRangeOfCurrentPage(){
        int lastProd = Page==lastPage?numberOfProductInLastPage:productPerPage;
        return String.valueOf(Page*productPerPage+1) + "-" + String.valueOf(Page*productPerPage + lastProd);
    }
    
    public TableHang(ArrayList<EntityClass.Hang> listHang) {
       tableListData = listHang; 
       numberOfProductInLastPage = listHang.size()%productPerPage;
       lastPage = listHang.size()/productPerPage;
       
       //Change Table Style
       
    }
    @Override
    public int getRowCount() {
        if(tableListData == null)
            return 0;
        if(Page == lastPage){
            return numberOfProductInLastPage;
        }
        return productPerPage;
    }
    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }
    @Override
    public int getColumnCount() {
        return columnName.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        switch(columnIndex){
            case 0: value = tableListData.get(rowIndex + Page*productPerPage).getTenSP();break;
            case 1: value = tableListData.get(rowIndex + Page*productPerPage).getDonVi();break;
            case 2: value = tableListData.get(rowIndex + Page*productPerPage).getPhanLoai();break;
            case 3: value = tableListData.get(rowIndex + Page*productPerPage).getGiaBan();break;
            case 4: value = (int)(tableListData.get(rowIndex + Page*productPerPage).getKhuyenMai()*100);break;
            case 5: value = (tableListData.get(rowIndex + Page*productPerPage).getGiaBan()
                           - (int)(tableListData.get(rowIndex + Page*productPerPage).getGiaBan()
                           * tableListData.get(rowIndex + Page*productPerPage).getKhuyenMai()));break;
            case 6: value = tableListData.get(rowIndex + Page*productPerPage).getViTriGianHang();break;
            case 7: value = tableListData.get(rowIndex + Page*productPerPage).getSoLuongGianHang();break;
        }
        return value;
    }
    
}
