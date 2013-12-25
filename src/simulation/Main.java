package simulation;

public class Main {

	public static void main(String[] args) {
		CostAndRangeRanking CRR = new CostAndRangeRanking ();
		
		for ( int i = 0; i<110; i++ ) {
			CRR.CARRCreate();
			System.out.println(i+"ƒ^[ƒ“–Ú");
			WriteOutData WOR = new WriteOutData();
			WOR.WriteOut ( CRR, i );
		}
	}

}
