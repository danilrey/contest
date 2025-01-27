fun main() {
    val input = readlnOrNull()
    if (input != null) {
        val (n, m) = input.split(" ").map { it.toInt() }
        val distances = readlnOrNull()?.split(" ")?.map { it.toInt() }?.toMutableList() ?: return

        val a1 = distances[0]
        val a2 = distances[1]
        var greatDays = 0

        for (i in 2..<n) {
            if (distances[i] in a1..a2) {
                greatDays++
            }
        }

        if (greatDays >= m) {
            println(0)
            return
        }

        val correct = mutableListOf<Int>()
        for (i in 2..<n) {
            if (distances[i] < a1) {
                correct.add(a1 - distances[i])
            } else if (distances[i] > a2) {
                correct.add(distances[i] - a2)
            }
        }

        correct.sort()
        var result = 0
        for (i in correct) {
            result += i
        }

        println(result)
    }
}
