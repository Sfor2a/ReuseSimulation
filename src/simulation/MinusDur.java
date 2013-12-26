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
		int HouseNumber = RF.getHouseList ().size (); //家の数
		for ( int i = 0; i< HouseNumber; i++ ) { //全部の家に総当たり
			Housedata TAISYOUHOUSE = RF.getHouseList ().get ( i ); //その家具が所属している家
			List < HPAdata > iFurnitureList = TAISYOUHOUSE.getFurnitureList (); //長文書き換えｗ
			for ( int j = 0; j < iFurnitureList.size (); j++ ) { //その家の家具に総当たり
				HPAdata TaisyouHPA = iFurnitureList.get ( j );//対象家具
				MinusDurability ( TaisyouHPA ); //耐久度減産メソッド
				NewHPABuy ( TaisyouHPA, RF, i, j, iFurnitureList, TAISYOUHOUSE ); //耐久度0の家具をさがして廃棄して、その分を購入(TaisyouHPAが該当かどうか調べる
				doubleHPASearch ( TaisyouHPA, TAISYOUHOUSE, iFurnitureList ); //冷蔵庫がダブってれば耐久度の低い方を安売り設定する
				
			}
		}
	}

	private void doubleHPASearch( HPAdata taisyouHPA, Housedata tAISYOUHOUSE, List<HPAdata> iFurnitureList ) { //ダブり検索
		for ( int i = 0; i < iFurnitureList.size(); i++ ) {
			
		}
	}

	private void NewHPABuy( HPAdata tAISYOU, ReadFile RF, int i, int j, List < HPAdata > iFurnitureList, Housedata TAISYOUHOUSE ) { //新規購入
		int NowDur = tAISYOU.getDurability(); //検索対象の家具の耐久度
		if ( NowDur <= 0 ) {
			System.out.println( TAISYOUHOUSE.getName() + "の" + tAISYOU.getName () + "が耐久度0になりました" );
			System.out.println( "新規に" + tAISYOU.getName () + "を購入します" );
			new buybuy ( RF, i, j ); //実際に購入するクラスを動かす
			iFurnitureList.remove ( j ); //耐久度０になってる家具は廃棄する
		}
	}

	private void MinusDurability ( HPAdata TaisyouHPA ) { //耐久度減らすよ
		if ( TaisyouHPA.getDurability () > 0 ) { //耐久度が0より大きいときだけ 
			int NowDur = TaisyouHPA.getDurability () - TaisyouHPA.getMinusDur (); //耐久度を減らす
			Double onepValue = (double) (TaisyouHPA.getMaxValue () / 100); //1%アタリのコストを求める
			int NowValue = (int) (onepValue * NowDur); //耐久地を書けて値段にする
			TaisyouHPA.setDurability ( NowDur ); //耐久度と
			TaisyouHPA.setTermValue ( NowValue ); //価格を設定
		}
	}
}


