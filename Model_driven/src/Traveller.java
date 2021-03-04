import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.GregorianCalendar;

public class Traveller {
//	public ArrayList<Booking> orders = New ArrayList<Booking>();
//	Flight flight = new Flight("","","","","","",0,0,0);
	Flight f = new Flight();
	Date createDate = new Date();
	public static String TravellerName;
	public static int TravellerID;
	
	int travellerID = 0;
	String name = " ";
	String password = " ";
	boolean ifSignIn = false;
	String seat;
	
	
	public Traveller() {
		
	}
	

	
	public Traveller(int travellerID, String name, String password) {
		this.travellerID = travellerID;
		this.name = name;
		this.password = password; 
	}

	public int getTravellerID() {
		return travellerID;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public boolean getIfSignIn() {
		return ifSignIn;
	}
	
	public void setIfSignIn(boolean b) {
	ifSignIn = b;
	}
	
	public void setTravellerID(int travellerID) {
		this.travellerID = travellerID;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public  void signUp(String filepath) throws IOException {
		String path = filepath;
		FileWriter fw = new FileWriter(path, true);
		BufferedWriter br = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(br);
		
		Scanner i = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = i.next();

//		traveller.setName(name);
		
		System.out.println("Enter your password");
		String password = i.next();
		
		int travellerID = (int)(Math.random()*90000 + 100000);
//		traveller.setTravellerID(travellerID);
//		t.setTravellerID(travellerID);
//		TravellerID = t.getTravellerID();
		

		
		pw.println(name+","+password);
		pw.flush();
		pw.close();
		
		
		System.out.println("Congratulations, you have signed up as a passenger!");
		System.out.printf("Your ID is %d \n", travellerID);
		
	}
	


	public String signIn(String filepath) throws IOException{
		Scanner sc = new Scanner(System.in);
		Traveller t = new Traveller();

		
		System.out.println("Enter your username");
		String searchName = sc.next();
		t.setName(searchName);
		TravellerName = t.getName();
//		System.out.println(TravellerName);
		
		System.out.println("Enter your password");
		String searchPassword = sc.next();
		
		String resultRow = "Wrong ID or password!";
		BufferedReader br = new BufferedReader(new FileReader("people.csv"));
		String line;
		while((line = br.readLine())!=null) {
			String[] values = line.split(",");
			if((values[0].contentEquals(TravellerName))&&(values[1].contentEquals(searchPassword))) {
				System.out.println("Thats the correct username and password!!!");
				action();
				break;
				
			}
	
		}
		br.close();
		return resultRow;
	}
	
	public void queryOrders(String filepath) {
		//add verification
		String path = filepath;
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while((line = br.readLine())!=null) {
				String values[] = line.split(",");
				System.out.println(values);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
			
	}
	
	public static String[] queryAllFlights(String filepath) throws IOException {
		String path = filepath;
		ArrayList<String> records = new ArrayList<String>();
		String resultRow = "No flights!";
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while((line = br.readLine())!=null) {
			String[] values = line.split(",");
			if(values[0]!=null) {
				resultRow = line;
				records.add(resultRow);
				
				
			}
		
		}
		br.close();
		String[] recordsArray = new String[records.size()];
		records.toArray(recordsArray);
		return recordsArray;
		
	}
	
	public static String[] queryByInfo(String filepath) throws IOException {
		String path = filepath;
		ArrayList<String> records = new ArrayList<String>();
		String resultRow = "No such flight!";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the source"); 
		String source = sc.next();
		System.out.println("Enter the destination");
		String destination = sc.next();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while((line = br.readLine())!=null) {
			String[] values = line.split(",");
			if((values[3].contentEquals(source))&&(values[4].contentEquals(destination))) {
				resultRow = line;
				records.add(resultRow);
				
				
			}
		
		}
		br.close();
		String[] recordsArray = new String[records.size()];
		records.toArray(recordsArray);
		return recordsArray;
	}
	

	private static void showMenu() {
	   	System.out.printf("\nWelcome to the customer menu!!\n%s%s%s%s%s",
	                 			"0:Exit\n",
	    			  			"1:query the flight\n",
	    			  			"2:reserve the flight\n",
	    			  			"3:unsubscribe the flight\n",
								"4:query my orders");  
	} 	  
	public static void action() throws IOException {      	  
	    int opt = 0;
	    Traveller t = new Traveller();
		Scanner in = new Scanner(System.in);
		String[] data = new String[100];
		Run.Timeout();
		Run.Timeout();
		showMenu();
		opt = in.nextInt();
		do {
			switch (opt) {
	                case 0: continue;
	      			case 1:	data = queryByInfo("publishedFlights.csv");
	      					System.out.println(data.length);
	      					for(int i=0;i<data.length;i++) {
	      						System.out.println(data[i]);
	      					}
	    					break;
	       			case 2: t.makeBooking();
	       					break;
	       					
	       			case 3: t.cancelBooking("orders.csv", TravellerName);
	       					break;
	       					
					case 4: data = t.viewMyOrders("orders.csv");
							for(int i=0;i<data.length;i++) {
		  						System.out.println(data[i]);
		  					}
							break;
							
							
			default : System.out.println("No such command");
		}
		Run.Timeout();    
	    showMenu();
	    opt = in.nextInt();
	    }while (opt != 0);
	}
	
	public void makeBooking() throws IOException{
		Scanner sc = new Scanner(System.in);
		String cardDetail;
		System.out.println("Are you sure you want to make a booking?");
		char response = sc.next().charAt(0);
		if (response == 'y') {
//			System.out.println("Enter your name\n");
//			String name = traveller.getName();

			System.out.println("Enter the ID of the flight you want to book:\n");
			String ID = sc.next();
			f.setFlightID(ID);
			
			System.out.println("Please enter your card number");
			String number = sc.next();
			System.out.println("Do you want to save your card details?");
			char save = sc.next().charAt(0);
			if(save == 'y') {
				cardDetail = number;
			}else {
				cardDetail = "N/A";
			}
			
			Booking booking = new Booking(TravellerName, f.getFlightID(),cardDetail);
			
		}
	}
	
	public String[] viewMyOrders(String filepath) throws IOException {
		String path = filepath;
		ArrayList<String> records = new ArrayList<String>();
		String resultRow = "No orders so far!";
//		name = traveller.getName();
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while((line = br.readLine())!=null) {
			String[] values = line.split(",");
			if((values[0].contentEquals(TravellerName))) {
				resultRow = line;
				records.add(resultRow);
				
			}
		
		}
		br.close();
		String[] recordsArray = new String[records.size()];
		records.toArray(recordsArray);
		return recordsArray;
	}
	
	public void cancelBooking(String filepath, String name) {
	   	int positionOfTerm = 2;
			int positionID = positionOfTerm - 1;
			int positionName = positionOfTerm -2;
			Scanner sc = new Scanner(System.in);
			String tempFile = "temp.csv";
			File oldFile = new File(filepath);
			File newFile = new File(tempFile);
			
			String currentLine;
			String data[];
			
			System.out.println("Enter the ID of the flight you want to cancel");
			String removeTerm = sc.next();
			
			try {
				FileWriter filewrite = new FileWriter(tempFile,true);
				BufferedWriter buffwrite = new BufferedWriter(filewrite);
				PrintWriter printwrite = new PrintWriter(buffwrite);
				
				FileReader fr = new FileReader(filepath);
				BufferedReader br = new BufferedReader(fr);
				
				while((currentLine = br.readLine()) != null) {
					data = currentLine.split(",");
					if(!((data[positionName].equalsIgnoreCase(name)&&data[positionID].equalsIgnoreCase(removeTerm)))) {
						printwrite.println(currentLine);
					}
				}
				printwrite.flush();
				printwrite.close();
				fr.close();
				br.close();
				buffwrite.close();
				filewrite.close();
				
				oldFile.delete();
				File dump = new File(filepath);
				newFile.renameTo(dump);
				System.out.println("Your booking has been successfully cancelled!");
			}
			catch(Exception e) {
				 
			}
	}
		
}
	
	


