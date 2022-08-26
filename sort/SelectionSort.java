package com.sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args) {
		
		int min,temp;
		int[] number = {9,1,5,4,3}; //9,1,5,4,3을 가지고 있는 배열 생성
		
		for(int i=0;i<number.length-1;i++) {
			min=i; //1. min에 기준이 되는 배열의 인덱스 넣기
			for(int j=i+1;j<number.length;j++) {
				if(number[min]>number[j]) {
					min=j; //2. 기준보다 뒤에 있는 애들이랑 min이랑 비교하고 더 작으면 자리바꿔주기				
				}
			}
			
			temp=number[i]; //3. 한바퀴 다 돌아서 제일 작은 애와 기준 값 자리 바꿔주기
			number[i]=number[min];
			number[min]=temp;
		}
		
		System.out.println(Arrays.toString(number));
		
	}
	

}

/*
 비교의 기준은 제일 처음부터 마지막 앞에 숫자까지를 기준으로 한다.(즉, length보다 하나 작게)
 비교 대상이 되는 수는 두번째 수부터 마지막 숫자까지가 범위.
	기준이 비교대상보다 크면 두개 위치를 바꾸고 if문을 나간다.
 */
