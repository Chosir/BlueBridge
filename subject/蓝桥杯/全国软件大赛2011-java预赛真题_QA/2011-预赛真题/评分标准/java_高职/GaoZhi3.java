
/*
  �ο��𰸣�
  s2
  
  �����´����������ü�ʱ�ϱ�
*/

public class GaoZhi3
{		
	public static void main(String[] args)
	{
		String s = "1234567";		
		String s2 = "";
		for(int i=0; i<s.length(); i++)
		{
			s2 = s.charAt(i) + s2; // ���
		}
		System.out.println(s2);		
	}
}