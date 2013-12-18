package simulation;


import housedata.Housedata;

public class ExchangeFurnitureSearch {
	private int Cost = Integer.MAX_VALUE;
	
	public ExchangeFurnitureSearch ( Housedata A1, Housedata A2 ) {
		FurnitureSearch (A2, A2);
	}
	
	//�Q�b�^�[
	public int getCost() {
		return Cost;
	}
	public void setCost ( int co ) {
		Cost = co;
	}
	
	
	private void ExchangeFurnitureS (Housedata A1, Housedata A2, int l, int k, int m) { //�ΏۉƋ���X�y�b�N�ōi�ꂽ��
		int str3 = A2.getFurnitureList ().get ( k ).getDurability(); //�����Ƌ�̃X�y�b�N�������Ă���
		int str4 = A1.getWishList ().get ( l ).getWVLDurability ( A1.getWishList ().get ( l ).getWVL ( m,  A1.getWishList ().get ( l ).getWishValueList() ) ); //����ϋv�l�������Ă���
		int str5 = A1.getWishList ().get ( l ).getWVLCost ( A1.getWishList ().get ( l ).getWVL ( m,  A1.getWishList ().get ( l ).getWishValueList() ) ); //�R�X�g���Ђ��ς��Ă���
		int str6 = A2.getFurnitureList ().get ( k ).getTermValue(); //����̉��l���݂�
		if ( str3 <= str4 && str5 >= str6 && str6 != 0 ) { //����̑ϋv�l�������̃g�L��肨��������΁@���@�R�X�g����������
			setCost ( str6 );
		}
	}
	
	private void FurnitureSpec ( Housedata A1, Housedata A2, int l, int k ) { //�����̉Ƌ�̑I��
		for ( int m = 0; m < A1.getWishList ().get ( l ).getWishValueList ().size (); m++) { //�X�y�b�N���X�g�̒�����
			int str3 = Integer.parseInt ( A2.getFurnitureList ().get ( k ).getSpec() ); //�����Ƌ�̃X�y�b�N�������Ă���
			int str4 = Integer.parseInt ( A1.getWishList ().get ( l ).getWVLSpec ( A1.getWishList ().get ( l ).getWVL ( m,  A1.getWishList ().get ( l ).getWishValueList() ) ) ); //����ϋv�l�������Ă���
			if ( ( ( str4 / 100 ) * 110 ) > str3 && ( ( str4 / 100 ) * 90 ) < str3 ) { //����̉Ƌ�̃X�y�b�N�Ǝ����̂��̂Ƃ̃X�y�b�N�̍����P���ȓ��Ȃ�
				ExchangeFurnitureS ( A1, A2, l, k, m );
			}
		}
	}
	
	private void FurnitureSearch ( Housedata A1, Housedata A2 ) { //�Ƌ�̑������胁�\�b�h
		for ( int k = 0; k < A2.getFurnitureList ().size (); k++ ) { //��������̉Ƌ�X�g�𑍓�����
			for ( int l = 0; l < A1.getWishList().size(); l++ ) { //�����̊�]�Ƌ�̖��O�𑍂����肵��
				String str1 = A2.getFurnitureList ().get ( k ).getName();
				String str2 = A1.getWishList ().get ( l ).getName ();
				if ( str2.equals ( str1 ) ) { //�������̂������
					FurnitureSpec ( A1, A2, l, k );
				}
			}
		}

	}
}
