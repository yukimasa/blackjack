package domain.blackjack.player

import domain.blackjack.Action
import domain.blackjack.card.Card
import domain.blackjack.player.Hand.Companion.BUSTED

class Player {
    var hand = Hand()
    var isBusted = false

    fun addCardToHand(card: Card) {
        hand.addCard(card)
    }

    fun totalNumberOfHands(): Int {
        return hand.totalNumber()
    }

    fun action(): Action {
        return when {
            hand.totalNumber() < 16 -> {
                Action.HIT
            }
            hand.totalNumber() == BUSTED -> {
                busted()
                Action.STAY
            }
            else -> {
                Action.STAY
            }
        }
    }

    private fun busted() {
        isBusted = true
    }
}
