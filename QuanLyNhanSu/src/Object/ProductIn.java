package Object;

import java.util.Scanner;

public class ProductIn extends Product {
    double extraIn;

    public ProductIn(){
        // super();
        // this.extraIn = 0;
    }

    public ProductIn(int id, String name, double price, double extraIn) {
        super(id, name, price);
        this.extraIn = extraIn;
    }
    
     
    public String toString() {
        return "ProductIn [ID= "+ this.id + 
                ", Name= "+ this.name +
                ", Price= "+ this.price +
                ", PriceForSale=" + this.priceForSale() +
                ", extraIn=" + this.extraIn +
                "]";         
    }
    public double priceForSale(){
        return this.price+ this.extraIn;
    }
    public double getExtraIn() {
        return extraIn;
    }

    public void setExtraIn(double extraIn) {
        this.extraIn = extraIn;
    }
    public void input(ProductList P) {
        Scanner sc = new Scanner(System.in);
        super.input(P);
        System.out.print("Nhap ExtraIn: ");
        this.extraIn = sc.nextDouble();
    }
}
