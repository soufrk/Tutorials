package triangle.algorithms;

public class PascalTriangle {

	public static void main(String[] args) {
		int rows = 10;
		for(int i = 0; i < rows; i++){
			int no = 1;
			System.out.format("%"+(rows - i) * 2 + "s", "");
			for(int j = 0; j <= i; j++){
				System.out.format("%4d", no);
				no = no * (i - j)/(1 + j);
			}
			System.out.println();
		}
	}

}
