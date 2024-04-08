package com.example.countermvvm

data class CounterModel(
    var count : Int)

// 데이터와 관련된 것은 레파지토리에서 처리하기 --> 데이터를 보호하고 숨기기 위하여
class CounterRepository {
    private var _counter = CounterModel(0)

    fun getCounter() = _counter

    fun incrementCounter() {
        _counter.count++
    }

    fun decrementCounter() {
        _counter.count--
    }
}