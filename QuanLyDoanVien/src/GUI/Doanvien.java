package GUI;
import DBManage.ConnectDB_QLDV;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

class Doanvien {

    JFrame f = new JFrame("Quản lý đoàn viên - ĐOÀN VIÊN");
    JLabel LbQLDV = new JLabel("THÔNG TIN ĐOÀN VIÊN", SwingConstants.CENTER);

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

    JLabel LbMADV = new JLabel("    Mã đoàn viên");
    JTextField tfMADV = new JTextField(10);

    JLabel LbMASV = new JLabel("    Mã sinh viên");
    JTextField tfMASV = new JTextField(10);

    JLabel LbHoten = new JLabel("    Họ và tên");
    JTextField tfHoten = new JTextField(10);

    JLabel LbNgaysinh = new JLabel("    Ngày sinh");
    JTextField tfNgaysinh = new JTextField(10);

    JLabel LbGioitinh = new JLabel("    Giới tính");
    JRadioButton rbtnNam = new JRadioButton("Nam");
    JRadioButton rbtnNu = new JRadioButton("Nữ");
    ButtonGroup bG = new ButtonGroup();

    JLabel LbDiachi = new JLabel("    Địa chỉ");
    JTextField tfDiachi = new JTextField(10);

    JLabel LbTenchidoan = new JLabel("    Tên chi đoàn");
    JTextField tfTenchidoan = new JTextField(10);

    JLabel LbNganhhoc = new JLabel("    Ngành học");
    JCheckBox cbCNTT = new JCheckBox("CNTT");
    JCheckBox cbKinhte = new JCheckBox("Kinh tế");

    JLabel LbChucvu = new JLabel("    Chức vụ");
    String[] chucvu = {"Không", "BTCĐ", "Phó bí thư"};
    JComboBox cboChucvu = new JComboBox(chucvu);

    JButton btnAdd = new JButton("Thêm");
    JButton btnUpdate = new JButton("Cập nhật");
    JButton btnDelete = new JButton("Xóa");

    JButton btnDoanphi = new JButton("ĐOÀN PHÍ");
    JButton btnQHGD = new JButton("QUAN HỆ GIA ĐÌNH");
    JButton btnSearch = new JButton("Tìm kiếm");
    JButton btnReload = new JButton("Reset");

    JTable tbDoanvien;
    JPanel temp;

    PreparedStatement ps;
    Connection conn = null;
    ResultSet rs;
    DefaultTableModel tm;

    private void TaoFrame() {
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocation(360, 230);
        f.setSize(1300, 510);
        f.add(TaoPanel());
        f.setVisible(true);
    }
    private JPanel TaoPanel() {
        JPanel panel = new JPanel(new BorderLayout(11, 11));
        temp = new JPanel(new BorderLayout(1,1));
        temp.add(table());
        panel.add(temp, BorderLayout.CENTER);
        panel.add(title(), BorderLayout.NORTH);
        panel.add(input(), BorderLayout.WEST);
        panel.add(button_QLDV(), BorderLayout.SOUTH);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Them_DV();
                temp.removeAll();
                temp.add(table());
                temp.revalidate();
                temp.repaint();
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Capnhat_DV();
                temp.removeAll();
                temp.add(table());
                temp.revalidate();
                temp.repaint();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Xoa_DV();
                temp.removeAll();
                temp.add(table());
                temp.revalidate();
                temp.repaint();
            }
        });
        return panel;
    }
    private JPanel title() {
        JPanel panel = new JPanel(new GridLayout(1, 3, 1, 1));
        panel.add(LbNull);
        panel.add(LbQLDV);
        LbQLDV.setFont(new java.awt.Font("Segoe UI", 1, 16));
        LbQLDV.setForeground(Color.blue);
        panel.add(LbNull1);
        return panel;
    }
    private JPanel input() {
        JPanel panel = new JPanel(new GridLayout(10, 3, 3, 3));
        panel.add(LbMADV);
        LbMADV.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfMADV);
        panel.add(LbNull4);
        panel.add(LbMASV);
        LbMASV.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfMASV);
        panel.add(LbNull5);
        panel.add(LbHoten);
        LbHoten.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfHoten);
        panel.add(LbNull6);
        panel.add(LbNgaysinh);
        LbNgaysinh.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfNgaysinh);
        panel.add(LbNull7);
        panel.add(LbGioitinh);
        LbGioitinh.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bG.add(rbtnNam);
        bG.add(rbtnNu);
        panel.add(rbtnNam);
        rbtnNam.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbtnNu);
        rbtnNu.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbDiachi);
        LbDiachi.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfDiachi);
        panel.add(LbNull8);
        panel.add(LbTenchidoan);
        LbTenchidoan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfTenchidoan);
        panel.add(LbNull9);
        panel.add(LbNganhhoc);
        LbNganhhoc.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(cbCNTT);
        cbCNTT.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(cbKinhte);
        cbKinhte.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbChucvu);
        LbChucvu.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(cboChucvu);
        cboChucvu.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbNull10);
        panel.add(btnAdd);
        btnAdd.setBackground(Color.green);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnUpdate);
        btnUpdate.setBackground(Color.blue);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnDelete);
        btnDelete.setBackground(Color.red);
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12));
        return panel;
    }
    private JPanel button_QLDV() {
        JPanel panel = new JPanel(new GridLayout(1, 4, 2, 2));
        panel.add(btnReload);
        btnReload.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnDoanphi);
        btnDoanphi.setFont(new java.awt.Font("Segoe UI", 1, 12));
