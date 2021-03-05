import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Booking {

	
	public Booking(String name, String flightID, String card) throws IOException {
		String path = "orders.csv";
		FileWriter fw = new FileWriter(path, true);
		BufferedWriter br = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(br);
				
		pw.println(name+","+flightID+ "," +card);
		pw.flush();
		pw.close();
		System.out.println("Congratulations, you have made the booking!");
	}
	
	
}
