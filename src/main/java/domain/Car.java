package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// �߰� ��� ����

	private static ArrayList<Car> cars = new ArrayList<Car>();
	private static int numMove = 0;

	private final int threshold = 4;

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public int getThreshold() {
		return this.threshold;
	}

	public static void playGame() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputCarsName(br);
		inputNumMove(br);
		for (int i = 0; i < numMove; i++) {
			moveOneRound();
			// printState();
		}

	}

	private static void inputCarsName(BufferedReader br) {
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����)");
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), ",");
			while (st.hasMoreTokens()) {
				cars.add(new Car(validName(st.nextToken())));
			}
		} catch (Exception e) {
			inputCarsName(br);
		}
	}

	private static String validName(String s) throws Exception {
		if (s.length() > 5) {
			System.out.println("�Է� �̸� �� ���̰� 5 �ʰ��� ���� �ֽ��ϴ�.");
			throw new Exception();
		}
		return s;
	}

	private static void inputNumMove(BufferedReader br) {
		System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
		try {
			numMove = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("�߸��� �Է��Դϴ�.");
			inputNumMove(br);
		}
	}

	private static void moveOneRound() {
		Iterator<Car> it = cars.iterator();
		while (it.hasNext()) {
			moveOrNot(it.next());
		}
	}

	private static void moveOrNot(Car c) {
		int tmp = (int) Math.random() * 10;
		if (tmp > c.getThreshold())
			c.position++;
	}

}
