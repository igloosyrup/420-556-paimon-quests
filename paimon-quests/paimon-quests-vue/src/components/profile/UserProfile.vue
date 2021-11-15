<template>
    <div class="mt-5 py-5 text-light">
        <h1>Profil de {{this.$store.getters.currentUser.userName}}</h1>
        <div class="container-fluid d-flex justify-content-between mt-5">
            <div class="col-sm-12 col-md-6">
                <h2 class="mt-2">
                    Mes informations personnelles
                </h2>
                <div class="mt-4">
                    <router-link to="/edit-user">
                        <a class="btn btn-success p-2 mx-2 mt-5">
                            Modifier mon profil
                        </a>
                    </router-link>
                </div>
            </div>
            <div class="col-sm-12 col-md-6">
                <h2 class="mt-2">
                    Mes statistiques
                </h2>
                <div class="mt-4">
                    <router-link to="/new-quest">
                        <a class="btn btn-success p-2 mx-2 mt-5">
                            Ajouter une nouvelle quête
                        </a>
                    </router-link>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
    export default {
        name: "UserProfile",
    }
</script>

<style scoped>

</style>