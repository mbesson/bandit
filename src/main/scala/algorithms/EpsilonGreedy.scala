package algorithms

import model.Bandit

import scala.util.Random

/**
  * Handles the greedy algorithm to solve
  * multiarmed bandit problem.
  *
  * Created by mathieu on 09/10/2016.
  */
class EpsilonGreedy(bandit: Bandit, epsilon: Double) {
  var counts: Vector[Int] = Vector.fill(bandit.nbArm)(0)
  var values: Vector[Double] = Vector.fill(bandit.nbArm)(0.0)

  def ind_max(x: Vector[Double]): Int = x.indexOf(x.max)

  def select_arm (): Int = {
    if (Random.nextDouble() > this.epsilon) ind_max(this.values)
    else Random.nextInt(this.values.size)
  }

  def update (chosen_arm: Int, reward: Double): Unit = {
    this.counts(chosen_arm) += 1
    val n = this.counts(chosen_arm)

    val value = this.values(chosen_arm)
    val new_value = ((n - 1) / n.toFloat) * value + (1 / n.toFloat) * reward
  }
}
