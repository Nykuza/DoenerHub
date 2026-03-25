package Klassen;

public class Getraenke{
	
	public int getraenkeId;
	public String gName;
	public double gPreis;
	public String gForm;
	public double gFuellmenge;
	
	public Getraenke(){
		
	}
	
	public void setGetraenkeId(int pGetraenkeId){
		this.getraenkeId = pGetraenkeId;
	}
	
	public void setGName(String pGName){
		this.gName = pGName;
	}
	
	public void setGPreis(double pGPreis){
		this.gPreis = pGPreis;
	}
	
	public void setGForm(String pGForm){
		this.gForm = pGForm;
		
	}
	
	public void setGFuellmenge(Double pGFuellmenge){
		this.gFuellmenge = pGFuellmenge;
	}
	
	public int getGetraenkeId(){
		return this.getraenkeId;
	}
	
	public String getGName(){
		return this.gName;
	}
	
	public double getGPreis(){
		return this.gPreis;
	}
	
	public String getGForm(){
		return this.gForm;
	}
	
	public double getGFuellmenge(){
		return this.gFuellmenge;
	}
	
	public String toString(){
		return "GetraenkeID:" + this.getraenkeId +"\n" + "Name:" + this.gName + "\n" + "Preis:" + this.gPreis + "\n" + "Form:" + this.gForm + "\n" + "Fuellmenge:" + this.gFuellmenge + "\n";
	}
	


}
