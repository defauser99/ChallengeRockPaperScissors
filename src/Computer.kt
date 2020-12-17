/**
 * Even computer inherits properties and methods from Player Class,
 * but their playing hand will be selected randomly.
 */
class Computer : Player("Computer", (0..2).random())