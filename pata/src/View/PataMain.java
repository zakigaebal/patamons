package View;

import Controller.Controller;
import Model.Character;
import Model.Patamon;

public class PataMain {
	public static void main(String[] args) {
		Controller c = new Controller();
		boolean isStart = c.loginPage();
		Character patamon = new Patamon();
		if (isStart == true) 
		{
			 c.play(patamon);
		}
	}
}
