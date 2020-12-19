/**
 * This interface is used by Players only.
 * This interface includes functions to
 * print and validate Player's hand(s).
 */
interface RulePlayer {
    fun printHand(): String
    fun validate(): Boolean
}