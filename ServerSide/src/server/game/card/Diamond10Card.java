/**
 * 
 */
package server.game.card;

/**
 * @author Fatih
 * 
 */
class Diamond10Card extends Card {

	/**
	 * @param gifPath
	 * @param number
	 * @param point
	 */
	public Diamond10Card(String gifPath, CARD_TYPE type, CARD_NUMBER number) {
		super(gifPath, type, number, 0);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see client.card.Card#compareTo(client.card.Card)
	 */
	@Override
	public PISHTI_STATE compareTo(Card card) {

		if (this.equals(card))
			return PISHTI_STATE.DIAMOND10_PISHTI;

		return PISHTI_STATE.NO_PISHTI;
	}

}
