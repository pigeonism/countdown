import java.util.ArrayList;

public class IndexArrays{
	
	
	//#0#0#0#0#0#
	// index arrays
	ArrayList<Object> twoIndex, threeIndex, fourIndex, fiveIndex;
	
	IndexArrays(){

		//twoIndex = new int[16][4];
		twoIndex = new ArrayList<Object>();
		threeIndex = new ArrayList<Object>();
		fourIndex = new ArrayList<Object>();
		fiveIndex = new ArrayList<Object>();
		buildTwosArray();
		buildThreesArray();
		buildFoursArray();
		buildFivesArray();
	}
	
	public void buildTwosArray(){
		
		for(int x = 0; x < 4; x++){
			for(int y = 0; y < 4; y++){
				int  temp[] = {x,y};
				twoIndex.add(temp);
			}
		}
	}
	
	public void buildThreesArray(){
		
		for(int x = 0; x < 4; x++){
			for(int y = 0; y < 4; y++){
				for(int z = 0; z < 4; z++){
					//System.out.print(x + ":" + y + ":" + z +"\n");
					int  temp[] = {x,y,z};
					threeIndex.add(temp);
				}
			}
		}
	}
	public void buildFoursArray(){
		
		for(int w = 0; w < 4; w++){
			for(int x = 0; x < 4; x++){
				for(int y = 0; y < 4; y++){
					for(int z = 0; z < 4; z++){
						//System.out.print(w + ":" + x + ":" + y + ":"+ z + "\n");
						int  temp[] = {w,x,y,z};
						fourIndex.add(temp);
					} 
				}
			}
			
		}
	}
	// only one with addedva
	public void buildFivesArray(){
		for(int v = 0; v < 4; v++){
			for(int w = 0; w < 4; w++){
				for(int x = 0; x < 4; x++){
					for(int y = 0; y < 4; y++){
						for(int z = 0; z < 4; z++){
							//System.out.print(w + ":" + x + ":" + y + ":"+ z + "\n");
							int  temp[] = {v,w,x,y,z};
							fiveIndex.add(temp);
						} 
					}
				}
			
			}
		}
	}
}
