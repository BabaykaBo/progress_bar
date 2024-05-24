package dev.oleh.progress

object ProgressCircleSegment:
  def make(): InfiniteNext[Char] =
    InfiniteNext(AllSegmentsInOrder)

  lazy val AllSegmentsInOrder: NonEmptyIndexSeq[Char] =
    NonEmptyIndexSeq.unsafe(
      IndexedSeq('\uee06', '\uee07', '\uee08', '\uee09', '\uee0A', '\uee0B')
    )
