package com.example.composecomponents.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var name: String,
    var pusblisher: String,
    var realName: String,
    @DrawableRes var drawable: Int
)
