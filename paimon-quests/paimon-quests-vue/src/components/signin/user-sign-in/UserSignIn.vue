<template>
    <div>

    </div>
</template>

<script>
    export default {
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

</style>