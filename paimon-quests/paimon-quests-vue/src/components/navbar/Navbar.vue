<template>
    <!--  
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        
    Image and text -->
    <nav class="navbar navbar-light sticky-top bg-dark align-middle justify-content-start">
        <router-link to="/">
            <a class="navbar-brand">
                <img class="align-middle flip-img ml-1" draggable="false" :src="require(`@/assets/paimon/${LOGO_SOURCE}`)" width="85" height="85" alt="">
            </a>
        </router-link>
        <router-link to="/">
            <a class="navbar-brand mt-4">
                <h1 class="ml-2 align-middle text-light">{{TITLE}}</h1>
            </a>
        </router-link>
        
        <router-link to="/paimon">Paimon</router-link>
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
    .flip-img{
        -webkit-transform: scaleX(-1);
        transform: scaleX(-1);
    }

    img{
        -webkit-user-select: none;
        user-select: none;
    }
</style>