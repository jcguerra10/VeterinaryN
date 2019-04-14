//LABORATORIO No4.
//PROGRAMA HECHO POR JUAN CAMILO GUERRA TABARES
//ESTUDIANTE DE LA UNIVERSIDAD ICESI
package model;
import java.util.*;
//
public class Pet{
	public static final double KG1 = 1.0;
	public static final double KG12 = 3.0;
	public static final double KG2 = 3.1;
	public static final double KG22 = 10.0;
	public static final double KG3 = 10.1;
	public static final double KG32 = 20;
	//
	public static final double PRICE1G = 10000.0;
	public static final double PRICE2G= 12000.0;
	public static final double PRICE3G = 15000.0;
	public static final double PRICE4G = 20000.0;
	//
	public static final double PRICE1P = 15000.0;
	public static final double PRICE2P= 17000.0;
	public static final double PRICE3P = 20000.0;
	public static final double PRICE4P = 25000.0;
	//
	public static final double PRICE1A = 10000.0;
	public static final double PRICE2A= 12000.0;
	public static final double PRICE3A = 20000.0;
	public static final double PRICE4A = 25000.0;
	//
	public static final double PRICE1O = 15000.0;
	public static final double PRICE2O= 17000.0;
	public static final double PRICE3O = 20000.0;
	public static final double PRICE4O = 25000.0;
	//
	public static final String DOG = "perro";
	public static final String CAT = "gato";
	public static final String BIRD = "ave";
	public static final String OTHER = "otro";
	//
	//
	//
	private String name;
	private String type;
	private int age;
	private double weight;
	private double height;
	private boolean hospitalizatedBefore;
	private boolean hospitalizatedNow;
	//
	private ClinicHistory histo;
	private Clients cli;
	//
	public Pet(String name, String type, int age, double weight, double height, boolean hospitalizatedBefore, boolean hospitalizatedNow, ClinicHistory histo){
		this.name = name;
		this.type = type;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.hospitalizatedBefore = hospitalizatedBefore;
		this.hospitalizatedNow = hospitalizatedNow;
		this.histo = histo;
	}
	//get set
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}

	public int getAge(){
		return age;
	}
	public void setType(int age){
		this.age = age;
	}

	public double getWeight(){
		return weight;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getHeight(){
		return height;
	}
	public void setHeight(double height){
		this.height = height;
	}

	public boolean getHospitalizatedBefore(){
		return hospitalizatedBefore;
	}
	public void setHospitalizatedBefore(boolean hospitalizatedBefore){
		this.hospitalizatedBefore = hospitalizatedBefore;
	}

	public boolean getHospitalizatedNow(){
		return hospitalizatedNow;
	}
	public void setHospitalizatedNow(boolean hospitalizatedNow){
		this.hospitalizatedNow = hospitalizatedNow;
	}

	public ClinicHistory getHisto(){
		return histo;
	}
	public void setHisto(ClinicHistory histo){
		this.histo = histo;
	}
	public Clients getCli(){
		return cli;
	}
	public void setCli(Clients Cli){
		this.cli = cli;
	}

	//methods
	public void addHistoInfo(String statush, String symptomh, String diagnosish, Dated histoDate1h, Dated histoDate2h){
		ClinicHistory histoh = new ClinicHistory(statush, symptomh, diagnosish, histoDate1h, histoDate2h);
		setHisto(histoh);
	}

	public String infoPet(){
		String msg = "";
		msg += "=====================================================\n";
		msg += "=====================================================\n";
		if(type.equals(DOG)){
			msg += "EL NOMBRE DEL ANIMAL TIPO "+DOG+" ES: "+name+"\n";
		}else if(type.equals(CAT)){
			msg += "EL NOMBRE DEL ANIMAL TIPO "+CAT+" ES: "+name+"\n";
		}else if(type.equals(BIRD)){
			msg += "EL NOMBRE DEL ANIMAL TIPO "+BIRD+" ES: "+name+"\n";
		}else {
			msg += "EL NOMBRE DEL ANIMAL TIPO "+OTHER+" ES: "+name+"\n";
		}
		msg += "SU EDAD ES: "+age+"\n";
		msg += "PESA: "+weight+"\n";
		if(hospitalizatedBefore == true){
			msg += "EL ANIMAL HA ESTADO HOSPITALIZADO ANTES \n";
		}else{
			msg += "EL ANIMAL NO HA ESTADO HOSPITALIZADO ANTES\n";
		}
		if(hospitalizatedNow == true){
			msg += "EL ANIMAL ESTA HOSPITALIZADO \n";
		}else{
			msg += "EL ANIMAL ESTA HOSPITALIZADO \n";
		}
		msg += "--------------------------------------------\n\n";
		if(histo != null){
			msg += "HISTORIA CLINICA: \n";
			msg += histo.infoClinicHistory();
		}
		return msg;
	}

	public String getClinicHistoryPet(){
		String msg = "";
		if(cli!=null){
			msg += cli.histoClinic();
		}
		msg += "|||||||||||INFO ANIMAL|||||||||||\n";
		msg += "NOMBRE: "+name+"\n";
		msg += "PESO: "+weight+"\n";
		if(type.equals(DOG)){
			msg += "TIPO: "+DOG+"\n";
		}else if(type.equals(CAT)){
			msg += "TIPO: "+CAT+"\n";
		}else if(type.equals(BIRD)){
			msg += "TIPO: "+BIRD+"\n";
		}else {
			msg += "TIPO: "+OTHER+"\n";
		}
		msg += "EDAD: "+age+"\n";
		msg += "||||||||||||||||||||||||||||||||| \n";
		msg += "EL ESTADO DE LA HISTORIA CLINICA: "+histo.getStatus()+"\n";
		msg += "SINTOMAS: \n";
		msg += histo.getSymptom()+"\n";
		msg += "DIAGNOSTICO: \n";
		msg += histo.getDiagnosis()+"\n";



		return msg;
	}
	public void addMedicine(Medicine newMed){
		if(histo!=null){
			histo.addMedicine(newMed);
		}
	}

	public double calculatePriceOfPet(int dayCO, int monthCO, int yearCO){

		double tot = 0.0;
		if(histo!=null){
			tot += histo.knowMedicineCost();
			if(type.equals(CAT)){
				if(weight>=KG1&&weight<=KG12){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE1G;
				}else if(weight>=KG2&&weight<=KG22){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE2G;
				}else if(weight>=KG3&&weight<=KG32){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE3G;
				}else if(weight<KG32){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE4G;
				}else{
					tot+=0;
				}
			}else if(type.equals(DOG)){
				if(weight>=KG1&&weight<=KG12){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE1P;
				}else if(weight>=KG2&&weight<=KG22){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE2P;
				}else if(weight>=KG3&&weight<=KG32){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE3P;
				}else if(weight<KG32){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE4P;
				}else{
					tot+=0;
				}
			}else if(type.equals(BIRD)){
				if(weight>=KG1&&weight<=KG12){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE1A;
				}else if(weight>=KG2&&weight<=KG22){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE2A;
				}else if(weight>=KG3&&weight<=KG32){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE3A;
				}else if(weight<KG32){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE4A;
				}else{
					tot+=0;
				}
			}else{
				if(weight>=KG1&&weight<=KG12){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE1O;
				}else if(weight>=KG2&&weight<=KG22){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE2O;
				}else if(weight>=KG3&&weight<=KG32){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE3O;
				}else if(weight<KG32){
					tot += (histo.calculateDays(dayCO, monthCO, yearCO))*PRICE4O;
				}else{
					tot+=0;
				}
			}

		}
		return tot;
	}
	/**
	*Description This method allows to calculate the body mass index for a pet.
	*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.
	*post: The BMI is calculated.
	*@return The pet body mass index.
	*@throws If the height is zero, so an exception is thrown due to the division on zero does not exist.
	*/
	public double bmiCalc(){
		double tot = 0;
		if (height>0&&weight>0) {
			tot = weight/(height*height);
		}else {
			tot = 0;
		}
		return tot;
	}



}
