package friends;

// represents a list of people as a linked list of Person objects
public class PersonList {

	Person firstPerson; // First Person object in the list

	public PersonList() {

		this.firstPerson = null;
	}

	// finds Person object in this list with given name
	// if none exists, returns null. Runs in O(number of persons in this list)

	// ONLY FOR TESTING
	
	public void clear(){
		
		
		firstPerson = null;
		return;
	}
	
	
	public String personString() {

		String personList = "";
		
		if(firstPerson == null){
			
			return personList;
		}

		Person temp = firstPerson;

		while (temp != null) {

			personList += " ";

			personList += temp.name;

			temp = temp.nextPerson;

		}

		personList = personList.substring(1);

		return personList;

	}

	// ONLY FOR TESTING

	// ONLY FOR TESTING -- REMOVING EVERY OTHER PERSON
	public String personStringEveryOther() {

		String personList = "";

		Person temp = firstPerson;
		
		if(firstPerson.nextPerson == null){
			
			personList+= firstPerson.name;
			
			return personList;
		}

		while (temp.nextPerson.nextPerson != null) {

			personList += " ";

			personList += temp.name;
			

			if (temp.nextPerson.nextPerson == null) {

				temp = temp.nextPerson;

			} else {

				temp = temp.nextPerson.nextPerson;

				if (temp.nextPerson == null) {
					
					break;
				}

			}
		}
		
	
		personList += " " + temp.name;
		
		personList = personList.substring(1);

		return personList;

	}

	// ONLY FOR TESTING

	public Person lookup(String name) {

		Person temp = firstPerson;

		if (temp == null) {

			return null;

		} else if (temp.name.equals(name)) {

			return temp;

		} else {

			while (temp.nextPerson != null) {

				if (temp.nextPerson.name.equals(name)) {

					return temp.nextPerson;

				} else {

					temp = temp.nextPerson;

				}

			}

		}

		return null;

	}

	// creates a new Person object with name and adds it to the list of
	// Person objects. Runs in O(1)

	public Person addPerson(String name) {

		Person newPerson = new Person(name, null);

		if (firstPerson == null) {

			firstPerson = newPerson;

			return firstPerson;
		}

		// THIS ADDS TO THE START OF THE LIST O(1)

		newPerson.nextPerson = firstPerson;

		firstPerson = newPerson;

		return newPerson;

	}
	
	public Person addBeforelast(String name){
		
		Person who = new Person(name, null);
		
		
		Person temp = firstPerson; 
		
		if(firstPerson == null){
			
			return null;
			
		}else if ( firstPerson.nextPerson == null){
			
			who.nextPerson = firstPerson;
			
			firstPerson = who;
					
		}else if(firstPerson.nextPerson.nextPerson == null) {

			who.nextPerson = firstPerson.nextPerson;
			
			firstPerson.nextPerson = who;
			
		}else{
			
			while(temp.nextPerson.nextPerson.nextPerson!= null){
				
				
				temp = temp.nextPerson; 
			}
			
			who.nextPerson= temp.nextPerson.nextPerson;
			
			temp.nextPerson.nextPerson = who;
			
		
		}
		
		return who;
	}
	
	
	public void removeFriendEveryOther() {

		if(firstPerson == null){
			
			return;
			
		}else{
			
			Person temp = firstPerson;

			while (temp.nextPerson.nextPerson != null) {
				
				if (temp.nextPerson.nextPerson == null) {

					temp.nextPerson = null;
					
					return;

				} else {

					temp.nextPerson = temp.nextPerson.nextPerson;

					if (temp.nextPerson == null) {
						
						break;
					}

				}
			}
			
		}
		
		
		
		
			

			return;

		
	}
}
