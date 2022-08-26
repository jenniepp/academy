package com.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] number = {9,1,5,4,3};
		int temp;
		
		for(int i=number.length-1;i>0;i--) { 
			
			for(int j=0;j<i;j++) { //처음부터 오른쪽 값과 크기비교
				
				if(number[j]>number[j+1]) { //버블소트 자리변경
					temp=number[j];
					number[j]=number[j+1];
					number[j+1]=temp;
					
				}
			}
		}
		
		System.out.println(Arrays.toString(number));
		
	}

}
