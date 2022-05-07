package Giuaky_IT7;

import Giuaky_IT7.Object.Quanlybenhnhan;

public class Main {
    public static void main(String[] args) throws Exception {
        Quanlybenhnhan quanlybenhnhan = new Quanlybenhnhan();
        quanlybenhnhan.inputDSBNNoitru();
        quanlybenhnhan.inputDSBNNgoaitru();
        System.out.println("Danh sach benh nhan: ");
        quanlybenhnhan.showBN();
        System.out.println("Danh sach benh nhan khu vuc Da Nang: ");
        quanlybenhnhan.showBNKVDN();
        System.out.println("Danh sach benh nhan noi tru: ");
        quanlybenhnhan.showBNNoitru();
    }
}
