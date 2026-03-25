package Klassen;

public class Orte{
	
	public int ortId;
	public String oName;
	public int plz;
	public int einwohnerZahl;
	
	public Orte(){
		}
	
	public void setOrtId(int pOrtId){
		this.ortId = pOrtId;
	}
	public void setOName(String pOName){
		this.oName = pOName;
	}
	public void setPlz(int pPlz){
		this.plz = pPlz;
	}
	public void setEinwohnerZahl(int pEinwohnerZahl){
		this.einwohnerZahl = pEinwohnerZahl;
	}
	
	public int getOrtId(){
		return this.ortId;
	}
	public String getOName(){
		return this.oName;
	}
	public int getPlz(){
		return this.plz;
	}
	public int getEinwohnerzahl(){
		return this.einwohnerZahl;
	}
	
	public String toString(){
		return "OrtID:" + this.ortId +"\n" + "Orts Name:" + this.oName + "\n" + "Plz:" + this.plz + "\n" + "Einwohner Zahl:" + this.einwohnerZahl;
	}
}
