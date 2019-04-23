
//LABORATORIO No4.
//PROGRAMA HECHO POR JUAN CAMILO GUERRA TABARES
//ESTUDIANTE DE LA UNIVERSIDAD ICESI
package ui;
//
import model.*;
import java.util.*;
//
public class Main{
	private Veterinary vete;

	public Main(){
		init();
	}

	public void init(){
		Service serv1 = new Service(null, 0.0, null, 0, new Dated(15,4,2018));
		Service serv2 = new Service(null, 0.0, null, 0, new Dated(16,5,2018));
		//
		Dated histoDate1 = new Dated (10, 02, 2018);
		//
		ClinicHistory clini = new ClinicHistory("--", "--", "abierto", histoDate1, null);
		//
		Pet paca = new Pet("paca", "perro", 12, 32, 1.2, false, true, null);
		//
		Clients juan = new Clients ("juan", 20563, "cll 16 #10-86", "3025874962");
		//
		// Medicine Acetaminophen = new Medicine ("apheminophen", 15, 200, 2);
		// ClinicHistory c1 = new ClinicHistory ("--", "--", "abierto", new Dated(10, 03, 2000), new Dated(10, 03, 2001));
		// c1.addMedicine(Acetaminophen);
		// Pet luna = new Pet ("Luna", "perro", 2, 40.0, false, true);
		// Clients juan = new Clients ("juan", 20563, "cll 16 #10-86", "3025874962");

		vete = new Veterinary("MI PEQUEÑA MASCOTA");

	}

