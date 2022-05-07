package Object;

import java.util.ArrayList;

public class ProductList {
    ArrayList<Product> PList = new ArrayList<Product>();

    public ProductList(){
        this.PList = new ArrayList<Product>();
    }
    public ProductList(ArrayList<Product> PList){
        this.PList = PList;
    }
    public void add(Product p){
        this.PList.add(p);
    }
    public void show(){
        if (this.PList.size() == 0)
            System.out.println("Chua co Product nao");
        for (int i=0;i< this.PList.size();i++){
            System.out.println(this.PList.get(i).toString());
        }
    }
    public void priceForSaleGreater20(){
        boolean flag = true;
            for (int i=0;i< this.PList.size();i++)
                if (this.PList.get(i).priceForSale() > 20){
                    System.out.println(this.PList.get(i).toString());
                    flag = false;
                }
            if (flag)
                System.out.println("Khong co san pham nao co PriceForSale lon hon 20");  
    }
    public int NumberOfProduct(){
        return this.PList.size();
    }
    public ArrayList<Product> getPList() {
        return this.PList;
    }
    public void setPList(ArrayList<Product> PList) {
        this.PList = PList;
    }
        
}
