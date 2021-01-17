package editcom.vialsoft.powerfulappmvi.ui.auth.state


/**
 * This class contains the possible event that can happen in AuthView
 */
sealed class AuthStateEvent{

    class LoginAttemptEvent(
        val email: String,
        val password:String
    ): AuthStateEvent()

    class RegistrationAttemptEvent(
        val username: String,
        val email: String,
        val password: String,
        val confirmPassword: String
    ): AuthStateEvent()

    class CheckPreviousAuthEvent : AuthStateEvent()

}