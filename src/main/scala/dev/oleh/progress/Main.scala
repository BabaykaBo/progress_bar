package dev.oleh.progress

@main def main(): Unit =
  val generateRandomStyle: () => String =
    Style.makePseudoRandomGenerator()

  def bar(factor: Int): Unit =
    printProgressBar(generateRandomStyle(), factor)

  for factor <- 1 to 5 do bar(factor)
  // for factor <- 4 to 1 by -1 do bar(factor)
end main

def printProgressBar(style: String, factor: Int): Unit =
  val renderProgressBar: ProgressBar = ProgressBar.make(factor)

  for percentage <- 0 to 100 by 10 do
    val progressBar: String = renderProgressBar(percentage)
    val styledBar = progressBar in style
    clearPrint(styledBar)

    Thread.sleep(15)

  println()
end printProgressBar

def clearPrint(in: Any = ""): Unit =
  val replaceChar: String = "\u001b[2K"
  val beginCursor: String = "\r"

  print(replaceChar + beginCursor + in + Console.RESET)

extension (self: Any)
  infix def in(style: String): String =
    style + self + Console.RESET
