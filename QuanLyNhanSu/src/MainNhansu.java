import java.util.Scanner;

import QLNS.Giamdoc;
import QLNS.Nhanvien;
import QLNS.QuanLyNhanSu;
import QLNS.Quandoc;

public class MainNhansu {
    
    public static void display(){
        System.out.println("1. Nhap du lieu");
        System.out.println("2. Hien thi thong tin cac nhan su");
        System.out.println("3. Hien thi nhan su co tong luong cao nhat");
        System.out.println("4. Hien thi nhan su co sinh nhat thang 12");
        System.out.println("5. Hien thi tat ca nhan vien thuoc phong ke toan");
        System.out.println("6. Tim nhan vien co ho 'Huynh'");
    }   
    public static void main(String[] args) throws Exception {
        QuanLyNhanSu quanLyNhanSu = new QuanLyNhanSu();
        Scanner sc = new Scanner(System.in);

        boolean Chon = true;
        int choice;
        String temp;
        while (Chon){
            display();
            System.out.println("Nhap lua chon cua ban");
            temp = sc.nextLine();
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e){
                System.out.println("Lua chon khong dung");
                continue;
            }
            Giamdoc giamdoc = new Giamdoc();
            Quandoc quandoc = new Quandoc();
            Nhanvien nhanvien = new Nhanvien();
            switch(choice){
                case 1:
                    quanLyNhanSu.add1(giamdoc);
                    quanLyNhanSu.add2(quandoc);
                    quanLyNhanSu.add3(nhanvien);
                    break;   
                case 2:
                    quanLyNhanSu.show();
                    break;
                case 3:
                    quanLyNhanSu.tongLuongMax();
                    break;
                case 4:
                    quanLyNhanSu.checkT12();
                    break;
                case 5:
                    quanLyNhanSu.showNVKetoan();
                    break;
                case 6:
                    quanLyNhanSu.checkHo();
                    break;
                default: 
                    Chon = false;
                    break;   
            }    
        }
        System.out.println("Ket thuc");
    }
}
