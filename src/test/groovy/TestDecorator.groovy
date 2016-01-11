import java.lang.reflect.Method

class TestDecorator {

    static before(def instance, Method method, List args) {
        println "invokedBefore !"
    }

}
