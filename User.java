import java.util.ArrayList;

public class User{
	public int x = 2;
	public int y = 2;
	public int money;
	public ArrayList<String> inventory = new ArrayList<String>();
	String sprite = "x ";

	//add item
	public void add(String item){
		inventory.add(item);
	}//add item

	//does have item
	public boolean has(String item){
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