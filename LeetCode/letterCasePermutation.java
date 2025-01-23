import java.util.ArrayList;
import java.util.List;

public class letterCasePermutation {
    public static void main(String[] args) {
        String str="1a2b";
        List<String>res=calculate(str);
        System.out.println(res);
    }
    public static List<String> calculate(String str){
            List<String> res=new ArrayList<>();
            backtrack(str.toCharArray(),0,res);
            return res;
    }
    public static void backtrack(char[] arr, int index, List<String> res){
        if(index==arr.length){
            res.add(new String(arr));return;
        }
        if(Character.isLetter(arr[index])){
            if(Character.isUpperCase(arr[index])){
                arr[index]=Character.toLowerCase(arr[index]);
                backtrack(arr, index+1, res);
                arr[index]=Character.toUpperCase(arr[index]);
            }
            else{
                arr[index]=Character.toUpperCase(arr[index]);
                backtrack(arr, index+1, res);
                arr[index]=Character.toLowerCase(arr[index]);
            }
        }
        backtrack(arr, index+1, res);
    }
}
