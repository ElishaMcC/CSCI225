
// Program file name: FinalNO5EM.java
// Creates 4 fans with red blades that spin

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FinalNO5EM extends JFrame {
  public FinalNO5EM() {
    setLayout(new GridLayout(2, 2));
    // Create a MovingMessagePanel for displaying a moving message
    add(new MovingMessagePanel(50));
    add(new MovingMessagePanel(50));
    add(new MovingMessagePanel(50));
    add(new MovingMessagePanel(50));
  }

  /** Main method */
  public static void main(String[] args) {
    FinalNO5EM frame = new FinalNO5EM();
    frame.setTitle("FinalNO5EM");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(550, 400);
    frame.setVisible(true);
  }

  // Inner class: Displaying a moving message
  static class MovingMessagePanel extends JPanel {
    int arcpos = 60;

    public MovingMessagePanel(int delay){
      Timer timer = new Timer(delay, new TimerListener());
      timer.start();
    }


    /** Paint message */
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int radius = (int)(getHeight()*.5);
    int xCoordinate = getWidth()/2 - radius;
    int yCoordinate = getHeight()/2 - radius;

    g.setColor(Color.BLACK);
    g.drawOval(xCoordinate, yCoordinate, 2*radius, 2*radius);
    g.setColor(Color.RED);
    for(int i = 0; i < 4; i++){
        g.fillArc(xCoordinate+5, yCoordinate+5, (2 * radius)-10, (2 * radius)-10, arcpos + i*90, 40);
    }
    }

    class TimerListener implements ActionListener {
      /** Handle ActionEvent */
    public void actionPerformed(ActionEvent e) {
        arcpos += 10;
        repaint();
    }
    }
}
}