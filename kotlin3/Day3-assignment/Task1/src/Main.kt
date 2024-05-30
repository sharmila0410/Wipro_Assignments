data class Transaction(
    val id: Int,
    val date: String,
    val amount: Double,
    val description: String
)
class TransactionExporter : Exportable {
    override fun exportToCsv(transactions: List<Transaction>): String {
        val csvHeader = "ID,Date,Amount,Description"
        val csvBody = transactions.joinToString("\n") { transaction ->
            "${transaction.id},${transaction.date},${transaction.amount},${transaction.description}"
        }
        return "$csvHeader\n$csvBody"
    }
}
fun main() {
    val transactions = listOf(
        Transaction(1, "2024-01-01", 100.0, "Payment"),
        Transaction(2, "2024-01-02", 150.0, "Refund"),
        Transaction(3, "2024-01-03", 200.0, "Purchase")
    )

    val exporter = TransactionExporter()
    val csvData = exporter.exportToCsv(transactions)

    println(csvData)
}