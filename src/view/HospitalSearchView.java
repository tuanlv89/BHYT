/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.ConfigControl;
import Utils.Utils;
import DAO.HistoryControl;
import DAO.HospitalControl;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Config;
import model.Hospital;
import model.User;

/**
 *
 * @author hoanganhtuan
 */
public class HospitalSearchView extends javax.swing.JFrame {
    private User user;
    HospitalControl hospitalControl = new HospitalControl();
    DefaultTableModel model;
    KeyListener kl = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (searchTextField.getText().length() >= 50) // limit to 50 characters
                    e.consume();
            }
        };
    private ArrayList<Hospital> listHospitals = new ArrayList<>();
    public HospitalSearchView() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
    }
    
    public HospitalSearchView(User user) {
        initComponents();
        this.user = user;
        model = (DefaultTableModel) jTable1.getModel();
        listHospitals = hospitalControl.getAllHospital();
        showResult(listHospitals);
        onShowInputText();
        setTitle("Bệnh viện");
        setLocationRelativeTo(this);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
         for(int x=0;x<jTable1.getColumnCount();x++){
            jTable1.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        limitInput();
        ((JLabel) selectionComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    void onShowInputText() {
        int index = selectionComboBox.getSelectedIndex();
        if(index == 4 ) {
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jTextField1.setVisible(true);
            jTextField2.setVisible(true);
            searchTextField.setVisible(false);
        } else {
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            searchTextField.setVisible(true);
        }
    }
    
    private void limitInput() {
        int index = selectionComboBox.getSelectedIndex();
        System.out.println("index"+ index);
        jTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField1.getText().length() >= 5 ) // limit to 5 characters
                    e.consume();
            }
        });
        jTextField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField2.getText().length() >= 5 ) // limit to 5 characters
                    e.consume();
            }
        });
        
        int maxLength = (index == 2) ? 1 : 50;
        searchTextField.removeKeyListener(kl);
        kl = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (searchTextField.getText().length() >= maxLength) // limit to 50 characters
                    e.consume();
            }
        };
        searchTextField.addKeyListener(kl);
    }
    
    public void showResult(List<Hospital> lists) {
        if (lists.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có kết quả phù hợp!");
        } else {
            for (Hospital hospital: lists) {
                double mienGiam = getVienPhiMienGiam(user.getAge(), user.getNation(), user.isIsRelativeMartyrs(), user.isIsPoorFamily(), user.getTuyenDK(), hospital.getTuyen());
                hospital.setMienGiam(mienGiam);
                model.addRow(new Object[] {
                    hospital.getTen(), 
                    hospital.getDiaChi(), 
                    hospital.getTuyen(), 
                    hospital.getHotline(), 
                    String.valueOf(mienGiam)+"%"
                });
            }
        }
        
    }
    
    public double getVienPhiMienGiam(int tuoi, String danToc, boolean thanNhanLietSi, boolean hoNgheo, int tuyenDK, int tuyenBV) {
        double mienGiam = 0;
        ConfigControl configControl = new ConfigControl();
        Config currentConfig = configControl.getCurrentConfig();
        if(tuyenDK==tuyenBV) {
            mienGiam = Utils.ChiPhiDungTuyen(tuoi, tuyenDK, hoNgheo, thanNhanLietSi, danToc );
        } else {
            switch (tuyenBV) {
                case Utils.TUYEN_TRUNG_UONG:
                    mienGiam = currentConfig.getTraiTuyenTuyenTrungUong();
                    break;
                case Utils.TUYEN_TINH:
                    mienGiam = currentConfig.getTraiTuyenTuyenTinh();
                    break;
                case Utils.TUYEN_HUYEN:
                    mienGiam = currentConfig.getTraiTuyenTuyenHuyen();
                    break;
            }
        }
        return mienGiam;
    }
    
    public void addMissingInfoIfNeed() {
        if (jTextField1.getText().trim().equals("")) {
            jTextField1.setText("0");
        } else if (jTextField2.getText().trim().equals("")) {
            jTextField2.setText("100");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        selectionComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 455));
        setPreferredSize(new java.awt.Dimension(900, 455));
        setResizable(false);

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm kiếm theo:");

        selectionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Lựa chọn--", "Tên bệnh viện", "Tuyến", "Địa chỉ", "Phần trăm chi trả" }));
        selectionComboBox.setPreferredSize(new java.awt.Dimension(107, 25));
        selectionComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectionComboBoxMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectionComboBoxMouseReleased(evt);
            }
        });
        selectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionComboBoxActionPerformed(evt);
            }
        });
        selectionComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                selectionComboBoxPropertyChange(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên bệnh viện", "Địa chỉ", "Tuyến", "Hotline", "Phần trăm miễn giảm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(130);
        }

        jButton2.setText("Quay lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tối thiểu:");

        jLabel3.setText("Tối đa:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Bệnh viện");

        jLabel5.setText("Tuyến:");

        jLabel6.setText("1: Tuyến Trung ương");

        jLabel7.setText("2: Tuyến Tỉnh");

        jLabel8.setText("3: Tuyến Huyện");

        jLabel9.setText("4: Tuyến Xã");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addComponent(selectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int index = selectionComboBox.getSelectedIndex();
        if (index <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn 1 trường để tìm kiếm");
        } else {
            model.setRowCount(0);
            String search = searchTextField.getText();
            JPanel panel = (JPanel) getContentPane();
            if(index != 4 && search.equals("")) {
                JOptionPane.showMessageDialog(
                panel, 
                "Vui lòng điền thông tin tìm kiếm!", 
                "Thông báo", 
                JOptionPane.WARNING_MESSAGE);
                return;
            }
            switch(index) {
                case 1: {
                    ArrayList<Hospital> list = hospitalControl.getHospitalByName(search.trim());
                    showResult(list);
                    break;
                }
                case 2: {
                    if(!isNumeric(search) || Integer.parseInt(search) > 4 || Integer.parseInt(search) < 1) {
                        JOptionPane.showMessageDialog(
                        panel, 
                        "Tuyến bệnh viện phải là 1 số từ 1, 2, 3, 4 tương ứng với: Tuyến trung ương, tỉnh, huyện, xã!", 
                        "Thông báo", 
                        JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    ArrayList<Hospital> list = hospitalControl.getHospitalByTuyen(Integer.parseInt(search));
                    showResult(list);
                    break;
                }
                case 3: {
                    ArrayList<Hospital> list = hospitalControl.getHospitalByAddress(search.trim());
                    showResult(list);
                    break;
                }
                case 4: {
                    String toiThieu = jTextField1.getText().trim();
                    String toiDa = jTextField2.getText().trim();
                    if ((!isNumeric(toiDa) && !toiDa.equals("")) || (!isNumeric(toiThieu) && !toiThieu.equals(""))) {
                        JOptionPane.showMessageDialog(
                            panel, 
                            "Bạn nhập sai định dạng, vui lòng kiểm tra lại!", 
                            "Thông báo", 
                            JOptionPane.WARNING_MESSAGE);
                        return;
                    } 
                    double min = (toiThieu.equals("")) ? 0 : Double.parseDouble(toiThieu);
                    double max = (toiDa.equals("")) ? 100 : Double.parseDouble(toiDa);
                    if(jTextField1.getText().trim().equals("") && jTextField2.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(
                            panel, 
                            "Vui lòng điền thông tin tìm kiếm!", 
                            "Thông báo", 
                            JOptionPane.WARNING_MESSAGE);
                        break;
                    } else if (min < 0 || min > 100) {
                        JOptionPane.showMessageDialog(
                            panel, 
                            "Giá trị tối thiểu phải trong khoảng 0 - 100!", 
                            "Thông báo", 
                            JOptionPane.WARNING_MESSAGE);
                        break;
                    } else if (max > 100 || max < 0) {
                        JOptionPane.showMessageDialog(
                            panel, 
                            "Giá trị tối đa phải trong khoảng 0 - 100!", 
                            "Thông báo", 
                            JOptionPane.WARNING_MESSAGE);
                        break;
                    } else if (min > max) {
                        JOptionPane.showMessageDialog(
                            panel, 
                            "Giá trị tối thiểu phải nhỏ hơn hoặc bằng giá trị tối đa!", 
                            "Thông báo", 
                            JOptionPane.WARNING_MESSAGE);
                        break;
                    } else {
                        addMissingInfoIfNeed();
                        ArrayList<Hospital> list = hospitalControl.getHospitalByMienGiam(min, max, listHospitals);
                        showResult(list);
                        break;
                    }
                }
            }
            
            // TODO: Search database and show Result
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
 
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false; 
        }
        return pattern.matcher(strNum).matches();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomeView frame = new HomeView(user);
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void selectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionComboBoxActionPerformed
        // TODO add your handling code here
        onShowInputText();
        jTextField1.setText("");
        jTextField2.setText("");
        searchTextField.setText("");
        limitInput();
    }//GEN-LAST:event_selectionComboBoxActionPerformed

    private void selectionComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_selectionComboBoxPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_selectionComboBoxPropertyChange

    private void selectionComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectionComboBoxMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectionComboBoxMousePressed

    private void selectionComboBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectionComboBoxMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_selectionComboBoxMouseReleased

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HospitalSearchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HospitalSearchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HospitalSearchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HospitalSearchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HospitalSearchView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> selectionComboBox;
    // End of variables declaration//GEN-END:variables
}
