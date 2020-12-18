/**
 * This program is built to perform a simple rock, paper, scissors game.
 * They are 3 players of the game: Player 1, Player 2 (optional), and Computer.
 * If there is no Player 2, Player 1 will be automatically playing with Computer.
 */
fun main() {
    repeat(7) {print("`-_,-'")}
    println("\n  Welcome to Rock, Paper, Scissors Game!")
    println("     Created by Defa Ihsan Ramadhan")
    repeat(7) {print("`-_,-'")}

    /**
     * Condition below will let player to make round game.
     * Game round will be looped as long as player choose to replay.
     */
    do {
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