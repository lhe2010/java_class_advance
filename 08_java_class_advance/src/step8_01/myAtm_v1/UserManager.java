package step8_01.myAtm_v1;

import java.util.Scanner;

public class UserManager {
	
	Scanner scan = new Scanner(System.in);
	
	User[] users = null;
	int userCount = 0;
	
	void addUser() {
		String tempName="";
		
		while(true) {
			System.out.print("가입하실 유저아이디 : ");
			tempName = scan.next();
			
			boolean isAlready = false;
			// 이미 존재하는 유저인지 확인
			for (int i = 0; i < userCount; i++) {
				if(users[i].name.equals(tempName)) 
					isAlready = true;
			}
			// 이미 존재한다면 빠꾸
			if(isAlready) {
				System.out.println("이미 있는 아이디 입니다. 다시 입력하세요. ");
				continue;
			} else
				break;
		}
		// 유효한 아이디 입력한 경우 진행
		User[] temp = users;
		users = new User[userCount+1];
		for (int i = 0; i < userCount; i++) {
			users[i] = temp[i];
		}
		users[userCount++] = new User(tempName);
		
	}
	
	User getUser(int idx) {
		return users[idx];
	}
	
	int logUser(){
		int nExist = -1;
		while(true) {
			System.out.print("로그인하실 아이디 : ");
			String tempName = scan.next();
			
			for (int i = 0; i < userCount; i++) {
				// 올바른 아이디인 경우 
				if(users[i].name.equals(tempName)) {
					nExist = i;
				}
			}	
			if(nExist == -1) {
				System.out.println("존재하지 않는 아이디 입니다. ");
			} else {
				return nExist;
			}
		}
	}
	
	void leave() {
		while(true) {
			System.out.print("탈퇴하실 아이디 : ");
			String tempName = scan.next();
			
			int nExist = -1;
			for (int i = 0; i < userCount; i++) {
				if(users[i].name.equals(tempName))
					nExist = i;
			}
			
			if (nExist == -1) {
				System.out.println("존재하지 않는 아이디 입니다. ");
				continue;
			} else {
				break;
			}
		}
		// 올바른 아이디인 경우 탈퇴진행 
		User[] tempUsrs = users;
		users = new User[userCount-1];
			
		for (int i = 0; i < nExist; i++) {
				
		
		}
	}
	
	void printAllUser() {
		for (int i = 0; i < userCount; i++) {
			users[i].printAccount();
		}
	}
}
