package QLNS;

import java.util.ArrayList;
import java.util.Scanner;

import Interface.INhansu;

public class Nhansu implements INhansu {
    String hoten;
    String ngsinh;
    double hesoluong;
    
    public Nhansu() {
        
    }

    public Nhansu(String hoten, String ngsinh, double hesoluong) {
        this.hoten = hoten;
        this.ngsinh = ngsinh;
        this.hesoluong = hesoluong;
    }
    public String toString() {
        return "Nhansu [hesoluong=" + hesoluong + ", hoten=" + hoten + ", ngsinh=" + ngsinh + "]";
    }
    public void input(ArrayList<Nhansu> quanlyNS){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Hoten: ");
        this.hoten = sc.nextLine();
        System.out.println("Nhap Ngaysinh: ");
        this.ngsinh = sc.nextLine();
        System.out.println("Nhap Hesoluong");
        this.hesoluong = sc.nextDouble();
    }
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgsinh() {
        return ngsinh;
    }

    public void setNgsinh(String ngsinh) {
        this.ngsinh = ngsinh;
    }

    public double getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(double hesoluong) {
        this.hesoluong = hesoluong;
    }
    @Override
    public double tongLuong(){
        return 0;
    }

    
    
    
}

