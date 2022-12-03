package project.santosotech.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    var name: String = "",
    var desc: String = "",
    var photo: Int = 0
): Parcelable
