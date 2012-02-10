package Models;



public class Animal {
	private String n,type;
	private int age,careDays;
	public Animal(String petName,String petType, int petAge, int days){
		n=petName;
		type=petType;
		petAge=age;
		careDays=days;
	}
	
	public String getName() {	
		return n;
	}
	
	public String getType() {
		return type;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getCost(){
		return careDays*100;
	}
	
	public int getCareDays() {
		return careDays;
	}
	
	public void setCareDays(int careDays) {
		this.careDays = careDays;
		
	}
	
	public String toString(){
		return n;
	}
	
	public boolean equals(Object o){
	if(!(o instanceof Animal)){
		return false;
	}
	Animal other=(Animal)o;
	boolean retval=(other.getAge()==age) && (other.getCareDays()==careDays);
	retval=retval&& (other.getName().equals(n)) && (other.getType().equals(type));
	return retval;
	}
	
	 
	
	

}
