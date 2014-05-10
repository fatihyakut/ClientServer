package server.game.card;

public class JackCard extends Card {

	public JackCard(String gifPath, CARD_TYPE type, CARD_NUMBER number) {
		super(gifPath, type, number, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PISHTI_STATE compareTo(Card card) {
		// TODO Auto-generated method stub
		if (this.equals(card))
			return PISHTI_STATE.JACK_PISHTI;

		return PISHTI_STATE.NO_PISHTI;
	}
}
