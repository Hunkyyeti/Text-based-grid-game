//RPG
//Maxwell Merrill
//10-13-21

public class Main {
	public static void main(String[] args) {
      

		String[][] test = {
      { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
      { "0", ".", ".", ".", ".", ".", ".", "0", ".", ".", ".", ".", "0"},
      { "0", ".", ".", ".", ".", ".", ".", "0", ".", ".", ".", ".", "0"},
			{ "0", ".", ".", ".", ".", ".", ".", "0", ".", ".", ".", ".", "0"},
			{ "0", ".", ".", ".", ".", ".", ".", "0", ".", ".", ".", ".", "0"},
			{ "0", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "0"},
			{ "0", ".", ".", ".", ".", ".", ".", "0", ".", ".", ".", ".", "0"},
			{ "0", "0", "0", "0", ".", ".", ".", "0", "0", "0", ".", "0", "0"},
			{ "0", ".", ".", "0", ".", ".", ".", "0", ".", ".", ".", ".", "0"},
			{ "0", ".", ".", "0", ".", ".", ".", "0", ".", ".", ".", ".", "0"},
			{ "0", ".", ".", ".", ".", ".", ".", "0", ".", ".", ".", ".", "0"},
			{ "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}
    };

		String cmdList = "Move commands\n   up/u\n   down/d\n   left/l\n   right/r\n";

		MapMan MapMan1 = new MapMan();

		User User1 = new User();
		Key Key1 = new Key();

		


		//sets current map
		String[][] currentMap = test;
		//prints out map
		MapMan1.PrintMap(currentMap);

		//main gameplay loop
		while(true){
			System.out.println("Enter a command.");
			String cmd = Scan.getStr();

			//move command
			if (cmd.equalsIgnoreCase("move") == true || cmd.equalsIgnoreCase("m") == true){
				System.out.println("Enter a direction.");
				cmd = Scan.getStr();
				MapMan1.Move(cmd, currentMap);
				MapMan1.PrintMap(currentMap); //fix test to be changable to other maps
			}//Move command

			//help
			if (cmd.equalsIgnoreCase("help") == true){
				System.out.println(cmdList);
			}//help command

			//inventory tempory testing 
			if (cmd.equalsIgnoreCase("inventory") == true || cmd.equalsIgnoreCase("inv") == true){
				
				System.out.println("Enter an inventory command");
				cmd = Scan.getStr();
			
				//print inv
				if(cmd.equalsIgnoreCase("print") == true){
					MapMan1.PrintInv();
				}

				//use item Rework this to run with new system
				if(cmd.equalsIgnoreCase("use") == true){
					System.out.println("Enter an item to use");
					cmd = Scan.getStr();
					User1.use(cmd);
				}

			}//inventory

			
		}//main loop
	}//main()
}//Main