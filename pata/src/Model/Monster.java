package Model;

import java.util.Random;

public class Monster {
	private String name;
	private int hp;
	private int str;
	private String stats = "정상";
	private int dropMoney;
	private int exp;

	Random r = new Random();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public int getDropMoney() {
		return dropMoney;
	}

	public void setDropMoney(int dropMoney) {
		this.dropMoney = dropMoney;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}



	public Monster() {
		switch (r.nextInt(3)) {
		case 0:
			name = "아구몬";
			hp = 30;
			str = 10;
			dropMoney = 10;
			exp = 2;
			break;
		case 1:
			name = "그레이몬";
			hp = 50;
			str = 5;
			dropMoney = 20;
			exp = 3;
			break;
		case 2:
			name = "워그레이몬";
			hp = 50;
			str = 10;
			dropMoney = 30;
			exp = 4;
			break;
		default:
			break;
		}
	}
}