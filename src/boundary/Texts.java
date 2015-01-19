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
		"fængsel du er kun på besøg og kan forlade når som helst.", //30
		"Du er i fængsel kast lige tergninger for at komme ud.", //31
		"Du er blevet fængslet.", //32
		" du kan endten betale dig ud", //33
		" eller blive sat fri på grund af god opførsel (ved at rulle to ens terninger).", //34
		" er i fængsel. Vil du betale 100 point for at komme ud?", //35
		"Du har ikke nok point til at betale kaution ... vent på din løsladelse.", //36
		" Du har nu ", //37
		" fængsels tur tilbage.",//38
		//ChanceCardsSubtract
		"Betal for vognvask og smøring kr. 15,00.", //39
		"De har kørt frem for \"Fuld stop\". Betal 150 point.", //40
		"Betal 125 point for 2 kasser øl", //41
		"Du har købt et nyt dæk til din bil. Betal 120 point.", //42
		"De har måtte vedtage en parkeringsbøde. Betal 60 point til banken.", //43
		"De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal told 50 point", //44
		//ChanceCardsAdd
		"De har lagt penge ud til sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 25 point.", //45
		"Værdien af egen avl fra nyttehaven udgør 200 point, som De modtager af banken.", //46
		"Kommunen har eftergivet et kvartals skat, hæv i banken til en glad aften kr. 200,00.", //47
		"De har solgt deres gamle klude. Modtag kr. 20,00.", //48
		"Modtag udbytte af Deres aktier, kr. 50,00.", //49
		"De har rettidigt aflevert Deres abonnementskort, Depositum kr. 5,00 udbetales Dem af banken.", //50
		"Grundet på dyrtiden har De fået gageforhøjelse. Modtag kr.50,00.", //51
		"Manufakturvarerne er blevet billigere og bedre, herved sparer De kr. 100,00 som De modtager af banken.", //52
		"Efter auktionen på Assistentshuset, hvor De havde pasntsat Deres tøj, modtager De ekstra kr. 108,00.", //53
		"Deres præmieobligation er kommet ud. De modtager kr. 100,00 af banken.", //54
		"Betal 100 point.",//55
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
			"jail. You're only on a visit and can leave any time.", // 30
			"You are in jail, throw equal dice to get out.", // 31
			"You're being taken to the jail. ", //32
			"You either have to pay yourself out ", //33
			"or be set free because of good behavior (by rolling two equal dice).", //34
			" is in jail. Do you want to pay 100 points to get out?", //35
			"You don't have enough points to pay bail... wait for your parole", //36
			" .You now have ", //37
			" jail turn left ", //38
			//ChanceCardsSubtract
			"Pay for carwash and lubrication 15 points", //39
			"You have driven through a \"full stop\". Pay 150 points .", //40
			"Pay 125 points for receiving two boxes of beer", //41
			"You have purchased a new tire for your vehicle. Pay 120 points.", //42
			"You have to pay a parking ticket. Pay 60 points to the bank.", //43
			"You have been a trip abroad and purchased too many cigarettes. Pay customs 50 points.", //44
			//ChanceCardsAdd
			"You have put money out for potluck. Curiously pay all immediately. Receive from each player 25 points.", //45
			"The value of home-grown from utility garden is 200 points, as the recipient of the bank.", //46
			"The municipality has waived a quarterly tax raise in the bank for a happy evening 200.00 point.", //47
			"You have sold your old rags. Receive 20.00 point.", //48
			"Receive yield of your shares, 50.00 points.", //49
			"You have timely handed your subscription card Deposit 5.00 point paid to you by the bank.", //50
			"Due to the high cost of living have you received salary increase. Receive 50,00 point.", //51
			"Manufakturvarerne has become cheaper and better, it saves the kr. 100.00 as the recipient of the bank.", //52
			"After the auction the Assistant house where they had pasntsat your clothes, you will receive extra kr. 108,00.", //53
			"Your premium bond has come out. You receive  100.00 points of the bank.", //54
			"Pay 100 points.",//55
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
	
	public void setLanguage(String language) {
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
