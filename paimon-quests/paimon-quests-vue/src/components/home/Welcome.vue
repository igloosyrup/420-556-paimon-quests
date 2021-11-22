<template>
    <div class="container mb-3">
        <div class="mt-5">
            <img :src="require(`@/assets/paimon/${PAIMON}`)" draggable="false" class="paimon mt-5">


            <!-- <b-button v-b-modal.modal-1>Launch demo modal</b-button>

            <b-modal id="modal-1" title="BootstrapVue">
                <p class="my-4">Hello from modal!</p>
            </b-modal> -->
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Welcome',
        created(){
            this.PAIMON = 'qiqi.png'
        },
    }
</script>

<style scoped>
    .paimon{
        width: 500px
    }
</style>