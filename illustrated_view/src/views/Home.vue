<template>
  <v-app>
    <v-img
        gradient="rgba(0,0,0,.33), rgba(192,192,195,.33)"
        src="@/assets/homePage.jpeg" style="height: 100%">
      <ToolBar></ToolBar>
      <PropsList></PropsList>
    </v-img>
  </v-app>
</template>

<script>
import ToolBar from '../components/ToolBar'
import PropsList from '../components/PropsList'

export default {
  name: 'Home',

  components: {
    ToolBar,
    PropsList
  },
}
</script>
