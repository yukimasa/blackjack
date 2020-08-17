package domain.dealer

import domain.card.Card
import domain.card.Rank
import domain.card.Suit

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