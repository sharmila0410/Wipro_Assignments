import java.text.SimpleDateFormat
import java.util.Date

fun createEvent() {
    println("Enter event name:")
    val name = readLine() ?: "" // Handle empty input (improve for robustness)

    println("Enter event date (YYYY-MM-DD):")
    val dateString = readLine() ?: ""

    // Validate and parse date (improve for robustness)
    val date: Long = try {
        val formatter = SimpleDateFormat("yyyy-MM-dd") // Required for parsing
        val parsedDate = formatter.parse(dateString)
        parsedDate.time // Get the time in milliseconds
    } catch (e: Exception) {
        println("Invalid date format. Please use YYYY-MM-DD.")
        return // Exit if date parsing fails
    }

    when {
        name.isEmpty() -> println("Event name cannot be empty.")
        date < System.currentTimeMillis() -> println("Event date cannot be in the past.")
        else -> {
            val event = Event(name, date)
            println("Event created successfully!")
            // Add event to a storage mechanism (replace with your implementation)
        }
    }
}

// Sample Event data class (replace with your actual data structure)
data class Event(val name: String, val date: Long)

fun main() {
    createEvent()
}