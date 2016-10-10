package model

/**
  * Handles a MultiArmed Bandit problem.
  *
  * Created by mathieu on 09/10/2016.
  */
class Bandit(armSet: Set[Arm]) {
  // The number of arms in the bandit problem.
  val nbArm: Int = armSet.size

  def getArm(): Set[Arm] = this.armSet
}
