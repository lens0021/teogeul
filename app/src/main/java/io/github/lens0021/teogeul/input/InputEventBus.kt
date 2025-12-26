package io.github.lens0021.teogeul.input

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.runBlocking

object InputEventBus {
    private val eventFlow = MutableSharedFlow<InputEvent>(extraBufferCapacity = 0)
    val events = eventFlow.asSharedFlow()

    fun emitBlocking(event: InputEvent) {
        runBlocking {
            eventFlow.emit(event)
        }
    }

    suspend fun emit(event: InputEvent) {
        eventFlow.emit(event)
    }
}
