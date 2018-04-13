package lab2;

public class Atom
{
	/**
	 * Way to calculate atom mass, charge and even atom decay
	 */
	private int Protons, Neutrons, Electrons;
	
	/**
	 * Construct an atom with given protons, neutrons, electrons
	 * @param givenProtons
	 * 	get number of protons
	 * @param givenNeutrons
	 * 	get number of neutrons
	 * @param givenElectrons
	 * 	get number of electrons
	 */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons)
	{
		Protons = givenProtons;
		Neutrons = givenNeutrons;
		Electrons = givenElectrons;
	}
	
	/**
	 * returns total number of protons plus neutrons
	 * @return
	 * 	mass for this atom
	 */
	public int getAtomicMass()
	{
		int mass = Protons + Neutrons;
		return mass;
	}
	
	/**
	 * returns the difference between the number of protons and electrons
	 * @return
	 * 	charge of this atom
	 */
	public int getAtomicCharge()
	{
		int charge = Protons - Electrons;
		return charge;
	}
	
	/**
	 * decreases the number of protons by 2 and the number of neutrons by 2
	 */
	public void decay()
	{
		Protons = Protons - 2;
		Neutrons = Neutrons -2;
	}
}
