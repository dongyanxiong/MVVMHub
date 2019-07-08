package win.regin.base.state

import win.regin.base.exception.HubException

/**
 * @author :Reginer in  2019/7/8 9:42.
 *         联系方式:QQ:282921012
 *         功能描述:
 */

sealed class ViewState<out T> {
    companion object {
        fun <T> onHubSuccess(data: T): ViewState<T> = Success(data)
        fun <T> onHubLoading(): ViewState<T> = Loading
        fun <T> onHubError(error: HubException): ViewState<T> = Error(error)
    }

    object Loading : ViewState<Nothing>()
    data class Success<out T>(val data: T) : ViewState<T>()
    data class Error(val error: HubException) : ViewState<Nothing>()
}

