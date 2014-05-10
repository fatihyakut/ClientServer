package server.game.card;

import server.constant.Constants;

public abstract class Card {

	private int point;
	private CARD_NUMBER number;
	private CARD_TYPE type;
	private String gifPath;

	public static enum PISHTI_STATE {
		NO_PISHTI, NORMAL_PISHTI, CLUB2_PISHTI, DIAMOND10_PISHTI, ACE_PISHTI, JACK_PISHTI
	}

	public static enum CARD_TYPE {
		SNAKE('s'), DIAMOND('d'), HEART('h'), CLUB('c');

		private char symbol;

		private CARD_TYPE(char symbol) {
			this.symbol = symbol;
		}

		public char getSymbol() {
			return symbol;
		}
	}

	public static enum CARD_NUMBER {
		N2("2", 2), N3("3", 3), N4("4", 4), N5("5", 5), N6("6", 6), N7("7", 7), N8(
				"8", 8), N9("9", 9), N10("10", 10), NJ("J", 11), NQ("Q", 12), NK(
				"K", 13), NA("A", 14);

		private int number;
		private String symbol;

		private CARD_NUMBER(String symbol, int number) {
			this.number = number;
			this.symbol = symbol;
		}

		public int getNumber() {
			return number;
		}

		public String getSymbol() {
			return symbol;
		}

		public int toInt() {
			return number;
		}
	}

	public Card(String gifPath, CARD_TYPE type, CARD_NUMBER number, int point) {
		this.point = point;
		this.number = number;
		this.gifPath = gifPath;
		this.type = type;
	}

	public static Card create(CARD_TYPE type, CARD_NUMBER number) {
		Card c = null;
		StringBuilder gifPath = new StringBuilder();
		gifPath.append(Constants.gifPath);

		gifPath.append(getGifName(type, number));

		switch (type) {
		case DIAMOND:

			if (number == CARD_NUMBER.N10) {
				c = new Diamond10Card(gifPath.toString(), type, number);
				return c;
			}
			break;
		case CLUB:
			if (number == CARD_NUMBER.N2) {
				c = new Club2Card(gifPath.toString(), type, number);
				return c;
			}
			break;
		default:
			break;
		}

		switch (number) {
		case NJ:
			c = new JackCard(gifPath.toString(), type, number);
			return c;
		case NA:
			c = new AceCard(gifPath.toString(), type, number);
			return c;
		default:
			break;
		}

		c = new GeneralCard(gifPath.toString(), type, number);
		return c;
	}

	public CARD_TYPE getType() {
		return type;
	}

	private static String getGifName(CARD_TYPE type, CARD_NUMBER number) {
		if (type != null && number != null)
			return type.getSymbol() + number.toInt() + ".gif";
		return null;
	}

	public int getPoint() {
		return point;
	}

	public int getNumber() {

		return this.number.toInt();
	}

	public String getGifPath() {
		return gifPath;
	}

	public abstract PISHTI_STATE compareTo(Card card);

	@Override
	public boolean equals(Object card) {
		if (card == null || !(card instanceof Card))
			return false;

		if (this.getNumber() == ((Card) card).getNumber())
			return true;

		return false;
	}

	@Override
	public String toString() {
		return this.type.getSymbol() + " " + this.number.getSymbol() + " CARD";
	}
}
