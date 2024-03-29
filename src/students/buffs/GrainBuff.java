package students.buffs;

public class GrainBuff extends ItemModifiers {

	public GrainBuff(double minRange, double maxRange) {
		this.generatedBuff = getRandomPercentage(minRange, maxRange);
		
	}
	
	
}
