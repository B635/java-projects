<template>
  <v-app>
    <ToolBar></ToolBar>
    <AddButton/>
    <AdminProps></AdminProps>
  </v-app>
</template>

<script>
import ToolBar from '../components/ToolBar'
import AdminProps from '../components/AdminProps'
import AddButton from '../components/AddButton'

export default {
  name: "Admin",
  components: {
    ToolBar,
    AdminProps,
    AddButton
  },
}
</script>

<style scoped>

</style>