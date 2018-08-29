package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//�����������,����һ����������ɿ���ѧϰ
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

	//ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
	//��n�У���0��ʼ���ĵ�i��ֵΪCni(������ϣ����˴�������Ͻ�����ǰһ���������ֵ��û��ÿһ�ζ�����
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
	
	//ʱ�临�Ӷ�O(n^2),�ռ临�Ӷ�O(n)
	//ÿ��ֵΪ��һ��ǰ����ֵ�ĺͣ����ϸ���ÿ��λ�õ�ֵ
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
