package Object;
import java.util.Scanner;

import Interface.IProduct;

public class Product implements IProduct{
    int id;
    String name;
    double price;

    public Product() {
        // this.id = 0;
        // this.name = "";
        // this.price = 0;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
    public void input(ProductList P) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.print("Nhap ID: ");
            this.id = sc.nextInt();
            check = checkID(this.id, P);
            if (check == false)
                System.out.println("ID da ton tai, vui long nhap ID khac");
        } while (check == false);
        sc.nextLine();
        System.out.print("Nhap Name: ");
        this.name = sc.nextLine();
        System.out.print("Nhap Price: ");
        this.price = sc.nextDouble();
    }

    public boolean checkID(int id, ProductList P) {
        for (int i = 0; i < P.PList.size(); i++)
            if (P.PList.get(i).getId() == id)
                return false;
        return true;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double priceForSale() {
        
        return 0;
    }
}
