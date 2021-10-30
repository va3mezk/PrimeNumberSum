import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    var a=0
    var b=0
    var c=0
    var d=0
    println("Loading...Please wait")
    val job1 = launch {
        a =Prime(2,500000).calculate()
    }
    val job2 = launch(coroutineContext) {
        b=Prime(500001,1000000).calculate()
    }
    val job3 = launch(newFixedThreadPoolContext(3, "job3")) {
        c=Prime(1000001,1500000).calculate()
    }
    val job4 = launch(newFixedThreadPoolContext(4, "job4")) {
        d=Prime(1500001,2000000).calculate()
    }
    job1.join()
    job2.join()
    job3.join()
    job4.join()
    println("The sum of the primes below 2,000,000 is:${a+b+c+d}")
}

