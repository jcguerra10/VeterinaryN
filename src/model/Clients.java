//LABORATORIO No4.
//PROGRAMA HECHO POR JUAN CAMILO GUERRA TABARES
//ESTUDIANTE DE LA UNIVERSIDAD ICESI
package model;
import java.util.*;
//attributes
public class Clients{
	private String name;
	private int id;
	private String address;
	private String phone;
	//relations
	private ArrayList<Pet>pet;
	//constructor

	/**
	 *
	 * @param name
	 * @param id
	 * @param address
	 * @param phone
	 */
	public Clients(String name, int id, String address, String phone){
		this.name = name;
		this.id = id;
		this.address = address;
		this.phone = phone;
		pet = new ArrayList<Pet>();
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
	 * @return id
	 */
	public int getId(){
		return id;
	}
	/**
	 *
	 * @param id
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 *
	 * @return address
	 */
	public String getAddress(){
		return address;
	}
	/**
	 *
	 * @param address
	 */
	public void setAddress(String address){
		this.address = address;
	}

	/**
	 *
	 * @return phone
	 */
	public String getPhone(){
		return phone;
	}
	/**
	 *
	 * @param phone
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 *
	 * @return pet
	 */
	public ArrayList getPet(){
		return pet;
	}
	/**
	 *
	 * @param pet
	 */
	public void setPet(ArrayList <Pet>pet){
		this.pet = pet;
	}

	//methods

	/**
	 * Description: this method allows to add a new pet
	 * @param newPet
	 */
	public void addPet(Pet newPet){
		pet.add(newPet);
	}

	/**
	 * Description: show the information of the client
	 * @return msg
	 */
	public String infoClientWithPet(){
		String msg = "";
		msg += "======================================================\n";
		msg += "EL NOMBRE DEL CLIENTE ES: "+name+"\n";
		msg += "SU IDENTIDICACION ES: "+id+"\n";
		msg += "LA DIRECCION: "+address+"\n";
		msg += "SU TELEFONO: "+phone+"\n";
		msg += "><><><><><><><><><><><><><><><><><><><><><><><><><><><\n";
		if(pet.isEmpty()==false){
			for(int i=0;i<pet.size(); i++){
				msg += pet.get(i).infoPet();
			}
		}
		return msg;
	}
	/**
	 * Description: show the pet name with the index in the arraylist
	 * @return msg
	 */
	public String shortInfoPet(){
		String msg = "";

		if(pet.isEmpty()==false){
			for(int i=0;i<pet.size(); i++){
				msg += i + ")" + pet.get(i).getName()+"\n";
			}
		}
		return msg;
	}

	/**
	 * Description: get the pet name with the index of it
	 * @param indexPetDA
	 * @return msg
	 */
	public String getPetName(int indexPetDA){
		String msg = "";
		msg += pet.get(indexPetDA).getName();
		return msg;
	}

	/**
	 * Description: this allows to get the clinic history
	 * @return msg
	 */
	public String getTotalClinicHistory(){
		String msg = "";
		if(pet != null){
			for(int i=0;i<pet.size(); i++){
				msg += pet.get(i).getClinicHistoryPet();
				return msg;
			}
		}

		return msg;
	}

	/**
	 * Description: search an especific pet to add the clinic history
	 * @param indexPet
	 * @param statush
	 * @param symptomh
	 * @param diagnosish
	 * @param histoDate1h
	 * @param histoDate2h
	 */
	public void createHistoryClinicPet(int indexPet, String statush, String symptomh, String diagnosish, Dated histoDate1h, Dated histoDate2h){
		if(pet!=null){
			pet.get(indexPet).addHistoInfo(statush, symptomh, diagnosish, histoDate1h, histoDate2h);
		}
	}

	public void addMedicine(int iPet, Medicine newMed){
		if(pet!=null){
			pet.get(iPet).addMedicine(newMed);
		}
	}

	//HISTORIACLINICA
	/**
	 * Description: show the info of the client
	 * @return msg
	 */
	public String histoClinic(){
		String msg = "";
		msg += "|||HISTORIA CLINICA DEL ANIMAL||||\n";
		msg += "|||||||||||INFO CLIENTE|||||||||||\n";
		msg += "NOMBRE: "+name+"\n";
		msg += "ID: "+id+"\n";
		msg += "DIRECCION DE RESIDENCIA: "+address+"\n";
		msg += "CONTACTO: "+phone+"\n";

		return msg;
	}

	/**
	 * Description: this method allowas to get an especific pet
	 * @param indexPetFH this is the index of the pet
	 * @return Pet
	 */
	public Pet getPet(int indexPetFH){
		return pet.get(indexPetFH);
	}

	/**
     * Description: search an especific pet to change the status
     * @param indexPetFH
     * @param status
     */
	public void changeStatus(int indexPetFH, boolean status){
		pet.get(indexPetFH).changeStatus(status);
	}

	/**
	 * Description: search an especific pet to get the income for the pet
	 * @param indexPetCP
	 * @param dayT
	 * @param monthT
	 * @param yearT
	 * @return tot
	 */
	public double calculatePriceOfPet(int indexPetCP, int dayT, int monthT, int yearT){
		double tot = 0.0;
		tot+=pet.get(indexPetCP).calculatePriceOfPet(dayT, monthT, yearT);
		return tot;
	}
	/**
	 *Description This method allows to update the basic data of a veterinary client, these data include, address and
	 *phone number.
	 *pre: The client was created before.
	 *post: The address and /or phone number of the client is updated.
	 *@param The new address of the client. This param could be empty.
	 *@param The new phone number of the client. This param could be empty.
	 */
	public void updateClient(String phPa, String dirPa){
		if (phPa != null) {
			setPhone(phPa);
		}if (dirPa != null) {
			setAddress(dirPa);
		}
	}

	/**
	 * Description: search an espcefic pet to find the method newService()
	 * @param servv
	 * @param indexPetService
	 * @param todayDays
	 * @param todayMonths
	 * @param todayYears
	 */
	public void newService(String servv, int indexPetService, int todayDays, int todayMonths, int todayYears){
		pet.get(indexPetService).newService(servv, getId(), todayDays, todayMonths, todayYears);
	}

	/**
	 * Description: gets the total income of all the pets
	 * @param dayCO
	 * @param monthCO
	 * @param yearCO
	 * @return
	 */
	public double calcTotalPetIncome(int dayCO, int monthCO, int yearCO){
		double tot = 0.0;
		if (pet!=null) {
			for (int i=0;i<pet.size();i++) {
				tot += pet.get(i).calculatePriceOfPet(dayCO, monthCO, yearCO);
			}
			for (int k=0;k<pet.size();k++) {
				tot += pet.get(k).totService();
			}
		}
		return tot;
	}

	/**
	 * Description: get the average of income frome services
	 * @param typeS
	 * @return tot
	 */
	public double averageServicesIncome(String typeS){
		double tot = 0.0;
		if (pet!=null) {
			for (int i=0;i<pet.size();i++) {
				tot += pet.get(i).averageServicesIncome(typeS);
			}
		}
		return tot;
	}

	/**
	 * Description: get and calculate the average of all income from pets
	 * @param todayDayA
	 * @param todayMonthA
	 * @param todayYearA
	 * @param todayDayB
	 * @return average
	 */
	public double averageOfWeek(int todayDayA, int todayMonthA, int todayYearA, int todayDayB){
		double average = 0.0;
		int index = 0;
		if (pet!=null) {
			for (int i=0;i<pet.size();i++) {
				if (pet.get(i).averageOfWeek(todayDayA, todayMonthA, todayYearA, todayDayB) != 0) {
					average += pet.get(i).averageOfWeek(todayDayA, todayMonthA, todayYearA, todayDayB);
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
	 * Description: get all the services provided between to dates
	 * @param todayDayA the first day
	 * @param todayMonthA the firt month
	 * @param todayYearA the first year
	 * @param todayDayB the second day
	 * @param todayMonthB the second month
	 * @param todayYearB the second year
	 * @return
	 */
	public String servicesProvided(int todayDayA, int todayMonthA, int todayYearA, int todayDayB, int todayMonthB, int todayYearB){
		String msg = "";
		if (pet != null) {
			for (int i=0;i<pet.size();i++) {
				msg += pet.get(i).servicesProvided(todayDayA, todayMonthA, todayYearA, todayDayB, todayMonthB, todayYearB)+"\n";
			}
		}
		return msg;
	}

}
