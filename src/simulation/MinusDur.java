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
		int HouseNumber = RF.getHouseList ().size (); //‰Æ‚Ì”
		for ( int i = 0; i< HouseNumber; i++ ) { //‘S•”‚Ì‰Æ‚É‘“–‚½‚è
			Housedata TAISYOUHOUSE = RF.getHouseList ().get ( i ); //‚»‚Ì‰Æ‹ï‚ªŠ‘®‚µ‚Ä‚¢‚é‰Æ
			List < HPAdata > iFurnitureList = TAISYOUHOUSE.getFurnitureList (); //’·•¶‘‚«Š·‚¦‚—
			for ( int j = 0; j < iFurnitureList.size (); j++ ) { //‚»‚Ì‰Æ‚Ì‰Æ‹ï‚É‘“–‚½‚è
				HPAdata TaisyouHPA = iFurnitureList.get ( j );//‘ÎÛ‰Æ‹ï
				MinusDurability ( TaisyouHPA ); //‘Ï‹v“xŒ¸Yƒƒ\ƒbƒh
				NewHPABuy ( TaisyouHPA, RF, i, j, iFurnitureList, TAISYOUHOUSE ); //‘Ï‹v“x0‚Ì‰Æ‹ï‚ğ‚³‚ª‚µ‚Ä”pŠü‚µ‚ÄA‚»‚Ì•ª‚ğw“ü(TaisyouHPA‚ªŠY“–‚©‚Ç‚¤‚©’²‚×‚é
				doubleHPASearch ( TaisyouHPA, TAISYOUHOUSE, iFurnitureList ); //—â‘ ŒÉ‚ªƒ_ƒu‚Á‚Ä‚ê‚Î‘Ï‹v“x‚Ì’á‚¢•û‚ğˆÀ”„‚èİ’è‚·‚é
				
			}
		}
	}

	private void doubleHPASearch( HPAdata taisyouHPA, Housedata tAISYOUHOUSE, List<HPAdata> iFurnitureList ) { //ƒ_ƒu‚èŒŸõ
		for ( int i = 0; i < iFurnitureList.size(); i++ ) {
			
		}
	}

	private void NewHPABuy( HPAdata tAISYOU, ReadFile RF, int i, int j, List < HPAdata > iFurnitureList, Housedata TAISYOUHOUSE ) { //V‹Kw“ü
		int NowDur = tAISYOU.getDurability(); //ŒŸõ‘ÎÛ‚Ì‰Æ‹ï‚Ì‘Ï‹v“x
		if ( NowDur <= 0 ) {
			System.out.println( TAISYOUHOUSE.getName() + "‚Ì" + tAISYOU.getName () + "‚ª‘Ï‹v“x0‚É‚È‚è‚Ü‚µ‚½" );
			System.out.println( "V‹K‚É" + tAISYOU.getName () + "‚ğw“ü‚µ‚Ü‚·" );
			new buybuy ( RF, i, j ); //ÀÛ‚Éw“ü‚·‚éƒNƒ‰ƒX‚ğ“®‚©‚·
			iFurnitureList.remove ( j ); //‘Ï‹v“x‚O‚É‚È‚Á‚Ä‚é‰Æ‹ï‚Í”pŠü‚·‚é
		}
	}

	private void MinusDurability ( HPAdata TaisyouHPA ) { //‘Ï‹v“xŒ¸‚ç‚·‚æ
		if ( TaisyouHPA.getDurability () > 0 ) { //‘Ï‹v“x‚ª0‚æ‚è‘å‚«‚¢‚Æ‚«‚¾‚¯ 
			int NowDur = TaisyouHPA.getDurability () - TaisyouHPA.getMinusDur (); //‘Ï‹v“x‚ğŒ¸‚ç‚·
			Double onepValue = (double) (TaisyouHPA.getMaxValue () / 100); //1%ƒAƒ^ƒŠ‚ÌƒRƒXƒg‚ğ‹‚ß‚é
			int NowValue = (int) (onepValue * NowDur); //‘Ï‹v’n‚ğ‘‚¯‚Ä’l’i‚É‚·‚é
			TaisyouHPA.setDurability ( NowDur ); //‘Ï‹v“x‚Æ
			TaisyouHPA.setTermValue ( NowValue ); //‰¿Ši‚ğİ’è
		}
	}
}


