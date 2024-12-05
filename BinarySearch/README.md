# 이진 탐색(Binary Search)

이진탐색은 정렬된 리스트에서 검색 범위를 줄여 나가면서 검색 값을 찾는 알고리즘이다.

검색이 반복될 떄마다 검색 범위가 절반으로 줄어 속도가 빠르지만, 정렬된 리스트에서만 사용할 수 있다.

### 예시

#### Key = 91

| index | &nbsp;&nbsp;&nbsp; 0 &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; 1 &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; 2 &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;4&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;5&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;8&nbsp;&nbsp;&nbsp; |
| :---: | :-------------------------------------: | :-------------------------------------: | :-------------------------------------: | :-----------------------------------: | :-----------------------------------: | :-----------------------------------: | :-----------------------------------: | :-----------------------------------: | :-----------------------------------: |
| 1번째 |                   17                    |                   23                    |                   34                    |                  45                   |                  52                   |                  68                   |                  79                   |                  86                   |                  91                   |
|       |                                         |                                         |                                         |                                       |                   V                   |                                       |                                       |                                       |                                       |
|       |                                         |                                         |                                         |                  52                   |                   <                   |                  91                   |                                       |                                       |                                       |
|       |                                         |                                         |                                         |                                       |                                       |                  68                   |                  79                   |                  86                   |                  91                   |
| 2번째 |                                         |                                         |                                         |                                       |                                       |                  68                   |                  79                   |                  86                   |                  91                   |
|       |                                         |                                         |                                         |                                       |                                       |                                       |                   v                   |                                       |                                       |
|       |                                         |                                         |                                         |                                       |                                       |                  79                   |                   <                   |                  91                   |                                       |
|       |                                         |                                         |                                         |                                       |                                       |                                       |                                       |                  86                   |                  91                   |
|       |                                         |                                         |                                         |                                       |                                       |                                       |                                       |                   V                   |                                       |
|       |                                         |                                         |                                         |                                       |                                       |                                       |                  86                   |                   <                   |                  91                   |
|       |                                         |                                         |                                         |                                       |                                       |                                       |                                       |                                       |                  91                   |

이진탐색은 리스트의 중간 값과 비교하여 검색값을 찾는다.

중간 값이 검색 값과 같다면 종료.

중간 값보다 검색 값이 크다면 중간값 기준 배열의 오른쪽 구간을 탐색.

중간 값보다 검색 값이 작다면 중간값 기준 배열의 왼쪽 구간을 탐색.

값을 찾거나 간격이 비어있을 때까지 반복.

[이진 탐색 코드 구현](https://github.com/EliteZer0/algorithm-concepts-study/tree/main/BinarySearch/BinarySearch_Implement)

[이진 탐색 연습문제 풀이](https://github.com/EliteZer0/algorithm-concepts-study/tree/main/BinarySearch/BinarySearch_Practice)

- [x] [BOJ 2805번 : 나무 자르기](https://www.acmicpc.net/problem/2805)

- [x] [BOJ 12015번 : 가장 긴 증가하는 부분 수열 2](https://www.acmicpc.net/problem/12015)
