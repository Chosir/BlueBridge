
/*
  �𰸣�
  y * a / b
  ��Ȼ,����д��Ҳ�ǶԵģ�
  a / b * y
  a * y / b
*/


public class BenKe1
{
	public static void main(String[] args)
	{
		double x = 1;
		double y = 1;
		int a = 1;
		int b = 3;
		
		while(y>1e-15)
		{
			y =  y * a / b;  // ���λ��
			x += y;
			a++;
			b += 2;
		}
		System.out.println(x*2);
		
	}
}