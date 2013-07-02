// Calcu24.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "conio.h"
#include "stdlib.h"
#include "time.h"
#include "math.h"
#include "string.h"

/*
  ��һ���˿����У���ȡ4�š�
  2-10 �����������(Ϊ�˱�ʾ����10��T��ʾ)��J,Q,K,A ͳһ�� 1 ����
  Ҫ��ͨ���Ӽ��˳���������õ����� 24��
  ��������������ȡֽ�ƣ�������̽����⡣
*/

void GivePuzzle(char* buf)
{
	char card[] = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};

	for(int i=0; i<4; i++){
		buf[i] = card[rand() % 13];
	}
}


void shuffle(char * buf)
{
	for(int i=0; i<5; i++){
		int k = rand() % 4;
		char t = buf[k];
		buf[k] = buf[0];
		buf[0] = t;
	}
}


int GetCardValue(int c)
{
	if(c=='T')  return 10;
	if(c>='0' && c<='9') return c - '0';
	return 1;
}


char GetOper(int n)
{
	switch(n)
	{
	case 0:
		return '+';
	case 1:
		return '-';
	case 2:
		return '*';
	case 3:
		return '/';
	}

	return ' ';
}

double MyCalcu(double op1, double op2, int oper)
{
	switch(oper)
	{
	case 0:
		return op1 + op2;
	case 1:
		return op1 - op2;
	case 2:
		return op1 * op2;
	case 3:
		if(fabs(op2)>0.0001)
			return op1 / op2;
		else
			return 100000;
	}

	return 0;
}


void MakeAnswer(char* answer, int type, char* question, int* oper)
{
	char p[4][3];

	for(int i=0; i<4; i++)
	{
		if( question[i] == 'T' )
			strcpy(p[i], "10");
		else
			sprintf(p[i], "%c", question[i]);
	}
	
	switch(type)
	{
	case 0:
		sprintf(answer, "%s %c (%s %c (%s %c %s))", 
			p[0], GetOper(oper[0]), p[1], GetOper(oper[1]), p[2], GetOper(oper[2]), p[3]);
		break;
	case 1:
		sprintf(answer, "%s %c ((%s %c %s) %c %s)", 
			p[0], GetOper(oper[0]), p[1], GetOper(oper[1]), p[2], GetOper(oper[2]), p[3]);
		break;
	case 2:
		sprintf(answer, "(%s %c %s) %c (%s %c %s)", 
			p[0], GetOper(oper[0]), p[1], GetOper(oper[1]), p[2], GetOper(oper[2]), p[3]);
		break;
	case 3:
		sprintf(answer, "((%s %c %s) %c %s) %c %s", 
			p[0], GetOper(oper[0]), p[1], GetOper(oper[1]), p[2], GetOper(oper[2]), p[3]);
		break;
	case 4:
		sprintf(answer, "(%s %c (%s %c %s)) %c %s", 
			p[0], GetOper(oper[0]), p[1], GetOper(oper[1]), p[2], GetOper(oper[2]), p[3]);
		break;
	}
}


bool TestResolve(char* question, int* oper, char* answer)
{
	// �ȴ��������
	return false;
}


/*
  ���������̽��������ͨ��������ֲ��� �Ӽ��˳��� ��ϣ�ͨ�������Ĳ��������еĽⷨ
  ��ʾ��
  1. ��Ҫ���������ſ��Ƽ����������� ���磺( 10 - 4 ) * ( 3 + A ), ʵ���ϼ���������Ŀ�����޵ģ�
     A*(B*(c*D))
	 A*((B*C)*D)
	 (A*B)*(C*D)
	 ((A*B)*C)*D
	 (A*(B*C))*D
  2. ��Ҫ���Ǽ�����Ϊ�����������( 3 + (3 / 7) ) * 7
  3. ��Ŀ���Ƶ�λ�ÿ������⽻��
*/
bool TryResolve(char* question, char* answer)
{
	int oper[3];  // �洢�������0:�ӷ� 1:���� 2:�˷� 3:����

	
	for(int i=0; i<1000 * 1000; i++)
	{
		// ����ֽ��˳��
		shuffle(question);
		
		// ������������
		for(int j=0; j<3; j++)
			oper[j] = rand() % 4;

		if( TestResolve(question, oper, answer) )  return true;
	}

	return false;
}


int main(int argc, char* argv[])
{
	// ��ʼ���������
	srand( (unsigned)time( NULL ) );

	char buf1[4];   // ��Ŀ
	char buf2[30];  // ���


	printf("***************************\n");
	printf("����24\n");
	printf("A J Q K ����1���㣬�������Ƶ����\n");
	printf("Ŀ���ǣ�ͨ������������ϳ������24\n");
	printf("***************************\n\n");


	for(;;)
	{
		GivePuzzle(buf1);  // ����

		
		printf("��Ŀ��");
		for(int j=0; j<4; j++){
			if( buf1[j] == 'T' )
				printf("10 ");
			else
				printf("%c ", buf1[j]);
		}

		printf("\n��������ο���...\n");
		getch();

		if( TryResolve(buf1, buf2) )  // ����
			printf("�ο���%s\n", buf2);
		else
			printf("�������޽�...\n");

		printf("�����������һ��Ŀ��x ���˳�...\n");
		if( getch() == 'x' ) break;
	}

	return 0;
}

