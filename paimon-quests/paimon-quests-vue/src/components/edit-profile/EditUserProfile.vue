<template>
    <div class="container mb-5 mt-5 pb-5 px-5">
        <div class="py-5 mt-5 mx-5">
            <div class="d-flex justify-content-center">
                <div class="form mt-5">
                    <img :src="require(`@/assets/paimon/${PAIMON}`)" draggable="false" class="rounded-pill paimon mt-5">
                    <h1 class="text-dark mx-4 py-5 display-4">
                        Modifier mon profil
                    </h1>
                </div>
            </div>
            <div class="d-flex justify-content-center">
                <form class="mb-3" @submit.prevent="updateUser">
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
                                <button type="submit" class="form-control btn btn-dark mt-3">Mettre à jours mon profil</button>
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
    export default {
        name: "EditUserProfile",
        created(){
            this.PAIMON = 'oh.png'
        },
        methods:{
            updateUser(){
                console.log("Update User")
            }
        }
    }
</script>

<style scoped>
    .paimon{
        width: 150px;
    }
</style>