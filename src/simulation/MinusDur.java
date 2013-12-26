package simulation;

import java.util.List;

import newbuy.buybuy;
import housedata.HPAdata;
import housedata.Housedata;
import housedata.ReadFile;


public class MinusDur {		
	public MinusDur () {
	}
	
	public void Minus ( ReadFile RF ) {
		int HouseNumber = RF.getHouseList ().size (); //�Ƃ̐�
		for ( int i = 0; i< HouseNumber; i++ ) { //�S���̉Ƃɑ�������
			Housedata TAISYOUHOUSE = RF.getHouseList ().get ( i ); //���̉Ƌ�������Ă����
			List < HPAdata > iFurnitureList = TAISYOUHOUSE.getFurnitureList (); //��������������
			for ( int j = 0; j < iFurnitureList.size (); j++ ) { //���̉Ƃ̉Ƌ�ɑ�������
				HPAdata TaisyouHPA = iFurnitureList.get ( j );//�ΏۉƋ�
				MinusDurability ( TaisyouHPA ); //�ϋv�x���Y���\�b�h
				NewHPABuy ( TaisyouHPA, RF, i, j, iFurnitureList, TAISYOUHOUSE ); //�ϋv�x0�̉Ƌ���������Ĕp�����āA���̕����w��(TaisyouHPA���Y�����ǂ������ׂ�
				doubleHPASearch ( TaisyouHPA, TAISYOUHOUSE, iFurnitureList ); //�①�ɂ��_�u���Ă�Αϋv�x�̒Ⴂ����������ݒ肷��
				
			}
		}
	}

	private void doubleHPASearch( HPAdata taisyouHPA, Housedata tAISYOUHOUSE, List<HPAdata> iFurnitureList ) { //�_�u�茟��
		for ( int i = 0; i < iFurnitureList.size(); i++ ) {
			
		}
	}

	private void NewHPABuy( HPAdata tAISYOU, ReadFile RF, int i, int j, List < HPAdata > iFurnitureList, Housedata TAISYOUHOUSE ) { //�V�K�w��
		int NowDur = tAISYOU.getDurability(); //�����Ώۂ̉Ƌ�̑ϋv�x
		if ( NowDur <= 0 ) {
			System.out.println( TAISYOUHOUSE.getName() + "��" + tAISYOU.getName () + "���ϋv�x0�ɂȂ�܂���" );
			System.out.println( "�V�K��" + tAISYOU.getName () + "���w�����܂�" );
			new buybuy ( RF, i, j ); //���ۂɍw������N���X�𓮂���
			iFurnitureList.remove ( j ); //�ϋv�x�O�ɂȂ��Ă�Ƌ�͔p������
		}
	}

	private void MinusDurability ( HPAdata TaisyouHPA ) { //�ϋv�x���炷��
		if ( TaisyouHPA.getDurability () > 0 ) { //�ϋv�x��0���傫���Ƃ����� 
			int NowDur = TaisyouHPA.getDurability () - TaisyouHPA.getMinusDur (); //�ϋv�x�����炷
			Double onepValue = (double) (TaisyouHPA.getMaxValue () / 100); //1%�A�^���̃R�X�g�����߂�
			int NowValue = (int) (onepValue * NowDur); //�ϋv�n�������Ēl�i�ɂ���
			TaisyouHPA.setDurability ( NowDur ); //�ϋv�x��
			TaisyouHPA.setTermValue ( NowValue ); //���i��ݒ�
		}
	}
}


