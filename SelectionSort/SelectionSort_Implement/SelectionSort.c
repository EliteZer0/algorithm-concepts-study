#include <stdio.h>

int main()
{
	int n = 0;

	scanf("%d", &n);

	int data[n]; // C89/90 에서는 동작하지 않음. 동적 할당 사용에 대한 공부 필요.

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &data[i]);
	}

	// 처음 구현 코드
	// for (int i = 0; i<n; i++){
	//     int min = INT_MAX;//요소와 비교하기 위한 int형 최댓값 설정
	//     int minIndex = 0;
	//     for(int j = i; j<n; j++){
	//         if(min>data[j]) {
	//             min = data[j];//비교한 요소가 작으면 최솟값에 요소 저장
	//             minIndex = j;//인덱스 번호 저장
	//         }
	//     }
	//     int temp = data[i]; //현재 요소 임시 저장
	//     data[i] = min;//현재 인덱스에 최솟값 저장
	//     data[minIndex] = temp;//최솟값 인덱스에 현재 요소 저장
	// }

	for (int i = 0; i < n; i++)
	{
		int minIndex = i; // i번째 반복 시 최솟값 저장할 인덱스

		for (int j = i; j < n; j++)
		{
			if (data[minIndex] > data[j])
			{
				minIndex = j; // 최솟값 위치 저장
			}
		}

		int temp = data[i];		  // 현재 요소 임시 저장
		data[i] = data[minIndex]; // 현재 인덱스에 최솟값 저장
		data[minIndex] = temp;	  // 최솟값 인덱스에 현재 요소 저장
	}

	for (int i = 0; i < n; i++)
	{
		printf("%d ", data[i]);
	}

	return 0;
}