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
