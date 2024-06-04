package views;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPage extends JPanel{
  public InfoPage(CardLayout cl, JPanel cp){
    JPanel content = new JPanel();
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

    JLabel label = new JLabel("This is a info page :P");
    JButton button = new JButton("Back to home");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        cl.show(cp, "home");
      }
    });

    content.add(label);
    content.add(button);

    add(content);
  }
}
