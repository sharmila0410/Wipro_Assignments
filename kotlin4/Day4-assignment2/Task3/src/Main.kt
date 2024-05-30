import java.time.LocalDate
class Event(
    val id: String,
    val name: String,
    val date: LocalDate
    // Other properties and methods...
)

// Define a class to represent a tagged event
data class TaggedEvent(val event: Event, val tags: Set<String>)

// Extension function to tag an event
fun Event.tag(tags: Set<String>): TaggedEvent {
    return TaggedEvent(this, tags)
}

// Extension function to categorize events by date
fun List<Event>.categorizeByDate(): Map<LocalDate, List<Event>> {
    return this.groupBy { it.date }
}

// Extension function to categorize events by a custom function
fun List<Event>.categorizeByCustom(categorizer: (Event) -> String): Map<String, List<Event>> {
    return this.groupBy { categorizer(it) }
}
fun main() {
    val events = listOf(
        Event("1", "Meeting", LocalDate.of(2024, 5, 1)),
        Event("2", "Training", LocalDate.of(2024, 5, 2)),
        Event("3", "Presentation", LocalDate.of(2024, 5, 2)),
        Event("4", "Conference", LocalDate.of(2024, 5, 3))
    )

    // Tagging an event
    val taggedEvent = events[0].tag(setOf("work", "planning"))
    println("Tagged Event: $taggedEvent")

    // Categorizing events by date
    val eventsByDate = events.categorizeByDate()
    println("\nEvents Categorized by Date:")
    eventsByDate.forEach { (date, eventList) ->
        println("Date: $date")
        eventList.forEach { event ->
            println("- ${event.name}")
        }
    }

    // Categorizing events by a custom function (here, by the first letter of the event name)
    val eventsByFirstLetter = events.categorizeByCustom { it.name.first().toString().toUpperCase() }
    println("\nEvents Categorized by First Letter:")
    eventsByFirstLetter.forEach { (letter, eventList) ->
        println("Letter: $letter")
        eventList.forEach { event ->
            println("- ${event.name}")
        }
    }
}