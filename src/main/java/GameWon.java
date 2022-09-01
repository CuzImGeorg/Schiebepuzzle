/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author georg
 */
public class GameWon extends JFrame {

    public GameWon(int zuege) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        JPanel p = new JPanel();
        p.setSize(500, 500);
        JTextArea t = new JTextArea();
        t.setText("Du hast Gewonnen");
        JTextArea t2 = new JTextArea();
        t2.setText("Du hast " + zuege + " Züge gebraucht");
        p.add(t);
        p.add(t2);
        add(p);

    }

}
