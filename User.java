import java.util.ArrayList;

public class User{
	public int userX = 2;
	public int userY = 2;
	public int userMoney;
	public ArrayList<String> inventory = new ArrayList<String>();

	//add item
	public void add(String item){
		inventory.add(item);
	}//add item

	//does have item
	public boolean doesHave(String item){
		for (int i = 0; i < inventory.size(); i++){
			if (inventory.get(i).equalsIgnoreCase(item) == true){
				return true;
			}
		}
		return false;
	}// does have item

	// use item
	public boolean use(String item){
		for (int i = 0; i < inventory.size(); i++){
			if (inventory.get(i).equalsIgnoreCase(item) == true){
				inventory.remove(i);
				return true;
			}
		}
		return false;
	}//use item
	
}