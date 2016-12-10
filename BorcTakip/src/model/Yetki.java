package model;

public class Yetki {
	private int yetki_id;
	private String yetki_adi;
	
	public Yetki(){
		super();
	}
	
	public Yetki(String yetki_adi){
		this.yetki_adi=yetki_adi;
	}

	public int getYetki_id() {
		return yetki_id;
	}

	public void setYetki_id(int yetki_id) {
		this.yetki_id = yetki_id;
	}

	public String getYetki_adi() {
		return yetki_adi;
	}

	public void setYetki_adi(String yetki_adi) {
		this.yetki_adi = yetki_adi;
	}

}
