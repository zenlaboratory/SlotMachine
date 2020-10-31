//

fun main() {
  
  val mySlotGame = SlotGame()
  
  mySlotGame.menu()
  mySlotGame.showPlayerData()
  mySlotGame.actionKey()
  
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