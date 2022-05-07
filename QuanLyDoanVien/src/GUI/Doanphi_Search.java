package GUI;

import DBManage.ConnectDB_QLDV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Doanphi_Search extends JFrame {
    JFrame f = new JFrame("Quản lý đoàn viên - TÌM KIẾM ĐOÀN VIÊN ĐÓNG ĐOÀN PHÍ");

    JLabel lbT1 = new JLabel("Tháng 1");
    JLabel lbT2 = new JLabel("Tháng 2");
    JLabel lbT3 = new JLabel("Tháng 3");
    JLabel lbT4 = new JLabel("Tháng 4");
    JLabel lbT5 = new JLabel("Tháng 5");
    JLabel lbT6 = new JLabel("Tháng 6");
    JLabel lbT7 = new JLabel("Tháng 7");
    JLabel lbT8 = new JLabel("Tháng 8");
    JLabel lbT9 = new JLabel("Tháng 9");
    JLabel lbT10 = new JLabel("Tháng 10");
    JLabel lbT11 = new JLabel("Tháng 11");
    JLabel lbT12 = new JLabel("Tháng 12");
    JLabel lbNull = new JLabel("");
    JLabel lbNull1 = new JLabel("");
    JLabel lbNull2 = new JLabel("");

    String[] dp = {"","Rồi","Chưa"};
    JComboBox cboT1 = new JComboBox(dp);
    JComboBox cboT2 = new JComboBox(dp);
    JComboBox cboT3 = new JComboBox(dp);
    JComboBox cboT4 = new JComboBox(dp);
    JComboBox cboT5 = new JComboBox(dp);
    JComboBox cboT6 = new JComboBox(dp);
    JComboBox cboT7 = new JComboBox(dp);
    JComboBox cboT8 = new JComboBox(dp);
    JComboBox cboT9 = new JComboBox(dp);
    JComboBox cboT10 = new JComboBox(dp);
    JComboBox cboT11 = new JComboBox(dp);
    JComboBox cboT12 = new JComboBox(dp);

    JButton btnSearch = new JButton("Tìm kiếm");
    JButton btnDoanvien = new JButton("ĐOÀN VIÊN");
    JButton btnDoanphi = new JButton("ĐOÀN PHÍ");
    JButton btnQHGD = new JButton("QUAN HỆ GIA ĐÌNH");
    JButton btnReset = new JButton("Reset");

    JTable tbDoanphi;

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;

    private void TaoFrame() {
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocation(500,230);
        f.setSize(1000,500);
        f.add(TaoPanel());
        f.setVisible(true);
    }
    private JPanel TaoPanel() {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.add(input(), BorderLayout.NORTH);
        panel.add(button(), BorderLayout.SOUTH);
        panel.add(tableData(), BorderLayout.CENTER);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.add(table(), BorderLayout.CENTER);
                panel.revalidate();
            }
        });
        return panel;
    }
    private JPanel input() {
        JPanel panel = new JPanel(new GridLayout(4,7,5,5));
        panel.add(lbT1);
        panel.add(lbT2);
        panel.add(lbT3);
        panel.add(lbT4);
        panel.add(lbT5);
        panel.add(lbT6);
        panel.add(lbNull);
        panel.add(cboT1);
        panel.add(cboT2);
        panel.add(cboT3);
        panel.add(cboT4);
        panel.add(cboT5);
        panel.add(cboT6);
        panel.add(lbNull1);
        panel.add(lbT7);
        panel.add(lbT8);
        panel.add(lbT9);
        panel.add(lbT10);
        panel.add(lbT11);
        panel.add(lbT12);
        panel.add(lbNull2);
        panel.add(cboT7);
        panel.add(cboT8);
        panel.add(cboT9);
        panel.add(cboT10);
        panel.add(cboT11);
        panel.add(cboT12);

        panel.add(btnSearch);

        return panel;
    }
    private JPanel button() {
        JPanel panel = new JPanel(new GridLayout(1,4,1,1));
        panel.add(btnReset);
        panel.add(btnDoanvien);
        panel.add(btnDoanphi);
        panel.add(btnQHGD);

        return panel;
    }
    private JPanel table() {
        JPanel panel = new JPanel(new GridLayout(1,1,5,5));
        BangTimKiem();
        JScrollPane sp = new JScrollPane(tbDoanphi);
        panel.add(sp);
        return panel;
    }
    private JPanel tableData(){
        JPanel panel = new JPanel(new GridLayout(1,1,5,5));
        BangDL();
        JScrollPane sp = new JScrollPane(tbDoanphi);
        panel.add(sp);
        return  panel;
    }
    public void BangDL() {
        ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
        String col[] = {"Mã ĐV", "Mã SV", "Họ tên","Ngày sinh", "Giới tính","Địa chỉ", "Tên chi đoàn", "Ngành học", "Chức vụ"};
        DefaultTableModel tm1 = new DefaultTableModel(col, 0);

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = con_DV.connect_SQL();
            // tạo đối tượng thực thi câu lệnh SELECT
            st = conn.createStatement();
            // Thực thi
            rs = st.executeQuery("SELECT * FROM DOANVIEN");
            Vector data = null;
            tm1.setRowCount(0);
            // Nếu đoàn viên khong tồn tại
            if (rs.isBeforeFirst() ==  false){
                JOptionPane.showMessageDialog(this, "Đoàn viên không tồn tại");
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()){
                data = new Vector();
                data.add(rs.getString("MaDV"));
                data.add(rs.getString("MaSV"));
                data.add(rs.getString("Hoten"));
                data.add(rs.getString("Ngaysinh"));
                data.add(rs.getString("Gioitinh"));
                data.add(rs.getString("Diachi"));
                data.add(rs.getString("Tenchidoan"));
                data.add(rs.getString("Nganhhoc"));
                data.add(rs.getString("Chucvu"));
                // thêm dòng vào table model
                tm1.addRow(data);
            }
            tbDoanphi = new JTable();
            tbDoanphi.setModel(tm1); // thêm dữ liệu vào table
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void BangTimKiem(){
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        String column[] = {"Mã ĐV", "Mã SV", "Họ tên","Ngày sinh", "Giới tính","Địa chỉ", "Tên chi đoàn", "Ngành học", "Chức vụ"};
        DefaultTableModel tm = new DefaultTableModel(column, 0);

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = cn.connect_SQL();
            // tạo đối tượng thực thi câu lệnh SELECT
            st = conn.createStatement();
            // Thực thi
            rs = st.executeQuery(sql_statement(cboT1.getSelectedItem().toString(),cboT2.getSelectedItem().toString(),cboT3.getSelectedItem().toString(),cboT4.getSelectedItem().toString(),cboT5.getSelectedItem().toString(),cboT6.getSelectedItem().toString(),cboT7.getSelectedItem().toString(),cboT8.getSelectedItem().toString(),cboT9.getSelectedItem().toString(),cboT10.getSelectedItem().toString(),cboT11.getSelectedItem().toString(),cboT12.getSelectedItem().toString()));
            Vector data = null;
            tm.setRowCount(0);
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("MaDV"));
                data.add(rs.getString("MaSV"));
                data.add(rs.getString("Hoten"));
                data.add(rs.getString("Ngaysinh"));
                data.add(rs.getString("Gioitinh"));
                data.add(rs.getString("Diachi"));
                data.add(rs.getString("Tenchidoan"));
                data.add(rs.getString("Nganhhoc"));
                data.add(rs.getString("Chucvu"));

                tm.addRow(data);
            }
            tbDoanphi = new JTable();
            tbDoanphi.setModel(tm);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void reset() {
        cboT1.setSelectedItem("");
        cboT2.setSelectedItem("");
        cboT3.setSelectedItem("");
        cboT4.setSelectedItem("");
        cboT5.setSelectedItem("");
        cboT6.setSelectedItem("");
        cboT7.setSelectedItem("");
        cboT8.setSelectedItem("");
        cboT9.setSelectedItem("");
        cboT10.setSelectedItem("");
        cboT11.setSelectedItem("");
        cboT12.setSelectedItem("");
    }
    public String sql_statement(String Thang1, String Thang2, String Thang3, String Thang4, String Thang5, String Thang6, String Thang7, String Thang8, String Thang9, String Thang10, String Thang11, String Thang12) {
        String sql = "SELECT DOANVIEN.MADV, DOANVIEN.MASV, DOANVIEN.Hoten, DOANVIEN.Ngaysinh, DOANVIEN.Gioitinh, DOANVIEN.Diachi, DOANVIEN.Tenchidoan, DOANVIEN.Nganhhoc, DOANVIEN.Chucvu FROM DOANVIEN INNER JOIN DOANPHI ON DOANVIEN.MADV = DOANPHI.MADV WHERE ";
        // Thang1.equals("Rồi") || Thang1.equals("Chưa")
        if (Thang1.length()>0) {
            sql += (String)("Thang1 = N'"+Thang1+"'");
        }
        if (Thang2.length()>0){
            if (Thang1.length()>0) sql += " AND";
            sql += (String)(" Thang2 = N'"+Thang2+"'");
        }
        if (Thang3.length()>0){
            if (Thang1.length()>0 || Thang2.length()>0) sql += " AND";
            sql += (String)(" Thang3 = N'"+Thang3+"'");
        }
        if (Thang4.length()>0){
            if (Thang1.length()>0 || Thang2.length()>0 || Thang3.length()>0) sql += " AND";
            sql += (String)(" Thang4 = N'"+Thang4+"'");
        }
        if (Thang5.length()>0){
            if (Thang1.length()>0 || Thang2.length()>0 || Thang3.length()>0 || Thang4.length()>0) sql += " AND";
            sql += (String)(" Thang5 = N'"+Thang5+"'");
        }
        if (Thang6.length()>0){
            if (Thang1.length()>0 || Thang2.length()>0 || Thang3.length()>0 || Thang4.length()>0 || Thang5.length()>0 ) sql += " AND";
            sql += (String)(" Thang6 = N'"+Thang6+"'");
        }
        if (Thang7.length()>0){
            if (Thang1.length()>0 || Thang2.length()>0 || Thang3.length()>0 || Thang4.length()>0 || Thang5.length()>0 || Thang6.length()>0) sql += " AND";
            sql += (String)(" Thang7 = N'"+Thang7+"'");
        }
        if (Thang8.length()>0){
            if (Thang1.length()>0 || Thang2.length()>0 || Thang3.length()>0 || Thang4.length()>0 || Thang5.length()>0 || Thang6.length()>0 || Thang7.length()>0) sql += " AND";
            sql += (String)(" Thang8 = N'"+Thang8+"'");
        }
        if (Thang9.length()>0){
            if (Thang1.length()>0 || Thang2.length()>0 || Thang3.length()>0 || Thang4.length()>0 || Thang5.length()>0 || Thang6.length()>0 || Thang7.length()>0 || Thang8.length()>0) sql += " AND";
            sql += (String)(" Thang9= N'"+Thang9+"'");
        }
        if (Thang10.length()>0){
            if (Thang1.length()>0 || Thang2.length()>0 || Thang3.length()>0 || Thang4.length()>0 || Thang5.length()>0 || Thang6.length()>0 || Thang7.length()>0 || Thang8.length()>0 || Thang9.length()>0) sql += " AND";
            sql += (String)(" Thang10= N'"+Thang10+"'");
        }
        if (Thang11.length()>0){
            if (Thang1.length()>0 || Thang2.length()>0 || Thang3.length()>0 || Thang4.length()>0 || Thang5.length()>0 || Thang6.length()>0 || Thang7.length()>0 || Thang8.length()>0 || Thang9.length()>0 || Thang10.length()>0) sql += " AND";
            sql += (String)(" Thang11= N'"+Thang11+"'");
        }
        if (Thang12.length()>0){
            if (Thang1.length()>0 || Thang2.length()>0 || Thang3.length()>0 || Thang4.length()>0 || Thang5.length()>0 || Thang6.length()>0 || Thang7.length()>0 || Thang8.length()>0 || Thang9.length()>0 || Thang10.length()>0 || Thang11.length()>0) sql += " AND";
            sql += (String)(" Thang12= N'"+Thang12+"'");
        }
        return sql;
    }
    public Doanphi_Search() {
        TaoFrame();
        btnDoanvien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Doanvien();
                f.setVisible(false);
            }
        });
        btnDoanphi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Doanphi();
                f.setVisible(false);
            }
        });
        btnQHGD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QHGD();
                f.setVisible(false);
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
    }
    public static void main(String[] args) {
        new Doanphi_Search();
    }
}
