package models

data class StoreOrder(
	val petId: Int? = null,
	val quantity: Int? = null,
	val id: Long? = null,
	val shipDate: String? = null,
	val complete: Boolean? = null,
	val status: String? = null
)

