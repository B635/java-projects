<template>
  <v-content
      style="margin: 15px"
  >
    <v-row>
      <v-col
          v-for="m in msg"
          :key="m.id"
          cols="6"
      >
        <v-card
            elevation="10"
            height="200"
        >
          <v-card-title>
            {{ m.id }} {{ m.name }}
          </v-card-title>
          <v-card-text>
            <h2>
              概述：{{ m.description }}
            </h2>
            <h2>
              效果：{{ m.effect }}
            </h2>
            <h2>
              地点：{{ m.place }}
            </h2>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-content>
</template>

<script>

export default {
  name: "PropsList",
  props: {
    msg: [],
  },
  methods: {
    query() {
      fetch("http://127.0.0.1:8080/userProps", {credentials: 'include'})
          .then(r => r.json()
          )
          .then(data => this.msg = data)
          .catch(err => console.log(err))
    }
  },
  mounted() {
    this.query()
  }
}
</script>
