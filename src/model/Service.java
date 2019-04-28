package model;
//
import java.util.*;
//
public class Service{
    //
    public static final double SHOWER_VETERINARY = 20000.0;
    public static final double SHOWER_DOMICILE = 30000.0;
    public static final double NAIL_CUT = 8000;
    public static final double DENTAL_PROPHYLAXIS = 12000;
    public static final double VACCINES = 45000;
    //
    public static final String SHOWER = "Bano veterinaria";
    public static final String SHOWER_D = "Bano domicilio";
    public static final String NAIL = "Corte de uñas";
    public static final String PROPHYLAXIS = "Profilaxis Dental";
    public static final String VACC = "Vacunas";
    private String typeOfService;
    private double cost;
    private String idPet;
    private int idClient;
    //
    private Dated dateOfService;
    //
	public Service(String typeOfService, double cost, String idPet, int idClient, Dated dateOfService) {
		this.typeOfService = typeOfService;
		this.cost = cost;
		this.idPet = idPet;
		this.idClient = idClient;
        this.dateOfService = dateOfService;
	}
    //
	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getIdPet() {
		return idPet;
	}

	public void setIdPet(String idPet) {
		this.idPet = idPet;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

    public Dated getDateOfService() {
		return dateOfService;
	}

	public void setDateOfService(Dated dateOfService) {
		this.dateOfService = dateOfService;
	}
    //
    public void setIncome(){
        if (typeOfService.equals(SHOWER))
            setCost(SHOWER_VETERINARY);
        else if (typeOfService.equals(SHOWER_D))
            setCost(SHOWER_DOMICILE);
        else if (typeOfService.equals(NAIL))
            setCost(NAIL_CUT);
        else if (typeOfService.equals(PROPHYLAXIS))
            setCost(DENTAL_PROPHYLAXIS);
        else if (typeOfService.equals(VACC))
            setCost(VACCINES);
    }

    public String infoService(){
        String msg = "";
        msg += "><><><><><><><><><><><><><><><><><><><><><><><><><><><\n";
        msg += "EL TIPO DE SERVICIO ES "+getTypeOfService()+"\n";
        msg += "EL COSTO ES "+getCost()+"\n";
        msg += "EL ID DEL CLIENTE: "+getIdClient()+"\n";
        msg += "LA FECHA DE REALIZADO ES: "+dateOfService.infoDate()+"\n";
        msg += "><><><><><><><><><><><><><><><><><><><><><><><><><><><\n";
        return msg;
    }

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
        if (dateOfService.getYear() == todayYearA) {
            if (dateOfService.getMonth() == todayMonthA) {
                if (dateOfService.getDay()>todayDayA) {
                    range = true;
                }else {
                    range = false;
                }
            }else if (dateOfService.getMonth() == todayMonthB) {
                if (dateOfService.getDay()<todayDayB) {
                    range = true;
                }else {
                    range = false;
                }
            }else {
                range = false;
            }
        }else if (dateOfService.getYear() == todayYearB) {
            if (dateOfService.getMonth() == todayMonthB) {
                if (dateOfService.getDay()<todayDayB) {
                    range = true;
                }else {
                    range = false;
                }
            }else {
                range = false;
            }
        }
        return range;
    }

    public boolean knowRange(int todayDayA, int todayMonthA, int todayYearA, int todayDayB, int todayMonthB, int todayYearB){
        boolean range = false;
        if (dateOfService.getYear() >= todayYearA && dateOfService.getYear() <= todayYearB) {
            if (dateOfService.getMonth() >= todayMonthA && dateOfService.getMonth() <= todayMonthB) {
                if (dateOfService.getDay()>=todayDayA && dateOfService.getDay()<=todayDayB) {
                    range = true;
                }else {
                    range = false;
                }
            }else {
                range = false;
            }
        }else {
            range = false;
        }
        return range;
    }

}
