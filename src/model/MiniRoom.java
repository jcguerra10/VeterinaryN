//LABORATORIO No4.
//PROGRAMA HECHO POR JUAN CAMILO GUERRA TABARES
//ESTUDIANTE DE LA UNIVERSIDAD ICESI
package model;
import java.util.*;
//attributes
public class MiniRoom{
	private boolean available;
	private String histoClinic;
	//
	private Pet pet;
	//
	public MiniRoom(boolean available, Pet pet){
		this.available = available;
		this.pet = pet;
	}
	//get set
	public boolean getAvailable(){
		return available;
	}
	public void setAvailable(boolean available){
		this.available = available;
	}

	public Pet getPet(){
		return pet;
	}
	public void setPet(Pet pet){
		this.pet = pet;
	}
	// methods
	public String getMiniRoom(){
		String msg = "";

		msg += "========================== CUARTO ==========================\n";
		if(available == false){
			msg += "DISPONIBILIDAD: NO HAY DISPONIBILIDAD \n";
		}else{
			msg += "DISPONIBILIDAD: SI HAY DISPONIBILIDAD \n";
		}
		if(pet!=null){
			msg += pet.getClinicHistoryPet()+"\n";
		}else{
			msg += "NO HAY ANIMAL O NO EXISTE ALGUNA HISTORIA CLINICA\n";
		}
		return msg;
	}
	public String showNamePet(){
		String msg ="";
		if(pet!=null)
			msg += pet.getName();
		return msg;
	}
	public String getHistoClinic(){
		String msg = "";
		if (pet != null){
			msg += pet.getClinicHistoryPet();
		}
		return msg;
	}
	public void changeSymptom(String newSymp){
		pet.changeSymptom(newSymp);
	}



}
