<template>
  <div class="container-fluid py-5 paimon-bg custom-height">
    <div class="text-light">
      <h1 class="display-1 custom-font" style="margin-top: 2em;">Bienvenue à Paimon Quests</h1>
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
