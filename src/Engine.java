import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Engine {
	static ArrayList<Double> TallReduc = new ArrayList<Double>();
	static ArrayList<Integer> TGearsHold = new ArrayList<Integer>(Collections.nCopies(12, 0));
	
	
	
	public static void main(String args[]) throws IOException {
		Arrays arr = new Arrays();

		
		
		/*for(int i = 0; i<10; i++) {
			System.out.println(arr.DallReduc.get(i));
		}*/
		
		
		
		
		
		
		TallReduc.add(100.0);
		TallReduc.add(50.0);
		TallReduc.add(0.0);
		
		
		for(int i = 0; i<arr.DallReduc.size(); i++){
	        for(int j = 0; j<arr.allReduc.length-1; j++){
	        		
	            double sur = arr.DallReduc.get(i) * arr.allReduc[j];
	            int k = findPos(TallReduc, sur ,0 ,TallReduc.size()-1);
	            System.out.println("i:"+ i+" j:"+j+" k:"+k);
	            if (k == -1) {
	                //NSLog(@"DONE did IT UP");
	                break;
	            }else if(k==-2){
	                //repeat number - see above
	            }else{
	                //NSLog(@"k = %d", k );
	                TallReduc.add(k, sur);
	                TGearsHold.add(k*6, arr.DGearHold.get(i*4)); 
	                TGearsHold.add(k*6+1, arr.DGearHold.get(i*4+1));
	                TGearsHold.add(k*6+2, arr.DGearHold.get(i*4+2));
	                TGearsHold.add(k*6+3, arr.DGearHold.get(i*4+3));
	                TGearsHold.add(k*6+4, arr.Gearhold[j*2]);
	                TGearsHold.add(k*6+5, arr.Gearhold[j*2+1]);
	            }
	        }
	        
	    }
	    
	    TallReduc.remove(0.0);
	    TallReduc.remove(50.0);
	    TallReduc.remove(100.0);
	    for(int i = 0; i<12; i++) {TGearsHold.remove(0);}
	    
	    BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/admin/Documents/workspace/GearCalc/src/TallReduc", true));
	    BufferedWriter writer1 = new BufferedWriter(new FileWriter("/Users/admin/Documents/workspace/GearCalc/src/TGearHold", true));
 		
 		for(int i =0; i<TallReduc.size(); i++){
	    		writer.append(""+TallReduc.get(i));
	    		writer.append(" ");
	    		
	    }
	    for(int i =0; i<TGearsHold.size(); i++){
	    		writer.append(""+TGearsHold.get(i));
	    		writer.append(" ");
	    }
	    writer.close();
	    writer1.close();
	    
	    ask();
	}
	
	public static void ask() throws FileNotFoundException {
		Arrays arr = new Arrays();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("What reduc do you want?");
		double dReductionOne =scan.nextDouble();
		System.out.println("How man stages");
		int stages =scan.nextInt();
		
		double reduction = 1/dReductionOne;
		double closRed = Double.MAX_VALUE;
		ArrayList<String> closest = new ArrayList<String>();
        //NSLog(@"@%f", reduction);
        
        switch (stages){
                case 1:
                for(int i = 0; i<arr.allReduc.length; i++){
                    if(Math.abs(arr.allReduc[i] - reduction)<=closRed){
                        closRed = Math.abs(arr.allReduc[i] - reduction);
                        closest.add(0,""+1/Math.abs(arr.allReduc[i]) + " - ("+ arr.Gearhold[i*2]+","+arr.Gearhold[i*2+1]+")");
                        
                        
                    } else{
                        break;
                    }
                }
                
                
                
                break;
                
                case 2:
                
                for(int i = 0; i<arr.DallReduc.size(); i++){
                    if(Math.abs(arr.DallReduc.get(i) - reduction)<=closRed){
                        closRed = Math.abs(arr.DallReduc.get(i) - reduction);
                        closest.add(0,""+1/Math.abs(arr.DallReduc.get(i)) + " - ("+ arr.DGearHold.get(i*4)+","+arr.DGearHold.get(i*4+1)+")("+arr.DGearHold.get(i*4+2)+","+arr.DGearHold.get(i*4+3)+")");                        
                    } else{
                        break;
                    }
                }

                break;/*
                
                case 3:
                
                for(int i = 0; i<[self.TallReduc count]; i++){

                    if(fabs([[self.TallReduc objectAtIndex:i] doubleValue] - reduction)<=closRed){
                        closRed = fabs([[self.TallReduc objectAtIndex:i] doubleValue] - reduction);
                        [self.closest addObject:[NSString stringWithFormat:@"%f - (%@,%@), (%@,%@), (%@,%@)", 1/fabs([[self.TallReduc objectAtIndex:i] doubleValue]), [self.TGearsHold objectAtIndex:i*6], [self.TGearsHold objectAtIndex:i*6+1],[self.TGearsHold objectAtIndex:i*6+2],[self.TGearsHold objectAtIndex:i*6+3],[self.TGearsHold objectAtIndex:i*6+4],[self.TGearsHold objectAtIndex:i*6+5]]];
                        
                        
                    } else{
                        break;
                    }
                }
                break;
                
                /*case 4:
                for(int i = 0; i<[self.QallReduc count]; i++){
                    
                    if(fabs([[self.QallReduc objectAtIndex:i] doubleValue] - reduction)<=closRed){
                        closRed = fabs([[self.QallReduc objectAtIndex:i] doubleValue] - reduction);
                        finalReducOne = closRed+reduction;
                        [self.closest addObject:[NSString stringWithFormat:@"%f - (%@,%@), (%@,%@), (%@,%@), (%@,%@)", 1/fabs([[self.QallReduc objectAtIndex:i] doubleValue]), [self.QGearsHold objectAtIndex:i*8], [self.QGearsHold objectAtIndex:i*8+1],[self.QGearsHold objectAtIndex:i*8+2],[self.QGearsHold objectAtIndex:i*8+3],[self.QGearsHold objectAtIndex:i*8+4],[self.QGearsHold objectAtIndex:i*8+5],[self.QGearsHold objectAtIndex:i*8+6],[self.QGearsHold objectAtIndex:i*8+7]]];

                        
                        
                    } else{
                        break;
                    }
                }

                break;*/
                
                default:
                break;
        }
        System.out.println(closest.toString());
		
	}
	public static int findPos(ArrayList<Double> arr, double nums, int start, int end) {
		int mid = (start + end)/2;
		if(arr.get(mid)-nums == 0) {
			return -2;
		} else if((double)arr.get(mid)>nums && (double)arr.get(mid+1)<nums) {
			return mid+1;
		} else if(mid == 0) {
			return 0;
		} else if ((double)arr.get(mid)>nums) {
			return findPos(arr, nums, mid, end);
		} else if((double)arr.get(mid)<nums) {
			return findPos(arr, nums, start, mid);
		} else {
			return -1;
		}
	}
}
