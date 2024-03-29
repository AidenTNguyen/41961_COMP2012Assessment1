package students.buffs;

import students.ItemModifiers;

public class GrainBuff extends ItemModifiers {

	public GrainBuff(double minRange, double maxRange) {
		this.generatedBuff = getRandomPercentage(minRange, maxRange);
		
	}
	
	
}
