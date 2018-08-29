package easy;

//À¨ºÅÆ¥Åä
//×óÀ¨ºÅÈëÕ»£¬Åö¼ûÓÒÀ¨ºÅÊ±²é¿´Õ»¶¥ÊÇ·ñÆ¥Åä
import java.util.Stack;

public class E20ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E20ValidParentheses e = new E20ValidParentheses();
		System.out.println(e.isValid("()]"));
	}

	public boolean isValid(String s) {
		Stack<Character> ss = new Stack<Character>();
		for( int i =0; i< s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i)=='{') {
				ss.push(s.charAt(i));
			}else {
				if(ss.empty()) return false;
				if(s.charAt(i)==')' && ss.peek()!= '(') return false;
				if(s.charAt(i)==']' && ss.peek()!= '[') return false;
				if(s.charAt(i)=='}' && ss.peek()!= '{') return false;
				ss.pop();
			}
		}
		return ss.empty();
    }
}
