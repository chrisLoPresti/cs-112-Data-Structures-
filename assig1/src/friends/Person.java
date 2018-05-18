package friends;

public class Person {
	String name; // the person's name
	Friend firstFriend; // the first friend in the list of this
						// person's friends
	Person nextPerson; // the next person in the list of people

	public Person(String name, Person nextPerson) {
		this.name = name;
		this.nextPerson = nextPerson;
	}

	// A string representing the list of friends of this person.
	// O(number of friends in the list)
	
	public String getName(){
		
		return this.name;
	}
	
	
	public String friendString() {

		String friendList = "";

		Friend temp = firstFriend;

		if (firstFriend == null) {

			return friendList;
		}

		while (temp != null) {

			friendList += " ";

			friendList += temp.who.name;

			temp = temp.nextFriend;

		}

		friendList = friendList.substring(1);

		return friendList;

	}

	// add friend as a friend of this person
	// O(1)
	public void addFriend(Person friend) {

		Friend newFriend = new Friend(friend, null);

		Friend temp = firstFriend;

		if (temp == null) {

			firstFriend = newFriend;

			return;

		}

		// THIS ADDS FRIEND TO THE START OF FRIEND LIST O(1)

		newFriend.nextFriend = firstFriend;

		firstFriend = newFriend;

		return;
		
		// THIS ADDS FRIEND TO THE END OF FRIENDLIST O(N)

		/*
		  else if (temp.nextFriend == null) {
		 
		  temp.nextFriend = newFriend;
		  
		  return;
		  
		  } else {
		  
		  while (temp.nextFriend != null) {
		  
		  temp = temp.nextFriend;
		 
		  }
		 
		  temp.nextFriend = newFriend;
		  
		  return; }
		 */

	}

	// remove Person friend as a friend of this person
	// if friend is not a friend of this person, does nothing
	// O(number of friends of this person)
	public void removeFriend(Person friend) {

		Friend temp = firstFriend;

		if (firstFriend == null) {

			return;

		} else if (firstFriend.who.name.equals(friend.name)) {

			firstFriend = firstFriend.nextFriend;

			return;

		} else {

			while (temp.nextFriend != null) {

				if (temp.nextFriend.who.name.equals(friend.name)) {

					temp.nextFriend = temp.nextFriend.nextFriend;

				} else {

					temp = temp.nextFriend;
				}

			}

			return;

		}
	}
	
	

}//end of class
