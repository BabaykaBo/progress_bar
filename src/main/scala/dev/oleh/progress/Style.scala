package dev.oleh.progress

object Style:

  def random(): String =
    All(util.Random.nextInt(All.size))

  final lazy val All: IndexedSeq[String] =
    import Console.*
    IndexedSeq(BLACK, BLUE, CYAN, GREEN, MAGENTA, RED, WHITE, YELLOW)
