/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproj;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author mateo
 */
public class StatsFrame extends JFrame {

    private JButton exitbtn;
    private JTextArea area;
    private Movie oldMovie;
    private Movie newMovie;
    private String gmov;
    private int num;
    private int totalEntries;

    public StatsFrame(Movie oldMovie, Movie newMovie, String gmov, int num, int totalEntries) {

        //Data from mainframe init.
        this.oldMovie = oldMovie;
        this.newMovie = newMovie;
        this.gmov = gmov;
        this.num = num;
        this.totalEntries = totalEntries;
        area = new JTextArea();

        //show the data 
        area.setText(this.gmov+this.num+"\tEntries\n"
        +this.oldMovie.getMovieTitle() + "\tis is the oldest movie with release date back in \t" + this.oldMovie.getDate() + "\n"
        +this.newMovie.getMovieTitle() + "\tis the newest  movie with release date  \t" + this.newMovie.getDate() + "\n"
        +"The total entries of the movie catalog are : " + this.totalEntries);
      

        exitbtn = new JButton("Back");
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(exitbtn);
        area.setEditable(false);
        this.add(area, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.PAGE_END);
        this.setSize(1290, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Movie Catalog Statistics");
        this.setVisible(true);

        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }

        });
    }

}
