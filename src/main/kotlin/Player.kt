//

data class Player(val name: String, var amount: Int, var prize: Int, var level: PlayerLevel) {
  
  enum class PlayerLevel {
    
    PLATINUM,
    GOLD,
    SILVER,
    BRONZE,
    NOOB
    
  }
  
}