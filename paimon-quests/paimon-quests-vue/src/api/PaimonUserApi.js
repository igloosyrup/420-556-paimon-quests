import axios from 'axios'

export class PaimonUserApi{

    static registerPaimonUser(user){
        axios.post('http://localhost:9696/user/register', user)
    }
    
}