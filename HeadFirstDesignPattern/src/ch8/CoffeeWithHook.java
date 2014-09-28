package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

	@Override
	public void addCondiments() {
		System.out.println("Boiling water");
	}

	@Override
	public void brew() {
		System.out.println("Pouring into cup");
	}
	
	public boolean customerWantsCondiments() {
		String answer = getUserInput();
		if(answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
		
	}

	private String getUserInput() {
		String answer = null;
		System.out.println("Would you like milk and sugar with your coffee(y/n)?");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			answer = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(answer == null ){
			answer = "no";
		}
		
		return answer;
	}
}
