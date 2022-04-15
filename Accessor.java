import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;;


public class Accessor {

	private static Accessor singletonAccessor=null;
	private Connection con=null;
	Statement stat=null ;

	// скрытый конструктор принимает драйвер и адрес БД
	// выбрасывает исключение Exception
	private Accessor() throws Exception {
	
		String server = "DESKTOP-VC16KFA\\SQLEXPRESS:1433";
		String urlDatabase ="animal";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// формирование строки подключения

		
		//String connectionString = "jdbc:sqlserver://localhost;databaseName="+urlDatabase+";integratedSecurity=true;";
		//String connectionString = "jdbc:sqlserver://"+server+";databaseName="+urlDatabase+";integratedSecurity=false;";
		String connectionString = "jdbc:sqlserver://"+server+";databaseName="+urlDatabase+";integratedSecurity=true;";
		

		// подключение к БД
		con = DriverManager.getConnection(connectionString);
		stat = con.createStatement();
	
	}

	// открытый метод получения единственного экземпляра аксесора
	// выбрасывает исключение Exception
	public static Accessor getInstance()
			throws Exception {
		if (singletonAccessor == null)
			singletonAccessor = new Accessor();
		return singletonAccessor;
	}
	
	//закрывает соединение с БД
	public  void closeConnection()
			throws SQLException {
		if (con!= null)
			con.close();
		}
	
	void propertyStatement()throws SQLException 
	{
		//проверка, реализует ли драйвер JDBC тот или иной тип выборки
		//TYPE_FORWARD_ONLY - курсор выборки перемещается только вперед
		//TYPE_SCROLL_INSENSITIVE - курсор перемещается в обеих направлениях, выборка не изменяется
		//TYPE_SCROLL_SENSITIVE - курсор перемещается в обеих направлениях, выборка изменяется при изменении строк в БД
		
		boolean ro=con.getMetaData().supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY);
		System.out.println("TYPE_FORWARD_ONLY - "+ro);
		
		ro=con.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE);
		System.out.println("TYPE_SCROLL_INSENSITIVE - "+ro);
			
		ro=con.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
		System.out.println("TYPE_SCROLL_SENSITIVE - "+ro);
		
		//проверка, поддерживает ли драйвер JDBC тот или иной режим изменения выборки
		//CONCUR_READ_ONLY - выборку нельзя изменять
		//CONCUR_UPDATABLE - выборку можно изменять
		ro=con.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		System.out.println("CONCUR_READ_ONLY - "+ro);
		
		ro=con.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		System.out.println("CONCUR_UPDATABLE - "+ro);
		
					
	}
	/*________________________ии 4 курс _____________________*/
	public Animal[] getAnimal(Animal[] animal) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM animal");
		int i = 0;
		while (rs.next()) {
			animal[i]=new Animal();
			animal[i].ID=rs.getInt("ID");
			i++;
		}
		rs.close();
		return animal;
	}

	public void  getArtiodactyls(List<Artiodactyls> artiodactyls) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Artiodactyls");
		int i = 0;
		while (rs.next()) {
			artiodactyls.add(i,new Artiodactyls());
			artiodactyls.get(i) .ID = rs.getInt("Id");
			artiodactyls.get(i) .food = rs.getString("food");
			artiodactyls.get(i) .habitat = rs.getString("Habitat");
			artiodactyls.get(i) .reproduction = rs.getString("Reproduction");
			artiodactyls.get(i) .locomotion = rs.getString("Locomotion");
			artiodactyls.get(i) .lifestyle = rs.getString("Lifestyle");
			artiodactyls.get(i) .average_age = rs.getInt("Average_age");
			artiodactyls.get(i) .type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();

	}
