package simulation;

public class Main {

	public static void main(String[] args) {
		CostAndRangeRanking CRR = new CostAndRangeRanking ();
		for ( int i = 0; i<1000; i++ ) {
			CRR.CARRCreate();
		}
	}

}
