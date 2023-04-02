import java.util.*;
public class Main {
    public static int yh(int n){
        //如果是1，直接返回第1个
        if(n == 1)
            return n;
        int[][] arr = new int[100][100];
        //先填充边缘的1
        for(int i = 0; i < 100 ; i++){
                arr[i][0] = 1;
                arr[i][i] = 1;
        }
        /*
        1
        11
        1xx1
        1xxx1
        */
        int num = 3;
        //从第三行开始填充
        for(int i = 2; i < 100; i++){
            //每行开头有一个1，+1跳过
            num++;
            for(int j = 1; j < i; j++){
                //填充杨辉三角中间数据并比较
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                num++;
                if(arr[i][j] == n){
                    return num;
                }
            }
            //每行结束有一个1，加1跳过
            num++;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = yh(n);
        System.out.println("答案是"+ans);
    }
}