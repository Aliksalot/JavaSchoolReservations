package reservations;
import java.util.ArrayList;
import java.util.HashMap;
import enums.*;
import views.CompleteReservationGUI;
import views.MainScreen;

public class Main {
	
	private static CompleteReservationGUI gui;
	
	private static final HashMap<RoomType, Integer> typePriceMap = new HashMap<>() {{
		put(RoomType.SINGLE, 50);
		put(RoomType.DOUBLE, 75);
		put(RoomType.APARTMENT, 100);
	}};
	
	private static final HashMap<RoomExtras, Integer> extraPriceMap = new HashMap<>() {{
		put(RoomExtras.BATH, 30);
		put(RoomExtras.SAUNA, 100);
		put(RoomExtras.TERRASE, 20);
	}};
	
	public static int calcPrice(int nightCount, ArrayList<RoomExtras> extras, RoomType type) {
		if(nightCount == 0 || extras == null || type == null)
			return -1;
		var totalPrice = nightCount * typePriceMap.get(type);
		for(var extra: extras) {
			totalPrice += extraPriceMap.get(extra);
		}
		return totalPrice;
	}
	
	
	public static void main(String[] args) {
		new MainScreen();
	}
}
