package bugdemo

enum class TestEnum(val id: String? = null) {

    ENUM1(id = "enum1_id"),

    ENUM2(id = "enum2_id") {
        override fun test() {
            println(id)
        }
    };

    open fun test() {
        println("foo")
    }

}

fun main(args: Array<String>) {
    println("for ENUM1: " + TestEnum.ENUM1::class.constructors)
    println("for ENUM2: " + TestEnum.ENUM2::class.constructors)
}
