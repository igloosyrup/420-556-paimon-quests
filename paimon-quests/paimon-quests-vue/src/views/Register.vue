<template>
    <div class="container-fluid py-5 paimon-bg">
        <div class="container py-5 my-5">
            <div class="my-5">
                <div class="form-bg py-5">
                    <SignUp />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import SignUp from '@/components/signup/SignUp'

    export default {
        name: "Register",
        components:{
            SignUp,
        }
    }
</script>

<style scoped>

</style>