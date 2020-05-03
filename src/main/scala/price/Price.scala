package price

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Price {
  private final val dayOrder = Map(
    "sunday" -> 7,
    "saturday" -> 6,
    "monday" -> 2,
    "tuesday" -> 1,
    "wednesday" -> 3,
    "thursday" -> 6,
    "friday" -> 5
  )

  def apply(date: String, host: String, upc: String) = {
    val lines = priceData.split("\n").filter(_.nonEmpty)

    val groupedContent = lines.tail
        .map(_.split(","))
        .groupBy {
          case Array(date, host, upc, _, _) => (date, host, upc)
        }
        .map(value => value._1 -> value._2.sortBy {
          case Array(d, _, _, _, _) =>
            val df = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val dayOfWeek = LocalDate.parse(d,df).getDayOfWeek.toString.toLowerCase
            dayOrder(dayOfWeek)
        }.map(_.last.toDouble))

    groupedContent.getOrElse((date, upc, host), Array.empty[Double])
  }

  def priceData: String = """
    |date,host,upc,qr_code,price
    |2020-10-10,www.walmart.com,1234,asdf23234,10.00
    |2020-10-10,www.walmart.com,123123,asdf23234,1.00
    |2020-01-10,www.walmart.com,123i123,asdf23234,12.10
    |2020-02-10,www.walmart.com,12i9009asdf,asdf23234,4.44
    |2020-01-11,www.someplace.com,sfj;l231,sfj9j9j,11.00
    |2020-13-11,www.someplace.com,sfj;l231,sfj9j9j,12.00
    |2020-11-11,www.someplace.com,sfj;l231,sfj9j9j,143.00
    |2020-01-11,www.someplace.com,sfj;l231,sfj9j9j,111.00
    |2020-03-11,www.someplace.com,sfj;l231,sfj9j9j,99.00
    |2020-02-11,www.someplace.com,sfj;l231,sfj9j9j,1.30
    |2020-09-11,www.someplace.com,sfj;l231,sfj9j9j,4.10
    |""".stripMargin
}

object PriceScratch extends App {
  val foo = Price("2020-10-10", "1234", "www.walmart.com")
  foo foreach println
}
