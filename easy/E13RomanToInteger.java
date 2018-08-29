package easy;

import java.util.HashMap;
import java.util.Map;

public class E13RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E13RomanToInteger ee = new E13RomanToInteger();
		String s = "MCMXCIV" ;
		System.out.println(ee.romanToInt2(s));

	}
	public int romanToInt(String s) {
		int result = 0;
        for(int i = 0; i < s.length(); i++) {
        	if ( s.charAt(i) == 'I')
        	{
        		if( i+1 < s.length() && s.charAt(i+1) == 'V') {
        			result += 4;
        			i += 1;
        		}else if(i+1 < s.length() && s.charAt(i+1) == 'X') {
        			result += 9;
        			i += 1;
        		}else {
        			result += 1;
        		}
        		
        	}else if (s.charAt(i) == 'V') {
        		result += 5;
        	}else if (s.charAt(i) == 'X') {
        		if(i+1 < s.length() && s.charAt(i+1) == 'L') {
        			result += 40;
        			i += 1;
        		}else if(i+1 < s.length() && s.charAt(i+1) == 'C') {
        			result += 90;
        			i += 1;
        		}else {
        			result += 10;
        		}
        	}else if (s.charAt(i) == 'L') {
        		result += 50;
        	}else if (s.charAt(i) == 'C') {
        		if(i+1 < s.length() && s.charAt(i+1) == 'D') {
        			result += 400;
        			i += 1;
        		}else if(i+1 < s.length() && s.charAt(i+1) == 'M') {
        			result += 900;
        			i += 1;
        		}else {
        			result += 100;
        		}
        	}else if (s.charAt(i) == 'D') {
        		result += 500;
        	}else if (s.charAt(i) == 'M') {
        		result += 1000;
        	}
        	 
        }
        return result;
    }
	//最后一位或者当前位大于下一位就加上，否则减去当前位
	public int romanToInt2(String s) {
		int result = 0;
		//HashMap的key,value值均可为null，但Java的基本类型不可为null。
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
        for(int i = 0; i < s.length(); i++) {
        	if( i == s.length()-1 || map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
        		result += map.get(s.charAt(i));
   
        	}else {
        		result -= map.get(s.charAt(i));
        	}
        	 
        }
        return result;
    }

}
