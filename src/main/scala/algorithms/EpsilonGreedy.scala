package algorithms

import model.{Arm, Bandit}

import scala.collection.immutable.HashMap
import scala.util.Random

/**
  * Handles the greedy algorithm to solve
  * multiarmed bandit problem.
  *
  * Created by mathieu on 09/10/2016.
  */
class EpsilonGreedy(bandit: Bandit, epsilon: Double) {
  val banditArms: Set[Arm] = bandit.getArm()

  var counts = (banditArms.toList zip List.fill(banditArms.size)(0)).toMap

  var values = (banditArms.toList zip List.fill(banditArms.size)(0.0)).toMap

  def ind_max(x: Map[Arm, Double]) = x.maxBy(_._2)

  def select_arm (): Arm = {
    if (Random.nextDouble() > this.epsilon) ind_max(this.values)._1
    else banditArms.toList(Random.nextInt(banditArms.size))
  }

  def update (chosen_arm: Arm, reward: Double): Unit = {
    this.counts.updated(chosen_arm, counts(chosen_arm) + 1)
    val n = this.counts(chosen_arm)

    val value = this.values(chosen_arm)
    val new_value = ((n - 1) / n.toFloat) * value + (1 / n.toFloat) * reward
    this.values.updated(chosen_arm, new_value)
  }

  def printValues(): Unit = {
    for ((k,v) <- values) printf("Arm: %s, value: %s\n", k.getNme(), v)
  }

  def printCounts(): Unit = {
    for ((k,v) <- counts) printf("Arm: %s, count: %s\n", k.getNme(), v)
  }
}
