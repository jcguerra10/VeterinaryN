//LABORATORIO No4.
//PROGRAMA HECHO POR JUAN CAMILO GUERRA TABARES
//ESTUDIANTE DE LA UNIVERSIDAD ICESI
package model;
import java.util.*;

public class Veterinary{
	public static final int MINI_ROOM = 8;
	private String name;
	//relations
	private ArrayList<Clients>client;
	private MiniRoom[]mini;
	//constructor
	/**
	 *
	 * @param name
	 */
	public Veterinary (String name){
		this.name = name;
		client = new ArrayList<Clients>();
		Clients juan = new Clients("Juan Camilo", 1006035126, "cll 16 #101", "3012391474");
		client.add(juan);
		Pet paca = new Pet("paquita", "perro", 10, 6, 1.2, true, false, null);
		addPettoClient(paca, 0);
		Pet luna = new Pet("luna", "gato", 9, 5, 0.9, false, false, null);
		addPettoClient(luna, 0);
		Clients isabella = new Clients("isabella", 1006588756, "cll 6 #51", "3212874174");
		client.add(isabella);

		//
		mini = new MiniRoom[MINI_ROOM];

		mini[0] = new MiniRoom (true, null);
		mini[1] = new MiniRoom (true, null);
		mini[2] = new MiniRoom (true, null);
		mini[3] = new MiniRoom (true, null);
		mini[4] = new MiniRoom (true, null);
		mini[5] = new MiniRoom (true, null);
		mini[6] = new MiniRoom (true, null);
		mini[7] = new MiniRoom (true, null);
	}
	//get set
	/**
    *
    * @return name
    */
	public String getName(){
		return name;
	}
	/**
    *
    * @param name
    */
	public void setName(String name){
		this.name = name;
	}
    /**
    *
    * @return client
    */
	public ArrayList<Clients> getClient(){
		return client;
	}
    /**
    *
    * @param client
    */
	public void setClient(ArrayList <Clients>client){
		this.client = client;
	}

    /**
    *
    * @return mini
    */
	public MiniRoom[]getMini(){
		return mini;
	}
    /**
    *
    * @param mini
    */
	public void setMini(MiniRoom[]mini){
		this.mini = mini;
	}

	//methods
	/**
	 *
	 * post: add a new client
	 * @param newClient
	 * @return msg
	 */
	public String addClient(Clients newClient){
		String msg = "";
		client.add(newClient);
		msg += "SE HA CREADO EL NUEVO CLIENTE";
		return msg;
	}
	/**
	 * Description: look for the pet indicated
	 * @param newPet
	 * @param index
	 * @return msg
	 */
	public String addPettoClient(Pet newPet, int index){
		String msg = "";
		client.get(index).addPet(newPet);
		msg += "SE HA CREADO EL NUEVO ANIMAL";
		return msg;
	}
	/**
	 * Description: get the information of the client with pet
	 * @return msg
	 */
	public String infoClientPet(){
		String msg = "";
		if(client.isEmpty() == false){
			for(int i=0;i<client.size(); i++){
				msg += client.get(i).infoClientWithPet();
			}
		}
		return msg;
	}
	/**
	  * Description: get the name of the client with the index in the ArrayList
	  * @return msg
	  */
	public String shortInfoClient(){
		String msg = "";
		if(client.isEmpty() == false){
			for(int i=0;i<client.size(); i++){
				msg += i + ")" + client.get(i).getName()+"\n";
			}
		}
		return msg;
	}
	/**
	 * Description: search the client with the parameter
	 * @param indexClient
	 * @return msg
	 */
	public String shortInfoClientPet(int indexClient){
		String msg = "";

		msg += client.get(indexClient).shortInfoPet()+"\n";

		return msg;
	}
	/**
	 * Description: search the client with the parameter
	 * @param indexClientDA
	 * @param indexPetDA
	 * @return msg
	 */
	public String namePetSpecific(int indexClientDA, int indexPetDA){
		String msg ="";
		msg += client.get(indexClientDA).getPetName(indexPetDA);
		return msg;
	}
	/**
	 * Description: search the client with the parameter
	 * @param indexClient
	 * @param indexPet
	 * @param statush
	 * @param symptomh
	 * @param diagnosish
	 * @param histoDate1h
	 * @param histoDate2h
	 */
	public void createHistoryClinicPet(int indexClient, int indexPet, String statush, String symptomh, String diagnosish, Dated histoDate1h, Dated histoDate2h){
		if(client != null){
			client.get(indexClient).createHistoryClinicPet(indexPet, statush, symptomh, diagnosish, histoDate1h, histoDate2h);
		}
	}
	/**
	 * Description: search the client with the parameter
	 * @param iClient
	 * @param iPet
	 * @param newMed
	 */
	public void addMedicine(int iClient, int iPet, Medicine newMed){
		if(client!=null){
			client.get(iClient).addMedicine(iPet, newMed);
		}
	}

