
package question;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.io.*;
import java.util.*;

public class CityNavigator
{  

	public static int pathFinder(String startCity, String targetCity) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		ArrayList<String> roadsList = new ArrayList<String>();
		File file = new File("cities_and_distances.txt");
		Scanner sc;
		ArrayList<Integer> roadLong = new ArrayList<Integer>();
		ArrayList<String> unvisitedList = new ArrayList<>();
		
		try {
			sc = new Scanner(file);
			
			while (sc.hasNext()) {
				String tempString = sc.nextLine();
				
				
				String[] way =  tempString.split(":");
				roadLong.add(Integer.parseInt(way[1]) );
				roadLong.add(Integer.parseInt(way[1]) );
				
//				tempArrayList.add(way[0].split("-"));
			
				// two city names in form AB
				if(unvisitedList.contains(way[0].substring(0,1))==false){
					unvisitedList.add(way[0].substring(0,1));
				}
				if(unvisitedList.contains(way[0].substring(2,3))==false){
					unvisitedList.add(way[0].substring(2,3));
				}
				
				way[0]= way[0].substring(0,1) + way[0].substring(2,3);
				roadsList.add(way[0]);
				
				String[] reverseStrings = tempString.split(":");
				reverseStrings[0] = reverseStrings[0].substring(2,3) + reverseStrings[0].substring(0,1);
				roadsList.add(reverseStrings[0]);
//				tempArrayList.add(reverseStrings[0].split("-"));
				
				
			}

			ArrayList<String> vertexList = (ArrayList<String>) unvisitedList.clone();
			String[] path = new String[vertexList.size()];

			int[] shorthestDistance = new int[vertexList.size()];
			
			for (int i = 0 ; i < vertexList.size() ; i++) {
				if (i != vertexList.indexOf(startCity))
				shorthestDistance[i] = Integer.MAX_VALUE-100000;
			}
			
			
			String currentVertex = startCity;
			while (unvisitedList.size() > 1) {
				unvisitedList.remove(currentVertex);
				
				int i = 0;
				for( String road:roadsList) {
					if (road.startsWith(currentVertex)) {
						if ( shorthestDistance[ vertexList.indexOf(road.substring(1,2))] >roadLong.get(i) + shorthestDistance[vertexList.indexOf(currentVertex)]) {
							shorthestDistance[ vertexList.indexOf(road.substring(1,2))] =roadLong.get(i)+ shorthestDistance[vertexList.indexOf(currentVertex)];
							path[vertexList.indexOf(road.substring(1,2))] = currentVertex;
							
						}
					
					}
					i++;
				}
				int minIndex =0;
				int min= Integer.MAX_VALUE;
				for ( int j = 0; j< unvisitedList.size() ; j++ ) {
					if ( shorthestDistance[ vertexList.indexOf( unvisitedList.get(j))] <  min) {
						min = shorthestDistance[ vertexList.indexOf( unvisitedList.get(j))];
						minIndex = j;
					}
				}
		
				
				currentVertex = unvisitedList.get(minIndex);
				
				
				
			}

			
			
	
			
			int res = shorthestDistance[vertexList.indexOf(targetCity)];
			
			if (res != Integer.MAX_VALUE-100000 ) {
				String reversepath = targetCity;
				ArrayList<String> rightArrayList = new ArrayList<>();
				rightArrayList.add(reversepath);
				while (reversepath!= startCity) {
				
					
					reversepath = path[vertexList.indexOf(reversepath)];
					rightArrayList.add(reversepath);
					rightArrayList.add(reversepath);

				}
				rightArrayList.remove(rightArrayList.size()-1);
				
		
				
				String finalpath = rightArrayList.toString();
				System.out.print("[");
				int x = 0;
				System.out.print(rightArrayList.get(rightArrayList.size()-1));
				
				
				
				for (int i = rightArrayList.size()-2 ; i >= 0 ; i--) {
					if (x%2==1) {
					System.out.print(",");
					System.out.print(rightArrayList.get(i));
					x++;
					}else {
					
					System.out.print("-");
					x++;
					System.out.print(rightArrayList.get(i));
					}
				}
				
				System.out.print("]");
			return res;
			}else {
				return 0;
			}
			
			

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
		
		
		
		
		
		



		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}
	


}  

