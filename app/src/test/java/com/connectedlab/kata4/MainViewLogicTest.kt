package com.connectedlab.kata4

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer

class MainViewLogicTest {
    private lateinit var service: EmailService
    private lateinit var sut: MainViewLogic

    @Before
    fun setup() {
        service = Mockito.mock(EmailService::class.java)

        sut = MainViewLogic(service)
    }

    /**
     * 1. If invalid email (does not contain @) is inputted, error text (TextView / error_text)
     * should show "Invalid Email Address".
     */
    @Test
    fun inputTextValue_givenInvalidEmail_showErrorText() {
        sut.inputTextValue.set("123")
        assertTrue(sut.errorTextVisible.get())

    }

    /**
     * 2. The seekbar value is displayed and constantly updated in the textview above it
     * (TextView / num_emails_text) in the format: "Number of emails: <value>"
     *
     * Hint: Bind the seekbar android:progress attribute to an ObservableField!
     */
    @Test
    fun seekbarProgress_displaysToUser() {
        sut.seekBarValue.set(50)

        assertEquals("Number of emails: 50", sut.emailNumbers.get())
    }

    /**
     * 3. Click on the button (Button / email_button) calls EmailService.sendEmails (with the
     * appropriate arguments), and hides the error text if it is shown.
     *
     * Note: You don't need the parameter of buttonClick
     */
    @Test
    fun buttonClick_callsSendEmails() {
        sut.inputTextValue.set("email text")
        sut.seekBarValue.set(5)
        sut.buttonClick(null)
        Mockito.verify(service).sendEmails("email text", 5, sut)

    }

    /**
     * 4. If the sendEmails fails (i.e. onFailure is called), the error text shows "Failed to Send
     * - Need > 50 Emails!"
     */
    @Test
    fun sendEmails_givenSignupFails_showsErrorText() {
        sut.inputTextValue.set("email text")
        sut.seekBarValue.set(5)
        val answer: Answer<Unit> = Answer { invocation: InvocationOnMock ->
            (invocation.arguments[2] as EmailService.Callback).onFailure()
        }
        Mockito.`when`(service.sendEmails(Mockito.anyString(), Mockito.anyInt(), Mockito.any(EmailService.Callback::class.java))).thenAnswer(answer)

        sut.buttonClick(null)

        assertEquals(true, sut.errorTextVisible.get())
        assertEquals("Failed to Send - Need > 50 Emails!", sut.errorTextValue.get())
    }

    /**
     * 5. If sendEmails succeeds (i.e. onSuccess is called), a toast is shown with the text
     * "Success!"
     */
    @Test
    fun sendEmails_givenSignupSucceeds_showsToastWithSuccess() {
        TODO("Implement me!")
    }
}
