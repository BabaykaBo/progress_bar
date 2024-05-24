package dev.oleh.progress

final case class NonEmptyIndexSeq[+A] private (self: IndexedSeq[A]):
  export self.*

object NonEmptyIndexSeq:
  def apply[A](self: IndexedSeq[A]): Option[NonEmptyIndexSeq[A]] =
    Option.when(self.nonEmpty)(new NonEmptyIndexSeq(self))

  def unsafe[A](self: IndexedSeq[A]): NonEmptyIndexSeq[A] =
    apply(self).getOrElse(
      throw IllegalArgumentException("Expected IndexedSeq to be non-empty!")
    )
