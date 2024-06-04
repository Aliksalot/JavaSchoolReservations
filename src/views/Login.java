package views;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import models.Account;
import utils.IGlobalMethods;

public class Login extends JPanel {
  
  public Login(MainScreen app){
    JPanel content = new JPanel();
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

    JLabel l0 = new JLabel("Login to your account");
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

    JButton b1 = new JButton("Login");
    b1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        var username = ta1.getText();
        var password = ta2.getPassword();
        
        var user = new Account(username);

        var loginResult = user.comparePasswords(new String(password));
        if(loginResult){
          app.setLoggedInUser(username);
          app.navigate("home");
        }else{
          ta2.setText("");
        }
        
      }
    });
    b1.setAlignmentX(Component.CENTER_ALIGNMENT);

    content.add(l0);

    form.add(l1);
    form.add(ta1);
    form.add(l2);
    form.add(ta2);
    form.add(b1);
    
    content.add(form);
    add(content);
  }
}
