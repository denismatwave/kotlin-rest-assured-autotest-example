import models.StoreOrder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import requests.Store.deleteStoreOrder
import requests.Store.getStoreOrder
import requests.Store.postStore

class StoreTests {

    private lateinit var storeRequest : StoreOrder

    @BeforeEach
    fun setUp() {
        storeRequest = StoreOrder(status = "Test")
    }

    @Test
    fun test() {
        val order = postStore(storeRequest)
        getStoreOrder(order.id.toString())
        deleteStoreOrder(order.id.toString())
    }
}