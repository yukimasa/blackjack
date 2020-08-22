package application

import domain.blackjack.GameResult
import domain.blackjack.Action
import domain.blackjack.dealer.Dealer
import domain.simulator_rules.DistributeAce
import domain.blackjack.player.Player

class BlackJack {
    // ディーラーとプレイヤーを準備
    private val dealer = Dealer()
    private val player1 = Player()
    private val player2 = Player()
    private val distributeAce = DistributeAce()

    fun startGame(): GameResult {
        // ディーラーがデッキをシャッフル
        dealer.shuffle()

        // ディーラーがプレイヤーにカードを配る
        handOutCards()

        // プレイヤーのアクション
        playersAction()

        // 手札の比較
        return compare()
    }

    private fun handOutCards() {
        player1.addCardToHand(dealer.distributeOneCard(distributeAce))
        player1.addCardToHand(dealer.distributeOneCard())
        player2.addCardToHand(dealer.distributeOneCard())
        player2.addCardToHand(dealer.distributeOneCard())
    }

    private fun playersAction() {
        val players = listOf(player1, player2)

        for (player in players) {
            while (!player.isBusted) {
                if (player.action() == Action.HIT) {
                    player.addCardToHand(dealer.distributeOneCard())
                } else if (player.action() == Action.STAY) {
                    break
                } else {
                    break
                }
            }
        }
    }

    private fun compare(): GameResult {
        return if (!player1.isBusted && player2.isBusted) {
            GameResult(isWin = true)
        } else if(player1.isBusted && !player2.isBusted) {
            GameResult(isLose = true)
        } else if (player1.isBusted && player2.isBusted) {
            GameResult(isDraw = true)
        } else {
            when {
                (player1.totalNumberOfHands() > player2.totalNumberOfHands()) -> {
                    GameResult(isWin = true)
                }
                (player1.totalNumberOfHands() == player2.totalNumberOfHands()) -> {
                    GameResult(isDraw = true)
                }
                else -> {
                    GameResult(isLose = true)
                }
            }
        }
    }
}
