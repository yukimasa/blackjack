package application

import domain.GameResult
import domain.dealer.Dealer
import domain.dealer.simulator_rules.DistributeAce
import domain.player.Player

class BlackJack {
    fun startGame(): GameResult {
        // ディーラーとプレイヤーを準備
        val dealer = Dealer()
        val player1 = Player()
        val player2 = Player()
        val distributeAce = DistributeAce()

        // ディーラーがデッキをシャッフル
        dealer.shuffle()

        // ディーラーがプレイヤーにカードを配る
        player1.addCardToHand(dealer.distributeOneCard(distributeAce))
        player1.addCardToHand(dealer.distributeOneCard())
        player2.addCardToHand(dealer.distributeOneCard())
        player2.addCardToHand(dealer.distributeOneCard())

        // プレイヤーのアクション
        while (player1.canAction) {
            player1.action(dealer.distributeOneCard())
        }

        while (player2.canAction) {
            player2.action(dealer.distributeOneCard())
        }

        // 手札の比較
        return compare(player1, player2)
    }

    private fun compare(player1: Player, player2: Player): GameResult {
        return when {
            player1.totalNumberOfHands() > player2.totalNumberOfHands() -> {
                GameResult(isWin = true)
            }
            player1.totalNumberOfHands() == player2.totalNumberOfHands() -> {
                GameResult(isDraw = true)
            }
            else -> {
                GameResult(isLose = true)
            }
        }
    }
}