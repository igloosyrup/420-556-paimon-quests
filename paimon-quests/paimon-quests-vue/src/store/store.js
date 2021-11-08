import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

const userUrl = "http://localhost:9696/user/",
const headers = { 'Content-Type' : 'application/json'}

export const store = new Vuex.Store({
        state: {
            user: {
                username: undefined,
                password: undefined,
                email: undefined,
                firstName: undefined,
                lastName: undefined,
                birthdate: undefined
            }
        },
        mutations: {
            logout(state){
                state.user = undefined
            },
            loginUser(state, payload){
                state.user = payload
            }
        },
        actions:{
            async loginUser(state){
                axios.get(`${userUrl}/login/${state.userName}/${state.password}`)
                .then(res => res.data.userName == state.userName ? 
                    state.user = res.data : state.user = undefined)

                // const result = await fetch(`${userUrl}login/${state.user.username}/${state.user.password}`, { headers })
                // const userFromServer = await result.json()
                // state.commit("loginUser", userFromServer.user)
            },

        },
        getters:{
            getCurrentUser: state => state.user
        },
    }
)
