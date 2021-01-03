package dev.rasul.remoteimage

import android.graphics.Bitmap

sealed class RemoteImageState {

    object Loading : RemoteImageState()

    data class Loaded(
        val image: Bitmap
    ) : RemoteImageState()

    object LoadError : RemoteImageState()

}