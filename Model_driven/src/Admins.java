import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Admins {
	String userName = " ";
	String password = " ";
	
	Flight f = new Flight();
	
	
	public Admins() {}
	
	public static void signUp(String filepath) throws IOException{
		String path = filepath;
		FileWriter fw = new FileWriter(path, true);
		BufferedWriter br = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(br);
		
		Scanner i = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = i.next();
		
		System.out.println("Enter your password");
		String password = i.next();
		
		
		pw.println(name+","+password);
		pw.flush();
		pw.close();
		
		
		System.out.println("Congratulations, you have signed up as an admin!");
	}
	
	public String signIn(String filepath) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your username");
		String searchName = sc.next();
		
		System.out.println("Enter your password");
		String searchPassword = sc.next();
		
		String resultRow = "Wrong ID or password!";
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line;
		while((line = br.readLine())!=null) {
			String[] values = line.split(",");
			if((values[0].contentEquals(searchName))&&(values[1].contentEquals(searchPassword))) {
				System.out.println("Thats the correct username and password!!!");
				action();
				break;
				
			}
	
		}
		br.close();
		return resultRow;
	}
	
	public static void action() throws IOException {
		Scanner sc = new Scanner(System.in);
		int value = 0;
		boolean GetCommand = false;
		Admins a = new Admins();

		
		while(!GetCommand) {
			Run.Timeout();
			showMenu();
			value = sc.nextInt();
			if(value>6) {
				System.out.println("No such option!");
			}
			else GetCommand = true;
		}
		
		do {
			switch(value) {
			case 0 : continue;
			case 1 : Run.Timeout();
					 a.createFlight();
					 break;
			case 2: continue;
			case 3: continue;
			case 4: Run.Timeout();
					a.publishFlight("publishedFlights.csv");
					break;
			default: break;
			}
			showMenu();
			value = sc.nextInt();
		}while(value!=0);
	}
	
    private static void showMenu() {
        System.out.printf("\nWelcome to the admin menu!!\n%s%s%s%s%s",
                          "0:Exit\n",
                          "1:creat flight\n",
                          "2:update flight\n",
                          "3:delete flight\n",
                          "4:publish flights\n");
    }
    
    public void createFlight() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Please input FlightID:");
        String flightID = sc.next();
        f.setFlightID(flightID);
        
        System.out.println("Please input start time:");
        String startTime = sc.next();
        f.setStartTime(startTime);
        
        System.out.println("Please input arrival time:");
        String arrivalTime = sc.next();
        f.setArrivalTime(arrivalTime);
        
        System.out.println("Please input the source:");
        String source = sc.next();
        f.setSource(source);
        
        System.out.println("Please input the destination:");
        String destination = sc.next();
        f.setDestination(destination);
        
        System.out.println("Please input departure date:");
        String departureDate = sc.next();
        f.setDepartureDate(departureDate);
        
        System.out.println("Please input price:");
        int price = sc.nextInt();
        f.setPrice(price);
        
        System.out.println("Please input seat capacity:");
        int seatCapacity = sc.nextInt();
        f.setseatCapacity(seatCapacity);
        
        System.out.println("Enter the number of booked seats");
        int filled = sc.nextInt();
        f.setFilled(filled);
        
        Flight f1 = new Flight(flightID, startTime, arrivalTime, source, destination, departureDate, price, seatCapacity, filled);
        
    }
    
    private void publishFlight(String filepath) throws IOException {
		String path = filepath;
		FileWriter fw = new FileWriter(path, true);
		BufferedWriter br = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(br);
		
		String ID = f.getFlightID();
		String start = f.getStartTime();
		String arrival = f.getArrivalTime();
		String source = f.getSource();
		String destination = f.getDestination();
		String date = f.getDepartureDate();
		int capacity = f.getseatCapacity();
		int price = f.getPrice();
		int filled = f.getFilled();
		
		pw.println(ID+ "," +start+"," +arrival+ "," +source+ "," +destination+ "," +date+ "," +capacity+ "," +price+ "," +filled);
		pw.flush();
		pw.close();
		
		System.out.println("Congratulations, you have published the flight" );

    }
}
