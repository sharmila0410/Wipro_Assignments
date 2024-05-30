import java.util.*

open class Event(
    val name: String,
    val date: String,
    val location: String
)

class EventManage : Display {
    private val events = mutableListOf<Event>()
    private val notifications = mutableListOf<(Event) -> Unit>()

    fun addEvent(event: Event) {
        events.add(event)
        notify(event)
    }

    fun removeEvent(event: Event){
        events.remove(event)
    }

    fun addNotification(notification: (Event) -> Unit){
        notifications.add(notification)
    }

    private fun notify(event: Event){
        notifications.forEach{it(event)}
    }

    override fun showEventDetails(){
        events.forEach{println("Event: ${it.name},Date:${it.date}, Location:${it.location}")}
    }

}

class SpecialEvent(
    name: String,
    date: String,
    location: String,
    val vipList: MutableList<String> = mutableListOf(),
    val premiumServices: MutableList<String> = mutableListOf()
) : Event(name, date, location) {

    fun addVIP(vip: String) {
        vipList.add(vip)
    }

    fun removeVIP(vip: String) {
        vipList.remove(vip)
    }

    fun addPremiumService(service: String) {
        premiumServices.add(service)
    }

    fun removePremiumService(service: String) {
        premiumServices.remove(service)
    }

    override fun toString(): String {
        return "SpecialEvent(name=$name, date=$date, location=$location, VIPs=$vipList, Premium Services=$premiumServices)"
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val eventManager = EventManage()

    // Adding a simple notification system
    eventManager.addNotification { event ->
        println("Notification: New event added: ${event.name}")
    }

    while (true) {
        println("Enter event type (1: Regular Event, 2: Special Event, 0: Exit): ")
        val eventType = scanner.nextInt()
        scanner.nextLine()  // Consume newline

        if (eventType == 0) break

        println("Enter event name: ")
        val name = scanner.nextLine()

        println("Enter event date (YYYY-MM-DD): ")
        val date = scanner.nextLine()

        println("Enter event location: ")
        val location = scanner.nextLine()

        when (eventType) {
            1 -> {
                val event = Event(name, date, location)
                eventManager.addEvent(event)
            }
            2 -> {
                val specialEvent = SpecialEvent(name, date, location)
                println("Enter VIPs (comma separated): ")

                val vips = scanner.nextLine().split(",").map { it.trim() }
                vips.forEach { specialEvent.addVIP(it) }

                println("Enter Premium Services (comma separated): ")
                val services = scanner.nextLine().split(",").map { it.trim() }
                services.forEach { specialEvent.addPremiumService(it) }

                eventManager.addEvent(specialEvent)
            }
            else -> {
                println("Invalid event type")
            }
        }
    }

    eventManager.showEventDetails()
}