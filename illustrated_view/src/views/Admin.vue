<template>
  <v-app>
    <v-img
        gradient="rgba(0,0,0,.33), rgba(192,192,195,.33)"
        src="@/assets/adminPage.jpeg" style="height: 100%">
      <ToolBar></ToolBar>
      <AddButton/>
      <AdminProps></AdminProps>
    </v-img>
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