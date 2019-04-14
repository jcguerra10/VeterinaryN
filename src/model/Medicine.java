//LABORATORIO No3.
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
	public Medicine (String name, double dose, double doseCost, int frecuency){
		this.name = name;
		this.dose = dose;
		this.doseCost = doseCost;
		this.frecuency = frecuency;
	}
	//
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public double getDose(){
		return dose;
	}
	public void setDose(double dose){
		this.dose = dose;
	}
	
	public double getDoseCost(){
		return doseCost;
	}
	public void setDoseCost(double doseCost){
		this.doseCost = doseCost;
	}
	
	public int getFrecuency(){
		return frecuency;
	}
	public void setFrecuency(int frecuency){
		this.frecuency = frecuency;
	}
	//
	//
	
	public String showInfoMedi(){
		String msg = "";
		
		msg += "NOMBRE DE LA MEDICINA: "+name+"\n";
		msg += "LA DOSIS: "+dose+"\n";
		msg += "COSTO POR DOSIS: "+doseCost+"\n";
		msg += "FRECUENCIA QUE ESTA DEBE SER APLICADA: "+frecuency+"\n";
		
		return msg;
	}
}	