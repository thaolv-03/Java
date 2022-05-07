package Object;

import java.util.Scanner;

public class ProductOut extends Product {
    String orgin;
    double extraOut;

    public ProductOut() {
        // super();
        // this.orgin = "";
        // this.extraOut = 0;
    }
    public ProductOut(int id, String name, double price, String orgin, double extraOut) {
        super(id, name, price);
        this.orgin = orgin;
        this.extraOut = extraOut;
    }
    public String toString() {
        return "ProductOut ["+
                "ID=" + this.id +
                ", Name=" + this.name +
                ", Price=" + this.price +
                ", PriceForSale=" + this.priceForSale() +
                ", orgin=" + this.orgin +
                ", extraOut=" + this.extraOut + 
                "]";
    }
    public double priceForSale(){
        return this.price+this.extraOut+this.extraOut/10;
    }
    public void input(ProductList P){
        Scanner sc = new Scanner(System.in);
        super.input(P);
        System.out.println("Enter Orgin: ");
        this.orgin = sc.nextLine();
        System.out.println("Enter ExtraOut: ");
        this.extraOut = sc.nextDouble();
    }
    public String getOrgin() {
        return orgin;
    }
    public void setOrgin(String orgin) {
        this.orgin = orgin;
    }
    public double getExtraOut() {
        return extraOut;
    }
    public void setExtraOut(double extraOut) {
        this.extraOut = extraOut;
    }
    
   
    
    
}
