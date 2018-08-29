package easy;

public class E70ClimbingStairs {
//爬楼梯，要么爬一步，要么爬两步，爬n阶的方法数
//斐波拉契数列，f(n)=f(n-1)+f(n-2)
//最后一步的时候，要么从n-1阶爬上，要么从n-2阶爬上
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E70ClimbingStairs  e = new E70ClimbingStairs();
		System.out.println(e.climbStairs3(5));
		
	}
	
	public int climbStairs(int n) {
		if ( n ==1 ) return 1;
			
		int f[] = new int[n];
		f[0]= 1;f[1]=2;
        for(int i = 2; i < n ; i++) {
        	f[i] = f[i-1] + f[i-2];
        }
		return f[n-1];
    }
	
	//用a,b保存前两个状态f(n-2)和f(n-1)的值，省去存储数组的空间
	public int climbStairs2(int n) {
        int a = 1, b = 1;
        while (n-- >0) {
            b += a; 
            a = b - a;
        }
        return a;
    }
	
	//矩阵法 ，时间复杂度logn,空间复杂度O(1)
//	Qn = {{Fn,Fn-1},{Fn-1,Fn-2}} * {{1,1},{1,0}} = {{Fn+1,Fn},{Fn,Fn-1}}
//	Fn = Qn-1{0,0}
	public int climbStairs3(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {  //保存Qn-1
                ret = multiply(ret, a);
            }
            n >>= 1; 
            a = multiply(a, a);
        }
        return ret;
    }
    public int[][] multiply(int[][] a, int[][] b) {//矩阵相乘
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
    
    //公式法 时间复杂度logn(pow),空间复杂度O(1)
    public int climbStairs4(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }

}
