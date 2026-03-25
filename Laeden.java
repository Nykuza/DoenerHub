package Klassen;

public class Laeden{

	public int ladenId;
	public String ladenName;
	public String anschrift;
	public int hausnummer;
	public String telefonnummer;
	public double teuerstesProdukt;
	public double guenstigstesProdukt;
	public String zahlungsart;
	public String bestellen;
	
	
	public Laeden(){
		
	}
	
	public void setLadenId(int pLadenId){
		this.ladenId = pLadenId;
	}
	
	public void setLadenName(String pLadenName){
		this.ladenName = pLadenName;
	}
	
	public void setAnschrift(String pAnschrift){
		this.anschrift = pAnschrift;
	}
	
	public void setHausnummer(int pHausnummer){
		this.hausnummer = pHausnummer;
		
	}
	
	public void setTelefonnummer(String pTelefonnummer){
		this.telefonnummer = pTelefonnummer;
	}
	
	public void setTeuerstesProdukt(double pTeuerstesProdukt){
		this.teuerstesProdukt = pTeuerstesProdukt;
	}
	
	public void setGuenstigstesProdukt(double pGuenstigstesProdukt){
		this.guenstigstesProdukt = pGuenstigstesProdukt;
	}
	
	public void setZahlungsart(String pZahlungsart){
		this.zahlungsart = pZahlungsart;
	}
	
	public void setBestellen(String pBestellen){
		this.bestellen = pBestellen;
	}
	
	public int getLadenId(){
		return this.ladenId;
	}
	
	public String getLadenName(){
		return this.ladenName;
	}
	
	public String getAnschrift(){
		return this.anschrift;
	}
	
	public int getHausnummer(){
		return this.hausnummer;
	}
	
	public String getTelefonnummer(){
		return this.telefonnummer;
	}
	
	public double getTeuerstesProdukt(){
		return this.teuerstesProdukt;
	}
	
	public double getGuenstigstesProdukt(){
		return this.guenstigstesProdukt;
	}
	
	public String getZahlungsart(){
		return this.zahlungsart;
	}
	
	public String getBestellen(){
		return this.bestellen;
	}
	
	public String toString(){
		return "LadenID:" + this.ladenId +"\n" + "LadenName:" + this.ladenName + "\n" + "Anschrift:" + this.anschrift + "\n" + "Hausnummer:" + this.hausnummer + "\n" + "Telefonnummer:" + this.telefonnummer + "\n" + "TeuerstesProdukt:" + this.teuerstesProdukt + "\n" + "GuenstigstesProdukt:" + this.guenstigstesProdukt + "\n" + "Zahlungsart:" + this.zahlungsart + "\n" + "Bestellen:" + this.bestellen + "\n";
	}
	
}

