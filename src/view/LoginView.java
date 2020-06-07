/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.UserControl;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author hoanganhtuan
 */
public class LoginView extends javax.swing.JFrame {
    String currentUsername;
    String currentPassword;
    
    public void checkInfo(){
        if (usernameTextField.getText().equals("")) {
            showMessage("Bạn chưa nhập Username!");
        } else if (passwordTextField.getText().equals("")) {
            showMessage("Bạn chưa nhập Password!");
        } else {
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            UserControl control = new UserControl();
               
            if (control.checkUser(username, password) == null) {
                showMessage("Sai Username hoặc Password!");
            } else {
                User user = control.checkUser(username, password);
                System.out.println(user);
                if(user != null) {
                    HomeView hv = new HomeView(control.getUser(user.getId()));
                    hv.setVisible(true);
                    dispose();
                }
            }
        }
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Thong bao", JOptionPane.WARNING_MESSAGE);
    }
    public LoginView() {
        initComponents();
        setTitle("Hệ thống tính Bảo hiểm y tế");
        setLocationRelativeTo(this);
    } 
    
    
    private void goToHomeView() {
        HomeView frame = new HomeView();
        frame.setVisible(true);
        this.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        password.setText("Mật khẩu:");

        username.setText("Tên đăng nhập:");

        usernameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameTextFieldKeyPressed(evt);
            }
        });

        passwordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTextFieldKeyPressed(evt);
            }
        });

        jButton1.setText("Đăng nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameTextField)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        checkInfo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usernameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextFieldKeyPressed
        if (usernameTextField.getText().length() == 10) {
            usernameTextField.setText(currentUsername);
        } else {
            currentUsername = usernameTextField.getText();
        }
    }//GEN-LAST:event_usernameTextFieldKeyPressed

    private void passwordTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextFieldKeyPressed
        String passwordText = String.valueOf(passwordTextField.getPassword());
        if (passwordText.length() == 10) {
            passwordTextField.setText(currentPassword);
        } else {
            currentPassword = passwordText;
        }
    }//GEN-LAST:event_passwordTextFieldKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel username;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
