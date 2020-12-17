/**
 * Class below is a blueprint for every players in the game.
 * Every players must have name and their VALID playing hand.
 */
open class Player(val name: String?, var hand: Int) {

    fun printHand(): String {
        val hands = arrayOf("Rock", "Paper", "Scissors")
        return "$name picked ${hands[hand]}"
    }

    fun validate(): Boolean {
        return !(hand < 0 || hand > 2)
    }
}