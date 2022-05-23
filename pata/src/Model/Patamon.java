package Model;

public class Patamon implements Character
{

	private int experience = 40;
	private int energy = 50;
	private int level = 1;
	
	@Override
	public void eat() {
		energy += 25;
		System.out.println("�ȳ�...���ִ�!!");
		System.out.println();
	}

	@Override
	public void sleep() {
		energy+=10;
		System.out.println("�Ĵڸ��� �������ϴ� Z z Z z");
		System.out.println();
	}

	@Override
	public void play() {
		energy-=30;
		experience+=30;
		System.out.println("����....energy Down");
		System.out.println("��������~����ġ ���");
		System.out.println("");
	}

	@Override
	public void train() {
		energy-=30;
		experience+=30;
		System.out.println("�Ĵڸ��� �Ʒ���.");
		System.out.println("��������~����ġ ���");
		System.out.println("");
	}

	@Override
	public void levelUp() {
		if(experience>60) {
			experience-=40;
			level++;
			System.out.println("������ "+level);
			System.out.println();
		}
	}

	@Override
	public boolean endGame() {
        boolean returnValue=true;
//        if(level>4) {
//            System.out.println("�Ĵڸ��� ������� ��ȭ�߽��ϴ�!");
//            returnValue=false;
//        }
        if(energy<0) {
            System.out.println("���αⰡ ���� �׾����ϴ�....");
            returnValue=false;
        }
        return returnValue;
    }

	@Override
	public void printInfo() {
		System.out.println("================");
		System.out.println("   �Ĵڸ� ����â   ");
		System.out.println("   ����ġ: "+experience);
		System.out.println("   ������: "+energy);
		System.out.println("   ����: "+level);
		System.out.println("===============");
	}

	@Override
	public void revolution() {
	        if(level>4) {
	            System.out.println("�Ĵڸ��� ������� ��ȭ�߽��ϴ�!");
	            System.out.println();
	        }
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		
	}
}
