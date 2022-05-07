package GUI;

import DBManage.ConnectDB_QLDV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

class Doanvien_Search extends JFrame {

    JFrame f = new JFrame("Quản lý đoàn viên - TÌM KIẾM ĐOÀN VIÊN");

    JLabel LbHoten = new JLabel("           Họ tên");
    JLabel LbNgaysinh = new JLabel("            Ngày sinh");
    JLabel LbGioitinh = new JLabel("            Giới tính");
    JLabel LbDiachi = new JLabel("            Địa chỉ");
    JLabel LbTenchidoan = new JLabel("        Tên chi đoàn");
    JLabel LbNganhhoc = new JLabel("          Ngành học");
    JLabel LbChucvu = new JLabel("          Chức vụ");
    JLabel LbNull = new JLabel("");

    JTextField tfHoten = new JTextField(10);
    JTextField tfNgaysinh = new JTextField(10);
    JTextField tfGioitinh = new JTextField(10);
    JTextField tfDiachi = new JTextField(10);
    JTextField tfTenchidoan = new JTextField(10);
    JTextField tfNganhhoc = new JTextField(10);
    JTextField tfChucvu = new JTextField(10);

    JButton btnSearch = new JButton("Tìm kiếm");
    JButton btnDoanvien = new JButton("ĐOÀN VIÊN");
    JButton btnDoanphi = new JButton("ĐOÀN PHÍ");
    JButton btnQHGD = new JButton("QUAN HỆ GIA ĐÌNH");

    JTable tbSearch;

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;

    private void TaoFrame(){
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocation(500,230);
        f.setSize(1000,450);
        f.add(TaoPanel());
        f.setVisible(true);
    }
    private JPanel TaoPanel() {
        JPanel panel = new JPanel(new BorderLayout(11,11));
        panel.add(input(), BorderLayout.NORTH);
        panel.add(tableData(), BorderLayout.CENTER);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.add(table(), BorderLayout.CENTER);
                panel.revalidate();
                reset();
            }
        });
        panel.add(button(), BorderLayout.SOUTH);
        return panel;
    }
    private JPanel input(){
        JPanel panel = new JPanel(new GridLayout(2,9,2,2));
        panel.add(LbHoten);
        LbHoten.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbNgaysinh);
        LbNgaysinh.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbGioitinh);
        LbGioitinh.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbDiachi);
        LbDiachi.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbTenchidoan);
        LbTenchidoan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbNganhhoc);
        LbNganhhoc.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbChucvu);
        LbChucvu.setFont(new java.awt.Font("Segoe UI", 1, 12));

        panel.add(LbNull);

        panel.add(tfHoten);
        panel.add(tfNgaysinh);
        panel.add(tfGioitinh);
        panel.add(tfDiachi);
        panel.add(tfTenchidoan);
        panel.add(tfNganhhoc);
        panel.add(tfChucvu);

        panel.add(btnSearch);
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSearch.setBackground(Color.BLUE);
        btnSearch.setForeground(Color.WHITE);
        return panel;
    }
    private JPanel button() {
        JPanel panel = new JPanel(new GridLayout(1,3,2,2));

        panel.add(btnDoanvien);
        btnDoanvien.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnDoanphi);
        btnDoanphi.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnQHGD);
        btnQHGD.setFont(new java.awt.Font("Segoe UI", 1, 12));

        return  panel;
    }
    private JPanel table() {
        JPanel panel = new JPanel(new GridLayout(1,1,5,5));
        BangTimkiem();
        JScrollPane sp = new JScrollPane(tbSearch);
        panel.add(sp);
        return  panel;
    }
    private JPanel tableData(){
        JPanel panel = new JPanel(new GridLayout(1,1,5,5));
        BangDL();
        JScrollPane sp = new JScrollPane(tbSearch);
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
            tbSearch = new JTable();
            tbSearch.setModel(tm1); // thêm dữ liệu vào table
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void BangTimkiem()  {
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
            rs = st.executeQuery(sql_statement(tfHoten.getText(),tfNgaysinh.getText(),tfGioitinh.getText(),tfDiachi.getText(), tfTenchidoan.getText(), tfNganhhoc.getText(), tfChucvu.getText()));
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
            tbSearch = new JTable();
            tbSearch.setModel(tm1); // thêm dữ liệu vào table
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void reset() {
        tfHoten.setText("");
        tfNgaysinh.setText("");
        tfGioitinh.setText("");
        tfDiachi.setText("");
        tfTenchidoan.setText("");
        tfNganhhoc.setText("");
        tfChucvu.setText("");
    }
    public String sql_statement(String hoten, String ngaysinh, String gioitinh, String diachi, String tenchidoan, String nganhhoc, String chucvu ) {
        // câu lệnh xem dữ liệu
        String sql = "SELECT * FROM DOANVIEN WHERE ";

        if (hoten.length()>0){
            sql += (String)("Hoten like N'%"+hoten+"%'");
        }
        if (ngaysinh.length()>0){
            if (hoten.length()>0) sql += " AND";
            sql += (String)(" Ngaysinh like '%"+ngaysinh+"%'");
        }
        if (gioitinh.length()>0){
            if (hoten.length()>0 || ngaysinh.length()>0) sql += " AND";
            sql += (String)(" Gioitinh like N'%"+gioitinh+"%'");
        }
        if (diachi.length()>0){
            if (hoten.length()>0 || ngaysinh.length()>0 || gioitinh.length()>0) sql += " AND";
            sql += (String)(" Diachi like N'%"+diachi+"%'");
        }
        if (tenchidoan.length()>0){
            if (hoten.length()>0 || ngaysinh.length()>0 || gioitinh.length()>0 || diachi.length()>0 ) sql += " AND";
            sql += (String)(" Tenchidoan like '%"+tenchidoan+"%'");
        }
        if (nganhhoc.length()>0){
            if (hoten.length()>0 || ngaysinh.length()>0 || gioitinh.length()>0 || diachi.length()>0 || tenchidoan.length()>0) sql += " AND";
            sql += (String)(" Nganhhoc like N'%"+nganhhoc+"%'");
        }
        if (chucvu.length()>0){
            if (hoten.length()>0 || ngaysinh.length()>0 || gioitinh.length()>0 || diachi.length()>0 || tenchidoan.length()>0 || nganhhoc.length()>0) sql += " AND";
            sql += (String)(" Chucvu like N'%"+chucvu+"%'");
        }
        return sql;
    }
    public Doanvien_Search(){
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
    }
    public static void main(String[] args) {
        new Doanvien_Search();
    }
}

