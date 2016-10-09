package model

/**
  * Handles a MultiArmed Bandit problem.
  *
  * Created by mathieu on 09/10/2016.
  */
class Bandit(armList: List[Arm]) {
  // The number of arms in the bandit problem.
  val nbArm: Int = armList.size
}
