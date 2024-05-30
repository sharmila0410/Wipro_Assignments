import java.util.Date

data class Event(val name: String, val date: Date, val attendeeCount: Int)

fun main() {
    // Prompt the user to enter event details
    val name = readLine() ?: ""
    val date = Date() // You can replace this with actual date parsing logic
    print("Enter attendee count: ")
    val attendeeCount = readLine()?.toIntOrNull() ?: 0

    // Create an instance of Event with user-defined variables
    val event = Event(name, date, attendeeCount)

    println("Event Name: ${event.name}")
    println("Event Date: ${event.date}")
    println("Attendee Count: ${event.attendeeCount}")
}