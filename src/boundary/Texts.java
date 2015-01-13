package boundary;

public class Texts {
	

	public static String[] text;
	
	private String[] textDansk =
		{
		"Skriv navn på spiller ", //0
		"Velkommen, vælg antal spillere:", //1
		"'s tur til at kaste terningerne.", //2
		"Du er gået fallit.", //3
		" har vundet!", //4
		" har ingen ejer, vil du gerne købe det for ", //5
		"Ja", //6
		"Nej", //7
		"Du har købt ", //8
		"Du nægtede at købe ", //9
		"Du har ikke nok point til at købe ", //10
		" er ejet af dig selv, og så sker der ikke noget.", //11
		" er ejet af ", //12
		" points vil bive overført til ", //13
		"'s balance", //14
		", du har ikke råd til det. Dine resterende ", //15
		"Du har landet på ", //16
		" og modtager ", //17
		" points.", //18
		". Du kan slappe af her, indtil det bliver din tur igen.", //19
		" og må betale 200 points i skat", //20
		"skatten er højere end din balance. ", //21
		"Du betaler resten af dine balance i stedet.", //22
		" skal betales. ", //23
		"Vil du betale 200 points eller 10% af dine totale point?", //24
		"200", //25
		"10%", //26
		"Skatten højere end din balance. i stedet betaler du 10% dine point", //27
		"Du har passeret start feltet og modtager ", //28
		"DU er gået falit.", //29
		" på fængsel du er kun på besøg og kan forlade når som helst", //30
		"du er i fængsel kast lige tergninger for at komme ud", //31
		"Du er blevet fængslet.", //32
		" du kan endten betale dig ud", //33
		" eller blive sat fri på grund af god opførsel (ved at rulle to ens terninger)", //34
		" er i fængsel. Vil du betale 100 point for at komme ud?", //35
		"Du har ikke nok point til at betale kaution ... vent på din løsladelse", //36
		" . Du har nu ", //37
		" fængsels tur tilbage",//38
		"Betal for vognvask og smøring kr. 15,00.", //39
		"De har kørt frem for \"Fuld stop\". Betal 150 point.", //40
		
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
			" and must pay a tax of 200 points", //20
			"The tax is higher than your balance. ", //21
			"Instead you pay the rest of you balance.", //22
			" have to be paid. ", //23
			"Would you like to pay 200 points or 10% of your total score?", //24
			"200", //25
			"10%", //26
			"The tax is higher than your balance. Instead you pay 10% of your score", //27
			"You have have passed Start field and receive ", //28
			"You have gone bankrupt.", //29
			"prison You're only on a visit and can leave any time.", // 30
			"You are in prison, throw equal dice to get out", // 31
			"You're being taken to the jail. ", //32
			"You either have to pay yourself out ", //33
			"or be set free because of good behavior (by rolling two equal dice)", //34
			" is in jail. Do you want to pay 100 points to get out?", //35
			"You don't have enough points to pay bail... wait for your parole", //36
			" .You now have ", //37
			" prison turn left ", //38
			"Pay for carwash and lubrication 15 points", //39
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
