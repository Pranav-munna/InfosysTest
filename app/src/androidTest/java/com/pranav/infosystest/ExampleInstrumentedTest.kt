package com.pranav.infosystest

import android.app.Activity
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pranav.infosystest.ui.home.quotes.QuotesViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private var viewModel: QuotesViewModel? = null
    private var activity: Activity? = null

    @Before
    fun setup() {
//        activity = mock(Activity::class.java)
//        viewModel = QuotesViewModel(null)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.pranav.infosystest", appContext.packageName)
    }
}
