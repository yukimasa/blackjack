package domain.dealer

import domain.card.Card
import domain.dealer.simulator_rules.DistributionRules

class Dealer {
    var deck = Deck()

    fun shuffle() {
        deck.shuffle()
    }

    fun distributeOneCard(rules: DistributionRules? = null): Card {
        var card = rules?.distribute(deck) ?: deck.cards.first()
        deck.cards.remove(card)
        return card
    }
}