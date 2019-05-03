
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
	/**
	 *
	 * @param status
	 * @param symptom
	 * @param diagnosis
	 * @param histoDate1
	 * @param histoDate2
	 */
	public ClinicHistory(String status, String symptom, String diagnosis, Dated histoDate1, Dated histoDate2){
		this.status = status;
		this.symptom = symptom;
		this.diagnosis = diagnosis;
		this.histoDate1 = histoDate1;
		this.histoDate2 = histoDate2;
		medi = new ArrayList<Medicine>();
	}
	//
	/**
	 *
	 * @return status
	 */
	public String getStatus(){
		return status;
	}
	/**
	 *
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}

	/**
	 *
	 * @return symptom
	 */
	public String getSymptom(){
		return symptom;
	}
	/**
	 *
	 * @param symptom
	 */
	public void setSymptom(String symptom){
		this.symptom = symptom;
	}

	/**
	 *
	 * @return diagnosis
	 */
	public String getDiagnosis(){
		return diagnosis;
	}
	/**
	 *
	 * @param diagnosis
	 */
	public void setDiagnosis(String diagnosis){
		this.diagnosis = diagnosis;
	}

	/**
	 *
	 * @return histoDate1
	 */
	public Dated getHistoDate1(){
		return histoDate1;
	}
	/**
	 *
	 * @param histoDate1
	 */
	public void setHistoDate1(Dated histoDate1){
		this.histoDate1 = histoDate1;
	}

	/**
	 *
	 * @return histoDate2
	 */
	public Dated getHistoDate2(){
		return histoDate2;
	}
	/**
	 *
	 * @param histoDate2
	 */
	public void setHistoDate2(Dated histoDate2){
		this.histoDate2 = histoDate2;
	}

	/**
	 *
	 * @return medi
	 */
	public ArrayList getMedi(){
		return medi;
	}
	/**
	 *
	 * @param medi
	 */
	public void setMedi(ArrayList <Medicine>medi){
		this.medi = medi;
	}

	//
	/**
	 * Description: show the information of the clinic history
	 * @return msg
	 */
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
		msg += "><><><><><><><><><><><><><><><><><><><><><><><><><><><\n";
		if(medi.isEmpty()==false){
			for(int i=0;i<medi.size();i++){
				msg += medi.get(i).showInfoMedi();
			}
		}else {
			msg += "NO HAY MEDICINA PARA EL ANIMAL\n";
		}
		msg += "======================================================\n";
		return msg;
	}

	/**
	 * Description: add a new medicine to the ArrayList
	 * @param newMed it is the new medicine to add
	 */
	public void addMedicine(Medicine newMed){
		medi.add(newMed);
	}

	/**
	 * Description: it is to sum all the cost of the medicines
	 * @return tot
	 */
	public double knowMedicineCost(){
		double tot = 0.0;
		if(medi!=null){
			for(int i=0;i<medi.size();i++){
				tot+=medi.get(i).getDoseCost();
			}
		}
		return tot;
	}

	/**
	 * Description: calculate the days pass between two dates
	 * @param dayCO it is today day
	 * @param monthCO it is today month
	 * @param yearCO it is today year
	 * @return tot
	 */
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
	/**
	 * Description: it is to change the status to open
	 *
	 */
	public void changeStatus(){
		setStatus(OPEN);
	}

	/**
	 * Description: this method change the status to close and set the discharge date
	 * @param dischargeDate it is the date of discharge
	 */
	public void changeHisto(Dated dischargeDate){
		setStatus(CLOSE);
		setHistoDate2(dischargeDate);

	}

	/**
	 * Description: this method allows to add a new symptom to existing ones
	 * @param newSymp it is the new symptom to add
	 */
	public void changeSymptom(String newSymp){
		String msg = "";
		//
		msg += getSymptom()+"\n";
		msg += newSymp+"\n";
		//
		setSymptom(msg);
	}

	/**
	 * Description: this method allows to add new notes to the existing ones
	 * @param newNotes it is the new notes to change
	 */
	public void addNotes(String newNotes){
	String msg = "";
	//
	msg += getDiagnosis()+"\n";
	msg += newNotes+"\n";
	//
	setDiagnosis(msg);
	}
	/**
	 * Description: this method allows to know the range between one date and calculate
	 * other eith the day todayDayB
	 * @param todayDayA
	 * @param todayMonthA
	 * @param todayYearA
	 * @param todayDayB
	 * @return
	 */
	public boolean knowRange(int todayDayA, int todayMonthA, int todayYearA, int todayDayB){
		boolean range = false;
        //
        int todayMonthB = 0;
        int todayYearB = 0;

        if (todayDayB<todayDayA) {
            todayMonthB = todayMonthA + 1;
            if (todayMonthB>12) {
                todayMonthB -= 12;
                todayYearB = todayYearA + 1;
            }else {
                todayYearB = todayYearA;
            }
        }else {
            todayMonthB = todayMonthA;
        }
		//
		if (histoDate1 != null && histoDate2 != null) {

			if (histoDate1.getYear() == todayYearA) {
	            if (histoDate1.getMonth() == todayMonthA) {
	                if (histoDate1.getDay()>todayDayA) {
	                    range = true;
	                }else {
	                    range = false;
	                }
	            }else if (histoDate1.getMonth() == todayMonthB) {
	                if (histoDate1.getDay()<todayDayB) {
	                    range = true;
	                }else {
	                    range = false;
	                }
	            }else {
	                range = false;
	            }
	        }else if (histoDate1.getYear() == todayYearB) {
	            if (histoDate1.getMonth() == todayMonthB) {
	                if (histoDate1.getDay()<todayDayB) {
	                    range = true;
	                }else {
	                    range = false;
	                }
	            }else {
	                range = false;
	            }
	        }
			//
			if (histoDate2.getYear() == todayYearA) {
	            if (histoDate2.getMonth() == todayMonthA) {
	                if (histoDate2.getDay()>todayDayA) {
	                    range = true;
	                }else {
	                    range = false;
	                }
	            }else if (histoDate2.getMonth() == todayMonthB) {
	                if (histoDate2.getDay()<todayDayB) {
	                    range = true;
	                }else {
	                    range = false;
	                }
	            }else {
	                range = false;
	            }
	        }else if (histoDate2.getYear() == todayYearB) {
	            if (histoDate2.getMonth() == todayMonthB) {
	                if (histoDate2.getDay()<todayDayB) {
	                    range = true;
	                }else {
	                    range = false;
	                }
	            }else {
	                range = false;
	            }
	        }
		}
        return range;
    }

	/**
	 * Description: get the day of discharge
	 * @return
	 */
	public int getDay2(){
		return histoDate2.getDay();
	}
	/**
	 * Description: get the month of discharge
	 * @return
	 */
	public int getMonth2(){
		return histoDate2.getMonth();
	}
	/**
	 * Description: get the year of discharge
	 * @return
	 */
	public int getYear2(){
		return histoDate2.getYear();
	}

}
