fun main() {
    val ago = 259201

    agoToText(ago)
}

fun agoToText(ago: Int) {
    val minutes = ago / 60
    val lastMinutes = Character.getNumericValue(minutes.toString().last())
    val penultimateMinutes = minutes.toString().dropLast(1)
    val penultimateMinutesNum =
        if (!penultimateMinutes.isEmpty()) Character.getNumericValue(penultimateMinutes.last()) else 0

    val hours = ago / 3600
    val lastHours = Character.getNumericValue(hours.toString().last())
    val penultimateHours = hours.toString().dropLast(1)
    val penultimateHoursNum = if (!penultimateHours.isEmpty()) Character.getNumericValue(penultimateHours.last()) else 0

    when {
        ago <= 60 -> println("Был(а) только что")
        ago >= 61 && ago <= 60 * 60 ->
                when (lastMinutes) {
                    1 -> if (penultimateMinutesNum != 1) println("Был(а) $minutes минуту назад") else println("Был(а) $minutes минут назад")
                    2, 3, 4 -> if (penultimateMinutesNum != 1) println("Был(а) $minutes минуты назад")
                    else -> println("Был(а) $minutes минут назад")
                }
        ago >= 60 * 60 + 1 && ago <= 24 * 60 * 60 ->
            when (lastHours) {
                1 -> if (penultimateHoursNum != 1) println("Был(а) $hours час назад") else println("Был(а) $hours часов назад")
                2, 3, 4 -> if (penultimateHoursNum != 1) println("Был(а) $hours часа назад")
                else -> println("Был(а) $hours часов назад")
            }
        ago >= 24 * 60 * 60 + 1 && ago <= (24 * 60 * 60) * 2 -> println("Был(а) сегодня")
        ago >= (24 * 60 * 60) * 2 + 1 && ago <= (24 * 60 * 60) * 3 -> println("Был(а) вчера")
        else -> println("Был(а) давно")
    }
}