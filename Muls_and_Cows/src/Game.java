
//using Integer.parseInt() method 
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		System.out.println("Выберите уровень сложности: 3, 4 или 5");
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
		String concede="сдаюсь";
		while (end==false) {
			int counter = 0, Try = 0;
			String Number = "";
			while (counter == 0) {
				System.out.println("Введите число из " + Difficulty + " цифр");
				Scanner num = new Scanner(System.in);
				Number = num.next();
				counter++;
				if(Number.compareTo(concede)==0) {
					System.out.print("Было загадано число: ");
					for (int m = 0; m < Difficulty; m++)
						System.out.print(Array[m]);
					end=true;
					break;
				}
				else if (Number.length() != Difficulty) {
					System.out.println("Введено число несоответствующее заданной сложности");
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
					System.out.println("Поздравляю! Вы верно отгадали число! На это вам понадобилось " + Try + " попытка");
				else if(Try>1 && Try<5)
					System.out.println("Поздравляю! Вы верно отгадали число! На это вам понадобилось " + Try + " попытки");
				else 
					System.out.println("Поздравляю! Вы верно отгадали число! На это вам понадобилось " + Try + " попыток");
				end=true;
				break;
			}
			if (Cows == 1)
				System.out.print("Вы отгадали " + Cows + " корову и ");
			else
				System.out.print("Вы отгадали " + Cows + " коров и ");
			if (Muls == 0)
				System.out.println(Muls + " быков.");
			else
				System.out.println(Muls + " быка.");
			System.out.println("Вы можете ввести сдаюсь, если хотите завершить игру");
		}
	}
}
