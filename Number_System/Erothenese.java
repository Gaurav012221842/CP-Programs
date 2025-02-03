import java.util.*;
public class Erothenese {
    public static void main(String[] args) {
        int n=100;
        boolean[] arr=new boolean[n];
         
        arr[0]=arr[1]=true;
        
        for(int i=0;i<n;i++){
            if(!arr[i]){
                for(int j=2*i;j<n;j+=i){
                    arr[j]=true;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(!arr[i]){
                System.out.print(i+" ");
            }
        }
        
    }
}
