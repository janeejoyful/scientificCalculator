// Project21bstv110.java
// Janee Yeak
// 18 June 2021

// This calculator can add, subtract, multiply, divide, calculate powers, 
// calculate square and cube roots, calculate sine, cosine, tangent,
// as well as arcsine, arccosine and arctangent. Parentheses work as expected
// (those in parentheses are calculated first).  The first equation will take a few seconds (to compute); After
// that all equations are computed rather quickly.

package Project21bstv110;

import java.awt.*;
import javax.swing.*;


class Project21bstv110
{
   public static void main(String[] args) {
      // Create the frame on the event dispatching thread.
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new Project21bstv110();
         }
      });
   }
   
   public Project21bstv110() // Constructor.
   {
      JFrame jfrm = new JFrame("My Calculator");
      jfrm.setSize(800, 250);
      jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jfrm.add(new Calculator(), BorderLayout.CENTER);
      jfrm.pack();
      jfrm.setVisible(true);
   }
}