//LABORATORIO No4.
//PROGRAMA HECHO POR JUAN CAMILO GUERRA TABARES
//ESTUDIANTE DE LA UNIVERSIDAD ICESI
package model;
import java.util.*;
//
public class Medicine{
	private String name;
	private double dose;
	private double doseCost;
	private int frecuency;
	//
	/**
	  *
	  * @param name
	  * @param dose
	  * @param doseCost
	  * @param frecuency
	  */
	public Medicine (String name, double dose, double doseCost, int frecuency){
		this.name = name;
		this.dose = dose;
		this.doseCost = doseCost;
		this.frecuency = frecuency;
	}
	//
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
	 * @return dose
	 */
	public double getDose(){
		return dose;
	}
	/**
	 *
	 * @param dose
	 */
	public void setDose(double dose){
		this.dose = dose;
	}

	/**
	 *
	 * @return doseCost
	 */
	public double getDoseCost(){
		return doseCost;
	}
	/**
	 *
	 * @param doseCost
	 */
	public void setDoseCost(double doseCost){
		this.doseCost = doseCost;
	}

	/**
	 *
	 * @return frecuency
	 */
	public int getFrecuency(){
		return frecuency;
	}
	/**
	 *
	 * @param frecuency
	 */
	public void setFrecuency(int frecuency){
		this.frecuency = frecuency;
	}
	//
	//
	/**
	 * Description: show the information of the medicine
	 * @return msg
	 */
	public String showInfoMedi(){
		String msg = "";

		msg += "NOMBRE DE LA MEDICINA: "+name+"\n";
		msg += "LA DOSIS: "+dose+"\n";
		msg += "COSTO POR DOSIS: "+doseCost+"\n";
		msg += "FRECUENCIA QUE ESTA DEBE SER APLICADA: "+frecuency+"\n";

		return msg;
	}
}
