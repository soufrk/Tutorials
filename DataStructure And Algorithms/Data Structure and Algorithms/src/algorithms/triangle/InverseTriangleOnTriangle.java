package algorithms.triangle;

public class InverseTriangleOnTriangle {

	public static void main(String[] args) {
		int row = 5;
		for(int i = 0; i < row*2; i++){
			if(i < 5)
				System.out.format("%" + (i + 1) * 2 + "s", "");
			else if(i > 5)
				System.out.format("%" + (row*2 - i) * 2 + "s", "");
			for(int j = row - i; j > 0; j--){
				System.out.format("%4s",'*');
			}
			for(int k = i - row; i > row && k >= 0; k--){
				System.out.format("%4s",'*');
			}
			if(i != 5)
				System.out.println();
		}
	}

}
