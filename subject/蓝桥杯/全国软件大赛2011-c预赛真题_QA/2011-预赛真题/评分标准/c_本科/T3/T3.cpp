
/*
  �𰸣�reverse_str(buf+1,n-2)

  ע��������ָ����﷨�ȼ��ԣ�
  buf + 1 �ȼ�  &buf[1]

  reverse_str(++buf,n-2)   (�Ƚϱ�̬)
*/


#include "stdafx.h"

void reverse_str(char* buf, int n)
{
	if(n<2) return;
	char tmp = buf[0];
	buf[0] = buf[n-1];
	buf[n-1] = tmp;
	reverse_str(buf+1,n-2);   // ���
}


int main(int argc, char* argv[])
{
	char x[] = "1234567";
	reverse_str(x, 7);
	printf("%s\n", x);

	return 0;
}

