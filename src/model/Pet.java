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
	private ArrayList<Service>serv;
	//
	/**
	 *
	 * @param name
	 * @param type
	 * @param age
	 * @param weight
	 * @param height
	 * @param hospitalizatedBefore
	 * @param hospitalizatedNow
	 * @param histo
	 */
	public Pet(String name, String type, int age, double weight, double height, boolean hospitalizatedBefore, boolean hospitalizatedNow, ClinicHistory histo){
		this.name = name;
		this.type = type;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.hospitalizatedBefore = hospitalizatedBefore;
		this.hospitalizatedNow = hospitalizatedNow;
		this.histo = histo;
		serv = new ArrayList<Service>();
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
     * @return type
     */
	public String getType(){
		return type;
	}
	/**
     *
     * @param type
     */
	public void setType(String type){
		this.type = type;
	}
	/**
     *
     * @return age
     */
	public int getAge(){
		return age;
	}
	/**
     *
     * @param age
     */
	public void setType(int age){
		this.age = age;
	}
	/**
     *
     * @return weight
     */
	public double getWeight(){
		return weight;
	}
	/**
     *
     * @param weight
     */
	public void setWeight(double weight){
		this.weight = weight;
	}
	/**
     *
     * @return height
     */
	public double getHeight(){
		return height;
	}
	/**
     *
     * @param height
     */
	public void setHeight(double height){
		this.height = height;
	}
	/**
     *
     * @return hospitalizatedBefore
     */
	public boolean getHospitalizatedBefore(){
		return hospitalizatedBefore;
	}
	/**
     *
     * @param hospitalizatedBefore
     */
	public void setHospitalizatedBefore(boolean hospitalizatedBefore){
		this.hospitalizatedBefore = hospitalizatedBefore;
	}
	/**
     *
     * @return hospitalizatedNow
     */
	public boolean getHospitalizatedNow(){
		return hospitalizatedNow;
	}
	/**
     *
     * @param hospitalizatedNow
     */
	public void setHospitalizatedNow(boolean hospitalizatedNow){
		this.hospitalizatedNow = hospitalizatedNow;
	}
	/**
     *
     * @return histo
     */
	public ClinicHistory getHisto(){
		return histo;
	}
	/**
     *
     * @param histo
     */
	public void setHisto(ClinicHistory histo){
		this.histo = histo;
	}
	/**
     *
     * @return cli
     */
	public Clients getCli(){
		return cli;
	}
	/**
     *
     * @param cli
     */
	public void setCli(Clients Cli){
		this.cli = cli;
	}
	/**
     *
     * @return serv
     */
	public ArrayList<Service> getService(){
		return serv;
	}
	/**
     *
     * @param serv
     */
	public void setService(ArrayList<Service>serv){
		this.serv = serv;
	}

	//methods
	/**
	 * Description: add a new clinic history for the pet
	 * @param statush it is the status of the new clinic history
	 * @param symptomh it is the symptom of the new clinic history
	 * @param diagnosish it is the diagnosis of the new clinic history
	 * @param histoDate1h it is the date of entering in the MiniRoom of the new clinic history
	 * @param histoDate2h it is the date of discharge of the new clinic history
	 */
	public void addHistoInfo(String statush, String symptomh, String diagnosish, Dated histoDate1h, Dated histoDate2h){
		ClinicHistory histoh = new ClinicHistory(statush, symptomh, diagnosish, histoDate1h, histoDate2h);
		setHisto(histoh);
	}

	/**
	 * Description: show the information of the pet with the history clinic
	 * @return msg
	 */
	public String infoPet(){
		String msg = "";
		msg += "><><><><><><><><><><><><><><><><><><><><><><><><><><><\n";
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
			msg += "EL ANIMAL NO ESTA HOSPITALIZADO \n";
		}
		msg += "><><><><><><><><><><><><><><><><><><><><><><><><><><><\n";
		if(histo != null){
			msg += "HISTORIA CLINICA: \n";
			msg += histo.infoClinicHistory();
		}
		if(serv!=null){
			for (int i=0;i<serv.size();i++) {
				msg += serv.get(i).infoService();
			}
		}
		return msg;
	}
	/**
	 * Description: it is to get the clinic history
	 * @return msg
	 */
	public String getClinicHistoryPet(){
		String msg = "";
		if(cli!=null){
			msg += cli.histoClinic();
		}
			msg += "><><><><><><><><><><><><>INFO ANIMAL<><><><><><><><><><><><><\n";
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
			msg += "><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n";
			msg += "EL ESTADO DE LA HISTORIA CLINICA: "+histo.getStatus()+"\n";
			msg += "SINTOMAS: \n";
			msg += histo.getSymptom()+"\n";
			msg += "DIAGNOSTICO: \n";
			msg += histo.getDiagnosis()+"\n";
		return msg;
	}

	/**
	 * Description: search the method addmedicine() in histoh
	 * @param newMed it is the new Medicine
	 */
	public void addMedicine(Medicine newMed){
		if(histo!=null){
			histo.addMedicine(newMed);
		}
	}

	/**
	 * Description: change the status of hospitalizatedNow()
	 * @param status it is the new status of the hospitalization
	 */
	public void changeStatus(boolean status){
		setHospitalizatedNow(status);
	}

	/**
	 * Description: calculate the price of the pet with the days of stay and with the day of today
	 * @param dayCO it is today day
	 * @param monthCO it is today month
	 * @param yearCO it is today year
	 * @return tot
	 */
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
	 *Description: search the method in histo changeHisto()
	 *@param dischargeDate it is the date of pet discharge
	 */
	public void changeHisto(Dated dischargeDate){
		histo.changeHisto(dischargeDate);
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

	/**
	 *Description: search in histo the method changeSymptom()
	 *@param newSymp are the new symptom
	 */
	public void changeSymptom(String newSymp){
		histo.changeSymptom(newSymp);
	}
	/**
	 *Description: search in histo the method addNotes()
	 *@param newNotes are the new notes
	 */
	public void addNotes(String newNotes){
   		histo.addNotes(newNotes);
	}

	/**
	 * Description: add a new service
	 * post: add a new service with the date of made
	 * @param servv it is the type of Service
	 * @param idCli it is the id of the client
	 * @param todayDays it is the day of today
	 * @param todayMonths it is the month of today
	 * @param todayYears it is the year of today
	 */
	public void newService(String servv, int idCli, int todayDays, int todayMonths, int todayYears){
		Dated addDate = new Dated(todayDays, todayMonths, todayYears);
		Service addService = new Service (servv, 0, getName(), idCli, addDate);
		serv.add(addService);
		serv.get(serv.size()-1).setIncome();
	}

	/**
	* Description: is to have the cost of the service
	* @return tot
	*/
	public double totService(){
		double tot = 0.0;
		if (serv!=null){
			for (int i=0;i<serv.size();i++) {
				tot += serv.get(i).getCost();
			}
		}
		return tot;
	}

	/**
	 * Description: is to get a cost for an especific service
	 * @param typeS is the type of the service
	 */
	public double averageServicesIncome(String typeS){
		double tot = 0.0;
		if (serv!=null) {
			for (int i=0;i<serv.size();i++) {
				if (serv.get(i).getTypeOfService().equals(typeS)) {
					tot += serv.get(i).getCost();
				}
			}
		}
		return tot;
	}

	/**
	 * Description: is to get the average of the week
	 * @param todayDayA it is the today day
	 * @param todayMonthA it is the today month
	 * @param todayYearA it is the today year
	 * @param todayDayB it is the day limit of the week
	 * @return average
	 */
	public double averageOfWeek(int todayDayA, int todayMonthA, int todayYearA, int todayDayB){
		double average = 0.0;
		int servIndex = 0;
		boolean knowhisto = false;
		if (serv!=null) {
			for (int i=0;i<serv.size();i++) {
				if (serv.get(i).knowRange(todayDayA, todayMonthA, todayYearA, todayDayB) == true) {
					average += serv.get(i).getCost();
					++servIndex;
				}
			}
		}
		if (histo != null) {
			if (histo.getStatus().equals(histo.CLOSE)) {
				if (histo.knowRange(todayDayA, todayMonthA, todayYearA, todayDayB) == true) {
					average += calculatePriceOfPet(histo.getDay2(), histo.getMonth2(), histo.getYear2());
					knowhisto = true;
				}
			}
		}
		if (knowhisto == true) {
			servIndex += 1;
		}
		if (average != 0.0){
			average = average/servIndex;
		}
		return average;
	}
	/**
	 * Description: this method allows to know the services provied between to dates
	 * @param todayDayA the first day
	 * @param todayMonthA the firt month
	 * @param todayYearA the first year
	 * @param todayDayB the second day
	 * @param todayMonthB the second month
	 * @param todayYearB the second year
	 * @return msg
	 */
	public String servicesProvided(int todayDayA, int todayMonthA, int todayYearA, int todayDayB, int todayMonthB, int todayYearB){
		String msg = "";
		//
		if (serv != null) {
			for (int i=0;i<serv.size();i++) {
				if (serv.get(i).knowRange(todayDayA, todayMonthA, todayYearA, todayDayB, todayMonthB, todayYearB) == true) {
					msg += serv.get(i).infoService()+"\n";
				}
			}
		}
		return msg;
	}


}
