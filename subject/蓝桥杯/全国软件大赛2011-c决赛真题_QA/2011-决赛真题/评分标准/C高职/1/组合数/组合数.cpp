

/*
  ���������
  �������� 8 ��

  ���1��(3��)
  return 1

  ���2��(5��)
  f(n-1,m)

��ÿ����ͬ�Ĵ�Ҫϸ�ģ����ȴ�����򣬿�����Ƿ���ȷ
�ٻ����ݲ���

*/





#include "stdafx.h"

// n ��Ԫ������ȡ m ��Ԫ�أ��ж�����ȡ��
int f(int n, int m)
{
	if(m>n) return 0;
	if(m==0) return 1;

	return f(n-1,m-1) + f(n-1,m);
}


int main(int argc, char* argv[])
{
	printf("%d\n", f(10,3));
	printf("%d\n", f(5,3));
	printf("%d\n", f(5,2));

	return 0;
}

