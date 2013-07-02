// MyMenu.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "stdlib.h"
#include "string.h"


/*
  ʹ��һ���˵�����Ժ������˵������ϵ
  �����������ԣ�
  �ҵ���һ�����Ӳ˵���
  �ҵ���һ�����ֵܡ�
  �ҵ����ġ����ڵ㡱�˵���
*/
struct MenuItem
{
	char  text[30];
	int level;
	MenuItem*  next;
	MenuItem*  child;
	MenuItem*  parent;
};


/*
  ����һ���˵���������ı������ɲ˵���ҽӵ����ʵ�λ�á�
  �ı���������������TAB�ַ����Ʊ����������
  ��ϸ�۲�ʾ�����ı��ļ���ǰ�ߵĿհײ��ǿո����TAB��
  TAB����Խ�࣬��ʾ����� level Խ�󣬼��˵�·��Խ�����
  ͨ���жϲ˵����level ����һ���˵���� level��ϵ�����Ծ�����Ρ��ҽӡ�
*/
MenuItem* AddMenu( MenuItem* cur, char* text )
{
	MenuItem* pNew = new MenuItem();
	pNew->next = pNew->child = pNew->parent = NULL;

	char* p = text;
	int level = 0;

	while( *p == '\t' ){
		level++;
		p++;
	}

	strcpy( pNew->text, text+level );
	pNew->level = level;
	
	if( pNew->level == cur->level )
	{
		cur->next = pNew;
		pNew->parent = cur->parent;
	}
	else if ( pNew->level > cur->level )
	{
		cur->child = pNew;
		pNew->parent = cur;
	}
	else
	{
		MenuItem* p = cur;
		for(int i=0; i < cur->level - pNew->level; i++) 
			p = p->parent;

		p->next = pNew;
		pNew->parent = p->parent;
	}

	return pNew;
}


void CreateMenu(MenuItem* root)
{
	MenuItem* cur_menu = root;

	FILE* fp = fopen("a.txt", "r"); 
	if( fp == NULL ) exit(-1);

	while(true){
		char buf[100];
		if( fgets( buf, 99, fp ) == NULL ) break;
		// ȥ��β������Ҫ�Ļ��з���
		if(buf[strlen(buf)-1] == '\n' )
			buf[strlen(buf)-1] = '\0';

		cur_menu = AddMenu(cur_menu, buf);
	}

	fclose(fp);
}


void RunMenu(MenuItem* menu)
{
	printf("�ȴ�������ɣ�");
}


// �ͷŲ˵���ռ�õ��ڴ�
void FreeMenu(MenuItem* menu)
{
	if(menu->child != NULL)
		FreeMenu( menu->child );
	if(menu->next != NULL)
		FreeMenu( menu->next );

	delete menu;
}

int main(int argc, char* argv[])
{
	MenuItem* root = new MenuItem();
	root->text[0] = '\0';
	root->next = root->parent = root->child = NULL;
	root->level = -1;

	// �����˵������ڴ��еĽṹ
	CreateMenu( root );

	// ���в˵�
	RunMenu( root );

	// �ͷ���Դ
	FreeMenu( root );

	return 0;
}

