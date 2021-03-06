import java.io.IOException;
import java.util.Scanner;
public class Run {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Traveller traveller = new Traveller();
		Admins admin = new Admins();
		boolean commandGet = false;
		Scanner sc = new Scanner(System.in);
		String[] data = new String[100];
		int value = 0;
		showMenu();
		while(!commandGet) {
			value = sc.nextInt();
			if(value>5)
				System.out.println("Enter a valid command");
			else commandGet = true;
		} 
		
		do {
			switch(value) {
			case 0: continue;
			case 1: admin.signUp("admins.csv");
					break;
			case 2: traveller.signUp("people.csv");
					break;
			case 3: admin.signIn("admins.csv");
					break;
			case 4: traveller.signIn("people.csv");
					break;
			case 5: data = traveller.queryAllFlights("publishedFlights.csv");
					System.out.println(data.length);
					for(int i=0;i<data.length;i++) {
						System.out.println(data[i]);
					}
					break;
			default: break;
			}
			Timeout(); 
			showMenu();
			value = sc.nextInt();
		}while(value!=0);
	}

	private static void showMenu() {
        System.out.printf("\nWelcome to book ticket!\n%s%s%s%s%s%s%s",
                "0:Exit\n",
                "1:Sign up as Administrators\n",
                "2:Sign up as Passengers\n",
                "3:Sign in as Administrators\n",
                "4:Sign in as Passengers\n", 
                "5:Query Flight without sign in\n",
				"6:Display all flights\n");
    }
	public static void Timeout() {
		try {
			Thread.currentThread().sleep(900);
		}
		catch(Exception e) {}
		
	}
}
