// PrintMap (map)
// Move (direct(u, d, l, r), (map))

public class MapMan {
	Key Key1 = new Key();
	User User1 = new User();

	public void PrintMap(String[][] map) {
		for (int i = 0; i < map.length; i++) {
			// Loops through and prints map
			for (int j = 0; j < map[i].length; j++) {
				if (i == User1.userY && j == User1.userX) {// copy this and replace the text to add other objects

					// Replaces space with charecter.
					System.out.print("x ");

				} else if (i == Key1.keyY && j == Key1.keyX && Key1.show == true) {

					// Replaces space with charecter.
					System.out.print("F ");

				} else {
					System.out.print(map[i][j] + " ");
				}

			} // for j
			System.out.println();
		} // for i
	}// PrintFrame()

	public void Move(String direct, String[][] map){
		//up
		if (direct.equalsIgnoreCase("u") == true || direct.equalsIgnoreCase("up") == true){
			if (map[User1.userY - 1][User1.userX].equalsIgnoreCase(".") == true){//Add another if statement with a differnt char to add another material
				User1.userY--;
			}
		}
		//down
		if (direct.equalsIgnoreCase("d") == true || direct.equalsIgnoreCase("down") == true){
			if (map[User1.userY + 1][User1.userX].equalsIgnoreCase(".") == true){
				User1.userY++;
			}
		}
		//left
		if (direct.equalsIgnoreCase("l") == true || direct.equalsIgnoreCase("left") == true){
			if (map[User1.userY][User1.userX - 1].equalsIgnoreCase(".") == true){
				User1.userX--;
			}
		}
		//right
		if (direct.equalsIgnoreCase("r") == true || direct.equalsIgnoreCase("right") == true){
			if (map[User1.userY][User1.userX + 1].equalsIgnoreCase(".") == true){
				User1.userX++;
			}
		}

		if (Key1.keyX == User1.userX && Key1.keyX == User1.userX && Key1.show == true){
			Key1.show = false;
			User1.add("key");
		}
	
	}// Move()

	public void PrintInv(){
		System.out.println(User1.inventory);
	}//Print inventory


}// UserCntrl