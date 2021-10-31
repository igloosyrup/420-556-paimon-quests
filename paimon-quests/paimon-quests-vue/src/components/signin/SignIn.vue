<template>
    <div class="container mt-5 pb-5 px-5">
        <div class="py-5 mt-5 mx-5">
            <div class="d-flex justify-content-center">
                <div class="form-row mt-5">
                    <h1 class="text-dark mt-5 mx-4 py-5 display-4">
                        Login
                    </h1>
                </div>
            </div>
            <form class="mb-5">
                <div class="form-group mb-4">
                    <div class="d-flex justify-content-center">
                        <div class="form-group col-md-6">
                        <label for="inputEmail4">Username</label>
                        <input type="text" class="form-control" id="inputEmail4" placeholder="Email">
                        <label for="inputPassword4">Password</label>
                        <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary mt-5">Sign in</button>
            </form>
        </div>
    </div>
</template>

<script>
    export default {
        name: "SignIn",
        created(){
            this.PAIMON = 'nice-paimon.png'
        }
    }
</script>

<style scoped>
    input{
            background-color: rgba(255,255,255, 0.0);
            border: 0px;
    }

</style>