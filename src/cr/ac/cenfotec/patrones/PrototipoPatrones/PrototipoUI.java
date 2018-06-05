/**

first push
 * 
 */
package cr.ac.cenfotec.patrones.PrototipoPatrones;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import cr.acr.cenfotec.patrones.PrototypeClases.*;
import cr.ac.cenfotec.patrones.PrototypeMultis.*;
/**
 * @author Olman
 *
 */
public class PrototipoUI {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static Authenticator authenticator = new Authenticator();
	static UserAuthenticated userAuthenticated = new UserAuthenticated();
	static MultiUser multi_user = new MultiUser();


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		showMainMenu();
			
	}
	
	public static void showMainMenu () {
		boolean end = false;
		
		do {
			try {
				end = showLoginMenu();
				if (end) {
					showMenu();
				} else {
					System.out.println("Credenciales invalidas, por favor intente nuevamente");
				}
			} 
			catch (Exception error) {
				System.out.println(error);
				System.out.println(error.getMessage());
			}
			
			
		}while(end != true);
		
	}
	
	public static boolean showLoginMenu () throws IOException {
		
		String userName, password;
		boolean isAuthenticated = false;
		User currentUser;
		boolean showUserMenu = false;
		
		out.println("Formulario inicio de sesion");
		out.println("Ingrese su nombre de usuario");
		userName = in.readLine();
		out.println("Ingrese su contrasena");
		password = in.readLine();
		
		isAuthenticated = authenticator.validateCredencials(userName, password);
		
		if (isAuthenticated) {
			// Nota: Reemplazar esta funcionaliadad por métodos en el authenticator
			currentUser = multi_user.getUserByUserName(userName);
			if (currentUser != null) {
				userAuthenticated = new UserAuthenticated(
						currentUser.getName(), 
						currentUser.getLastName(), currentUser.getId(), 
						currentUser.getUserName(), currentUser.getUserType());
				showUserMenu = true;				
			} else {
				showUserMenu = false;
			}

			
		}
		
		return showUserMenu;
	}
	
	public static void showMenu () {
		if (userAuthenticated.getUserType() == 0) {
			showAdminMenu();
		} else if (userAuthenticated.getUserType() == 1) {
			showUserMenu();
		}
	}
	
	public static void showAdminMenu() {
		int option;
		boolean end = false;
		
		do {
			try {
				showAdminOptions();
				option = readOption();
				end = excuteAdminOption(option);
			}
			catch (Exception error) {
				System.out.println(error);
				System.out.println(error.getMessage());
			}
			
		}while(end != true);
	}
	
	public static void showAdminOptions () {
		out.println("Seleccione una opci\u00f3n");
		out.println("1.Registrar Organizaci\u00f3n");
		out.println("2.Registrar un empleado");
		out.println("3.Registrar un proceso");
		out.println("4.Registrar tarea");
		out.println("5.Modificar tarea");
		out.println("6.Ver historial de tareas");
		out.println("7.Cerrar Sesi\u00f3n");
	}

	public static void showUserMenu() {
		int option;
		boolean end = false;
		
		do {
			try {
				showUserOptions();
				option = readOption();
				end = excuteUserOption(option);
			}
			catch (Exception error) {
				System.out.println(error);
				System.out.println(error.getMessage());
			}
			
		}while(end != true);
	}	
	
		
	public static void showUserOptions() {
		out.println("Seleccione una opci\u00f3n");
		out.println("1.Modificar tarea");
		out.println("2.Ver historial de tareas");
		out.println("3.Cerrar Sesi\u00f3n");		
	}
	
	public static int readOption() throws NumberFormatException, IOException {
		int option;
		out.println("Ingrese la opci\u00f3n que desea realizar");
		option = Integer.parseInt(in.readLine());
		return option;
	}	
	
	public static boolean excuteUserOption (int option) throws InterruptedException, IOException {
		boolean end = false;
		
		switch (option) {
			
			case 1:
				break;
				
			case 2: 
				break;
			
			case 3:
				closeSession(); 
				break;
			
			default: 
				break;
				
		}
		
		return end; 
	}
	

	public static boolean excuteAdminOption (int option) {
		boolean end = false;
		
		switch (option) {
			
			case 1:
				break;
				
			case 2: 
				break;
			
			case 3:
				break;
				
			case 4:
				break;
				
			case 5: 
				break;
			
			case 6:
				break;
				
			case 7:
				closeSession(); 
				break;
			
			default: 
				break;
				
		}
		
		return end; 
	}
	
	public static void closeSession () {
		userAuthenticated = null;
		clearConsole();
		showMainMenu(); 
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
		
	
	
	
}
