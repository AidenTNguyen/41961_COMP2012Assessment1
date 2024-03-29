package students.buffs;

import students.ItemModifiers;

public class AppleBuff extends ItemModifiers {
	
	double generatedBuff = 0.0;
	
	public AppleBuff(double minRange, double maxRange) {
		this.generatedBuff = getRandomPercentage(minRange, maxRange);
		
	}
	

}
