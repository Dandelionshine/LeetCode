package easy;

import java.util.ArrayList;
import java.util.List;

//杨辉三角生成
public class E118PascalTriangle {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		E118PascalTriangle  e = new E118PascalTriangle();
		List<List<Integer>> list = e.generate(5);
		System.out.println(list.size());
		for(int i =0 ;i< list.size(); i++) {
			for(int j =0 ;j< list.get(i).size(); j++) {
				//System.out.println(list.get(i).size());
				System.out.print(list.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	//时间复杂度O(n^2),空间复杂度O(n^2)
	//二维数组保存生成的杨辉三角，每个值为上一行前两个值的和
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        
        for(int i = 0; i< numRows; i++) {
        	ArrayList<Integer> row = new ArrayList<Integer>();
        	
        	row.add(0,1);
        	for(int j = 1; j < i;j++) {
        		row.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
        	}
        	if(i!=0)
        		row.add(1);

        	list.add(row);
        }
        
        return list;
    }

}
