package views;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JPanel{

  private JButton b4;

  public void showReserveButton(){
    if(b4 != null){
      b4.setVisible(true);
    }
  }
  
  public HomePage(CardLayout layout, JPanel panel){
    
    JPanel content = new JPanel();
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    JLabel l1 = new JLabel("Welcome to my application");
    l1.setAlignmentX(Component.CENTER_ALIGNMENT);
    content.add(l1);
    JPanel buttonContainer = new JPanel();
    JButton b1 = new JButton("Login");
    b1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        layout.show(panel, "login");
      }
    });
    JButton b2 = new JButton("Register");
    b2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        layout.show(panel, "register");
      }
    });
    JButton b3 = new JButton("Info");
    b3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        layout.show(panel, "info");
      }
    });
    b4 = new JButton("Create reservation");
    b4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        layout.show(panel, "reserve");
      }
    });
    b4.setVisible(false);

    buttonContainer.add(b1);
    buttonContainer.add(b2);
    buttonContainer.add(b3);
    buttonContainer.add(b4);
    
    content.add(buttonContainer);
    add(content);
  }
}
