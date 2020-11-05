package step8_01.myAtm_v1;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	
	Scanner scan = new Scanner(System.in);
	
	UserManager manager = new UserManager();
	int identifier = -1;
	
	void printMainMenu() {
		while(true) {
			System.out.println("\n[ATM프로그램동작중...]");
			System.out.println("[1] 로그인 [2] 로그아웃 [3] 회원가입 [4] 회원탈퇴 [5] 종료");
			System.out.print("메뉴를 선택하세요 : ");
			
			int sel = scan.nextInt();
			
			if(sel == 1) 		login();	 
			else if(sel == 2)	logout();	
			else if(sel == 3) 	join();
			else if (sel == 4) 	leave();
			else {
				manager.printAllUser();
//				System.out.println("[ATM프로그램 종료]");
//				break;
			}
		}
	}
	
	void login() {
		if(identifier != -1) {
			System.out.println("이미 로그인 되어있습니다. ");
		} else {
			identifier = manager.logUser();
			System.out.println("로그인 완료");
		}	
	}
	
	void logout() {
		if(identifier == -1) {
			System.out.println("로그인 이후 이용할 수 있는 메뉴입니다. ");
		} else {
			identifier = -1;
			System.out.println("로그아웃 완료 ");
		}
	}
	
	void join() {
		if(identifier != -1) {
			System.out.println("로그아웃 이후 이용할 수 있는 메뉴입니다. ");
		} else {
			manager.addUser();			
		}
	}
	
	void leave() {
		manager.leave();
	}
}
