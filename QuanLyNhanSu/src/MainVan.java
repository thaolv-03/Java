import java.util.Scanner;

import Object.Van;
import Object.VanList;

public class MainVan {

    public static void displayMenu(){
        System.out.println("+------------------ Menu -------------------------+");
        System.out.println("| 1) Them 5 object Van                            |");
        System.out.println("| 2) In ra danh sach Van                          |");
        System.out.println("| 3) In danh sach Van priceForSale lon hon 20     |");
        System.out.println("| 4) Tinh tong so Van co trong danh sach          |");
        System.out.println("| 5) Thoat                                        |");
        System.out.println("+-------------------------------------------------+");
    }
    public static void main(String[] args) throws Exception {
        VanList vanList = new VanList();
        Scanner sc = new Scanner(System.in);

        boolean Menu = true;
        int choice = 0;
        String temp;
        while (Menu){ // chừng nào Menu còn = true thì tiếp tục thực hiện khối lệnh dưới
            displayMenu();
            System.out.println("Nhap lua chon cua ban: ");
            temp = sc.nextLine(); // dùng biến temp kiểu String để nhận lệnh nhập (lưu lại) vì nếu dùng kiểu int thì ví dụ khi nhập a b c thì sẽ lỗi và sẽ tự động out ngay
            try { // try(thử) chuyển temp(String) thành số rồi gán cho choice(int)
                choice = Integer.parseInt(temp);
            } catch (Exception e){ // nếu catch(bắt được) lỗi exception thì nó sẽ in ra lựa chọn khong đúng và thực hiện tiếp..
                System.out.println("Lua chon khong dung");
                continue; // ->>
            } // còn nếu chuyển temp(String) thành số được thì sẽ chạy cái switch case...
            switch (choice){
                case 1:
                    // int i =1;
                    // do {
                    //     Van van = new Van();
                    //     System.out.println("Nhap Van "+i+": ");  
                    //     van.input(vanList);
                    //     vanList.add(van);
                    //     i++;
                    // } while (i<=5);
                    vanList.add();
                    break;
                case 2:
                    vanList.show();
                    break;
                case 3:
                    vanList.priceForSaleGreater20();
                    break;
                case 4:
                    System.out.println("Number of Van: " + vanList.NumberOfVan());
                    break;
                case 5:
                    Menu = false;
                    break;
                default:
                    System.out.println("Lua chon khong dung");
                    break;
            }
        }
        System.out.println("Ket thuc"); // nếu Menu = false thì hiện 
    }
}