	public static void main(String[] args){
		Main m = new Main();
		m.msg();
	}
	public void msg(){
		Scanner scanStr = new Scanner (System.in);
		Scanner scanInt = new Scanner (System.in);
		Scanner scanDou = new Scanner (System.in);
		//
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("||BIENVENIDO AL PROGRAMA PARA LA VETERINARIA MI PEQUEÑA MASCOTA||");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n\n");
		//
		int option = 0;
		boolean exit = false;
		while (!exit){
			menu();
			option = scanInt.nextInt();

			switch (option){
				case(1):
					System.out.println(vete.infoClientPet());
					break;
				case(2):
					exit = true;

					break;

				case (3):
					//Crear cliente

					System.out.println("DIGITE EL NOMBRE DEL CLIENTE: ");
					String namec = scanStr.nextLine();
					System.out.println("DIGITE SU IDENTIFICACION: ");
					int id = scanInt.nextInt();
					System.out.println("DIGITE LA DIRECCION DEL CLIENTE: ");
					String address = scanStr.nextLine();
					System.out.println("DIGITE EL TELEFONO DEL CLIENTE: ");
					String phone = scanStr.nextLine();

					Clients newClient = new Clients(namec, id, address , phone);
					System.out.println("OBJETO CREADO \n");
					vete.addClient(newClient);
					System.out.println("OBJETO INGRESADO SATISFACTORIAMENTE \n");
					break;

				case(4):
					//Crear pets
					boolean hospitalizatedBefore;
					boolean hospitalizatedNow;
					System.out.println(vete.shortInfoClient());
					int index = scanInt.nextInt();

					System.out.println("DIGITE EL NOMBRE DE LA MASCOTA");
					String name = scanStr.nextLine();
					System.out.println("DIGITE EL TIPO DE ANIMAL:");
					System.out.println("PERRO");
					System.out.println("GATO");
					System.out.println("AVE");
					System.out.println("OTRO");
					String type = scanStr.nextLine();
					System.out.println("DIGITE LA EDAD DEL ANIMAL");
					int age = scanInt.nextInt();
					System.out.println("DIGITE EL PESO EN KG");
					double weight = scanDou.nextDouble();
					System.out.println("DIGITE LA ALTURA DEL ANIMAL");
					double height = scanDou.nextDouble();
					System.out.println("HA ESTADO ANTES EN LA VETERINARIA");
					System.out.println("1. SI");
					System.out.println("2. NO");
					int i = scanInt.nextInt();
					if(i == 1){
						hospitalizatedBefore = true;
					}else if(i == 2){
						hospitalizatedBefore = false;
					}else{
						hospitalizatedBefore = false;
					}
					hospitalizatedNow = true;

					Pet pet = new Pet(name, type, age, weight, height, hospitalizatedBefore, hospitalizatedNow, null);

					vete.addPettoClient(pet, index);

				break;
				case(5):
					//crear historia clinica
					System.out.println("DIGITE EL DUEÑO DE LA MASCOTA QUE QUIERE AGREGARLE LA HISTORIA CLINICA: \n");
					System.out.println(vete.shortInfoClient());
					int indexClient = scanInt.nextInt();
					System.out.println("DIGITE LA MASCOTA A LA QUE QUIERE AGREGARLE LA HISTORIA CLINICA:\n");
					System.out.println(vete.shortInfoClientPet(indexClient));
					int indexPet = scanInt.nextInt();
					System.out.println("DIGITE EL SINTOMA DEL ANIMAL:\n");
					String symptomh = scanStr.nextLine();
					System.out.println("DIGITE EL DIAGNOSTICO DEL ANIMAL:\n");
					String diagnosish = scanStr.nextLine();
					System.out.println("DIGITE EL DIA DE ENTRADA:\n");
					int dayh = scanInt.nextInt();
					System.out.println("DIGITE EL MES DE ENTRADA:\n");
					int monthh = scanInt.nextInt();
					System.out.println("DIGITE EL ANIO DE ENTRADA:\n");
					int yearh = scanInt.nextInt();
					Dated histoDate1h = new Dated (dayh, monthh, yearh);
					String statush = "abierto";

					vete.createHistoryClinicPet(indexClient, indexPet, statush, symptomh, diagnosish, histoDate1h, null);

				break;
				case(6):
					System.out.println("DIGITE EL DUEÑO DE LA MASCOTA QUE QUIERE AGREGARLE LA MEDICINA: \n");
					System.out.println(vete.shortInfoClient());
					int iClient = scanInt.nextInt();
					System.out.println("DIGITE LA MASCOTA A LA QUE QUIERE AGREGARLE LA MEDICINA:\n");
					System.out.println(vete.shortInfoClientPet(iClient));
					int iPet = scanInt.nextInt();
					System.out.println("DIGITE EL NOMBRE DE LA MEDICINA: ");
					String namem = scanStr.nextLine();
					System.out.println("DIGITE LA DOSIS: ");
					double dosem = scanDou.nextDouble();
					System.out.println("DIGITE EL COSTO DE LA DOSIS: ");
					double doseCostm = scanDou.nextDouble();
					System.out.println("DIGITE LA FRECUENCIA: ");
					int frecuencym = scanInt.nextInt();

					Medicine newMed = new Medicine(namem, dosem, doseCostm, frecuencym);
					vete.addMedicine(iClient, iPet, newMed);
				break;
				case(7):
					String newHistory = "";
					System.out.println("DIGITE EL DUEÑO DE LA MASCOTA QUE QUIERE HOSPITALIZAR: \n");
					System.out.println(vete.shortInfoClient());
					int indexClientFH = scanInt.nextInt();
					System.out.println("DIGITE LA MASCOTA A LA QUE QUIERE HOSPITALIZAR:\n");
					System.out.println(vete.shortInfoClientPet(indexClientFH));
					int indexPetFH = scanInt.nextInt();
					//
					Pet addPet = vete.getPetToMini(indexClientFH, indexPetFH);
					// newHistory += vete.getHistoClinicSpecific(indexClientFH, indexPetFH);
					boolean ava = false;
					//
					MiniRoom miniWithPet = new MiniRoom (ava, addPet);
					System.out.println(vete.addPetToMini(miniWithPet));
				break;
				case(8):
					System.out.println(vete.show());
				break;
				case(9):
					System.out.println("DIGITE EL DUEÑO DE LA MASCOTA QUE QUIERE CALCULAR EL PRECIO: \n");
					System.out.println(vete.shortInfoClient());
					int indexClientCP = scanInt.nextInt();
					System.out.println("DIGITE LA MASCOTA A LA QUE QUIERE CALCULAR EL PRECIO:\n");
					System.out.println(vete.shortInfoClientPet(indexClientCP));
					int indexPetCP = scanInt.nextInt();
					System.out.println("DIGITE EL DIA DE HOY:\n");
					int dayT = scanInt.nextInt();
					System.out.println("DIGITE EL MES DE HOY:\n");
					int monthT = scanInt.nextInt();
					System.out.println("DIGITE EL ANIO DE HOY:\n");
					int yearT = scanInt.nextInt();
					System.out.println("\n");
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
					System.out.println("EL PRECIO DE DEBE ES: "+vete.calculatePriceOfPet(indexClientCP, indexPetCP, dayT, monthT, yearT));
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
					System.out.println("\n");
				break;
				case(10):
					System.out.println("DIGITE EL DUEÑO DE LA MASCOTA QUE QUIERE DAR DE ALTA: \n");
					System.out.println(vete.shortInfoClient());
					int indexClientDA = scanInt.nextInt();
					System.out.println("DIGITE LA MASCOTA A LA QUE QUIERE DAR DE ALTA:\n");
					System.out.println(vete.shortInfoClientPet(indexClientDA));
					int indexPetDA = scanInt.nextInt();
					String nameOfDischarge = vete.namePetSpecific(indexClientDA, indexPetDA);
					System.out.println("DIGITE EL DIA DE HOY:\n");
					int dayD = scanInt.nextInt();
					System.out.println("DIGITE EL MES DE HOY:\n");
					int monthD = scanInt.nextInt();
					System.out.println("DIGITE EL ANIO DE HOY:\n");
					int yearD = scanInt.nextInt();
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
					System.out.println("EL PRECIO DE DEBE ES: "+vete.calculatePriceOfPet(indexClientDA, indexPetDA, dayD, monthD, yearD));
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
					MiniRoom miniDischarge = new MiniRoom (true, null);
					System.out.println (vete.dischargeAPet(nameOfDischarge, miniDischarge));
				break;
				case (11):
					String phPa = "";
					String dirPa = "";
					//
					System.out.println("DIGITE EL DUEÑO QUE QUIERE ACTUALIZAR: \n");
					System.out.println(vete.shortInfoClient());
					int cliPa = scanInt.nextInt();
					System.out.println("QUIERE ACTUALIZAR TELEFONO?");
					System.out.println("1- SI");
					System.out.println("2- NO");
					int op = scanInt.nextInt();
					if (op == 1) {
						System.out.println("DIGITE EL NUEVO TELEFONO:");
						phPa = scanStr.nextLine();
					}else if (op == 2) {
						phPa = null;
					}else {
						System.out.println("ERROR");
						exit = true;
					}
					System.out.println("QUIERE ACTUALIZAR DIRECCION?");
					System.out.println("1- SI");
					System.out.println("2- NO");
					int op2 = scanInt.nextInt();
					if (op2 == 1) {
						System.out.println("DIGITE LA NUEVA DIRECCION:");
						dirPa = scanStr.nextLine();
					}else if (op2 == 2) {
						dirPa = null;
					}else {
						System.out.println("ERROR");
						exit = true;
					}
					//
					vete.updateClient(phPa, dirPa, cliPa);
				break;
				case (12):
					//
					System.out.println("DIGITE EL DUEÑO QUE QUIERE ACTUALIZAR: \n");
					System.out.println(vete.showShortInfoMini());
					int miniI = scanInt.nextInt();
					System.out.println("DIGITE EL SINTOMA QUE QUIERE AGREGAR: \n");
					String sym = scanStr.nextLine();
					//
					vete.changeSymptom(sym, miniI);
				break;
				case(13):
   					System.out.println("DIGITE EL ANIMAL QUE QUIERE AGREGAR NOTAS: \n");
				   	System.out.println(vete.showShortInfoMini());
				   	int indexMiniN = scanInt.nextInt();
				   	System.out.println("DIGITE LA NOTA QUE QUIERE AGREGAR: \n");
				   	String notes = scanStr.nextLine();
				   	//
				   	vete.addNotes(notes, indexMiniN);
				break;
				case (14):
					System.out.println("DIGITE EL DIA DE HOY:\n");
					int todayDays = scanInt.nextInt();
					System.out.println("DIGITE EL MES DE HOY:\n");
					int todayMonths = scanInt.nextInt();
					System.out.println("DIGITE EL ANIO DE HOY:\n");
					int todayYears = scanInt.nextInt();
					//
					System.out.println("QUE SERVICIO QUIERE REALIZAR?");
					System.out.println("1- BAÑO DE MASCOTA");
					System.out.println("2- BAÑO DE MASCOTA CON DOMICILIO");
					System.out.println("3- CORTE DE UNAS");
					System.out.println("4- PROFILIAXIS DENTAL");
					System.out.println("5- APLICACION DE VACUNAS");
					int indexService = scanInt.nextInt();
					String servv = "";
					if (indexService == 1){
						servv = "Bano veterinaria";
					}else if (indexService == 2) {
						servv = "Bano domicilio";
					}else if (indexService == 3) {
						servv = "Corte de uñas";
					}else if (indexService == 4) {
						servv = "Profilaxis Dental";
					}else if (indexService == 5) {
						servv = "Vacunas";
					}
					System.out.println("EL DUEÑO DE LA MASCOTA QUE QUIERE HACER EL SERVICIO \n");
					System.out.println(vete.shortInfoClient());
					int indexClientService = scanInt.nextInt();
					System.out.println("A QUE MASCOTA DESEA QUIERE HACER EL SERVICIO:\n");
					System.out.println(vete.shortInfoClientPet(indexClientService));
					int indexPetService = scanInt.nextInt();
					//
					vete.newService(servv, indexClientService, indexPetService, todayDays, todayMonths, todayYears);

				break;
				case (15):
					System.out.println("DIGITE EL DIA DE HOY:\n");
					int todayDay = scanInt.nextInt();
					System.out.println("DIGITE EL MES DE HOY:\n");
					int todayMonth = scanInt.nextInt();
					System.out.println("DIGITE EL ANIO DE HOY:\n");
					int todayYear = scanInt.nextInt();
					System.out.println("LOS INGRESOS TOTALES DE LA VETERINARIA SON: "+vete.calcTotalIncome(todayDay, todayMonth, todayYear));
				break;
				case (16):
					System.out.println("EL PROMEDIO DEL SERVICIO Bano veterinaria: "+vete.averageServicesIncome("Bano veterinaria")+"\n");
					System.out.println("EL PROMEDIO DEL SERVICIO Bano domicilio: "+vete.averageServicesIncome("Bano domicilio")+"\n");
					System.out.println("EL PROMEDIO DEL SERVICIO Corte de uñas: "+vete.averageServicesIncome("Corte de uñas")+"\n");
					System.out.println("EL PROMEDIO DEL SERVICIO Profilaxis Dental: "+vete.averageServicesIncome("Profilaxis Dental")+"\n");
					System.out.println("EL PROMEDIO DEL SERVICIO Vacunas: "+vete.averageServicesIncome("Vacunas")+"\n");
				break;
				default:
					System.out.println ("DIGITO NO VALIDO");
			}
		}
	}

