<template>
    <div class="container mt-5 pb-5 px-5">
        <div class="py-5 m-5">
            <div class="d-flex justify-content-center">
                <div class="form mt-5">
                    <img :src="require(`@/assets/paimon/${PAIMON}`)" draggable="false" class="rounded-pill paimon mt-5">
                    <h1 class="text-dark mx-4 py-5 display-4">
                        Inscrivez-vous
                    </h1>
                </div>
            </div>
            <div class="d-flex justify-content-center">
                <form class="mx-5" @submit.prevent="registerUser">
                    <div class="d-flex justify-content-center">
                        <div class="form-group">
                            <div class="form-group mt-3" :class="{ 'form-group--error': $v.username.$error }">
                                <label for="username">Nom d'utilisateur</label>
                                <input type="text" class="form-control" id="username" v-model="$v.username.$model" placeholder="Votre nom d'utilisateur">
                                <div class="text-danger font-weight-bold" v-if="!$v.username.required && $v.username.$dirty">Le nom d'utilisateur est obligatoire</div>
                                <div class="text-danger font-weight-bold" v-if="!$v.username.usernameValid">Le nom d'utilisateur doit avoir au moins {{$v.username.$params.minLength.min}} caractères.</div>
                            </div>
                            <div class="form-group mt-3" :class="{ 'form-group--error': $v.email.$error }">
                                <label for="email">Adresse Courriel</label>
                                <input type="email" class="form-control" id="email" v-model="$v.email.$model" placeholder="Votre adresse courriel">
                                <div class="text-danger font-weight-bold" v-if="!$v.email.required && $v.email.$dirty">L'adresse courriel est obligatoire</div>
                                <div class="text-danger font-weight-bold" v-if="!$v.email.minLength">L'adresse courriel doit avoir au moins {{$v.email.$params.minLength.min}} caractères.</div>
                            </div>
                            <div class="form-group mt-3" :class="{ 'form-group--error': $v.password.$error }">
                                <label for="password">Mot de passe</label>
                                <input type="password" class="form-control" id="password" v-model="$v.password.$model" placeholder="Votre mot de passe">
                                <div class="text-danger font-weight-bold" v-if="!$v.password.required && $v.password.dirty">Le mot de passe est obligatoire</div>
                                <div class="text-danger font-weight-bold" v-if="!$v.password.passwordValid">Le mot de passe doit avoir au moins {{$v.password.$params.minLength.min}} caractères.</div>
                            </div>
                            <div class="mt-3">
                                <button type="submit" class="form-control btn btn-dark mt-3">S'inscrire</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import { required, minLength, email, helpers } from 'vuelidate/lib/validators'
import { Patterns } from '@/constants/patterns.js'
    const passwordValid = helpers.regex("passwordValid", Patterns.passwordPattern())
    const usernameValid = helpers.regex("usernameValid", Patterns.usernamePattern())

    export default {
        name: "SignUp",
        data(){
            return{
                username: "",
                password: "",
                email: "",
                submitStatus: null,
            }
        },
        created(){
            this.PAIMON = 'nice-paimon.png'
        },
        validations:{
            username:{
                required,
                minLength: minLength(8),
                usernameValid
            },
            password:{
                required,
                minLength: minLength(8),
                passwordValid
            },
            email:{
                required,
                email,
                minLength: minLength(6),
            }
        },
        methods:{
            clearForm(){
                this.username = ''
                this.password = ''
                this.email = ''
                this.$v.$reset()

            },
            registerSuccess(){
                this.clearForm()
                alert("Inscription avec succès!")
            },
            registerUser(){
                this.$v.$touch()
                if (this.$v.$invalid){
                    alert("Veuillez remplir tous les champs correctement")
                }else{
                    const user = { username : this.username, password : this.password, email : this.email}
                    axios.post('http://localhost:9696/user/register', user)
                        .then(res => res.data.username == this.username ? this.registerSuccess() : alert("Insciption échouée"))
                        .catch(err => console.log(err))
                }
            }
        },
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