package com.ruse.world.content;

import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.util.Random;

public class TriviaSystem {

	enum TriviaData {
		QUESTION_1("What is 10000 x 1", "10000"),
		QUESTION_2("What is the main currency on Levincia", "Levincia tokens"),
		QUESTION_3("Re-arrange these letters to make a npc.  'stvaneneR'", "Revenants"),
		QUESTION_4("Re-arrange these letters to make a city.  'rorckVa'", "Varrock"),
		QUESTION_5("Who can you reclaim a lost pet from", "Zookeeper"),
		QUESTION_6("What is the name of the final boss in Legends Raids", "Veigar"),
		QUESTION_7("How much do you have to donate to use the command ::bank", "$50"),
		QUESTION_8("How long does well of goodwill last", "2 hours"),
		QUESTION_9("What is the lightest chemical element", "Hydrogen"),
		QUESTION_10("Which planet is nearest the sun", "Mercury"),
		QUESTION_11("Which band had a number 1 hit with 'Barbie Girl'", "Aqua"),
		QUESTION_12("Which dinosaur was larger than the tyrannosaurus", "Spinosaurus"),
		QUESTION_13("The name of which dinosaur means 'triple horned'", "Triceratops"),
		QUESTION_14("How long does the exp bonus skill last", "6 hours"),
		QUESTION_15("What does Shetani staff upgrade to", "Brutal staff"),
		QUESTION_16("What does pernix T2 upgrade to", "Sorrow"),
		QUESTION_17("Unscramble these letters 'nigw steikhleid'", "Wing kiteshield"),
		QUESTION_18("Unscramble these letters 'aevyh niasawch'", "Heavy chainsaw"),
		QUESTION_19("Type this : 'hy3gjkyuhfjfrq01fi'", "hy3gjkyuhfjfrq01fi"),
		QUESTION_20("Type the following : '21042919422'", "21042919422"),
		QUESTION_21("Type the following : 'ximf2mc292m92'", "ximf2mc292m92"),
		QUESTION_22("Type the following : '0k0k02k02kd2d'", "0k0k02k02kd2d"),
		QUESTION_23("Type the following : 'v2img903m'", "v2img903m"),
		QUESTION_24("Type the following : 'omv039f290k'", "omv039f290k"),
		QUESTION_25("Type the following : 'foem30ffo3mfo2'", "foem30ffo3mfo2"),
		QUESTION_26("Type the following : 'zomofo2mf20mf'", "zomofo2mf20mf"),
		QUESTION_27("Type the following : 'pp20d20d2l02'", "pp20d20d2l02"),
		QUESTION_28("Type the following : 'ao10fm30mg02'", "ao10fm30mg02"),
		QUESTION_29("Type the following : 'omv2mf029fm290f2'", "omv2mf029fm290f2"),
		QUESTION_30("What lets you go to a boss by your self? ", "Instance token"),
		QUESTION_31("What is 5 x 5?", "25"),
		QUESTION_32("What is the seventh planet from the sun", "uranus"),
		QUESTION_33("Name the worlds largest ocean", "pacific ocean"),
		QUESTION_34("What is 10000 x 0", "0"),
		QUESTION_35("What altar is used to change your prayer book", "Chaos altar"),
		QUESTION_36("When is double exp active?", "Weekend"),
		QUESTION_37("What defence level is required to wear barrows", "70"),
		QUESTION_38("What is the name of the server", "Levincia"),
		QUESTION_39("Where do you store all of your items", "Bank"),
		QUESTION_40("What points do you get for killing bosses", "Boss points"),
		QUESTION_41("What should I do every day to help the server", "Vote"),
		QUESTION_42("What is the cube root of 216", "6"),
		QUESTION_43("Guess a number 1-10", "1"),
		QUESTION_44("Guess a number 1-10", "2"),
		QUESTION_45("Guess a number 1-10", "3"),
		QUESTION_46("Guess a number 1-10", "4"),
		QUESTION_47("Guess a number 1-10", "5"),
		QUESTION_48("Guess a number 1-10", "6"),
		QUESTION_49("Guess a number 1-10", "7"),
		QUESTION_50("Guess a number 1-10", "8"),
		QUESTION_51("Guess a number 1-10", "9"),
		QUESTION_52("Guess a number 1-10", "10"),
		QUESTION_53("What is the highest donator rank obtained", "zenyte");

		TriviaData(String question, String answer) {
			this.question = question;
			this.answer = answer;
		}

		private String question, answer;

		public String getQuestion() {
			return question;
		}

		public String getAnswer() {
			return answer;
		}
	}

	private static int timer = 1000; // 20minutes
	private static boolean active = false;
	private static TriviaData currentQuestion = null;
	
	public static String getCurrentQuestion() {
		return currentQuestion == null ? "None" : currentQuestion.getQuestion().toUpperCase().substring(0, 1) + currentQuestion.getQuestion().toLowerCase().substring(1);
	}

	public static void tick() {

		if (!active) {
			if (timer < 1) {
				startTrivia();
				timer = 2000;
			} else {
				timer--;
			}
		}
	}

	private static final TriviaData[] TRIVIA_DATA = TriviaData.values();

	private static void startTrivia() {
		setAndAskQuestion();
	}

	private static void setAndAskQuestion() {
		active = true;
		currentQuestion = TRIVIA_DATA[new Random().nextInt(TRIVIA_DATA.length)];
		World.sendMessage("<img=1396>@red@[TRIVIA]<img=1396> @red@" + currentQuestion.getQuestion() + "");
		World.getPlayers().forEach(PlayerPanel::refreshPanel);
	}
	
	public static void answer(Player player, String answer) {
		if(!active) {
			player.sendMessage("@red@There is no trivia going on at the moment");
			return;
		}
		if(answer.equalsIgnoreCase(currentQuestion.getAnswer()) && Misc.getRandom(20) <= 19) {
			player.getInventory().add(6833, 1);
			active = false;
			World.sendMessage("<img=1396>@red@[TRIVIA]<img=1396> @blu@" + player.getUsername() + "@bla@ has received a @red@Goodiebag @bla@from Trivia");
			World.sendMessage("<img=1396>@red@[TRIVIA]<img=1396> @bla@ The answer for the trivia to the question was @red@" + currentQuestion.answer);
			currentQuestion = null;
			World.getPlayers().forEach(PlayerPanel::refreshPanel);
			player.sendMessage("@bla@congrats, you've guessed correctly and received a@blu@ Goodie bag@bla@!");
		}else if (answer.equalsIgnoreCase(currentQuestion.getAnswer())) {
			player.getInventory().add(23401, 1);
			active = false;
			World.sendMessage("<img=1396>@red@[TRIVIA]<img=1396> @blu@" + player.getUsername() + "@bla@ has received a @red@Scroll of Insurance @bla@from Trivia");
			World.sendMessage("<img=1396>@red@[TRIVIA]<img=1396> @bla@ The answer for the trivia to the question was @red@" + currentQuestion.answer);
			currentQuestion = null;
			World.getPlayers().forEach(PlayerPanel::refreshPanel);
			player.sendMessage("@bla@congrats, you've guessed correctly and received a@blu@ Scroll of Insurance@bla@!");
		} else {
			player.sendMessage("@bla@Incorrect answer - your answer was: @red@" + answer);
		}
	}

}
