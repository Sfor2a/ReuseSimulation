package simulation;


import housedata.Housedata;

public class ExchangeFurnitureSearch {
	private int Cost = Integer.MAX_VALUE;
	
	public ExchangeFurnitureSearch ( Housedata A1, Housedata A2 ) {
		FurnitureSearch (A2, A2);
	}
	
	//ゲッター
	public int getCost() {
		return Cost;
	}
	public void setCost ( int co ) {
		Cost = co;
	}
	
	
	private void ExchangeFurnitureS (Housedata A1, Housedata A2, int l, int k, int m) { //対象家具をスペックで絞れたら
		int str3 = A2.getFurnitureList ().get ( k ).getDurability(); //相手先家具のスペックをもってくる
		int str4 = A1.getWishList ().get ( l ).getWVLDurability ( A1.getWishList ().get ( l ).getWVL ( m,  A1.getWishList ().get ( l ).getWishValueList() ) ); //一個ずつ耐久値をもってきて
		int str5 = A1.getWishList ().get ( l ).getWVLCost ( A1.getWishList ().get ( l ).getWVL ( m,  A1.getWishList ().get ( l ).getWishValueList() ) ); //コストもひっぱってきて
		int str6 = A2.getFurnitureList ().get ( k ).getTermValue(); //相手の価値をみて
		if ( str3 <= str4 && str5 >= str6 && str6 != 0 ) { //相手の耐久値が自分のトキよりおっきければ　かつ　コストが見合えば
			setCost ( str6 );
		}
	}
	
	private void FurnitureSpec ( Housedata A1, Housedata A2, int l, int k ) { //交換の家具の選定
		for ( int m = 0; m < A1.getWishList ().get ( l ).getWishValueList ().size (); m++) { //スペックリストの中から
			int str3 = Integer.parseInt ( A2.getFurnitureList ().get ( k ).getSpec() ); //相手先家具のスペックをもってくる
			int str4 = Integer.parseInt ( A1.getWishList ().get ( l ).getWVLSpec ( A1.getWishList ().get ( l ).getWVL ( m,  A1.getWishList ().get ( l ).getWishValueList() ) ) ); //一個ずつ耐久値をもってきて
			if ( ( ( str4 / 100 ) * 110 ) > str3 && ( ( str4 / 100 ) * 90 ) < str3 ) { //相手の家具のスペックと自分のものとのスペックの差が１割以内なら
				ExchangeFurnitureS ( A1, A2, l, k, m );
			}
		}
	}
	
	private void FurnitureSearch ( Housedata A1, Housedata A2 ) { //家具の総当たりメソッド
		for ( int k = 0; k < A2.getFurnitureList ().size (); k++ ) { //交換相手の家具リストを総当たり
			for ( int l = 0; l < A1.getWishList().size(); l++ ) { //自分の希望家具の名前を総あたりして
				String str1 = A2.getFurnitureList ().get ( k ).getName();
				String str2 = A1.getWishList ().get ( l ).getName ();
				if ( str2.equals ( str1 ) ) { //同じものがあれば
					FurnitureSpec ( A1, A2, l, k );
				}
			}
		}

	}
}
