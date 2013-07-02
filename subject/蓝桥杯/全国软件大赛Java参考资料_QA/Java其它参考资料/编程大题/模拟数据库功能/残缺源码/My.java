

import java.io.*;
import java.util.*;


// ����ÿ������
class MyRow
{
	private String name;    // ����
	private double length;  // ����
	private double weight;  // ����
	private double power;   // ����
	private double price;   // �۸�
	
	public MyRow(String x)
	{
		String[] ss = x.split("\t");
		name = ss[0].trim();
		length = Double.parseDouble(ss[1]);
		weight = Double.parseDouble(ss[2]);
		power = Double.parseDouble(ss[3]);
		price = Double.parseDouble(ss[4]);
	}
	
	public String toString()
	{
		return name + "\t" + length + "\t" + weight + "\t" + power + "\t" + price;
	}
	
	public String getName() { return name; }
	public double getLength() { return length; }
	public double getWeight() { return weight; }
	public double getPower() { return power; }
	public double getPrice() { return price; }
}

// ������������
class MyData
{
	// �ڲ��࣬�����С��࣬���ڲþ�Vector�еĶ���ıȽϴ�С����	
	class CaiPan implements Comparator
	{
		private int type;
		
		public CaiPan(int type)
		{
			this.type = type;
		}
		
		public int compare(Object o1, Object o2)	
		{
			if(!(o1 instanceof MyRow)) return 0;
			if(!(o2 instanceof MyRow)) return 0;
			
			MyRow r1 = (MyRow)o1;
			MyRow r2 = (MyRow)o2;
			
			switch(type){
			case 1:
				return Double.compare(r1.getLength(),r2.getLength());
			case 2:
				return Double.compare(r1.getWeight(),r2.getWeight());
			case 3:
				return Double.compare(r1.getPower(),r2.getPower());
			case 4:
				return Double.compare(r1.getPrice(),r2.getPrice());
			default:
				return 0;
			}
		}
	}
		
		
	private Vector _v = new Vector();
	
	public void show()
	{
		System.out.println("................................");
		System.out.println("����\t����\t����\t����\t�۸�");
		for(int i=0; i<_v.size(); i++){
			System.out.println(_v.get(i));
		}
		System.out.println("................................");
	}
	
