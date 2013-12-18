package housedata;

import java.util.ArrayList;
import java.util.List;

public class Wishlist extends HouseElements {
	private static int WLNum = 0;
	private List < WishValueList > WishValList = new ArrayList <> (); //耐久度と価格のリスト
	
	//ゲッター
	public List< WishValueList > getWishValueList () {
		return WishValList;
	}
	public WishValueList getWVL ( int i, List < WishValueList > WVL ) {
		WishValueList iWVL = WVL.get(i);
		return iWVL;
		
	}
	public int getWVLDurability ( WishValueList iWVL ) {
		return iWVL.getDurability();
	}
	public int getWVLCost ( WishValueList iWVL ) {
		return iWVL.getCost();
	}
	public String getWVLSpec ( WishValueList iWVL ) {
		return iWVL.getSpec();
	}
	//セッター
	public void setValuelist ( WishValueList WVL ) {
		WishValList.add ( WVL );
	}
	
	public Wishlist ( String nam, int Dur, int cost, Housedata HD, String spec ) { //ウィッシュリストをつくるよ
		ID = WLNum++;
		setName ( nam ); //ウィッシュリストにかぐの名前がなければ新しくかぐの名前を作る
		new WishValueList ( this, Dur, cost, spec );//n%以上の価値で何円と判断
		HD.setWishList ( this );
	}	
}

class WishValueList extends HouseElements {
	private int Durability; //耐久度
	private int Cost; //それに見合う価値
	private String spec;
	private static int WVLNum; //ID加算
	
	//ゲッター・セッター
	public int getDurability() {
		return Durability;
	}
	public void setDurability(int durability) {
		Durability = durability;
	}
	public int getCost() {
		return Cost;
	}
	public void setCost(int cost) {
		Cost = cost;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public WishValueList ( Wishlist WL, int Dur, int cost, String spec ) { //その家具のウィッシュリストだよ
		ID = WVLNum++;
		setDurability ( Dur );
		setCost ( cost );
		setSpec ( spec );
		WL.setValuelist ( this );
	}

}