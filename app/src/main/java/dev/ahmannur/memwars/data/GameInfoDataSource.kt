package dev.ahmannur.memwars

data class GameInfo(val title: String, val description: String)

object GameInfoDataSource {
    private val gameInfoMap = mapOf(
        "Word War" to GameInfo("Word War", """In this game you will have to memorize a list of words the best of your ability. 
            |
            |When you start the game, a list of words will be shown. You will have to memorize that list. After memorizing, you can press the Test Memory to begin the recall.
            |
            |In the recall section, you will have to re-create the original list by typing the correct words. Every time you enter the correct word in the correct place, it will be locked. If you enter all the correct words, your 'Proceed' button will be unlocked and you can check your score.
            |You scores will also have timers attached to them. It is not used to measure your score in this game, but will give you some additional info on what your natural memorization and recall time is
            |
            |You will also get some leeway. Meaning, even if you miss a few words, you will still be able proceed. Your will notice the 'Proceed' button being made available.
            |There is no time limit here. The only difficulty parameter that exists, is the number of words.
            |Remember to memorize the list in order.
            |
            |This excercise is very basic with very loose restrictions. But it is a very important practice in leveling up your fundamental memorization methods, especially if you're a beginner.
            |It can be used to train your memory palace, different loci methods of memorizing, you can also use peg systems or the body method, if you are just starting""".trimMargin()),
        "Word War Extreme" to GameInfo("Title for Game 2", "Description for Game 2"),
        // Add more game information here
    )

    fun getGameInfo(gameName: String?): GameInfo? {
        return gameInfoMap[gameName]
    }
}