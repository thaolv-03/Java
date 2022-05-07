package QLNS;

import java.util.ArrayList;
import java.util.Scanner;

public class Nhanvien extends Nhansu  {
    String tenDonvi;

    public Nhanvien() {
        
    }

    public Nhanvien(String hoten, String ngsinh, double hesoluong, String tenDonvi) {
        super(hoten, ngsinh, hesoluong);
        this.tenDonvi = tenDonvi;
    }

    public String toString() {
        return "Nhanvien ["+
                " Hoten= " + this.hoten +
                " Ngaysinh= " + this.ngsinh +
                " Hesoluong= " + this.hesoluong +
                " TenDonvi= " + tenDonvi + 
                " ]";
    }

    public String getTenDonvi() {
        return tenDonvi;
    }

    public void setTenDonvi(String tenDonvi) {
        this.tenDonvi = tenDonvi;
    }

    public double tongLuong(){
        return (this.hesoluong*1150000);
    }
    public void input(ArrayList<Nhansu> NS){
        Scanner sc = new Scanner(System.in);
        super.input(NS);
        System.out.println("Nhap Tendonvi: ");
        this.tenDonvi = sc.nextLine();
    }
}
