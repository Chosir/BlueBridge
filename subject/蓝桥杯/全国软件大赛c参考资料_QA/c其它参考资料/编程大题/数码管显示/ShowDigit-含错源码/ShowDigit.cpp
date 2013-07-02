// ShowDigit.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "stdlib.h"
#include "conio.h"
#include "string.h"

/*
����ÿ�����ֶ�Ӧ������ܺŵľ���
�����һ�б�ʾ����0����Ӧ������ܵı��Ϊ0 1 2 3 5 6 7
Ҳ����˵ֻ��3��������ǰ��ģ�����������ܶ��ǵ�����
���磺����8����Ӧ����������ܶ������ġ�
����ܵı���ǰ��մ��ϵ��£������ҵ�˳����еģ�
����ʾ��ͼ��
 
 0000
1    2
1    2
 3333
4    5
4    5
 6666
*/

static int MX[10][7] = 
{
	{1,1,1,0,1,1,1},
	{0,1,1,0,0,1,0},
	{1,0,1,1,1,0,1},
	{1,0,1,1,0,1,1},
	{0,1,1,1,0,1,0},
	{1,1,0,1,0,1,1},
	{1,1,0,1,1,1,1},
	{1,0,1,0,0,1,0},
	{1,1,1,1,1,1,1},
	{1,1,1,1,0,1,1}
};

/*
��������ģ����ʾЧ���Ļ���
��Ϊ�޷���������������ܣ����ǰ�Ҫ��������������ڵ�λ�á���桱����������
ÿ��������ֻ�����1�����֣������������ء���Ϊ��7x4
���磬3��������ڻ������е����Ϊ��
....
....
....
@@@@
....
....
....
�ٱ��磬5�Ź�����Ϊ��
....
....
....
...@
...@
...@
...@
ע�⣬��ͬ�������ռ�ݵ�ģ��λ�������ص����Ⲣ��Ӱ��Ч����
*/
static char BUF1[7][4];
static char BUF2[7][4];
static char BUF3[7][4];


void init_buf(char p[][4])
{
	for(int i=0; i<7; i++){
		for(int j=0; j<4; j++){
			p[i][j] = '.';
		}
	}
}


void write_one_to_buf(char buf[][4], int n)
{
	int i;
	switch(n){
	case 0:
		for(i=0; i<4; i++) 
			buf[0][i] = '@';
		break;
	case 1:
		for(i=0; i<4; i++) 
			buf[i][0] = '@';
		break;
	case 2:
		for(i=0; i<4; i++) 
			buf[i][3] = '@';
		break;
	case 3:
		for(i=0; i<4; i++) 
			buf[3][i] = '@';
		break;
	case 4:
		for(i=0; i<4; i++) 
			buf[i+3][0] = '@';
		break;
	case 5:
		for(i=0; i<4; i++) 
			buf[i+3][3] = '@';
		break;
	case 6:
		for(i=0; i<4; i++) 
			buf[6][i] = '@';
		break;
	}
}


void show_buf()
{
	printf("\n");
	for(int i=0; i<7; i++){
		for(int j=0; j<4; j++){
			printf( "%c", BUF1[i][j]);
		}
		printf("   ");
		for(j=0; j<4; j++){
			printf( "%c", BUF2[i][j]);
		}
		printf("   ");
		for(j=0; j<4; j++){
			printf( "%c", BUF3[i][j]);
		}

		printf("\n");
	}
}

// lk: ˮƽ�Ŵ�ϵ���� hk: ��ֱ�Ŵ�ϵ��
void show_buf_big(int lk, int hk)
{
	// ���Ʋ����ķ���
	if(lk<1)  lk = 1;
	if(lk>5)  lk = 5;
	if(hk<1)  hk = 1;
	if(hk>5)  hk = 5;

	printf("....�ù����뿼������ԭ��Ч����ɣ�\n");
}


void show_buf_lean()
{
	printf("\n");
	for(int i=0; i<7; i++){
		
		for(int k=0; k<i; k++){
			printf(" ");
		}

		for(int j=0; j<4; j++){
			printf( "%c", BUF1[i][j]);
		}
		printf("   ");
		for(j=0; j<4; j++){
			printf( "%c", BUF2[i][j]);
		}
		printf("   ");
		for(j=0; j<4; j++){
			printf( "%c", BUF3[i][j]);
		}
		printf("\n");
	}
}


void write_to_buf(char buf[7][4], int digit)
{
	// ĳ����������Щ���������ɣ�
	for(int i=0; i<7; i++){
		if(MX[digit][i] == 1)
			write_one_to_buf(buf, i);
	}
}


int main(int argc, char* argv[])
{
	for(;;){
		printf("������Ҫ��ʾ��3λ������100-999��, ����exit�˳��� ");
		char buf[100];
		gets(buf);
		
		if(buf=="exit") break;

		int n = atoi(buf);
		if(n<100 || n>999){
			printf("�����������Ч����������...\n");
			continue;
		}

		// �ֽ�Ϊ��ǧλ����λ����λ
		int a = n / 100;  
		int b = n / 10 % 10;
		int c = n % 10;

		init_buf(BUF1);
		init_buf(BUF2);
		init_buf(BUF3);

		//��ʵ��Ӧ���У�ֻҪ֪������Ҫ��ʾ��Щ����ܣ��Ϳ���ֱ�ӿ������ǣ�
		//�ڴ˴�������ͨ��ˢ�µ�һ����������Ļ�������ģ��������̣�
		//������λ�ã������á�.������ʾ��������λ�ã������á�@������ʾ
		write_to_buf(BUF1, a);  
		write_to_buf(BUF2, b);
		write_to_buf(BUF3, c);

		show_buf();  // ��ʾģ�⻺�����е�����

		printf("�����������..");
		getch();
		show_buf_lean();  // ��б��ʾ

		printf("�����������..");
		getch();
		show_buf_big(2,3);  // ˮƽ�Ŵ�2������ֱ�Ŵ�3��

		printf("�����������..");
		getch();
		show_buf_big(5,1);  // ˮƽ�Ŵ�5������ֱ�Ŵ�1������ֱ���Ŵ�
	}

	return 0;
}

