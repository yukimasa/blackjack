package domain.simulator_rules

import domain.blackjack.card.Card
import domain.blackjack.dealer.Deck

interface DistributionRules {
    fun distribute(deck: Deck): Card
}
