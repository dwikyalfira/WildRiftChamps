package com.dicoding.wildriftchamps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Champion(
    val name: String?,
    val role: String?,
    val region: String?,
    val description: String?,
    val photoIcon: Int,
    val photoBG: Int
): Parcelable
