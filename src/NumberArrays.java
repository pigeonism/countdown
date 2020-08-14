import java.util.ArrayList;

public class NumberArrays{
	// different from operation index arrays, not allowed to have the same number in an array[x], but 
	// same numbers of prev array[x-any] is fine and needed
	ArrayList<Object> numTwos, numThrees, numFours, numFives, numSixes;
	double[] iNums;

	NumberArrays(double[] nums){
		iNums = nums;
		buildMultiNumArrays();
		
	}
	

	public void buildMultiNumArrays(){
		// unlike operator index array, values here cant be repeated in the same array.
		// build in stages, twos upto threes, seperately
		
		numTwos = new ArrayList<Object>(); //first step, built on for numthrees
		for(int a = 0; a < 6; a++){
			for(int b = 0; b < 6; b++){
				if (iNums[a] != iNums[b]){
					//System.out.print(iNums[a]+":"+iNums[b]+ "\n");
					double[] temp = {iNums[a], iNums[b]};
					numTwos.add(temp);
				}
			}		
		}
		// now threes, using above
		numThrees = new ArrayList<Object>();
		for (int z = 0; z < numTwos.size(); z++) {
			double[] twos = (double[])numTwos.get(z);
			for(int a = 0; a < 6; a++){
				if (twos[0] != iNums[a] && twos[1] != iNums[a]){
					//System.out.print(twos[0]+ ":" + twos[1]+ ":"+iNums[a]+"\n");
					double[] temp = {twos[0], twos[1], iNums[a]};
					numThrees.add(temp);
				}
			}
				
			
		}
		// now fours, using above
		numFours = new ArrayList<Object>();
		for (int z = 0; z < numThrees.size(); z++) {
			double[] threes = (double[])numThrees.get(z);
			for(int a = 0; a < 6; a++){
				if (threes[0] != iNums[a] && threes[1] != iNums[a] && threes[2] != iNums[a]){
					//System.out.print(threes[0]+ ":" + threes[1]+ ":"+ threes[2]+":"+iNums[a]+"\n");
					double[] temp = {threes[0], threes[1], threes[2], iNums[a]};
					numFours.add(temp);
				}
			}
				
			
		}
		// now fivess, using above
		numFives = new ArrayList<Object>();
		for (int z = 0; z < numFours.size(); z++) {
			double[] fours = (double[])numFours.get(z);
			for(int a = 0; a < 6; a++){
				if (fours[0] != iNums[a] && fours[1] != iNums[a] && fours[2] != iNums[a] && fours[3] != iNums[a]){
					//System.out.print(fours[0]+ ":" + fours[1]+ ":"+ fours[2]+":"+fours[3]+":"+iNums[a]+"\n");
					double[] temp = {fours[0], fours[1], fours[2],fours[3], iNums[a]};
					numFives.add(temp);
				}
			}
				
			
		}
		// now sixess, using above
		numSixes = new ArrayList<Object>();
		for (int z = 0; z < numFives.size(); z++) {
			double[] fives = (double[])numFives.get(z);
			for(int a = 0; a < 6; a++){
				if (fives[0] != iNums[a] && fives[1] != iNums[a] && fives[2] != iNums[a] && fives[3] != iNums[a] && fives[4] != iNums[a]){
					//System.out.print(fives[0]+ ":" + fives[1]+ ":"+ fives[2]+":"+fives[3]+":"+fives[4]+":"+iNums[a]+"\n");
					double[] temp = {fives[0], fives[1], fives[2],fives[3],fives[4], iNums[a]};
					numSixes.add(temp);
				}
			}
				
			
		}

	}// end 
}
