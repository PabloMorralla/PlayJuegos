package com.example.playjuegos

data class CheckInfo (
    var title: String,
    var selected: Boolean,
    var onCheckedChange: (Boolean) -> Unit
)