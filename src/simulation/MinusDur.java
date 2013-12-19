package simulation;
import housedata.ReadFile;


public class MinusDur {		
	public MinusDur () {
	}
	
	public void Minus ( ReadFile RF ) {
		int HouseNumber = RF.getHouseList ().size (); //家の数
		for ( int i = 0; i< HouseNumber; i++ ) { //全部の家に総当たり
			for ( int j = 0; j < RF.getHouseList ().get ( i ).getFurnitureList ().size (); j++ ) { //その家の家具に総当たり
				if ( RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).getDurability () > 0 ) { 
					int NowDur = RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).getDurability ()
							- RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).getMinusDur (); //耐久度を減らす
					Double onepValue = (double) (RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).getMaxValue () / 100); //1%アタリのコストを求める
					int NowValue = (int) (onepValue * NowDur); //耐久地を書けて値段にする
					RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).setDurability( NowDur );
					RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).setTermValue( NowValue );
					if ( NowDur <= 0 ) System.out.println( RF.getHouseList ().get ( i ).getFurnitureList ().get ( j ).getName () + "が耐久度0になりました" );
				}
			}
		}
	}
}


