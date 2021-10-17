import kotlin.random.Random
import kotlin.random.nextInt

fun main(args: Array<String>) {

    val numLetter ="ississippi".count({Letter -> Letter=='s'})
    println(numLetter)

    println("---------------------------")

    println({ val currentYear = 2018
        "Welcome to SimVillage, Mayor! (copyright $currentYear)" }())

    println("---------------------------")

    val greetingFunction :()-> String ={ val currentYear = 2021
        "Welcome to SimVillage, Mayor! (copyright $currentYear)" }

    val greetingFun:(String)->String={playerName ->
        val currentYear1=2021
        "welcome to SimVillage, $playerName ($currentYear1)" }
    println(greetingFun("Lamia"))

    println("---------------------------")

    val greetingfun1: (String)-> String={ val currentYear = 2019
        "Welcome to SimVillage, $it ! (copyright $currentYear)" }
    println(greetingfun1("Omar"))

    println("---------------------------")

    val greetingfun2: (String,Int) -> String ={ playerName,numBuilding->
        val currentYear2 = 2018
        println("Add $numBuilding houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear2)"}
    println(greetingfun2("Huda", 5))

    println("---------------------------")

    val greetingfun3 = { playerName: String, numBuilding: Int ->
        val currentYear= 201
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingfun3("Lamia", 1))

    println("---------------------------")

    val greetingFunction4 = { playerName: String, numBuildings: Int ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome to SimVillage $playerName ! (copyright $currentYear)"
    }
    runSimulation("Gyal", greetingFunction4)

    println("--------------------------")

    runSimulation("Guyal") { playerName, numBuildings ->
        val currentYear = 2020
        println("Adding $numBuildings houses")
        "Welcome to SimVillage , $playerName (copyright $currentYear)"
    }

    println("---------------------------")

    runSimulation1("Guyal",::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2999
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)" }

    runSimulation3()

    println("-----------Exceptions Example----------------")
    //Exceptions Example
    var input: String? =null
    val a: Int? = try { input!!.toInt() } catch (e: NumberFormatException) { null }
    println("---------------------------")

}

fun runSimulation(playerName: String, greetingFunction4: (String, Int) -> String) {
    val numBuildings = Random.nextInt(1..3)
    println(greetingFunction4(playerName, numBuildings)) }


fun printConstructionCost(numBuilding:Int) { val cost = 500
    println("constrution cost : ${cost * numBuilding}") }

fun runSimulation1(playerName: String, costPrinter: (Int) -> Unit, greetingFunction4: (String, Int) -> String) {
    val numBuildings = Random.nextInt(1..3)
    costPrinter(numBuildings)
    println(greetingFunction4(playerName, numBuildings)) }

fun runSimulation3() { val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Gual")) }
fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}
