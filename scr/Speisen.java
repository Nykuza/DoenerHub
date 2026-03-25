package Klassen;

public class Speisen{
	
	public int speisenId;
	public String speisenName;
	public double speisenPreis;
	public String fleischArt;
	public Boolean vegetarisch;
	public Boolean vegan;
	public String beilagen;
	
	public Speisen(){
		
	}
	
	public void setSpeisenId(int pSpeisenId){
		this.speisenId = pSpeisenId;
	}
	public void setSpeisenName(String pSpeisenName){
		this.speisenName = pSpeisenName;
	}
	public void setSpeisenPreis(double pSpeisenPreis){
		this.speisenPreis = pSpeisenPreis;
	}
	public void setFleischArt(String pFleischArt){
		this.fleischArt = pFleischArt;
	}
	public void setVegetarisch(Boolean pVegetarisch){
		this.vegetarisch = pVegetarisch;
	}
	public void setVegan(Boolean pVegan){
		this.vegan = pVegan;
	}
	public void setBeilagen(String pBeilagen){
		this.beilagen = pBeilagen;
	}
	
	public int getSpeisenId(){
		return this.speisenId;
	}
	
	public String getSpeiseName(){
		return this.speisenName;
	}
	public double getSpeisenPreis(){
		return this.speisenPreis;
	}
	public String getFleischArt(){
		return this.fleischArt;
	}
	public Boolean getVegetarisch(){
		return this.vegetarisch;
	}
	public Boolean getVegan(){
		return this.vegan;
	}
	public String getBeilagen(){
		return this.beilagen;
	}
	
	public String toString(){
		return "SpeisenID:" + this.speisenId +"\n" + "Speisen Name:" + this.speisenName + "\n" + "Speisen Preis:" + this.speisenPreis + "\n" + "Fleisch Art:" + this.fleischArt + "\n"+"Vegetarisch? :" + this.vegetarisch + "\n"+ "Vegan? :" + this.vegan + "\n" + "Beilagen:" + this.beilagen;
	}
	
}
