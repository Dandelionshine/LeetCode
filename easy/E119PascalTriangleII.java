package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//杨辉三角生成,方法一的组合数生成可以学习
public class E119PascalTriangleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		E119PascalTriangleII  e = new E119PascalTriangleII();
		List<Integer> list = e.getRow2(4);
		for(int j =0 ;j< list.size(); j++) {
			//System.out.println(list.get(i).size());
			System.out.print(list.get(j));
		}
	}

	//时间复杂度O(n),空间复杂度O(n)
	//第n行（从0开始）的第i个值为Cni(排列组合），此处排列组合借助于前一个组合数的值，没有每一次都连乘
	public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if(rowIndex == 0) return list;
        long temp =1;
        int t = rowIndex,b=1;
        for(int i =1 ; i< rowIndex+1 ; i++)
        {
        	temp = temp * t;
        	temp = temp / b;
        	list.add((int) temp);
        	t--;
        	b++;
        }
        return list;
    }
	
	//时间复杂度O(n^2),空间复杂度O(n)
	//每个值为上一行前两个值的和，不断更新每个位置的值
	public List<Integer> getRow2(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        
        for (int i = 1; i <= k; i++) 
            for (int j = i; j > 0; j--) 
                arr[j] = arr[j] + arr[j - 1];
        
        return Arrays.asList(arr);
    }
}
