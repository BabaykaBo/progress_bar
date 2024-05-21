package dev.oleh.progress

final class ProgressBar private (factor: Int) extends (Double => String):
  override def apply(percentage: Double): String =
    val p: Int = percentage.toInt

    if p < 10 then `0%`
    else if p < 20 then `10%`
    else if p < 30 then `20%`
    else if p < 40 then `30%`
    else if p < 50 then `40%`
    else if p < 60 then `50%`
    else if p < 70 then `60%`
    else if p < 80 then `70%`
    else if p < 90 then `80%`
    else if p < 100 then `90%`
    else `100%`
    end if
  end apply

  val `0%` : String = s"$le${mf * 0}${me * 8}$re"
  val `10%` : String = s"$lf${mf * 0}${me * 8}$re"
  val `20%` : String = s"$lf${mf * 1}${me * 7}$re"
  val `30%` : String = s"$lf${mf * 2}${me * 6}$re"
  val `40%` : String = s"$lf${mf * 3}${me * 5}$re"
  val `50%` : String = s"$lf${mf * 4}${me * 4}$re"
  val `60%` : String = s"$lf${mf * 5}${me * 3}$re"
  val `70%` : String = s"$lf${mf * 6}${me * 2}$re"
  val `80%` : String = s"$lf${mf * 7}${me * 1}$re"
  val `90%` : String = s"$lf${mf * 8}${me * 0}$re"
  val `100%` : String = s"$lf${mf * 8}${me * 0}$rf"

  private lazy val lf: String = "" + mf.drop(1)
  private lazy val le: String = "" + me.drop(1)

  private lazy val mf: String = "" * f
  private lazy val me: String = "" * f

  private lazy val rf: String = mf.dropRight(1) + ""
  private lazy val re: String = me.dropRight(1) + ""

  private lazy val f: Int = factor.inside(1 to 10)

  extension (self: Int)
    private def inside(range: Range): Int =
      inside(range.start, range.end)

    private def inside(from: Int, to: Int): Int =
      val f: Int = from min to
      val t: Int = from max to

      self max f min t
  end extension
end ProgressBar

object ProgressBar:
  def make(factor: Int = 1): ProgressBar = ProgressBar(factor)
