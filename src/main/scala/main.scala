import algorithms.EpsilonGreedy
import model.{Arm, Bandit, BernoulliArm}

/**
  * Main class of the project.
  *
  * Created by mathieu on 09/10/2016.
  */
object main extends App{
  println("Multiarmed Bandit Problem")

  val arm1: BernoulliArm = new BernoulliArm(0.1, "1")
  val arm2: BernoulliArm = new BernoulliArm(0.1, "2")
  val arm3: BernoulliArm = new BernoulliArm(0.9, "3")

  val bandit: Bandit = new Bandit(Set(arm1, arm2, arm3))
  val espGreedy = new EpsilonGreedy(bandit, 0.001)

  espGreedy.printCounts()

  for (arm <- bandit.getArm()) println(arm.draw())

}
