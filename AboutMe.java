/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproj;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author mateo
 */
public class AboutMe extends JFrame {

    public AboutMe() {
        JLabel aboutlb = new JLabel();
        ImageIcon img;
        JButton exitbtn;
        img = new ImageIcon("index.png"); //img input 
        aboutlb.setBorder(new EmptyBorder(0, 10, 0, 10));//top,left,bottom,right
        aboutlb.setIcon(img);
        aboutlb.setText("<html><h3>Movie Registration App</h3><br>"
                + "This application has been developed in the framework of Java Development Course \n"
                + "As an exam for my finals \n"
                + "<br> <b> Author </b> : Ματέο Ρουμπάτι \n"
                + "<br> <b> Semester </b> : 12 \n"
                + "<br> <b> Class </b> : ΜΑΕ 08 \n"
                + "<br><strong>2021-22</strong></html>");

        exitbtn = new JButton("Back");
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(exitbtn);
        
        this.add(bottomPanel, BorderLayout.PAGE_END);
        this.add(aboutlb);
        this.setSize(1290, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("About");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);

        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }

        });
    }

 
}
