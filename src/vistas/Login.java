package vistas;

import Administrador.Admin;
import java.awt.Color;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.LoginBack;

public class Login extends javax.swing.JFrame {

    int xMouse, yMouse;

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    public void validar() {
        String correo = txtRut.getText();
        String pass = String.valueOf(txtPass.getPassword());
        if (!correo.isEmpty() && !pass.isEmpty()) {
            LoginBack loginBack = new LoginBack();
            modelo.Login login = loginBack.buscarUsuario(correo, pass);
            if (login != null) {
                String tipoUsuario = loginBack.obtenerTipoUsuario(correo);
                switch (tipoUsuario) {
                    case "admin":
                        Admin admin = new Admin();
                        admin.setVisible(true);
                        break;
                    case "proveedor":
                        proveedor proveedor = new proveedor();
                        proveedor.setVisible(true);
                        break;
                    case "venta":
                        Venta venta = new Venta();
                        venta.setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Tipo de usuario inválido");
                        break;
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Correo o Contraseña Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar correo y contraseña");
        }
    }

    public void windowStateChanged(WindowEvent e) {
        if (e.getNewState() == JFrame.MAXIMIZED_BOTH) {
            // Haz algo cuando la ventana se maximice
        } else if (e.getNewState() == JFrame.NORMAL) {
            // Haz algo cuando la ventana vuelva a su tamaño normal
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtPass = new javax.swing.JPasswordField();
        barra = new javax.swing.JPanel();
        BtnCerrar = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        BtnMinimizar = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        BtnMaximizar = new javax.swing.JPanel();
        btnMaximizar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        BackGround.setBackground(new java.awt.Color(255, 255, 255));
        BackGround.setForeground(new java.awt.Color(255, 255, 255));
        BackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estatua.png"))); // NOI18N
        BackGround.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, -10, 360, 760));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("USUARIO");
        BackGround.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        txtRut.setBackground(new java.awt.Color(255, 255, 255));
        txtRut.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtRut.setForeground(new java.awt.Color(204, 204, 255));
        txtRut.setToolTipText("");
        txtRut.setBorder(null);
        BackGround.add(txtRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 580, 40));
        BackGround.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 720, 10));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CONTRASEÑA");
        BackGround.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, -1, -1));
        BackGround.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, 720, 10));

        txtPass.setBackground(new java.awt.Color(255, 255, 255));
        txtPass.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPass.setBorder(null);
        BackGround.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 630, 40));

        barra.setBackground(new java.awt.Color(255, 255, 255));
        barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMouseDragged(evt);
            }
        });
        barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMousePressed(evt);
            }
        });

        BtnCerrar.setBackground(new java.awt.Color(255, 255, 255));

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xabierto.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout BtnCerrarLayout = new javax.swing.GroupLayout(BtnCerrar);
        BtnCerrar.setLayout(BtnCerrarLayout);
        BtnCerrarLayout.setHorizontalGroup(
            BtnCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnCerrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrar))
        );
        BtnCerrarLayout.setVerticalGroup(
            BtnCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnCerrarLayout.createSequentialGroup()
                .addComponent(btnCerrar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        BtnMinimizar.setBackground(new java.awt.Color(255, 255, 255));

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Miabierto.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BtnMinimizarLayout = new javax.swing.GroupLayout(BtnMinimizar);
        BtnMinimizar.setLayout(BtnMinimizarLayout);
        BtnMinimizarLayout.setHorizontalGroup(
            BtnMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnMinimizarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMinimizar))
        );
        BtnMinimizarLayout.setVerticalGroup(
            BtnMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnMinimizarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMinimizar))
        );

        BtnMaximizar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout BtnMaximizarLayout = new javax.swing.GroupLayout(BtnMaximizar);
        BtnMaximizar.setLayout(BtnMaximizarLayout);
        BtnMaximizarLayout.setHorizontalGroup(
            BtnMaximizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        BtnMaximizarLayout.setVerticalGroup(
            BtnMaximizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        btnMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Mxabierto.png"))); // NOI18N
        btnMaximizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaximizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout barraLayout = new javax.swing.GroupLayout(barra);
        barra.setLayout(barraLayout);
        barraLayout.setHorizontalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(BtnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaximizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 936, Short.MAX_VALUE))
        );
        barraLayout.setVerticalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraLayout.createSequentialGroup()
                .addGroup(barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(barraLayout.createSequentialGroup()
                        .addGroup(barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMaximizar))
                        .addGap(1, 1, 1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BackGround.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 30));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BackGround.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 730, 270));

        btnEntrar.setText("ENTRAR");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        BackGround.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 625, 220, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 1532, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_barraMousePressed

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_barraMouseDragged

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnMaximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizarMouseClicked

    }//GEN-LAST:event_btnMaximizarMouseClicked

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        
        String correo = txtRut.getText();
    String pass = String.valueOf(txtPass.getPassword());
    if (!correo.isEmpty() && !pass.isEmpty()) {
        LoginBack loginBack = new LoginBack();
        modelo.Login login = loginBack.buscarUsuario(correo, pass);
        if (login != null) {
            String tipoUsuario = loginBack.obtenerTipoUsuario(correo);
            switch (tipoUsuario) {
                case "administrador": {
                    Admin admin = new Admin(login.getNombre());
                    admin.setVisible(true);
                    dispose();
                    break;
                }
                case "reponedor": {
                    proveedor proveedor = new proveedor();
                    proveedor.setVisible(true);
                    dispose();
                    break;
                }
                case "vendedor": {
                    Venta venta = new Venta();
                    venta.setVisible(true);
                    dispose();
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Tipo de usuario inválido");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales inválidas");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Debe ingresar correo y contraseña");
    }


    }//GEN-LAST:event_btnEntrarActionPerformed
    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {
        BtnCerrar.setBackground(Color.red);
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JPanel BtnCerrar;
    private javax.swing.JPanel BtnMaximizar;
    private javax.swing.JPanel BtnMinimizar;
    private javax.swing.JPanel barra;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel btnMaximizar;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}