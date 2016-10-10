package model

import scala.util.Random

/**
  * Created by mathieu on 10/10/2016.
  */
class BernoulliArm(p: Double, name: String) extends Arm{

  def getName(): String = this.name

  require(this.p > 0 && this.p < 1, "The parameter p must lies between 0 and 1.")

  override def draw(): Int = {
    if (Random.nextFloat() > this.p) 0
    else 1
  }
}
