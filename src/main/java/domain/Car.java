package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void playGame() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputCarsName(br);
		inputNumMove(br);

	}

	private void inputCarsName(BufferedReader br) {
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

	private String validName(String s) throws Exception {
		if (s.length() > 5) {
			System.out.println("�Է� �̸� �� ���̰� 5 �ʰ��� ���� �ֽ��ϴ�.");
			throw new Exception();
		}
		return s;
	}

	private void inputNumMove(BufferedReader br) {
		System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
		try {
			numMove = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("�߸��� �Է��Դϴ�.");
			inputCarsName(br);
		}
	}

}
