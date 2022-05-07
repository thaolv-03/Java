package Object;

import java.util.ArrayList;


public class VanList {
    ArrayList<Van> VList = new ArrayList<Van>(); // -> tạo một mảng danh sách: VList 
    Van v= new Van();
    // constructor
    public VanList() {

    }
    public VanList(ArrayList<Van> VList){
        this.VList= VList;
    }

    // Thêm object
    public void add(){
        for (int i=0;i < 5;i++){
            v = new Van();
            System.out.println("Nhap van thu "+i+" : " );
            v.input(this.VList);
            this.VList.add(v);
        }
       
    }
    // Hiển thị object
    public void show(){
        if (this.VList.size() == 0)
            System.out.println("Chua co Van nao");
        for (int i=0;i< this.VList.size();i++){
            System.out.println(this.VList.get(i).toString());
        }
    }
    // Ktra priceForSale của các Object trong danh sách nhập vào  
    public void priceForSaleGreater20(){
        boolean flag = true;
            for (int i=0;i< this.VList.size();i++)
                if (this.VList.get(i).priceForSale() > 20){
                    System.out.println(this.VList.get(i).toString());
                    flag = false;
                }
            if (flag)
                System.out.println("Khong co Van nao co PriceForSale lon hon 20");  
    }
    // hiển thị tổng số Object trong danh sách
    public int NumberOfVan(){
        return this.VList.size();
    }
    
    public ArrayList<Van> getVList() {
        return this.VList;
    }
    public void setVList(ArrayList<Van> vList) {
        this.VList = vList;
    }
    

}
