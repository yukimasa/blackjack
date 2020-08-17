package application

import domain.GameResult

class BlackJackSimulator {
    fun simulate(): GameResult {
        val blackJack = BlackJack()
        return blackJack.startGame()
    }
}