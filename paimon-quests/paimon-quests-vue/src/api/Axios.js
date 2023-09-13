// import axios from "axios"
export default class AxiosServices{

    static getCsrfToken(){
        return instance
    }

    static getBaseUrl(){
        return BASE_URL
    }
    
    static getConfig(){
        return (
            {
                headers: {
                    'content-type': 'application/json',
                    'X-XSRF-TOKEN': CSRF_TOKEN
                },
                withCredentials: true
            }
        )
    }
}

const CSRF_TOKEN = 
// this.$cookies.get("X-XSRF-TOKEN")
document.cookie.match(new RegExp(`XSRF-TOKEN=([^;]+)`))[1]

// const instance = axios.create({
//     headers: { "X-XSRF-TOKEN": CSRF_TOKEN }
// })
const instance = {
    'X-XSRF-TOKEN': CSRF_TOKEN
}
// export const AXIOS = instance

const BASE_URL ='http://localhost:9696'