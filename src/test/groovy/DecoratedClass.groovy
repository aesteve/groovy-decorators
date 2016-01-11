import com.github.aesteve.groovy.decorators.annot.Decorate
import groovy.transform.TypeChecked

@TypeChecked
class DecoratedClass {

    @Decorate("test")
    void decoratedMethod() {
        println "within method"
    }

}
