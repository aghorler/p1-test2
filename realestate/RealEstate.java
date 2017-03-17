package realestate;

import java.util.Scanner;

public class RealEstate {
	
	private House[] properties;
	/*private House houseForAuction; I don't know what to do with this. */
	private int propCount = 0;
	
	public RealEstate(){
		properties = new House[20];
	}
	
	public void runAction(){
		boolean flag = true;
		
		while(flag){
			System.out.println("1. Add properites\n" +
								"2. Display properties\n" +
								"3. Place property on auction\n" +
								"4. Place a bid\n" +
								"5. Display current state\n" +
								"6. Quit");	
			
			Scanner input = new Scanner(System.in);
			int choice = 0;
		
			System.out.println("Enter your choice (1 - 6): ");
			choice = input.nextInt();
			
			switch(choice){
			case 1:
				addProperties();
				break;
			case 2:
				listProperties();
				break;
			case 3:
				putHouseOnAuction();
				break;
			case 4:
				placeBid();
				break;
			case 5:
				//houseForAuction is unclear
				displaySold();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Incorrect input. Please enter a number between 1 and 6.");
			}
		}
	}
	
	private void addProperties(){
		boolean continueEnter = true;
		
		while(continueEnter){
			Scanner houseInput = new Scanner(System.in);
			System.out.println("Enter type: ");
			System.out.println(" (Enter stop to terminate.)");
			String type = houseInput.nextLine();
			
			//exit loop if user enters keyword
			if(type.equals("stop")){
				continueEnter = false;
				break;
			}
		
			System.out.println("Bedrooms: ");
			int bedrooms = houseInput.nextInt();
		
			House h = new House(type, bedrooms);
		
			properties[propCount] = h;
			propCount++;
		}
	}
	
	//prints using toString
	private void listProperties(){
		for(int i = 0; i < propCount; i++){
			System.out.println(properties[i]);
		}
	}
	
	private void putHouseOnAuction(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ID: ");
		int id = input.nextInt();
		
		for(int i = 0; i < propCount; i++){
			if(id == properties[i].getID() && properties[i].getIsSold() == false){
				System.out.println("Enter reserve: ");
				double reservePrice = input.nextDouble();
				
				System.out.println("Enter start price: ");
				double price = input.nextDouble();
				
				properties[i].setReservePrice(reservePrice);
				properties[i].setPrice(price); //this is the starting price for bidding
			}
			else{
				System.out.println("Invalid property selected. ");
			}
		}
	}
	
	private void placeBid(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ID: ");
		int id = input.nextInt();
		
		for(int i = 0;i < propCount; i++){
			if(id == properties[i].getID() && properties[i].getIsSold() == false){
				
				while(properties[i].getPrice() <= properties[i].getReservePrice()){
					System.out.println("Current price: " + properties[i].getPrice());
					System.out.println("Enter a bid (incremental): ");
					double bid = input.nextDouble();
					//bidding is incremented by adding bid to price, which is highly abnormal. But okay.
					properties[i].setPrice(properties[i].getPrice() + bid);
				}
				
				System.out.println("Property sold for " + properties[i].getPrice() + "!");
				properties[i].setIsSold(true);
			}
		}
	}
	
	private void displaySold(){
		System.out.println("Sold properties: ");
		for(int i = 0; i < propCount; i++){
			if(properties[i].getIsSold() == true){
				System.out.println(properties[i]);
			}
		}
	}
	
}
