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

		//Defines door 1
		Door1.x = 7;
		Door1.y = 5;
		Door1.show = true;
		Door1.locked = true;
		Door1.key = "key";
	}

	public void PrintMap(String[][] map) {
		for (int i = 0; i < map.length; i++) {
			
			// Loops through and prints map
			for (int j = 0; j < map[i].length; j++){
				if (i == User1.y && j == User1.x){// copy this and replace the text to add other objects
					System.out.print("x ");

				} else if (i == Key1.y && j == Key1.x && Key1.show == true){
					System.out.print("F ");

				} else if (i == Door1.y && j == Door1.x && Door1.show == true && Door1.locked == true){
					System.out.print("| ");

				} else if (i == Door1.y && j == Door1.x && Door1.show == true && Door1.locked == false){
					System.out.print("_ ");

				} else{
					System.out.print(map[i][j] + " ");
				}

			} // for j
			System.out.println();
		} // for i
	}// World printer


	//Switch direction sense to int value

	public void Move(int direct, String[][] map){
		switch (direct){
		//up
		case 1:
			if (map[User1.y - 1][User1.x].equalsIgnoreCase(" ") == true){//Add another if statement with a differnt char to add another material
				User1.y--;
			}
			if (checkDirection(direct, User1.x, User1.y, Door1.x, Door1.y) == true && User1.has(Door1.key) == true){
				Door1.locked = false;
				User1.y--;
			}
			break;
		//down
		case 2:
			if (map[User1.y + 1][User1.x].equalsIgnoreCase(" ") == true){
				User1.y++;
			}
			if (checkDirection(direct, User1.x, User1.y, Door1.x, Door1.y) == true && User1.has(Door1.key) == true){
				Door1.locked = false;
				User1.y++;
			}
			break;
		//left
		case 3:
			if (map[User1.y][User1.x - 1].equalsIgnoreCase(" ") == true){
				User1.x--;
			}
			if (checkDirection(direct, User1.x, User1.y, Door1.x, Door1.y) == true && User1.has(Door1.key) == true){
				Door1.locked = false;
				User1.x--;
			}
			break;
		//right
		case 4:
			if (map[User1.y][User1.x + 1].equalsIgnoreCase(" ")){
				User1.x++;
			}
			if (checkDirection(direct, User1.x, User1.y, Door1.x, Door1.y) == true && User1.has(Door1.key) == true){
				Door1.locked = false;
				User1.x++;
			}
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
			forceMove(direction);
		}
	}
}// MapMan