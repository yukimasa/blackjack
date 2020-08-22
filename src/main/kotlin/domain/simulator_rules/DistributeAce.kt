package domain.simulator_rules

import domain.blackjack.card.Card
import domain.blackjack.dealer.Deck

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
