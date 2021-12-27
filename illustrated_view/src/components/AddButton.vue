<template>
  <v-row justify="center">
    <v-dialog
        v-model="dialog"
        max-width="600px"
        persistent
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
            block
            dark
            icon
            rounded
            v-bind="attrs"
            x-large
            v-on="on">
          <v-icon> mdi-expand-all</v-icon>
          <tr>添加图鉴</tr>
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
                 @click="verifyProp()"
          >
            Sure
          </v-btn>
        </v-card-actions>
        <v-alert
            v-model="propExist"
            dismissible
            elevation="3"
        >道具已存在,请勿重新添加
        </v-alert>
        <v-alert
            v-model="idNotNull"
            dismissible
            elevation="3"
        >道具序号不能为空
        </v-alert>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
export default {
  name: "AddButton",
  data: () => ({
    dialog: false,
    idNotNull: false,
    propExist: false,
    idInput: "",
    nameInput: "",
    descriptionInput: "",
    placeInput: "",
    effectInput: "",
  }),
  methods: {
    addProp() {
      this.dialog = false
      let url = "http://127.0.0.1:8080/addProp/" + this.idInput;
      fetch(url, {
        method: 'post',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
          name: this.nameInput,
          description: this.descriptionInput,
          place: this.placeInput,
          effect: this.effectInput
        })
      }).then().catch(e => console.log(e));
      window.location.reload();
    },
    verifyProp() {
      if (this.idInput === "") {
        this.idNotNull = true;
      } else {
        let url = "http://127.0.0.1:8080/searchProp/" + this.idInput;
        fetch(url, {
          method: 'post',
          headers: {'Content-Type': 'application/json'},
        })
            .then(r => r.text())
            .then(data => {
              if (data === 'true') {
                this.propExist = true;
              } else if (data === "PropMissed") {
                this.addProp();
              }
            })

      }
    }
  }
}
</script>
