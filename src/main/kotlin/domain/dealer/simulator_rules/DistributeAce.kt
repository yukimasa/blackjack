package domain.dealer.simulator_rules

import domain.card.Card
import domain.dealer.Deck

class DistributeAce : DistributionRules {
    override fun distribute(deck: Deck): Card {
        for (card in deck.cards) {
            if (card.isAce()) {
                return card
            }
        }
        return deck.cards.first()
    }
}
