package housedata;

import java.util.ArrayList;
import java.util.List;

public class Housedata {
	public List < HPAdata > FurnitureList = new ArrayList <> (); //家具リスト
	public List < Wishlist > WishList = new ArrayList <> (); //ほしいものリスト
	private int Coin; //コイン
	private static int HouseIDAdd; //ID加算
	
	//ゲッター・セッター
	public List<HPAdata> getFurnitureList() {
		return FurnitureList;
	}
	public List<Wishlist> getWishList() {
		return WishList;
	}
	public int getCoin() {
		return Coin;
	}
	public void setCoin(int coin) {
		Coin = coin;
	}
	public static int getHouseIDAdd() {
		return HouseIDAdd;
	}	
	//ゲッター・セッター終了
	
	public Housedata () {
		
	}
	
	
	
	
}
