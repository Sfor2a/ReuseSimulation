package simulation;

import housedata.HPAdata;
import housedata.Housedata;

public class Exchange {

	public Exchange(Housedata A1, Housedata A2, HPAdata HPA ) {
		HPAdata F1 = HPA; //相手のその家具をもってくる
		int k = Integer.MAX_VALUE;
		for ( int i = 0; i < A2.getFurnitureList().size(); i++ ) {
			if ( A2.getFurnitureList().get(i) == F1 ) k = i;
		}
		int str6 = A2.getFurnitureList ().get ( k ).getTermValue();
		F1.setExchangecount ( F1.getExchangecount() + 1 );//交換回数加算
		A2.getFurnitureList().remove ( k ); //その家具は消える
		A1.getFurnitureList().add ( F1 ); //家具が追加される
		A1.setCoin ( A1.getCoin() - str6 );//A1の家からコインがへって
		A2.setCoin ( A2.getCoin() + str6 );//コインがたされる
		System.out.println( A1.getName () + "<->" + A2.getName() );
		System.out.println( str6 + "<->" + F1.getName () );
	}

}
