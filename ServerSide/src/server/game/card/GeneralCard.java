package server.game.card;

class GeneralCard extends Card {

	public GeneralCard(String gifPath, CARD_TYPE type, CARD_NUMBER number) {
		super(gifPath, type, number, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PISHTI_STATE compareTo(Card card) {

		if (this.equals(card))
			return PISHTI_STATE.NORMAL_PISHTI;

		return PISHTI_STATE.NO_PISHTI;
	}

}
