data class Message(val userName: String = "", val userMessage: String = "")

object TestCases {
    fun getMessageInfo(userMessage: String): Int {
        if (isValidMessage(userMessage)) {
            return 1 // Користувач коректно ввів дані
        }

        if (!isValidMessage(userMessage)) {
            return -1 // Текст не відповідає умові або умовам
        }
        return -4 // Добавил значение по умолчанию, если нет других совпадений
    }
    fun isValidMessage(userMessage: String): Boolean {
        return userMessage.length in 1..1000 && userMessage.all { it.isLetter() || it.isWhitespace() }
    }
}

@RunWith(AndroidJUnit4::class)
class MedicialChatTest {
    fun testValidMessage() {
        ActivityScenario.launch(MedicialChat::class.java).onActivity{ medicalchat ->
            val res = medicalchat.getMessageInfo("Hi I want to be free")
            assertEquals(1, res)
        }
    }
    fun testInvalidMessage() {
        ActivityScenario.launch(MedicialChat::class.java).onActivity{ medicalchat ->
            val res = medicalchat.getMessageInfo("")
            assertEquals(-1, res)
        }
    }
    fun testInvalidMessage2() {
        ActivityScenario.launch(MedicialChat::class.java).onActivity{ medicalchat ->
            val res = medicalchat.getMessageInfo("")
            assertEquals(-1, res)
        }
    }
}
