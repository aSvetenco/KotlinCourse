package sa.kotlin.photoapp.test

class TestPresenter(val view: TestView) {

    fun sayHello(message: String) {
        view.sayHello(message)
    }

    fun hideHello() {
        view.hideHello()
    }

}