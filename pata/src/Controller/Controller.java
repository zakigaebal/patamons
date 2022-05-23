package Controller;

import java.util.Random;
import java.util.Scanner;

import Model.Monster;
import source.PataImage;
import Model.Character;

/* 
 * 파닥몬 키우기
 * 파닥몬 키우기는 경험치를 얻고 레벨업하는게임이다.
 * 체력과 공격력을 가지고 있다.
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
	// 최대 체력은 나이와 레벨에 영향을 받는다.
	int hpMax = 100;
	int hp = hpMax;
	int hunger = 100;
	// 상태를 나타냄 (정상/죽음)
	String stats = "정상";
	// 스텟 3종류
	// strong, wisdom, dexterity
	int str = 10;
	int wis = 10;
	int dex = 10;
	// 성향 - 성향에 따라 마왕/왕이 결정
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
		System.out.println("[파닥몬 키우기 로그인창]");
		System.out.println("파닥몬 키우기 로그인을 해주세요");
		System.out.println("[1]회원가입하기 [2]로그인하기 [3]종료");
		System.out.println();
		System.out.println();
		System.out.println();
		while (true) {
			System.out.print("▶ 이름을 입력해 주세요 :  ");
			name = sc.nextLine();

			System.out.print("▶ 입력한 이름이 \'" + name + "\'이(가) 맞습니까? [ Y / N ] ");
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
		System.out.println("게임시작!!");
		borderLine();

		if (isStart == true) {
			System.out.println("파닥몬 키우기를 시작합니다^^");

			try {
				pi.mainPata();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("여기는 집입니다.");
			System.out.println(name + "은(는) 무엇을 할까요?");
			System.out.println("1. 상태보기        2. 행동하기        3. 종료보기");
			System.out.print("▶ 입력해주세요. ");
		}
		  while (flag) {
	            character.printInfo();
	            System.out.println("1.밥먹이기 2.잠재우기 3.놀아주기 4.운동 5.배틀 6.종료");
	            System.out.println("입력>>");
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
				System.out.println("사냥감이 나타났습니다.");
				System.out.println();
				again = !again;
			} else {
				System.out.println("전투로그");
				System.out.println(name + "는 " + mon.getStr() + "의 데미지를 입었다!");
				System.out.println(mon.getName() + "는 " + str + "의 데미지를 입었다!");
				System.out.println();
			}
			System.out.println("이름 : " + mon.getName() + "\t체력 : " + mon.getHp());
			System.out.println("이름 : " + name + "\t체력 : " + hp);
			System.out.println();
			System.out.println(name + "은(는) 무엇을 할까요?");
			System.out.println("1. 공격하기        2. 아이템사용      3. 도망가기");
			System.out.print("▶ 입력해주세요. ");

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
		} while ((!mon.getStats().equals("죽음")) && sceneNum == 0 && (!stats.equals("죽음")));

		if (mon.getStats().equals("죽음")) {
			borderLine();
			System.out.println(name + "은(는) 승리했습니다!");
			System.out.println(mon.getDropMoney() + "G 를 얻었습니다.");
			System.out.println("힘이 1 증가했습니다.");
			System.out.println("경험치를 " + mon.getExp() + "만큼 얻었습니다.");
			System.out.println();
			System.out.print("▶ 진행하려면 아무키나 입력하세요. ");
			money += mon.getDropMoney();
			exp += mon.getExp();
			str++;
			sc.nextLine();
			sc.nextLine();

		} else if (stats.equals("죽음")) {
			borderLine();
			System.out.println(name + "은(는) 졌습니다.");
			System.out.println("100G를 잃었습니다.");
			System.out.println();
			System.out.print("▶ 진행하려면 아무키나 입력하세요. ");
			money -= 100;

			stats = "정상";

			sc.nextLine();
			sc.nextLine();

		} else {
			borderLine();
			System.out.println(name + "은(는) 도망쳤습니다.");
			System.out.println();
			System.out.print("▶ 진행하려면 아무키나 입력하세요. ");
			sc.nextLine();
			sc.nextLine();
		}
	}

	public void battle(Monster mon) {
		mon.setHp(-str);
		
		hp -= mon.getStr();

		if (mon.getHp() <= 0) {
			mon.setStats("죽음");
		}

		if (hp <= 0) {
			stats = "죽음";
		}
	}

	private void borderLine() {
		System.out.println();
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------");
		System.out.println();
	}

}
