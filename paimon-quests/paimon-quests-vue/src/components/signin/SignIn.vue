<template>
    <div class="container mb-5 mt-5 pb-5 px-5">
        <div class="py-5 mt-5 mx-5">
            <div class="d-flex justify-content-center">
                <div class="form mt-5">
                    <img :src="require(`@/assets/paimon/${PAIMON}`)" draggable="false" class="rounded-pill paimon mt-5">
                    <h1 class="text-dark mx-4 py-5 display-4">
                        Connectez-vous
                    </h1>
                    <!-- To remove this later -->
                    <span >
                        {{this.$store.state.user}}
                    </span>
                    <!-- end of to remove later -->
                </div>
            </div>
            <div class="d-flex justify-content-center">
                <form class="mb-3" @submit.prevent="loginUser">
                    <div class="d-flex justify-content-center">
                        <div class="form-group">
                            <div class="mt-3">
                                <label for="userName">Nom d'utilisateur</label>
                                <input type="text" v-model="userName" class="form-control" id="userName" placeholder="Votre nom d'utilisateur">
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
import axios from 'axios'
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
            loginSuccess(user){
                this.clearForm()
                this.$store.dispatch("loginUser", user)
                this.$swal.fire({
                    title: "Bravo!",
                    text: "Connexion avec succès!",
                    icon: "success",
                    confirmButtonColor: '#3085d6',
                }).then( (result) => {
                    if(result.isConfirmed)
                        this.$router.push({ name: "User"})
                })
            },
            swal(alertTitle, alertText, alertIcon){
                this.$swal.fire({
                    title: alertTitle,
                    text: alertText,
                    icon: alertIcon,
                })
            }
            ,
            loginUser(){
                if(this.userName == "" || this.password == ""){
                    this.swal("Erreur!", "Veuillez entrez votre Nom d'utilisateur et Mot de passe avant de vous connecter", "error")
                    return
                }

                const credentials = {
                    userName : this.userName,
                    password : this.password
                }
                axios.post('http://localhost:9696/user/login/', credentials)
                    .then(res => {res.data != null  && res.data.userName == this.userName ? this.loginSuccess(res) : this.swal("Erreur!","Connexion échouée", "error")})
                    .catch( () =>{
                        this.swal("Erreur!", "Connexion échouée", "error")}
                    )
            }
        }
    }
</script>

<style scoped>
    input{
        border: 0px;
    }
    .paimon{
        width: 197.5px;
    }
</style>