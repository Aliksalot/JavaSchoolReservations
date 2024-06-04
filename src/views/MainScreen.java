package views;

import reservations.Main;
import utils.IGlobalMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements IGlobalMethods{

  private CardLayout cardLayout;
  private JPanel cardPanel;
  private HomePage homePanel;

  private String loggedInUser;

  public void navigate(String to){
    cardLayout.show(cardPanel, to);
  }

  @Override
  public void setLoggedInUser(String username){
    this.loggedInUser = username;
    if(homePanel != null && username != ""){
      homePanel.showReserveButton();
    }
  }

  public MainScreen(){
    setTitle("Hotel app");
    setResizable(false);
    setSize(400, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    cardLayout = new CardLayout();
    cardPanel = new JPanel(cardLayout);

    JPanel loginPanel = new Login(this);
    JPanel registerPanel = new Register(cardLayout, cardPanel);
    JPanel reservationPanel = new CompleteReservationGUI(this);
    homePanel = new HomePage(cardLayout, cardPanel);
    JPanel infoPanel = new InfoPage(cardLayout, cardPanel);

    cardPanel.add(homePanel, "home");
    cardPanel.add(loginPanel, "login");
    cardPanel.add(registerPanel, "register");
    cardPanel.add(infoPanel, "info");
    cardPanel.add(reservationPanel, "reserve");

    cardLayout.show(cardPanel, "home");
    add(cardPanel);

    var homeButton = new JButton("Home");
    homeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        cardLayout.show(cardPanel, "home");
      }
    });

    var menubar = new JMenuBar();

    menubar.add(homeButton);

    setJMenuBar(menubar);
    setVisible(true);
  }
}
