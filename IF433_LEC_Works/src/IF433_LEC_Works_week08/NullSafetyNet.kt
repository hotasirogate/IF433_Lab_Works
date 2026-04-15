package IF433_LEC_Works_week08

fun main() {
    var nama:String? = "Wirawan";

    try {
        println("nama kamu ${nama!!.uppercase()}");
    } catch(ex: Exception) {
        println("Kamu kena error, ini pesan err-nya: ${ex.message}");
    }

    val kumpulanData: List<Any> = listOf(123, "Budi", 2824, "Tangerang");
    for(item in kumpulanData){
        val isiData = item as? String
        if(isiData != null){
            println(isiData);
        }
    }
}