import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr);

        for(int i=0; i<n; i++){
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int[] arr){
        int[] tmp = new int[arr.length]; // 임시 저장공간
        mergeSort(arr, tmp, 0, arr.length - 1); // 재귀함수 호출
    }

    public static void mergeSort(int[] arr, int[] tmp, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;

            mergeSort(arr, tmp, start, mid); // 배열 앞부분
            mergeSort(arr, tmp, mid+1, end); // 배열 뒷부분
            // 재귀함수가 돌아온 경우, 가운데를 기준으로 왼, 오 배열이 정렬되어있는 상태
            merge(arr, tmp, start, mid, end); // 두 개로 나뉜 배열 방을 병합
        }
    }

    public static void merge(int[] arr, int[] tmp, int start, int mid, int end){
        // 임시 저장배열에 필요한 만큼 복사
        for(int i=start; i<=end; i++){
            tmp[i] = arr[i];
        }
        int ptr1 = start;
        int ptr2 = mid + 1;
        int idx = start; // 다음에 저장할 곳을 기억하기 위함

        while(ptr1 <= mid && ptr2 <= end){
            if(tmp[ptr1] <= tmp[ptr2]){
                arr[idx] = tmp[ptr1]; // 원본 배열에 옮김
                ptr1++;
            }
            else{
                arr[idx] = tmp[ptr2];
                ptr2++;
            }
            idx++;
        }

        // 앞 배열에 데이터가 남아있는 경우, 뒤쪽 배열 신경X
        for(int i=0; i<=mid-ptr1; i++){
            arr[idx + i] = tmp[ptr1 + i];
        }
    }
}