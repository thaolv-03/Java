package Giuaky_IT7.Object;

import java.util.ArrayList;
import java.util.Scanner;

public class Benhnhan {
    protected String hoten;
    protected int soBHXH;
    protected int namsinh;
    protected String diachi;
    protected String ngaydenkham;
    
    public String toString() {
        return "Benhnhan [hoten=" + hoten +
                        ", soBHXH=" + soBHXH +  
                        ", namsinh=" + namsinh + 
                        ", diachi=" + diachi + 
                        ", ngaydenkham=" + ngaydenkham + 
                        "]";
    }

    public Benhnhan() {
    }

    public Benhnhan(String hoten, int soBHXH, int namsinh, String diachi, String ngaydenkham) {
        this.hoten = hoten;
        this.soBHXH = soBHXH;
        this.namsinh = namsinh;
        this.diachi = diachi;
        this.ngaydenkham = ngaydenkham;
    }

    public void input(ArrayList<Benhnhan> benhnhan){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Hoten: ");
        this.hoten = sc.nextLine();
        String temp;
        boolean b= true;
        while (b){
            System.out.println("Nhap so BHXH: ");
            temp = sc.nextLine();
            try {
                this.soBHXH = Integer.parseInt(temp);
            } catch (Exception e) {
                System.out.println("So BHXH khong dung");
                continue;
            }
        
            System.out.println("Nhap namsinh: ");
            this.namsinh = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhap diachi: ");
            this.diachi = sc.nextLine();
            System.out.println("Nhap ngay den kham: ");
            this.ngaydenkham = sc.nextLine();
            b= false;
        }
    }
    // public boolean checksoBHXH(int soBHXH, Quanlybenhnhan QLBN){
    //     for (int i=0;i< QLBN.benhnhan.size();i++)
    //         if (QLBN.benhnhan.get(i).getSoBHXH() == soBHXH)
    //             return false;
    //         return true;
    // }
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSoBHXH() {
        return soBHXH;
    }

    public void setSoBHXH(int soBHXH) {
        this.soBHXH = soBHXH;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaydenkham() {
        return ngaydenkham;
    }

    public void setNgaydenkham(String ngaydenkham) {
        this.ngaydenkham = ngaydenkham;
    }
    
}
