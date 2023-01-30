package app.service;

import org.springframework.stereotype.Service;

@Service
public class RewardsServiceImpl implements RewardsService {

	public int getRewardPoints(int moneySpent) {
		
		//moneySpent > 100; Rewards = 2 * moneySpent - 150;
		if(moneySpent > 100) return 2 * moneySpent - 150;
		
		//moneySpent = 100; Rewards = 50;
		if(moneySpent == 100) return 50;
		
		//moneySpent < 100 && moneySpent > 50; Rewards = moneySpent - 50;
		if(moneySpent < 100 && moneySpent > 50) return moneySpent - 50;
	
		//moneySpent < = 50; Rewards = 0;
		if(moneySpent <= 50) return 0;
		
		return 0;
	}

}
