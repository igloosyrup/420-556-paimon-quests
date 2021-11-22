<template>
  <div id="app" class="">
    <Navbar />
    <router-view />
    <Footer />
  </div>
</template>

<script>
import Navbar from '@/components/navbar/Navbar'
import Footer from '@/components/footer/Footer'

  export default {
    components:{
      Navbar,
      Footer
  }
}

</script>

<style>
@font-face{
      font-family: "Chistoso";
      src: local("Chistoso"),
      url(./assets/fonts/Chistoso-Regular.ttf) format("truetype");
  }
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

</style>
