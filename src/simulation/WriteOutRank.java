package simulation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteOutRank {
	public WriteOutRank() {
		
	}
	public void WriteOut ( CostAndRangeRanking CARR ) {
		File file = new File ( ".\\recycle\\WritedRanking.txt" ); //書き込むファイル名
		PrintWriter pw;
		try {
			pw = new PrintWriter (new BufferedWriter ( new FileWriter ( file, true ) ) );
			for ( int i = 0; i < CARR.getCARRList().size(); i++  ) {
				CostAndRangeRankingList CARRL = CARR.getCARRList().get(i);
				pw.print( "距離 " + CARRL.getRange() + " コスト " + CARRL.getCost() + " スコア " + CARRL.getScore() + " 対象家具 " + CARRL.getHPA() );
				pw.println( );
			}
			pw.close();
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //printlnの用意
	}
}

