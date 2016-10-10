import algorithms.EpsilonGreedy
import model.{Arm, Bandit}

/**
  * Main class of the project.
  *
  * Created by mathieu on 09/10/2016.
  */
object main extends App{
  println("Multiarmed Bandit Problem")

  val arm: Arm = new Arm("toto")

  val bandit: Bandit = new Bandit(List(arm))
  val espGreedy = new EpsilonGreedy(bandit, 0.001)

  for(elem <- espGreedy.counts) println(elem)
}
