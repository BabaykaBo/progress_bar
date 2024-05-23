package dev.oleh.progress

@main def hello(): Unit =
  for factor <- 1 to 4 do printProgressBar(factor)

def printProgressBar(factor: Int): Unit =
  val renderProgressBar: ProgressBar = ProgressBar.make(factor)

  for percentage <- 0 to 100 by 10 do
    val progressBar: String = renderProgressBar(percentage)
    clearPrint(progressBar)

    Thread.sleep(15)

  println()
end printProgressBar

def clearPrint(in: Any = ""): Unit =
  val replaceChar: String = "\u001b[2K"
  val beginCursor: String = "\r"

  print(replaceChar + beginCursor + in + Console.RESET)
