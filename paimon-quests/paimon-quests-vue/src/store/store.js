import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from "vuex-persistedstate"

Vue.use(Vuex)

const LOGIN = "mutateLogin"
const LOGOUT = "mutateLogout"

const store = new Vuex.Store({
        state: {
            user: undefined
        },
        mutations: {
            mutateLogin(state, payload){
                state.user = payload.data
                console.log(state.user)
            },
            mutateLogout(state){
                state.user = undefined
            }
        },
        actions:{
            loginUser(state, payload){
                state.commit(LOGIN, payload)
            },
            logout(state){
                state.commit(LOGOUT)
                console.log(state.user)
            }
            
        },
        getters:{
            currentUser: state => state.user
        },
        plugins: [createPersistedState()]
    }
)

export default store