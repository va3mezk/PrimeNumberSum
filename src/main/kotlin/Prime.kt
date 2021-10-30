class Prime(var less:Int,var higher:Int) {
    fun calculate():Int{
        var sum=0
        while (less < higher) {
            if (checkPrime(less)) {
                sum += less
            }
            ++less
        }
        return sum
    }
    private fun checkPrime(num: Int): Boolean {
        var prime = true
        for (i in 2..num / 2) {
            if (num % i == 0) {
                prime = false
                break
            }
        }
        return prime
    }
}