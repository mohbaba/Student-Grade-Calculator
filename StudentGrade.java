import java.util.*;

public class StudentGrade {
	private static Scanner scanner = new Scanner(System.in);
	private static int studentNumber;
	private static int subjectNumber;
	private static double[][] studentSubject;
	private static double[] totalScores;
	private static double[] averages;
	private static double[] highestScores;
	private static int[] highestStudent;
	private static double[] lowestScores;
	private static int[] lowestStudent;


	public static void displayQuestions() {
        	System.out.println("How many students do you have?");
        	studentNumber = scanner.nextInt();

        	System.out.println("How many subjects do they offer?");
        	subjectNumber = scanner.nextInt();
	        studentSubject = new double[studentNumber][subjectNumber];
		totalScores = new double[studentNumber];

	        System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        	System.out.println("Saved Successfully");
        	System.out.println();
	        System.out.println();
	}
	
	public static void scoreInput() {
		for (int i = 0; i < studentNumber; i++) {
			for (int j = 0; j < subjectNumber; j++) {
			System.out.printf("Entering score for student %d%n", i + 1);
			System.out.printf("Enter score for subject %d%n", j + 1);
			double score = scanner.nextDouble();
			while (score < 0 || score > 100) {
				System.out.println("Enter correct score:");
				score = scanner.nextDouble();
			}
			studentSubject[i][j] = score;
			totalScores[i] += score;
			System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("Saved Successfully");
			System.out.println();
			}
		}
	}
	public static double[] getHighest() {
		highestScores = new double[subjectNumber];
		highestStudent = new int[subjectNumber];
		for (int j = 0; j < subjectNumber; j++) {
			double max = Double.MIN_VALUE;
			for (int i = 0; i < studentNumber; i++) {
				if (studentSubject[i][j] > max) {
				max = studentSubject[i][j];
				highestStudent[j] = i + 1;
				}
			}
		highestScores[j] = max;
		}
	return highestScores;
	}

	public static double[] getLowest() {
		lowestScores = new double[subjectNumber];
		lowestStudent = new int[subjectNumber];
	
		for (int j = 0; j < subjectNumber; j++) {
			double min = Double.MAX_VALUE;
			for (int i = 0; i < studentNumber; i++) {
				double score = studentSubject[i][j];
				if (score < min) {
					min = score;
					lowestStudent[j] = i + 1;
				}
			}
		lowestScores[j] = min;
		}

	return lowestScores;
	}

	public static double[] averageCalc() {
		averages = new double[studentNumber];
		for (int i = 0; i < studentNumber; i++) {
			averages[i] = totalScores[i] / subjectNumber;
		}
	return averages;
	}

	public static void displayTable(){
		int[] position = new int[studentNumber];
		System.out.println("==============================================================");
		System.out.print("STUDENT\t\t");
		
		for(int subject = 0; subject < subjectNumber ; subject++){
			System.out.printf("SUB %d\t", subject+1);

		}

		for(int i = 0 ; i < studentNumber ; i++){
			position[i] = 1;

			for(int j = 0; j < studentNumber ; j++){
				if(totalScores[j] > totalScores[i]){
					position[i]++;
				}
			}
		}

		System.out.print("TOT\t");
		System.out.print("AVE\t");
		System.out.println("POS\t");
		System.out.println("==============================================================");
		for(int student = 0; student < studentNumber ; student++){
			System.out.printf("Student %d\t", student+1);
			

			for(int subject = 0 ; subject < subjectNumber ; subject++){
				System.out.printf("%.0f\t",studentSubject[student][subject] );
			}
			System.out.printf("%.0f\t",totalScores[student]);
			System.out.printf("%.2f\t",averageCalc()[student]);
			System.out.printf("%d\t",position[student]);
			System.out.println();
		}
		System.out.println("==============================================================");
		System.out.println();
		System.out.println("==============================================================");
	}


