
/*
  �𰸣�
  ��1��  len+1     (2��)
  ��2��  0         (4��)

ע�⣺
��2 �ȼ���ʽ�������ǣ�
'\0'  
(char)0  
NULL

�粻�ܶ϶�����Ҫ�������
���磺
��2��s[len]  �ͱȽϱ�̬�������С�
*/

#include "stdafx.h"
#include "string.h"
#include "stdlib.h"


void shift(char* s, int n)
{
	char* p;
	char* q;
	int len = strlen(s);
	if(len==0) return;
	if(n<=0 || n>=len) return;
	
	char* s2 = (char*)malloc(len+1);   // ���1
	p = s;
	q = s2 + n % len;
	while(*p)
	{	
		*q++ = *p++;
		if(q-s2>=len)
		{
			*q = 0;  // ���2
			q = s2;
		}
	}
	strcpy(s,s2);
	free(s2);
}


int main(int argc, char* argv[])
{
	char x[] = "abcdefg";
	shift(x,2);
	printf("%s\n", x);
	return 0;
}

