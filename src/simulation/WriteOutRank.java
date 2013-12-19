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
		File file = new File ( ".\\recycle\\WritedRanking.txt" ); //�������ރt�@�C����
		PrintWriter pw;
		try {
			pw = new PrintWriter (new BufferedWriter ( new FileWriter ( file, true ) ) );
			for ( int i = 0; i < CARR.getCARRList().size(); i++  ) {
				CostAndRangeRankingList CARRL = CARR.getCARRList().get(i);
				pw.print( "���� " + CARRL.getRange() + " �R�X�g " + CARRL.getCost() + " �X�R�A " + CARRL.getScore() + " �ΏۉƋ� " + CARRL.getHPA() );
				pw.println( );
			}
			pw.close();
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //println�̗p��
	}
}

