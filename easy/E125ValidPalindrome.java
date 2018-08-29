package easy;

public class E125ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		E125ValidPalindrome ee = new E125ValidPalindrome();
		String s="race a car";
		System.out.println(ee.isPalindrome(s));
	}

	public boolean isPalindrome(String s) {
		String removeOther = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for(int i = 0 ; i< removeOther.length()/2; i++)
        {
        	if(removeOther.charAt(i) != removeOther.charAt(removeOther.length()-1-i))      		
        		return false;

        }
		return true;
    }
	
	public boolean isPalindrome2(String s) {
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
	    String rev = new StringBuffer(actual).reverse().toString();
	    return actual.equals(rev);
	}
	
}
