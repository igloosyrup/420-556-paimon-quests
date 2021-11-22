<template>
    <div class="container-fluid py-5 paimon-bg custom-height">
        <div class="container py-5 my-5">
            <div class="my-5">
                <div class="form-bg py-5">
                    <SignIn />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import SignIn from '@/components/signin/SignIn'

    export default {
        name: "Login",
        components:{
            SignIn,
        }
    }
</script>

<style lang="scss" scoped>

</style>