package simulation;

import java.util.ArrayList;
import java.util.List;

import housedata.Housedata;
import housedata.ReadFile;
import mapdata.ConnectPoint;

public class CostAndRangeRanking {
	private List < CostAndRangeRankingList > CARRList = new ArrayList <> ();

	
	//�Q�b�^�[�E�Z�b�^�[
	public List<CostAndRangeRankingList> getCARRList() {
		return CARRList;
	}
	public void setCARRList(CostAndRangeRankingList costAndRangeRankingList) {
		CARRList.add (costAndRangeRankingList );
	}

	public CostAndRangeRanking () {
		
		ReadFile RF = new ReadFile();
		RF.CreatefromFile( "C:\\recycle\\Houselist.txt" ); //�Ƌ�X�g�̍쐬
		
		int HouseNumber = RF.getHouseList ().size (); //�Ƃ̐�		
		ConnectPoint CP = new ConnectPoint(); //�n�}���f���쐬
		CP.ConnectfromFile("D:\\Users\\Sforza\\Dropbox\\�v���O����\\Mapdata2.txt"); //�n�}���f���쐬
		
		HouseSearch ( HouseNumber, RF, CP );
		
		for ( int i = 0; i < getCARRList().size(); i++ ) {
			Housedata House1 = getCARRList().get(i).getHouseC1();
			for ( int j = 0; j < getCARRList().size(); j++ ) {
				Housedata House2 = getCARRList().get(j).getHouseC1();
				
			}
			
		}
	}
	
	private void HouseSearch ( int HouseNumber, ReadFile RF, ConnectPoint CP ) { //�Ƃ̑������胁�\�b�h
		for ( int i = 0; i< HouseNumber; i++ ) { //�������i�̌���
			for ( int j = 0; j < HouseNumber; j++ ) {
				Housedata A1 = RF.getHouseList ().get ( i ); //�����̎��
				Housedata A2 = RF.getHouseList ().get ( j ); //�����
				if ( A1 != A2 && A2 != A1 ) { //i��j���Ⴄ�Ƃ��������������
					int Range = MARange ( A1, A2, CP );
					int Cost = FurnitureCost ( A1, A2 );
					new CostAndRangeRankingList ( Cost, Range, A1, A2, this );
				}
			}
		}
	}
	
 	private int MARange ( Housedata B1, Housedata B2, ConnectPoint CP ) { //�ŒZ������Ԃ��� ���邢�݂����̃Q�b�^�[
		int PointNum = CP.getPitList().size(); //�n�}���f���̍s��
		
		int[][] RouteArray = new int [PointNum][PointNum]; //�n�}�s��̏�����
		for ( int i=0; i< PointNum; i++ ) {
			for ( int j =0; j< PointNum; j++) {
				RouteArray[i][j] = 0;
			}
		}
		
		String Name1 = B1.getName(); //�Ƃ̖��O���擾
		String Name2 = B2.getName();
		
		for ( int i = 0; i < CP.getPitList().size(); i++ ) { //�Ƃ̖��O���烋�[�g�𒲂ׂ�
			if ( Name1.equals ( CP.getPitList().get(i).getName() ) ) {
				for ( int j = 0; j < CP.getPitList().size(); j++ ) {
					if ( Name2.equals ( CP.getPitList().get(j).getName() ) ) {
						MinimumAccess MA = new MinimumAccess ( RouteArray, PointNum, i, j, CP ); //�s��ƂȂ��������āA�����ƃ��[�g��Ԃ�
						return MA.getLength();
					}
				}
			}
		}
		return 0;
	}
	
	private int FurnitureCost ( Housedata A1, Housedata A2 ) { //�Ƌ�̃R�X�g��Ԃ���
		ExchangeHPASearch EFS = new ExchangeHPASearch ( A1, A2 );
		return EFS.getCost();
	}
}


class CostAndRangeRankingList {
	private int Cost;
	private int Range;
	private Housedata C1;
	private Housedata C2;
	
	public int getCost() {
		return Cost;
	}
	public void setCost(int cost) {
		Cost = cost;
	}
	public int getRange() {
		return Range;
	}
	public void setRange(int range) {
		Range = range;
	}
	public Housedata getHouseC1() {
		return C1;
	}
	public Housedata getHouseC2() {
		return C2;
	}
	public void setA1(Housedata a1) {
		C1 = a1;
	}
	
	public void setA2(Housedata a2) {
		C2 = a2;
		}
	
	public CostAndRangeRankingList ( int Co, int Ra, Housedata a1, Housedata a2, CostAndRangeRanking CARR ) {
		setCost ( Co );
		setRange ( Ra );
		setA1 ( a1 );
		setA2 ( a2 );
		CARR.setCARRList( this );
	}
	
	
}
