<template>
    <footer class="py-4 charcoal-bg">
        <div class="text-center mb-4">
            <h1 class="text-white display-4">Mes contacts</h1>
        </div>
        <div class="text-center">
            <a :href="`${GITHUB}`" target="_blank" class="mx-4"><i class="fab fa-github text-light fa-3x"></i></a>
        </div>
        <div class="text-center mt-1">
            <a :href="`${GITHUB}`" target="_blank" class="mx-4 text-light">Github</a>
        </div>
        <p class="text-white mt-4 mb-0">&copy; Copyright 2021 - Par Zi Yu Chen </p>
    </footer>
</template>

<script>
    export default {
        name: "Footer",
        created(){
            this.GITHUB = "https://github.com/igloosyrup";
        }
    }
</script>

<style scoped>

</style>