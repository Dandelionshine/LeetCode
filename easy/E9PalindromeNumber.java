package easy;
//回文数字判断
//不将数字转化为字符串
//取整和取余来判断，第一位和最后一位是否相等，循环判断

public class E9PalindromeNumber {
	public static void main(String[] args) {
		E9PalindromeNumber ee = new E9PalindromeNumber();
		
		System.out.println(ee.isPalindrome(10));
	}
	
	public boolean isPalindrome(int x) {

        int div = 1;
        int left,right;
		if( x < 0) return false;
        while( x / div >= 10) div *= 10;
        while( x > 0) {
	        left = x / div;
	        right = x % 10;
	        if(left != right) return false;
	        x = x % div;
	        x = x / 10;
	        div /= 100;
        }
        return true;
    }

}
