package com.dj

class Bathroom {
  var urinals: List[Urinal] = List[Urinal]()

  def this(numberOfUrinals: Int) = {
    this()

    val _isSingle = isSingleStallFacility(numberOfUrinals)

    if (_isSingle) {
      urinals = List(createFirstUrinal)
    } else {
      urinals = createMultiUrinalFacility(numberOfUrinals)
    }

    def _isInMiddle(p: Int): Boolean = { p > 1 && p < numberOfUrinals }

    def linkUrinal(u: Urinal): Urinal = {
      if (u.position == 1) return linkFirst()
      if (_isInMiddle(u.position)) return linkMiddle(u.position)
      linkLast(u.position)
    }

    val linked: Urinal => Urinal = (t) => linkUrinal(t)

    urinals.map(linked)
  }

  def numberOfUrinals: Int = {
    this.urinals.size
  }

  def createFirstUrinal: Urinal = {
    new Urinal(1)
  }

  def createMultiUrinalFacility(num: Int): List[Urinal] = {
    val positions = List.range(1, num + 1)

    def createBaseUrinal(p: Int): Urinal = {
      createUrinal(p)
    }

    val base: Int => Urinal = (t) => createBaseUrinal(t)

    positions.map(base)
  }

  def isSingleStallFacility(numberOfUrinals: Int): Boolean = {
    1 == numberOfUrinals
  }

  def createUrinal(position: Int): Urinal = {
    new Urinal(position)
  }

  def linkFirst(): Urinal = {
    val u = getUrinalByPosition(1) match {
      case Some(u) => u
      case None => new Urinal(1)
    }
    u.rightNeighbor = getUrinalByPosition(2)
    u
  }

  def getUrinalByPosition(p: Int): Option[Urinal] = {
    urinals.filter(_.position == p).headOption
  }


  def linkMiddle(p: Int): Urinal = {
    val u = getUrinalByPosition(p) match {
      case Some(u) => u
      case None => new Urinal(p)
    }

    u.leftNeighbor = getUrinalByPosition(p - 1)
    u.rightNeighbor = getUrinalByPosition(p + 1)
    u
  }

  def linkLast(p: Int): Urinal = {
    val u = getUrinalByPosition(p) match {
      case Some(u) => u
      case None => new Urinal(p)
    }

    u.leftNeighbor = getUrinalByPosition(p - 1)
    u
  }

  def getLeftNeighbor(urinal: Urinal): Option[Urinal] = {
    urinal.leftNeighbor
  }

  def nextAvailable: Option[Urinal] = {

    if (urinals.isEmpty) return None

    if (urinalExistsWithoutNeighbor) { getUrinalWithNoNeighbor } else { getUrinalWithNeighbor }
  }

  private def getUrinalWithNeighbor = {
    urinals.filter(_.status == Available).lastOption
  }

  private def getUrinalWithNoNeighbor = {
    urinals.filter(_.isAvailable).lastOption
  }

  private def urinalExistsWithoutNeighbor = {
    getUrinalWithNoNeighbor.isDefined
  }
}
