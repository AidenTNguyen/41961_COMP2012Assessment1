package students.buffs;

public class AppleBuff extends ItemModifiers {
	
	public AppleBuff(double minRange, double maxRange) {
		this.generatedBuff = getRandomPercentage(minRange, maxRange);
		
	}
	

}
