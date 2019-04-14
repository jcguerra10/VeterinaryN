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
	public Veterinary (String name){
		this.name = name;
		client = new ArrayList<Clients>();
		mini = new MiniRoom[MINI_ROOM];

		mini[0] = new MiniRoom (true, null, null);
		mini[1] = new MiniRoom (true, null, null);
		mini[2] = new MiniRoom (true, null, null);
		mini[3] = new MiniRoom (true, null, null);
		mini[4] = new MiniRoom (true, null, null);
		mini[5] = new MiniRoom (true, null, null);
		mini[6] = new MiniRoom (true, null, null);
		mini[7] = new MiniRoom (true, null, null);


		// mini = new ArrayList<MiniRoom>();
	}
	//get set
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public ArrayList<Clients> getClient(){
		return client;
	}
	public void setClient(ArrayList <Clients>client){
		this.client = client;
	}
	public MiniRoom[]getMini(){
		return mini;
	}
	public void setMini(MiniRoom[]mini){
		this.mini = mini;
	}

	//methods

	public String addClient(Clients newClient){
		String msg = "";
		client.add(newClient);
		msg += "SE HA CREADO EL NUEVO CLIENTE";
		return msg;
	}

	public String addPettoClient(Pet newPet, int index){
		String msg = "";
		client.get(index).addPet(newPet);
		msg += "SE HA CREADO EL NUEVO ANIMAL";
		return msg;
	}

	public String infoClientPet(){
		String msg = "";
		if(client.isEmpty() == false){
			for(int i=0;i<client.size(); i++){
				msg += client.get(i).infoClientWithPet();
			}
		}
		return msg;
	}

	public String shortInfoClient(){
		String msg = "";
		if(client.isEmpty() == false){
			for(int i=0;i<client.size(); i++){
				msg += i + ")" + client.get(i).getName()+"\n";
			}
		}
		return msg;
	}

	public String shortInfoClientPet(int indexClient){
		String msg = "";

		msg += client.get(indexClient).shortInfoPet()+"\n";

		return msg;
	}

	public String namePetSpecific(int indexClientDA, int indexPetDA){
		String msg ="";
		msg += client.get(indexClientDA).getPetName(indexPetDA);
		return msg;
	}

	// public String createHistoryClinicPet(indexClient, indexPet){
		// String msg = "";

		// msg += client.get(indexclient).createHistoryClinicPet(indexPet);
		// return msg;
	// }


	public void createHistoryClinicPet(int indexClient, int indexPet, String statush, String symptomh, String diagnosish, Dated histoDate1h, Dated histoDate2h){
		if(client != null){
			client.get(indexClient).createHistoryClinicPet(indexPet, statush, symptomh, diagnosish, histoDate1h, histoDate2h);
		}
	}

	public void addMedicine(int iClient, int iPet, Medicine newMed){
		if(client!=null){
			client.get(iClient).addMedicine(iPet, newMed);
		}
	}


	public String showHistoInMiniRooms(){
		String msg = "";

		for(int i=0;i<mini.length;i++){
			//if(mini[i]!=null){
				msg += mini[i].getHistoClinic()+"\n";
			//}

		}
		return msg;
	}
	public Pet getPetToMini(int indexClientFH, int indexPetFH){
		return client.get(indexClientFH).getPet(indexPetFH);
	}

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

	public String show(){
		String msg = "";
		for(int i=0;i<mini.length;i++){
			msg += mini[i].getMiniRoom();
		}
		return msg;
	}

	public double calculatePriceOfPet(int indexClientCP, int indexPetCP, int dayT, int monthT, int yearT){
		double tot = 0.0;

		tot += client.get(indexClientCP).calculatePriceOfPet(indexPetCP, dayT, monthT, yearT);

		return tot;
	}

	public String dischargeAPet(String nameOfDischarge, MiniRoom miniDischarge){
		String msg = "";
		for(int i=0;i<mini.length; i++){
			if(mini!=null){
				if(mini[i].showNamePet().equals(nameOfDischarge)){
					mini[i]=miniDischarge;
					msg += "SE HA DADO DE ALTA AL ANIMAL";
				}
			}
		}
		return msg;
	}

	public void updateClient(String phPa, String dirPa, int cliPa){
		client.get(cliPa).updateClient(phPa, dirPa);
	}


}
