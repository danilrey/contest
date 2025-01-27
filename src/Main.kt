fun main() {
    val n = readlnOrNull()?.toInt() ?: return
    val points = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val (x, y) = readlnOrNull()?.split(" ")?.map { it.toInt() } ?: return
        points.add(Pair(x, y))
    }
    var count = 0
    val usedpairs = BooleanArray(n) { false }
    for (i in 0..<n) {
        for (j in i + 1..<n) {
            for (k in j + 1..<n) {
                if (!usedpairs[i] && !usedpairs[j] && !usedpairs[k]) {
                    val (x1, y1) = points[i]
                    val (x2, y2) = points[j]
                    val (x3, y3) = points[k]
                    if ((x2 - x1) * (y3 - y1) != (y2 - y1) * (x3 - x1)) {
                        count++
                        usedpairs[i] = true
                        usedpairs[j] = true
                        usedpairs[k] = true
                    }
                }
            }
        }
    }
    println(count)
}