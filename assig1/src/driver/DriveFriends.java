package driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import friends.PersonList;
import friends.Person;

public class DriveFriends {
	public static void main(String [] args)
		throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char cmd=' ';
		PersonList people = new PersonList();
		
		System.out.println("options:\ntype:  for:");
		System.out.println(" q     quit");
		System.out.println(" a     add friend");
		System.out.println(" b     add friend before last friend");
		System.out.println(" d     delete friend");
		System.out.println(" p     print friend list");
		System.out.println(" l     print people list");
		System.out.println(" r     remove very other person");
		System.out.println(" e     print every other person");
		
		while (cmd != 'q'){
			
			Person who;
			System.out.print("option: ");
			String line = br.readLine();
			if (line.length() == 0){
				cmd = ' ';
			} else {
				cmd = line.charAt(0);
			}
			
			switch (cmd){
			case 'a': who = readPerson("person", people, br);
					  who.addFriend(readPerson("friend", people, br));
					  
					  break;
					  
			case 'c': people.clear();
			
				System.out.println("the lists were cleared");
			  
			  break;
					  
			case 'b': who = readPersonBeforeLastMethod("person", people, br);
			
					String name = who. getName();
			
					System.out.println(name + " was added");
			  
			  break;
			  
			case 'd': who =  readPerson("person", people, br);
			  	      who.removeFriend(readPerson("friend", people, br));
			  	      break;
			case 'l': System.out.println("here's a list of all the people");
					  String personList = people.personString();
					  System.out.println(personList);
			          break;
			          
			case 'r': System.out.println("every other friend has been removed");
			
				people.removeFriendEveryOther();
			
	          break;
	          
			          
			case 'e': System.out.println("here's a list of every other person");
			  String personListEveryOther = people.personStringEveryOther();
			  
			  System.out.println(personListEveryOther);
	          break;
			case 'p': who = readPerson("person", people, br);
			          // add "|" so we can see extra spaces fore and aft
			 		  System.out.println("|"+who.friendString()+"|"); 
			 		  break;
			case 'q': System.out.println("Bye.");
					  break;
			default:  System.out.println("Bad option.");
			
			}
		}
	}
		
		static Person readPerson(String kind, PersonList people, BufferedReader br)
			throws IOException {
			System.out.println("type "+ kind + "'s name: ");
			String name = br.readLine().trim();  // remove spaces around name
			Person who = people.lookup(name);
			if (who == null){
				who = people.addPerson(name);
			}
			return who;
		}
		
		
		
		static Person readPersonBeforeLastMethod(String kind, PersonList people, BufferedReader br)
				throws IOException {
				System.out.println("type "+ kind + "'s name: ");
				String name = br.readLine().trim();  // remove spaces around name
				Person who = people.lookup(name);
				if (who == null){
					who = people.addBeforelast(name);
				}
				return who;
			}
}
