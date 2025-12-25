package io.github.lens0021.teogeul.event

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.runBlocking

object TeogeulEventFlow {
    private val eventFlow = MutableSharedFlow<TeogeulEvent>(extraBufferCapacity = 0)
    val events = eventFlow.asSharedFlow()

    fun emitBlocking(event: TeogeulEvent) {
        runBlocking {
            eventFlow.emit(event)
        }
    }

    suspend fun emit(event: TeogeulEvent) {
        eventFlow.emit(event)
    }
}
