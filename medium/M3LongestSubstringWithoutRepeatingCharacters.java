package medium;

import java.util.Arrays;
import java.util.HashSet;

//最长子串

public class M3LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		M3LongestSubstringWithoutRepeatingCharacters e = new M3LongestSubstringWithoutRepeatingCharacters();
		String s = "bbbbb";
		System.out.println(e.lengthOfLongestSubstring2(s));
	}
	
	//23ms
	//维护一个滑动窗口，记录当前子串最左位置，最右位置即是当前位置，若当前字符在当前子串中，更新最左位置
	//ASCII字符可表示256个字符，用256长的数组记录每个字符最后出现的位置
	public int lengthOfLongestSubstring(String s) {
        int map[] = new int[256];
        Arrays.fill(map, 0);
        
        int left = 0, res = 0;
        
        for(int i = 0 ; i< s.length(); i++) {
        	left = Math.max(left, map[s.charAt(i)]);
        	map[s.charAt(i)] = i + 1;
        	res = Math.max(res, i - left + 1);
        }
        return res;
    }

	//40ms
	//用hashset记录每个字符
	//维护一个滑动窗口，记录最左，最右位置
	public int lengthOfLongestSubstring2(String s) {
		int left = 0, res = 0,right = 0;
        HashSet<Character> set = new HashSet<Character>();
        while(right < s.length()) {
        	if(set.contains(s.charAt(right))) {
        		set.remove(s.charAt(left++));
        	}else {
        		set.add(s.charAt(right++));
        		res = Math.max(res, set.size());
        	}
        }
        return res;
    }
}