	public static void subjectSummary(){
		System.out.println("SUBJECT SUMMARY");
		for(int subject = 0; subject < subjectNumber; subject++){
			int numberOfPasses = 0;
			int numberOfFail = 0;
			double total =0;
			double highestScore = studentSubject[0][subject];
			int highestStudent = 0;
			double lowestScore = studentSubject[0][subject];
			int lowestStudent = 0;
			System.out.printf("Subject %d%n", (subject + 1));

			for(int student = 0 ; student < studentNumber ; student++){
				double score = studentSubject[student][subject];
				total += score;
				if(score >= 50){
					numberOfPasses++;
				}else
				if(score < 50){
					numberOfFail++;
				}
				
				if(score > highestScore){
					highestScore = score;
					highestStudent = student;
				}else

				if(score < lowestScore){
					lowestScore = score;
					lowestStudent = student;
				}



			}
			double average = total / studentNumber;
			
			System.out.printf("Highest scoring student is: student %d scoring %f%n", highestStudent + 1, highestScore);
			System.out.printf("Lowest scoring student is: student %d scoring %f%n", lowestStudent + 1, lowestScore);
			System.out.printf("Total score is: %.0f%n", total);
			System.out.printf("Average score is: %.2f%n", average);
			System.out.printf("Number of passes is: %d%n", numberOfPasses);
			System.out.printf("Number of fails is: %d%n%n%n", numberOfFail);
		}		


	}

	public static void classSummary(){
		int hard = 0;
		int tempHard = 1;
		int tempEasy = 1;
		int easy = 0;
		int count = 1;
		double high = Double.MIN_VALUE;
		double low = Double.MAX_VALUE;
		int lowStud = 0;
		int highStud = 0;
		int lowSub = 0;
		int highSub = 0;
		double best = Double.MIN_VALUE;
		double worst = Double.MAX_VALUE;
		int bestCount = 0;
		int worstCount = 0;
		int subjectPasses[] = new int[subjectNumber];
		int subjectFails[] = new int[subjectNumber];
		double totalScore[] = new double[studentNumber];
		double total = 0;
		double average = 0;
		for(int subject = 0; subject < subjectNumber; subject++){
			int pass = 0;
			int fail = 0;
			for(int student = 0 ; student < studentNumber ; student++){
				double score = studentSubject[student][subject];
				totalScore[student] += score;
				if(score >= 50){
					pass++;
				}else
				if(score < 50){
					fail++;
				}
			}
			
			subjectPasses[subject] = pass;
			subjectFails[subject] = fail;
 			
		}
		
		for(int i = 0; i < totalScore.length ; i++){
			

			total += totalScore[i];
			if(totalScore[i] > best){
				best = totalScore[i];
				bestCount = i;
			}
			if(totalScore[i] < worst){
				worst = totalScore[i];
				worstCount = i;
			}
		}
		
		for(int i = 0 ; i < subjectNumber ; i++){
			
			if(subjectPasses[i] > hard){
				easy = subjectPasses[i];
				tempEasy = i;
			}
			if(subjectFails[i] > easy  ){
				hard = subjectFails[i];
				tempHard = i;
			}
			if(getHighest()[i] > high){
				high = getHighest()[i];
				highStud = highestStudent[i];
				highSub = i;
			}
			if(getLowest()[i] < low){
				low = getLowest()[i];
				lowStud = lowestStudent[i];
				lowSub = i;
			}

		}
		average = total / studentNumber;
		

		System.out.printf("The hardest subject is Subject %d with %d failures%n",tempHard+1,hard);
		System.out.printf("The easiest subject is Subject %d with %d passes%n",tempEasy+1,easy);
		System.out.printf("The overall Highest score is scored by Student %d in subject %d scoring %.2f%n",highStud,highSub+1, high);
		System.out.printf("The overall Lowest score is scored by Student %d in subject %d scoring %.2f%n",lowStud,lowSub+1, low);
		System.out.println("==================================================================");

		System.out.println();
		System.out.println();
		System.out.println("CLASS SUMMARY");
		System.out.println("==================================================================");
		System.out.printf("Best Graduating Student is: Student %d scoring %.0f%n", bestCount+1 , best);
		System.out.println("==================================================================");

		System.out.println();
		System.out.println();

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.printf("Worst Graduating Student is: Student %d scoring %.0f%n", worstCount+1 , worst);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		System.out.println();
		System.out.println();

		System.out.println("==================================================================");
		System.out.printf("Class Total Score is:  %.0f%n", total);
		System.out.printf("Class Average Score is: %.0f%n", average);
		System.out.println("==================================================================");

	}	
	
	public static void main(String[] args) {
        	displayQuestions();
        	scoreInput();
		displayTable();
		System.out.println();
		subjectSummary();
		classSummary();
		System.out.println();
        	
		
    	}
}

