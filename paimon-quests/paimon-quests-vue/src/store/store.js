import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export const store = new Vuex.Store({
        state: {
            user: {
                username: undefined,
                password: undefined,
            }
        },
        mutations: {
            logout(state){
                state.user = undefined
            },
            // login(state){

            // }
        },
        actions:{

        },
        getters:{

        },
        computed:{
            
        }
    }
)
