package wrdle;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws Exception {

		File file = new File("C:\\Users\\Rodri\\Desktop\\java wrdle\\fiveletters.txt");
		Scanner sc = new Scanner(file);

		List pw = new ArrayList();
		while (sc.hasNextLine()) {

			pw.add(sc.nextLine());

		}

		Random rand = new Random();
		int randInt = rand.nextInt(pw.size());

		String password = (String) pw.get(randInt);
		// System.out.println(password);

		String[] pwLetras = password.split("");
		// System.out.println(Arrays.toString(pwLetras));

		int intentosRestantes = 0;
		while (intentosRestantes < 6) {

			Scanner yep = new Scanner(System.in);
			System.out.println("Contraseña: ");

			String pwUsuario = yep.nextLine();
			String userPw = pwUsuario.toUpperCase();
			System.out.println("la pw del usuario: " + userPw);

			if (userPw.equals(password)) {
				System.out.print("Ganaste!");
				return;
			}

			for (int i = 0; i < userPw.length(); i++) {

				if (userPw.charAt(i) == password.charAt(i)) {
					System.out.println(userPw.charAt(i) + " En Verde");

				} else if (password.length() < 10) {
					char letraActual = password.charAt(i);
					for (int j = 0; j < 5; j++) {
						char letraActualUser = userPw.charAt(j);
						if (letraActualUser == letraActual) {
							System.out.println(letraActualUser + " En Amarillo");
						} else if (intentosRestantes == 5) {
							System.out.println("perdiste!");
							return;
						}

					}
				}

			}
			intentosRestantes++;

		}
	}
}
