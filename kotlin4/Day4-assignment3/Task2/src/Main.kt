import java.time.LocalDateTime

interface Schedulable {
    val id: String
    val name: String
    var dateTime: LocalDateTime

    fun schedule(dateTime: LocalDateTime)
    fun reschedule(newDateTime: LocalDateTime)
}
class Event(
    override val id: String,
    override val name: String,
    initialDateTime: LocalDateTime
) : Schedulable {

    private var _dateTime: LocalDateTime = initialDateTime

    override var dateTime: LocalDateTime
        get() = _dateTime
        set(value) {
            _dateTime = value
        }

    override fun schedule(dateTime: LocalDateTime) {
        this._dateTime = dateTime
        println("Event '$name' scheduled for $dateTime")
    }

    override fun reschedule(newDateTime: LocalDateTime) {
        this._dateTime = newDateTime
        println("Event '$name' rescheduled to $newDateTime")
    }
}
class Schedule {
    private val events = mutableListOf<Schedulable>()

    fun addEvent(event: Schedulable) {
        events.add(event)
        println("Event '${event.name}' added to the schedule.")
    }

    fun removeEvent(event: Schedulable) {
        if (events.remove(event)) {
            println("Event '${event.name}' removed from the schedule.")
        } else {
            println("Event '${event.name}' not found in the schedule.")
        }
    }

    fun listEvents() {
        if (events.isEmpty()) {
            println("No events scheduled.")
        } else {
            println("Scheduled events:")
            events.forEach { event ->
                println("- ${event.name} at ${event.dateTime}")
            }
        }
    }

    fun findEventById(eventId: String): Schedulable? {
        return events.find { it.id == eventId }
    }
}
fun main() {
    val schedule = Schedule()

    val event1 = Event("1", "Meeting", LocalDateTime.of(2024, 5, 1, 9, 0))
    val event2 = Event("2", "Conference", LocalDateTime.of(2024, 5, 2, 10, 0))
    val event3 = Event("3", "Workshop", LocalDateTime.of(2024, 5, 3, 11, 0))

    schedule.addEvent(event1)
    schedule.addEvent(event2)
    schedule.addEvent(event3)

    schedule.listEvents()

    val foundEvent = schedule.findEventById("2")
    foundEvent?.let {
        it.reschedule(LocalDateTime.of(2024, 5, 2, 14, 0))
    }

    schedule.listEvents()

    schedule.removeEvent(event1)
    schedule.listEvents()
}