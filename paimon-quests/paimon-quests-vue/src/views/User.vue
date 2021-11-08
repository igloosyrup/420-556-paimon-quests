<template>
    <div class="container-fluid py-5 paimon-bg">
        <UserProfile />
    </div>
</template>

<script>
import UserProfile from '@/components/profile/UserProfile'
    export default {
        name: "User",
        components:{
            UserProfile,
        }

    }
</script>

<style scoped>

</style>