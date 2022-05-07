package QLNS;

import java.util.ArrayList;
import java.util.Scanner;

public class Quandoc extends Nhansu {
    int sLNVquanly;

    public Quandoc() {
        
    }

    public Quandoc(String hoten, String ngsinh, double hesoluong, int sLNVquanly) {
        super(hoten, ngsinh, hesoluong);
        this.sLNVquanly = sLNVquanly;
    }

    public String toString() {
        return "Quandoc ["+
                " Hoten= " + this.hoten +
                " Ngaysinh= " + this.ngsinh +
                " Hesoluong= " + this.hesoluong +
                " sLNVquanly= " + sLNVquanly + 
                " ]";
    }
    public double tongLuong(){
        return this.hesoluong*1150000;
    }
    public int getsLNVquanly() {
        return sLNVquanly;
    }

    public void setsLNVquanly(int sLNVquanly) {
        this.sLNVquanly = sLNVquanly;
    }

    public void input(ArrayList<Nhansu> NS){
        Scanner sc = new Scanner(System.in);
        super.input(NS);
        System.out.println("Nhap Soluongnhanvienquanly: ");
        this.sLNVquanly = sc.nextInt();
    }
    

}

