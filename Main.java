import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main<thereIsEdentulous, thereIsArtiodactyls> {

	public static void main(String[] args) throws Exception {
		/*System.out.println("Enter animal parameters");
		System.out.println("____________________________________________________________________________");
		System.out.print("ANIMAL NUTRITION:carnivores, herbivores, omnivores\n");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();*/
		/*List<Artiodactyls> f =new ArrayList<>();
		Accessor.getInstance().getArtiodactyls(f) ;
		System.out.println(f);*/




		System.out.println("fill in the information about the animal");
		Scanner in = new Scanner(System.in);

		System.out.println("Enter food: ");
		String food = in.nextLine();

		System.out.println("Enter habitat");
		String habitat = in.nextLine();

		System.out.println("Enter reproduction");
		String reproduction = in.nextLine();

		System.out.println("Enter locomotion");
		String locomotion = in.nextLine();

		System.out.println("Enter lifestyle");
		String lifestyle = in.nextLine();

		System.out.println("Enter average age");
		String average_age = in.nextLine();

		System.out.println("Enter type");
		String type = in.nextLine();


		boolean thereIsPinnipeds = Accessor.getInstance()
				.PinnipedsGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);

		boolean thereIsEdentulous = Accessor.getInstance()
				.EdentulousGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);

		boolean thereIsArtiodactyls = Accessor.getInstance()
				.ArdvarksGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);
		boolean thereIsCetaceans = Accessor.getInstance()
				.CetaceansGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);
		boolean thereIsLagomorphs = Accessor.getInstance()
				.LagomorphsGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);
		boolean thereIsPrimates = Accessor.getInstance()
				.PrimatesGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);
		boolean thereIsOddToedUngulates = Accessor.getInstance()
				.Odd_toed_Get(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);
		boolean thereIsRodents = Accessor.getInstance()
				.RodentsGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);
		boolean thereIsInsectivores = Accessor.getInstance()
				.InsectivoresGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);

		boolean thereIsLizards = Accessor.getInstance()
				.LizardsGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);

		boolean thereIsProboscis = Accessor.getInstance()
				.ProboscisGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);

		boolean thereIsArdcarks = Accessor.getInstance()
				.ArdvarksGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);

		boolean thereIsPredatory = Accessor.getInstance()
				.PredatoryGet(food,
						habitat,
						reproduction,
						locomotion,
						lifestyle,
						average_age,
						type);


		System.out.println();
		if (thereIsPinnipeds) {
			System.out.println("This animal belongs to the species PINNIPEDS");
		} else {
			System.out.println("No animal with such parameters");
		}
/**********************************************************************/
		System.out.println();
		if (thereIsEdentulous) {
			System.out.println("This animal belongs to the species PINNIPEDS");
		} else {
			System.out.println("No Edentulous");
		}


		/**********************************************************************/
		System.out.println();
		if (thereIsArtiodactyls) {
			System.out.println("This animal belongs to the species ARTIODACTYLS");
		} else {
			System.out.println("No Artiodactyls");
		}

		/**********************************************************************/
		System.out.println();
		if (thereIsCetaceans) {
			System.out.println("This animal belongs to the species CETACEANS");
		} else {
			System.out.println("No Cetaceans");
		}
		/**********************************************************************/
		System.out.println();
		if (thereIsLagomorphs) {
			System.out.println("This animal belongs to the species LAGOMORPHS");
		} else {
			System.out.println("No Lagomorphs");
		}
		/**********************************************************************/
		System.out.println();
		if (thereIsPrimates) {
			System.out.println("This animal belongs to the species PRIMATES");
		} else {
			System.out.println("No Primates");
		}
		/**********************************************************************/
		System.out.println();
		if (thereIsOddToedUngulates) {
			System.out.println("This animal belongs to the species ODD TOED UNGULATES");
		} else {
			System.out.println("No OddToedUngulates");
		}
		/**********************************************************************/
		System.out.println();
		if (thereIsRodents) {
			System.out.println("This animal belongs to the species RODENTS");
		} else {
			System.out.println("No Rodents");
		}
		/**********************************************************************/
		System.out.println();
		if (thereIsInsectivores) {
			System.out.println("This animal belongs to the species INSECTIVORES");
		} else {
			System.out.println("No Insectivores");
		}
		/**********************************************************************/
		System.out.println();
		if (thereIsLizards) {
			System.out.println("This animal belongs to the species LIZARDS");
		} else {
			System.out.println("No Lizards");
		}
		/**********************************************************************/
		System.out.println();
		if (thereIsProboscis) {
			System.out.println("This animal belongs to the species PROBOSCIS");
		} else {
			System.out.println("No Proboscis");
		}
		/**********************************************************************/
		System.out.println();
		if (thereIsArdcarks) {
			System.out.println("This animal belongs to the species ARDCARKS");
		} else {
			System.out.println("No Ardcarks");
		}
		/**********************************************************************/
		System.out.println();
		if (thereIsPredatory) {
			System.out.println("This animal belongs to the species PREDATORY");
		} else {
			System.out.println("No Predatory");
		}
		/**********************************************************************/
		/**********************************************************************/
		/**********************************************************************/

	}
	private static String getParameter() {
//		Scann
		return null;
	}
}




/* в бд пишу запрос
пишу метод с параметраи и вставляю запрос бд
потом в запрос кидаю слова-параметры
если запрос совпадет то чувак найден
*/
