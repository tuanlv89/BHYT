/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.ConfigControl;
import DAO.DBConection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import model.Config;
import model.User;

/**
 *
 * @author hoanganhtuan
 */
public class AddConfigView extends javax.swing.JFrame {
    private int tuoi;
    private double qlDungTuyen1;
    private double qlDungTuyen2;
    private double qlDungTuyen3;
    private double traiTuyenTuyenHuyen;
    private double traiTuyenTuyenTinh;
    private double traiTuyenTuyenTrungUong;
    Timestamp ngayApDung = new Timestamp(System.currentTimeMillis());
    ConfigControl configControl = new ConfigControl();
    private User user;
    /**
     * Creates new form AddConfigView
     */
    public AddConfigView(User user) {
        initComponents();
        setAlertInvisible();
        this.user = user;
        setTitle("Thêm cấu hình");
        setLocationRelativeTo(this);
        limitInput();
    }
    
    public AddConfigView() {
        initComponents();
    }
    
    private void limitInput() {
        jTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField1.getText().length() >= 3 ) // limit to 3 characters
                    e.consume();
            }
        });
        jTextField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField2.getText().length() >= 5 ) // limit to 3 characters
                    e.consume();
            }
        });
        jTextField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField3.getText().length() >= 5 ) // limit to 3 characters
                    e.consume();
            }
        });
        jTextField4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField4.getText().length() >= 5 ) // limit to 3 characters
                    e.consume();
            }
        });
        jTextField5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField5.getText().length() >= 5 ) // limit to 3 characters
                    e.consume();
            }
        });
        jTextField6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField6.getText().length() >= 5 ) // limit to 3 characters
                    e.consume();
            }
        });
        jTextField7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField7.getText().length() >= 5 ) // limit to 3 characters
                    e.consume();
            }
        });
    }
    
    boolean checkInput() {
        JPanel panel = (JPanel) getContentPane();
        String tuoi = jTextField1.getText().trim();
        String qlDungTuyen1 = jTextField2.getText().trim();
        String qlDungTuyen2 = jTextField3.getText().trim();
        String qlDungTuyen3 = jTextField4.getText().trim();
        String traiTuyenTuyenHuyen = jTextField5.getText().trim();
        String traiTuyenTuyenTinh = jTextField6.getText().trim();
        String traiTuyenTuyenTrungUong = jTextField7.getText().trim();
        if(checkInput(tuoi, qlDungTuyen1, qlDungTuyen2, qlDungTuyen3, traiTuyenTuyenHuyen, traiTuyenTuyenTinh, traiTuyenTuyenTrungUong)) {
            return false;
        } else setAlertInvisible();
        return true;
    }
    
    void getInput() {
        tuoi = Integer.parseInt(jTextField1.getText());
        qlDungTuyen1 = Double.parseDouble(jTextField2.getText());
        qlDungTuyen2 = Double.parseDouble(jTextField3.getText());
        qlDungTuyen3 = Double.parseDouble(jTextField4.getText());
        traiTuyenTuyenHuyen = Double.parseDouble(jTextField5.getText());
        traiTuyenTuyenTinh = Double.parseDouble(jTextField6.getText());
        traiTuyenTuyenTrungUong = Double.parseDouble(jTextField7.getText());
    }
    
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
 
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false; 
        }
        return pattern.matcher(strNum).matches();
    }
    
    private void setAlertInvisible() {
        tvTuoi.setVisible(false);
        tvqldt1.setVisible(false);
        tvqldt2.setVisible(false);
        tvqldt3.setVisible(false);
        tvttth.setVisible(false);
        tvtttt.setVisible(false);
        tvttttu.setVisible(false);
    }
    
    public boolean isTeenagerAge(int age) {
        if (age < 0 || age > 18) {
            return false;
        }
        
        return true;
    }
    
    public boolean isValidPercentage(double percent) {
        if (percent < 0 || percent > 100) {
            return false;
        }
        return true;
    }
    
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
}
    
    private boolean checkInput(String tuoi, String qlDungTuyen1, String qlDungTuyen2, String qlDungTuyen3, String traiTuyenTuyenHuyen, String traiTuyenTuyenTinh, String traiTuyenTuyenTrungUong) {
        boolean check = false;
        if(tuoi.equals("")) {
            tvTuoi.setText("Trường thông tin \"tuổi\" trống");
            tvTuoi.setVisible(true);
            check = true;
        } else if(!isNumeric(tuoi)) {
            tvTuoi.setText("Trường nhập không đúng định dạng số");
            tvTuoi.setVisible(true);
            check = true;
        } else if (!isInteger(tuoi)){
            tvTuoi.setText("Tuổi phải là một số nguyên dương");
            tvTuoi.setVisible(true);
            check = true;
        } else if(!isTeenagerAge(Integer.parseInt(tuoi))) {
            tvTuoi.setText("Giá trị phải nằm trong khoảng từ 0 - 18 tuổi!");
            tvTuoi.setVisible(true);
            check = true;
        }
        
        
        if(qlDungTuyen1.equals("")) {
            tvqldt1.setText("Trường \"quyền lợi đúng tuyến 1\" trống");
            tvqldt1.setVisible(true);
            check = true;
        } else if(!isNumeric(qlDungTuyen1)) {
            tvqldt1.setText("Trường nhập không đúng định dạng số");
            tvqldt1.setVisible(true);
            check = true;
        } else if(!isValidPercentage(Double.parseDouble(qlDungTuyen1))) {
            tvqldt1.setText("Giá trị phải nằm trong khoảng từ 0 - 100%!");
            tvqldt1.setVisible(true);
            check = true;
        }
        
        
       if(qlDungTuyen2.equals("")) {
            tvqldt2.setText("Trường \"quyền lợi đúng tuyến 2\" trống");
            tvqldt2.setVisible(true);
            check = true;
        } else if(!isNumeric(qlDungTuyen2)) {
            tvqldt2.setText("Trường nhập không đúng định dạng số");
            tvqldt2.setVisible(true);
            check = true;
        } else if(!isValidPercentage(Double.parseDouble(qlDungTuyen2))) {
            tvqldt2.setText("Giá trị phải nằm trong khoảng từ 0 - 100%!");
            tvqldt2.setVisible(true);
            check = true;
        }
       
       
       
        if(qlDungTuyen3.equals("")) {
            tvqldt3.setText("Trường thông tin \"quyền lợi đúng tuyến 3\" trống");
            tvqldt3.setVisible(true);
            check = true;
        } else if(!isNumeric(qlDungTuyen3)) {
            tvqldt3.setText("Trường nhập không đúng định dạng số");
            tvqldt3.setVisible(true);
            check = true;
        } else if(!isValidPercentage(Double.parseDouble(qlDungTuyen3))) {
            tvqldt3.setText("Giá trị phải nằm trong khoảng từ 0 - 100%!");
            tvqldt3.setVisible(true);
            check = true;
        }
        
        
        if(traiTuyenTuyenHuyen.equals("")) {
            tvttth.setText("Trường thông tin \"trái tuyến tuyến huyện\" trống");
            tvttth.setVisible(true);
            check = true;
        } else if(!isNumeric(traiTuyenTuyenHuyen)) {
            tvttth.setText("Trường nhập không đúng định dạng số");
            tvttth.setVisible(true);
            check = true;
        } else if(!isValidPercentage(Double.parseDouble(traiTuyenTuyenHuyen))) {
            tvttth.setText("Giá trị phải nằm trong khoảng từ 0 - 100%!");
            tvttth.setVisible(true);
            check = true;
        }
        
        
        if(traiTuyenTuyenTinh.equals("")) {
            tvtttt.setText("Trường thông tin \"trái tuyến tuyến tỉnh\" trống");
            tvtttt.setVisible(true);
            check = true;
        } else if(!isNumeric(traiTuyenTuyenTinh)) {
            tvtttt.setText("Trường nhập không đúng định dạng số");
            tvtttt.setVisible(true);
            check = true;
        } else if(!isValidPercentage(Double.parseDouble(traiTuyenTuyenTinh))) {
            tvtttt.setText("Giá trị phải nằm trong khoảng từ 0 - 100%!");
            tvtttt.setVisible(true);
            check = true;
        }
        
        if(traiTuyenTuyenTrungUong.equals("")) {
            tvttttu.setText("Trường thông tin \"trái tuyến tuyến trung ương\" trống");
            tvttttu.setVisible(true);
            check = true;
        } else if(!isNumeric(traiTuyenTuyenTrungUong)) {
            tvttttu.setText("Trường nhập không đúng định dạng số");
            tvttttu.setVisible(true);
            check = true;
        } else if(!isValidPercentage(Double.parseDouble(traiTuyenTuyenTrungUong))) {
            tvttttu.setText("Giá trị phải nằm trong khoảng từ 0 - 100%!");
            tvttttu.setVisible(true);
            check = true;
        }
        return check;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        tvTuoi = new javax.swing.JLabel();
        tvqldt1 = new javax.swing.JLabel();
        tvqldt3 = new javax.swing.JLabel();
        tvttth = new javax.swing.JLabel();
        tvtttt = new javax.swing.JLabel();
        tvttttu = new javax.swing.JLabel();
        tvqldt2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 455));
        setResizable(false);

        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Thêm cấu hình");

        jLabel2.setText("Tuổi:");

        jLabel3.setText("Quyền lợi đúng tuyến 1:");

        jLabel4.setText("Quyền lợi đúng tuyến 2:");

        jLabel5.setText("Quyền lợi đúng tuyến 3:");

        jLabel6.setText("Trái tuyến tuyến huyện:");

        jLabel7.setText("Trái tuyến tuyến tỉnh:");

        jTextField1.setAutoscrolls(false);
        jTextField1.setHighlighter(null);
        jTextField1.setMinimumSize(new java.awt.Dimension(110, 20));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });

        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });

        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });

        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });

        jButton2.setText("Thêm mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Trái tuyến tuyến trung ương:");
        jLabel8.setMaximumSize(new java.awt.Dimension(160, 14));
        jLabel8.setMinimumSize(new java.awt.Dimension(160, 14));
        jLabel8.setPreferredSize(new java.awt.Dimension(160, 14));

        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        tvTuoi.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        tvTuoi.setForeground(new java.awt.Color(255, 0, 0));
        tvTuoi.setText("jLabel9");

        tvqldt1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        tvqldt1.setForeground(new java.awt.Color(255, 0, 0));
        tvqldt1.setText("jLabel9");

        tvqldt3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        tvqldt3.setForeground(new java.awt.Color(255, 0, 0));
        tvqldt3.setText("jLabel9");

        tvttth.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        tvttth.setForeground(new java.awt.Color(255, 0, 0));
        tvttth.setText("jLabel9");

        tvtttt.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        tvtttt.setForeground(new java.awt.Color(255, 0, 0));
        tvtttt.setText("jLabel9");

        tvttttu.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        tvttttu.setForeground(new java.awt.Color(255, 0, 0));
        tvttttu.setText("jLabel9");

        tvqldt2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        tvqldt2.setForeground(new java.awt.Color(255, 0, 0));
        tvqldt2.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tvTuoi))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tvqldt1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tvqldt2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tvqldt3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tvttth))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tvtttt))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tvttttu)))
                        .addContainerGap(228, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))))
            .addGroup(layout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvTuoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvqldt1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvqldt2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvqldt3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvttth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvtttt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvttttu))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConfigView frame = new ConfigView(user);
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(!checkInput()) return;
        getInput();
        
        JPanel panel = (JPanel) getContentPane();
        UIManager.put("OptionPane.yesButtonText", "Có");
        UIManager.put("OptionPane.noButtonText", "Không");
        
        int n = JOptionPane.showConfirmDialog(
            panel, 
            "Bạn có muốn thêm cấu hình này không?", 
            "Thông báo", 
            JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION) {
                Config config = new Config(tuoi, qlDungTuyen1, qlDungTuyen2, qlDungTuyen3, traiTuyenTuyenHuyen, traiTuyenTuyenTinh, traiTuyenTuyenTrungUong, ngayApDung);
                System.out.println(config);
                DBConection conection = new DBConection();
                Connection conn = conection.getConnection();
                
                boolean isSuccess = configControl.insertNewConfig(conn, config);
                if(isSuccess) {
                    showMessage("Thêm cấu hình thành công!", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(AddConfigView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    showMessage("Thêm cấu hình không thành công!", JOptionPane.WARNING_MESSAGE);
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(AddConfigView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                new ConfigView(user).setVisible(true);
                dispose();
            } else {
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
           }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        setAlertInvisible();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // TODO add your handling code here:
        setAlertInvisible();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        // TODO add your handling code here:
        setAlertInvisible();
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        // TODO add your handling code here:
        setAlertInvisible();
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        // TODO add your handling code here:
        setAlertInvisible();
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
        setAlertInvisible();
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        // TODO add your handling code here:
        setAlertInvisible();
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
      
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased
    
    
    
    public void showMessage(String message, int type) {
        JOptionPane.showMessageDialog(this, message, "Thông báo", type);
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AddConfigView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddConfigView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddConfigView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddConfigView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddConfigView().setVisible(true);
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel tvTuoi;
    private javax.swing.JLabel tvqldt1;
    private javax.swing.JLabel tvqldt2;
    private javax.swing.JLabel tvqldt3;
    private javax.swing.JLabel tvttth;
    private javax.swing.JLabel tvtttt;
    private javax.swing.JLabel tvttttu;
    // End of variables declaration//GEN-END:variables
}
