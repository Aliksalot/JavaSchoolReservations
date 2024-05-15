package views;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import enums.*;
import reservations.Main;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class CompleteReservationGUI extends JFrame{
	
	public RoomType type;
	public ArrayList<RoomExtras> extras = new ArrayList<>();
	public int nightCount;
	
	private JLabel result = new JLabel();
	
	protected void setNightCount(int count) {
		this.nightCount = count;
	}
	
	protected void setRoomType(RoomType type) {
		this.type = type;
	}
	
	protected void addExtra(RoomExtras extra) {
		this.extras.add(extra);
	}
	
	protected void removeExtra(RoomExtras extra) {
		this.extras.remove(extra);
	}
	
	protected void calcPriceAndDisplay() {
		var totalPrice = Main.calcPrice();
		if(totalPrice != -1) {
			this.result.setText("Цена: " + totalPrice);
			return;
		}
		
		this.result.setText("Невалидни параметри");
	}
	
	public CompleteReservationGUI() {
		getContentPane().setLayout(null);
		
		ButtonGroup roomTypeButtonGroup = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Двойна - 75");
		rdbtnNewRadioButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setRoomType(RoomType.DOUBLE);
			}
			
		});
		rdbtnNewRadioButton.setBounds(0, 38, 136, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Единична -  50");
		rdbtnNewRadioButton_1.setBounds(0, 64, 136, 23);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setRoomType(RoomType.SINGLE);
			}
			
		});
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Апартамент - 100");
		rdbtnNewRadioButton_2.setBounds(0, 90, 136, 23);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setRoomType(RoomType.APARTMENT);
			}
			
		});
		getContentPane().add(rdbtnNewRadioButton_2);
		
		roomTypeButtonGroup.add(rdbtnNewRadioButton_2);
		roomTypeButtonGroup.add(rdbtnNewRadioButton);
		roomTypeButtonGroup.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel = new JLabel("Вид стая");
		lblNewLabel.setBounds(30, 11, 46, 14);
		getContentPane().add(lblNewLabel);
		
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
		getContentPane().add(chckbxNewCheckBox);
		
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
		getContentPane().add(chckbxNewCheckBox_1);
		
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
		getContentPane().add(chckbxNewCheckBox_2);
		
		ButtonGroup nightCountButtonGroup = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("3");
		rdbtnNewRadioButton_3.setBounds(265, 38, 109, 23);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setNightCount(3);
			}
			
		});
		getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("5");
		rdbtnNewRadioButton_4.setBounds(265, 64, 109, 23);
		rdbtnNewRadioButton_4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setNightCount(5);
			}
			
		});
		getContentPane().add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("7");
		rdbtnNewRadioButton_5.setBounds(265, 90, 109, 23);
		rdbtnNewRadioButton_5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setNightCount(7);
			}
			
		});
		getContentPane().add(rdbtnNewRadioButton_5);
		
		nightCountButtonGroup.add(rdbtnNewRadioButton_3);
		nightCountButtonGroup.add(rdbtnNewRadioButton_4);
		nightCountButtonGroup.add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Екстри");
		lblNewLabel_1.setBounds(165, 11, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Брой нощувки");
		lblNewLabel_2.setBounds(290, 11, 109, 14);
		getContentPane().add(lblNewLabel_2);
		
		result.setBounds(101, 176, 178, 14);
		getContentPane().add(result);
		
		JButton btnNewButton = new JButton("Пресметни цена");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calcPriceAndDisplay();
			}
		});
		btnNewButton.setBounds(101, 142, 178, 23);
		getContentPane().add(btnNewButton);
		
		this.setVisible(true);
		this.setBounds(0, 0, 800, 800);
	}

}
