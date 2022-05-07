package QLNS;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNhanSu {
    ArrayList<Nhansu> quanlyNS = new ArrayList<Nhansu>();
    Nhansu ns = new Nhansu();
    Giamdoc gd = new Giamdoc();
    Quandoc qd = new Quandoc();
    Nhanvien nv = new Nhanvien();
    public QuanLyNhanSu() {
    }

    public QuanLyNhanSu(ArrayList<Nhansu> quanlyNS) {
        this.quanlyNS = quanlyNS;
    }
    public void add1(Giamdoc giamdoc){
        gd = new Giamdoc();
        System.out.println("Nhap giam doc");
        gd.input(this.quanlyNS);
        this.quanlyNS.add(gd);
    }
    public void add2(Quandoc quandoc){
        for (int i=1; i<=2;i++){
            qd = new Quandoc();
            System.out.println("Nhap quan doc thu "+i+": ");
            qd.input(this.quanlyNS);
            this.quanlyNS.add(qd);
        } 
        /*for (int i=0;i < 5;i++){
            v = new Van();
            System.out.println("Nhap van thu "+i+" : " );
            v.input(this.VList);
            this.VList.add(v);
        }*/
    }
    public void add3(Nhanvien nhanvien){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong nhan vien: ");
        int n = sc.nextInt();
        for (int i=1;i<=n;i++){
            nv = new Nhanvien();
            System.out.println("Nhap nhan vien thu "+i+":");
            nv.input(this.quanlyNS);
            this.quanlyNS.add(nv);
        }
    }
    public void show(){
        if (this.quanlyNS.size() == 0)
            System.out.println("Chua co nhan su");
        for (int i=0;i<this.quanlyNS.size();i++){
            System.out.println(this.quanlyNS.get(i).toString());
        }
    }
    public void tongLuongMax(){
        double max=0;
        for (int i=0;i<this.quanlyNS.size();i++){
            if (this.quanlyNS.get(i).tongLuong() > max){
                max = this.quanlyNS.get(i).tongLuong();
            }
        }
        for (int i=0;i<this.quanlyNS.size();i++){
            if (this.quanlyNS.get(i).tongLuong() == max){
                System.out.println(this.quanlyNS.get(i).toString());
            }
        }
    }
    public void checkT12(){
       
        for (int i=0;i<this.quanlyNS.size();i++){
            String[] str = this.quanlyNS.get(i).getNgsinh().split("/");
            String st1 = str[1];
            if (st1.equals("12")){
                System.out.println(this.quanlyNS.get(i).toString());
            }
        }   
    }
    public void showNVKetoan(){
       
        for (int i=0;i<this.quanlyNS.size();i++){
            if (( (Nhanvien) this.quanlyNS.get(i)).getTenDonvi().equals("Ketoan")){
                System.out.println(this.quanlyNS.get(i).toString());
            }
        }   
    }

    public void checkHo(){
       
        for (int i=0;i<this.quanlyNS.size();i++){
            String[] str = this.quanlyNS.get(i).getHoten().split(" ");
            String st0 = str[0];
            if (st0.equals("Huynh")){
                System.out.println(this.quanlyNS.get(i).toString());
            }
        }   
    }
}
    
    

