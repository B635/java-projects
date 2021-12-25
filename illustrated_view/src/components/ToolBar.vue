<template>
  <v-container>
    <v-app-bar
        app
        clipped-left
        dark
    >
      <v-app-bar-nav-icon
          @click.stop="drawer = !drawer"
      ></v-app-bar-nav-icon>

      <v-toolbar-title>Lost ruins</v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-zodiac-leo</v-icon>
      </v-btn>
    </v-app-bar>

    <v-navigation-drawer
        v-model="drawer"
        app
        clipped
        color="#ECEFF1"
    >
      <v-list dense>
        <v-list-item
            v-for="item in items"
            :key="item.title"
            :to="item.link"
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

  </v-container>
</template>

<script>
export default {
  name: "ToolBar",
  data() {
    return {
      drawer: false,
      items: [
        {title: '图鉴', icon: 'mdi-view-dashboard', link: '/home'},
        {title: '开发者模式', icon: 'mdi-account-cog', link: '/admin'},
      ]
    }
  }
}
</script>
