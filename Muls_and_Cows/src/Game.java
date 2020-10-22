
//using Integer.parseInt() method 
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		System.out.println("�������� ������� ���������: 3, 4 ��� 5");
		Scanner dif = new Scanner(System.in);
		int Difficulty = dif.nextInt();
		int[] Array = new int[Difficulty];
		Array[0] = 0;
		Random random = new Random();
		for (int i = 0; i < Difficulty; i++) {
			Array[i] = random.nextInt(10);
			if (i > 0)
				for (int j = 0; j < i; j++)
					if (Array[i] == Array[j])
						i--;
		}
		for (int m = 0; m < Difficulty; m++)
			System.out.print(Array[m]);
		boolean end = false;
		String concede="������";
		while (end==false) {
			int counter = 0, Try = 0;
			String Number = "";
			while (counter == 0) {
				System.out.println("������� ����� �� " + Difficulty + " ����");
				Scanner num = new Scanner(System.in);
				Number = num.next();
				counter++;
				if(Number.compareTo(concede)==0) {
					System.out.print("���� �������� �����: ");
					for (int m = 0; m < Difficulty; m++)
						System.out.print(Array[m]);
					end=true;
					break;
				}
				else if (Number.length() != Difficulty) {
					System.out.println("������� ����� ����������������� �������� ���������");
					counter = 0;
				} 
				else
					Try++;
			}
			if(Number.compareTo(concede)==0)
				break;
			int Muls = 0;
			int Cows = 0;
			for (int k = 0; k < Difficulty; k++) {
				int d= Character.getNumericValue(Number.charAt(k));
				System.out.print(d);
				for (int g = 0; g < Difficulty; g++)
					if (Array[g] == d) {
						if (g == k)
							Muls++;
						else
							Cows++;
					}
			}
			if (Muls == Difficulty) {
				if(Try==1)
					System.out.println("����������! �� ����� �������� �����! �� ��� ��� ������������ " + Try + " �������");
				else if(Try>1 && Try<5)
					System.out.println("����������! �� ����� �������� �����! �� ��� ��� ������������ " + Try + " �������");
				else 
					System.out.println("����������! �� ����� �������� �����! �� ��� ��� ������������ " + Try + " �������");
				end=true;
				break;
			}
			if (Cows == 1)
				System.out.print("�� �������� " + Cows + " ������ � ");
			else
				System.out.print("�� �������� " + Cows + " ����� � ");
			if (Muls == 0)
				System.out.println(Muls + " �����.");
			else
				System.out.println(Muls + " ����.");
			System.out.println("�� ������ ������ ������, ���� ������ ��������� ����");
		}
	}
}
