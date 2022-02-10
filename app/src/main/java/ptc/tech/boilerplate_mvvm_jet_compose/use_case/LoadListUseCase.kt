package ptc.tech.boilerplate_mvvm_jet_compose.use_case

import ptc.tech.repository.model.Entity

open class LoadListUseCase<Item: Entity> {
    fun forceToRefresh() { }

    open suspend fun loadItems(): Array<Item> {
        return arrayOf<Any>() as Array<Item>
    }
}