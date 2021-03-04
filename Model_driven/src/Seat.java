
public class Seat {
	private String seatNumber = "";
	private boolean ifBooked = false;
	
	public Seat(char s1, String s2) {
		seatNumber = s1+ s2;
		ifBooked = false;
	}
	
	public String getSeatNumber() {
		return seatNumber;
	}
	
	public void setSeatNumber(String s) {
		seatNumber = s;
	}
	
	public boolean getIfBooked() {
		return ifBooked;
	}
	
	public void setIfBooked(boolean b) {
		ifBooked = b;
	}

} 
 