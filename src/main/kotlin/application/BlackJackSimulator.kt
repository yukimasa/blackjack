package application

import domain.blackjack.GameResult

class BlackJackSimulator {
    fun simulate(): GameResult {
        val blackJack = BlackJack()
        return blackJack.startGame()
    }
}
