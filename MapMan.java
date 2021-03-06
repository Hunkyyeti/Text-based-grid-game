// PrintMap (map)
// Move (direct(u, d, l, r), (map))

public class MapMan {
	Key Key1 = new Key();
	User User1 = new User();
	Door Door1 = new Door();

	//defines items
	public void DefineItems(){
		//Defines key 1
		Key1.x = 1;
		Key1.y = 1;
		Key1.show = true;
		Key1.name = "key";
		Key1.sprite = "F ";
		

		//Defines door 1
		Door1.x = 7;
		Door1.y = 5;
		Door1.show = true;
		Door1.locked = true;
		Door1.key = "key";
		Door1.sprite = "| ";
	}

	//Print logic for objects
	public void objectPrint(String[][] map, int i, int j){
		//User1
		if (i == User1.y && j == User1.x){
			System.out.print(User1.sprite);
		}
		//Key1
		else if (i == Key1.y && j == Key1.x && Key1.show == true){
			System.out.print(Key1.sprite);
		} 
		//Door1
		else if (i == Door1.y && j == Door1.x && Door1.show == true){
			System.out.print(Door1.sprite);
		}
		//Print map
		else{
			System.out.print(map[i][j] + " ");
		}
	}

	public void PrintMap(String[][] map) {
		for (int i = 0; i < map.length; i++) {
			// Loops through and prints map
			for (int j = 0; j < map[i].length; j++){
				objectPrint(map, i, j);
			} // for j
			System.out.println();
		} // for i
	}// World printer


	//Switch direction sense to int value

	public void Move(int direction, String[][] map){
		switch (direction){
		//up
		case 1:
			if (map[User1.y - 1][User1.x].equalsIgnoreCase(" ") == true){
				User1.y--;
			}
			doorOpen(direction);
			break;
		//down
		case 2:
			if (map[User1.y + 1][User1.x].equalsIgnoreCase(" ") == true){
				User1.y++;
			}
			doorOpen(direction);
			break;
		//left
		case 3:
			if (map[User1.y][User1.x - 1].equalsIgnoreCase(" ") == true){
				User1.x--;
			}
			doorOpen(direction);
			break;
		//right
		case 4:
			if (map[User1.y][User1.x + 1].equalsIgnoreCase(" ")){
				User1.x++;
			}
			doorOpen(direction);
			break;
		}

		//if on key
		if (ifOn(User1.x, User1.y, Key1.x, Key1.y) == true && Key1.show == true){
			Key1.show = false;
			User1.add(Key1.name);
		}

		System.out.println(User1.x + "," + User1.y);
	
	}// Movement controler

	public void PrintInv(){
		System.out.println(User1.inventory);
	}//Print inventory

	//Check if object is in the specific direction
	public boolean checkDirection(int direction, int uX, int uY, int x, int y){
		switch (direction){
		case 1:
			if (uY - 1 == y && uX == x){
				return true;
			}
			break;
		case 2:
			if (uY + 1 == y && uX == x){
				return true;
			}
			break;
		case 3:
			if (uY == y && uX - 1 == x){
				return true;
			}
			break;
		case 4:
			if (uY == y && uX + 1 == x){
				return true;
			}
			break;
		}
		return false;
	}//Check Direction

	//Checks if on a specfic object
	public boolean ifOn(int uX, int uY, int x, int y){
		if (uY == y && uX == x){
			return true;
		}
		return false;
	}//If on

	//moves without collsion checks
	public void forceMove(int direction){
		switch(direction){
		case 1:
			User1.y--;
			break;
		case 2:
			User1.y++;
			break;
		case 3:
			User1.x--;
			break;
		case 4:
			User1.x++;
			break;
		}
	}
	
	//Checks if door is you have key then moves you through the door if you do.
	public void doorOpen(int direction){
		if (checkDirection(direction, User1.x, User1.y, Door1.x, Door1.y) == true && User1.has(Door1.key) == true){
			Door1.locked = false;
			Door1.sprite = "_ ";
			forceMove(direction);
		}
	}
}// MapMan