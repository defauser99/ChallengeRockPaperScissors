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