import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.GregorianCalendar;

public class Traveller {
//	public ArrayList<Booking> orders = New ArrayList<Booking>();
	Flight flight = new Flight("","","","","","",0,0,0);
	Date createDate = new Date();
	
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
	
	public static void signUp(String filepath) throws IOException {
		String path = filepath;
		FileWriter fw = new FileWriter(path, true);
		BufferedWriter br = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(br);
		
		Scanner i = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = i.next();
		
		System.out.println("Enter your password");
		String password = i.next();
		
		int travellerID = (int)(Math.random()*90000 + 100000);
		
		
		Traveller t = new Traveller(travellerID, name, password);
		
		pw.println(name+","+password);
		pw.flush();
		pw.close();
		
		
		System.out.println("Congratulations, you have signed up as a passenger!");
		System.out.printf("Your ID is %d \n", travellerID);
		
	}
	
	public String signIn(String filepath) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your username");
		String searchName = sc.next();
		
		System.out.println("Enter your password");
		String searchPassword = sc.next();
		
		String resultRow = "Wrong ID or password!";
		BufferedReader br = new BufferedReader(new FileReader("people.csv"));
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
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the source"); 
//		String source = sc.next();
//		System.out.println("Enter the destination");
//		String destination = sc.next();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while((line = br.readLine())!=null) {
			String[] values = line.split(",");
			if(values[0]!=null) {
				resultRow = line;
				records.add(resultRow);
				
				
			}
//		
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
			if((values[0].contentEquals(source))&&(values[1].contentEquals(destination))) {
				resultRow = line;
				records.add(resultRow);
				
				
			}
//		
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
		Scanner in = new Scanner(System.in);
		String[] data = new String[100];
		Run.Timeout();
		Run.Timeout();
		showMenu();
		opt = in.nextInt();
		do {
			switch (opt) {
	                case 0: continue;
	      			case 1:	data = queryByInfo("places.csv");
	      					System.out.println(data.length);
	      					for(int i=0;i<data.length;i++) {
	      						System.out.println(data[i]);
	      					}
	      					
	    					break;
	       			case 2: continue;
	       					
	       			case 3: continue;
	       					
					case 4: continue;
							
			default : System.out.println("No such command");
		}
		Run.Timeout();    
	    showMenu();
	    opt = in.nextInt();
	    }while (opt != 0);
	}
		
}
	
	


