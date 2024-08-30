// Calculator.java
// Janee Yeak
// 18 June 2021
// This is for Project21bstv110

package Project21bstv110;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.ArrayList;


class Calculator extends JPanel implements ActionListener
{
   int state = 0;
   private boolean after = false;
   private double memoryFunction;
   
   JTextField equationBox;
   JTextField resultBox;
   JLabel label;
     
   DefaultListModel<String> lm;
   JList<String> list;
      
   public Calculator() // Constructor:
   {
     
     memoryFunction = new Double(0.0);

      // Create Button.
      JButton one = new JButton("1");
      JButton two = new JButton("2");
      JButton three = new JButton("3");
      JButton four = new JButton("4");
      JButton five = new JButton("5");
      JButton six = new JButton("6");
      JButton seven = new JButton("7");
      JButton eight = new JButton("8");
      JButton nine = new JButton("9");
      JButton zero = new JButton("0");
      JButton decimalPoint = new JButton(".");
      
      JButton pi = new JButton("π");
      JButton ans = new JButton("Ans");
      
      JButton delete = new JButton("DEL");
      JButton ac = new JButton("AC");
      
      JButton add = new JButton("+");
      JButton multiply = new JButton("×");
      JButton divide = new JButton("÷");
      JButton minus = new JButton("-");
      
      JButton equals = new JButton("=");
      
      JButton sqrt = new JButton("√");
      JButton cbrt = new JButton("3√"); 
      
      JButton sin = new JButton("sin");
      JButton cos = new JButton("cos");
      JButton tan = new JButton("tan");
      
      JButton asin = new JButton("asin");
      JButton acos = new JButton("acos");
      JButton atan = new JButton("atan");
      
      JButton openP = new JButton("(");
      JButton closeP = new JButton(")");
      
      JButton mPlus = new JButton("M+");
      JButton mMinus = new JButton("M-");
      JButton MR = new JButton("MR");
      JButton MC = new JButton("MC");
      JButton e = new JButton("E");

      JButton power = new JButton("^");
      JButton euler = new JButton("e"); 
      
      JButton in = new JButton("In"); 
      JButton logTen = new JButton("log10");
      
      JButton square = new JButton("x²");
             
      lm = new DefaultListModel<>();
      lm.addElement("No Calculator history; key in an equation to start.");
      lm.addElement("No Calculator history; key in an equation to start.");
      lm.addElement("No Calculator history; key in an equation to start.");
      lm.addElement("No Calculator history; key in an equation to start.");
      lm.addElement("No Calculator history; key in an equation to start.");
     
      list = new JList<>(lm);
      label = new JLabel("     The little list below will display all previously computed equations  ");
            
      equationBox = new JTextField(50);
      equationBox.setEditable(false);
      resultBox = new JTextField(50);
      resultBox.setEditable(false);
      
      equationBox.setActionCommand("");
      resultBox.setActionCommand("");
            
      // Adding ActionListeners for the numbers...
      one.addActionListener(this);
      two.addActionListener(this);
      three.addActionListener(this);
      four.addActionListener(this);
      five.addActionListener(this);
      six.addActionListener(this);
      seven.addActionListener(this);
      eight.addActionListener(this);
      nine.addActionListener(this);
      zero.addActionListener(this);
      
      delete.addActionListener(this);
      ac.addActionListener(this);
      
      multiply.addActionListener(this);
      divide.addActionListener(this);
      add.addActionListener(this);
      minus.addActionListener(this);
      decimalPoint.addActionListener(this);
      equals.addActionListener(this);
      
      ans.addActionListener(this);
      decimalPoint.addActionListener(this);
      pi.addActionListener(this);
      
      sqrt.addActionListener(this);
      cbrt.addActionListener(this);
      
      sin.addActionListener(this);
      cos.addActionListener(this);
      tan.addActionListener(this);
      asin.addActionListener(this);
      acos.addActionListener(this);
      atan.addActionListener(this);
      
      openP.addActionListener(this);
      closeP.addActionListener(this);
      
      mPlus.addActionListener(this);
      mMinus.addActionListener(this);
      MC.addActionListener(this);
      MR.addActionListener(this);
      e.addActionListener(this);
      power.addActionListener(this);
      euler.addActionListener(this);
      
      in.addActionListener(this);
      logTen.addActionListener(this);
      
      square.addActionListener(this);
      
      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
      c.fill = GridBagConstraints.HORIZONTAL;
      c.weightx = 0.5;
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 5;
      
      add(equationBox, c);
      
      c.gridx = 0;
      c.gridy = 1;
      
      add(resultBox, c);
      
      c.gridx = 0;
      c.gridy = 2;
      c.gridwidth = 1;
      
      add(mPlus, c);

      c.gridx = 1;
      c.gridy = 2;
      
      add(mMinus, c);
      
      c.gridx = 2;
      c.gridy = 2;
      
      add(MC, c);
      
      c.gridx = 3;
      c.gridy = 2;
      
      add(MR, c);
      
      c.gridx = 4;
      c.gridy = 2;
      
      add(e, c);
      
      c.gridx = 0;
      c.gridy = 3;
      
      add(square, c);
      
      c.gridx = 1;
      c.gridy = 3;
      
      add(sqrt, c);
      
      c.gridx = 2;
      c.gridy = 3;
      
      add(cbrt, c);
      
      c.gridx = 3;
      c.gridy = 3;
      
      add(power, c);
      
      c.gridx = 4;
      c.gridy = 3;
      
      add(euler, c);
      
      c.gridx = 0;
      c.gridy = 4;
      
      add(sin, c);
      
      c.gridx = 1;
      c.gridy = 4;
      
      add(cos, c);
      
      c.gridx = 2;
      c.gridy = 4;
      
      add(tan, c);

      c.gridx = 3;
      c.gridy = 4;
      
      add(in, c);

      c.gridx = 4;
      c.gridy = 4;
      
      add(logTen, c);

      c.gridx = 0;
      c.gridy = 5;
      
      add(asin, c);
      
      c.gridx = 1;
      c.gridy = 5;
      
      add(acos, c);
      
      c.gridx = 2;
      c.gridy = 5;
      
      add(atan, c);
      
      c.gridx = 3;
      c.gridy = 5;
      
      add(openP, c);
      
      c.gridx = 4;
      c.gridy = 5;
      
      add(closeP, c);
      
      c.gridx = 0;
      c.gridy = 6;
          
      add(one, c);
      
      c.gridx = 1;
      c.gridy = 6;
      
      add(two, c);
      
      c.gridx = 2;
      c.gridy = 6;
      
      add(three, c);
      
      c.gridx = 3;
      c.gridy = 6;
      
      add(delete, c);
      
      c.gridx = 4;
      c.gridy = 6;
      
      add(ac, c);
      
      c.gridx = 0;
      c.gridy = 7;
      
      add(four, c);
      
      c.gridx = 1;
      c.gridy = 7;
      
      add(five, c);
      
      c.gridx = 2;
      c.gridy = 7;
      
      add(six, c);
      
      c.gridx = 3;
      c.gridy = 7;
      
      add(multiply, c);
      
      c.gridx = 4;
      c.gridy = 7;
      
      add(divide, c);
      
      c.gridx = 0;
      c.gridy = 8;
      
      add(seven, c); 
       
      c.gridx = 1;
      c.gridy = 8;
      
      add(eight, c);
      
      c.gridx = 2;
      c.gridy = 8;
      
      add(nine, c);
      
      c.gridx = 3;
      c.gridy = 8;
      
      add(add, c);
      
      c.gridx = 4;
      c.gridy = 8;
      
      add(minus, c);
      
      c.gridx = 0;
      c.gridy = 9;
      
      add(zero, c);
      
      c.gridx = 1;
      c.gridy = 9;
      
      add(decimalPoint, c);
      
      c.gridx = 2;
      c.gridy = 9;
      
      add(pi, c);
      
      c.gridx = 3;
      c.gridy = 9;
      
      add(ans, c);
      
      c.gridx = 4;
      c.gridy = 9;
      
      add(equals, c);
      
      c.gridx = 0;
      c.gridy = 10; 
      c.gridwidth = 5; 
                
      add(label, c);
      
      c.gridx = 0;
      c.gridy = 11;
      
      add(list, c);
      

   }   
   
