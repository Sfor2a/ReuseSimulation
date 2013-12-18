package simulation;
import simulation.MinimumAccess;
import mapdata.*;
import mapdata.Rangefinder;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		ConnectPoint CP = new ConnectPoint(); //地図モデル作成
		CP.ConnectfromFile("C:\\Mapdata.txt"); //地図モデル作成
		
		int PointNum = CP.getPitList().size(); //地図モデルの行列
		int[][] RouteArray = new int [PointNum][PointNum];
		for ( int i=0; i< PointNum; i++ ) {
			for ( int j =0; j< PointNum; j++) {
				RouteArray[i][j] = 0;
			}
		}
		Rangefinder RF = new Rangefinder (CP, RouteArray); //最短経路を探索するための行列作成
		
		MinimumAccess MA = new MinimumAccess ( RouteArray, PointNum, 0, 3 ); //行列とつなぎ先をいれて、距離とルートを返す
		System.out.println(MA.getLength());
		
		
		
		
		
		

	}

}
