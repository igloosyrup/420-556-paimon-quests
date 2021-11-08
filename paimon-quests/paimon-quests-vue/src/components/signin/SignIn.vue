<template>
    <div class="container mb-5 mt-5 pb-5 px-5">
        <div class="py-5 mt-5 mx-5">
            <div class="d-flex justify-content-center">
                <div class="form mt-5">
                    <img :src="require(`@/assets/paimon/${PAIMON}`)" draggable="false" class="rounded-pill paimon mt-5">
                    <h1 class="text-dark mx-4 py-5 display-4">
                        Connectez-vous
                    </h1>
                    
                </div>
            </div>
            <div class="d-flex justify-content-center">
                <form class="mb-3" @submit.prevent="loginUser">
                    <div class="d-flex justify-content-center">
                        <div class="form-group">
                            <div class="mt-3">
                                <label for="username">Nom d'utilisateur</label>
                                <input type="text" v-model="userName" class="form-control" id="username" placeholder="Votre nom d'utilisateur">
                            </div>
                            <div class="mt-3">
                                <label for="password">Mot de passe</label>
                                <input type="password" v-model="password" class="form-control" id="password" placeholder="Votre mot de passe">
                            </div>
                            <div class="mt-3">
                                <button type="submit" class="form-control btn btn-dark mt-3">Se connecter</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div>
            <a href="#" class="text-dark">Mot de passe oublié?</a>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
    export default {
        name: "SignIn",
        created(){
            this.PAIMON = 'proud-paimon.png'
        }, 
        data(){
            return{
                userName: "",
                password: ""
            }
        },
        methods:{
            clearForm(){
                this.userName = ''
                this.password = ''
            },
            loginSuccess(){
                this.clearForm()
                // this.$store.setUser()
                alert("Connexion avec succès!")
            },
            loginUser(){
                axios.get(`http://localhost:9696/user/login/${this.userName}/${this.password}`)
                    .then(res => res.data.userName == this.userName ? this.loginSuccess() : alert("Connexion échouée"))
            }
        }
    }
</script>

<style scoped>
    input{
            /* background-color: rgba(255,255,255, 0.0); */
            border: 0px;
    }
    .paimon{
        width: 197.5px;
    }
</style>