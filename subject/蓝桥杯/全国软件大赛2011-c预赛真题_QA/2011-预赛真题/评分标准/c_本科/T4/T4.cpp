
/*
  �𰸣�
  ��1��  (int)dTestNo   ��2�֣�
  ��2��  dTestNo>=1.0   ��3�֣�

  ע��ȼ���ʽ���粻���ж���������������������
*/

#include "stdafx.h"

void fun(double dTestNo, int iBase)
{
	int iT[8];
	int iNo;
	
	printf("ʮ������С�� %f ת���� %d ������Ϊ: ",dTestNo, iBase);
	
	for(iNo=0;iNo<8;iNo++)
	{
		dTestNo *= iBase;
		iT[iNo] = (int)dTestNo;    // ���1
		if(dTestNo>=1.0) dTestNo -= iT[iNo];  // ���2
	}
	
	printf("0.");
	for(iNo=0; iNo<8; iNo++) printf("%d", iT[iNo]);
	printf("\n");
}

int main (int argc, char* argv[])
{	
	double dTestNo= 0.795;
	int iBase;
	
	for(iBase=2;iBase<=9;iBase++)
		fun(dTestNo,iBase);
	printf("\n");

	return 0;
}


