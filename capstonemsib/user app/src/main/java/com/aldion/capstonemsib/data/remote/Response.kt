package com.aldion.capstonemsib.data.remote

import com.aldion.capstonemsib.data.entity.Statement

data class Response(
    var questions:List<Statement>? = null,
    var exception: Exception? = null
)
