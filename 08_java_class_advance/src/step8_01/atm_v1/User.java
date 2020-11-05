package step8_01.atm_v1;

public class User {
	
	String name   = "";
	int accCount  = 0;
	Account[] acc = null;
	
	void printAccount() {
		
		for (int i = 0; i < accCount; i++) {
			acc[i].printOwnAccount();
		}	
		
	}
	
}
