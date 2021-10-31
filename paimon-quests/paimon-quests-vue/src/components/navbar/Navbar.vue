<template>
    <!--  
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        
    Image and text -->
    <nav class="navbar navbar-light sticky-top bg-dark align-middle">
        <div class="row justify-content-start">
            <div class="">
                <router-link to="/">
                    <a class="navbar-brand">
                        <img class="align-middle flip-img ml-1" draggable="false" :src="require(`@/assets/paimon/${LOGO_SOURCE}`)" width="85" height="85" alt="">
                    </a>
                </router-link>
            </div>
            <div class="mt-4">
                <router-link to="/">
                    <a class="navbar-brand">
                        <h1 class="align-middle text-light">{{TITLE}}</h1>
                    </a>
                </router-link>
            </div>
        </div>
        <!-- <router-link to="/paimon">
            Paimon
        </router-link> -->
        <div class="row justify-content-end">
            <div class="mt-4">
                <router-link to="/login">
                    <a class="text-light mx-2 mt-5">
                        Se connecter
                    </a>
                </router-link>
            </div>
            <div class="mt-4">
                <router-link to="/register">
                    <a class="text-light mx-2">
                        S'enregistrer
                    </a>
                </router-link>
            </div>
        </div>
    </nav>
</template>

<script>
    export default {
        name: "Navbar",
        created() {
            this.LOGO_SOURCE = 'hi-paimon.png';
            this.UN_TEST = "he;lo";
            this.TITLE = "Paimon Quest"
        },
    }
</script>

<style scoped>
    img{
        -webkit-user-select: none;
        user-select: none;
    }
</style>