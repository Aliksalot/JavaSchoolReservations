package reservations;
import java.util.HashMap;
import enums.*;
import views.CompleteReservationGUI;

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
	
	public static int calcPrice() {
		if(gui.nightCount == 0 || gui.extras == null || gui.type == null)
			return -1;
		var totalPrice = gui.nightCount * typePriceMap.get(gui.type);
		for(var extra: gui.extras) {
			totalPrice += extraPriceMap.get(extra);
		}
		return totalPrice;
	}
	
	
	public static void main(String[] args) {
		gui = new CompleteReservationGUI();
	}
}
