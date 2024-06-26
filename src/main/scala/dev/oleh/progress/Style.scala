package dev.oleh.progress

object Style:

  def random(): String =
    All(util.Random.nextInt(All.size))

  def makePseudoRandomGenerator(): InfiniteNext[String] =
    InfiniteNext(All)

  final lazy val All: NonEmptyIndexSeq[String] =
    import Console.*
    NonEmptyIndexSeq.unsafe(
      IndexedSeq(BLACK, BLUE, CYAN, GREEN, MAGENTA, RED, WHITE, YELLOW)
    )
end Style
