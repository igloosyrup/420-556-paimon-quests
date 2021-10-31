<template>
    <div class="container mt-5 pb-5 px-5">
        <div class="py-5 mt-5 mx-5">
            <div class="d-flex justify-content-center">
                <div class="form-row mt-5">
                    <img :src="require(`@/assets/paimon/${PAIMON}`)" draggable="false" class="rounded-pill ml-3 paimon " alt="">
                    <h1 class="text-dark mt-5 mx-4 py-5 display-4">
                        Inscrivez-vous
                    </h1>
                    <img :src="require(`@/assets/paimon/${PAIMON}`)" draggable="false" class="rounded-pill mx-3 flip-img paimon" alt="">
                </div>
            </div>
            <form class="my-5">
                <div class="form-row mt-4">
                    <div class="form-group col-md-6">
                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                    </div>
                    <div class="form-group col-md-6">
                    <label for="inputPassword4">Password</label>
                    <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                    </div>
                </div>
                <div class="form-group mt-4">
                    <label for="inputAddress">Address</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                </div>
                <div class="form-group mt-4">
                    <label for="inputAddress2">Address 2</label>
                    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
                </div>
                <button type="submit" class="btn btn-primary">Sign in</button>
            </form>
        </div>
    </div>
</template>

<script>
    export default {
        name: "SignUp",
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
    .paimon{
        width: 197.5px;
    }
</style>