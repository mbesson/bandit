package algorithms

import model.Bandit

/**
  * Handles the greedy algorithm to solve
  * multiarmed bandit problem.
  *
  * Created by mathieu on 09/10/2016.
  */
class EpsilonGreedy(bandit: Bandit, epsilon: Float) {
  var counts: Vector[Int] = Vector.fill(bandit.nbArm)(0)
  var values: Vector[Double] = Vector.fill(bandit.nbArm)(0.0)
}
