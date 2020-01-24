
public class Main {

	public static void main(String[] args) {
		CheckInput myobj = new CheckInput();
		PokemonMath calculator = new PokemonMath();
		String aType = myobj.getMessage("Enter the attack type:",
				"Normal Fighting Flying Poison Ground Rock Bug Ghost Steel Fire Water Grass Electric Psychic Ice Dragon Dark Fairy");
		String dType1 = myobj.getMessage("Enter defending type #1:",
				"Normal Fighting Flying Poison Ground Rock Bug Ghost Steel Fire Water Grass Electric Psychic Ice Dragon Dark Fairy");
		String dType2 = myobj.getMessage("Enter defending type #2 (type NA if the pokemon in monotype):",
				"Normal Fighting Flying Poison Ground Rock Bug Ghost Steel Fire Water Grass Electric Psychic Ice Dragon Dark Fairy NA na");
		double x = calculator.calculateTypeAdvantage(aType, dType1, dType2);
		System.out.println(x);
	}

}
