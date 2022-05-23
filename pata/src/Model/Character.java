package Model;

public interface Character {
	//먹기
	public void eat();
	//자기
	public void sleep();
	//놀기
	public void play();
	//운동하기
	public void train();
	//레벨업
	public void levelUp();
	//게임끝내기
	public boolean endGame();
	//정보창메서드
	public void printInfo();
	//진화
	public void revolution();
	//전투
	public void fight();
}
