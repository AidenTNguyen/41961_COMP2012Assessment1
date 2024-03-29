package students.buffs;

import students.ItemModifiers;

public class AppleBuff extends ItemModifiers {
	
	public AppleBuff(double minRange, double maxRange) {
		this.generatedBuff = getRandomPercentage(minRange, maxRange);
		
	}
	

}
