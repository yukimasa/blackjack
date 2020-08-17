package domain.player

import domain.card.Card

class Hand {
    var cards = mutableSetOf<Card>()

    fun addCard(card: Card) {
        cards.add(card)
    }

    fun totalNumber(): Int {
        var totalNumber = 0
        for (card in cards) {
            totalNumber += card.number()
        }

        return totalNumber
    }
}