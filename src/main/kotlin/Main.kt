package tasklist

object TaskManager {
    private val taskList = mutableListOf<String>()

    fun addTask() {
        println("Input the tasks (enter a blank line to end):")
        while (true) {
            val task = readln().trim()
            if (task.isEmpty()) {
                break
            }
            taskList.add(task)
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
}

fun main() {
    TaskManager.addTask()
    TaskManager.printTasks()
}