package GUI;

import DBManage.ConnectDB_QLDV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class QHGD extends JFrame {
    JFrame f = new JFrame("Quản lý đoàn viên - QUAN HỆ GIA ĐÌNH");
    JLabel LbQHGD = new JLabel("QUAN HỆ GIA ĐÌNH");
    JLabel LbMADV = new JLabel("Mã đoàn viên");
    JTextField tfMADV = new JTextField(10);

    JLabel LbNull = new JLabel("");
    JLabel LbNull1 = new JLabel("");
    JLabel LbNull2 = new JLabel("");
    JLabel LbNull3 = new JLabel("");
    JLabel LbNull4 = new JLabel("");
    JLabel LbNull5 = new JLabel("");
    JLabel LbNull6 = new JLabel("");
    JLabel LbNull7 = new JLabel("");
    JLabel LbNull8 = new JLabel("");
    JLabel LbNull9 = new JLabel("");
    JLabel LbNull10 = new JLabel("");
    JLabel LbNull11 = new JLabel("");

    JLabel LbHTBo = new JLabel("Họ tên bố");
    JLabel LbNSBo = new JLabel("Năm sinh bố");
    JLabel LbNNBo = new JLabel("Nghề nghiệp bố");
    JLabel LbHTMe = new JLabel("Họ tên mẹ");
    JLabel LbNSMe = new JLabel("Năm sinh mẹ");
    JLabel LbNNMe = new JLabel("Nghề nghiệp mẹ");
    JTextField tfHTBo = new JTextField(10);
    JTextField tfNSBo = new JTextField(10);
    JTextField tfNNBo = new JTextField(10);
    JTextField tfHTMe = new JTextField(10);
    JTextField tfNSMe = new JTextField(10);
    JTextField tfNNMe = new JTextField(10);

    JButton btnAdd = new JButton("Thêm");
    JButton btnUpdate = new JButton("Cập nhật");
    JButton btnDelete = new JButton("Xóa");

    JButton btnReset = new JButton("Reset");
    JButton btnDoanvien = new JButton("ĐOÀN VIÊN");
    JButton btnDoanphi = new JButton("ĐOÀN PHÍ");
    JButton btnSearch = new JButton("Tìm kiếm");

    JTable tbQHGD;
    JPanel temp;

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    DefaultTableModel tm;

    private void TaoFrame(){
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocation(470,300);
        f.setSize(1140,400);
//        f.getContentPane().setBackground(new Color(00,00,00, 84));
        f.add(TaoPanel());
        // f.pack();
        f.setVisible(true);
    }
    private JPanel TaoPanel(){
        JPanel panel = new JPanel(new BorderLayout(10,10));
        temp = new JPanel(new BorderLayout(1,1));
        temp.add(table());
        panel.add(temp, BorderLayout.CENTER);
        panel.add(MaDV_title(), BorderLayout.NORTH);
        panel.add(input(), BorderLayout.WEST);
//        panel.add(table(), BorderLayout.CENTER);
        panel.add(button(), BorderLayout.SOUTH);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Them();
                temp.removeAll();
                temp.add(table());
                temp.revalidate();
                temp.repaint();
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Capnhat();
                temp.removeAll();
                temp.add(table());
                temp.revalidate();
                temp.repaint();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Xoa();
                temp.removeAll();
                temp.add(table());
                temp.revalidate();
                temp.repaint();
            }
        });
        return panel;
    }
    private JPanel MaDV_title(){
        JPanel panel = new JPanel(new GridLayout(1,6,1,1));
        panel.add(LbMADV);
        LbMADV.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfMADV);
        panel.add(LbNull);
        panel.add(LbNull1);
        panel.add(LbNull5);
        panel.add(LbQHGD);
        LbQHGD.setFont(new java.awt.Font("Segoe UI", 1, 13));
        panel.add(LbNull2);
        panel.add(LbNull3);
        panel.add(LbNull4);
        return panel;
    }
    private JPanel input(){
        JPanel panel = new JPanel(new GridLayout(7,3,2,2));
        panel.add(LbHTBo);
        LbHTBo.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfHTBo);
        panel.add(LbNull6);
        panel.add(LbNSBo);
        LbNSBo.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfNSBo);
        panel.add(LbNull7);
        panel.add(LbNNBo);
        LbNNBo.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfNNBo);
        panel.add(LbNull8);
        panel.add(LbHTMe);
        LbHTMe.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfHTMe);
        panel.add(LbNull9);
        panel.add(LbNSMe);
        LbNSMe.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfNSMe);
        panel.add(LbNull10);
        panel.add(LbNNMe);
        LbNNMe.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfNNMe);
        panel.add(LbNull11);
        panel.add(btnAdd);
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnAdd.setBackground(Color.green);
        btnAdd.setForeground(Color.WHITE);
        panel.add(btnUpdate);
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnUpdate.setBackground(Color.BLUE);
        btnUpdate.setForeground(Color.WHITE);
        panel.add(btnDelete);
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnDelete.setBackground(Color.RED);
        btnDelete.setForeground(Color.WHITE);
        return panel;
    }
    private JPanel table(){
        JPanel panel = new JPanel(new GridLayout(1,1,5,7));
        HienthiQHGD();
        panel.addMouseListener(new mouseEvent());
        JScrollPane sp = new JScrollPane(tbQHGD);
        panel.add(sp);
        sp.addMouseListener(new mouseEvent());
        tbQHGD.addMouseListener(new mouseEvent());
        return panel;
    }
    private JPanel button(){
        JPanel panel = new JPanel(new GridLayout(1,4,1,1));
//        panel.add(btnList);
        panel.add(btnReset);
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnDoanvien);
        btnDoanvien.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnDoanphi);
        btnDoanphi.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnSearch);
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12));
//        panel.add(btnReload);
//        btnReload.setFont(new java.awt.Font("Segoe UI", 1, 12));
        return panel;
    }
    public void HienthiQHGD(){
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        rs = cn.DanhsachDoanvien("SELECT * FROM QUANHEGIADINH");
        String column[] = {"Mã ĐV","Họ tên bố","Năm sinh bố","Nghề nghiệp bố","Họ tên mẹ","Năm sinh mẹ","Nghề nghiệp mẹ"};
        tm = new DefaultTableModel(column,0);

        try {
            while (rs.next()){
                Object data[] = {rs.getString("MaDV"),rs.getString("HoTenBo"),rs.getString("NamSinhBo"),rs.getString("NgheNghiepBo"),rs.getString("HoTenMe"),rs.getString("NamSinhMe"),rs.getString("NgheNghiepMe")};
                tm.addRow(data);
                tbQHGD = new JTable(tm);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void Them() {
        ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
        conn = con_DV.connect_SQL();
        try {
            ps = conn.prepareStatement("Exec sp_Them_qhgd ?,?,?,?,?,?,?");
            ps.setString(1, tfMADV.getText());
            ps.setString(2, tfHTBo.getText());
            ps.setString(3, tfNSBo.getText());
            ps.setString(4, tfNNBo.getText());
            ps.setString(5, tfHTMe.getText());
            ps.setString(6, tfNSMe.getText());
            ps.setString(7, tfNNMe.getText());
            int record = ps.executeUpdate();
            if (record > 0)
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            else
                JOptionPane.showMessageDialog(null,"Thêm không thành công");
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public void Capnhat() {
        ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
        conn = con_DV.connect_SQL();
        try {
            ps = conn.prepareStatement("UPDATE QUANHEGIADINH SET HoTenBo = ?, NamSinhBo = ?, NgheNghiepBo = ?, HoTenMe = ?, NamSinhMe = ?, NgheNghiepMe = ? WHERE MADV = ?");
            ps.setString(1, tfHTBo.getText());
            ps.setString(2, tfNSBo.getText());
            ps.setString(3, tfNNBo.getText());
            ps.setString(4, tfHTMe.getText());
            ps.setString(5, tfNSMe.getText());
            ps.setString(6, tfNNMe.getText());
            ps.setString(7, tfMADV.getText());
            int record = ps.executeUpdate();
            if (record > 0)
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            else
                JOptionPane.showMessageDialog(null,"Cập nhật không thành công");
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public void Xoa() {
        ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
        conn = con_DV.connect_SQL();
        try {
            ps = conn.prepareStatement("Exec sp_Xoa_dhgd ?");
            ps.setString(1, tfMADV.getText());
            int record = ps.executeUpdate();
            if (record > 0)
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            else
                JOptionPane.showMessageDialog(null,"Xóa không thành công");
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public void reset() {
        tfMADV.setText("");
        tfHTBo.setText("");
        tfNSBo.setText("");
        tfNNBo.setText("");
        tfHTMe.setText("");
        tfNSMe.setText("");
        tfNNMe.setText("");

    }
    public QHGD(){
        TaoFrame();
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
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
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QHGD_Search();
                f.setVisible(false);
            }
        });
    }
    public static void main(String[] args) {
        new QHGD();
    }
    class mouseEvent implements MouseListener {
        public void mouseClicked(MouseEvent e){
            int i = tbQHGD.getSelectedRow();
            System.out.println(i);
            tfMADV.setText((String)(tm.getValueAt(i,0)));
            tfHTBo.setText((String)(tm.getValueAt(i,1)));
            tfNSBo.setText((String)(tm.getValueAt(i,2)));
            tfNNBo.setText((String)(tm.getValueAt(i,3)));
            tfHTMe.setText((String)(tm.getValueAt(i,4)));
            tfNSMe.setText((String)(tm.getValueAt(i,5)));
            tfNNMe.setText((String)(tm.getValueAt(i,6)));
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
