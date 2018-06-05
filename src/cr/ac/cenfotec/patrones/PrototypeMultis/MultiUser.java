/**
 * 
 */
package cr.ac.cenfotec.patrones.PrototypeMultis;

import java.util.ArrayList;

import cr.acr.cenfotec.patrones.PrototypeClases.User;

/**
 * @author Olman
 *
 */
public class MultiUser {

	
	public ArrayList<User> getUsers () {
		ArrayList<User> userList = new ArrayList<User>();
		User newUser = new User("Eduardo","Martinez", 01, "abc123", "eduMar", 0);
		User newEmployee = new User("Carlos","Garro", 02, "abc123", "carGa", 1);
		userList.add(newUser);
		userList.add(newEmployee);
		return userList;
	}
	
	public User getUserByUserName (String userName) {
		User foundedUser = new User();
		ArrayList<User> userList  = new ArrayList<>();
		userList = getUsers();
		
		for (int i = 0; i < userList.size(); i++) {
			String testUserName = userList.get(i).getUserName();
			if (testUserName.equals(userName)) {
				foundedUser = userList.get(i);
				break;
			} else {
				foundedUser = null;
			}
		} 
		return foundedUser;
	}
}
