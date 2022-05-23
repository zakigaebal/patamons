package Model;

public class Patamon implements Character
{

	private int experience = 40;
	private int energy = 50;
	private int level = 1;
	
	@Override
	public void eat() {
		energy += 25;
		System.out.println("냠냠...맛있다!!");
		System.out.println();
	}

	@Override
	public void sleep() {
		energy+=10;
		System.out.println("파닥몬이 잠들었습니다 Z z Z z");
		System.out.println();
	}

	@Override
	public void play() {
		energy-=30;
		experience+=30;
		System.out.println("힘듦....energy Down");
		System.out.println("아이조아~경험치 상승");
		System.out.println("");
	}

	@Override
	public void train() {
		energy-=30;
		experience+=30;
		System.out.println("파닥몬이 훈련중.");
		System.out.println("아이좋아~경험치 상승");
		System.out.println("");
	}

	@Override
	public void levelUp() {
		if(experience>60) {
			experience-=40;
			level++;
			System.out.println("레벨업 "+level);
			System.out.println();
		}
	}

	@Override
	public boolean endGame() {
        boolean returnValue=true;
//        if(level>4) {
//            System.out.println("파닥몬이 엔젤몬로 진화했습니다!");
//            returnValue=false;
//        }
        if(energy<0) {
            System.out.println("꼬부기가 굶어 죽었습니다....");
            returnValue=false;
        }
        return returnValue;
    }

	@Override
	public void printInfo() {
		System.out.println("================");
		System.out.println("   파닥몬 정보창   ");
		System.out.println("   경험치: "+experience);
		System.out.println("   에너지: "+energy);
		System.out.println("   레벨: "+level);
		System.out.println("===============");
	}

	@Override
	public void revolution() {
	        if(level>4) {
	            System.out.println("파닥몬이 엔젤몬로 진화했습니다!");
	            System.out.println();
	        }
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		
	}
}
