package Controller;

import java.util.Random;
import java.util.Scanner;

import Model.Monster;
import source.PataImage;
import Model.Character;

/* 
 * �Ĵڸ� Ű���
 * �Ĵڸ� Ű���� ����ġ�� ��� �������ϴ°����̴�.
 * ü�°� ���ݷ��� ������ �ִ�.
 */
public class Controller {
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	PataImage pi = new PataImage();
	boolean isStart = false;
	private static Character character;
	private boolean flag = true;

	String name;
	int level = 1;
	int exp = 0;
	int money = 0;
	// �ִ� ü���� ���̿� ������ ������ �޴´�.
	int hpMax = 100;
	int hp = hpMax;
	int hunger = 100;
	// ���¸� ��Ÿ�� (����/����)
	String stats = "����";
	// ���� 3����
	// strong, wisdom, dexterity
	int str = 10;
	int wis = 10;
	int dex = 10;
	// ���� - ���⿡ ���� ����/���� ����
	int tendency = 0;

	public Controller() {
		mainPage();
	}

	public void mainPage() {
		try {
			pi.startText();
			pi.mainPata();
			pi.gameStart();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean loginPage() {
		System.out.println("[�Ĵڸ� Ű��� �α���â]");
		System.out.println("�Ĵڸ� Ű��� �α����� ���ּ���");
		System.out.println("[1]ȸ�������ϱ� [2]�α����ϱ� [3]����");
		System.out.println();
		System.out.println();
		System.out.println();
		while (true) {
			System.out.print("�� �̸��� �Է��� �ּ��� :  ");
			name = sc.nextLine();

			System.out.print("�� �Է��� �̸��� \'" + name + "\'��(��) �½��ϱ�? [ Y / N ] ");
			if (sc.nextLine().equals("Y")) {
				isStart = true;
				break;
			}
		}
		return isStart;
	}

	public void play(Character c) {
        character=c;
        Scanner sc = new Scanner(System.in);
        int sceneNum = 0;
		System.out.println("���ӽ���!!");
		borderLine();

		if (isStart == true) {
			System.out.println("�Ĵڸ� Ű��⸦ �����մϴ�^^");

			try {
				pi.mainPata();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("����� ���Դϴ�.");
			System.out.println(name + "��(��) ������ �ұ��?");
			System.out.println("1. ���º���        2. �ൿ�ϱ�        3. ���Ẹ��");
			System.out.print("�� �Է����ּ���. ");
		}
		  while (flag) {
	            character.printInfo();
	            System.out.println("1.����̱� 2.������ 3.����ֱ� 4.� 5.��Ʋ 6.����");
	            System.out.println("�Է�>>");
	            String select = sc.nextLine();
	            switch (select) {
	            case "1":
	                character.eat();
	                break;
	            case "2":
	                character.sleep();
	                break;
	            case "3":
	                character.play();
	                break;
	            case "4":
	                character.train();
	                break;
	            case "5":
	            	battlePage();
	            case "6":
	                flag = false;
	                break;  
	            default:
	            	break;
	            }
	            character.levelUp();
	            character.revolution();
	            if (flag == true) {
	            	flag = character.endGame();
	            }
	        }
		  sc.close();
	        
	    }    



	public void battlePage() {
		Monster mon = new Monster();
		int sceneNum = 0;
		boolean again = false;

		do {
			borderLine();
			if (again == false) {
				System.out.println("��ɰ��� ��Ÿ�����ϴ�.");
				System.out.println();
				again = !again;
			} else {
				System.out.println("�����α�");
				System.out.println(name + "�� " + mon.getStr() + "�� �������� �Ծ���!");
				System.out.println(mon.getName() + "�� " + str + "�� �������� �Ծ���!");
				System.out.println();
			}
			System.out.println("�̸� : " + mon.getName() + "\tü�� : " + mon.getHp());
			System.out.println("�̸� : " + name + "\tü�� : " + hp);
			System.out.println();
			System.out.println(name + "��(��) ������ �ұ��?");
			System.out.println("1. �����ϱ�        2. �����ۻ��      3. ��������");
			System.out.print("�� �Է����ּ���. ");

			switch (sc.nextInt()) {
			case 1:
				battle(mon);
				break;
			case 2:
				break;
			case 3:
				sceneNum = 1;
				break;
			default:
				break;
			}
		} while ((!mon.getStats().equals("����")) && sceneNum == 0 && (!stats.equals("����")));

		if (mon.getStats().equals("����")) {
			borderLine();
			System.out.println(name + "��(��) �¸��߽��ϴ�!");
			System.out.println(mon.getDropMoney() + "G �� ������ϴ�.");
			System.out.println("���� 1 �����߽��ϴ�.");
			System.out.println("����ġ�� " + mon.getExp() + "��ŭ ������ϴ�.");
			System.out.println();
			System.out.print("�� �����Ϸ��� �ƹ�Ű�� �Է��ϼ���. ");
			money += mon.getDropMoney();
			exp += mon.getExp();
			str++;
			sc.nextLine();
			sc.nextLine();

		} else if (stats.equals("����")) {
			borderLine();
			System.out.println(name + "��(��) �����ϴ�.");
			System.out.println("100G�� �Ҿ����ϴ�.");
			System.out.println();
			System.out.print("�� �����Ϸ��� �ƹ�Ű�� �Է��ϼ���. ");
			money -= 100;

			stats = "����";

			sc.nextLine();
			sc.nextLine();

		} else {
			borderLine();
			System.out.println(name + "��(��) �����ƽ��ϴ�.");
			System.out.println();
			System.out.print("�� �����Ϸ��� �ƹ�Ű�� �Է��ϼ���. ");
			sc.nextLine();
			sc.nextLine();
		}
	}

	public void battle(Monster mon) {
		mon.setHp(-str);
		
		hp -= mon.getStr();

		if (mon.getHp() <= 0) {
			mon.setStats("����");
		}

		if (hp <= 0) {
			stats = "����";
		}
	}

	private void borderLine() {
		System.out.println();
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------");
		System.out.println();
	}

}
