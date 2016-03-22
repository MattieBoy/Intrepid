package com.dj

class Bathroom {
  var urinals: List[Urinal] = List[Urinal]()

  def this(numberOfUrinals: Int) = {
    this()

    val _isSingle = isSingleStallFacility(numberOfUrinals)
    if (_isSingle) {
      var list = new scala.collection.mutable.ListBuffer[Urinal]()
      list += createSingleUrinal
      urinals = list.toList
    } else {
      urinals = createMultiUrinalFacility(numberOfUrinals)
    }

    def _isMiddle(p: Int): Boolean = { p > 1 && p < numberOfUrinals }

    def linkUrinal(p: Urinal): Urinal = {
      if (p.position == 1) return linkFirstUrinal()
      if (_isMiddle(p.position)) return linkMiddleUrinal(p.position)
      linkRightUrinal(p.position)
    }
    val linked: Urinal => Urinal = (t) => linkUrinal(t)
    urinals.map(linked)
    println("urinals = " + urinals)
  }

  def getUrinalOptionByPosition(i: Int): Option[Urinal] = {
    urinals.filter(_.position == i).headOption
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

  def linkFirstUrinal(): Urinal = {
    val u = getUrinalOptionByPosition(1) match {
      case Some(u) => u
      case None => new Urinal(1)
    }
    u.rightNeighbor = getUrinalOptionByPosition(2)
    u
  }

  def linkMiddleUrinal(p: Int): Urinal = {
    val u = getUrinalOptionByPosition(p) match {
      case Some(u) => u
      case None => new Urinal(p)
    }

    u.leftNeighbor = getUrinalOptionByPosition(p - 1)
    u.rightNeighbor = getUrinalOptionByPosition(p + 1)
    u
  }

  def linkRightUrinal(p: Int): Urinal = {
    val u = getUrinalOptionByPosition(p) match {
      case Some(u) => u
      case None => new Urinal(p)
    }

    u.leftNeighbor = getUrinalOptionByPosition(p - 1)
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
