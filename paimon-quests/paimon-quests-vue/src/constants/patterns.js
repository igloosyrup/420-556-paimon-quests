
export class Patterns{

    static usernamePattern(){
        const userNamePattern = /^(?=.*[a-z])(?=.*[A-Z])*(?=.*[0-9])*(?=.*[@$!%*?&])*[A-Za-z0-9@$!%*?&]{8,}$/
        return userNamePattern
    }

    static passwordPattern(){
        const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$/
        return passwordPattern
    }

    static emailPattern(){
        const emailPattern = ""
        return emailPattern
    }
}