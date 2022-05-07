package QLNS;

import java.util.ArrayList;
import java.util.Scanner;

public class Giamdoc extends Nhansu {
    double hesochucvu;

    public Giamdoc() {
        
    }

    public Giamdoc(String hoten, String ngsinh, double hesoluong, double hesochucvu) {
        super(hoten, ngsinh, hesoluong);
        this.hesochucvu = hesochucvu;
    }

    
    public String toString() {
        return "Giamdoc [" +
                "Hoten= " + this.hoten +
                " Ngaysinh= " + this.ngsinh +
                " Hesoluong=" + this.hesoluong +
                " Hesochucvu=" + this.hesochucvu + 
                " ]";
    }
    public double tongLuong() { 
        return (this.hesoluong + this.hesochucvu)*1150000; 
    }
    public double getHesochucvu() {
        return hesochucvu;
    }
    public void setHesochucvu(double hesochucvu) {
        this.hesochucvu = hesochucvu;
    }

    
    public void input(ArrayList<Nhansu> NS){
        Scanner sc = new Scanner(System.in);
        super.input(NS);
        System.out.println("Nhap Hesochucvu: ");
        this.hesochucvu = sc.nextDouble();
    }
}
