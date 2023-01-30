package app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RewardsServiceImplTest {

	@Autowired
	RewardsService rewardsService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetRewardPointsMoneySpentGreaterThan100() {
		int moneySpent = 120;
		int expectedRewardPoints = 90;
		int actualRewardPoints = rewardsService.getRewardPoints(moneySpent);
		Assertions.assertTrue(expectedRewardPoints == actualRewardPoints);
	}
	
	@Test
	void testGetRewardPointsMoneySpentEqualTo100() {
		int moneySpent = 100;
		int expectedRewardPoints = 50;
		int actualRewardPoints = rewardsService.getRewardPoints(moneySpent);
		Assertions.assertTrue(expectedRewardPoints == actualRewardPoints);
		
	}
	
	@Test
	void testGetRewardPointsMoneySpentLessThan100AndGreaterThan50() {
		int moneySpent = 90;
		int expectedRewardPoints = 40;
		int actualRewardPoints = rewardsService.getRewardPoints(moneySpent);
		Assertions.assertTrue(expectedRewardPoints == actualRewardPoints);
	}
	
	@Test
	void testGetRewardPointsMoneySpentEqualTo50() {
		int moneySpent = 50;
		int expectedRewardPoints = 0;
		int actualRewardPoints = rewardsService.getRewardPoints(moneySpent);
		Assertions.assertTrue(expectedRewardPoints == actualRewardPoints);
	}
	
	@Test
	void testGetRewardPointsMoneySpentLessThan50() {
		int moneySpent = 40;
		int expectedRewardPoints = 0;
		int actualRewardPoints = rewardsService.getRewardPoints(moneySpent);
		Assertions.assertTrue(expectedRewardPoints == actualRewardPoints);
	}

}
