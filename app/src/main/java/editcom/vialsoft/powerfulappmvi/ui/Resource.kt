package editcom.vialsoft.powerfulappmvi.ui

data class LoadingResource(val isLoading: Boolean)
data class DataResource<T>(val data: Event<T>?, val response: Event<ResponseResource>?)
data class ErrorResource(val response: ResponseResource)


data class ResponseResource(val message : String? , val responseType : ResponseType)

sealed class ResponseType{

    class Toast : ResponseType()
    class Dialog : ResponseType()
    class None : ResponseType()

}


/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 * (This one was created by mitch for handling screen rotation
 */
class Event<T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content

    override fun toString(): String {
        return "Event(content=$content,hasBeenHandled=$hasBeenHandled)"
    }

    companion object{

        // we don't want an event if there's no data
        fun <T> dataEvent(data: T?): Event<T>?{
            data?.let {
                return Event(it)
            }
            return null
        }

        // we don't want an event if the response is null

        fun responseEvent(response: ResponseResource?): Event<ResponseResource>?{
            response?.let{
                return Event(response)
            }
            return null
        }
    }


}