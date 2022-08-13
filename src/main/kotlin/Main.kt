enum class ACTION(val action: String) {
    ADD("add"),
    PRINT("print"),
    END("end")
}

object TaskManager {
    private val taskList = mutableListOf<String>()

    fun addTask() {
        println("Input the tasks (enter a blank line to end):")
        var str = ""
        while (true) {
            val task = readln().trim()
            if (task.isEmpty()) {
                break
            }
            if(str.isEmpty()) {
                str += task + "\n"
            }  else {
                str += "   $task\n"
            }
        }
        if (str.isNotEmpty()) {
            taskList.add(str)
        } else {
            println("The task is blank")
        }
    }

    fun printTasks() {
        if (taskList.isEmpty()) {
            println("No tasks have been input")
        } else {
            for (i in taskList.indices) {
                val space = if (i >= 9) " " else "  "
                println("${i + 1}$space${taskList[i]}")
            }
        }
    }

    fun exit() = println("Tasklist exiting!")
}

fun invalidInput() = println("The input action is invalid")

fun main(args: Array<String>) {

    while (true) {
        println("Input an action (add, print, end):")
        when (readln()) {
            ACTION.ADD.action ->  TaskManager.addTask()
            ACTION.PRINT.action -> TaskManager.printTasks()
            ACTION.END.action -> {
                TaskManager.exit()
                break
            }
            else -> invalidInput()
        }
    }
}


