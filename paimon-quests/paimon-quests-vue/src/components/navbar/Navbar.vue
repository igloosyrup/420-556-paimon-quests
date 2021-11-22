<template>
    <nav class="navbar navbar-light align-middle" id="navbar">
        <div class="row justify-content-start">
            <div>
                <router-link to="/">
                    <a class="navbar-brand">
                        <img class="align-middle flip-img ml-1" draggable="false" :src="require(`@/assets/paimon/${LOGO_SOURCE}`)" width="85" height="85" alt="">
                    </a>
                </router-link>
            </div>
            <div class="mt-4">
                <router-link to="/">
                    <a class="text-light">
                        <h1 class="align-middle mt-2 custom-font">{{TITLE}}</h1>
                    </a>
                </router-link>
            </div>
        </div>
        <div class="row justify-content-end" v-if="this.getCurrentUser == undefined">
            <div class="mt-4">
                <router-link to="/login">
                    <a class="text-light lead mx-2 mt-5">
                        Se connecter
                    </a>
                </router-link>
            </div>
            <div class="mt-4">
                <router-link to="/register">
                    <a class="text-light lead mx-2">
                        S'enregistrer
                    </a>
                </router-link>
            </div>
        </div>
        <div class="row justify-content-end" v-if="this.getCurrentUser != undefined && this.getCurrentUser != ''">
            <div class="mt-4 mx-2">
                <router-link to="/user">
                    <a href="#" class="text-light lead">Mon profil</a>
                </router-link>
            </div>
            <a class="text-light mt-4 mx-2 lead" @click="logout()">
                Se déconnecter
            </a>
        </div>
    </nav>
</template>

<script>
    export default {
        name: "Navbar",
        methods:{
            logout(){
                this.$swal.fire({
                    title: "Déconnexion",
                    text: "Voulez-vous vraiment vous déconnecter?",
                    icon: 'warning',
                    showCancelButton: true,
                    focusConfirm: false,
                    confirmButtonText:'Oui',
                    cancelButtonText:'Non'
                }).then((result) => {
                    if(result.isConfirmed)
                        this.$store.dispatch("logout")
                        this.swal("Bravo", "déconnexion avec succès!", "success")
                        if(this.$route.path === "/")
                            return
                        this.$router.push({ name: "Home"})
                })
            }, 
            swal(alertTitle, alertText, alertIcon){
                this.$swal.fire({
                    title: alertTitle,
                    text: alertText,
                    icon: alertIcon
                })
            },

        },
        data(){
            return{
                user: "",
            }
        },
        created() {
            this.LOGO_SOURCE = 'hi-paimon.png'
            this.UN_TEST = "hello"
            this.TITLE = "Paimon Quest"
            this.user = this.getCurrentUser
            
        },
        computed:{
            getCurrentUser(){
                return this.$store.getters.currentUser
            }
        }
    }
</script>

<style scoped>
    #navbar{
        background-color: rgba(27, 27, 27, 0.5);
        position:fixed;
        width:100%;
    }
    img{
        -webkit-user-select: none;
        user-select: none;
    }
</style>