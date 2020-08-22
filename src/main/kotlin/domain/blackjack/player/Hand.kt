package domain.blackjack.player

import domain.blackjack.card.Card

class Hand {
    companion object {
        const val BLACK_JACK = 21
        const val BUSTED = 99
    }

    var cards = mutableSetOf<Card>()

    fun addCard(card: Card) {
        cards.add(card)
    }

    fun totalNumber(): Int {
        var totalNumber = 0
        for (card in cards) {
            totalNumber += if (card.isAce() && (totalNumber in 5..10)) {
                // Ace判定
                11
            } else {
                card.number()
            }
        }

        return when {
            totalNumber > 21 -> {
                BUSTED
            }
            totalNumber == 21 -> {
                BLACK_JACK
            }
            else -> {
                totalNumber
            }
        }
    }
}
