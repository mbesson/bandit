package algorithms

import model.{Arm, Bandit}

import scala.util.Random

/**
  * Handles the greedy algorithm to solve
  * multiarmed bandit problem.
  *
  * Created by mathieu on 09/10/2016.
  */
class EpsilonGreedy(bandit: Bandit, epsilon: Double) {
  val banditArms: Set[Arm] = bandit.getArm()

  var counts: Map[Arm, Int] = Map[Arm, Int]()
  for(arm <- banditArms) counts + (arm -> 0)

  var values: Map[Arm, Double] = Map[Arm, Double]()
  for(arm <- banditArms) values + (arm -> 0.0)

  def ind_max(x: Map[Arm, Double]): (Arm, Double) = x.max

  def select_arm (): Arm = {
    if (Random.nextDouble() > this.epsilon) ind_max(this.values)._1
    else banditArms.toList(Random.nextInt(banditArms.size))
  }

  def update (chosen_arm: Arm, reward: Double): Unit = {
    this.counts(chosen_arm) += 1
    val n = this.counts(chosen_arm)

    val value = this.values(chosen_arm)
    val new_value = ((n - 1) / n.toFloat) * value + (1 / n.toFloat) * reward
  }
}
