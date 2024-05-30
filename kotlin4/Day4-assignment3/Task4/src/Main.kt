import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Attendee(val name: String, val email: String)
data class Event(val name: String, val date: LocalDate, val type: String)

class DataManager<T> {
    private val data: MutableList<T> = mutableListOf()

    fun addData(item: T) {
        data.add(item)
    }

    fun getAllData(): List<T> {
        return data.toList()
    }

    fun findByName(name: String): T? {
        return data.find { it.toString().contains(name, ignoreCase = true) }
    }

    fun printData() {
        data.forEach { println(it) }
    }
}

fun main() {
    val attendeeManager = DataManager<Attendee>()
    val eventManager = DataManager<Event>()

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") // Define date format

    // User Input (Example)
    while (true) {
        println("Enter data type (attendee/event) or 'quit' to exit:")
        val type = readLine()!!.lowercase()
        if (type == "quit") break

        println("Enter data details:")
        val details = readLine()!!

        when (type) {
            "attendee" -> {
                val parts = details.split(",")
                if (parts.size != 2) {
                    println("Invalid attendee format (name,email)")
                    continue
                }
                attendeeManager.addData(Attendee(parts[0].trim(), parts[1].trim()))
            }
            "event" -> {
                val parts = details.split(",")
                if (parts.size != 3) {
                    println("Invalid event format (name,date,type)")
                    continue
                }
                try {
                    val date = LocalDate.parse(parts[1].trim(), formatter)
                    eventManager.addData(Event(parts[0].trim(), date, parts[2].trim()))
                } catch (e: Exception) {
                    println("Invalid date format (YYYY-MM-DD)")
                }
            }
            else -> println("Invalid data type")
        }
    }

    println("\nAttendees:")
    attendeeManager.printData()

    println("\nEvents:")
    eventManager.printData()
}