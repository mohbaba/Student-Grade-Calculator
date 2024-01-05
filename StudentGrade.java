import java.util.*;
public class StudentGrade{

	private static Scanner scanner = new Scanner(System.in);
	private static int studentNumber;
	private static int subjectNumber;
	private static double score;
	private static double[][] studentSubject;
	private static double highestScores;
	private static double lowestScores;
	private static int[] highestStudent;
	private static int[] lowestStudent;
	private static double[] totalScores;
	private static double[] averages;
	

	
	public static void infoPrompt(){
		int count = 1;
		int subjectCount = 1;
		for(int i = 0 ; i < studentSubject.length ; i++){
			for(int j = 0; j < studentSubject[i].length ; j++){
				
				System.out.printf("Entering score for student %d%n",count);
				System.out.printf("Enter score for subject %d%n",subjectCount);
				score = scanner.nextDouble();
				while(score < 0 || score > 100){
					System.out.println("Enter correct score:");
					score = scanner.nextDouble();
				}
				studentSubject[i][j] = score;
				totalScores[i] += score; 
				subjectCount++;
				System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Saved Successfully");
				System.out.println();
			}
			count++;
			subjectCount = 1;
			System.out.println();
		}
	}

	public static double getHighest(){
		int count = 0;
		int subjectCount = 1;
		//highestScores = studentSubject[0];
		//lowestScores = studentSubject[0];
		
		for(int i = 0; i < studentSubject.length ; i++){
			highestScores = studentSubject[0][i];
			lowestScores = studentSubject[0][i];
			for(int j = 0; j < studentSubject[i].length ; j++){
				
				if(studentSubject[i][j] > highestScores){
				  	highestScores[j] = studentSubject[i][j];
					
					highestStudent[j] = subjectCount; 
				}
				
				if(studentSubject[i][j] < lowestScores){
					lowestScores[j] = studentSubject[i][j];				 

				}
				subjectCount++;	
			}
			count++;
			subjectCount = 1;
			System.out.println();
		}
		return highestScores;

	}

	public static double getLowest(){
		int count = 1; 
		//lowestScores = new double[subjectNumber];
		double lowest = studentSubject[0][0];
		
	
		for(int i = 0; i < studentSubject.length ; i++){

			for(int j = 0 ; j < studentSubject[i].length ; j++){
				if(studentSubject[i][j] < lowest){
					//lowest = studentSubject[i][j];
					//lowestScores[i] = lowest;
					//lowestStudent[j] = count;

				}
				//lowestScores[j] = lowest;
				count++;
			}
			count = 1;
			System.out.println();
		}
 
		return lowest;
	}

	
	public static double[] averageCalc(){
		for(int i = 0 ; i < totalScores.length ; i++){
			averages[i] = totalScores[i] / subjectNumber;

		}
		return averages;
	}






	public static void main(String[] args){
	
		System.out.println("How many students do you have?");
		studentNumber = scanner.nextInt(); 
		
		System.out.println("How many subjects do they offer?");
		subjectNumber = scanner.nextInt();
	
		studentSubject = new double[studentNumber][subjectNumber];
		highestScores = new double[subjectNumber];
		highestStudent = new int[subjectNumber];
		//lowestScores = new double[subjectNumber];
		lowestStudent = new int[subjectNumber];
		totalScores = new double[studentNumber];
		averages = new double[studentNumber];
		System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Saved Successfully");

		System.out.println();
		System.out.println();

		infoPrompt();
		System.out.println(Arrays.deepToString(studentSubject));
		System.out.println(Arrays.toString(totalScores));
		System.out.println(Arrays.toString(averageCalc()));
		System.out.println(getHighest());
		//System.out.println(Arrays.toString(getLowest()));
		//System.out.println(getLowest());
		System.out.println(lowestScores);
	}
}