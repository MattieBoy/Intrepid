package com.dj

class Bathroom {
  var urinals: List[Urinal] = List[Urinal]()

  def this(numberOfUrinals: Int) = {
    this()

    val _isSingle = isSingleStallFacility(numberOfUrinals)

    if (_isSingle) {
      urinals = List(createSingleUrinal)
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

  def getOptionalUrinalByPosition(p: Int): Option[Urinal] = {
    urinals.filter(_.position == p).headOption
  }

  def numberOfUrinals: Int = {
    this.urinals.length
  }

  def createSingleUrinal: Urinal = {
    new Urinal(1)
  }

  def createMultiUrinalFacility(numberOfUrinals: Int): List[Urinal] = {
    val positions = List.range(1, numberOfUrinals + 1)

    def createBaseUrinal(p: Int): Urinal = {
      createUrinal(p)
    }
    val base: Int => Urinal = (t) => createBaseUrinal(t)

    positions.map(base)
  }

  def isSingleStallFacility(numberOfUrinals: Int): Boolean = {
    1 == numberOfUrinals
  }

  def createUrinal(p: Int): Urinal = {
    new Urinal(p)
  }

  def linkFirst(): Urinal = {
    val u = getOptionalUrinalByPosition(1) match {
      case Some(u) => u
      case None => new Urinal(1)
    }
    u.rightNeighbor = getOptionalUrinalByPosition(2)
    u
  }

  def linkMiddle(p: Int): Urinal = {
    val u = getOptionalUrinalByPosition(p) match {
      case Some(u) => u
      case None => new Urinal(p)
    }

    u.leftNeighbor = getOptionalUrinalByPosition(p - 1)
    u.rightNeighbor = getOptionalUrinalByPosition(p + 1)
    u
  }

  def linkLast(p: Int): Urinal = {
    val u = getOptionalUrinalByPosition(p) match {
      case Some(u) => u
      case None => new Urinal(p)
    }

    u.leftNeighbor = getOptionalUrinalByPosition(p - 1)
    u
  }

  def getLeftNeighbor(urinal: Urinal): Option[Urinal] = {
    urinal.leftNeighbor
  }

  def nextAvailable: Option[Urinal] = {

    if (urinals.isEmpty) return None

    if (urinalExistsWithoutNeighbor) {
      getUrinalWithNoNeighbor
    } else {
      getUrinalWithNeighbor
    }
  }

  private def getUrinalWithNeighbor = {
    val a = urinals.filter(_.status == Available)
    a.lastOption
  }

  private def getUrinalWithNoNeighbor = {
    val a = urinals.filter(_.isAvailable)
    a.lastOption
  }

  private def urinalExistsWithoutNeighbor = {
    getUrinalWithNoNeighbor.isDefined
  }
}