	public boolean load(String x)
	{
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(x)));
			_v.clear();
			br.readLine();  // ��һ�в�Ҫ
			for(;;){
				String s = br.readLine();
				if(s==null) break;
				MyRow row = new MyRow(s);
				_v.add(row);
			}		
			
			show();
			
			return true;	
		}
		catch(Exception e){
			//e.printStackTrace();
			return false;
		}
	}
	
	public boolean sort(String x)
	{
		if(x.equals("length")){
			Collections.sort(_v, new CaiPan(1));
			show();
			return true;
		}
		if(x.equals("weight")){
			Collections.sort(_v, new CaiPan(2));
			show();
			return true;
		}
		if(x.equals("power")){
			Collections.sort(_v, new CaiPan(3));
			show();
			return true;
		}
		if(x.equals("price")){
			Collections.sort(_v, new CaiPan(4));
			show();
			return true;
		}
		
		return false;
	}
	
	// ������������
	public boolean select(String x)
	{
		Vector sort = new Vector();  // ��ʾ���ֶ�
		Vector where = new Vector();  // ���˵��������
		
		String[] ss = x.split(" ");
		
		Vector t = sort;
		for(int i=0; i<ss.length; i++){
			if(ss[i].length()==0) continue;  // ��ֹ����ո�
			if(ss[i].equals("where")){
				t = where;
				continue;
			}
			t.add(ss[i]);
		}
		
		if(sort.size()==0) return false;  // �ֶα���ָ��
		if(sort.size()>5) return false;  // �ֶ�̫��
		
		return select(sort, where); 
	}	
	
	// ִ��select����
	public boolean select(List sort, List where)
	{
	try{
		System.out.println("................................");
		//�������
		for(int k=0; k<sort.size(); k++){
			if(sort.get(k).equals("name"))
				System.out.print("����\t");
			else if(sort.get(k).equals("length"))
				System.out.print("����\t");
			else if(sort.get(k).equals("weight"))
				System.out.print("����\t");
			else if(sort.get(k).equals("power"))
				System.out.print("����\t");
			else if(sort.get(k).equals("price"))
				System.out.print("�۸�\t");
			else if(sort.get(k).equals("*"))
				System.out.print("����\t����\t����\t����\t�۸�\t");
			else
				return false;
		}// ö��sort
		System.out.println("");
		
		
		//�������
		for(int i=0; i<_v.size(); i++){
			MyRow row = (MyRow)_v.get(i);
			if(checkWhere(row, where)){
				for(int k=0; k<sort.size(); k++){
					if(sort.get(k).equals("name"))
						System.out.print(row.getName() + "\t");
					else if(sort.get(k).equals("length"))
						System.out.print(row.getLength() + "\t");
					else if(sort.get(k).equals("weight"))
						System.out.print(row.getLength() + "\t");
					else if(sort.get(k).equals("power"))
						System.out.print(row.getLength() + "\t");
					else if(sort.get(k).equals("price"))
						System.out.print(row.getLength() + "\t");
					else if(sort.get(k).equals("*"))
						System.out.print(row + "\t");
					else
						return false;
				}// ö��sort
				System.out.println("");
			}//����������	
		}//��ÿ���д���
		
		System.out.println("................................");
		return true;
	}
	catch(Exception e){
		//e.printStackTrace();
		return false;
	}
	}
	
	
	// ����true ����м�¼��ʾ������false,����ʾ
	public boolean checkWhere(MyRow row, List where) throws Exception
	{
		if(where.size()==0) return true;
		System.out.println("�����������Ĺ��ܵȴ�������ɣ�");
		return false;
	}
}

// ��������û����������
class MyCommand
{
	private MyData data;
	
	public MyCommand(MyData x)
	{
		data = x;
	}
	
	public boolean execute(String x)
	{
		int d = x.indexOf(" ");  // �ҵ�һ���ո��λ��
		if(d<0) return false;
		
		String x1 = x.substring(0,d);  
		String x2 = x.substring(d+1);  
		
		if(x1.equals("load")){
			if(!data.load(x2.trim()))
				System.out.println("װ���ļ�����");
			return true;
		}
			
		if(x1.equals("sort"))
			return data.sort(x2.trim());
		
		if(x1.equals("select"))
			return data.select(x2);
		
		return false;
	}
}


public class My
{
	private static BufferedReader br_keyboard;  
	
	static
	{
		br_keyboard = new BufferedReader(new InputStreamReader(System.in));  // �������ڴӼ��̶���
	}
	
	public static void main(String[] args) throws Exception
	{
		MyData data = new MyData();
		MyCommand cmd = new MyCommand(data);  // cmd ������ data
		
		for(;;){
			System.out.print("����������(����help��ʾ������Ϣ)��");
			String s = br_keyboard.readLine();
			
			if(s.equals("exit")) break;
			
			if(s.equals("help")){
				System.out.println("----------------------------");
				System.out.println("load data.txt");
				System.out.println("�ӵ�ǰĿ¼װ���ļ�data.txt������ʾ");
				System.out.println("sort weight");
				System.out.println("�������������򣬲���ʾ");
				System.out.println("���Ƶأ��������� sort length, sort price��sort power��");
				System.out.println("select weight length");
				System.out.println("ֻ��ʾ ��������������");
				System.out.println("select weight length where price > 50");
				System.out.println("ֻ��ʾ ��������������, ֻ�����۸� > 50 ����");
				System.out.println("select * where price>50 length<30");
				System.out.println("��ʾ������, ֻ�����۸�>50 �� ����<30 ����");
				System.out.println("��������ϣ����ϱ�����");
				System.out.println("exit");
				System.out.println("�˳�����");
				System.out.println("----------------------------");
				continue;
			}
			
			if(!cmd.execute(s)){
				System.out.println("��Ч������");
			}
		}
		
	}
}