	/**
	 * Description: search the client with the parameter and get the clinic history
	 * @return msg
	 */
	public String showHistoInMiniRooms(){
		String msg = "";

		for(int i=0;i<mini.length;i++){
			//if(mini[i]!=null){
				msg += mini[i].getHistoClinic()+"\n";
			//}

		}
		return msg;
	}

	/**
	 * Description: search the client with the parameter and get a especific pet in MiniRoom
	 * @param indexClientFH
	 * @param indexPetFH
	 * @return
	 */
	public Pet getPetToMini(int indexClientFH, int indexPetFH){
		return client.get(indexClientFH).getPet(indexPetFH);
	}
	/**
	 * Description: add a Pet to MiniRoom
	 * @param miniWithPet
	 * @return
	 */
	public String addPetToMini(MiniRoom miniWithPet){
		String msg = "";
		int exit=0;
		int i = 0;
		while(exit==0&&i<mini.length){
			if(mini[i].getAvailable()==true){
				mini[i]=miniWithPet;
				exit = 1;
				msg += "SE AGREGO EL ANIMAL AL CUARTO";
			}else{
				i++;
			}
		}
		return msg;
	}
	/**
	 * Description: search the client with the parameter
	 * @param indexClientFH
	 * @param indexPetFH
	 * @param status
	 */
	public void changeStatus(int indexClientFH, int indexPetFH, boolean status){
		client.get(indexClientFH).changeStatus(indexPetFH, status);
	}
	/**
	 * Description: get the information of all MiniRooms
	 * @return msg
	 */
	public String show(){
		String msg = "";
		for(int i=0;i<mini.length;i++){
			msg += mini[i].getMiniRoom();
		}
		return msg;
	}
	/**
	 * Description: search the client with the parameter
	 * @param indexClientCP
	 * @param indexPetCP
	 * @param dayT
	 * @param monthT
	 * @param yearT
	 * @return tot
	 */
	public double calculatePriceOfPet(int indexClientCP, int indexPetCP, int dayT, int monthT, int yearT){
		double tot = 0.0;

		tot += client.get(indexClientCP).calculatePriceOfPet(indexPetCP, dayT, monthT, yearT);

		return tot;
	}

