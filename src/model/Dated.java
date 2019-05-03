package model;
import java.util.*;
//
public class Dated{
	private int day;
	private int month;
	private int year;
	//
	/**
	 *
	 * @param day
	 * @param month
	 * @param year
	 */
	public Dated(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	//
	/**
     *
     * @return day
     */
	public int getDay(){
		return day;
	}
	/**
     *
     * @param day
     */
	public void setDay(int day){
		this.day = day;
	}

	/**
     *
     * @return month
     */
	public int getMonth(){
		return month;
	}
	/**
     *
     * @param month
     */
	public void setMonth(int month){
		this.month = month;
	}

	/**
     *
     * @return year
     */
	public int getYear(){
		return year;
	}
	/**
     *
     * @param year
     */
	public void setYear(int year){
		this.year = year;
	}
	//
	//

	/**
	 * Description: show the information od the date
	 * @return msg
	 */
	public String infoDate(){
		String msg = "";
		msg += getDay()+"/"+getMonth()+"/"+getYear();
		return msg;
	}
}
