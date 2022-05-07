package GUI;

import DBManage.ConnectDB_QLDV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class QHGD_Search {
    JFrame f = new JFrame("Quản lý đoàn viên - TÌM KIẾM QUAN HỆ GIA ĐÌNH CỦA ĐOÀN VIÊN");

    JLabel lbHTBo = new JLabel("Họ tên bố");
    JLabel lbNSBo = new JLabel("Năm sinh bố");
    JLabel lbNNBo = new JLabel("Nghề nghiệp bố");
    JLabel lbHTMe = new JLabel("Họ tên mẹ");
    JLabel lbNSMe = new JLabel("Năm sinh mẹ");
    JLabel lbNNMe = new JLabel("Nghề nghiệp mẹ");

    JLabel lbNull = new JLabel("");
//    JLabel lbNull1 = new JLabel("");
//    JLabel lbNull2 = new JLabel("");

    JTextField tfHTBo = new JTextField(10);
    JTextField tfNSBo = new JTextField(10);
    JTextField tfNNBo = new JTextField(10);
    JTextField tfHTMe = new JTextField(10);
    JTextField tfNSMe = new JTextField(10);
    JTextField tfNNMe = new JTextField(10);

    JButton btnReset = new JButton("Reset");
    JButton btnSearch = new JButton("Tìm kiếm");
    JButton btnDoanvien = new JButton("ĐOÀN VIÊN");
    JButton btnDoanphi = new JButton("ĐOÀN PHÍ");
    JButton btnQHGD = new JButton("QUAN HỆ GIA ĐÌNH");


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
        JPanel panel = new JPanel(new GridLayout(2,7,5,5));
        panel.add(lbHTBo);
        panel.add(lbNSBo);
        panel.add(lbNNBo);
        panel.add(lbHTMe);
        panel.add(lbNSMe);
        panel.add(lbNNMe);
        panel.add(lbNull);
        panel.add(tfHTBo);
        panel.add(tfNSBo);
        panel.add(tfNNBo);
        panel.add(tfHTMe);
        panel.add(tfNSMe);
        panel.add(tfNNMe);
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
                JOptionPane.showMessageDialog(null, "Đoàn viên không tồn tại");
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
            rs = st.executeQuery(sql_statement(tfHTBo.getText(), tfNSBo.getText(), tfNNBo.getText(), tfHTMe.getText(), tfNSMe.getText(), tfNNMe.getText() ));
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
        tfHTBo.setText("");
        tfNSBo.setText("");
        tfNNBo.setText("");
        tfHTMe.setText("");
        tfNSMe.setText("");
        tfNNMe.setText("");
    }
    public String sql_statement(String hotenbo, String namsinhbo, String nghenghiepbo, String hotenme , String namsinhme, String nghenghiepme) {
        String sql = "SELECT DOANVIEN.MADV, DOANVIEN.MASV, DOANVIEN.Hoten, DOANVIEN.Ngaysinh, DOANVIEN.Gioitinh, DOANVIEN.Diachi, DOANVIEN.Tenchidoan, DOANVIEN.Nganhhoc, DOANVIEN.Chucvu FROM DOANVIEN INNER JOIN QUANHEGIADINH ON DOANVIEN.MADV = QUANHEGIADINH.MADV WHERE ";
        // Thang1.equals("Rồi") || Thang1.equals("Chưa")
        if (hotenbo.length()>0) {
            sql += (String)("HoTenBo like N'%"+hotenbo+"%'");
        }
        if (namsinhbo.length()>0){
            if (hotenbo.length()>0) sql += " AND";
            sql += (String)(" NamSinhBo = '"+namsinhbo+"'");
        }
        if (nghenghiepbo.length()>0){
            if (hotenbo.length()>0 || namsinhbo.length()>0) sql += " AND";
            sql += (String)(" NgheNghiepBo like N'%"+nghenghiepbo+"%'");
        }
        if (hotenme.length()>0){
            if (hotenbo.length()>0 || namsinhbo.length()>0 || nghenghiepbo.length()>0) sql += " AND";
            sql += (String)(" HoTenMe like N'%"+hotenme+"%'");
        }
        if (namsinhme.length()>0){
            if (hotenbo.length()>0 || namsinhbo.length()>0 || nghenghiepbo.length()>0 || hotenme.length()>0) sql += " AND";
            sql += (String)(" NamSinhMe = '"+namsinhme+"'");
        }
        if (nghenghiepme.length()>0){
            if (hotenbo.length()>0 || namsinhbo.length()>0 || nghenghiepbo.length()>0 || hotenme.length()>0 || namsinhme.length()>0 ) sql += " AND";
            sql += (String)(" NgheNghiepMe like N'%"+nghenghiepme+"%'");
        }
        return sql;
    }
    public QHGD_Search() {
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
        new QHGD_Search();
    }
}

