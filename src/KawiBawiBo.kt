/**
 * This program is built to perform a simple rock, paper, scissors game.
 * They are 3 players of the game: Player 1, Player 2 (optional), and Computer.
 * If there is no Player 2, Player 1 will be automatically playing with Computer.
 */
fun main() {
    /**
     * Condition below will let player to make round game.
     * Game round will be looped as long as player choose to replay.
     */
    do {
        repeat(7) {print("`-_,-'")}
        println("\n  Welcome to Rock, Paper, Scissors Game!")
        println("     Created by Defa Ihsan Ramadhan")
        repeat(7) {print("`-_,-'")}

        print("\n\nDo you have 2 players? (Y/N): ")
        var playersConfirmation = readLine()?.toUpperCase()?.ifBlank { null }
        if (playersConfirmation != "Y" && playersConfirmation != "N") {
            playersConfirmation = null
        }
        if(playersConfirmation in arrayOf("N",null)) println("Playing with computer....")

        /**
         * Players should fill their names.
         * If name is left empty, it will be 'Guest'.
         */
        print("\nWhat is your name, Player 1? ")
        val player1name = readLine()?.capitalize()?.ifBlank { null } ?: "Guest"
        println("Hello! $player1name")

        if(playersConfirmation == "Y") {
            print("\nWhat is your name, Player 2? ")
            val player2name = readLine()?.capitalize()?.ifBlank { null } ?: "Guest"
            println("Hello! $player2name")

            /**
             * If there are 2 players, each players must select their hand.
             * Hands are represented with numbers from 0 to 2.
             */
            println("")
            val player1 = selectHand(player1name)
            val player2 = selectHand(player2name)

            println("")
            player1.judge(player2)

        } else {
            /**
             * If playing with computer,
             * only Player 1 that must selecting hand.
             * While computer will show its playing hand randomly.
             */
            val player1 = selectHand(player1name)

            println("")
            player1.judge(Computer())
        }

        // Condition below will loop the game
        print("Play again? (Y/N): ")
        val roundGameConfirmations = readLine()?.toUpperCase()?.ifBlank { null }
        if (roundGameConfirmations in arrayOf("N",null)) println("Exit game...")

    } while (roundGameConfirmations == "Y")
}

/**
 * Function below is a placeholder for every game.
 * This function will record every selected hands and
 * return warning if selected hands are unacceptable.
 * If warning returned, players must reselect their hand.
 */
fun selectHand(playerName: String): Player {

    print("$playerName, select number (0 Rock, 1 Paper, 2 Scissors): ")
    val player = Player(playerName, readLine()?.toIntOrNull() ?: -1)

    while (!player.validate()) {
        print("Unacceptable hand!, select number (0 Rock, 1 Paper, 2 Scissors): ")
        player.hand = readLine()?.toIntOrNull() ?: -1
    }

    return player
}

/**
 * Function below is the judge of every game.
 * This function will return the result of the game.
 * The result can be: A draw, A player 1 win, A player 2 win, or A computer win.
 */
fun Player.judge(player2: Player) {
    println(this.printHand())
    println(player2.printHand())
    if (this.hand == player2.hand) { println("Draw Game") }
    else {
        when(this.hand) {
            0 -> if (player2.hand == 1) println("${player2.name} Win!") else println("${this.name} Win!")
            1 -> if (player2.hand == 2) println("${player2.name} Win!") else println("${this.name} Win!")
            2 -> if (player2.hand == 0) println("${player2.name} Win!") else println("${this.name} Win!")
        }
    }
}

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

/**
 * Even computer inherits properties and methods from Player Class,
 * but their playing hand will be selected randomly.
 */
class Computer : Player("Computer", (0..2).random())