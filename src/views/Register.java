package views;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import models.Account;

public class Register extends JPanel {
  public Register(CardLayout cl, JPanel cp){
    JPanel content = new JPanel();
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

    JLabel l0 = new JLabel("Register your account");
    l0.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    JPanel form = new JPanel();
    form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
    form.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel l1 = new JLabel("Enter your username");
    l1.setAlignmentX(Component.RIGHT_ALIGNMENT);
    JTextArea ta1 = new JTextArea();
    JLabel l2 = new JLabel("Enter your password");
    l2.setAlignmentX(Component.RIGHT_ALIGNMENT);
    JPasswordField ta2 = new JPasswordField();
    JLabel l3 = new JLabel("Repeat your password");
    l3.setAlignmentX(Component.RIGHT_ALIGNMENT);
    JPasswordField ta3 = new JPasswordField();

    JPanel buttonContainer = new JPanel();
    buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.X_AXIS));

    JButton b1 = new JButton("Register");
    b1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        var username = ta1.getText();
        var password = ta2.getPassword();
        var password1 = ta3.getPassword();
        if(new String(password).equals(new String(password1))){
          new Account(username, new String(password));
          ta1.setText("");
          ta2.setText("");
          ta3.setText("");
          cl.show(cp, "home");
        }else{
          System.out.println("fail");
          ta3.setText("");
        }
      }
    });
    b1.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton b2 = new JButton("Home");
    b2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        cl.show(cp, "home");
      }
    });
    b2.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    buttonContainer.add(b2);
    buttonContainer.add(b1);

    content.add(l0);

    form.add(l1);
    form.add(ta1);
    form.add(l2);
    form.add(ta2);
    form.add(l3);
    form.add(ta3);
    form.add(buttonContainer);
    
    content.add(form);
    add(content);
  }
}
