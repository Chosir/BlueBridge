
/*
  �𰸣�
  reverseString(x.substring(1))
  
  ע�⣺
  reverseString(x.substring(1,x.length())) �ǶԵ�
  
  �������İ취Ҳ�ǶԵ�
  reverseString(new StringBuffer(x).deleteCharAt(0).toString())
  
  ��֮�����ʵ��ȷ���������������������������һ�¡�
  
*/


public class BenKe3
{
	public static String reverseString(String x)
	{
		if(x==null || x.length()<2) return x;
		return reverseString(x.substring(1)) + x.charAt(0);  // ���
		//return reverseString(new StringBuffer(x).deleteCharAt(0).toString()) + x.charAt(0);
	}
	
	public static void main(String[] args)
	{
		System.out.println(reverseString("abcd"));
	}
}