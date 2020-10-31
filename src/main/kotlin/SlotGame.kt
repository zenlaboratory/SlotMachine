//

import java.io.File

class SlotGame {
  
  var actionKey: String = ""
  lateinit var myPlayer: Player
  private var spinData = ""
  private var hallOfHonor = File("hall_of_honor.csv")
  
  private val slotValues = mapOf(
    
      1 to "\uE1B3",
      2 to "\uE1B4",
      3 to "\uE1B5")
  
  private val slotPrizes = mapOf(
    
      "\uE1B3\uE1B3\uE1B3" to 20,
      "\uE1B4\uE1B4\uE1B4" to 50,
      "\uE1B5\uE1B5\uE1B5" to 100)
  
  fun menu() {
    
    val playerName: String
    val amountCoins: Int?
    val playerLevel = Player.PlayerLevel.NOOB
    val prize = 0
    
    println("### WELCOME TO SLOT MACHINE ###")
    println()
    print("Enter the player name: ")
    playerName = readLine()!!
    print("Enter the amount of coins: ")
    amountCoins = readLine()?.toIntOrNull() ?: 0
    println()
    println("$playerName, you are a $playerLevel player, " +
        "now you have $amountCoins coins to play SLOT MACHINE")
    println()
    println("GOOD LUCK!!!")
    myPlayer = Player(playerName, amountCoins, prize, playerLevel)
    println()
    
  }
  
  fun showPlayerData() {
    
    println()
    println("** NAME: ${myPlayer.name} ** COINS: ${myPlayer.amount} ** PRIZE: " +
        "${myPlayer.prize} ** LEVEL: ${myPlayer.level} **")
    println()
    
  }
  
  private fun getRandomNumber(): Int {
    
    return (1..3).random()
    
  }
  
  fun slotSpin(times: Int) {
    
    for (spins in 0 until times) {
      
      spinData += slotValues[getRandomNumber()].toString()
      
    }
    
    println()
    spinData.forEach { print(" - $it - ") }
    println()
    checkPrizes()
    checkLevel()
    spinData = ""
    myPlayer.amount--
    showPlayerData()
    actionKey()
    
  }
  
  fun actionKey() {
    
    print("Press Enter key to spin the slots or X to win the prize...")
    actionKey = readLine().toString().toUpperCase()
    
  }
  
  private fun checkPrizes() {
    
    when (spinData) {
  
      in slotPrizes.keys -> myPlayer.prize += slotPrizes.getValue(spinData)
      
    }
    
  }
  
  private fun checkLevel() {
    
    when (myPlayer.prize) {
  
      in 0..200 -> myPlayer.level = Player.PlayerLevel.NOOB
      in 201..400 -> myPlayer.level = Player.PlayerLevel.BRONZE
      in 401..600 -> myPlayer.level = Player.PlayerLevel.SILVER
      in 601..800 -> myPlayer.level = Player.PlayerLevel.GOLD
      in 801..10000 -> myPlayer.level = Player.PlayerLevel.PLATINUM
      
    }
    
  }
  
  fun saveHallOfFame() {
    
    hallOfHonor.createNewFile()
    hallOfHonor.appendText("${myPlayer.name}; ${myPlayer.prize}; ${myPlayer.level}\n")
    
  }
  
  fun exitGame() {
    
    println()
    println("MANY THANKS FOR PLAYING ${myPlayer.name}")
    
  }
  
  fun noCoins() {
    
    println()
    println("SORRY ${myPlayer.name}, YOU DO NOT HAVE ENOUGH COINS TO PLAY")
    
  }
  
  /*fun easterEgg(){
  
  
  
  }*/
  
}