
/*
   �������֣� 9��

  ���1: (3��)
  n==0
  ���ߣ�0==n

  ���2: (6��)
  f(n-i*i, a, idx+1)
  ���ߣ�
  f(n-i*i, a, idx+1) > 0
  f(n-i*i, a, idx+1) == 1
 
��ÿ����ͬ�Ĵ�Ҫϸ�ģ����ȴ�����򣬿�����Ƿ���ȷ
�ٻ����ݲ���

*/



#include "stdafx.h"
#include "math.h"

// �ķ�����������Ȼ������ֻҪ���ĸ�����ƽ���;Ϳ��Ա�ʾ��

int f(int n, int a[], int idx)
{
	if(n==0) return 1;
	if(idx==4)  return 0;

	for(int i=(int)sqrt(n); i>=1; i--)
	{
		a[idx] = i;

		if(f(n-i*i, a, idx+1))
			return 1;
	}

	return 0;
}

int main(int argc, char* argv[])
{
	for(;;)
	{
		int number;
		printf("��������(1~10��)��");
		scanf("%d",&number);
		
		int a[] = {0,0,0,0};

		int r = f(number, a, 0);

		printf("%d: %d %d %d %d\n", r, a[0], a[1], a[2], a[3]);
		
	}

	return 0;
}

