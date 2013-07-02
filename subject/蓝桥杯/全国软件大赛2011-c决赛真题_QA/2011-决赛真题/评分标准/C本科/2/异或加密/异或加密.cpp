

/*
  �������֣�14��
  
  ���1��(7��)
  uckey[i/8] |= (unsigned char)0x80 >> (i%8);

  ���2��(7��)
  uckey[i/8] &= ~((unsigned char)0x80 >> (i%8));

  ע�������߼��ȼ���ʽ������ȷ�Ĵ𰸣��������ʹ������λ��
  (unsignec char)0x80 >> 2  �ȼ��ڣ�0x01 << 5
  ��ÿ����ͬ�Ĵ�Ҫϸ�ģ����ȴ�����򣬿�����Ƿ���ȷ
  �ٻ����ݲ���
*/



#include "stdafx.h"
#include <String.h>
#include <stdlib.h>

// ��һ���������ɶ�����λѭ��������
// ͬ����ʽ����


void f(char* buf, unsigned char* uckey, int n)
{
	int i;
	for(i=0; i<n; i++)
		buf[i] = buf[i] ^ uckey[i];
}

int main(int argc, char* argv[])
{
	char p[] = "abcd�й���123";  // �����ܴ�
	
	//char* key = "11001100010001110";  //�������ܳ״�
	char* key = "11100";  //�������ܳ״�
	
	int np = strlen(p);
	int nk = strlen(key);
	unsigned char* uckey = (unsigned char*)malloc(np); 
	
	int i;
	for(i=0; i<np*8; i++)
	{
		if(key[i%nk]=='1')
			uckey[i/8] |= (unsigned char)0x80 >> (i%8);
		else
			uckey[i/8] &= ~((unsigned char)0x80 >> (i%8));
		
	}

	for(i=0; i<np; i++)
	{
		printf("%02X ", (unsigned char)p[i]);
	}
	printf("\n");	

	f(p, uckey, strlen(p));
	
	for(i=0; i<np; i++)
	{
		printf("%02X ", (unsigned char)p[i]);
	}
	printf("\n");

	f(p, uckey, strlen(p));
	
	printf("%s\n", p);
	
	free(uckey);
	
	return 0;
}

