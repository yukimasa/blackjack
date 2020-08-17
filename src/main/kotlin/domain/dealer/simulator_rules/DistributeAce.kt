package domain.dealer.simulator_rules

import domain.card.Card
import domain.card.Rank
import domain.dealer.Deck

class DistributeAce : DistributionRules {
    override fun distribute(deck: Deck): Card {
        for (card in deck.cards) {
            if (card.rank.name == Rank.ACE.toString()) {
                return card
            }
        }
        return deck.cards.first()
    }
}