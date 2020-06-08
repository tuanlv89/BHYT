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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    
    public void showResult(List<Hospital> lists) {
        for (Hospital hospital: lists) {
            double mienGiam = getVienPhiMienGiam(user.getAge(), user.getNation(), user.isIsRelativeMartyrs(), user.isIsPoorFamily(), user.getTuyenDK(), hospital.getTuyen());
            hospital.setMienGiam(mienGiam);
            model.addRow(new Object[] {
                hospital.getTen(), 
                hospital.getDiaChi(), 
                hospital.getTuyen(), 
                hospital.getHotline(), 
                String.valueOf(mienGiam)
            });
        }
    }
    
    private double getVienPhiMienGiam(int tuoi, String danToc, boolean thanNhanLietSi, boolean hoNgheo, int tuyenDK, int tuyenBV) {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm kiếm theo:");

        selectionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Lựa chọn--", "Tên bệnh viện", "Tuyến", "Địa chỉ", "Phần trăm chi trả" }));
        selectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionComboBoxActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(selectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchTextField)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(selectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            switch(index) {
                case 1: {
                    ArrayList<Hospital> list = hospitalControl.getHospitalByName(search);
                    showResult(list);
                    break;
                }
                case 2: {
                    if(!isNumeric(search)) {
                        JOptionPane.showMessageDialog(
                        panel, 
                        "Tuyến bệnh viện phải là 1 số từ 1, 2, 3, 4 tương ứng với: Tuyến trung ương, tỉnh, huyện, xã!", 
                        "Thông báo", 
                        JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    ArrayList<Hospital> list = hospitalControl.getHospitalByTuyen(Integer.parseInt(search));
                    showResult(list);
                    break;
                }
                case 3: {
                    ArrayList<Hospital> list = hospitalControl.getHospitalByAddress(search);
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
                            JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } 
                    double min = (toiThieu.equals("")) ? 0 : Double.parseDouble(toiThieu);
                    double max = (toiDa.equals("")) ? 100 : Double.parseDouble(toiDa);
                    if(jTextField1.getText().trim().equals("") && jTextField2.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(
                            panel, 
                            "Vui lòng điền thông tin tìm kiếm!", 
                            "Thông báo", 
                            JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else if (min < 0) {
                        JOptionPane.showMessageDialog(
                            panel, 
                            "Giá trị tối thiểu phải lớn hơn hoặc bằng 0!", 
                            "Thông báo", 
                            JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else if (max > 100) {
                        JOptionPane.showMessageDialog(
                            panel, 
                            "Giá trị tối đa phải nhỏ hơn hoặc bằng 100!", 
                            "Thông báo", 
                            JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else if (min > max) {
                        JOptionPane.showMessageDialog(
                            panel, 
                            "Giá trị tối thiểu phải nhỏ hơn hoặc bằng giá trị tối đa!", 
                            "Thông báo", 
                            JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else {
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
    }//GEN-LAST:event_selectionComboBoxActionPerformed

    
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> selectionComboBox;
    // End of variables declaration//GEN-END:variables
}
