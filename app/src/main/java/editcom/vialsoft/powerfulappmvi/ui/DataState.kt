package editcom.vialsoft.powerfulappmvi.ui

/**
 * This class represents the estate of the incoming data from the server.
 */
data class DataState<T>(
    var error: Event<ErrorResource>? = null,
    var loading : LoadingResource = LoadingResource(false),
    var data : DataResource<T>? = null
) {


    companion object {

        fun <T> error(
            response: ResponseResource
        ): DataState<T> {
            return DataState(
                error = Event(
                    ErrorResource(
                        response
                    )
                ),
                loading = LoadingResource(false),
                data = null
            )
        }

        fun <T> loading(
            isLoading: Boolean,
            cachedData: T? = null
        ): DataState<T> {
            return DataState(
                error = null,
                loading = LoadingResource(isLoading),
                data = DataResource(
                    Event.dataEvent(
                        cachedData
                    ), null
                )
            )
        }

        fun <T> data(
            data: T? = null,
            response: ResponseResource? = null
        ): DataState<T> {
            return DataState(
                error = null,
                loading = LoadingResource(false),
                data = DataResource(
                    Event.dataEvent(data),
                    Event.responseEvent(response)
                )
            )
        }
    }



}