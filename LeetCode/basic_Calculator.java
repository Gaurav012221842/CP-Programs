import java.util.Stack;

public class basic_Calculator {
    public static void main(String[] args) {
        String str="1 + 1";
        System.out.println(calculatee(str));
    }
    public static int calculate(String str){
        int answer=0;
        int n=str.length();
        int sign=1;
        int i=0;
        int num;
        while(i<n){
            if(str.charAt(i)==' '){
                i++;
            }
            else if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                num=0;
                while(i<str.length()&&str.charAt(i)>='0' && str.charAt(i)<='9'){
                    num=num*10+str.charAt(i++)-'0';
                }
                answer+=sign*num;
                sign=1;
            }
            
            else if(str.charAt(i)=='+'){
                sign=1;
                i++;
            }
            else if(str.charAt(i)=='-'){
                sign=-1;
                i++;
            }

        }
        return answer;
    }
    public static int calculatee(String str){
        Stack<Integer>st=new Stack<>();
        int res=0;
        int n=str.length();
        int num=0;
        int sign=1;
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch=='+' || ch=='-'){
                res+=sign*num;
                num=0;
                sign=(ch=='+'?1:-1);
            }
            else if(ch=='('){
                st.push(res);
                st.push(sign);
                res=0;
                sign=1;


            }
            else if(ch==')'){
                res+=sign*num;
                num=0;
                res*=st.pop();
                res+=st.pop();
            }
        }
        res+=sign*num;
        return res;
    }

}