	/**
	 * Description: discharge a Pet and search the method changeHisto()
	 * @param nameOfDischarge
	 * @param miniDischarge
	 * @param dischargeDate
	 * @return msg
	 */
	public String dischargeAPet(String nameOfDischarge, MiniRoom miniDischarge, Dated dischargeDate){
		String msg = "";
		for(int i=0;i<mini.length; i++){
			if(mini!=null){
				if(mini[i].showNamePet().equals(nameOfDischarge)){
					mini[i].changeHisto(dischargeDate);
					mini[i] = miniDischarge;
					msg += "SE HA DADO DE ALTA AL ANIMAL";
				}
			}
		}
		return msg;
	}
	/**
	 * Description: search the client with the parameter
	 * @param phPa
	 * @param dirPa
	 * @param cliPa
	 */
	public void updateClient(String phPa, String dirPa, int cliPa){
		client.get(cliPa).updateClient(phPa, dirPa);
	}
	/**
	 * Description: search the client with the parameter
	 * @param newSymp
	 * @param indexMini
	 */
	public void changeSymptom(String newSymp, int indexMini){
		if (mini[indexMini]!=null) {
			mini[indexMini].changeSymptom(newSymp);
		}
	}
	/**
	 * Description: get the name of the Pet of each MiniRoom
	 * @return
	 */
	public String showShortInfoMini(){
		String msg = "";
		for(int i=0;i<mini.length;i++){
			msg += i +"-"+mini[i].showNamePet()+"\n";
		}
		return msg;
	}
	/**
	 * Description: search a MiniRoom with the parameter
	 * @param newNotes
	 * @param iPet
	 */
	public void addNotes(String newNotes, int iPet){
   		mini[iPet].addNotes(newNotes);
	}
	/**
	 * Description: search the client with the parameter
	 * @param servv
	 * @param indexClientService
	 * @param indexPetService
	 * @param todayDays
	 * @param todayMonths
	 * @param todayYears
	 */
	public void newService(String servv, int indexClientService, int indexPetService, int todayDays, int todayMonths, int todayYears){
		client.get(indexClientService).newService(servv, indexPetService, todayDays, todayMonths, todayYears);
	}
	/**
	 * Description: get method calcTotalPetIncome() of each Client
	 * @param todayDay
	 * @param todayMonth
	 * @param todayYear
	 * @return
	 */
	public double calcTotalIncome(int todayDay, int todayMonth, int todayYear){
		double tot = 0.0;
		if (client!=null) {
			for (int i=0;i<client.size();i++) {
				tot += client.get(i).calcTotalPetIncome(todayDay, todayMonth, todayYear);
			}
		}
		return tot;
	}
	/**
	 * Description: get method averageServicesIncome() of each Client
	 * @param typeS
	 * @return
	 */
	public double averageServicesIncome(String typeS){
		double tot = 0.0;
		int div = 0;
		if (client!=null) {
			for (int i=0;i<client.size();i++) {
				tot += client.get(i).averageServicesIncome(typeS);
				div++;
			}
			tot = tot/div;
		}
		return tot;
	}
	/**
	 * Description: get method averageOfWeek() of each Client
	 * @param todayDayA
	 * @param todayMonthA
	 * @param todayYearA
	 * @param todayDayB
	 * @return
	 */
	public double averageOfWeek(int todayDayA, int todayMonthA, int todayYearA, int todayDayB){
		double average = 0.0;
		int index = 0;
		if (client != null) {
			for (int i=0;i<client.size();i++) {
				if (client.get(i).averageOfWeek(todayDayA, todayMonthA, todayYearA, todayDayB) != 0) {
					average += client.get(i).averageOfWeek(todayDayA, todayMonthA, todayYearA, todayDayB);
					index += 1;
				}
			}
		}
		if (average != 0) {
			average = average/index;
		}
		return average;
	}
	/**
	 * Description: get method servicesProvided() of each Client
	 * @param todayDayA
	 * @param todayMonthA
	 * @param todayYearA
	 * @param todayDayB
	 * @param todayMonthB
	 * @param todayYearB
	 * @return
	 */
	public String servicesProvided(int todayDayA, int todayMonthA, int todayYearA, int todayDayB, int todayMonthB, int todayYearB){
		String msg = "";
		if (client != null) {
			for (int i=0;i<client.size();i++) {
				msg += client.get(i).servicesProvided(todayDayA, todayMonthA, todayYearA, todayDayB, todayMonthB, todayYearB)+"\n";
			}
		}
		return msg;
	}

}
