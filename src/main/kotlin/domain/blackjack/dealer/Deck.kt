package domain.blackjack.dealer

import domain.blackjack.card.Card
import domain.blackjack.card.Rank
import domain.blackjack.card.Suit

class Deck {
    var cards = mutableSetOf<Card>()

    init {
        for (rank in Rank.values()) {
            for (suit in Suit.values()) {
                cards.add(Card(rank, suit))
            }
        }
    }

    fun shuffle() {
        cards = cards.shuffled().toMutableSet()
    }
}
