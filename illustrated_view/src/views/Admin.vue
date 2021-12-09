<template>
  <v-app>
    <ToolBar></ToolBar>
    <AdminProps></AdminProps>
  </v-app>
</template>

<script>
import ToolBar from '../components/ToolBar'
import AdminProps from '../components/AdminProps'

export default {
  name: "Admin",
  components: {
    ToolBar,
    AdminProps
  },
}
</script>

<style scoped>

</style>