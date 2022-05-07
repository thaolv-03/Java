package Giuaky_IT7.Object;

import java.util.ArrayList;
import java.util.Scanner;

public class Quanlybenhnhan {
    ArrayList<Benhnhan> benhnhan = new ArrayList<Benhnhan>();
    Benhnhan B = new Benhnhan();
    public Quanlybenhnhan() {
    }

    public Quanlybenhnhan(ArrayList<Benhnhan> benhnhan) {
        this.benhnhan = benhnhan;
    }
    public void inputDSBNNoitru(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so benh nhan noi tru: ");
        n = sc.nextInt();
        for (int i=0;i<n;i++){
            B = new BNNoitru();
            System.out.println("Nhap benh nhan noi tru thu "+i+": ");
            B.input(this.benhnhan);
            this.benhnhan.add(B);
        }
    }
    public void inputDSBNNgoaitru(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so benh nhan ngoai tru: ");
        n = sc.nextInt();
        for (int i=0;i<n;i++){
            B = new BNNgoaitru();
            System.out.println("Nhap benh nhan ngoai tru thu "+i+": ");
            B.input(this.benhnhan);
            this.benhnhan.add(B);
        }
    }
    public void showBN(){
        if (this.benhnhan.size() == 0){
            System.out.println("Chua co benh nhan nao");
        }
        for (int i = 0;i < this.benhnhan.size();i++){
            System.out.println(this.benhnhan.get(i).toString());
        }
    }
    public void showBNKVDN(){
        boolean flag = true;
        for (int i=0;i<this.benhnhan.size();i++){
            if (this.benhnhan.get(i).getDiachi().equals("Da Nang")){
                System.out.println(this.benhnhan.get(i).toString());
                flag = false;
            } 
        }
        if (flag)
                System.out.println("--Khong co benh nhan khu vuc Da Nang");
    }
    // Hiển thị danh sách bệnh nhân điều trị nội trú 
    public void showBNNoitru(){
        boolean flag = true;
        for (Benhnhan benhnhan : benhnhan) {
            if (benhnhan instanceof BNNoitru) {
                System.out.println(((BNNoitru) benhnhan).toString());
                flag = false;
            }     
        }
        if (flag)
            System.out.println("--Khong co benh nhan noi tru nao");
    }
    
}
