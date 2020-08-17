package domain.player

import domain.card.Card

class Player {
    var hand = Hand()
    var canAction = true

    fun addCardToHand(card: Card) {
        hand.addCard(card)
    }

    fun totalNumberOfHands(): Int {
        return hand.totalNumber()
    }

    fun action(card: Card) {
        if (hand.totalNumber() < 16) {
            hit(card)
        } else {
            stay()
        }
    }

    private fun hit(card: Card) {
        addCardToHand(card)
    }

    private fun stay() {
        canAction = false
    }
}