import java.time.LocalDate

data class Event(val name: String, val date: LocalDate, val type: String)

fun main() {
    val events = mutableListOf<Event>()
    events.add(Event("Movie Night", LocalDate.of(2024, 5, 25), "Social"))
    events.addAll(listOf(
        Event("Conference", LocalDate.of(2024, 6, 10), "Professional"),
        Event("Book Club", LocalDate.of(2024, 5, 30), "Social")
    ))

    // Print all events
    println("All Events:")
    printEvents(events)

    // Filter upcoming events (after today's date)
    val upcomingEvents = events.filter { it.date.isAfter(LocalDate.now()) }
    println("\nUpcoming Events:")
    printEvents(upcomingEvents)

    // Filter social events
    val socialEvents = events.filter { it.type == "Social" }
    println("\nSocial Events:")
    printEvents(socialEvents)

    // Filter upcoming social events
    val upcomingSocialEvents = events.filter { it.date.isAfter(LocalDate.now()) }
        .filter { it.type == "Social" }
    println("\nUpcoming Social Events:")
    printEvents(upcomingSocialEvents)
}

fun printEvents(events: List<Event>) {
    events.forEach { println(it.name) }
}