package boundary;

public class Texts {
	

	public static String[] text;
	
	private String[] textDansk =
		{
		"Skriv navn på spiller ", //0
		"Velkommen, skriv antal spillere:", //1
		"'s tur til at kaste terninger", //2
		"Du er gået fallit", //3
		" har vundet!", //4
		" har ingen ejer, vil du gerne købe det for ", //5
		"Ja", //6
		"Nej", //7
		"Du har købt ", //8
		"Du nægtede at købe", //9
		"Du har ikke nok point til at købe ", //10
		" er ejet af dig selv, og så sker der ikke noget.", //11
		" er ejet af", //12
		" points vil bive overført til ", //13
		"'s balance", //14
		", du har ikke råd til det. dine resterende ", //15
		"Du har landet på ", //16
		" og modtager ", //17
		" points.", //18
		". Du kan slappe af her, indtil det bliver din tur igen.", //19
		" og må betale 2000 points i skat", //20
		"skatten er højere end din balance. ", //21
		"Du betaler resten af dine balance i stedet.", //22
		" og skal betale skat. ", //23
		"Vil du betale 200 points eller 10% af dine totale point?", //24
		"200", //25
		"10%", //26
		"Skatten højere end din balance. i stedet betaler du 10% dine point", //27
		"Du har passeret start feltet og modtager ", //28
		"DU er gået validt.", //29
		};
	
	private String[] textEnglish = 
		{
			"Enter name of player ", //0
			"Welcome, choose amount of players:", //1
			"'s turn to roll the dice.", //2
			"You have gone bankrupt.", //3
			" have won!", //4
			" has no owner, would you like to buy it for ", //5
			"Yes", //6
			"No", //7
			"You have successfully bought ", //8
			"You refused to buy ", //9
			"You dont have enough points to buy ", //10
			" is owned by yourself and therefore nothing happens.", //11
			" is owned by ", //12
			" points will be transfered to ", //13
			"'s balance", //14
			", but the rent is higher than your balance. Your remaining ", //15
			"You have landed on ", //16
			" and recieve ", //17
			" points.", //18
			". Rest here until next turn.", //19
			" and must pay a tax of 2000 points", //20
			"The tax is higher than your balance. ", //21
			"Instead you pay the rest of you balance.", //22
			" and have to pay tax. ", //23
			"Would you like to pay 200 points or 10% of your total score?", //24
			"200", //25
			"10%", //26
			"The tax is higher than your balance. Instead you pay 10% of your score", //27
			"You have have passed Start field and receive ", //28
			"You have gone bankrupt.", //29
		};
	

	public Texts(String language) {
		if(language.equals("Dansk")) {
			text = textDansk;
		} else if(language.equals("English")) {
			text = textEnglish;
		} else {
			text = textEnglish;
		}
	}

	public Texts() {
		// TODO Auto-generated constructor stub
	}
}
