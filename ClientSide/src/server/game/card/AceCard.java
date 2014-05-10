package server.game.card;

public class AceCard extends Card {

	public AceCard(String gifPath, CARD_TYPE type, CARD_NUMBER number) {
		super(gifPath, type, number, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PISHTI_STATE compareTo(Card card) {

		if (this.equals(card))
			return PISHTI_STATE.ACE_PISHTI;

		return PISHTI_STATE.NO_PISHTI;
	}

}
