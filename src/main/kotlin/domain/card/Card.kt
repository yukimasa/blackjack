package domain.card

class Card(val rank: Rank, val suit: Suit) {
    fun number(): Int {
        return when {
            rank.number == Rank.ACE.number -> {
                1
            }
            isFaceCard(rank) -> {
                10
            }
            else -> {
                rank.number
            }
        }
    }

    private fun isFaceCard(rank: Rank): Boolean {
        if (
            rank.number == Rank.JACK.number ||
            rank.number == Rank.QUEEN.number ||
            rank.number == Rank.KING.number
        ) {
            return true
        }
        return false
    }
}