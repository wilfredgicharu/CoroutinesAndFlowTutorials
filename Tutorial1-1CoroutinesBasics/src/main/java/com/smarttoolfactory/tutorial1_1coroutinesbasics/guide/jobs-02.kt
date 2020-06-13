package com.smarttoolfactory.tutorial1_1coroutinesbasics.guide

import kotlinx.coroutines.*

/**
 * Cancellation is propagated from parent to child.
 *
 * A parent job’s cancellation causes its children to cancel.
 *
 * A child’s cancellation won’t affect its parent and other childs
 * A child’s failure(throwing exception) causes its parent and other childs to cancel.
 *
 * 🤡Cancellation of parent job🤡
 * 🔥 In this case, parent job is cancelled, then all child jobs cancelled automatically.
 * */

fun main() {

    // Parent Job and Coroutine Exception Handler
    val parentJob = Job()

    // CoroutineScope
    val coroutineScope = CoroutineScope(Dispatchers.IO + parentJob)

    var child1: Job? = null
    var child2: Job? = null

    // Use
    coroutineScope.launch {
        child1 = coroutineScope.launch {
            delay(500)
        }
        child2 = coroutineScope.launch {
            delay(500)
        }


        // cancel()
        parentJob.cancel()

        println("Job 1 state: ${child1?.status()}")
        println("Job 2 state: ${child2?.status()}")
        println("Parent job is active: ${coroutineScope.isActive}")
        println("Parent job is active: $isActive")
        println("Parent job is active: ${parentJob.isActive}")
    }


    Thread.sleep(2000L)
}