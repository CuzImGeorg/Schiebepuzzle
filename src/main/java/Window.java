/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author georg
 */
public class Window extends JFrame{

    /**
     * Creates new form window
     */
    private JButton[] barr = new JButton[Game.getFields()];
    private JPanel p = new JPanel();


    
   public Window(int size) {
        setSize(size, size);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        p.setLayout(new GridLayout( (int) Math.sqrt(Game.getFields()), (int) Math.sqrt(Game.getFields())));
        p.setSize(size, size);
        update();
        for(JButton b :barr) {
            
            p.add(b);
        }
        p.setVisible(true);
        add(p);
//        initComponents();
        setVisible(true);
    }
  

    public void update() {
      
        ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                String text = ((JButton) e.getSource()).getText();
                if(!Game.isWon()) {
                Game.move(Integer.parseInt(text));
                }
            }
        }
        };
        int counter = 0;
        for (int i = 0; i < Game.getField().length; i++) {
            for (int j = 0; j < Game.getField().length; j++) {
                barr[counter] = new JButton();
                barr[counter].setText(String.valueOf(Game.getField()[i][j]));
                barr[counter].setSize(100, 100);
                barr[counter].setLocation((i+100)*i, (j+100)*j);
                barr[counter].addActionListener(listener);  
                barr[counter].setVisible(true);
                
                counter++;
            }
 
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new window().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
