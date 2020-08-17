package domain.dealer.simulator_rules

import domain.card.Card
import domain.dealer.Deck

interface DistributionRules {
    fun distribute(deck: Deck): Card
}