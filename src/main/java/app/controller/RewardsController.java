package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.RewardsService;

@RestController
public class RewardsController {

	@Autowired
	RewardsService rewardsService;
	
	String commonMessage = "<h1 align='center'>Rewards Project</h1>";
	
	@GetMapping("/rewards")
	public ResponseEntity lookupRewards(int moneySpent) throws Exception {
		if(moneySpent != 0) {
			int rewardPoints = rewardsService.getRewardPoints(moneySpent);
			String message = "<h2>For $" + moneySpent + " money spent, the rewards points are: " + rewardPoints + "</h2>";
			return new ResponseEntity(commonMessage + message, HttpStatus.OK);
		} 
		return new ResponseEntity(commonMessage + "<h2>Bad data</h2>", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ Exception.class })
    public ResponseEntity handleException(Exception e){
		return new ResponseEntity(commonMessage + "<h2>Cannot perform rewards calculation. Please check the input. </h2>", HttpStatus.INTERNAL_SERVER_ERROR); 
    }
}
