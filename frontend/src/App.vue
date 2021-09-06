<template>
  <div id="app">
    <SkiPicker/>
  </div>
</template>

<script>
import SkiPicker from './components/SkiPicker'

export default {
  name: 'App',
  components: {
    SkiPicker
  }
}
</script>

<style>
body {
   background-size: cover;
   background-image: url("./assets/background.jpg");
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  color: #656565;
}
</style>
