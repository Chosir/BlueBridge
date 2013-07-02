
/*
  �ο��𰸣�
  ��1��sa[i+j]    (4��)
  ��2��n = j      (5��)

  ע�⣬ָ����������ʽ�ĵȼ��ԡ�
  *(sa+i+j) ��һ����
*/


#include "stdafx.h"
#include "string.h"

int g(int a, int b)
{
	char sa[]="00000000";
	char sb[]="00000000";
	int n = 0;
	int i,j;
	
	sprintf(sa,"%8d",a);
	sprintf(sb,"%8d",b);
	for(i=0; i<8; i++)
	{
		for(j=1; j<=8-i; j++)
		{
			char t = sa[i+j];  // ���1
			sa[i+j] = 0;
			if(strstr(sb, sa+i))
			{
				if(j>n) n = j;  // ���2
			}
			sa[i+j] = t;
		}
	}
	
	return n;
}


int main(int argc, char* argv[])
{
	printf("%d\n", g(12345678,42234566));	
	printf("%d\n", g(12345678,12345678));
	return 0;
}

