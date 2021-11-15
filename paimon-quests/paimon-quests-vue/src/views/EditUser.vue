<template>
    <div class="container-fluid py-5 paimon-bg">
        <div class="container py-5 my-5">
            <div class="form-bg py-5">
                <EditUserProfile />
            </div>
        </div>
    </div>
</template>

<script>
import EditUserProfile from '@/components/edit-profile/EditUserProfile'
    export default {
        name: "EditUser",
        components: {
            EditUserProfile,
        }
    }
</script>

<style scoped>

</style>