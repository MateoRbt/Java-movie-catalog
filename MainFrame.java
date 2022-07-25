/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproj;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class MainFrame extends JFrame {

    //components : Labels
    private JLabel LmovieTitle;
    private JLabel LmovieDirector;
    private JLabel LmovieDuration;
    private JLabel LmovieGenre;
    private JLabel LmovieDate;
    private JLabel Lprotagonist;
    private JLabel Lstars;
    private JLabel LparentalGuides;

    //components : text fields
    private JTextField movieTitletxt;
    private JTextField movieDirectortxt;
    private JTextField movieDurationtxt;
    private JTextField movieDatetxt;
    private JTextField protagonisttxt;

    // components : buttons
    private JButton savebtn;
    private JButton closebtn;
    private JButton aboutbtn;
    private JButton statsbtn;

    //components : combo box 
    private JComboBox movieGenrecb;
    private JComboBox starscb;
    private JComboBox parentalGuidescb;

    //components : extras 
    private String[] GenreStrings = {" ", "Comedy", "Drama", "Horror", "Adventure"};
    private String[] StarsStrings = {" ", "*", "**", "***", "****", "*****"};
    private String[] PGStrings = {" ", "G", "PG", "PG-13", "R", "NC 17"};

    private ArrayList<Movie> movieCatalog = new ArrayList();
    private ArrayList<Movie> bckMovieCatalog = new ArrayList();
    private JTextArea area;
    private int saveflag = 0;

    public MainFrame() {

        LmovieTitle = new JLabel("Movie Title");
        LmovieGenre = new JLabel("Movie Genre");
        LmovieDirector = new JLabel("Director");        //init labels
        LmovieDuration = new JLabel("Duration");
        LmovieDate = new JLabel("Date of Premiere");
        Lprotagonist = new JLabel("Main Protagonist");
        Lstars = new JLabel("Stars");
        LparentalGuides = new JLabel("Parental Guides");

        movieTitletxt = new JTextField(10);
        movieDirectortxt = new JTextField(10);                      //init txtfields
        movieDurationtxt = new JTextField(3);
        movieDatetxt = new JTextField(4);
        protagonisttxt = new JTextField(10);

        movieGenrecb = new JComboBox(GenreStrings);
        starscb = new JComboBox(StarsStrings);
        parentalGuidescb = new JComboBox(PGStrings);

        savebtn = new JButton("Save");
        closebtn = new JButton("Close");
        aboutbtn = new JButton("About");            //init buttons
        statsbtn = new JButton("Stats");

        area = new JTextArea();
        //create panels
        JPanel topPanel = new JPanel();

        topPanel.setLayout(
                new FlowLayout(FlowLayout.LEFT));

        JPanel bottomPanel = new JPanel();

        bottomPanel.setLayout(
                new FlowLayout(FlowLayout.LEFT));

        //add to panels
        topPanel.add(LmovieTitle);
        topPanel.add(movieTitletxt);
        topPanel.add(LmovieGenre);
        topPanel.add(movieGenrecb);
        topPanel.add(LmovieDirector);
        topPanel.add(movieDirectortxt);
        topPanel.add(LmovieDuration);
        topPanel.add(movieDurationtxt);
        topPanel.add(LmovieDate);
        topPanel.add(movieDatetxt);
        topPanel.add(Lprotagonist);
        topPanel.add(protagonisttxt);
        topPanel.add(Lstars);
        topPanel.add(starscb);
        topPanel.add(LparentalGuides);
        topPanel.add(parentalGuidescb);

        //bottompanels
        bottomPanel.add(closebtn);

        bottomPanel.add(aboutbtn);

        bottomPanel.add(statsbtn);

        bottomPanel.add(savebtn);

        area.setEditable(
                false);

        this.add(area, BorderLayout.CENTER);

        this.add(topPanel, BorderLayout.PAGE_START);

        this.add(bottomPanel, BorderLayout.PAGE_END);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.setSize(
                1290, 700);

        this.setResizable(false);

        this.setLocationRelativeTo(
                null);

        this.setTitle(
                "Movie Form");

        this.setVisible(
                true);

        //listeners
        this.addWindowListener(
                new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e
            ) {
                exitApp();
            }
        }
        );

        savebtn.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                saveFile();
            }
        }
        );

        closebtn.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                exitApp();
            }

        }
        );

        aboutbtn.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                new AboutMe();
            }

        }
        );

        statsbtn.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                callStats();
            }

        }
        );
    } //here is where the magic happens 

    private void clearFields() {
        movieTitletxt.setText("");
        movieDirectortxt.setText("");
        movieDatetxt.setText("");
        movieDurationtxt.setText("");
        protagonisttxt.setText("");
        movieGenrecb.setSelectedIndex(0);
        starscb.setSelectedIndex(0);
        parentalGuidescb.setSelectedIndex(0);

    } //clears fields for new entries.

    private int checkList(String name, String genre, String dir) {

        fileR("Adventure.txt");
        fileR("Comedy.txt");
        fileR("Drama.txt");
        fileR("Horror.txt");

        for (Movie movie : movieCatalog) {
            if ((movie.getMovieTitle().equals(name)) && (movie.getMovieGenre().equals(genre)) && (movie.getDirector().equals(dir))) {
                return 1;
            }
        }
        for (Movie movie : bckMovieCatalog) {
            if ((movie.getMovieTitle().equals(name)) && (movie.getMovieGenre().equals(genre)) && (movie.getDirector().equals(dir))) {
                return 1;
            }
        }

        return 0;
    } // function that checks the catalog if a movie already exist's

    public static int fmax(int a, int b, int c, int d) {

        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (d > max) {
            max = d;
        }

        return max;
    } // function that gets the max of 4 numbers : used by callStats action 

    private void exitApp() {
        int i;
        String mname = movieTitletxt.getText().trim();
        String mdir = movieDirectortxt.getText().trim();
        String gen = movieGenrecb.getSelectedItem().toString().trim();
        String date = movieDatetxt.getText().trim();
        String dur = movieDurationtxt.getText().trim();
        String star = starscb.getSelectedItem().toString().trim();
        String prot = protagonisttxt.getText().trim();
        String pg = parentalGuidescb.getSelectedItem().toString().trim();
        if (saveflag == 0) {  //check if you didn't saved your work  
            if ((mname != null && !mname.isEmpty()) && (mdir != null && !mdir.isEmpty()) //check if the fileds aren't empty 
                    && (gen != null && !gen.isEmpty()) && (date != null && !date.isEmpty())
                    && (dur != null && !dur.isEmpty()) && (star != null && !star.isEmpty())
                    && (prot != null && !prot.isEmpty()) && (pg != null && !pg.isEmpty())) {
                i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you realy want to exit the app you haven't saved your work ?");
                if (i == JOptionPane.YES_OPTION) {  //exit if you press yes 
                    System.exit(0);
                }

            } else { //if fields are empty dont show the not saved message
                i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to exit the app?");
                if (i == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        } else { //exit message if work is saved 
            i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to exit the app?");
            if (i == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    } // exit action

    private void setEntry() {
        String mname = movieTitletxt.getText().trim();
        String mdir = movieDirectortxt.getText().trim();
        String gen = movieGenrecb.getSelectedItem().toString().trim();
        String date = movieDatetxt.getText().trim();
        String dur = movieDurationtxt.getText().trim();
        String star = starscb.getSelectedItem().toString().trim();
        String prot = protagonisttxt.getText().trim();
        String pg = parentalGuidescb.getSelectedItem().toString().trim();

        if ((mname != null && !mname.isEmpty()) && (mdir != null && !mdir.isEmpty())  //check f fields are emtpy 
                && (gen != null && !gen.isEmpty()) && (date != null && !date.isEmpty())
                && (dur != null && !dur.isEmpty()) && (star != null && !star.isEmpty())
                && (prot != null && !prot.isEmpty()) && (pg != null && !pg.isEmpty())) {
            String id = mname.substring(0, 2) + gen.substring(0, 2) + mdir.substring(0, 2) + date; //id generation
            //this vars contains sybols that you may encounter if date and duration are given wrong  
            int firstIndex = dur.indexOf('.');
            int secIndex = dur.indexOf(':');
            int thindex = dur.indexOf(',');
            //check duration and date format 
            if (date.length() != 4 || dur.length() < 2 || (firstIndex > 0) || (secIndex > 0) || (thindex > 0)) { 
                if (date.length() != 4) {   //check date len
                    JOptionPane.showMessageDialog(
                            MainFrame.this,
                            "Wrong date \n date format must be YYYY",
                            "Entry error",
                            JOptionPane.WARNING_MESSAGE);
                    movieDatetxt.setText("");
                }
                if (dur.length() < 2 || (firstIndex > 0) || (secIndex > 0) || (thindex > 0)) {
                    JOptionPane.showMessageDialog( //check duration 
                            MainFrame.this,
                            "Wrong duration \n duration must be in minutes 000",
                            "Entry error",
                            JOptionPane.WARNING_MESSAGE);
                    movieDurationtxt.setText("");
                }

            } else {  //create movie and append to moviecatalog
                int d = Integer.parseInt(dur);
                int y = Integer.parseInt(date);
                int flag = checkList(mname, gen, mdir);
                if (flag == 0) {
                    Movie movie = new Movie(mname, mdir, d, y, id, gen, pg, prot, star);  //movie item creation
                    movieCatalog.add(movie);
                    area.append(movie.toString());
                    area.append("\n");
                    clearFields();
                    saveflag = 0;

                } else {
                    JOptionPane.showMessageDialog(
                            MainFrame.this,
                            "Movie already exists",
                            "Entry error",
                            JOptionPane.WARNING_MESSAGE);
                    clearFields();

                }
            }

        } else { //if fields are empty show message 
            JOptionPane.showMessageDialog(MainFrame.this, "Movie information is missing nothing to save", "Save error", JOptionPane.WARNING_MESSAGE);
        }

    } // action for generating movie id and checks if the entries are correct 

    private void fileR(String name) {

        try {
            //readfile
            BufferedReader reader = new BufferedReader(new FileReader(name));

            String line = "";
            String[] token;
            Movie movie;
            int a;
            int b;
            while (reader.ready()) {
                line = reader.readLine();
                token = line.split("\t");
                if (token.length == 9) {
                    a = Integer.parseInt(token[5]);
                    b = Integer.parseInt(token[4]);
                    movie = new Movie(token[0], token[3], a, b, token[1], token[2], token[8], token[6], token[7]);
                    bckMovieCatalog.add(movie);

                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    } // special method tha opens files and initializes back up catalog

    private void saveFile() {
        setEntry();
        if (!movieCatalog.isEmpty()) {
            try {
                String gname;

                //init buffered writter filewritter file
                BufferedWriter Hwriter = new BufferedWriter(new FileWriter("Horror.txt", true));
                BufferedWriter Cwriter = new BufferedWriter(new FileWriter("Comedy.txt", true));
                BufferedWriter Awriter = new BufferedWriter(new FileWriter("Adventure.txt", true));
                BufferedWriter Dwriter = new BufferedWriter(new FileWriter("Drama.txt", true));

                //begin saving parse its movie genre and open the txt it belongs 
                for (Movie movie : movieCatalog) {

                    gname = movie.getMovieGenre();
                    if ("Horror".equals(gname)) {
                        Hwriter.write(movie.toString());
                        Hwriter.newLine();

                    }
                    if ("Comedy".equals(gname)) {
                        Cwriter.write(movie.toString());
                        Cwriter.newLine();
                    }
                    if ("Adventure".equals(gname)) {
                        Awriter.write(movie.toString());
                        Awriter.newLine();
                    }
                    if ("Drama".equals(gname)) {
                        Dwriter.write(movie.toString());
                        Dwriter.newLine();
                    }
                }

                Hwriter.close();
                Cwriter.close();
                Awriter.close();
                Dwriter.close();
                JOptionPane.showMessageDialog(
                        MainFrame.this,
                        movieCatalog.size() + "  Entries saved to catalog",
                        "Save completed",
                        JOptionPane.INFORMATION_MESSAGE);
                saveflag = 1;
                movieCatalog.clear();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(savebtn,
                        "Can't access the catalog ",
                        "File access error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    } //action for save 

    private void callStats() {
        bckMovieCatalog.clear();  //clean back up catalog for data integrity
        fileR("Adventure.txt");
        fileR("Comedy.txt");
        fileR("Drama.txt");
        fileR("Horror.txt");

        if (!bckMovieCatalog.isEmpty()) {
            String gn = "";
            //counters to count genre entries 
            int hc = 0;
            int cc = 0;
            int ac = 0;
            int dc = 0;

            //parse the back up catalog and count for each file the entries
            for (Movie movie : bckMovieCatalog) {
                gn = movie.getMovieGenre();
                if ("Horror".equals(gn)) {
                    hc += 1;
                }
                if ("Adventure".equals(gn)) {
                    ac += 1;
                }
                if ("Comedy".equals(gn)) {
                    cc += 1;
                }
                if ("Drama".equals(gn)) {
                    dc += 1;
                }
            }
            //find max
            int maxg;
            int maxc = 0; //flag that schecks if there are more than 1 genre with the same number of entries
            maxg = fmax(hc, cc, ac, dc);

            //check if there is only one movie genre with the most entries 
            if (maxg == hc) {
                gn = "The movie genre with the most entries is : Horror   with : ";
                maxc++;

            }
            if (maxg == ac) {
                gn = "The movie genre with the most entries is : Adventure  with : ";
                maxc++;

            }
            if (maxg == cc) {
                gn = "The movie genre with the most entries is : Comedy   with : ";
                maxc++;

            }
            if (maxg == dc) {
                gn = "The movie genre with the most entries is : Drama  with : ";
                maxc++;

            }
            if (maxc >= 2) //check movie genre flag 
            {
                gn = "There is no  movie genre with more entries than :\t ";

            }

            //find oldest and newset movie
            //variables for newest and oldest movie
            int nu;
            int ol;
            nu = 0;
            ol = 100000;
            //this two variables save the position of the object 
            int pos = 0;  
            int pos2 = 0;
            for (Movie movie : bckMovieCatalog) {

                if (movie.getDate() > nu) {

                    nu = movie.getDate();
                    pos = bckMovieCatalog.indexOf(movie);
                } else if (movie.getDate() < ol) {
                    ol = movie.getDate();
                    pos2 = bckMovieCatalog.indexOf(movie);
                }

            }
            Movie nMovie = bckMovieCatalog.get(pos);
            Movie oMovie = bckMovieCatalog.get(pos2);

            new StatsFrame(oMovie, nMovie, gn, maxg, bckMovieCatalog.size());

        } else {
            JOptionPane.showMessageDialog(MainFrame.this, "The movie catalog is empty", "Stats error", JOptionPane.WARNING_MESSAGE);

        }
    } // action for stats frame

}