//            btnDoanphi.setBackground(Color.BLACK);
//            btnDoanphi.setForeground(Color.WHITE);
        panel.add(btnQHGD);
        btnQHGD.setFont(new java.awt.Font("Segoe UI", 1, 12));
//            btnQHGD.setBackground(Color.BLACK);
//            btnQHGD.setForeground(Color.WHITE);
        panel.add(btnSearch);
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12));
//            btnSearch.setBackground(Color.BLACK);
//            btnSearch.setForeground(Color.WHITE);
        return panel;
    }
    private JPanel table() {
        JPanel panel = new JPanel(new GridLayout(1, 1, 5, 5));
        HienthiDoanvien();
        panel.addMouseListener(new mouseEvent());
        JScrollPane sp = new JScrollPane(tbDoanvien);
        panel.add(sp);
        sp.addMouseListener(new mouseEvent());
        tbDoanvien.addMouseListener(new mouseEvent());
        sp.setFont(new java.awt.Font("Segoe UI", 1, 12));
        return panel;
    }

    public void HienthiDoanvien() {
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        rs = cn.DanhsachDoanvien("SELECT * FROM DOANVIEN");
        String[] column = {"Mã đoàn viên", "Mã sinh viên", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Tên chi đoàn", "Ngành học", "Chức vụ"};
        tm = new DefaultTableModel(column, 0);
        tm.setRowCount(0);
        try {
            while (rs.next()) {
                Object data[] = {rs.getString("MADV"), rs.getString("MASV"), rs.getString("Hoten"), rs.getString("Ngaysinh"), rs.getString("Gioitinh"), rs.getString("Diachi"), rs.getString("Tenchidoan"), rs.getString("Nganhhoc"), rs.getString("Chucvu")};
                tbDoanvien = new JTable(tm);
                tm.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void Them_DV() {
        ConnectDB_QLDV con_DV = new ConnectDB_QLDV();

        String gioitinh = "";
        if (rbtnNam.isSelected())
            gioitinh = rbtnNam.getText();
        else
            gioitinh = rbtnNu.getText();

        String nganhhoc = "";
        if (cbCNTT.isSelected())
            nganhhoc += cbCNTT.getText() + ";";
        if (cbKinhte.isSelected())
            nganhhoc += cbKinhte.getText();

        String chucvu = cboChucvu.getSelectedItem().toString();

        String ngaysinh = tfNgaysinh.getText();
        Date date = Date.valueOf(ngaysinh);

        conn = con_DV.connect_SQL();
        try {
            ps = conn.prepareStatement("Exec sp_ThemDoanvien ?,?,?,?,?,?,?,?,?");
            ps.setString(1, tfMADV.getText());
            ps.setString(2, tfMASV.getText());
            ps.setString(3, tfHoten.getText());
            ps.setString(4, String.valueOf(date));
            ps.setString(5, gioitinh);
            ps.setString(6, tfDiachi.getText());
            ps.setString(7, tfTenchidoan.getText());
            ps.setString(8, nganhhoc);
            ps.setString(9, chucvu);
            int record = ps.executeUpdate();
            if (record == 0)
                JOptionPane.showMessageDialog(null,"Thêm không thành công");
            conn.close();
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null,e2);
        }
    }
    public void Capnhat_DV() {
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        String gioitinh = "";
        if (rbtnNam.isSelected())
            gioitinh = rbtnNam.getText();
        else
            gioitinh = rbtnNu.getText();

        String nganhhoc = "";
        if (cbCNTT.isSelected())
            nganhhoc += cbCNTT.getText() + ";";
        if (cbKinhte.isSelected())
            nganhhoc += cbKinhte.getText();

        String chucvu = cboChucvu.getSelectedItem().toString();

        String ngaysinh = tfNgaysinh.getText();
        Date date = Date.valueOf(ngaysinh);

        conn = cn.connect_SQL();
        try {
            // Exec sp_Update_Dv1 ?,?,?,?,?,?,?,?,?
            ps = conn.prepareStatement("UPDATE DOANVIEN SET MaSV=?, Hoten=?, Ngaysinh=?, Gioitinh=?, Diachi=?, Tenchidoan=?, Nganhhoc=?, Chucvu=? WHERE MaDV=? ");
            ps.setString(1, tfMASV.getText());
            ps.setString(2, tfHoten.getText());
            ps.setString(3, String.valueOf(date));
            ps.setString(4, gioitinh);
            ps.setString(5, tfDiachi.getText());
            ps.setString(6, tfTenchidoan.getText());
            ps.setString(7, nganhhoc);
            ps.setString(8, chucvu);
            ps.setString(9, tfMADV.getText());
            int record = ps.executeUpdate();
            if (record == 0)
                JOptionPane.showMessageDialog(null,"Cập nhật không thành công");
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
    public void Xoa_DV() {
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        conn = cn.connect_SQL();
        try {
            ps = conn.prepareStatement("Exec sp_Delete_Dv ?");
            ps.setString(1, tfMADV.getText());
            int record = ps.executeUpdate();
            if (record == 0)
                JOptionPane.showMessageDialog(null,"Xóa không thành công");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public void reset() {
        tfMADV.setText("");
        tfMASV.setText("");
        tfHoten.setText("");
        tfNgaysinh.setText("");
        tfDiachi.setText("");
        tfTenchidoan.setText("");
        cbCNTT.setSelected(false);
        cbKinhte.setSelected(false);
        cboChucvu.setSelectedItem("Không");
    }
    public Doanvien() {
        TaoFrame();
        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
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
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Doanvien_Search();
                f.setVisible(false);
            }
        });
    }
    public static void main(String[] args) {
        new Doanvien();
    }
    class mouseEvent implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            int i = tbDoanvien.getSelectedRow();
            System.out.println(i);
            tfMADV.setText((String) (tm.getValueAt(i, 0)));
            tfMASV.setText((String) (tm.getValueAt(i, 1)));
            tfHoten.setText((String) (tm.getValueAt(i, 2)));
            tfNgaysinh.setText((String) (tm.getValueAt(i, 3)));
            if (tm.getValueAt(i,4).equals("Nam")){
                rbtnNam.setSelected(tm.isCellEditable(i,4));
            } else {
                rbtnNu.setSelected(tm.isCellEditable(i,4));
            }
            tfDiachi.setText((String) (tm.getValueAt(i, 5)));
            tfTenchidoan.setText((String) (tm.getValueAt(i, 6)));
            if (tm.getValueAt(i,7).equals("CNTT;")){
                cbKinhte.setSelected(false);
                cbCNTT.setSelected(tm.isCellEditable(i,7));
            } else {
                cbCNTT.setSelected(false);
                cbKinhte.setSelected(tm.isCellEditable(i,7));
            }
            cboChucvu.setSelectedItem(tm.getValueAt(i,8));
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
    }
}
