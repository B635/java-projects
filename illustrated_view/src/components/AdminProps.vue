<template>
  <v-content style="margin: 15px">
    <v-row>
      <v-col v-for="m in msg" :key="m.id" cols="6">
        <v-card elevation="10" height="210">
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
          <ChangeButton :id-default=m.id></ChangeButton>
          <v-btn absolute color="red" icon right @click="deleteProp(m.id)">
            <v-icon large>mdi-close-circle</v-icon>
          </v-btn>
        </v-card>
      </v-col>
    </v-row>
  </v-content>
</template>

<script>
import ChangeButton from './ChangeButton'

export default {
  name: "AdminProps",
  components: {
    ChangeButton,
  },
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
    },
    deleteProp(id) {
      let url = "http://127.0.0.1:8080/deleteProp/" + id;
      const requestOptions = {
        method: "POST",
        credentials: 'include',
      }
      fetch(url, requestOptions)
          .then()
          .catch(err => console.log(err))
      window.location.reload();
    },
  },
  mounted() {
    this.query()
  }
}
</script>
