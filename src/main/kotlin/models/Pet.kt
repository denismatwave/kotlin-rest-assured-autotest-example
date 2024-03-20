package models

data class Pet(
	val photoUrls: List<String?>? = null,
	val name: String? = null,
	val id: Int? = null,
	val category: Category? = null,
	val tags: List<TagsItem?>? = null,
	val status: String? = null
)

data class Category(
	val name: String? = null,
	val id: Int? = null
)

data class TagsItem(
	val name: String? = null,
	val id: Int? = null
)

