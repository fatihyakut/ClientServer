package server.game.card;

import server.game.card.Card.CARD_NUMBER;

public class CardDeckFactory {

	public static CardDeck create() {
		CardDeck cd = new CardDeck();

		for (Card.CARD_TYPE t : Card.CARD_TYPE.values())
			for (Card.CARD_NUMBER n : CARD_NUMBER.values())
				cd.add(Card.create(t, n));

		return cd;
	}
}
