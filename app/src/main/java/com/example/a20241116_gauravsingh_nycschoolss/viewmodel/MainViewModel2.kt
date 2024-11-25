package com.otherTallguy.dagger2example.viewmodel

import androidx.lifecycle.ViewModel
import com.example.a20241116_gauravsingh_nycschoolss.repository.SchoolRepository
import com.example.a20241116_gauravsingh_nycschoolss.viewmodel.TestForMultiBinding
import javax.inject.Inject

class MainViewModel2 @Inject constructor(
    private val repository: SchoolRepository,
    private val testForMultiBinding: TestForMultiBinding
) : ViewModel() {


}