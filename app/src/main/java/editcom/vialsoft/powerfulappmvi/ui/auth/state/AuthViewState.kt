package editcom.vialsoft.powerfulappmvi.ui.auth.state

import editcom.vialsoft.powerfulappmvi.model.AuthToken

/**
 * This class AuthViewState is the one with the logic related to the state of the view when an event
 * has happened or will happend, it works in conjunction with the stateEvent class.
 */

data class AuthViewState(
    var loginFields: LoginFields? = LoginFields(),
    var registrationFields: RegistrationFields? = RegistrationFields(),
    var authToken: AuthToken? = null
)

data class LoginFields(
    var loginEmail: String? = null,
    var loginPassword: String? = null
) {

    class LoginError {
        companion object {

            fun mustFillAllFields(): String {
                return "All fields are required."
            }

            fun none(): String {
                return "None"
            }

        }
    }

    fun isValidForLogin() :String{

        if (loginEmail.isNullOrEmpty() || loginPassword.isNullOrEmpty()){
            return LoginError.mustFillAllFields()
        }

        return LoginError.none()
    }


}


data class RegistrationFields(
    var registrationUsername: String? = null,
    var registrationEmail: String? = null,
    var registrationPassword: String? = null,
    var registrationConfirmPassword: String? = null
) {

    class RegistrationError {
        companion object {

            fun mustFillAllFields(): String {
                return "All fields are required."
            }

            fun passwordsDoNotMatch(): String {
                return "Passwords must match."
            }

            fun none(): String {
                return "None"
            }

        }
    }

    fun isValidForRegistration(): String {

        if (registrationUsername.isNullOrEmpty()
            || registrationEmail.isNullOrEmpty()
            || registrationPassword.isNullOrEmpty()
            || registrationConfirmPassword.isNullOrEmpty()
        ) {
            return RegistrationError.mustFillAllFields()
        }

        if (!registrationPassword.equals(registrationConfirmPassword)) {
            return RegistrationError.passwordsDoNotMatch()
        }

        return RegistrationError.none()
    }

}