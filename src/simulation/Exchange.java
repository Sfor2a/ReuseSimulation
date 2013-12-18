package simulation;

import housedata.HPAdata;
import housedata.Housedata;

public class Exchange {

	public Exchange(Housedata A1, Housedata A2, HPAdata HPA ) {
		HPAdata F1 = HPA; //����̂��̉Ƌ�������Ă���
		int k = Integer.MAX_VALUE;
		for ( int i = 0; i < A2.getFurnitureList().size(); i++ ) {
			if ( A2.getFurnitureList().get(i) == F1 ) k = i;
		}
		int str6 = A2.getFurnitureList ().get ( k ).getTermValue();
		F1.setExchangecount ( F1.getExchangecount() + 1 );//�����񐔉��Z
		A2.getFurnitureList().remove ( k ); //���̉Ƌ�͏�����
		A1.getFurnitureList().add ( F1 ); //�Ƌ�ǉ������
		A1.setCoin ( A1.getCoin() - str6 );//A1�̉Ƃ���R�C�����ւ���
		A2.setCoin ( A2.getCoin() + str6 );//�R�C�����������
		System.out.println( A1.getName () + "<->" + A2.getName() );
		System.out.println( str6 + "<->" + F1.getName () );
	}

}
