
//LABORATORIO No4.
//PROGRAMA HECHO POR JUAN CAMILO GUERRA TABARES
//ESTUDIANTE DE LA UNIVERSIDAD ICESI
package model;
import java.util.*;
//
public class ClinicHistory{
	public static final String OPEN = "abierto";
	public static final String CLOSE = "cerrado";
	//
	private String status;
	private String symptom;
	private String diagnosis;
	//
	private Dated histoDate1;
	private Dated histoDate2;
	private ArrayList<Medicine> medi;
	//
	public ClinicHistory(String status, String symptom, String diagnosis, Dated histoDate1, Dated histoDate2){
		this.status = status;
		this.symptom = symptom;
		this.diagnosis = diagnosis;
		this.histoDate1 = histoDate1;
		this.histoDate2 = histoDate2;
		medi = new ArrayList<Medicine>();
	}
	//
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status = status;
	}

	public String getSymptom(){
		return symptom;
	}
	public void setSymptom(String symptom){
		this.symptom = symptom;
	}

	public String getDiagnosis(){
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis){
		this.diagnosis = diagnosis;
	}

	public Dated getHistoDate1(){
		return histoDate1;
	}
	public void setHistoDate1(Dated histoDate1){
		this.histoDate1 = histoDate1;
	}

	public Dated getHistoDate2(){
		return histoDate2;
	}
	public void setHistoDate2(Dated histoDate2){
		this.histoDate2 = histoDate2;
	}

	public ArrayList getMedi(){
		return medi;
	}
	public void setMedi(ArrayList <Medicine>medi){
		this.medi = medi;
	}

	//
	public String infoClinicHistory(){
		String msg = "";
		if(status.equals(OPEN)){
			msg += "ESTADO: "+OPEN+"\n";
		}else if(status.equals(CLOSE)){
			msg += "ESTADO: "+CLOSE+"\n";
		}else{
			msg += "ESTADO MAL DIGITADO\n";
		}
		msg += "SU SINTOMA ES EL SIGUIENTE: \n"+symptom+"\n";
		msg += "EL DIAGNOSTICO: \n"+diagnosis+"\n";
		msg += "--------------------------------------------\n";
		if(medi.isEmpty()==false){
			for(int i=0;i<medi.size();i++){
				msg += medi.get(i).showInfoMedi();
			}
		}
		return msg;
	}

	public void addMedicine(Medicine newMed){
		medi.add(newMed);
	}

	public double knowMedicineCost(){
		double tot = 0.0;
		if(medi!=null){
			for(int i=0;i<medi.size();i++){
				tot+=medi.get(i).getDoseCost();
			}
		}
		return tot;
	}

	public int calculateDays(int dayCO, int monthCO, int yearCO){
		int tot = 0;
		if(histoDate1.getYear()<yearCO){
			if(histoDate1.getMonth()<=monthCO){
				tot+=360;
				if(histoDate1.getDay()<dayCO){
					tot += (monthCO-histoDate1.getMonth())*30;
					tot += dayCO-histoDate1.getDay();
				}else if(histoDate1.getDay()>dayCO){
					tot += ((monthCO-histoDate1.getMonth())-1)*30;
					tot -= dayCO-histoDate1.getDay();
				}
			}else if(histoDate1.getMonth()>monthCO){
				if(histoDate1.getDay()<dayCO){
					tot += ((histoDate1.getMonth()-monthCO)-12)*30;
					tot += dayCO-histoDate1.getDay();
				}else if(histoDate1.getDay()>dayCO){
					tot += ((monthCO-histoDate1.getMonth())-1)*30;
					tot -= dayCO-histoDate1.getDay();
				}
			}
		}else if(histoDate1.getYear()==yearCO){
			if(histoDate1.getMonth()<=monthCO){
				if(histoDate1.getDay()<dayCO){
					tot += (monthCO-histoDate1.getMonth())*30;
					tot += dayCO-histoDate1.getDay();
				}else if(histoDate1.getDay()>dayCO){
					tot += ((monthCO-histoDate1.getMonth())-1)*30;
					tot -= dayCO-histoDate1.getDay();
				}
			}else if(histoDate1.getMonth()>monthCO){
				if(histoDate1.getDay()<dayCO){
					tot += ((histoDate1.getMonth()-monthCO)-12)*30;
					tot += dayCO-histoDate1.getDay();
				}else if(histoDate1.getDay()>dayCO){
					tot += ((monthCO-histoDate1.getMonth())-1)*30;
					tot -= dayCO-histoDate1.getDay();
				}
			}

		}else{
			tot+=0.0;
		}
		return tot;
	}

	public void changeSymptom(String newSymp){
		String msg = "";
		//
		msg += getSymptom()+"\n";
		msg += newSymp+"\n";
		//
		setSymptom(msg);
	}
	
	public void addNotes(String newNotes){
	String msg = "";
	//
	msg += getDiagnosis()+"\n";
	msg += newNotes+"\n";
	//
	setDiagnosis(msg);
	}


}
