package ds.matrix;

public class MatrixSpiralPrint {

	public static void main(String[] args) {
		int[][] matrix = { { 0 , 1 , 2 , 3 , 4}, 
						   {10, 11, 12, 13, 14}};
		int n = 2, m = 5, i = 0, j = 0, k = m, l =  n;
		
		while(true){
			
			for(int a = i; a < k; a++ ){
				System.out.print(matrix[i][a]  + " ");
			}
			if( i == l)
				break;
			i++;
			for(int b = i; b < l; b++){
				System.out.print(matrix[b][k - 1]  + " ");
			}
			if( i == l)
				break;
			k--;
			for(int c = k - 1; c >= j; c-- ){
				System.out.print(matrix[l - 1][c]  + " ");
			}
			if( k == j)
				break;
			l--;
			for(int d = l - 1; d >= i; d-- ){
				System.out.print(matrix[d][j]  + " ");
			}
			if( k == j)
				break;
			j++;
		}
	}

}
