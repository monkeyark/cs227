package lab2;

public class AtomTest {

	public static void main(String[] args)
	{
		// initialize Uranium-238 atom (92 protons, 146 neutrons, 92 electrons)
		Atom Uranium238 = new Atom(92, 146, 92);
		System.out.println(Uranium238.getAtomicMass());
		System.out.println(Uranium238.getAtomicCharge());
		
		// Uranium-238 decay
		Uranium238.decay();
		System.out.println(Uranium238.getAtomicMass());
		System.out.println(Uranium238.getAtomicCharge());
	}
}
