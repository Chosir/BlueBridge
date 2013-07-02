import java.io.*;

class FileOp {
	public static void main(String args[]) 
	{
		try	{
			while(run()!=0);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static int run() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int c = -1;
		while (c != 0) {
			System.out.println("-----------------");
			System.out.println("1. ����Ŀ¼");
			System.out.println("2. ɾ��Ŀ¼");
			System.out.println("3. �����ļ�");
			System.out.println("4. ɾ���ļ�");
			System.out.println("0. �˳�");
			System.out.println("-----------------");			
			System.out.print("���������ѡ��");
			try {
				c = Integer.parseInt(br.readLine().trim());
			} catch (Exception e) {
				System.out.println("��Ч��ѡ��");
				continue;
			}
			switch (c) 
			{
				case 0:
					System.out.println("�ټ���");
					return 0;
				case 1:
					System.out.print("������Ҫ������Ŀ¼����");
					createDirectory(br.readLine());
					break;					
				case 2:
					System.out.print("������Ҫɾ����Ŀ¼����");
					delDirectory(br.readLine());
					break;
				case 3:
					System.out.print("������Ҫ�������ļ�����");
					createFile(br.readLine());
					break;					
				case 4:
					System.out.print("������Ҫɾ�����ļ�����");
					delFile(br.readLine());
					break;	
				default:
					System.err.println("��Ч��ѡ��");
					continue;
			}	
			System.out.println();			
		} 		
		
		return 1;
	}
		
	// ɾ���ļ���
	public static void delDirectory(String folderPath) 
	{
		System.out.println("�ȴ�������ɣ�");
	}
	
	// ɾ��ָ�����ļ�
	public static void delFile(String name)
	{
		System.out.println("�ȴ�������ɣ�");
	}
		
	//�����ļ�
	public static void createFile(String name) throws IOException
	{
		System.out.println("�ȴ�������ɣ�");
	}
	
	//����Ŀ¼	
	public static void createDirectory(String name)
	{
		System.out.println("�ȴ�������ɣ�");
	}
}

