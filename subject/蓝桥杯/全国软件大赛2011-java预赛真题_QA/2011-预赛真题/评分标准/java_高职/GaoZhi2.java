
/*
  �ο��𰸣�
  /d/1000
  
  ע���߼��ȼۣ�
  /(d*1000)
  /d*0.001
  ...
  
  ����ȷ�����������п����н��
  
*/

public class GaoZhi2
{
	public static double getDistance(int begin, int end, double d)
	{
		return (end-begin) * Math.PI * d * d/ d / 1000;   // ���
	}
				
	public static void main(String[] args)
	{
		System.out.println(getDistance(100,200,1));
	}
}