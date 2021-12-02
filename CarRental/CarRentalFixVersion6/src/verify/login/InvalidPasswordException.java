package verify.login;

public class InvalidPasswordException extends Exception {

    int passwordConditionViolated = 0;

    public InvalidPasswordException(int conditionViolated) {
        super("Invalid Password: ");
        passwordConditionViolated = conditionViolated;
    }

    public String printMessage() {
        switch (passwordConditionViolated) {
            case 0:
                return ("Ingrese una contraseña.");
            case 1:
                return ("La contraseña debe tener entre 8-20 caracteres.");

            case 2:
                return ("La contraseña no debe tener espacios.");

            case 3:
                return ("La contraseña debe almenos tener un numero.");

            case 4:
                return ("La contraseña debe tener un caracter especial.");

            case 5:
                return ("La contraseña debe almenos tener una mayuscula.");

            case 6:
                return ("La contraseña debe almenos tener una minuscula.");                
        }

        return ("");
    }
}