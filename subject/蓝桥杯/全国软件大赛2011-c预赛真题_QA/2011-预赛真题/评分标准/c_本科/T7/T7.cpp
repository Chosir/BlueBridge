/*
  �ο��𰸣�
  ��1��pro(m-1,n,x-1,y-1)  (5��)
  ��2��pro(m,n-1,x-1,y)    (5��)

  δ֪�𰸴�������һ�£������鼸��������
*/

#include "stdafx.h"

/*
m: ���к������Ŀ
n: ���а������Ŀ
x: ��Ҫȡ������Ŀ
y: �������ٳ��ֵĴ���
*/
double pro(int m, int n, int x, int y)
{
	if(y>x) return 0;
	if(y==0) return 1;
	if(y>m) return 0;
	if(x-n>y) return 1;
	double p1 = pro(m-1,n,x-1,y-1);  // ���1
	double p2 = pro(m,n-1,x-1,y);    // ���2
	return (double)m/(m+n) * p1 + (double)n/(m+n) * p2;
}


int main(int argc, char* argv[])
{
	printf("%f\n",pro(5,5,3,1));
	return 0;
}

