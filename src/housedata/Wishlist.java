package housedata;

import java.util.ArrayList;
import java.util.List;

public class Wishlist extends HouseElements {
	private static int WLNum = 0;
	private List < WishValueList > WishValList = new ArrayList <> (); //�ϋv�x�Ɖ��i�̃��X�g
	
	//�Q�b�^�[
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
	//�Z�b�^�[
	public void setValuelist ( WishValueList WVL ) {
		WishValList.add ( WVL );
	}
	
	public Wishlist ( String nam, int Dur, int cost, Housedata HD, String spec ) { //�E�B�b�V�����X�g�������
		ID = WLNum++;
		setName ( nam ); //�E�B�b�V�����X�g�ɂ����̖��O���Ȃ���ΐV���������̖��O�����
		new WishValueList ( this, Dur, cost, spec );//n%�ȏ�̉��l�ŉ��~�Ɣ��f
		HD.setWishList ( this );
	}	
}

class WishValueList extends HouseElements {
	private int Durability; //�ϋv�x
	private int Cost; //����Ɍ��������l
	private String spec;
	private static int WVLNum; //ID���Z
	
	//�Q�b�^�[�E�Z�b�^�[
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
	
	public WishValueList ( Wishlist WL, int Dur, int cost, String spec ) { //���̉Ƌ�̃E�B�b�V�����X�g����
		ID = WVLNum++;
		setDurability ( Dur );
		setCost ( cost );
		setSpec ( spec );
		WL.setValuelist ( this );
	}

}