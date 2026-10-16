package task4

fun main() {
    val courses = mutableListOf("SIF101", "SIF202", "SIF303", "SIF202")
    val creditMap = mapOf("SIF101" to 3, "SIF202" to 4, "SIF303" to 3, "SIF404" to 2)

    // 1. MutableList: tambah dua mata kuliah, hapus satu
    courses.add("SIF404")
    courses.add("SIF505")
    courses.remove("SIF303")
    println("Final list: $courses")

    // 2. Set: buang duplikat
    val uniqueCourses = courses.toSet()
    println("Unique courses: $uniqueCourses")

    // 3. Map: cari SKS, tangani mata kuliah yang tidak ditemukan
    val creditsSif202 = creditMap.getOrDefault("SIF202", 0)
    println("SIF202 credits: $creditsSif202")

    val creditsSif505 = creditMap["SIF505"] ?: 0
    println("SIF505 credits: $creditsSif505 (not found in credit map)")

    // 4. Ringkasan
    val totalCredits = uniqueCourses.sumOf { creditMap[it] ?: 0 }
    println("Total enrolled courses: ${uniqueCourses.size}")
    println("Total credit hours: $totalCredits")
}