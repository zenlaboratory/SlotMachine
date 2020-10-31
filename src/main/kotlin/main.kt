//

fun main() {
  
  val mySlotGame = SlotGame()
  
  clearScreen()
  mySlotGame.menu()
  mySlotGame.showPlayerData()
  mySlotGame.actionKey()
  clearScreen()
  
  while ((mySlotGame.actionKey != "X") && (mySlotGame.myPlayer.amount > 0)) {
    
    mySlotGame.slotSpin(3)
    
  }
  
  mySlotGame.saveHallOfFame()
  
  if (mySlotGame.actionKey == "X") {
  
    mySlotGame.exitGame()
  
  } else {
  
    mySlotGame.noCoins()
  
  }
  
}

fun clearScreen() {
  
  // TODO - Clear the console/terminal output
  
}
