
/*
  �ο��𰸣�
  ��1��v2 = m-1    ��4.5�֣�
  ��2��v1 = m+1    ��4.5�֣�
  
  ��� 
  v2 = m
  v1 = m 
  ˵���������̶����ˣ�����1��
*/

import java.util.*;

public class GaoZhi6
{		
	public static void main(String[] args)
	{
		System.out.println("�����������һ�����֣�1~100����������");
		System.out.println("��ÿ��һ�����֣���Ҫ�������� '�´���'��'��С'�ˣ�����'����'");
		Scanner scan = new Scanner(System.in);
		int v1 = 1;
		int v2 = 100;
		for(;;)
		{
			int m = (v1 + v2)/2;
			System.out.println("�Ҳ��ǣ�" + m);
			System.out.println("1.�µ�̫����");
			System.out.println("2.�µ�̫С��");
			System.out.println("3.���У�");
			System.out.print("��ѡ��");
			int user = Integer.parseInt(scan.nextLine());
			if(user==3) break;
			if(user==1) v2 = m-1;  // ���1
			if(user==2) v1 = m+1;  // ���2
		}
	}
}