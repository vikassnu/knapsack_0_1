import java.util.Scanner;
public class kanpsack_0_1_dynamic_ {
    static int max(int a,int b){
        return (a>b)?a:b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("No. of item: ");
        int t = sc.nextInt();//no_of_item
        int[] vals = new int[t+1];
        int[] weight = new int[t+1];
        for(int i=1;i<t+1;i++){
            System.out.println("value of "+(i)+" th item: ");
            vals[i]=sc.nextInt();//value of "i"th item
            System.out.println("weight of "+(i)+" th item: ");
            weight[i]=sc.nextInt();// weight of "i"th item
        }
        vals[0]=0;
        weight[0]=0;
        System.out.println("max capacity: ");
        int C = sc.nextInt();//Max_capacity
        int[][] dp = new int[t+1][C+1];// dynamic programming matrix
        for(int i=0;i<t+1;i++){
            for(int j=0;j<C+1;j++) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(j<weight[i]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = max(vals[i]+dp[i-1][j-weight[i]],dp[i-1][j]);
                }

            }
        }
        for(int i=0;i<t+1;i++){
            System.out.print("[");
            for (int j=0;j<C;j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println(dp[i][C]+"]");
        }
        System.out.println(dp[t][C]);

    }
}
