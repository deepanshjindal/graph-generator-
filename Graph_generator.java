





import java.util.ArrayList;
import java.util.Vector;


import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.io.*;

public class Graph_generator implements Comparable<Graph_generator>{

	String name;
	int value;
	public Graph_generator(String s , int x) {
		this.name = s;
		this.value = x;
		
	}
	@Override
	public int compareTo(Graph_generator o) {
		// TODO Auto-generated method stub
		if(this.value > o.value) {
			return 1;}
		else if(this.value<o.value) {
			return -1;}
			
		return this.name.compareTo(o.name);
	}
	
	public static void main(String args[]) throws IOException{
		 //FileOutputStream f = new FileOutputStream("myo.txt");
  //System.setOut(new PrintStream(f));
		//Scanner sc = new Scanner(System.in);
		//String nodeaddress=sc.next();
		//String edgeaddress =sc.next();
		String nodeaddress=args[0];
				String edgeaddress =args[1];
				
		HashMap<String, LinkedList<Graph_generator>> hashmap = new HashMap<String, LinkedList<Graph_generator>>();
		File csvfile = new File(nodeaddress);
		BufferedReader br = new BufferedReader(new FileReader(csvfile));
		String line  = "";
		int iter1 = 0;
		try {
			while( (line = br.readLine()) != null) {
				if(iter1 ==0) {
					iter1++;
					continue;
				}
					String[] count = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					//System.out.println(count[0]);
					String a = count[1].replaceAll("^\"+|\"+$", "");
					//int x = count.length;
//					int y = x/2;
//					String a = "";
//					while(y<x) {
//					if(x!=2) {
//						String s = count[y];
//						if(y==x/2) {
//							
//							s = s.substring(1);
//							if(a=="") {
//								a = a+s;
//							}
//						}
//						else if (y==x-1) {
//							s =s.substring(0, s.length()-1);
//						a = a + "," + s;
//						}
//						else {
//							a= a+ "," + s;
//						}
//						
//						y++;
//						
//						}
//					else if(x==2) {
//						
//					
//					if(a=="") {
//						a= a+count[y];
//					}
//					else {
//						a = a+"," + count[y];}
//					y++;
//
//					}
//					}
//					
				
				//System.out.println(a);
					//csvread c1= new csvread(a,-1);
					LinkedList<Graph_generator> l = new LinkedList<>();
					//l.add(c1);
					
					
					hashmap.put(a, l);
					
					
					
			}
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	
		File csvfile2 = new File(edgeaddress);
		BufferedReader br2 = new BufferedReader(new FileReader(csvfile2));
		String line2  = "";
		int iter2 = 0;
	//	line2 = br2.readLine();
		int iter3 = 0;
		
		try {
			while( (line2 = br2.readLine()) !=null) {
				//iter3++;
				if(iter2 == 0) {
					iter2++;
					continue;
				}
				String[] count2 = line2.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				String first = count2[0].replaceAll("^\"+|\"+$", "");
				String second = count2[1].replaceAll("^\"+|\"+$", "");
				int weight = Integer.parseInt(count2[2]);
				LinkedList<Graph_generator> list1 = hashmap.get(first);
				LinkedList<Graph_generator> list2 = hashmap.get(second);
				Graph_generator temp1 = new Graph_generator(second , weight);
				list1.add(temp1);
				Graph_generator temp2 = new Graph_generator(first , weight);
				list2.add(temp2);
//				String first ="a";
//				String second = "b";
//				int weight = 0 ;
//				int x = count2.length;
//				//System.out.println(line2);
//				
//				if(x == 3) {
//					
//					first = count2[0];
//					second = count2[1];
//					weight = Integer.parseInt(count2[2]);
//					LinkedList<assignment4> list1 = hashmap.get(first);
//					LinkedList<assignment4> list2 = hashmap.get(second);
//					if(list1 == null || list2 == null) {
//						//System.out.println("errorfound::" + first +"  " +  second);
//					}
//					if(list1 != null) {
//						assignment4 temp = new assignment4(second , weight);
//						list1.add(temp);
//						
//					}
//					if(list2 !=null) {
//						assignment4 temp1 = new assignment4(first , weight);
//						list2.add(temp1);
//						//System.out.println("XXXXXXXX");
//					}
//					
//				}
//				else if ( x!=3) {
//					String first1 = count2[0];
//					char ch1 =first1.charAt(0);
//					//System.out.println("XXXXXXXX");
//					if(ch1 == '"') {
//						//System.out.println("XXXXXXXX");
//						int y = 0;
//						String s1 =count2[0].substring(1);
//						first = s1;
//						y++;
//						while(count2[y].charAt(count2[y].length()-1) != '"' ) {
//							first = first + "," +count2[y];
//							y++;
//							
//						}
//						first = first + ","+count2[y].substring(0,count2[y].length()-1);
//						y++;
//						char ch2 = count2[y].charAt(0);
//						if(ch2 != '"') {
//							second = count2[y];
//							weight =  Integer.parseInt(count2[y+1]);
//							
//						}
//						else if(ch2 == '"') {
//							//System.out.println("XXXXXXXX");
//							String s2 = count2[y].substring(1);
//							//System.out.println(s2);
//							second = s2;
//							y++;
//							while( count2[y].charAt(count2[y].length()-1) != '"') {
//								second = second + "," + count2[y];
//								y++;
//								
//							}
//							second = second + "," + count2[y].substring(0,count2[y].length()-1);
//							y++;
//							weight = Integer.parseInt(count2[y]);}
//							
//							LinkedList<assignment4> list1 = hashmap.get(first);
//							LinkedList<assignment4> list2 = hashmap.get(second);
//							if(list1 == null || list2 == null) {
//								//System.out.println("errorfound::" + first +"  " +  second);
//							}
//							if(list1 != null) {
//								assignment4 temp = new assignment4(second , weight);
//								list1.add(temp);
//								//System.out.println(list1.getFirst().name);
//							}
//							if(list2 !=null) {
//								assignment4 temp1 = new assignment4(first , weight);
//								list2.add(temp1);
//							}
//							
//						}
//						
//						
//						
//						
//					
//					else if(ch1 != '"') {
//						int y = 0;
//						 first = count2[y];
//						 y++;
//						char ch2 = count2[y].charAt(0);
//						if(ch2 != '"') {
//							 second = count2[y];
//							y++;
//							weight = Integer.parseInt(count2[y]);
//							y++;
//						}
//						else if(ch2 == '"') {
//							
//							String s2 = count2[y].substring(1);
//							 second = s2;
//							 y++;
//							while( count2[y].charAt(count2[y].length()-1) != '"') {
//								second = second + "," + count2[y];
//								y++;
//								
//							}
//							second = second + "," + count2[y].substring(0,count2[y].length()-1);
//							y++;
//							weight = Integer.parseInt(count2[y]);}
//							
//							LinkedList<assignment4> list1 = hashmap.get(first);
//							LinkedList<assignment4> list2 = hashmap.get(second);
//							if(list1 == null || list2 == null) {
//								//System.out.println("errorfound::" + first +"  " +  second);
//							}
//							if(list1 != null) {
//								assignment4 temp = new assignment4(second , weight);
//								list1.add(temp);
//							}
//							if(list2 !=null) {
//								assignment4 temp1 = new assignment4(first , weight);
//								list2.add(temp1);
//							}
//							
//							
//						}
//						
//					}
//					
//					
//				//System.out.println(first +":" +second +":"+ weight);
//					
					
					
				}
				
			
			
			
			//System.out.println(iter3);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	
		
		String func=args[2];
		//System.out.println(func);
		switch (func) {
            case "average":
                 average(hashmap);
                 break;
             case "rank":
                 rank(hashmap);
                 break;
             case "independent_storylines_dfs":
                 independent_storylines_dfs(hashmap);
                 break;
             default:
                 break;
         }
		
		
//		Iterator <String> it = hashmap.keySet().iterator();
//		int sum = 0;
//		int nodes = 0;
//		while(it.hasNext()) {
//			nodes++;
//			String key=(String)it.next();
//			LinkedList<csvread> x = hashmap.get(key);
//			int size = x.size();
//			sum = sum+size;
//		}
//		System.out.println("nodes:" +nodes);
//		System.out.println("size:" + sum);
//		float answ = sum/nodes;
//		System.out.println(answ);
		//System.out.println("average");
		//average(hashmap);
		//System.out.println("rank");
		//System.out.println("pp:" + pp);
		
		
		//rank(hashmap);
		//System.out.println();
		//System.out.println("idfs");
		//independent_storylines_dfs(hashmap);
		
	}
	
	public static void average(HashMap<String, LinkedList<Graph_generator>> hashmap){
		int sum = 0;
		int nodes = 0;
		
		for (Map.Entry<String, LinkedList<Graph_generator>> set : hashmap.entrySet()) {
			nodes++;
			String key = set.getKey();
			LinkedList<Graph_generator> x = hashmap.get(key);
			int size = x.size();
			sum = sum+size;
		}
		if(nodes == 0) {
			float ans = 0;
			System.out.printf("%.2f",ans);
			System.out.println();
			return;
		}
		
		float answ = (float)sum/nodes;
		System.out.printf("%.2f", answ);
		System.out.println();
		
	}
	

	public static void independent_storylines_dfs(HashMap<String, LinkedList<Graph_generator>> hashmap) {
		
		HashMap<String, Integer> visitcheck = new HashMap<>();
		for (Map.Entry<String, LinkedList<Graph_generator>> set : hashmap.entrySet()) {
			String key = set.getKey();
			visitcheck.put(key, 0);			
			
		}
		int indcount = 0;
		for (Map.Entry<String, LinkedList<Graph_generator>> set : hashmap.entrySet()) {
			String key = set.getKey();
			if(visitcheck.get(key) == 0) {
			indcount++;
			visitcheck.replace(key, 0, indcount);
			markvisited( visitcheck,hashmap , indcount , key);}
			
			
		}
		
		//System.out.println(indcount);
		
		ArrayList<ArrayList<String>> conncomp= new ArrayList<>(indcount); 
		for(int i = 0 ; i< indcount ; i++) {
			ArrayList<String> tee = new ArrayList<String>();
			
			conncomp.add(tee);
		}

		
		for (Map.Entry<String,Integer> set : visitcheck.entrySet()) {
			String key = set.getKey();
			int label = visitcheck.get(key);
			//System.out.println("ll:" +co);
			(conncomp.get(label-1)).add(key);
			
		}
		//System.out.println(conncomp.get(0).get(1) + " old");
		for(int i = 0 ; i< conncomp.size();i++) {
			quicksort2(conncomp.get(i), 0,conncomp.get(i).size()-1);
		}
		
		//System.out.println(conncomp.get(0).get(1));
		quicksort3(conncomp,0,conncomp.size()-1);
		for(int i = 0 ; i <conncomp.size();i++) {
			printlist(conncomp.get(i));
			System.out.println();
			
		}
		
		
	}
	
	public static void printlist(ArrayList<String> list) {
		
		for(int i =0 ; i<list.size();i++) {
			if(i == list.size()-1) {
				System.out.print(list.get(i));
				break;
			}
			System.out.print(list.get(i)+ ",");
			
		}
		
		
	}
	
	public static void quicksort3(ArrayList<ArrayList<String>> list , int low , int high) {
		if(low>=high) {
			return;
		}
		int i = low ;
		int j = high;
		int pivotindex = (i+j)/2;
		
		ArrayList<String> pivot = list.get(pivotindex);
		
		while(i<=j) {
			while( comparelist(list.get(i), pivot) > 0 ) {
				i++;
			}
			while( comparelist(list.get(j), pivot)< 0) {
				j--;
				
			}
			
			if(i<=j) {
				swap3(list,i,j);
				i++;
				j--;	
			}
		}
		
		if(low<j) {
			quicksort3(list , low ,j);
		}
		if(i<high) {
			quicksort3(list , i, high);
		}
		
		
		
		
	}
	
	public static  void swap3(ArrayList<ArrayList<String>> list , int i , int j) {
		ArrayList<String> temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
		
	}
	
	public static int comparelist(ArrayList<String> l1, ArrayList<String> l2) {
		
		if(l1.size()>l2.size()) {
			return 1;
		}
		else if (l2.size() > l1.size()) {
			return -1;
		}
		else {
			
			return l1.get(0).compareTo(l2.get(0));
		}
		
		
	}
	
	public static void quicksort2(ArrayList<String> list , int low , int high){
		if(low>=high) {
			return;
		}
		int i = low ;
		int j = high;
		//System.out.println("ll:" + i + "hh:" + j );
		int pivotindex = (i+j)/2;
		//System.out.println(pivotindex);
		String pivot = list.get(pivotindex);
		
		
		while(i<=j) {
			while( list.get(i).compareTo(pivot) > 0 ) {
				i++;
			}
			while(list.get(j).compareTo(pivot) < 0) {
				j--;
				
			}
			
			if(i<=j) {
				swap2(list,i,j);
				i++;
				j--;	
			}
		}
		
		
		
		if(low<j) {
			quicksort2(list , low ,j);
		}
		if(i<high) {
			quicksort2(list , i, high);
		}
		
		
		
		
		
		
		
	}
	public static void swap2(ArrayList<String> list , int i , int j) {
		String temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
		return;
		
		
	}
	
	public static void markvisited(HashMap<String, Integer> visitcheck, HashMap<String, LinkedList<Graph_generator>> hashmap, int indcount , String key) {
		
	for(int i = 0 ; i <hashmap.get(key).size() ; i++) {
		String temp = hashmap.get(key).get(i).name;
		if(visitcheck.get(temp) == 0) {
			visitcheck.replace(temp, 0, indcount);
			markvisited(visitcheck, hashmap, indcount, temp);
		}
		else if(visitcheck.get(temp)!= 0) {
			continue;
		}
		
	}
		
	}
	
	
	public static void rank(HashMap<String , LinkedList<Graph_generator>> hashmap) {
		
		ArrayList<Graph_generator> sort = new ArrayList<>();
	
		for (Map.Entry<String, LinkedList<Graph_generator>> set : hashmap.entrySet()) {
			int cooccur =0;
			String key = set.getKey();
			LinkedList<Graph_generator> x = hashmap.get(key);
			for(int i = 0 ; i<x.size();i++) {
				cooccur = cooccur + x.get(i).value;
				}
			//System.out.println(cooccur);
			Graph_generator z = new Graph_generator(key,cooccur);
			sort.add(z);
			
			
			
		}
		quicksort(sort , 0 , sort.size()-1);
		for(int l = 0 ; l<sort.size();l++) {
			if(l== sort.size()-1) {
				System.out.print(sort.get(l).name);
				break;
				
			}
//System.out.println(sort.get(l).value);
			System.out.print(sort.get(l).name + ",");
		}
	System.out.println();
	}
		
		public static void quicksort(ArrayList<Graph_generator> list , int a , int b) {
			if(a>=b) {
				return;
			}
			int i = a;
			int j = b;
			int pivotindex = (j+i)/2;
			Graph_generator pivot = list.get(pivotindex);
			
			while(i<=j) {
				while( list.get(i).compareTo(pivot) >0 ) {
					i++;
				}
				while(list.get(j).compareTo(pivot) < 0) {
					j--;
					
				}
				
				if(i<=j) {
					swap(list,i,j);
					i++;
					j--;	
				}
			}
			
			if(a<j) {
				quicksort(list , a ,j);
			}
			if(i<b) {
				quicksort(list , i,b);
			}
			
		}
	
		public static void swap(ArrayList<Graph_generator> list , int i , int j) {
			
			Graph_generator temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
		
		
		
		
		
	}
	
	
	
	
	


