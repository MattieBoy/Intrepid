package com.EverCraft

/**
 * Created by matthewrighter on 3/25/16.
 */
trait Alignment { def value: String}

final case object Good extends Alignment {
  val value = "Good"
}
final case object Neutral extends Alignment {
  val value = "Neutral"
}
final case object Evil extends Alignment {
  val value = "Evil"
}
