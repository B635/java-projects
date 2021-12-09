<template>
  <v-app>
    <ToolBar></ToolBar>
    <PropsList></PropsList>
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
