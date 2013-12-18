package mapdata;

public class Rangefinder {
	public Rangefinder ( ConnectPoint CP, int [][] RouteArray ) {
		
		int PointNum = CP.getPitList ().size (); //地点の数
		
		for ( int i = 0; i < PointNum; i++ ) { //地点1からくりかえす
			int RouteOutNum = CP.getPitList ().get ( i ).getRteOutList ().size ();
			for ( int j = 0; j < RouteOutNum; j++ ) {
				double x1 = CP.getPitList ().get ( i ).getRoutedataOut ( j ).getTo ().getX ();
				double y1 = CP.getPitList ().get ( i ).getRoutedataOut ( j ).getTo ().getY ();
				double x2 = CP.getPitList ().get ( i ).getX ();
				double y2 = CP.getPitList ().get ( i ).getY ();
				double Length = Math.sqrt ( ( x2 - x1 ) * ( x2 - x1 ) + ( y2 - y1 ) * ( y2 - y1 ) ); //結ばれている2点間の距離を計算
				
				String AiteName = CP.getPitList ().get ( i ).getRoutedataOut ( j ).getTo ().getName ();
				int l = 0;
				
				for ( int k = 0; k < PointNum; k++ ) { //つながる先のポイントを検索して、リストの番号を手に入れる
					if ( AiteName.equals( CP.getPitList ().get ( k ).getName () ) ){
						l = k; 
						break;
					}
				}

				RouteArray[i][l] = (int) Length; //距離を代入（おもて
				RouteArray[l][i] = (int) Length; //距離を代入（うら
			}
		}	
	}
}
