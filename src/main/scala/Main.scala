@main def hello(): Unit =
  println("Hello world!")
  println(msg)

def msg = "I was compiled by Scala 3. :)"
def foo(a: String): String =
  a.toUpperCase()