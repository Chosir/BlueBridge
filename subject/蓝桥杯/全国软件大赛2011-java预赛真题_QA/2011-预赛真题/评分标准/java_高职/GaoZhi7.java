
/*
  �ο��𰸣�
  ��1�� null             ��3�֣�
  ��2�� cow.afterYear()  ��7�֣�
  
        cow.age++  Ҳ����ȷ��
        
  ����ȷ���Ĵ����������
*/

import java.util.*;

public class GaoZhi7
{
	public static class Cow 
	{
		private int age;
		public Cow afterYear()
		{
			age++;
			return age > 2 ? new Cow() : null;  // ���1
		}	
		
		public static void showTotalCowNum(int n)
		{
			List<Cow> list = new ArrayList<Cow>();
			list.add(new Cow());
	
			for (int i = 0; i < n; i++)
			{
				int cowCount = list.size();
				for (int j = 0; j < cowCount; j++)
				{
					Cow cow = list.get(j).afterYear(); 
					if (cow != null)
					{
						cow.afterYear(); // ���2
						list.add(cow);
					}
				}
			}
			System.out.println(n + "��󣬹��У�" + list.size());		
		}
	}
		
		
	public static void main(String[] args)
	{
		Cow.showTotalCowNum(7);
	}
}