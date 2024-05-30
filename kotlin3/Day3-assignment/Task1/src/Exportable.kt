interface Exportable {
    fun exportToCsv(transactions: List<Transaction>):String
}