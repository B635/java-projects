<template>
  <v-content style="margin: 15px">
    <v-row>
      <v-col v-for="m in msg" :key="m.id" cols="6">
        <v-card elevation="10" height="200">
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
          <v-dialog
              v-model="dialog"
              max-width="600px"
              persistent
          >
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                  absolute
                  color="primary"
                  icon
                  light
                  v-bind="attrs"
                  v-on="on">
                <v-icon large>mdi-archive-edit</v-icon>
              </v-btn>
            </template>
            <v-card>
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col
                        cols="12"
                        md="4"
                        sm="6"
                    >
                      <v-text-field
                          v-model="idInput"
                          label="id"
                          required>
                      </v-text-field>
                    </v-col>
                    <v-col
                        cols="12"
                        md="4"
                        sm="6"
                    >
                      <v-text-field
                          v-model="nameInput"
                          label="name"
                          required>
                      </v-text-field>
                    </v-col>
                    <v-col
                        cols="12"
                        md="4"
                        sm="6"
                    >
                      <v-text-field
                          v-model="placeInput"
                          label="place"
                          required>
                      </v-text-field>
                    </v-col>
                    <v-col
                        cols="12"
                        md="4"
                        sm="6"
                    >
                      <v-text-field
                          v-model="effectInput"
                          label="effect"
                          required>
                      </v-text-field>
                    </v-col>
                    <v-col
                        cols="12"
                        md="4"
                        sm="12"
                    >
                      <v-text-field
                          v-model="descriptionInput"
                          label="description"
                          required>
                      </v-text-field>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1"
                       text
                       @click="dialog = false">
                  Close
                </v-btn>
                <v-btn color="blue darken-1"
                       text
                       @click="editProp()">
                  Sure
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
          <v-btn absolute color="red" icon right @click="deleteProp(m.id)">
            <v-icon large>mdi-close-circle</v-icon>
          </v-btn>
        </v-card>
      </v-col>
    </v-row>
  </v-content>
</template>

<script>

export default {
  name: "AdminProps",
  data: () => ({
    dialog: false,
    idInput: "",
    nameInput: "",
    descriptionInput: "",
    placeInput: "",
    effectInput: "",
  }),
  props: {
    msg: [],
  },
  methods: {
    query() {
      fetch("http://127.0.0.1:8080/userprops", {credentials: 'include'})
          .then(r => r.json()
          )
          .then(data => this.msg = data)
          .catch(err => console.log(err))
    },
    deleteProp(id) {
      let url = "http://127.0.0.1:8080/deleteprop/" + id;
      const requestOptions = {
        method: "POST",
        credentials: 'include',
      }
      fetch(url, requestOptions)
          .then()
          .catch(err => console.log(err))
      this.query()
    },
    editProp() {
      console.log(this.idInput)
      this.dialog = false
      let url = "http://127.0.0.1:8080/changeprop/" + this.idInput;
      fetch(url, {
        method: 'post',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
          name: this.nameInput,
          description: this.descriptionInput,
          place: this.placeInput,
          effect: this.effectInput
        })
      }).then().catch(e => console.log(e))
    },
  },
  mounted() {
    this.query()
  }
}
</script>
