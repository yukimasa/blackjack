package domain.card

class Card(val rank: Rank, val suit: Suit) {
    fun number(): Int {
        return when {
            isAce() -> {
                1
            }
            isFaceCard() -> {
                10
            }
            else -> {
                rank.number
            }
        }
    }

    fun isAce(): Boolean {
        return rank.number == Rank.ACE.number
    }

    private fun isFaceCard(): Boolean {
        return rank.number == Rank.JACK.number || rank.number == Rank.QUEEN.number || rank.number == Rank.KING.number
    }
}
