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
            _id = value
        }

    private var _date: String = date
    var date: String
        get() = _date
        set(value) {
            require(isValidDate(value)) { "Invalid date format. Expected format: YYYY-MM-DD" }
            _date = value
        }

    private var _amount: Double = amount
    var amount: Double
        get() = _amount
        set(value) {
            require(value >= 0) { "Amount must be non-negative" }
            _amount = value
        }

    private var _description: String = description
    var description: String
        get() = _description
        set(value) {
            require(value.isNotBlank()) { "Description cannot be blank" }
            _description = value
        }

    private fun isValidDate(date: String): Boolean {
        val regex = Regex("""\d{4}-\d{2}-\d{2}""")
        return regex.matches(date)
    }
}
interface Exportable {
    fun exportToCsv(transactions: Collection<Transaction>?): String
}

class TransactionExporter : Exportable {
    override fun exportToCsv(transactions: Collection<Transaction>?): String {
        if (transactions.isNullOrEmpty()) {
            return "No transactions available to export."
        }

        val csvHeader = "ID,Date,Amount,Description"
        val csvBody = transactions.joinToString("\n") { transaction ->
            "${transaction.id},${transaction.date},${transaction.amount},${transaction.description}"
        }
        return "$csvHeader\n$csvBody"
    }
}
fun handleTransactionList(transactions: List<Transaction>?, exporter: Exportable) {
    val csvData = exporter.exportToCsv(transactions)
    println(csvData)
}
fun handleTransactionSet(transactions: Set<Transaction>?, exporter: Exportable) {
    val csvData = exporter.exportToCsv(transactions)
    println(csvData)
}
fun handleTransactionMap(transactions: Map<Int, Transaction>?, exporter: Exportable) {
    val transactionList = transactions?.values?.toList()
    val csvData = exporter.exportToCsv(transactionList)
    println(csvData)
}
 fun main() {
    val transactionsList: MutableList<Transaction>? = mutableListOf()
    val transactionsSet: MutableSet<Transaction>? = mutableSetOf()
    val transactionsMap: MutableMap<Int, Transaction>? = mutableMapOf()

    try {
        println("Enter transaction details:")
        print("ID: ")
        val id = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("ID must be an integer")

        print("Date (YYYY-MM-DD): ")
        val date = readLine() ?: throw IllegalArgumentException("Date cannot be null")

        print("Amount: ")
        val amount = readLine()?.toDoubleOrNull() ?: throw IllegalArgumentException("Amount must be a number")

        print("Description: ")
        val description = readLine() ?: throw IllegalArgumentException("Description cannot be null")

        val transaction = Transaction(id, date, amount, description)

        // Add to different collections
        transactionsList?.add(transaction)
        transactionsSet?.add(transaction)
        transactionsMap?.put(id, transaction)

        val exporter = TransactionExporter()

        // Handle different collections
        handleTransactionList(transactionsList, exporter)
        handleTransactionSet(transactionsSet, exporter)
        handleTransactionMap(transactionsMap, exporter)

    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    } catch (e: NullPointerException) {
        println("Error: ${e.message}")
    }
}