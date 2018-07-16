package com.example.demo.common;

public class Constant {
	
	public static final String HELLO_WORLD = "Hello World !";
	public static final String HELLO_TEMPLATE = "Hello, %s !";
	
	public static void main(String[] args) {
		String s,s1;
		StringBuilder sb = new StringBuilder("12234567990");
		StringBuilder sb2 = new StringBuilder(sb);
		 //(Integer.valueOf(sb.charAt(i)) % 2 !=0) && (Integer.valueOf(sb.charAt(i+1)) % 2 !=0);
		
		try {
		for(int i=0;i<sb.length()-1;i++) {
			boolean even = (Integer.valueOf(sb.charAt(i)) % 2 ==0) && (Integer.valueOf(sb.charAt(i+1)) % 2 ==0);
			boolean odd = (Integer.valueOf(sb.charAt(i)) % 2 !=0) && (Integer.valueOf(sb.charAt(i+1)) % 2 !=0);
			
			if(even) {
				
				System.out.println("hello start");
				
				s = sb.substring(i+1, sb.length()-1);//sb.substring(0, i);
				s1 = sb.substring(0, i+1)+"*";
				
				
				sb2.replace(i+1, sb.length()-1, s);
				sb2.replace(0, i+1, s1);
				
				System.out.println("hello middle");
			}
			
			else if(odd){				
				System.out.println("hello start");
				
				s = sb.substring(i+1, sb.length()-1);//sb.substring(0, i);
				s1 = sb.substring(0, i+1)+"-";
				
				
				sb2.replace(i+1, sb.length()-1, s);
				sb2.replace(0, i+1, s1);
				
				System.out.println("hello middle");
			}
			
		}
		
		System.out.println(sb.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
