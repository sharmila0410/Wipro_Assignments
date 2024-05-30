import java.time.LocalDate
import java.time.format.DateTimeParseException

class Transaction(
    id: Int,
    date: String,
    amount: Double,
    description: String
) {
    private var _id: Int = id
    var id: Int
        get() = _id
        private set(value) {
            if (value <= 0) throw InvalidTransactionIdException("ID must be a positive integer")
            _id = value
        }

    private var _date: LocalDate = parseDate(date)
    var date: String
        get() = _date.toString()
        set(value) {
            _date = parseDate(value)
        }

    private var _amount: Double = amount
    var amount: Double
        get() = _amount
        set(value) {
            if (value < 0) throw NegativeTransactionAmountException("Amount must be non-negative")
            _amount = value
        }

    private var _description: String = description
    var description: String
        get() = _description
        set(value) {
            if (value.isBlank()) throw BlankTransactionDescriptionException("Description cannot be blank")
            _description = value
        }

    private fun parseDate(date: String): LocalDate {
        return try {
            LocalDate.parse(date)
        } catch (e: DateTimeParseException) {
            throw InvalidDateFormatException("Invalid date format. Expected format: YYYY-MM-DD")
        }
    }
}
class InvalidTransactionIdException(message: String) : IllegalArgumentException(message)
class InvalidDateFormatException(message: String) : IllegalArgumentException(message)
class NegativeTransactionAmountException(message: String) : IllegalArgumentException(message)
class BlankTransactionDescriptionException(message: String) : IllegalArgumentException(message)
fun List<Transaction>?.totalExpenses(): Double {
    return this?.filter { it.amount < 0 }?.sumOf { it.amount } ?: 0.0
}

fun List<Transaction>?.totalIncomes(): Double {
    return this?.filter { it.amount > 0 }?.sumOf { it.amount } ?: 0.0
}
fun main() {
    try {
        val transactions = listOf(
            Transaction(1, "2024-01-01", -50.0, "Groceries"),
            Transaction(2, "2024-01-02", 200.0, "Salary"),
            Transaction(3, "2024-01-03", -30.0, "Transport"),
            Transaction(4, "2024-01-04", 100.0, "Freelance Work")
        )

        val totalExpenses = transactions.totalExpenses()
        val totalIncomes = transactions.totalIncomes()

        println("Total Expenses: $totalExpenses")
        println("Total Incomes: $totalIncomes")

        // Handling null transactions list
        val nullTransactions: List<Transaction>? = null
        val nullTotalExpenses = nullTransactions.totalExpenses()
        val nullTotalIncomes = nullTransactions.totalIncomes()

        println("Total Expenses (null): $nullTotalExpenses")
        println("Total Incomes (null): $nullTotalIncomes")
    } catch (e: InvalidTransactionIdException) {
        println("Error: ${e.message}")
    } catch (e: InvalidDateFormatException) {
        println("Error: ${e.message}")
    } catch (e: NegativeTransactionAmountException) {
        println("Error: ${e.message}")
    } catch (e: BlankTransactionDescriptionException) {
        println("Error: ${e.message}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}