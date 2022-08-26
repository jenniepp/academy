package com.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		
		int std,temp;
		int[] number = {9,1,5,4,3}; 
		
		for(int i=1;i<number.length;i++) { //기준을 2번째 숫자부터 정한다.
			std=number[i];
			for(int j=0;j<i;j++) {
				if(std<number[j]) { //기준 왼쪽 숫자들을 비교해서 자리를 하나씩 바꾼다.
					temp=number[j];
					number[j]=number[i];
					number[i]=temp;
					}
			
				}
			}
		
		System.out.println(Arrays.toString(number));
		}

	}

