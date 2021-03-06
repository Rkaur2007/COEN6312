import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;

public class Flight {
	
	private String flightID;
	private String startTime;
	private String arrivalTime;
	private String source;
	private String destination;
	private String departureDate;
	private int seatCapacity;
	private int price;
	private int filled;
	 
	private ArrayList<Seat> seats = new ArrayList<Seat>();
	private ArrayList<Traveller> travellers = new ArrayList<Traveller>();
	
	public enum Status {UNPUBLISHED, AVAILABLE}
	private Status flightStatus;
	private void makeseat(int n) {
		 
	}
	
	
	public Flight() {}
	
	public Flight(String flightID_, String startTime_, String arrivalTime_, String source_, String destination_, 
			      String departureDate_, int seatCapacity_, int price_, int filled_) {
		flightID = flightID_;
		startTime = startTime_;
		arrivalTime = arrivalTime_;
		source = source_;
		destination = destination_;
		departureDate = departureDate_;
		seatCapacity = seatCapacity_;
		price = price_;
		filled = filled_;
		flightStatus = Status.UNPUBLISHED;
		
		for (int i=1; i <= seatCapacity/6; i++) {
			for (int j=1; j<7; j++) {
				String s = j + "";
				Seat seat = new Seat((char)(65+i),s);
				seats.add(seat);
			}
		}
		
		 
		
	}
	public String getFlightID() {
		return flightID;
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFilled() {
		return filled;
	}
	public void setFilled(int filled) {
		this.filled = filled;
	}
	public Status getFlightStatus() {
		return flightStatus;  
	}
	public void setFlightStatus(Status flightStatus) {
		this.flightStatus = flightStatus;
	}
	public int getseatCapacity() {
		return seatCapacity;
	}
	public void setseatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
}