   // Handle Events.
  public void actionPerformed(ActionEvent e)
  {  
      if(e.getActionCommand().equals("1"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "1"); 
      }
      else if(e.getActionCommand().equals("2"))
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "2");  
      }
      else if(e.getActionCommand().equals("3"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "3"); 
      }
      else if(e.getActionCommand().equals("4"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "4");
      }
      else if(e.getActionCommand().equals("5"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "5"); 
      }
      else if(e.getActionCommand().equals("6"))  
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "6");
      }
      else if(e.getActionCommand().equals("7"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "7");  
      }
      else if(e.getActionCommand().equals("8"))   
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "8");
      }
      else if(e.getActionCommand().equals("9"))    
      {
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "9"); 
      }
      else if(e.getActionCommand().equals("0"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "0");
      }
      else if(e.getActionCommand().equals("+"))    
      {
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "+");
      }
      else if(e.getActionCommand().equals("×"))    
      {
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation 
         equationBox.setText(equationBox.getText() + "×");
      }
      else if(e.getActionCommand().equals("÷"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation   
         equationBox.setText(equationBox.getText() + "÷");
      }
      else if(e.getActionCommand().equals("-"))   
      {
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "-");
      }
      else if(e.getActionCommand().equals("."))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation   
         equationBox.setText(equationBox.getText() + ".");
      }
      else if(e.getActionCommand().equals("Ans")) 
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + resultBox.getText());
      }
      else if(e.getActionCommand().equals("="))   
      { 
         resultBox.setText(computeEquation(equationBox.getText())); 
         after = true;
         String s = new String(equationBox.getText() + " = " + resultBox.getText());
         lm.addElement(s);
         resetList();
      }
      
      else if(e.getActionCommand().equals("DEL"))  
      {
         try {
         equationBox.setText(equationBox.getText().substring(0, (equationBox.getText().length())-1));  
         }
         
         catch (StringIndexOutOfBoundsException exception) { }
      }
      else if(e.getActionCommand().equals("AC")) { equationBox.setText(""); resultBox.setText(""); }
      
      else if(e.getActionCommand().equals("sin"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation   
         equationBox.setText(equationBox.getText() + "sin(");
      }
      else if(e.getActionCommand().equals("cos"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation   
         equationBox.setText(equationBox.getText() + "cos(");
      }
      else if(e.getActionCommand().equals("tan"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation   
         equationBox.setText(equationBox.getText() + "tan(");
      }
      else if(e.getActionCommand().equals("asin"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation   
         equationBox.setText(equationBox.getText() + "asin(");
      }
      else if(e.getActionCommand().equals("acos"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation   
         equationBox.setText(equationBox.getText() + "acos(");
      }
      else if(e.getActionCommand().equals("atan"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation   
         equationBox.setText(equationBox.getText() + "atan(");
      }
      else if(e.getActionCommand().equals("("))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "("); 
      }
      else if(e.getActionCommand().equals(")"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + ")"); 
      }
      else if(e.getActionCommand().equals("√"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "√"); 
      }
      else if(e.getActionCommand().equals("3√"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "3√"); 
      }
      else if(e.getActionCommand().equals("π"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         equationBox.setText(equationBox.getText() + "π"); 
      }
      else if(e.getActionCommand().equals("M+"))    
      { 
         try {
         double temp = Double.parseDouble(resultBox.getText());
         memoryFunction += temp;   
         }
         catch (NumberFormatException exception)  { }
      }

      else if(e.getActionCommand().equals("M-"))    
      { 
         try {
         double temp = Double.parseDouble(resultBox.getText());
         memoryFunction -= temp; 
         }
         catch (NumberFormatException exception) { }  
      }

      else if(e.getActionCommand().equals("MC"))        {     memoryFunction = 0.0;     }
      else if(e.getActionCommand().equals("MR"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation
         resultBox.setText(Double.toString(memoryFunction)); 
      }
      else if(e.getActionCommand().equals("E"))
      {
         if (!after)
            equationBox.setText(equationBox.getText() + "E");
      }
      else if(e.getActionCommand().equals("^"))
      {
         if(!after)
            equationBox.setText(equationBox.getText()+"^");
      }
      else if(e.getActionCommand().equals("e"))    
      { 
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation   
         equationBox.setText(equationBox.getText() + "e");
      }
      else if(e.getActionCommand().equals("In"))
      {
         if(after)  {  equationBox.setText(""); after = false;   }  // if this is the line of a new equation.
         equationBox.setText(equationBox.getText()+"In");
      }
      else if(e.getActionCommand().equals("log10"))
      {
         if(after)  { equationBox.setText(""); after = false;    }  // if this is the line of a new equation.
         equationBox.setText(equationBox.getText()+"log10(");
      }
      else if(e.getActionCommand().equals("x²"))
      {
         if(after)  { equationBox.setText(""); after = false;    }  // if this is the line of a new equation.
         equationBox.setText(equationBox.getText()+"²");
      }
   }
   protected void paintComponent(Graphics g) // setting a gradient background
   {
      super.paintComponent(g);
   
    Graphics2D g2d = (Graphics2D)g;
      
      g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      int w = getWidth();
      int h = getHeight();
      Color color1 = new Color(248, 219, 224);  // Carousel Pink #F8DBE0
      Color color2 = new Color(253, 108, 158);  // French Pink   #FD6C9E
      GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
      g2d.setPaint(gp);
      g2d.fillRect(0, 0, w, h);
   }
   private String computeEquation(String eqn)  
   {
      ScriptEngineManager mgr = new ScriptEngineManager();
      ScriptEngine engine = mgr.getEngineByName("js");

      try {
      try {
         String eqn0 = eqn.replace("e","2.718281828459045235360287471352");    // replace Euler's number
         String eqn1 = eqn0.replace("π", "3.141592653589793238462643383979");  // replace pi
         String eqn2 = eqn1.replace("×", "*");   // quite handy :)
         String eqn3 = eqn2.replace("÷", "/");
         String interruption = checkSquare(eqn3);
         String exception = checkExponent(interruption);
         String eqn4 = findTrig(exception);
         String eqn5 = checkCbrt(eqn4);
         String eqn6 = checkSqrt(eqn5);
         Object obj = engine.eval(eqn6); 
         String result = obj.toString();
         return result;
      }
      catch (ScriptException exception)  {  }
      }
      catch (NullPointerException exception) { } 

      return eqn;
   }
   private String findTrig(String s)
   {
      int asin = s.indexOf("asin");
      while(asin>-1)   { s = checkAsin(s);  asin = s.indexOf("asin"); } 
      int acos = s.indexOf("acos");
      while(acos>-1)   { s = checkAcos(s);  acos = s.indexOf("acos"); }
      int atan = s.indexOf("atan");
      while(atan>-1)   { s = checkAtan(s);  atan = s.indexOf("atan"); }
      int sin = s.indexOf("sin");
      while(sin>-1)    { s = checkSin(s);   sin = s.indexOf("sin");   }
      int cos = s.indexOf("cos");
      while(cos>-1)    { s = checkCos(s);   cos = s.indexOf("cos");   }
      int tan = s.indexOf("tan");
      while(tan>-1)    { s = checkTan(s);   tan = s.indexOf("tan");   }
      int logTen = s.indexOf("log10");
      while(logTen>-1) { s = checkLogTen(s); logTen = s.indexOf("log10"); }
      int in = s.indexOf("In");
      while(in>-1)    { s = checkIn(s);   in = s.indexOf("In");   }
      return s; 
   }
   
   private String checkAsin (String s)
   {
      int asin = s.indexOf("asin");
      String second = s;

      if (asin>-1)
      {
         try {
              int index = findClosingParen(s, asin+5); 
              int after = asin + 5;
              String first = s.substring(after, index-1);                // the string of the stuff inside the parathesis
              String two = computeEquation(first);
              double number = Double.parseDouble(two);   // converting it to a number
              String result = Double.toString(Math.toDegrees(Math.asin(number)));   // here's where the math comes in
              String beginning = s.substring(0, asin);  
              String end = s.substring(index);
              second = beginning + result + end; 
            
         }
         catch (NumberFormatException exception) { } 
      }
      
      return second;   
   }
   private String checkAcos(String s)
   {
      int acos = s.indexOf("acos");
      String second = s;

      if (acos>-1)
      {
         try {
              int index = findClosingParen(s, acos+5);
              int after = acos + 5;
              String first = s.substring(after, index-1);  // Stuff inside the parenthesis
              String two = computeEquation(first);
              double number = Double.parseDouble(two);  // changed to a number
              String result = Double.toString(Math.toDegrees(Math.acos(number)));   // math
              String beginning = s.substring(0, acos);
              String end = s.substring(index);
              second = beginning + result + end; 
         }
         catch (NumberFormatException exception) { } 
      }
      return second;

   }
   private String checkAtan(String s)
   {
      int atan = s.indexOf("atan");
      String second = s;

      if (atan>-1)
      {
         try {
              int index = findClosingParen(s, atan+5);
              int after = atan + 5;
              String first = s.substring(after, index-1);  // parenthesis
              String two = computeEquation(first);
              double number = Double.parseDouble(two); // number
              String result = Double.toString(Math.toDegrees(Math.atan(number)));  // Math, also i'm tired of writing comments.
              String beginning = s.substring(0, atan);
              String end = s.substring(index);
              second = beginning + result + end; 
         }
         catch (NumberFormatException exception) { } 
      }
      
      return second;
   }
   private String checkSin(String s)
   {
      int sin = s.indexOf("sin");
      String second = s;
      
      if (sin!= -1)
      {
         try {
              int index = findClosingParen(s, sin+4);
              int after = sin + 4;
              String first = s.substring(after, index-1);
              String two = computeEquation(first);
              double number = Double.parseDouble(two);
              double number2 = Math.toRadians(number);  
              String result = Double.toString(Math.sin(number2));
              String beginning = s.substring(0, sin);
              String end = s.substring(index);
              second = beginning + result + end; 
         }
         catch (NumberFormatException exception) { } 
      }
      
      return second;
   }
   private String checkCos(String s)
   {
      int cos = s.indexOf("cos");
      String second = s;
      if (cos!= -1)
      {
         try {
              int index = findClosingParen(s, cos+4);
              int after = cos + 4;
              String first = s.substring(after, index-1);
              String two = computeEquation(first);
              double number = Double.parseDouble(two);
              double number2 = Math.toRadians(number);  
              String result = Double.toString(Math.cos(number2));
              String beginning = s.substring(0, cos);
              String end = s.substring(index);
              second = beginning + result + end; 
             
         }
         catch (NumberFormatException exception) { } 
      }
      return second;
   }
   private String checkTan(String s)
   {
      int tan = s.indexOf("tan");
      String second = s;
      if (tan!= -1)
      {
         try {
              int index = findClosingParen(s, tan+4);
              int after = tan + 4;
              String first = s.substring(after, index-1);
              String two = computeEquation(first);
              double number = Double.parseDouble(two);
              double number2 = Math.toRadians(number);  
              String result = Double.toString(Math.tan(number2));
              String beginning = s.substring(0, tan);
              String end = s.substring(index);
              second = beginning + result + end; 
         }
         catch (NumberFormatException exception) { } 
      }
      return second;
   }
   private String checkIn(String s)
   {
      int in = s.indexOf("In");
      String second = s;
      
      if(in>-1)
      {
         boolean found = false;
         int indexA = in;
         int b = in+2;
         
         while(!found && b<s.length())
         {
            String temp = s.substring(b, b+1);
            boolean another = (temp.equals("1") || temp.equals("2") || temp.equals("3") || temp.equals("4") ||
                                 temp.equals("5") || temp.equals("6") || temp.equals("7")   ||
                                 temp.equals("8") || temp.equals("9") || temp.equals("0") || temp.equals("."));
                                 
            boolean blah = temp.equals("(");
                                 
            if(b == s.length()-1)  {   indexA = s.length();    found = true;    }
            else if(!another)
            {    indexA = b;   found = true;    }
            else {   b++; found = false;    }
            
            if(blah) {   indexA = findClosingParen(s, b+1);     found = true;    }     
         }
         String number1 = s.substring(in+2, indexA);
         String result1 = computeEquation(number1);
         double number = Double.parseDouble(result1);
         
         double result = Math.log(number);
         String beginning = s.substring(0, in);
         String end = s.substring(indexA);
         
         second = beginning + result + end;   
      }
      return second; 

    }
    
   private String checkLogTen (String s)
   {
      int logTen = s.indexOf("log10(");
      String second = s;

      if (logTen>-1)
      {
         try {
              int index = findClosingParen(s, logTen+6); 
              int after = logTen + 6;
              String first = s.substring(after, index-1);                // the string of the stuff inside the parathesis
              String two = computeEquation(first);
              double number = Double.parseDouble(two);   // converting it to a number
              String result = Double.toString(Math.log10(number));   // here's where the math comes in
              String beginning = s.substring(0, logTen);  
              String end = s.substring(index);
              second = beginning + result + end; 
            
         }
         catch (NumberFormatException exception) { } 
      }
      
      return second;   
   }


   private String checkSqrt(String s)
   {      
      int sqrt = s.indexOf("√");
      String second = s;
      
      if(sqrt>-1)
      {
         boolean found = false;
         int indexA = sqrt;
         int b = sqrt+1;
         
         while(!found && b<s.length())
         {
            String temp = s.substring(b, b+1);
            boolean another = (temp.equals("1") || temp.equals("2") || temp.equals("3") || temp.equals("4") ||
                                 temp.equals("5") || temp.equals("6") || temp.equals("7")   ||
                                 temp.equals("8") || temp.equals("9") || temp.equals("0") ||  temp.equals(".") );
                                 
            boolean blah = temp.equals("(");
                                 
            if(b == s.length()-1)  {   indexA = s.length();    found = true;    }
            else if(!another)
            {    indexA = b;   found = true;    }
            else {   b++; found = false;    }
            
            if(blah) {   indexA = findClosingParen(s, b+1);     found = true;    }     
         }
         
         String number1 = s.substring(sqrt+1, indexA);
         String result1 = computeEquation(number1);
         double number = Double.parseDouble(result1);
         
         double result = Math.sqrt(number);
         String beginning = s.substring(0, sqrt);
         String end = s.substring(indexA);
         
         second = beginning + result + end;   
      }
      return second; 
   }
   private String checkCbrt(String s)
   {
      int cbrt = s.indexOf("3√");
      String second = s;
      
      if(cbrt>-1)
      {
         boolean found = false;
         int indexA = cbrt;
         int b = cbrt+2;
         
         while(!found && b<s.length())
         {
            String temp = s.substring(b, b+1);
            boolean another = (temp.equals("1") || temp.equals("2") || temp.equals("3") || temp.equals("4") ||
                                 temp.equals("5") || temp.equals("6") || temp.equals("7")   ||
                                 temp.equals("8") || temp.equals("9") || temp.equals("0") || temp.equals(".") );
                                 
            boolean blah = temp.equals("(");
                                 
            if(b == s.length()-1)  {   indexA = s.length();    found = true;    }
            else if(!another)
            {    indexA = b;   found = true;    }
            else {   b++; found = false;    }
            
            if(blah) {   indexA = findClosingParen(s, b+1);     found = true;    }     
         }
         String number1 = s.substring(cbrt+2, indexA);
         String result1 = computeEquation(number1);
         double number = Double.parseDouble(result1);
         
         double result = Math.cbrt(number);
         String beginning = s.substring(0, cbrt);
         String end = s.substring(indexA);
         
         second = beginning + result + end;   
      }
      return second; 

    } 
    private String checkSquare(String s)  
    {
      int square = s.indexOf("²");
      String second = s;
            
      if(square>-1)
      {
         boolean found = false;
         int a = square-1;
         int indexB = square;
         
         while(!found && a>-1)
         {
            String temp = s.substring(a, a+1);
            boolean another = (temp.equals("1") || temp.equals("2") || temp.equals("3") || temp.equals("4") ||
                                 temp.equals("5") || temp.equals("6") || temp.equals("7")   ||
                                 temp.equals("8") || temp.equals("9") || temp.equals("0") || temp.equals("."));
                                 
            boolean blah = temp.equals(")");
            if(blah)  { indexB =  findOpeningParen(s, a);   found = true;  }                     
            else if(a == 0)   {   indexB = a;   found = true;    }
            else if(!another)
            {   indexB = a+1;  found = true;  }
            else {   a--; found = false;  }
         }
                  
         String number = s.substring(indexB, square);
         double base = Double.parseDouble(computeEquation(number));
         
         double result = Math.pow(base, 2);
         String beginning = s.substring(0, indexB);
         String end = s.substring(square+1);
         
         second = beginning + result + end;   
      }
      return second;
    }

    private String checkExponent(String s)  
    {
      int exp = s.indexOf("^");
      String second = s;
      
      if(exp>-1)
      {
         boolean found = false;
         int a = exp-1;
         int indexB = exp;
         int indexA = exp;
         int b = exp+1;
         
         while(!found && a>-1)
         {
            String temp = s.substring(a, a+1);
            boolean another = (temp.equals("1") || temp.equals("2") || temp.equals("3") || temp.equals("4") ||
                                 temp.equals("5") || temp.equals("6") || temp.equals("7")   ||
                                 temp.equals("8") || temp.equals("9") || temp.equals("0") || temp.equals("."));
                                 
            if(a == 0)   {   indexB = a;   found = true;    }
            else if(!another)
            {   indexB = a+1;  found = true;  }
            else {   a--; found = false;  }
         }
         
         found = false;
         
         while(!found && b<s.length()) 
         {
            String temp = s.substring(b, b+1);
            boolean another = (temp.equals("1") || temp.equals("2") || temp.equals("3") || temp.equals("4") ||
                                 temp.equals("5") || temp.equals("6") || temp.equals("7")   ||
                                 temp.equals("8") || temp.equals("9") || temp.equals("0") || temp.equals("."));
                                 
            if(b == s.length()-1)  {   indexA = s.length();    found = true;    }
            if(!another)
            {    indexA = b;   found = true;    }
            else {   b++; found = false;    }
         }
         
         double base = Double.parseDouble(s.substring(indexB, exp));
         double expo = Double.parseDouble(s.substring(exp+1, indexA));
         
         double result = Math.pow(base, expo);
         String beginning = s.substring(0, indexB);
         String end = s.substring(indexA);
         
         second = beginning + result + end;   
      }
      return second;
    }
    private int findClosingParen(String s, int openPos)  // slightly modified from https://stackoverflow.com/questions/12752225/how-do-i-find-the-position-of-matching-parentheses-or-braces-in-a-given-piece-of
    {
      int closePos = openPos;
      int counter = 1;
      int a = openPos;
      int b = a+1;
      int length = s.length();
    
    while (counter > 0 && a < length) {
        String sec = s.substring(a, b);
        if (sec.equals("(")) {
            counter++;
        }
        else if (sec.equals(")")) {
            counter--;
        }
        
    a++;
    b++;
    }
     
    if (counter == 0)
    {  closePos = a;  }
    return closePos;
   }
   
   private int findOpeningParen(String s, int closePos)  // slightly modified from https://stackoverflow.com/questions/12752225/how-do-i-find-the-position-of-matching-parentheses-or-braces-in-a-given-piece-of
   {
    int openPos = closePos;
    int counter = 1;
    int a = closePos - 1;

    while (counter > 0 && a>-1)
    {
      int b = a+1;
        String sec = s.substring(a, a+1);
        if (sec.equals("("))   {     counter--;     }
        
        else if (sec.equals(")")) {    counter++;  }
            
        if(a==0)   {   openPos = 0;   }        
        a--;
        }
    return openPos;

   }
      
    private void resetList()
    {
      lm.remove(0);
      list.revalidate();
      list.repaint();
    }


}
