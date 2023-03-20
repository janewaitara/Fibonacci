package com.mumbicodes.fibonacci.presentation.util

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

// Used to convert date to Long in viewmodel
fun LocalDateTime.toLong(): Long {
    val zonedDateTime = ZonedDateTime.of(this, ZoneId.systemDefault())
    return zonedDateTime.toInstant().toEpochMilli()
}

// Used to convert Long to string in compose
fun Long.toDateString(): String {
    val localDateTime = Instant.ofEpochMilli(this)
        .atZone(ZoneId.systemDefault()).toLocalDateTime()

    val date = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val time = localDateTime.format(DateTimeFormatter.ofPattern("hh:mm a"))
    return "$date at $time"
}
