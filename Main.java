import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = 0;
		while(in.hasNextInt()){
			count++;
			String l1 = in.nextLine();
			int numRows = Integer.parseInt(l1.split(" ")[0]);
			int numCols = Integer.parseInt(l1.split(" ")[1]);
			if(numRows==0 || numCols==0)
				return;
			
			if(count!=1){
				System.out.print("\n");
			}
			
			char[][] field = new char[numRows][numCols];
			int[][] intField = new int[numRows][numCols];
			
			for(int i = 0; i < numRows; i++){
				String line = in.nextLine();
				for(int j = 0; j < numCols; j++){
					field[i][j] = line.charAt(j);
					if(field[i][j]=='*'){
						intField[i][j] = 1000;
					}else{
						intField[i][j] = 0;
					}
				}
			}
			
			
			for(int i = 0; i < numRows; i++){
				for(int j = 0; j < numCols; j++){
					if(intField[i][j]>=1000){
						int left = (i+1)<numRows?i+1:1000;
						int right = (i-1)>=0?i-1:1000;
						int down = (j+1)<numCols?j+1:1000;
						int up = (j-1)>=0?j-1:1000;
						
						if(left!=1000){
							intField[left][j]++;
						}
						
						if(right!=1000){
							intField[right][j]++;
						}
						
						if(up!=1000){
							intField[i][up]++;
						}
						
						if(down!=1000){
							intField[i][down]++;
						}
						
						if(down!=1000 && right !=1000){
							intField[right][down]++;
						}
						
						if(down!=1000 && left !=1000){
							intField[left][down]++;
						}
						
						if(up!=1000 && right !=1000){
							intField[right][up]++;
						}
							
						if(up!=1000 && left !=1000){
							intField[left][up]++;
						}
					}
				}
			}
			System.out.println("Field #" + count+":");
			for(int i = 0; i < numRows;i++){
				for(int j = 0; j < numCols; j++){
					System.out.print(intField[i][j]>=1000?"*":intField[i][j]);
				}
				System.out.print("\n");
			}
		}
		
	}
}
