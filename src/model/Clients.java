//LABORATORIO No3.
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
	public Clients(String name, int id, String address, String phone){
		this.name = name;
		this.id = id;
		this.address = address;
		this.phone = phone;
		pet = new ArrayList<Pet>();
	}
	//get set
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public int getId(){
		return id;
	}
	public void setId(){
		this.id = id;
	}

	public String getAddress(){
		return address;
	}
	public void setAddress(){
		this.address = address;
	}

	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public ArrayList getPet(){
		return pet;
	}
	public void setPet(ArrayList <Pet>pet){
		this.pet = pet;
	}

	//methods

	public void addPet(Pet newPet){
		pet.add(newPet);
	}

	public String infoClientWithPet(){
		String msg = "";

		msg += "EL NOMBRE DEL CLIENTE ES: "+name+"\n";
		msg += "SU IDENTIDICACION ES: "+id+"\n";
		msg += "LA DIRECCION: "+address+"\n";
		msg += "SU TELEFONO: "+phone+"\n";
		msg += "--------------------------------------------\n\n";
		if(pet.isEmpty()==false){
			for(int i=0;i<pet.size(); i++){
				msg += pet.get(i).infoPet();
			}
		}
		return msg;
	}

	public String shortInfoPet(){
		String msg = "";

		if(pet.isEmpty()==false){
			for(int i=0;i<pet.size(); i++){
				msg += i + ")" + pet.get(i).getName()+"\n";
			}
		}
		return msg;
	}
	public String getPetName(int indexPetDA){
		String msg = "";
		msg += pet.get(indexPetDA).getName();
		return msg;
	}

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

	public String histoClinic(){
		String msg = "";
		msg += "|||HISTORIA CLINICA DEL ANIMAL||||\n";
		msg += "|||||||||||INFO CLIENTE|||||||||||\n";
		msg += "NOMBRE: "+name+"\n";
		msg += "ID: "+id+"\n";
		msg += "DIRECCION DE RESIDENCIA: "+address+"\n";
		msg += "CONTACTO: "+phone+"\n";
		// if(pet!=null){
			// msg += pet.get(indexPetFH).getClinicHistoryPet();
		// }
		return msg;
	}

	public Pet getPet(int indexPetFH){
		return pet.get(indexPetFH);
	}

	public double calculatePriceOfPet(int indexPetCP, int dayT, int monthT, int yearT){
		double tot = 0.0;
		tot+=pet.get(indexPetCP).calculatePriceOfPet(dayT, monthT, yearT);
		return tot;
	}

}
