package com.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] number = {9,1,5,4,3,6,12,2};

		mergeSort(number,0,number.length-1); //정렬시킬 배열, 제일 처음 인덱스, 마지막 값 인덱스를 넣기
		System.out.println(Arrays.toString(number));

	}

	public static void mergeSort(int[] number,int left,int right) {

		int mid;

		if(left<right) { //left<right 아니면 분할(divide)과정 끝내기
			mid = (left+right)/2; //중앙값 찾기
			mergeSort(number,left,mid); 
			mergeSort(number,mid+1,right);	//중앙값을 기준으로 두개의 배열로 나눠서 분할 반복 > 더이상 분할 안될때까지
			mergeConquer(number,left,right,mid);	//다시 병합 정렬 시켜주기( : Conquer)
		}
	}

	public static void mergeConquer(int[] number,int left,int right,int mid) {

		int[] sorted= new int[number.length]; 
		int i,j,k;
		i= left; //mid의 왼쪽 배열 중 제일 왼쪽 값
		j= mid+1; //mid의 오른쪽 배열 중 제일 왼쪽 값		
		k=left; //정렬된 값을 넣는 배열의 인덱스

		//정렬시켜 sorted배열에 삽입
		while(i<=mid && j<=right) { //i랑 j가 각각 배열의 끝인 mid와 right이 될 때까지 시행된다.
			if(number[i] <= number[j]) {
				sorted[k] = number[i];
				i++;
			}else {
				sorted[k] = number[j];
				j++;
			}
			k++;

		}

		//한쪽이 먼저 끝나 한쪽배열만 남는경우 남은 애들 순서대로 sorted배열에 넣어주기
		if(i > mid) {
			for(int t=j ; t<=right ; t++) {
				sorted[k] = number[t];
				k++;
			}
		}else {
			for(int t=i ; t<=mid ; t++) {
				sorted[k] = number[t];
				k++;
			}
		}
		//sorted에 정렬된 배열 number배열에 넣어주기
		for(int t=left ; t<=right ; t++) {
			number[t]=sorted[t];
		}

	}
}


