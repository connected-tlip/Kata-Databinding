package com.connectedlab.kata4

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MainViewLogicTest {
    private lateinit var service: SignupService
    private lateinit var sut: MainViewLogic

    @Before
    fun setup() {
        service = Mockito.mock(SignupService::class.java)

        sut = MainViewLogic(service)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
