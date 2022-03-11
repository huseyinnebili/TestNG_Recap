package driver;

import java.util.Scanner;

public class Demo {

	static int sum;

	public static void main(String[] args) {

		for (int i = 0; i < 30; i += 5) {

			if (i % 2 != 0) {

				if (i % 3 == 0) {

					continue;
				}

				sum = sum + i;
				System.out.print(i + ",");
			}

		}

		System.out.println("===========");
		System.out.println(sum);
	}
}
