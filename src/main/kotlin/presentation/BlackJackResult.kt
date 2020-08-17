package presentation

import application.BlackJackSimulator

class BlackJackResult {
    fun blackJackSimulate() {
        val blackJackSimulator = BlackJackSimulator()
        val gameCount = 10000
        var win = 0
        var lose = 0
        var draw = 0

        repeat(gameCount) {
            val result = blackJackSimulator.simulate()
            when {
                result.isWin -> {
                    win++
                }
                result.isLose -> {
                    lose++
                }
                result.isDraw -> {
                    draw++
                }
            }
        }

        println("$gameCount 回ゲームをした結果")
        println("勝敗は $win 勝 $lose 敗 $draw 引き分けです")
    }
}