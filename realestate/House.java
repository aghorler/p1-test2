package realestate;

public class House {
	
	private int bedrooms;
	private String type;
	private double reservePrice;
	private double price = 0;
	private boolean isSold;
	private int id;
	private static int nextID = 0;
	
	public House(){
	}
	
	public House(String type, int bedrooms){
		this.type = type;
		this.bedrooms = bedrooms;
		id = nextID++;
	}
	
	//getMethods
	public int getBedrooms(){
		return bedrooms;
	}
	
	public String getType(){
		return type;
	}
	
	public double getReservePrice(){
		return reservePrice;
	}
	
	public double getPrice(){
		return price;
	}
	
	public boolean getIsSold(){
		return isSold;
	}
	
	public int getID(){
		return id;
	}
	
	//setMethods
	public void setBedrooms(int bedrooms){
		this.bedrooms = bedrooms;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void setReservePrice(double reservePrice){
		this.reservePrice = reservePrice;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setIsSold(boolean isSold){
		this.isSold = isSold;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public String toString(){
		return "ID: " + id + "\n Type: " + type + "\n Bedrooms: " + bedrooms;
	}

}
