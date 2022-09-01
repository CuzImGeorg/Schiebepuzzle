/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author georg
 */
public class GameStart extends JFrame {

    public GameStart() {

        
        setSize(400, 400);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3,0));
        JButton easy = new JButton();
        easy.setText("easy");
        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
             Game.beforStart("easy");
                }

            });
        p.add(easy);

        JButton medium = new JButton();
        medium.setText("medium");
        medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
             Game.beforStart("medium");
                }

            });
        p.add(medium);

        JButton hard = new JButton();
        hard.setText("hard");
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
             Game.beforStart("hard");
                }

            });
        p.add(hard);

//        JButton custom = new JButton();
//        custom.setText("custom");
//        custom.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent ae){
//             Game.beforStart("custom");
//                }
//
//            });
//        p.add(custom);

        add(p);
        setVisible(true);

    }

}
