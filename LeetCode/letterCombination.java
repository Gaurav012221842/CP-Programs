import java.util.*;
public class letterCombination {
    public static void main(String[] args) {
        String digits="23";
        List<String> res=letterCombinations(digits);
        System.out.println(res);
    }
    public static List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0) return new ArrayList<>();
        List<String> res=new ArrayList<>();
        String[] mapping={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(res,digits,mapping,new StringBuilder(),0);
        return res;
    }
    public static void backtrack(List<String> res, String digits, String[] mapping, StringBuilder sb, int index){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        String letters=mapping[digits.charAt(index)-'2'];
        for(char ch : letters.toCharArray()){
            sb.append(ch);
            backtrack(res,digits,mapping,sb,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
