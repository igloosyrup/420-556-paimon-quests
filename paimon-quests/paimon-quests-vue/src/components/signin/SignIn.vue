<template>
    <div class="container mt-5 pb-5 px-5">
        <div class="py-5 mt-5 mx-5">
            <div class="d-flex justify-content-center">
                <div class="form mt-5">
                    <img :src="require(`@/assets/paimon/${PAIMON}`)" draggable="false" class="rounded-pill paimon mt-5" alt="">
                    <h1 class="text-dark mx-4 py-5 display-4">
                        Se connecter
                    </h1>
                </div>
            </div>
            <form class="mb-5" @submit="loginUser">
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
                    </div>
                </div>
                <button type="submit" class="btn btn-primary mt-5">Se connecter</button>
            </form>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
    export default {
        name: "SignIn",
        data(){
            return{
                userName: "",
                password: ""
            }
        },
        created(){
            this.PAIMON = 'Paimon-Treasure.png'
        },
        methods:{
            clearForm(){
                this.userName = ''
                this.password = ''
            },
            loginSuccess(){
                this.clearForm()
                alert("Connexion avec succès!")
            },
            loginUser(e){
                e.preventDefault();
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