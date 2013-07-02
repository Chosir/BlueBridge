
/*
  �𰸣�
  ��1�� return false
  ��2�� isPrime(i+2) && i+2<n
  
  ��1�� 1��
  ��2�� 3��
  
  ע�⣺
  ���2 �ش�isPrime(i+2)  �ɸ�2��
  
  ע�����е��߼��ȼ۸�ʽ��
  ���磺 
  isPrime(i+2) && i<n-2
  isPrime(2+i) && i<n-2
  
  ע������һ��ƫƧ��˼·��
  (n-2>1 && isPrime(i-2))
  
  ע�⣺���ش� isPrime(i-2) ������
*/


public class BenKe2
{
	public static boolean isPrime(int x)
	{
		for(int i=2; i<=x/2; i++)
		{
			if(x%i==0) return false; //���1
		}
		return true;
	}
	
	public static int twinPrimeNum(int n)
	{
		int sum = 0;
		for(int i=2; i<n; i++)
		{
			if(isPrime(i) && isPrime(i+2) && i+2<n) sum++; //���2
		}
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		System.out.println(twinPrimeNum(10000));  //205
	}
}