package views;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import enums.*;
import models.Reservation;
import reservations.Main;
import utils.IGlobalMethods;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class CompleteReservationGUI extends JPanel{
	
	public RoomType type;
	public ArrayList<RoomExtras> extras = new ArrayList<>();
	public int nightCount;
	private int price = -1;
	
	private JLabel result = new JLabel();
	private JPanel buttonsContainer;
	
	protected void setNightCount(int count) {
		this.nightCount = count;
		setSubmitButtonsVisible(false);
	}
	
	protected void setRoomType(RoomType type) {
		this.type = type;
		setSubmitButtonsVisible(false);
	}
	
	protected void addExtra(RoomExtras extra) {
		this.extras.add(extra);
		setSubmitButtonsVisible(false);
	}
	
	protected void removeExtra(RoomExtras extra) {
		this.extras.remove(extra);
	}

	private void setSubmitButtonsVisible(boolean b){
		System.out.println("HELLO BRO");
		if(this.buttonsContainer != null)
			this.buttonsContainer.setVisible(b);
	}
	
	protected void calcPriceAndDisplay() {
		var totalPrice = Main.calcPrice(nightCount, extras, type);
		if(totalPrice != -1) {
			this.price = totalPrice;
			setSubmitButtonsVisible(true);
			this.result.setText("Цена: " + totalPrice);
			return;
		}
		
		this.result.setText("Невалидни параметри");
	}
	
	public CompleteReservationGUI(IGlobalMethods app) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		var form = new JPanel(null);
		
		ButtonGroup roomTypeButtonGroup = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Двойна - 75");
		rdbtnNewRadioButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setRoomType(RoomType.DOUBLE);
			}
			
		});
		rdbtnNewRadioButton.setBounds(0, 38, 136, 23);
		form.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Единична -  50");
		rdbtnNewRadioButton_1.setBounds(0, 64, 136, 23);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setRoomType(RoomType.SINGLE);
			}
			
		});
		form.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Апартамент - 100");
		rdbtnNewRadioButton_2.setBounds(0, 90, 160, 23);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setRoomType(RoomType.APARTMENT);
			}
			
		});
		form.add(rdbtnNewRadioButton_2);
		
		roomTypeButtonGroup.add(rdbtnNewRadioButton_2);
		roomTypeButtonGroup.add(rdbtnNewRadioButton);
		roomTypeButtonGroup.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel = new JLabel("Вид стая");
		lblNewLabel.setBounds(30, 11, 46, 14);
		form.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("С тераса + 20");
		chckbxNewCheckBox.setBounds(138, 38, 125, 23);
		chckbxNewCheckBox .addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(extras.contains(RoomExtras.TERRASE)) {
					removeExtra(RoomExtras.TERRASE);
					return;
				}
				
				addExtra(RoomExtras.TERRASE);
			}
		});
		form.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("С вана + 30");
		chckbxNewCheckBox_1.setBounds(138, 64, 97, 23);
		chckbxNewCheckBox_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(extras.contains(RoomExtras.BATH)) {
					removeExtra(RoomExtras.BATH);
					return;
				}
				
				addExtra(RoomExtras.BATH);
			}
		});
		form.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Със сауна + 100");
		chckbxNewCheckBox_2.setBounds(138, 90, 125, 23);
		chckbxNewCheckBox_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(extras.contains(RoomExtras.SAUNA)) {
					removeExtra(RoomExtras.SAUNA);
					return;
				}
				
				addExtra(RoomExtras.SAUNA);
			}
		});
		form.add(chckbxNewCheckBox_2);
		
		ButtonGroup nightCountButtonGroup = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("3");
		rdbtnNewRadioButton_3.setBounds(265, 38, 109, 23);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setNightCount(3);
			}
			
		});
		form.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("5");
		rdbtnNewRadioButton_4.setBounds(265, 64, 109, 23);
		rdbtnNewRadioButton_4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setNightCount(5);
			}
			
		});
		form.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("7");
		rdbtnNewRadioButton_5.setBounds(265, 90, 109, 23);
		rdbtnNewRadioButton_5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setNightCount(7);
			}
			
		});
		form.add(rdbtnNewRadioButton_5);
		
		nightCountButtonGroup.add(rdbtnNewRadioButton_3);
		nightCountButtonGroup.add(rdbtnNewRadioButton_4);
		nightCountButtonGroup.add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Екстри");
		lblNewLabel_1.setBounds(165, 11, 46, 14);
		form.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Брой нощувки");
		lblNewLabel_2.setBounds(290, 11, 109, 14);
		form.add(lblNewLabel_2);
		
		result.setBounds(101, 176, 178, 14);
		form.add(result);
		
		JButton btnNewButton = new JButton("Пресметни цена");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calcPriceAndDisplay();
			}
		});
		btnNewButton.setBounds(101, 142, 178, 23);
		form.add(btnNewButton);

		add(form);

		buttonsContainer = new JPanel();
		buttonsContainer.setVisible(false);
		buttonsContainer.setLayout(new BoxLayout(buttonsContainer,	BoxLayout.X_AXIS));

		Runnable clearFields = new Runnable() {
			@Override
			public void run() {
				roomTypeButtonGroup.clearSelection();
				nightCountButtonGroup.clearSelection();
				chckbxNewCheckBox.setSelected(false);
				chckbxNewCheckBox_1.setSelected(false);
				chckbxNewCheckBox_2.setSelected(false);
				
				result.setText("");

				type = null;
				extras = new ArrayList<>();
				price = -1;
				nightCount = -1;
				
				setSubmitButtonsVisible(false);
			
			}
		};

		var b1 = new JButton("Create reservation");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				if(price != -1){
					var reservation = new Reservation(price, nightCount, extras, type);
					boolean result = reservation.writeToFile();
					if(result){
						JOptionPane.showMessageDialog(null, "Your reservation has been made", "Reservation status", JOptionPane.INFORMATION_MESSAGE);
						clearFields.run();
						app.navigate("home");
					}else{
						JOptionPane.showMessageDialog(null, "Some error has occured", "Reservation status", JOptionPane.INFORMATION_MESSAGE);
						clearFields.run();
					}
				}
			}
		});
		var b2 = new JButton("Clear fields");

		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				clearFields.run();
			}
		});

		buttonsContainer.add(b1);
		buttonsContainer.add(b2);

		add(buttonsContainer);
		
		this.setVisible(true);
		this.setBounds(0, 0, 800, 800);
	}

}
