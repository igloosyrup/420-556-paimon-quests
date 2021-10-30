<template>
    <div class="container mb-3">
        <h1 class="text-dark">Welcome to Paimon Quests</h1>
        <div>
            <b-button v-b-modal.modal-1>Launch demo modal</b-button>

            <b-modal id="modal-1" title="BootstrapVue">
                <p class="my-4">Hello from modal!</p>
            </b-modal>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'PaimonHome',
    }
</script>

<style scoped>

</style>