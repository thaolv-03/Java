package Giuaky_IT7.Object;

import java.util.ArrayList;
import java.util.Scanner;

public class BNNoitru extends Benhnhan {
    private String ngaynhapvien;
    private String ngayxuatvien;

    public BNNoitru() {  
    }

    public BNNoitru(String hoten, int soBHXH, int namsinh, String diachi, String ngaydenkham, String ngaynhapvien,
            String ngayxuatvien) {
        super(hoten, soBHXH, namsinh, diachi, ngaydenkham);
        this.ngaynhapvien = ngaynhapvien;
        this.ngayxuatvien = ngayxuatvien;
    }

    public String toString() {
        return "BNNoitru [hoten=" + hoten +
                            ", soBHXH=" + soBHXH +  
                            ", namsinh=" + namsinh + 
                            ", diachi=" + diachi + 
                            ", ngaydenkham=" + ngaydenkham + 
                            ", ngaynhapvien=" + ngaynhapvien + 
                            ", ngayxuatvien=" + ngayxuatvien + 
                            "]";
    }

    public String getNgaynhapvien() {
        return ngaynhapvien;
    }

    public void setNgaynhapvien(String ngaynhapvien) {
        this.ngaynhapvien = ngaynhapvien;
    }

    public String getNgayxuatvien() {
        return ngayxuatvien;
    }

    public void setNgayxuatvien(String ngayxuatvien) {
        this.ngayxuatvien = ngayxuatvien;
    }
    
    public void input(ArrayList<Benhnhan> QLBN){
        Scanner sc = new Scanner(System.in);
        super.input(QLBN);
        System.out.println("Nhap ngaynhapvien: ");
        this.ngaynhapvien = sc.nextLine();
        System.out.println("Nhap ngayxuatvien: ");
        this.ngayxuatvien = sc.nextLine();
    }
    
}
