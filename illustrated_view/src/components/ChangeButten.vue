<template>
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
          left
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
                md="6"
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
                md="6"
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
                md="6"
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
                md="6"
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
                md="12"
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
               @click="editProp()"
        >
          Sure
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>

</template>

<script>
export default {
  name: "ChangeButten",
  data: () => ({
    dialog: false,
    idInput: "",
    nameInput: "",
    descriptionInput: "",
    placeInput: "",
    effectInput: "",
  }),
  methods: {
    editProp() {
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
}
</script>

<style scoped>

</style>