/********************************************************************************/
	public Cetaceans[] getCetaceans(Cetaceans[] cetaceans) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Cetaceans");
		int i=0;
		while (rs.next()) {
			cetaceans[i]=new Cetaceans();
			cetaceans[i].ID = rs.getInt("Id");
			cetaceans[i].food = rs.getString("food");
			cetaceans[i].habitat = rs.getString("Habitat");
			cetaceans[i].reproduction = rs.getString("Reproduction");
			cetaceans[i].locomotion = rs.getString("Locomotion");
			cetaceans[i].lifestyle = rs.getString("Lifestyle");
			cetaceans[i].average_age = rs.getInt("Average_age");
			cetaceans[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return cetaceans;
	}

/*******************************************************************************/

	public Insectivores[] getInsectivores(Insectivores[] insectivores) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Insectivores");
		int i=0;
		while (rs.next()) {
			insectivores[i]=new Insectivores();
			insectivores[i].ID = rs.getInt("Id");
			insectivores[i].food = rs.getString("food");
			insectivores[i].habitat = rs.getString("Habitat");
			insectivores[i].reproduction = rs.getString("Reproduction");
			insectivores[i].locomotion = rs.getString("Locomotion");
			insectivores[i].lifestyle = rs.getString("Lifestyle");
			insectivores[i].average_age = rs.getInt("Average_age");
			insectivores[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return insectivores;
	}
	/******************************************************************/

	public Primates[] getPrimates(Primates[] primates) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Primates");
		int i=0;
		while (rs.next()) {
			primates[i]=new Primates();
			primates[i].ID = rs.getInt("Id");
			primates[i].food = rs.getString("food");
			primates[i].habitat = rs.getString("Habitat");
			primates[i].reproduction = rs.getString("Reproduction");
			primates[i].locomotion = rs.getString("Locomotion");
			primates[i].lifestyle = rs.getString("Lifestyle");
			primates[i].average_age = rs.getInt("Average_age");
			primates[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return primates;
	}
	/****************************************************************************/

	public Lizard[] getLizard(Lizard[] lizard) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Primates");
		int i=0;
		while (rs.next()) {
			lizard[i]=new Lizard();
			lizard[i].ID = rs.getInt("Id");
			lizard[i].food = rs.getString("food");
			System.out.println(lizard[i].food+"\n");
			lizard[i].habitat = rs.getString("Habitat");
			lizard[i].reproduction = rs.getString("Reproduction");
			lizard[i].locomotion = rs.getString("Locomotion");
			lizard[i].lifestyle = rs.getString("Lifestyle");
			lizard[i].average_age = rs.getInt("Average_age");
			lizard[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return lizard;
	}



	public Lagomorphs[] getLagomorphs(Lagomorphs[] lagomorphs) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Lagomorphs");
		int i=0;
		while (rs.next()) {
			lagomorphs[i]=new Lagomorphs();
			lagomorphs[i].ID = rs.getInt("Id");
			lagomorphs[i].food = rs.getString("food");
			lagomorphs[i].habitat = rs.getString("Habitat");
			lagomorphs[i].reproduction = rs.getString("Reproduction");
			lagomorphs[i].locomotion = rs.getString("Locomotion");
			lagomorphs[i].lifestyle = rs.getString("Lifestyle");
			lagomorphs[i].average_age = rs.getInt("Average_age");
			lagomorphs[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return lagomorphs;
	}


	public Proboscis[] getProboscis(Proboscis[] proboscis) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Proboscis");
		int i=0;
		while (rs.next()) {
			proboscis[i]=new Proboscis();
			proboscis[i].ID = rs.getInt("Id");
			proboscis[i].food = rs.getString("food");
			proboscis[i].habitat = rs.getString("Habitat");
			proboscis[i].reproduction = rs.getString("Reproduction");
			proboscis[i].locomotion = rs.getString("Locomotion");
			proboscis[i].lifestyle = rs.getString("Lifestyle");
			proboscis[i].average_age = rs.getInt("Average_age");
			proboscis[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return proboscis;
	}


	public Rodents[] getRodents(Rodents[] rodents) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Rodents");
		int i=0;
		while (rs.next()) {
			rodents[i]=new Rodents();
			rodents[i].ID = rs.getInt("Id");
			rodents[i].food = rs.getString("food");
			rodents[i].habitat = rs.getString("Habitat");
			rodents[i].reproduction = rs.getString("Reproduction");
			rodents[i].locomotion = rs.getString("Locomotion");
			rodents[i].lifestyle = rs.getString("Lifestyle");
			rodents[i].average_age = rs.getInt("Average_age");
			rodents[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return rodents;
	}

	public Edentulous[] getEdentulous(Edentulous[] edentulous) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Edentulous");
		int i=0;
		while (rs.next()) {
			edentulous[i]=new Edentulous();
			edentulous[i].ID = rs.getInt("Id");
			edentulous[i].food = rs.getString("food");
			edentulous[i].habitat = rs.getString("Habitat");
			edentulous[i].reproduction = rs.getString("Reproduction");
			edentulous[i].locomotion = rs.getString("Locomotion");
			edentulous[i].lifestyle = rs.getString("Lifestyle");
			edentulous[i].average_age = rs.getInt("Average_age");
			edentulous[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return edentulous;
	}


	public Pinnipeds[] getPinnipeds(Pinnipeds[] pinnipeds) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Pinnipeds");
		int i=0;
		while (rs.next()) {
			pinnipeds[i]=new Pinnipeds();
			pinnipeds[i].ID = rs.getInt("Id");
			pinnipeds[i].food = rs.getString("food");
			pinnipeds[i].habitat = rs.getString("Habitat");
			pinnipeds[i].reproduction = rs.getString("Reproduction");
			pinnipeds[i].locomotion = rs.getString("Locomotion");
			pinnipeds[i].lifestyle = rs.getString("Lifestyle");
			pinnipeds[i].average_age = rs.getInt("Average_age");
			pinnipeds[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return pinnipeds;
	}


	public Ardvarks[] getArdvarks(Ardvarks[] ardvarks) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Ardvarks");
		int i=0;
		while (rs.next()) {
			ardvarks[i]=new Ardvarks();
			ardvarks[i].ID = rs.getInt("Id");
			ardvarks[i].food = rs.getString("food");
			ardvarks[i].habitat = rs.getString("Habitat");
			ardvarks[i].reproduction = rs.getString("Reproduction");
			ardvarks[i].locomotion = rs.getString("Locomotion");
			ardvarks[i].lifestyle = rs.getString("Lifestyle");
			ardvarks[i].average_age = rs.getInt("Average_age");
			ardvarks[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return ardvarks;
	}


	public Predatory[] getPredatory(Predatory[] predatory) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Predatory");
		int i=0;
		while (rs.next()) {
			predatory[i]=new Predatory();
			predatory[i].ID = rs.getInt("Id");
			predatory[i].food = rs.getString("food");
			predatory[i].habitat = rs.getString("Habitat");
			predatory[i].reproduction = rs.getString("Reproduction");
			predatory[i].locomotion = rs.getString("Locomotion");
			predatory[i].lifestyle = rs.getString("Lifestyle");
			predatory[i].average_age = rs.getInt("Average_age");
			predatory[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return predatory;
	}

	public OddToedUngulates[] getOddToedUngulates(OddToedUngulates[] oddToedUngulates) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM Odd_toed_ungulates");
		int i=0;
		while (rs.next()) {
			oddToedUngulates[i]=new OddToedUngulates();
			oddToedUngulates[i].ID = rs.getInt("Id");
			oddToedUngulates[i].food = rs.getString("food");
			oddToedUngulates[i].habitat = rs.getString("Habitat");
			oddToedUngulates[i].reproduction = rs.getString("Reproduction");
			oddToedUngulates[i].locomotion = rs.getString("Locomotion");
			oddToedUngulates[i].lifestyle = rs.getString("Lifestyle");
			oddToedUngulates[i].average_age = rs.getInt("Average_age");
			oddToedUngulates[i].type = rs.getString("Type_");
			//storage[i]=addInfoStorage(id,storage[i]);
			i++;
		}
		rs.close();
		return oddToedUngulates;
	}


	public boolean PinnipedsGet(String food,
								String habitat,
								String reproduction,
								String locomotion,
								String lifestyle,
								String average_age,
								String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Pinnipeds\n" +
				"where '"+food+"'='carnivores' and \n" +
				"'"+habitat+"'='terrestrial-aquatic'and\n" +
				"'"+reproduction+"'='viviparous' and \n" +
				"'"+locomotion+"'='floating' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"'= '25' and \n" +
				"'"+type+"'='placental'");


		return queryResponse.next();

	}


	public boolean EdentulousGet(String food,
								 String habitat,
								 String reproduction,
								 String locomotion,
								 String lifestyle,
								 String average_age,
								 String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Edentulous\n" +
				"where '"+food+"' ='omnivores' and \n" +
				"'"+habitat+"'='terrestrial'and\n" +
				"'"+reproduction+"'='viviparous' and \n" +
				"'"+locomotion+"'='running' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"' = '20' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}

	public boolean CetaceansGet(String food,
								String habitat,
								String reproduction,
								String locomotion,
								String lifestyle,
								String average_age,
								String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Cetaceans\n" +
				"where '"+food+"' ='carnivores' and \n" +
				"'"+habitat+"'='aquatic'and\n" +
				"'"+reproduction+"'='viviparous' and \n" +
				"'"+locomotion+"'='floating' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"' = '60' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}

	public boolean LagomorphsGet(String food,
								 String habitat,
								 String reproduction,
								 String locomotion,
								 String lifestyle,
								 String average_age,
								 String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Lagomorphs\n" +
				"where '"+food+"' ='hebivores' and \n" +
				"'"+habitat+"'='terrestrial'and\n" +
				"'"+reproduction+"'='viviparous' and \n" +
				"'"+locomotion+"'='floating' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"' = '6' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}

	public boolean PrimatesGet(String food,
							   String habitat,
							   String reproduction,
							   String locomotion,
							   String lifestyle,
							   String average_age,
							   String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Primates\n" +
				"where '"+food+"' ='hebivores' and \n" +
				"'"+habitat+"'='terrestrial'and\n" +
				"'"+reproduction+"'='viviparous' and \n" +
				"'"+locomotion+"'='climbing' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"' = '40' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}

	public boolean Odd_toed_Get(String food,
								String habitat,
								String reproduction,
								String locomotion,
								String lifestyle,
								String average_age,
								String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Odd_toed_ungulates\n" +
				"where '"+food+"'='hebivores' and \n" +
				"'"+habitat+"'='terrestrial'and\n" +
				"'"+reproduction+"'='viviparous' and \n" +
				"'"+locomotion+"'='running' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"' = '25' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}

	public boolean RodentsGet(String food,
							  String habitat,
							  String reproduction,
							  String locomotion,
							  String lifestyle,
							  String average_age,
							  String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Rodents\n" +
				"where '"+food+"'='hebivores' and \n" +
				"'"+habitat+"'='underground'and\n" +
				"'"+reproduction+"'='viviparous' and \n" +
				"'"+locomotion+"'='running' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"' = '2' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}


	public boolean InsectivoresGet(String food,
								   String habitat,
								   String reproduction,
								   String locomotion,
								   String lifestyle,
								   String average_age,
								   String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Insectivores\n" +
				"where '"+food+"'='carnivores' and \n" +
				"'"+habitat+"'='terrestrial'and\n" +
				"'"+reproduction+"'='viviparous' and \n" +
				"'"+locomotion+"'='running' and \n" +
				"'"+lifestyle+"'='nocturnal' and\n" +
				"'"+average_age+"' = '6' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}

	public boolean LizardsGet(String food,
							  String habitat,
							  String reproduction,
							  String locomotion,
							  String lifestyle,
							  String average_age,
							  String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Lizards\n" +
				"where '"+food+"'='hebivores' and \n" +
				"'"+habitat+"'='terrestrial'and\n" +
				"'"+reproduction+"'='oviparous' and \n" +
				"'"+locomotion+"'='running' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"' = '7' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}

	public boolean ProboscisGet(String food,
								String habitat,
								String reproduction,
								String locomotion,
								String lifestyle,
								String average_age,
								String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Proboscis\n" +
				"where '"+food+"'='hebivores' and \n" +
				"'"+habitat+"'='terrestrial'and\n" +
				"'"+reproduction+"'='viviparous' and \n" +
				"'"+locomotion+"'='running' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"' = '70' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}

	public boolean ArdvarksGet(String food,
							   String habitat,
							   String reproduction,
							   String locomotion,
							   String lifestyle,
							   String average_age,
							   String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Ardvarks\n" +
				"where '"+food+"'='omnivores' and \n" +
				"'"+habitat+"'='terrestrial'and\n" +
				"'"+reproduction+"'='oviparous' and \n" +
				"'"+locomotion+"'='running' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"' = '20' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}

	public boolean PredatoryGet(String food,
							   String habitat,
							   String reproduction,
							   String locomotion,
							   String lifestyle,
							   String average_age,
							   String type) throws SQLException {

		ResultSet queryResponse = stat.executeQuery("SELECT *\n" +
				"FROM Predatory\n" +
				"where '"+food+"'='carnivores' and \n" +
				"'"+habitat+"'='terrestrial'and\n" +
				"'"+reproduction+"'='viviparous' and \n" +
				"'"+locomotion+"'='floating' and \n" +
				"'"+lifestyle+"'='daytime' and\n" +
				"'"+average_age+"' = '10' and \n" +
				"'"+type+"'='placental'");

		return queryResponse.next();
	}



}