
public class Countdown{

	// String op count
	String opStr;
	//boolean exitLoop = false;
	double target;
	double numsIn[];
	String allAnswers="";
	// tgt number to reach, n - the array of numbers to test.
	Countdown(int tgt, double[] n){
		target = (double)tgt;
		numsIn = n;
		opStr = "";
	}
	String getAnswers(){
		//System.out.println(allAnswers);
		if (allAnswers.length() >0){
			return allAnswers;
		}else{
			return "pass";
		}
		
	}
	// 
	public double add(double x, double y){ //case 0
		opStr += String.valueOf(x) + " + " + String.valueOf(y) + " "; 
		return x + y;
	}


	public double sub(double x, double y){ //case 1
		opStr += String.valueOf(x) + " - " + String.valueOf(y)  + " ";
		return x - y;
	}

	public double mul(double x, double y){ //case 2
		opStr += String.valueOf(x) + " * " + String.valueOf(y) + " ";
		return x * y;
	}


	public double div(double x, double y){ 
	//case 3.... if throws, catch, set break flag in member var
		if (x == 0.0 || y == 0.0) {
			//exitLoop = true;
			// Java will just give 0.0
			return x / y;
		}
		else {
			opStr += String.valueOf(x) + " / " + String.valueOf(y) + " ";
			return x / y;
		}
	}
	// to pick any of the methods above based on index numbers
	public double opChoice(int index, double X, double Y){
		double answer = 0.0;
		switch (index) {
			case 0:
				answer = add(X,Y);
				break;
			case 1:
				answer = sub(X,Y);
				break;
			case 2:
				answer = mul(X,Y);				
				break;
			case 3:
				answer = div(X,Y);				
				break;
		}
		return answer;
	}
	
	public void run(){
		
		for(int x = 0; x < numsIn.length; x++){
			if (numsIn[x] == target){ // or skip all this
				//System.out.print("Solution found: " + numsIn[x]  +"\n");
				allAnswers += String.valueOf(numsIn[x]) + "\n";
			}
		}
		// if simplest is not there...
		IndexArrays dex = new IndexArrays(); // to acces ops
		NumberArrays nums = new NumberArrays(numsIn);
		
		// order of test: if one number is equal to target, if two numbers use just one op no need for arrays
		// then the combo way
		
		// only two numbers so its less complicated
		
		for (int z = 0; z < nums.numTwos.size(); z++) {
			double[] numbers = (double[])nums.numTwos.get(z);
			if(add(numbers[0], numbers[1]) == target){
				//System.out.println("2nSolution found: "+ opStr+ "= " + String.valueOf(target)); 
				allAnswers += opStr+"\n";
			}
			opStr = " ";
			if(sub(numbers[0], numbers[1]) == target){
				//System.out.println("2nSolution found: "+ opStr+ "= " + String.valueOf(target));
				allAnswers += opStr+"\n";
			}
			opStr = " ";
			if(mul(numbers[0], numbers[1]) == target){
				//System.out.println("Solution found: " + numbers[0] + " mul " + numbers[1] +"\n");
				//System.out.println("2nSolution found: "+ opStr + "= " + String.valueOf(target));
				allAnswers += opStr+"\n";
			}
			opStr = " ";
			if(div(numbers[0], numbers[1]) == target){
				//System.out.println("2nSolution found: "+ opStr + "= " + String.valueOf(target));
				allAnswers += opStr+"\n";
			}
			opStr = " ";			
		}
		opStr = " ";
		// now 3
		for (int z = 0; z < nums.numThrees.size(); z++) {
			double[] numbers = (double[])nums.numThrees.get(z);
			for (int x = 0; x < dex.twoIndex.size(); x++) {
				int[] oper = (int[])dex.twoIndex.get(x);
				double a = opChoice(oper[0], numbers[0], numbers[1]);	
				double b = opChoice(oper[1], a, numbers[2]);	// ops might be the same anyway remember.
				if (b == target){
					//System.out.println("3nSolution found: "+opStr+ "= " + String.valueOf(target));
					allAnswers += opStr+"\n";
				}
				opStr = " ";
			}
		}
		//System.out.println("opstr: "+opStr);
		// now 4
		for (int z = 0; z < nums.numFours.size(); z++) {
			double[] numbers = (double[])nums.numFours.get(z);
			for (int x = 0; x < dex.threeIndex.size(); x++) {
				int[] oper = (int[])dex.threeIndex.get(x);
				double a = opChoice(oper[0], numbers[0], numbers[1]);	
				double b = opChoice(oper[1], a, numbers[2]);	
				double c = opChoice(oper[2], b, numbers[3]);	
				if (c == target){
					//System.out.println("4nSolution found: "+opStr+ "= " + String.valueOf(target));
					allAnswers += opStr+"\n";
				}
				opStr = " ";
			}
		}
		// now 5
		for (int z = 0; z < nums.numFives.size(); z++) {
			double[] numbers = (double[])nums.numFives.get(z);
			for (int x = 0; x < dex.fourIndex.size(); x++) {
				int[] oper = (int[])dex.fourIndex.get(x);
				double a = opChoice(oper[0], numbers[0], numbers[1]);	
				double b = opChoice(oper[1], a, numbers[2]);	
				double c = opChoice(oper[2], b, numbers[3]);	
				double d = opChoice(oper[3], c, numbers[4]);	
				if (d == target){
					//System.out.println("5nSolution found: "+opStr+ "= " + String.valueOf(target));
					allAnswers += opStr+"\n";
				}
				opStr = " ";
			}
		}
		// now 6
		for (int z = 0; z < nums.numSixes.size(); z++) {
			double[] numbers = (double[])nums.numSixes.get(z);
			for (int x = 0; x < dex.fiveIndex.size(); x++) {
				int[] oper = (int[])dex.fiveIndex.get(x);
				double a = opChoice(oper[0], numbers[0], numbers[1]);	
				double b = opChoice(oper[1], a, numbers[2]);	
				double c = opChoice(oper[2], b, numbers[3]);	
				double d = opChoice(oper[3], c, numbers[4]);
				double e = opChoice(oper[3], d, numbers[5]);
				/*if (exitLoop == true){
					break;
				}*/	
				if (e == target){
					//System.out.println("6nSolution found: "+opStr+ "= " + String.valueOf(target));
					allAnswers += opStr+"\n";
				}
				opStr = " ";
			}
		}
	}
	
}

