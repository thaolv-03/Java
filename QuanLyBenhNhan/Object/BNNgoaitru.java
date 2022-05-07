package Giuaky_IT7.Object;

import java.util.ArrayList;

public class BNNgoaitru extends Benhnhan {

    public BNNgoaitru() {
    }

    public BNNgoaitru(String hoten, int soBHXH, int namsinh, String diachi, String ngaydenkham) {
        super(hoten, soBHXH, namsinh, diachi, ngaydenkham);
    }

    
    public String toString() {
        return "BNNgoaitru [hoten=" + hoten +
                            ", soBHXH=" + soBHXH +  
                            ", namsinh=" + namsinh + 
                            ", diachi=" + diachi + 
                            ", ngaydenkham=" + ngaydenkham + 
                            "]";
    }
    public void input(ArrayList<Benhnhan> benhnhan){
        super.input(benhnhan);
    }
    
}
