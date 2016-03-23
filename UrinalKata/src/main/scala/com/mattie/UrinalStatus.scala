package com.mattie

sealed trait UrinalStatus { def value: String }

final case object Available extends UrinalStatus  {
  val value = "Available"
}

final case object Occupied extends UrinalStatus  {
  val value = "Occupied"

}