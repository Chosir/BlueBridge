
/*
  �ο��𰸣�
  x += price[i] * weight[i]
  
  x = x + price[i] * weight[i] Ҳ��ȷ
  
  ע��ӷ����˷�������
  ����ȷ�����������
*/

public class GaoZhi1
{
	public static double getTotal(double[] price, double[] weight)
	{
		double x = 0;
		for(int i=0; i<price.length; i++)
		{
			x += price[i] * weight[i];  // ���
		}
		return x;
	}
		
	public static void main(String[] args)
	{
		double[] p = {1.5, 2.4, 1.2, 3.3};
		double[] w = {2,2,3,1.5};
		
		System.out.println(getTotal(p, w));	
	}
}