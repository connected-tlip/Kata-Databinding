package com.connectedlab.kata4

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

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
        TODO("Implement me!")
    }

    /**
     * 2. The seekbar valid is displayed and constantly updated in the textview above it
     * (TextView / num_emails_text) in the format: "Number of emails: <value>"
     *
     * Hint: Bind the seekbar android:progress attribute to an ObservableField!
     */
    @Test
    fun seekbarProgress_displaysToUser() {
        TODO("Implement me!")
    }

    /**
     * 3. Click on the button (Button / email_button) calls EmailService.sendEmails (with the
     * appropriate arguments), and hides the error text if it is shown.
     *
     * Note: You don't need the parameter of buttonClick
     */
    @Test
    fun buttonClick_callsSendEmails() {
        TODO("Implement me!")
    }

    /**
     * 4. If the sendEmails fails (i.e. onFailure is called), the error text shows "Failed to Send
     * - Need > 50 Emails!"
     */
    @Test
    fun sendEmails_givenSignupFails_showsErrorText() {
        TODO("Implement me!")
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
