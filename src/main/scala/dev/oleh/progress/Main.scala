package dev.oleh.progress

@main def hello(): Unit =
  val bar: SimpleProgressBar.type = SimpleProgressBar

  for percentage <- 0 to 100 by 10 do
    println(s"${bar(percentage)}  ${percentage}")
