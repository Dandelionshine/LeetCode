package medium;

import java.util.Arrays;
import java.util.HashSet;

//��Ӵ�

public class M3LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		M3LongestSubstringWithoutRepeatingCharacters e = new M3LongestSubstringWithoutRepeatingCharacters();
		String s = "bbbbb";
		System.out.println(e.lengthOfLongestSubstring2(s));
	}
	
	//23ms
	//ά��һ���������ڣ���¼��ǰ�Ӵ�����λ�ã�����λ�ü��ǵ�ǰλ�ã�����ǰ�ַ��ڵ�ǰ�Ӵ��У���������λ��
	//ASCII�ַ��ɱ�ʾ256���ַ�����256���������¼ÿ���ַ������ֵ�λ��
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
	//��hashset��¼ÿ���ַ�
	//ά��һ���������ڣ���¼��������λ��
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
