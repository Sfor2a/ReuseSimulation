package simulation;
import housedata.ReadFile;


public class MinusDur {		
	public MinusDur () {
	}
	
	public void Minus ( ReadFile RF ) {
		int HouseNumber = RF.getHouseList ().size (); //�Ƃ̐�
		for ( int i = 0; i< HouseNumber; i++ ) { //�S���̉Ƃɑ�������
			for ( int j = 0; j < RF.getHouseList ().get ( i ).getFurnitureList ().size (); j++ ) { //���̉Ƃ̉Ƌ�ɑ�������
				if ( RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).getDurability () > 0 ) { 
					int NowDur = RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).getDurability ()
							- RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).getMinusDur (); //�ϋv�x�����炷
					Double onepValue = (double) (RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).getMaxValue () / 100); //1%�A�^���̃R�X�g�����߂�
					int NowValue = (int) (onepValue * NowDur); //�ϋv�n�������Ēl�i�ɂ���
					RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).setDurability( NowDur );
					RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).setTermValue( NowValue );
					if ( NowDur <= 0 ) System.out.println( RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).getName () + "���ϋv�x0�ɂȂ�܂���" );
				}
			}
		}
	}
}


