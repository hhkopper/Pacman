//
//package pacman.gui;
//
//import java.awt.Graphics;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import pacman.peli.Pacman;
//
//public class Pistelaskuri extends JPanel implements Paivitettava{
//    private Pacman peli;
//    private int ruudunSivunPituus;
//    private JLabel pisteet;
//    
//    public Pistelaskuri(Pacman peli, int sivunPituus) {
//        this.peli = peli;
//        this.ruudunSivunPituus = sivunPituus;
//        this.pisteet = new JLabel();
//    }
//    
//    @Override
//    protected void paintComponent(Graphics g) {
//        int pisteet = peli.getPisteet();
//        this.pisteet.setText(Integer.toString(pisteet));
//        
//        
//    }
//    @Override
//    public void paivita() {
//        repaint();
//    }
//    
//}
