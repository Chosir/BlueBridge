import java.io.*;

public class ATM {

	private Account acc;
 
	private File dataFile;
	private FileWriter fw;
	private BufferedWriter bw;
 
	private String filePath = "./data.txt";
 
	public ATM() {
		this.acc = new Account();
		try {
			this.dataFile = new File(this.filePath);
			if (!this.dataFile.exists()) {
				this.dataFile.createNewFile(); 
			}
			this.fw = new FileWriter(this.filePath);
			this.bw = new BufferedWriter(this.fw);
		} catch (IOException io) {
			System.err.println("�޷����ļ�");
			io.printStackTrace(); 
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	public static void main(String[] args) {
		new ATM().interact();
	}
 
	public void interact() {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�ʺ�: ");
			String temp = br.readLine();
			System.out.println("����: ");
			String temp2;
			boolean flag = true;
			int i = 0;
			

		}catch(Exception e){
			System.out.println(e);
		}

	}  
}


class Account {
 
	private long accNo = 123456;
	private String pass = "666666";
	private long balance = 10000;
 
	public Account() {
	}
 
	public boolean isValid(long accNo, String pass) {
		return (this.accNo == accNo) && (pass.equals(this.pass));
	}
 
	public void changePassword(String oldPass, String password) {
		if (!oldPass.equals(this.pass)) {
			System.err.println("�������");
			return; 
		}
		if (password.length() < 6) {
			System.err.println("������6λ����");
			return; 
		}
		if (password.equals(this.pass)) {
			System.err.println("�����벻����ԭʼ������ͬ");
			return; 
		}
		this.pass = password;  
	}
	
	public long balanceInquery() {
		return this.balance; 
	}
	
	public void withdraw(long amount) {
		if (amount > 5000 || amount < 0) {
		System.err.println("ȡ�Χ: $0-$5000");
		return; 
	}
	if ((amount % 100) != 0) {
		System.err.println("ȡ���������100�ı�����");
		return; 
	}
	long newBalance = this.balance - amount;
	if (newBalance < 0) {
		System.err.println("�˻����㣡");
		return; 
	}
	this.balance = newBalance;
	}
	
	public void deposit(long amount) {
		if (amount < 0) {
			System.err.println("�����Ǹ�����");
			return; 
		}
		this.balance += amount;
	}
	
	public String toString1() {
		return ("�ʺ�: " + this.accNo + "\n" + "����: " + this.pass + "\n" + "���: " + this.balance);
	}
} 