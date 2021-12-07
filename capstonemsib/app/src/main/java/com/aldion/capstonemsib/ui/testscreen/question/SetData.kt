package com.aldion.capstonemsib.ui.testscreen.question

object SetData {
    fun getStatement():ArrayList<StatementData>{
        var statement:ArrayList<StatementData> = arrayListOf()
        var statementOne = StatementData(
            1,
            "Saya tidak merasa sedih",
            "Saya merasa sedih",
            "Saya sedih sepanjang waktu dan tidak dapat menghilangkannya",
            "Saya begitu sedih sehingga merasa tidak tahan lagi"
        )
        statement.add(statementOne)
        return statement
    }
}