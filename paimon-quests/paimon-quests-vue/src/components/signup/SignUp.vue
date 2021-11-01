<template>
    <div class="container mt-5 pb-5 px-5 mr-5">
        <div class="py-5 mt-5">
                <img :src="require(`@/assets/paimon/${PAIMON}`)" draggable="false" class="rounded-pill paimon mt-5" alt="">
                <h1 class="text-dark py-5 display-4">
                    Inscrivez-vous
                </h1>
                <form class="my-5 mx-5" @submit="registerUser">
                    <div class="d-flex justify-content-center mt-2">
                        <div class="form-group">
                            <label for="username">Nom d'utilisateur</label>
                            <input type="text" class="form-control" id="username" v-model="userName" placeholder="Votre nom d'utilisateur">
                        </div>
                    </div>
                    <div class="d-flex justify-content-center mt-2">
                        <div class="form-group">
                            <label for="email">Adresse Courriel</label>
                            <input type="email" class="form-control" id="email" v-model="email" placeholder="Votre adresse courriel">
                        </div>
                    </div>
                    <div class="d-flex justify-content-center mt-2">
                        <div class="form-group">
                            <label for="password">Mot de passe</label>
                            <input type="password" class="form-control" id="password" v-model="password" placeholder="Votre mot de passe">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary mt-5">S'inscrire</button>
                </form>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
    export default {
        name: "SignUp",
        data(){
            return{
                userName: "",
                password: "",
                email: ""
            }
        },
        created(){
            this.PAIMON = 'nice-paimon.png'
        },
        methods:{
            clearForm(){
                this.userName = ''
                this.password = ''
                this.email = ''
            },
            registerSuccess(asd){
                console.log(asd)
                this.clearForm()
                alert("Inscription avec succès!")
            },
            registerUser(e){
                e.preventDefault();
                const user = { userName : this.userName, password : this.password, email : this.email}
                axios.post('http://localhost:9696/user/register', user)
                    .then(res => res.data.password == this.password ? this.registerSuccess(res) : alert("Insciption échouée"))
                    .catch(err => console.log(err))
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