package easy;

//������Ӵ�
//ÿһ���ַ������һ���ַ�����һ�����ַ���ȣ���һ��������·���֮ǰ���Ӵ�
public class E14LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		E14LongestCommonPrefix e = new E14LongestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		System.out.println(e.longestCommonPrefix2(strs));
	}
	//7ms
	public String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0) return "";
        String res = new String();
        for ( int j = 0; j< strs[0].length(); j++) {
        	
        	for ( int i = 1; i< strs.length; i++) {
        		if( j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) return res;
        	}
        	res += Character.toString(strs[0].charAt(j));
        }
        return res;
		
    }
	//6ms
	public String longestCommonPrefix2(String[] strs) {
        if( strs == null || strs.length == 0) return "";
        
        for ( int j = 0; j< strs[0].length(); j++) {
        	
        	for ( int i = 1; i< strs.length; i++) {
        		if( j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) return strs[0].substring(0, j);
        	}
        	
        }
        return strs[0];
		
    }
	//5ms ��������
	public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }
    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }   
}
