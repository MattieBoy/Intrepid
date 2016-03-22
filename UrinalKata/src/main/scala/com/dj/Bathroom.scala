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
  }

  def getUrinalByPosition(i: Int): Option[Urinal] = {
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

    def _isMiddle(p: Int): Boolean = { p > 1 && p < numberOfUrinals }

    def createUrinal(p: Int): Urinal = {
      if (p == 1) return createFirstUrinal()
      if (_isMiddle(p)) return createMiddleUrinal(p)
      createLastUrinal(p)
    }
    val c: Int => Urinal = (t) => createUrinal(t)

    positions.map(c)
  }

  def isSingleStallFacility(numberOfUrinals: Int): Boolean = {
    1 == numberOfUrinals
  }

  def createFirstUrinal(): Urinal = {
    val u = new Urinal(1)
    u.rightNeighbor = Option(new Urinal(2))
    u
  }

  def createMiddleUrinal(p: Int): Urinal = {
    val u = new Urinal(p)
    u.leftNeighbor = getLeftNeighbor(u)
    u.rightNeighbor = Option(new Urinal(p + 1))
    u
  }

  def getLeftNeighbor(urinal: Urinal): Option[Urinal] = {
    urinal.leftNeighbor
  }

  def createLastUrinal(position: Int): Urinal = {
    val u = new Urinal(position)
    u.leftNeighbor = getLeftNeighbor(u)
    u
  }

  def nextAvailable: Option[Urinal] = {

    if (urinals.isEmpty) return None

    if (urinalExistsWithoutNeighbor) {
      getUrinalWithNoNeighbor
    } else {
      getUrinalWithNeighbor
    }
  }

  private val getUrinalWithNeighbor = {
    urinals.filter(_.status == Available).lastOption
  }

  private val getUrinalWithNoNeighbor = {
    urinals.filter(_.isAvailable()).lastOption
  }

  private val urinalExistsWithoutNeighbor = {
    getUrinalWithNoNeighbor.isDefined
  }
}
