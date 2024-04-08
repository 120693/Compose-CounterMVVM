package com.example.countermvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {
    // 레파지토리와 UI 사이를 관리함
    private val _repository : CounterRepository = CounterRepository()

    // 내부에서만 사용할 변수는 앞에 _를 붙여준다
    private val _count = mutableStateOf(_repository.getCounter().count)

    // 그런데 이 값을 다른 클래스에서도 사용하고 싶다면, val 상태로 전달해주면 된다
    val count: MutableState<Int> = _count

    // 증가하는 함수
    fun increment() {
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    // 감소하는 함수
    fun decrement() {
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}