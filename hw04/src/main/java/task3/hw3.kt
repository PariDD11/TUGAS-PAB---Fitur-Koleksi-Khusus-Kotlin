package task3

// 1. Menghitung jumlah kata dalam sebuah String
fun String.wordCount(): Int {
    return this.trim().split(Regex("\\s+")).filter { it.isNotEmpty() }.size
}

// 2. Mengubah Int menjadi format Rupiah, misalnya 75000 -> "Rp 75.000"
fun Int.toRupiahString(): String {
    val grouped = this.toString()
        .reversed()
        .chunked(3)
        .joinToString(".")
        .reversed()
    return "Rp $grouped"
}

// 3. Rata-rata dari nilai yang berada di rentang [min, max]
fun List<Int>.clampedAverage(min: Int, max: Int): Double {
    val filtered = this.filter { it in min..max }
    return if (filtered.isEmpty()) 0.0 else filtered.average()
}

fun main() {
    // Tes wordCount
    println("Halo".wordCount())
    println("Saya sedang belajar Kotlin".wordCount())
    println("Extension function membuat kode lebih ringkas dan mudah dibaca".wordCount())

    // Tes toRupiahString
    println(1000.toRupiahString())
    println(50000.toRupiahString())
    println(1000000.toRupiahString())

    // Tes clampedAverage
    val scores = listOf(10, 50, 200, 85, -5)
    println("$scores.clampedAverage(0, 100) = ${scores.clampedAverage(0, 100)}")
    println(listOf(200, 300).clampedAverage(0, 100))
}