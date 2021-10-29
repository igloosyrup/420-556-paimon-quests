<template>
  <div class="hello">
    <div class="container mb-3">
      <p>{{ message }}</p>
      <button class="btn btn-danger" v-on:click="reverseMessage">Reverse Message</button>
    </div>
  </div>
</template>

<script>


export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data: function() {
    return{
      message: 'Hello Vue.js!'
    }
  },
  methods:{
    reverseMessage: function(){
      this.message = this.message.split('').reverse().join('')
    }
  },
  components:{
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