	public void menu(){

		System.out.println("|||||||||||||||||||||| MENU ||||||||||||||||||||||");
		System.out.println("1.  MOSTRAR LA INFORMACION DE LA VETERINARIA");
		System.out.println("2.  PARA SALIR DEL MENU");
		System.out.println("3.  PARA CREAR CLIENTE");
		System.out.println("4.  PARA AGREGAR ANIMAL A CLIENTE");
		System.out.println("5.  PARA AGREGAR HISTORIA CLINICA");
		System.out.println("6.  PARA AGREGAR NUEVA MEDICINA");
		System.out.println("7.  PARA HOSPITALIZAR");
		System.out.println("8.  MOSTRAR LA INFORMACION DE LOS CUARTOS");
		System.out.println("9.  PARA SABER EL PRECIO DE LA ESTADIA DEL ANIMAL");
		System.out.println("10. PARA DAR DE ALTA A UN ANIMAL");
		System.out.println("11. PARA ACTUALIZAR TELEFONO Y DIRECCION DEL CLIENTE");
		System.out.println("12. PARA AGREGAR UN NUEVO SINTOMA");
		System.out.println("13. PARA AGREGAR NOTAS");
		System.out.println("14. REALIZAR UN SERVICIO");
		System.out.println("15. SABER EL TOTAL DE INGRESOS: ");
		System.out.println("16. SABER EL PROMEDIO DE LOS INGRESOS DE SERVICIOS");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||");
	}
}
