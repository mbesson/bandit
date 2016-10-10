import algorithms.EpsilonGreedy
import model.{Arm, Bandit}

/**
  * Main class of the project.
  *
  * Created by mathieu on 09/10/2016.
  */
object main extends App{
  println("Multiarmed Bandit Problem")

  val arm1: Arm = new Arm("1")
  val arm2: Arm = new Arm("2")
  val arm3: Arm = new Arm("3")

  val bandit: Bandit = new Bandit(Set(arm1, arm2, arm3))
  val espGreedy = new EpsilonGreedy(bandit, 0.001)

  for(elem <- espGreedy.counts) println(elem)
}
