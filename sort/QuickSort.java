package com.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] number = {9,1,5,4,3,6,12,2};
		int left=0; //배열의 가장 왼쪽 인덱스(첫 시작이니까 0)
		int right=number.length-1; //배열의 가장 오른쪽 인덱스
		
		quickSort(number,left,right); // 퀵소트 메소드 실행
		System.out.println(Arrays.toString(number));
	}
	
	public static void quickSort(int[] number, int left, int right) {
		
		if(left>=right) return; //left가 right랑 같거나 더 크면 더이상 나눌 필요가 없게 다 한 상태라 끝
		
		int pivot=number[left]; //배열의 제일 왼쪽값을 피봇값으로 설정
		
		int i=left+1; //피봇 기준 제일 왼쪽값
		int j=right; //피봇 기준 제일 오른쪽 값
		while(i<j) {
			while(pivot>number[i]) 
				i++; //피봇 왼쪽값부터 차례대로 비교해서 피봇보다 큰 값찾기
		
			while(pivot<number[j])
				j--; //오른쪽값부터 차례대로 비교해서 피봇보다 작은 값찾기
		
			if(i<j) { //옮겨진 i와 j가 크로스하지 않았을 때
				int temp=number[i];
				number[i]=number[j];
				number[j]=temp;	//이렇게 찾아진 수 자리 바꾸기
			}else if(i>=j) { //옮겨진 i와 j가 크로스 했을 때
				int temp = pivot;
				number[left]=number[j];
				number[j]=temp; //작은 값과 피봇 자리 바꾸기
			}
			
		}
		
		//한 바퀴 다 돌고나면 재귀함수 돌리기
		quickSort(number,0,j-1);
		quickSort(number,j+1,right);
	}

}
