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
	/**
	 *
	 * @param available
	 * @param pet
	 */
	public MiniRoom(boolean available, Pet pet){
		this.available = available;
		this.pet = pet;
	}
	//get set
	/**
	 *
	 * @return available
	 */
	public boolean getAvailable(){
		return available;
	}
	/**
	 *
	 * @param available
	 */
	public void setAvailable(boolean available){
		this.available = available;
	}

	/**
	 *
	 * @return pet
	 */
	public Pet getPet(){
		return pet;
	}
	/**
	 *
	 * @param pet
	 */
	public void setPet(Pet pet){
		this.pet = pet;
	}
	// methods

	/**
	 * Description: get the information of the MiniRoom
	 * @return msg
	 */
	public String getMiniRoom(){
		String msg = "";

		msg += "========================== CUARTO ===========================\n";
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

	/**
	 * Description: allows to know the name of the animal in the MiniRoom
	 * @return msg
	 */
	public String showNamePet(){
		String msg ="";
		if(pet!=null)
			msg += pet.getName();
		return msg;
	}

	/**
	 * Description: search in pet the method changeHisto()
	 * @param dischargeDate it is the discharge date
	 */
	public void changeHisto(Dated dischargeDate){
		pet.changeHisto(dischargeDate);
	}
	/**
	 * Description: get the clinic histo of the pet
	 * @return msg
	 */
	public String getHistoClinic(){
		String msg = "";
		if (pet != null){
			msg += pet.getClinicHistoryPet();
		}
		return msg;
	}

	/**
	 * Description: search in pet the method changeSymptom()
	 * @param newSymp it is the new symptom to add
	 */
	public void changeSymptom(String newSymp){
		pet.changeSymptom(newSymp);
	}

	/**
	 * Description: search in pet the method addNotes()
	 * @param newNotes it is the new notes to add
	 */
	public void addNotes(String newNotes){
   		pet.addNotes(newNotes);
	}

}
