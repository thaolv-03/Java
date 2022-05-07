import java.util.Scanner;

import Object.Product;
import Object.ProductIn;
import Object.ProductList;
import Object.ProductOut;

public class Main {
    public static void displayMenu(){
        System.out.println("+---------------------------- Menu -----------------------------------+");
        System.out.println("| 1) Them Product vao danh sach gom ProductIn và ProductOut           |");
        System.out.println("| 2) In ra danh sach Product                                          |");
        System.out.println("| 3) In danh sach ProductIn va ProductOut có priceForSale lon hon 20  |");
        System.out.println("| 4) Tinh tong so Product co trong danh sach                          |");
        System.out.println("| 5) Thoat                                                            |");
        System.out.println("+---------------------------------------------------------------------+");
    }
    public static void main(String[] args) throws Exception {
        ProductList productList = new ProductList();
        Scanner sc = new Scanner(System.in);
        boolean Menu = true;
        int choice = 0, choice2 = 0;
        String temp;
        while (Menu){
            displayMenu();
            System.out.println("Nhap lua chon cua ban: ");
            temp = sc.nextLine();
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e){
                System.out.println("Lua chon khong dung");
                continue;
            }
            switch(choice){
                case 1:
                System.out.println("+-------- Menu --------+");
                System.out.println("| 1) Them ProductIn    |");
                System.out.println("| 2) Them ProductOut   |");
                System.out.println("+----------------------+");
                System.out.print("Nhap lua chon cua ban: ");    
                temp = sc.nextLine();
                try {
                    choice2 = Integer.parseInt(temp);
                } catch (Exception e) {
                    System.out.println("Lua chon khong dung");
                    continue;
                }
                Product p = new Product();
                switch (choice2){
                    case 1:
                        p = new ProductIn();
                        p.input(productList);
                        productList.add(p);
                        break;
                    case 2:
                        p = new ProductOut();
                        p.input(productList);
                        productList.add(p);
                        break;
                    // default:
                    //     System.out.println("Lua chon khong dung");
                    //     break;
                }
                break;
                case 2:
                    productList.show();
                    break;
                case 3:
                    productList.priceForSaleGreater20();
                    break;
                case 4:
                    System.out.println("Number of Product: " + productList.NumberOfProduct());
                    break;
                case 5:
                    Menu = false;
                    break;
                default:
                    System.out.println("Lua chon khong dung");
                    break;
            }
        }
        System.out.println("Ket thuc");
    }
}
