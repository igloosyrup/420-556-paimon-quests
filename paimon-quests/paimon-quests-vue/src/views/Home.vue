<template>
  <div class="container-fluid py-5 paimon-bg">
    <div class="text-light">
      <h1 class="mt-5">Bienvenue à Paimon Quests</h1>
      <Welcome />
    </div>
  </div>
</template>

<script>
import Welcome from '@/components/home/Welcome'

export default {
  name: 'Home',
  components: {
    Welcome,
  }
}
</script>
