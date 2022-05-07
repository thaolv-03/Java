package Object;

import java.util.Scanner;
import java.util.ArrayList; 

public class Van {
    int id;
    String name;
    double price;
    double extraOut;
    int quantity;
    
    public Van() {
    }
    // constructor
    public Van(int id, String name, double price, double extraOut, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.extraOut = extraOut;
        this.quantity = quantity;
    }
    // In ra thông tin của object 
    public String toString() {
        return "Van [Id= " + this.id + 
                ", Name= " + this.name + 
                ", Price= " + this.price + 
                ", Quantity= "+ this.quantity +
                ", ExtraOut= " + this.extraOut +
                ", PriceForSale= "+ this.priceForSale() +
                "]";
    }
    // hàm nhập
    public void input(ArrayList<Van> V){
        Scanner sc = new Scanner(System.in);

        boolean check = true;
        do { // lặp lại việc kiểm tra tra ID nhập vào trong khi check == false
        check = true;
        System.out.print("Nhap ID: ");
        this.id = sc.nextInt();
            check = checkID(this.id, V); 
            if (check == false)
                System.out.println("ID da ton tai, vui long nhap ID khac");
        } while (check == false);
        sc.nextLine();
        System.out.print("Nhap Name: ");
        this.name = sc.nextLine();
        System.out.print("Nhap Price: ");
        this.price = sc.nextDouble();
        System.out.print("Nhap Quantity: ");
        this.quantity = sc.nextInt();
        System.out.print("Nhap ExtraOut: ");
        this.extraOut = sc.nextDouble();
    }
    // Hàm check ID (kiểm tra ID nhập vào có giống nhau hay không)
    public boolean checkID(int Id, ArrayList<Van> V) {
        for (Van s : V)
            if (s.getId() == Id){
                return false;
            }
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

    public double getExtraOut() {
        return extraOut;
    }

    public void setExtraOut(double extraOut) {
        this.extraOut = extraOut;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    // tính priceForSale
    public double priceForSale() {
        double priceforsale=0;
        if (quantity >= 50){
            priceforsale = this.price + this.extraOut + this.extraOut*0.1;
        } else {
            priceforsale = this.price + this.extraOut;
        }
        return priceforsale;
    }
    
}

